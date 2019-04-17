import Dependencies._

name := "mirror-demo-scalajs-react"

version := "0.1"

ThisBuild / scalaVersion := "2.12.8"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / organization := "org.tmt"
ThisBuild / organizationName := "tmt"

scalaVersion := "2.12.8"


lazy val `react4s-app` = (project in file("./react4s-app"))
  .settings(
    name := "react4s-app",

    // This is an application with a main method
    scalaJSUseMainModuleInitializer := true,
    emitSourceMaps := true,

    jsEnv := new org.scalajs.jsenv.jsdomnodejs.JSDOMNodeJSEnv(),

    skip in packageJSDependencies := false,

    resolvers += Resolver.bintrayRepo("hmil", "maven"),
    resolvers += Resolver.sonatypeRepo("snapshots"),

    libraryDependencies ++= Seq(
      scalaTest % Test,
      "org.scala-js" %%% "scalajs-dom" % "0.9.6",
      "com.github.ahnfelt" %%% "react4s" % "0.9.24-SNAPSHOT"
//      diode
    ),

    Compile / npmDependencies ++= Seq(
      "react" -> "16.5.1",
      "react-dom" -> "16.5.1",
      "react-tooltip" -> "3.10.0"
    ),

    scalacOptions += "-P:scalajs:sjsDefinedByDefault",
    webpackDevServerExtraArgs in fastOptJS := Seq("--inline", "--hot"),
    webpackResources := webpackResources.value +++ PathFinder(Seq(baseDirectory.value / "index.html")) ** "*.*",
    webpackDevServerExtraArgs in fastOptJS ++= Seq(
      "--content-base",
      baseDirectory.value.getAbsolutePath
    )
  )
  .enablePlugins(ScalaJSPlugin, ScalaJSBundlerPlugin)