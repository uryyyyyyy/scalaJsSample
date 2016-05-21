name := "scalaJsSample"

lazy val commonSettings = Seq(
  organization := "com.github.uryyyyyyy",
  scalaVersion := "2.11.8",
  version := "0.1.0"
)

//lazy val clientCore = (project in file("clientCore"))
//  .settings()

val helloWorldOutputDir        = file("helloWorld/generated")

lazy val helloWorld = (project in file("helloWorld"))
  .settings(commonSettings: _*)
  .enablePlugins(ScalaJSPlugin)
  .settings(
    name := "hello-world",
    libraryDependencies ++= Seq(
      "org.scala-js" %%% "scalajs-dom" % "0.9.0",
      "be.doeraene" %%% "scalajs-jquery" % "0.9.0",
      "org.scalatest" %%% "scalatest" % "3.0.0-M15" % "test"
    ),
    testFrameworks += new TestFramework("utest.runner.Framework"),
    jsDependencies += RuntimeDOM,
    jsDependencies += "org.webjars" % "jquery" % "2.1.4" / "2.1.4/jquery.js",
    crossTarget  in (Compile, fullOptJS)                     := helloWorldOutputDir,
    crossTarget  in (Compile, fastOptJS)                     := helloWorldOutputDir,
    crossTarget  in (Compile, packageJSDependencies)         := helloWorldOutputDir,
    crossTarget  in (Compile, packageScalaJSLauncher)        := helloWorldOutputDir,
    crossTarget  in (Compile, packageMinifiedJSDependencies) := helloWorldOutputDir
    //    artifactPath in (Compile, fastOptJS)                     :=
    //      ((crossTarget in (Compile, fastOptJS)).value / ((moduleName in fastOptJS).value + "-opt.js"))
    //      name := "clientCore"
    //
    //persistLauncher in Compile := true
    //persistLauncher in Test := false
    //
    //scalaJSStage in Global := FastOptStage
  )


val useLibraryOutputDir        = file("useLibrary/generated")

lazy val useLibrary = (project in file("useLibrary"))
  .settings(commonSettings: _*)
  .enablePlugins(ScalaJSPlugin)
  .settings(
    name := "use-library",
    libraryDependencies ++= Seq(
      "org.scala-js" %%% "scalajs-dom" % "0.9.0",
      "be.doeraene" %%% "scalajs-jquery" % "0.9.0",
      "com.lihaoyi" %%% "upickle" % "0.4.0",
      "com.github.japgolly.scalajs-react" %%% "core" % "0.10.4",
      "com.github.japgolly.scalajs-react" %%% "extra" % "0.10.4",
      "com.github.chandu0101.scalajs-react-components" %%% "core" % "0.4.1",
      "org.scalatest" %% "scalatest" % "3.0.0-M15" % "test"
    ),
    jsDependencies += RuntimeDOM,
    crossTarget  in (Compile, fullOptJS)                     := useLibraryOutputDir,
    crossTarget  in (Compile, fastOptJS)                     := useLibraryOutputDir,
    crossTarget  in (Compile, packageJSDependencies)         := useLibraryOutputDir,
    crossTarget  in (Compile, packageScalaJSLauncher)        := useLibraryOutputDir,
    crossTarget  in (Compile, packageMinifiedJSDependencies) := useLibraryOutputDir
  )

lazy val jsonServer = (project in file("jsonServer"))
  .settings(commonSettings: _*)
  .enablePlugins(PlayScala)
  .settings(
    name := "json-server",
    libraryDependencies ++= Seq(
      "com.lihaoyi" %% "upickle" % "0.4.0",
      jdbc,
      cache,
      ws,
      "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test
    ),
    resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"
  ).dependsOn(jsonCommon)

lazy val jsonCommon = (project in file("jsonCommon"))
  .settings(commonSettings: _*)
  .settings(
    name := "json-common"
  )

val jsonClientOutputDir        = file("jsonServer/public/generated")

lazy val jsonClient = (project in file("jsonClient"))
  .settings(commonSettings: _*)
  .enablePlugins(ScalaJSPlugin)
  .dependsOn(jsonCommon)
  .settings(
    name := "json-client",
    libraryDependencies ++= Seq(
      "org.scala-js" %%% "scalajs-dom" % "0.9.0",
      "be.doeraene" %%% "scalajs-jquery" % "0.9.0",
      "com.lihaoyi" %%% "upickle" % "0.4.0",
      "com.github.japgolly.scalajs-react" %%% "core" % "0.10.4",
      "com.github.japgolly.scalajs-react" %%% "extra" % "0.10.4",
      "com.github.chandu0101.scalajs-react-components" %%% "core" % "0.4.1",
      "org.scalatest" %%% "scalatest" % "3.0.0-M15" % "test"
    ),
    crossTarget  in (Compile, fullOptJS)                     := jsonClientOutputDir,
    crossTarget  in (Compile, fastOptJS)                     := jsonClientOutputDir,
    crossTarget  in (Compile, packageJSDependencies)         := jsonClientOutputDir,
    crossTarget  in (Compile, packageScalaJSLauncher)        := jsonClientOutputDir,
    crossTarget  in (Compile, packageMinifiedJSDependencies) := jsonClientOutputDir
  )