package info.ditrapani.overview

import scala.annotation.tailrec

// Called List in standard library
sealed abstract class Lst {
  def head: Int

  def tail: Lst

  def isEmpty: Boolean

  def map(f: Int => Int): Lst

  def size: Int = sizeIter(0)

  def sizeIter(n: Int): Int

  override def toString(): String = toStringIter("Lst( ")

  def toStringIter(prefix: String): String
}

// Called :: (Cons) in standard library
final class Cell(val head: Int, val tail: Lst) extends Lst {
  override def isEmpty = false

  override def map(f: Int => Int) = {
    new Cell(f(head), tail.map(f))
  }

  override def sizeIter(n: Int): Int = tail.sizeIter(n + 1)

  override def toStringIter(prefix: String) =
    tail.toStringIter(s"${prefix}${head} ")
}

// Called Nil in standard library
final class Empty extends Lst {
  override def head = throw new RuntimeException("Empty.head not allowed")

  override def tail = throw new RuntimeException("Empty.tail not allowed")

  override def isEmpty = true

  override def map(f: Int => Int) = {
    this
  }

  override def sizeIter(n: Int) = n

  override def toStringIter(prefix: String): String = s"${prefix})"
}
