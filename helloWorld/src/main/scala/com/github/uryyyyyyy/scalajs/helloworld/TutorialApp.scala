package com.github.uryyyyyyy.scalajs.helloworld

import org.scalajs.dom
import org.scalajs.jquery.jQuery

import scala.scalajs.js.JSApp

object TutorialApp extends JSApp {
  def main(): Unit = {
    jQuery(setupUI _)
  }

  //jQUery
  def setupUI(): Unit = {
    jQuery("body").append("<p>Hello World</p>")
    jQuery("body").append("<button>clickMe!</button>")
      .click((e: dom.Event) => addClickedMessage(e))
  }

  //low level DOM API
  def addClickedMessage(e: dom.Event): Unit = {
    val parNode = dom.document.createElement("p")
    val textNode = dom.document.createTextNode(s"e.type: ${e.`type`}")
    parNode.appendChild(textNode)
    dom.document.body.appendChild(parNode)
  }

}