package info.ditrapani.overview09

import scala.annotation.tailrec

enum Lst[+A]:
  case Cell[A](head: A, tail: Lst[A]) extends Lst[A]
  case Empty extends Lst[Nothing]

  def isEmpty: Boolean =
    this match
      case Empty => true
      case _: Cell[_] => false

  def map[B](f: A => B): Lst[B] =
    reverse.reduce(Empty: Lst[B])((acc, e) => Cell(f(e), acc))

  @tailrec final def reduce[B](zero: B)(f: (B, A) => B): B =
    this match
      case Empty => zero
      case Cell(h, t) => t.reduce(f(zero, h))(f)

  def reverse: Lst[A] = reduce(Empty: Lst[A])((acc, e) => Cell(e, acc))

  def size: Int = reduce(0)((acc, _) => acc + 1)

  override def toString(): String =
    reduce("Lst( ")((acc, i) => s"${acc}${i} ") + ")"
