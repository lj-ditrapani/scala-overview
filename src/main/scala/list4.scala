package info.ditrapani.overview06

import scala.annotation.tailrec

enum Lst:
  case Cell(head: Int, tail: Lst) extends Lst
  case Empty() extends Lst

  def isEmpty: Boolean =
    this match
      case _: Empty => true
      case _: Cell => false

  def map(f: Int => Int): Lst = reverse.mapIter(Empty(), f)

  @tailrec final def mapIter(acc: Lst, f: Int => Int): Lst =
    this match
      case Empty() => acc
      case Cell(h, t) => t.mapIter(Cell(f(h), acc), f)

  @tailrec final def reduce[B](zero: B)(f: (B, Int) => B): B =
    this match
      case Empty() => zero
      case Cell(h, t) => t.reduce(f(zero, h))(f)

  def reverse: Lst = reverseIter(Empty())

  @tailrec final def reverseIter(acc: Lst): Lst =
    this match
      case Empty() => acc
      case Cell(h, t) => t.reverseIter(Cell(h, acc))

  def size: Int = sizeIter(0)

  @tailrec private def sizeIter(n: Int): Int =
    this match
      case Empty() => n
      case Cell(_, t) => t.sizeIter(n + 1)

  override def toString(): String = toStringIter("Lst( ")

  @tailrec final def toStringIter(prefix: String): String =
    this match
      case Empty() => s"${prefix})"
      case Cell(h, t) => t.toStringIter(s"${prefix}${h} ")
