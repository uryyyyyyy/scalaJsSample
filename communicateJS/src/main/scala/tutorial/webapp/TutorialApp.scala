package tutorial.webapp

import scala.scalajs.js.JSApp
import org.scalajs.dom

import scala.scalajs.js.annotation.JSExport

object TutorialApp extends JSApp {
  def main(): Unit = {
    println("helloWorld")
    dom.window.alert("Hi from Scala-js-dom")
  }

  @JSExport
  def func1(): String = {
    "helloWorld"
  }

  @JSExport
  def func2(str :String): Unit = {
    println(str)
  }

  @JSExport
  def func3(str :String): String = {
    str + str
  }
}
