enablePlugins(ScalaJSPlugin)

name := "npm-sample"

libraryDependencies ++= Seq(
  "com.github.japgolly.scalajs-react" %%% "core" % "0.10.4",
  "com.github.japgolly.scalajs-react" %%% "extra" % "0.10.4",
  "com.github.chandu0101.scalajs-react-components" %%% "core" % "0.4.1"
)