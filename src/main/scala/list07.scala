package info.ditrapani.overview07

import scala.annotation.tailrec

sealed abstract class Lst {
  def isEmpty: Boolean

  def map(f: Int => Int): Lst =
    reverse.reduce(Empty(): Lst)((acc, e) => Cell(f(e), acc))

  @tailrec final def reduce[B](zero: B)(f: (B, Int) => B): B =
    this match {
      case Empty() => zero
      case Cell(h, t) => t.reduce(f(zero, h))(f)
    }

  def reverse: Lst = reduce(Empty(): Lst)((acc, e) => Cell(e, acc))

  def size: Int = reduce(0)((acc, _) => acc + 1)

  override def toString(): String =
    reduce("Lst( ")((acc, i) => s"${acc}${i} ") + ")"
}

final case class Cell(head: Int, tail: Lst) extends Lst {
  override val isEmpty = false
}

final case class Empty() extends Lst {
  override val isEmpty = true
}
