name := "Scala.js Tutorial"

scalaJSStage in Global := FastOptStage

lazy val commonSettings = Seq(
	organization := "com.github.uryyyyyyy",
	scalaVersion := "2.11.7",
	libraryDependencies ++= Seq(
		"com.lihaoyi" %%% "upickle" % "0.2.8",
		"org.scala-js" %%% "scalajs-dom" % "0.8.0",
		"com.github.japgolly.scalajs-react" %%% "core" % "0.10.4",
		"org.scalatest" %% "scalatest" % "3.0.0-M15" % "test"
	)
)

lazy val angular1 = (project in file("angular1")).
		settings(commonSettings: _*)

lazy val circe = (project in file("circe")).
		settings(commonSettings: _*)

lazy val share = (project in file("share")).
		settings(commonSettings: _*)

lazy val server = (project in file("server")).
		settings(commonSettings: _*)

lazy val helloWorld = (project in file("helloWorld")).
		settings(commonSettings: _*)