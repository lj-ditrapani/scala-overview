package info.ditrapani.overview02

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
  override def head: Int = throw new RuntimeException("Empty.head not allowed")

  override def tail: Lst = throw new RuntimeException("Empty.tail not allowed")

  override def isEmpty: Boolean = true
}
