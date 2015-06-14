enablePlugins(ScalaJSPlugin)

name := "Scala.js Tutorial"

scalaVersion := "2.11.6"

scalaJSStage in Global := FastOptStage

libraryDependencies ++= Seq(
  "com.lihaoyi" %%% "upickle" % "0.2.8",
  "com.github.japgolly.scalajs-react" %%% "core" % "0.9.0"
)