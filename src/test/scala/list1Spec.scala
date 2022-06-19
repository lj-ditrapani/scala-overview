package info.ditrapani.overview01

import info.ditrapani.overview.Spec
import Lst.{Cell, Empty}

class List01Spec extends Spec:
  "Lst" - {
    "can be empty" in {
      val e: Lst = Empty
      e shouldBe Empty
    }

    "can hold elements" in {
      val list: Lst = Cell(1, Cell(2, new Cell(3, Empty)))
      val c1: Cell = list.asInstanceOf[Cell]
      c1.head should ===(1)
      val c2: Cell = c1.tail.asInstanceOf[Cell]
      c2.head should ===(2)
      val c3: Cell = c2.tail.asInstanceOf[Cell]
      c3.head should ===(3)
      c3.tail shouldBe Empty
    }
  }
