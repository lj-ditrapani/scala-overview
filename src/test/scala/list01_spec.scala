package info.ditrapani.overview01

import info.ditrapani.overview.Spec

class List01Spec extends Spec {
  describe("Lst") {
    it("can be empty") {
      val e: Lst = new Empty
    }

    it("can hold elements") {
      val list: Lst = new Cell(1, new Cell(2, new Cell(3, new Empty)))
      val c1: Cell = list.asInstanceOf[Cell]
      c1.head should ===(1)
      val c2: Cell = c1.tail.asInstanceOf[Cell]
      c2.head should ===(2)
      val c3: Cell = c2.tail.asInstanceOf[Cell]
      c3.head should ===(3)
      c3.tail shouldBe an[Empty]
    }
  }
}
