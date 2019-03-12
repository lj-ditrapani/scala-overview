package info.ditrapani.overview04

import info.ditrapani.overview.Spec

class List04Spec extends Spec {
  describe("Lst") {
    val list: Lst = new Cell(1, new Cell(2, new Cell(3, new Empty)))

    it("can be empty") {
      val e: Lst = new Empty
    }

    it("can hold elements") {
      list.isEmpty should ===(false)
      list.head should ===(1)
      list.tail.head should ===(2)
      list.tail.tail.head should ===(3)
      list.tail.tail.tail.isEmpty should ===(true)
    }

    describe("map") {
      it("returns empty list on empty list") {
        (new Empty).map(_ + 5).isEmpty should ===(true)
      }

      it("applies function to each element in list") {
        val list2 = list.map(_ * 2)
        list2.size should ===(3)
        list2.toString should ===("Lst( 2 4 6 )")
      }
    }

    describe("reduce") {
      it("reduces the list with +") {
        val i = list.reduce(0)(_ + _)
        i should ===(6)
      }

      it("reduces the list with *") {
        val i = new Cell(4, list).reduce(1)(_ * _)
        i should ===(24)
      }
    }

    describe("size") {
      it("returns size of list") {
        list.size should ===(3)
      }
    }

    describe("toString") {
      it("returns a string representation of the list") {
        list.toString should ===("Lst( 1 2 3 )")
      }

      it("returns a string representation of the empty list") {
        (new Empty).toString should ===("Lst( )")
      }
    }
  }
}
