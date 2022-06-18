package info.ditrapani.overview04

import scala.annotation.tailrec

// Called List in standard library
sealed abstract class Lst:
  def head: Int

  def tail: Lst

  def isEmpty: Boolean

  def map(f: Int => Int): Lst

  @tailrec final def reduce(zero: Int)(f: (Int, Int) => Int): Int =
    this match
      case _: Empty => zero
      case _: Cell => tail.reduce(f(zero, head))(f)

  def size: Int = sizeIter(0)

  @tailrec private def sizeIter(n: Int): Int =
    this match
      case _: Empty => n
      case _: Cell => tail.sizeIter(n + 1)

  override def toString(): String = toStringIter("Lst( ")

  def toStringIter(prefix: String): String

final class Cell(val head: Int, val tail: Lst) extends Lst:
  override def isEmpty = false

  // Not tailrec!
  override def map(f: Int => Int) =
    new Cell(f(head), tail.map(f))

  // Not tailrec!
  override def toStringIter(prefix: String) =
    tail.toStringIter(s"${prefix}${head} ")

final class Empty extends Lst:
  override def head: Int = throw new RuntimeException("Empty.head not allowed")

  override def tail: Lst = throw new RuntimeException("Empty.tail not allowed")

  override def isEmpty = true

  override def map(f: Int => Int) =
    this

  override def toStringIter(prefix: String): String = s"${prefix})"
