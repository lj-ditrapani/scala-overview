package info.ditrapani.overview10

object Main {
  def main(args: Array[String]): Unit = {
    val list = Lst("Hello world from scala!".toIndexedSeq: _*)
    println(list.toString)
    println(s"List size: ${list.size}")
    val list2 = list.map((x) => Integer.toHexString(x.toInt))
    println(s"List as ASCII values: ${list2}")
    println(s"Reversed list: ${list.reverse}")
  }
}
