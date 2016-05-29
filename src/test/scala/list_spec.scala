package info.ditrapani.overview

class ListSpec extends Spec {
  describe("Lst") {
    val list: Lst = new Cell(1, new Cell(2, new Cell(3, new Empty)))

    it("can be empty") {
      val e: Lst = new Empty
    }

    it("can hold elements") {
      list.isEmpty should === (false)
      list.head should === (1)
      list.tail.head should === (2)
      list.tail.tail.head should === (3)
      list.tail.tail.tail.isEmpty should === (true)
    }

    describe("map") {
      it("returns empty list on empty list") {
        (new Empty).map(_ + 5).isEmpty should === (true)
      }

      it("applies function to each element in list") {
        val list2 = list.map(_ * 2)
        list2.head should === (2)
      }
    }

    describe("size") {
      it("returns size of list") {
        list.size should === (3)
      }
    }

    describe("toString") {
      it("returns a string representation of the list") {
        list.toString should === ("Lst( 1 2 3 )")
      }
    }
  }
}
