package info.ditrapani.overview04

import scala.annotation.tailrec

enum Lst:
  case Cell(head: Int, tail: Lst)
  case Empty

  def isEmpty: Boolean =
    this match
      case Empty => true
      case _: Cell => false

  def map(f: Int => Int): Lst =
    this match
      case Empty =>
        this
      case Cell(head, tail) =>
        // Not tailrec!
        new Cell(f(head), tail.map(f))

  @tailrec final def reduce(zero: Int)(f: (Int, Int) => Int): Int =
    this match
      case Empty => zero
      case Cell(head, tail) => tail.reduce(f(zero, head))(f)

  def size: Int = sizeIter(0)

  @tailrec private def sizeIter(n: Int): Int =
    this match
      case Empty => n
      case Cell(head, tail) => tail.sizeIter(n + 1)

  override def toString(): String = toStringIter("Lst( ")

  def toStringIter(prefix: String): String =
    this match
      case Empty => s"${prefix})"
      case Cell(head, tail) =>
        // Not tailrec!
        tail.toStringIter(s"${prefix}${head} ")
