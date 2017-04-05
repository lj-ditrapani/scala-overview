Scala Overview
==============

This repo has 10 numbered branches.

1. Current branch = 1
2. Checkout current branch, talk about the code, run the tests.
3. Current branch = Current branch + 1
4. Go to step 2 unless Current branch > 10


Cost of typed language
----------------------
- Extra wordiness of types
- Optimized for maintainability/readability over write-ability
- 'noise' of types
- Almost like 2 languages; the runtime semantics & the type system


Benefit
-------
- maintainability
- readability (types are documentation)
- performance (not true with TypeScript)
- Don't need tests to check that you implemented the interface correctly
- Don't need tests to check that you are using the interface correctly


FP
--
- Referential transparency
- Immutable data structures
- Pure, side-effect-free functions


Intro
-----
We are going to build a generic list class.
Along the way we will learn about case classes, pattern matching,
and type parameters.
Show box/pointer diagram of list object on white board.


1-no-case-class
---------------
code
- packages like java
- Basic Lst of Ints class
- Inheritance (traits vs abstract class)

tests
- 'new' to create instance
- type casting :(
- tedious list construction

Don't want to type cast to call head/tail.


2-interface-methods
-------------------
code
- head/tail/isEmpty abstract methods
- override
- Ugly implementation of head/tail in Empty

tests
- no more type casts :)


3-more-interface-methods
------------------------
code
- new methods: map, reduce, size, toString
- tailrec

tests
- new tests for new methods
- lambda function
- underscore in lambda function


4-pattern-match
---------------
code
- Match on type


5-case-classes
--------------
code
- no val in parameters; yet still public attributes
- free apply method
- free unapply in pattern matches
- free toString & copy & == & hash
- everything is tailrec now

tests
- Use of apply method


6-type-parameters-1
----------------
Reduce is way too restrictive.  Let's make it more generic.

code
- reduce has a type parameter B
- B is the type of zero, and an input and the output parameter of f

tests
- Now we can reduce to a string instead of only an Int
- Reducing to an Int still works the same


7-refactor
----------
Re-write in terms of reduce


8-type-parameters-2
-------------------
code
- Lst is parameterized over type A
- map is parameterized over type B, so f is function from A => B
- reduce & reverse also affected
- Line 9 reduce(Empty(): Lst[B]) the Lst[B] is required
- Same on line 16

tests
- Added some generic type parameters (Lst[Int] on line 5 & 8)
- Lines 64-74:  tests Lst[Char]


9-nil-object
------------
Empty should be a singleton object, not a class

code
- Lst[+A], +A means type covariance:
  if B is a subtype of A, then Lst[B] is a subtype of Lst[A]
- Without the +A, Lst is type invariant with regard to its type parameter.
- Empty is an object
- Nothing is the bottom type

tests
- lose params for Empty, since no longer constructing instance.


10-apply-with-varargs
---------------------

code
- apply to make Lst a function (lines 24-27)
- varargs with *
- apply is parameterized on type A
- much nicer list constructor

tests
- use new Lst constructor in test code


Wrapping up
-----------

- Look at main.scala
- Splat sequence collection with `_*`
- run assembly in sbt; can now run resulting,
  self-contained jar on any jvm, Java 6 or later
- Option, Try, Either have similar implementations
  (case classes, pattern-matching, type covariance)


Going further
-------------
List documentation
- List <http://www.scala-lang.org/api/2.11.8/#scala.collection.immutable.List>
  sealed abstract class List[+A]
- <http://www.scala-lang.org/api/2.11.8/index.html#scala.collection.immutable.$colon$colon>
  final case class ::[B](head: B, tl: List[B]) extends List[B]
- <http://www.scala-lang.org/api/2.11.8/index.html#scala.collection.immutable.Nil$>
  object Nil extends List[Nothing]

:: & Nil are subclasses of List

:: reads as the 'cons' operator

Blog post with similar ideas:
<http://underscore.io/blog/posts/2015/06/02/everything-about-sealed.html>


Resources
---------
Types:
<http://docs.scala-lang.org/tutorials/tour/unified-types.html>

Tutorial (from shallow to more in depth):
- <https://learnxinyminutes.com/docs/scala/>
- <http://www.tutorialspoint.com/scala/>
- <http://docs.scala-lang.org/tutorials/tour/tour-of-scala>

You can decompile your .class files that scalac emits with javap (partial)
or cfr_0_121.jar (complete) or some other java decompiler.

- CFR - another java decompiler <http://www.benf.org/other/cfr/> 

Coursera has 3 brand-new scala courses available (2016).
