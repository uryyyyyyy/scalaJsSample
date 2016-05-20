package com.github.uryyyyyyy.scalajs.helloworld

import org.scalajs.dom

import scala.scalajs.js.JSApp
import scala.scalajs.js.annotation.JSExport

object ExportToJS {

  @JSExport
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
