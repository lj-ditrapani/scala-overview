Scala Overview
==============

This overview has 8 stages.
Each stage has corresponding `src/main/listXX.scala`
and `src/test/listXX_spec.scala` files.

1. X = 1
2. Open `listX.scala` and `listX_spec.scala`,
3. Talk about the code; notes for each stage below.
4. Run the tests `sbt testOnly *ListXSpec`
5. X = X + 1
6. Go to step 2 unless X > 8


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
Along the way we will learn about enums, pattern matching,
and type parameters, ADTs.
Show box/pointer diagram of list object on white board.


1-enum
---------------
code
- packages like java
- Basic Lst of Ints class
- Inheritance (Lst trait & case cases)

tests
- 'new' to create instance
    - can be omitted for case classes
- Empty is an Object
- type casting :(
- tedious list construction

Don't want to type cast to call head/tail.


2-methods
-------------------
code
- new methods: isEmpty, map, reduce, size, toString
- tailrec
- curry
- override
- Match
    - on value
    - on type
    - destructuring

tests
- no more type casts :)
- new tests for new methods
- lambda function
- underscore in lambda function


3-case-classes
--------------
code
- enum cases are case classes
    - free apply method
    - free unapply in pattern matches
    - free toString & copy & == & hash
- everything is tailrec now


4-type-parameters-1
-------------------
Reduce is way too restrictive.  Let's make it more generic.

code
- reduce has a type parameter B
- B is the type of zero, and an input and the output parameter of f

tests
- Now we can reduce to a string instead of only an Int
- Reducing to an Int still works the same


5-refactor
----------
Re-write methods in terms of reduce


6-type-parameters-2
-------------------
code
- Lst is parameterized over type A
- map is parameterized over type B, so f is function from A => B
- reduce & reverse also affected
- Line 15 reduce(Empty(): Lst[B]) the Lst[B] is required
- Same on line 22
- Empty changed from an object to a case class
    - We will need to fix this in next step

tests
- Added some generic type parameters (Lst[Int] on line 8 & 11)
- Lines 68 on:  tests Lst[Char]


7-nil-object
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


8-apply-with-varargs
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
- Splat sequence collection with `*`
- Option, Try, Either have similar implementations
  (case classes/enum, pattern-matching, type covariance)

Develop:

Start sbt console with `sbt`.
From sbt console you can run these useful commands while you develop:

    compile
    test
    run
    fmt

Deploying:

- run `sbt stage`; this stages the package which you can run
  directly with `target/universal/stage/bin/scala-overview`
- run `sbt Universal / packageBin`, this generates a zip artifact
  packaged here: `target/universal/scala-overview-<version>.zip`

Dependencies:

- check for outdated dependencies with `sbt dependencyUpdates`


Going further
-------------

List documentation
- List <https://www.scala-lang.org/api/current/scala/collection/immutable/List.html>
  `sealed abstract class List[+A]`
- <https://www.scala-lang.org/api/current/scala/collection/immutable/$colon$colon.html>
  `final case class ::[B](head: B, tl: List[B]) extends List[B]`
- <https://www.scala-lang.org/api/current/scala/collection/immutable/Nil$.html>
  `object Nil extends List[Nothing]`
- :: & Nil are subclasses of List
- :: reads as the 'cons' operator
- Blog post with similar ideas:
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

Coursera has 3 scala courses available.

<https://exercism.io> has a scala track.

There are lots of scala books available. I recommend:
- Scala for the Impatient (Cay S. Horstmann) -- Gentle overview
- Programming in Scala (Martin Odersky) -- Deep dive
