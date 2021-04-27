package info.ditrapani.overview05

import scala.annotation.tailrec

sealed abstract class Lst {
  def isEmpty: Boolean

  def map(f: Int => Int): Lst = reverse.mapIter(Empty(), f)

  @tailrec def mapIter(acc: Lst, f: Int => Int): Lst =
    this match {
      case Empty() => acc
      case Cell(h, t) => t.mapIter(Cell(f(h), acc), f)
    }

  @tailrec def reduce(zero: Int)(f: (Int, Int) => Int): Int =
    this match {
      case Empty() => zero
      case Cell(h, t) => t.reduce(f(zero, h))(f)
    }

  def reverse: Lst = reverseIter(Empty())

  @tailrec def reverseIter(acc: Lst): Lst =
    this match {
      case Empty() => acc
      case Cell(h, t) => t.reverseIter(Cell(h, acc))
    }

  def size: Int = sizeIter(0)

  @tailrec private def sizeIter(n: Int): Int =
    this match {
      case Empty() => n
      case Cell(_, t) => t.sizeIter(n + 1)
    }

  override def toString(): String = toStringIter("Lst( ")

  @tailrec def toStringIter(prefix: String): String =
    this match {
      case Empty() => s"${prefix})"
      case Cell(h, t) => t.toStringIter(s"${prefix}${h} ")
    }
}

final case class Cell(head: Int, tail: Lst) extends Lst {
  override val isEmpty = false
}

final case class Empty() extends Lst {
  override val isEmpty = true
}
