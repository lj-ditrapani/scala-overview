lazy val root = (project in file(".")).
  settings(
    name := "scala-overview",
    version := "0.1",
    scalaVersion := "2.11.8",
    organization := "ditrapani.info"
  )

libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.6" % "test"
