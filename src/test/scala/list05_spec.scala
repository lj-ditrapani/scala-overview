package info.ditrapani.overview05

import info.ditrapani.overview.Spec
import Lst.{Cell, Empty}

class List05Spec extends Spec:
  "Lst" - {
    val list: Lst = Cell(1, Cell(2, Cell(3, Empty)))

    "can be empty" in {
      val e: Lst = Empty
      e shouldBe Empty
    }

    "can hold elements" in {
      list.isEmpty should ===(false)
      list.size should ===(3)
      list.toString should ===("Lst( 1 2 3 )")
    }

    "map" - {
      "returns empty list on empty list" in {
        Empty.map(_ + 5).isEmpty should ===(true)
      }

      "applies function to each element in list" in {
        val list2 = list.map(_ * 2)
        list2.size should ===(3)
        list2.toString should ===("Lst( 2 4 6 )")
      }
    }

    "reduce" - {
      "reduces the list with +" in {
        val i = list.reduce(0)(_ + _)
        i should ===(6)
      }

      "reduces the list with *" in {
        val i = Cell(4, list).reduce(1)(_ * _)
        i should ===(24)
      }
    }

    "size" - {
      "returns size of list" in {
        list.size should ===(3)
      }
    }

    "toString" - {
      "returns a string representation of the list" in {
        list.toString should ===("Lst( 1 2 3 )")
      }

      "returns a string representation of the empty list" in {
        Empty.toString should ===("Lst( )")
      }
    }
  }
