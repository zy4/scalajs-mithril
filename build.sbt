lazy val sharedSettings = Seq(
  organization := "com.tgf.pizza",
  scalaVersion := "2.12.6",
  crossScalaVersions := Seq("2.12.6", "2.11.11"),
  scalacOptions ++= Seq(
    "-feature",
    "-deprecation",
    "-Xlint",
    "-Xfatal-warnings"
  ),
)

lazy val root = (project in file(".")).aggregate(core, examples)

lazy val core =
  (project in file("core"))
    .settings(sharedSettings: _*)
    .settings(
      scalacOptions ++= Seq("-P:scalajs:suppressExportDeprecations",
                            "-P:scalajs:suppressMissingJSGlobalDeprecations",
                            "-P:scalajs:sjsDefinedByDefault"),
      name := """scalajs-mithril""",
      libraryDependencies ++= Seq(
        "org.scala-js" %%% "scalajs-dom" % "0.9.3"
      )
    )
    .enablePlugins(ScalaJSPlugin)

lazy val examples =
  (project in file("examples"))
    .settings(sharedSettings: _*)
    .settings(
      scalacOptions ++= Seq("-P:scalajs:suppressExportDeprecations",
                            "-P:scalajs:suppressMissingJSGlobalDeprecations",
                            "-P:scalajs:sjsDefinedByDefault"),
      name := """scalajs-mithril-examples""",
      libraryDependencies ++= Seq(
        "org.scala-js" %%% "scalajs-dom" % "0.9.3"
      ),
      jsDependencies += "org.webjars" % "mithril" % "0.2.5" / "mithril.js"
    )
    .enablePlugins(ScalaJSPlugin)
    .dependsOn(core)
