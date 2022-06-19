package info.ditrapani.overview5

import scala.annotation.tailrec

enum Lst:
  case Cell(head: Int, tail: Lst)
  case Empty

  def isEmpty: Boolean =
    this match
      case Empty => true
      case _: Cell => false

  def map(f: Int => Int): Lst =
    reverse.reduce(Empty: Lst)((acc, e) => Cell(f(e), acc))

  @tailrec final def reduce[B](zero: B)(f: (B, Int) => B): B =
    this match
      case Empty => zero
      case Cell(h, t) => t.reduce(f(zero, h))(f)

  def reverse: Lst = reduce(Empty: Lst)((acc, e) => Cell(e, acc))

  def size: Int = reduce(0)((acc, _) => acc + 1)

  override def toString(): String =
    reduce("Lst( ")((acc, i) => s"${acc}${i} ") + ")"
