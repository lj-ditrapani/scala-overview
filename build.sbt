lazy val root = (project in file(".")).
  settings(
    name := "scala-overview",
    version := "0.1",
    scalaVersion := "2.13.5",
    organization := "info.ditrapani"
  )

scalacOptions ++= Seq(
  "-deprecation",
  "-encoding",
  "UTF-8",
  "-unchecked",
  "-Xlint",
  "-Ywarn-dead-code",
  "-Ywarn-numeric-widen",
  "-Ywarn-unused",
  "-Ywarn-value-discard",
)

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.7" % "test"

wartremoverWarnings ++= Warts.allBut(
  Wart.Equals,
  Wart.NonUnitStatements,
  Wart.Throw,
  Wart.AsInstanceOf,
  Wart.StringPlusAny,
)

ThisBuild / scalafmtOnCompile := true
