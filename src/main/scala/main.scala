package info.ditrapani.overview8

@main def main: Unit =
  val list = Lst("Hello world from scala!".toIndexedSeq: _*)
  println(list.toString)
  println(s"List size: ${list.size}")
  val list2 = list.map((x) => Integer.toHexString(x.toInt))
  println(s"List as ASCII values: ${list2}")
  println(s"Reversed list: ${list.reverse}")
