addCommandAlias("fmt", "scalafmtAll")

lazy val root = project
    .in(file("."))
    .settings(
        name := "scala-overview",
        version := "0.1",
        scalaVersion := "3.1.2",
        organization := "info.ditrapani",
        scalacOptions := compilerOptions,
        libraryDependencies ++= Seq(
          dependencies.scalaTest,
          dependencies.scalaTestFreespec,
        )
    )


lazy val compilerOptions =
  Seq(
    "-deprecation",
    "-encoding",
    "UTF-8",
    "-unchecked",
    "-Yexplicit-nulls",
    "-Ysafe-init",
    // "-new-syntax",
    // "-indent",
    // "-rewrite",
  )


lazy val dependencies =
  new {
    val scalaTestV = "3.2.12"

    val scalaTest = "org.scalatest" %% "scalatest" % scalaTestV % "test"
    val scalaTestFreespec =
      "org.scalatest" %% "scalatest-freespec" % scalaTestV % "test"
  }
