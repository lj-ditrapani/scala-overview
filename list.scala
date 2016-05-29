package info.ditrapani.overview

// Called List in standard library
sealed abstract class Lst {
  def head: Int
  def tail: Lst
  def isEmpty: Boolean
}

// Called :: (Cons) in standard library
final class Cell(val head: Int, val tail: Lst) extends Lst {
  override def isEmpty = false
}

// Called Nil in standard library
final class Empty extends Lst {
  override def head = throw new RuntimeException("Empty.head not allowed")
  override def tail = throw new RuntimeException("Empty.tail not allowed")
  override def isEmpty = true
}
