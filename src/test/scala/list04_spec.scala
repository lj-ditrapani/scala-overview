package info.ditrapani.overview04

import info.ditrapani.overview.Spec

class List04Spec extends Spec:
  "Lst" - {
    val list: Lst = new Cell(1, new Cell(2, new Cell(3, new Empty)))

    "can be empty" in {
      val e: Lst = new Empty
      e shouldBe an[Empty]
    }

    "can hold elements" in {
      list.isEmpty should ===(false)
      list.head should ===(1)
      list.tail.head should ===(2)
      list.tail.tail.head should ===(3)
      list.tail.tail.tail.isEmpty should ===(true)
    }

    "map" - {
      "returns empty list on empty list" in {
        (new Empty).map(_ + 5).isEmpty should ===(true)
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
        val i = new Cell(4, list).reduce(1)(_ * _)
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
        (new Empty).toString should ===("Lst( )")
      }
    }
  }
