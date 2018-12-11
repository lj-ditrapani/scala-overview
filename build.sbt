lazy val root = (project in file(".")).
  settings(
    name := "scala-overview",
    version := "0.1",
    scalaVersion := "2.12.8",
    organization := "ditrapani.info"
  )

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % "test"
