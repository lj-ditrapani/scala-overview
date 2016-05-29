Cost of typed language
----------------------
Typing Overhead
Optimized for maintainability/read over write
'noise' of types


Benefit
-------
maintainability
readability (types are documentation)
performance


FP
--
Referential transparency
Immutable data structures
Pure, side-effect-free functions


Language features
-----------------

val vs var
val x: Int = 42
var y: Int = 43

classes

traits
- can be interface
- can have implementation
- class can use multiple traits (trait linearization)

case classes

pattern matching

functions

map flatMap filter

collections
Immutable & mutable
Vector
Map
List
Array

types
<http://docs.scala-lang.org/tutorials/tour/unified-types.html>
type parameters
type variance
covariance A+
contravariance A-
self types

type bounds

Option, Try


https://learnxinyminutes.com/docs/scala/
http://underscore.io/blog/posts/2015/06/02/everything-about-sealed.html
Use book?

List
http://www.scala-lang.org/api/2.11.8/#scala.collection.immutable.List
sealed abstract class List[+A]
http://www.scala-lang.org/api/2.11.8/index.html#scala.collection.immutable.$colon$colon
final case class ::[B](head: B, tl: List[B]) extends List[B]
http://www.scala-lang.org/api/2.11.8/index.html#scala.collection.immutable.Nil$
object Nil extends List[Nothing]

:: & Nil are subclasses of List

javap
java .class decompiler
cfr_0_115.jar


or make a List & Option class & tests?
that would be fun
