enablePlugins(ScalaJSPlugin)

name := "clientCore"

persistLauncher in Compile := true
persistLauncher in Test := false

scalaJSStage in Global := FastOptStage
libraryDependencies ++= Seq(
  "org.scala-js" %%% "scalajs-dom" % "0.9.0",
  "org.scalatest" %% "scalatest" % "3.0.0-M15" % "test"
)

jsDependencies ++= Seq(
  RuntimeDOM
)