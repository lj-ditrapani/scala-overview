package info.ditrapani.overview6

import scala.annotation.tailrec

enum Lst[A]:
  case Cell(head: A, tail: Lst[A])
  case Empty()

  def isEmpty: Boolean =
    this match
      case _: Empty[_] => true
      case _: Cell[_] => false

  def map[B](f: A => B): Lst[B] =
    reverse.reduce(Empty(): Lst[B])((acc, e) => Cell(f(e), acc))

  @tailrec final def reduce[B](zero: B)(f: (B, A) => B): B =
    this match
      case Empty() => zero
      case Cell(h, t) => t.reduce(f(zero, h))(f)

  def reverse: Lst[A] = reduce(Empty(): Lst[A])((acc, e) => Cell(e, acc))

  def size: Int = reduce(0)((acc, _) => acc + 1)

  override def toString(): String =
    reduce("Lst( ")((acc, i) => s"${acc}${i} ") + ")"
