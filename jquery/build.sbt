enablePlugins(ScalaJSPlugin)

name := "jquery"

testFrameworks += new TestFramework("utest.runner.Framework")

libraryDependencies ++= Seq(
  "com.lihaoyi" %%% "utest" % "0.3.0" % "test",
  "be.doeraene" %%% "scalajs-jquery" % "0.9.0"
)

jsDependencies ++= Seq(
  RuntimeDOM,
  "org.webjars" % "jquery" % "2.1.4" / "2.1.4/jquery.js"
)