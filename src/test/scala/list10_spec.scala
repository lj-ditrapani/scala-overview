package info.ditrapani.overview10

import info.ditrapani.overview.Spec

class List10Spec extends Spec {
  describe("Lst") {
    val list: Lst[Int] = Lst(1, 2, 3)

    it("can be empty") {
      val e: Lst[Int] = Empty
    }

    it("can hold elements") {
      list.isEmpty should ===(false)
      list.size should ===(3)
      list.toString should ===("Lst( 1 2 3 )")
    }

    describe("map") {
      it("returns empty list on empty list") {
        (Empty: Lst[Int]).map(_ + 5).isEmpty should ===(true)
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
        val i = Cell(4, list).reduce(1)(_ * _)
        i should ===(24)
      }

      it("reduces the list to a string") {
        def joiner(acc: String, i: Int): String = s"${acc} ${i}"
        val s = Cell(4, list).reduce("Lst:")(joiner)
        s should ===("Lst: 4 1 2 3")
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
        (Empty).toString should ===("Lst( )")
      }
    }
  }

  describe("Lst of chars") {
    val list: Lst[Char] = Lst('s', 'c', 'a', 'l', 'a')

    it("still works") {
      list.size should ===(5)
      list.toString should ===("Lst( s c a l a )")
      list.reverse.toString should ===("Lst( a l a c s )")
      list.map(_.toInt - 96).toString should ===("Lst( 19 3 1 12 1 )")
    }
  }

  describe("Lst.apply") {
    it("creates a list") {
      Lst(1, 2, 3).toString should ===("Lst( 1 2 3 )")
    }
  }
}
