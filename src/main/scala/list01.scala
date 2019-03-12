package info.ditrapani.overview01

// Called List in standard library
sealed abstract class Lst

// Called :: (Cons) in standard library
final class Cell(val head: Int, val tail: Lst) extends Lst

// Called Nil in standard library
final class Empty extends Lst
