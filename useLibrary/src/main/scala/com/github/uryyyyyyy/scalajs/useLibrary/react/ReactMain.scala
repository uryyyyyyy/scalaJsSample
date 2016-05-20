package com.github.uryyyyyyy.scalajs.useLibrary.react

import chandu0101.scalajs.react.components.materialui._
import japgolly.scalajs.react.vdom.prefix_<^._
import japgolly.scalajs.react.{Callback, _}
import org.scalajs.dom
import org.scalajs.dom.{Event, document}

import scala.scalajs.js.JSApp
import scala.scalajs.js.annotation.JSExport

object ReactMain extends JSApp {

  @JSExport
  def myPrint(): Unit = {
    println("hello")
  }

  def main(): Unit = {
    println("helloWorld")

    val Hello =
      ReactComponentB[String]("Hello")
        .render_P(name => <.div("Hello there ", name))
        .build

    val color = "color".reactStyle

    def click(str:String): Callback = Callback(println(s"hello: $str"))

    val NoArgs =
      ReactComponentB[String]("No args")
        .render_P(str => <.div(
          color := "green",
          ^.onClick --> click(str),
          Hello(str),
          Hello("Sample"),
          MuiFlatButton(
            label = "Primary",
            primary = true,
            onBlur = clickAction
          )()
        )
        ).build

    ReactDOM.render(NoArgs("hello"), document.body)
  }

  val clickA = { (e0: dom.Event) => println("hello")}

  val clickAction: ReactEvent => Callback =
    e1 => Callback.info(s"Event handler: ${e1.eventType}")

  def check(bool: Boolean): String = {
    if (bool) "true" else "false"
  }
}
