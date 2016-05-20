package tutorial.webapp

import scala.scalajs.js.JSApp
import japgolly.scalajs.react.{ReactComponentB, ReactDOM}
import japgolly.scalajs.react.vdom.prefix_<^._
import org.scalajs.dom.document

object TutorialApp extends JSApp {
  def main(): Unit = {
    println("helloWorld")

    val Hello =
      ReactComponentB[String]("Hello")
        .render_P(name => <.div("Hello there ", name))
        .build

    val NoArgs =
      ReactComponentB[String]("No args")
        .render_P(str => <.div(Hello(str), Hello("Sample")))
        .build

    ReactDOM.render(NoArgs("hello"), document.body)
  }
}
