package info.ditrapani.overview1

// Called List in standard library
enum Lst:
  // Called :: (Cons) in standard library
  case Cell(head: Int, tail: Lst)
  // Called Nil in standard library
  case Empty
