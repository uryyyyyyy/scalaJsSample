package tutorial.webapp

import japgolly.scalajs.react.{ReactComponentB, ReactDOM}
import japgolly.scalajs.react.vdom.prefix_<^._
import org.scalajs.dom.document

import scala.scalajs.js.JSApp

object TutorialApp extends JSApp {
  def main(): Unit = {
    println("helloWorld")

    val Hello =
      ReactComponentB[String]("Hello")
        .render_P(name => <.div("Hello there ", name))
        .build

    val NoArgs =
      ReactComponentB[Unit]("No args")
        .render(_ => <.div(Hello("John"), Hello("Sample")))
        .build

    ReactDOM.render(NoArgs(), document.body)
  }
}
