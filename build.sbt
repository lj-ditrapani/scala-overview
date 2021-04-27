lazy val root = (project in file(".")).
  settings(
    name := "scala-overview",
    version := "0.1",
    scalaVersion := "2.12.8",
    organization := "info.ditrapani"
  )

scalacOptions ++= Seq(
  "-deprecation",
  "-encoding",
  "UTF-8",
  "-unchecked",
  "-Xlint",
  "-Ypartial-unification",
  "-Ywarn-dead-code",
  "-Ywarn-numeric-widen",
  "-Ywarn-unused",
  "-Ywarn-value-discard",
  "-Xfuture"
)

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.6" % "test"
// libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.7" % "test"

wartremoverWarnings ++= Warts.allBut(
  Wart.Equals,
  Wart.NonUnitStatements,
  Wart.Throw,
  Wart.AsInstanceOf
)

scalafmtOnCompile in ThisBuild := true
