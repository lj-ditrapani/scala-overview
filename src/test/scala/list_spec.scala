package info.ditrapani.overview

class ListSpec extends Spec {
  describe("Lst") {
    val list: Lst = Cell(1, Cell(2, Cell(3, Empty())))

    it("can be empty") {
      val e: Lst = Empty()
    }

    it("can hold elements") {
      list.isEmpty should === (false)
      list.size should === (3)
      list.toString === ("List( 1 2 3 )")
    }

    describe("map") {
      it("returns empty list on empty list") {
        (Empty()).map(_ + 5).isEmpty should === (true)
      }

      it("applies function to each element in list") {
        val list2 = list.map(_ * 2)
        list2.size should === (3)
        list2.toString should === ("Lst( 2 4 6 )")
      }
    }

    describe("reduce") {
      it("reduces the list with +") {
        val i = list.reduce(0)(_ + _)
        i should === (6)
      }

      it("reduces the list with *") {
        val i = Cell(4, list).reduce(1)(_ * _)
        i should === (24)
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

      it("returns a string representation of the empty list") {
        (Empty()).toString should === ("Lst( )")
      }
    }
  }
}
