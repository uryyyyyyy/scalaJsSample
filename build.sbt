name := "scalaJsSample"

scalaVersion := "2.11.8"

lazy val commonSettings = Seq(
  organization := "com.github.uryyyyyyy",
  scalaVersion := "2.11.8"
)

lazy val clientCore = (project in file("clientCore")).
  settings(commonSettings: _*)

lazy val helloWorld = (project in file("helloWorld")).
  settings(commonSettings: _*)
  .dependsOn(clientCore)

lazy val jquery = (project in file("jquery")).
  settings(commonSettings: _*)
  .dependsOn(clientCore)

lazy val react = (project in file("react")).
  settings(commonSettings: _*)
  .dependsOn(clientCore)

lazy val communicateJS = (project in file("communicateJS")).
  settings(commonSettings: _*)
  .dependsOn(clientCore)

lazy val jsonServer = (project in file("jsonServer")).
  settings(commonSettings: _*)
  .dependsOn(jsonCommon)

lazy val jsonCommon = (project in file("jsonCommon")).
  settings(commonSettings: _*)

lazy val jsonClient = (project in file("jsonClient")).
  settings(commonSettings: _*)
  .dependsOn(clientCore)
  .dependsOn(jsonCommon)