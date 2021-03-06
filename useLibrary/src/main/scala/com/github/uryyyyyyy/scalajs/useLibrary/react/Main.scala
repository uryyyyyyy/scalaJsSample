package com.github.uryyyyyyy.scalajs.useLibrary.react

import japgolly.scalajs.react.vdom.prefix_<^._
import japgolly.scalajs.react.{ReactComponentB, ReactDOM}
import org.scalajs.dom.document

import scala.scalajs.js.JSApp

object Main extends JSApp {
  def main(): Unit = {
    println("helloWorld")

    val Hello =
      ReactComponentB[String]("Hello")
        .render_P(name => <.div(^.id := 1, "Hello there ", name))
        .build

    val NoArgs =
      ReactComponentB[Unit]("No args")
        .render(_ => <.div(Hello("John"), Hello("Sample")))
        .buildU

    ReactDOM.render(NoArgs(), document.body)
  }
}
