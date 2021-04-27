package info.ditrapani.overview10

import scala.annotation.tailrec

sealed abstract class Lst[+A] {
  def isEmpty: Boolean

  def map[B](f: A => B): Lst[B] =
    reverse.reduce(Empty: Lst[B])((acc, e) => Cell(f(e), acc))

  @tailrec def reduce[B](zero: B)(f: (B, A) => B): B =
    this match {
      case Empty => zero
      case Cell(h, t) => t.reduce(f(zero, h))(f)
    }

  def reverse: Lst[A] = reduce(Empty: Lst[A])((acc, e) => Cell(e, acc))

  def size: Int = reduce(0)((acc, _) => acc + 1)

  override def toString(): String =
    reduce("Lst( ")((acc, i) => s"${acc}${i} ") + ")"
}

object Lst {
  def apply[A](seq: A*): Lst[A] =
    seq.reverse.foldLeft(Empty: Lst[A])((acc, e) => Cell(e, acc))
}

final case class Cell[A](head: A, tail: Lst[A]) extends Lst[A] {
  override val isEmpty = false
}

object Empty extends Lst[Nothing] {
  override val isEmpty = true
}
