lazy val root = (project in file(".")).
  settings(
    name := "scala-overview",
    version := "0.1",
    scalaVersion := "3.0.0-RC3",
    organization := "info.ditrapani"
  )

scalacOptions ++= Seq(
  "-deprecation",
  "-encoding",
  "UTF-8",
  "-unchecked",
)

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.8" % "test"

// Need to find a way to make wartremover work with scala 3 or find an alternative
/*
wartremoverWarnings ++= Warts.allBut(
  Wart.Equals,
  Wart.NonUnitStatements,
  Wart.Throw,
  Wart.AsInstanceOf,
  Wart.StringPlusAny,
)
*/

ThisBuild / scalafmtOnCompile := true
