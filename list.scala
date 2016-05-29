package info.ditrapani.overview

import scala.annotation.tailrec

// Called List in standard library
sealed abstract class Lst {
  def head: Int

  def tail: Lst

  def isEmpty: Boolean

  def map(f: Int => Int): Lst

  // def reduce(f: (Int, Int) => Int): Int

  def size: Int = sizeIter(0)

  @tailrec private def sizeIter(n: Int): Int = {
    if (isEmpty) {
      n
    } else {
      tail.sizeIter(n + 1)
    }
  }

  override def toString(): String = toStringIter("Lst( ")

  def toStringIter(prefix: String): String
}

final class Cell(val head: Int, val tail: Lst) extends Lst {
  override def isEmpty = false

  // Not tailrec!
  override def map(f: Int => Int) = {
    new Cell(f(head), tail.map(f))
  }

  // Not tailrec!
  override def toStringIter(prefix: String) =
    tail.toStringIter(s"${prefix}${head} ")
}

final class Empty extends Lst {
  override def head = throw new RuntimeException("Empty.head not allowed")

  override def tail = throw new RuntimeException("Empty.tail not allowed")

  override def isEmpty = true

  override def map(f: Int => Int) = {
    this
  }

  override def toStringIter(prefix: String): String = s"${prefix})"
}
