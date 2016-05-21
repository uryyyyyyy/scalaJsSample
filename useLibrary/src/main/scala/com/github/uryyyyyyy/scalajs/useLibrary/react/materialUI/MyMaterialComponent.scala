package com.github.uryyyyyyy.scalajs.useLibrary.react.materialUI

import chandu0101.scalajs.react.components.materialui.MuiFlatButton
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._
import org.scalajs.dom

object MyMaterialComponent {

  case class Props(id: Int)
  private[MyMaterialComponent] case class State(list: Seq[String])

  private[MyMaterialComponent] class Backend($: BackendScope[Props, State]) {

    def action(e:SyntheticEvent[dom.Node]): Callback ={
      println(this.$.state.runNow())
      $.modState(s => s.copy(list = Seq("hello", "aaa")))
    }

    val clickAction: ReactEvent => Callback =
      e1 => Callback.info(s"Event handler: ${e1.eventType}")

    def render(p: Props, s: State) = {
      MuiFlatButton(
        label = "Primary",
        primary = true,
        onBlur = clickAction
      )()
    }
  }

  def apply(p: Props) =
    ReactComponentB[Props]("Hello")
      .initialState(State(Seq("init", "hey")))
      .renderBackend[Backend]
      .build(p)
}
