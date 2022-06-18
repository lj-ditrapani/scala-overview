package info.ditrapani.overview02

import info.ditrapani.overview.Spec

class List02Spec extends Spec:
  "Lst" - {
    "can be empty" in {
      val e: Lst = new Empty
      e shouldBe an[Empty]
    }

    "can hold elements" in {
      val list: Lst = new Cell(1, new Cell(2, new Cell(3, new Empty)))
      list.isEmpty should ===(false)
      list.head should ===(1)
      list.tail.head should ===(2)
      list.tail.tail.head should ===(3)
      list.tail.tail.tail.isEmpty should ===(true)
    }
  }
