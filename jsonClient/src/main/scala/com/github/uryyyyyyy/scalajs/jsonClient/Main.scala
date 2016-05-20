package com.github.uryyyyyyy.scalajs.jsonClient

import scala.scalajs.js.JSApp
import org.scalajs.dom

import scala.util.Random

object Main extends JSApp {
  def main(): Unit = {
    println("helloWorld")
    dom.window.alert("Hi from Scala-js-dom")

    val r = Random

    val either = if(r.nextBoolean()) Left("sample L") else Right("sample R")

    either match {
      case Left(v) => println("left");println(v)
      case Right(v) => println("right");println(v)
    }
  }
}
