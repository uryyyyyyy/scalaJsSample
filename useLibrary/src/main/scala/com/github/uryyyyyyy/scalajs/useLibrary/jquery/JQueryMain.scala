package com.github.uryyyyyyy.scalajs.useLibrary.jquery

import org.scalajs.jquery.jQuery

import scala.scalajs.js.JSApp

object JQueryMain extends JSApp {
  def main(): Unit = {
    jQuery(setupUI _)
    println("helloWorld")
  }

  def setupUI(): Unit = {
    jQuery("""<button type="button">Click me!</button>""")
      .click(addClickedMessage _)
      .appendTo(jQuery("body"))
    jQuery("body").append("<p>Hello World</p>")
  }

  def addClickedMessage(): Unit = {
    jQuery("body").append("<p>You clicked the button!</p>")
  }
}