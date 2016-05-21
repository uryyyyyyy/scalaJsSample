package com.github.uryyyyyyy.scalajs.useLibrary.react.components

import com.github.uryyyyyyy.scalajs.useLibrary.react.router.SampleJs
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._
import org.scalajs.dom
import org.scalajs.dom.window

object MyComponent3 {

  type Props = Unit
  type State = Unit

  private[MyComponent3] class Backend($: BackendScope[Props, State]) {

    def action(e:SyntheticEvent[dom.Node]): Callback ={
      val str = SampleJs.hello("ping")
      window.alert("scalajs receive: " + str)
      Callback()
    }
    def render(p: Props, s: State) = {
      <.div(
        <.div(^.onClick ==> action, "action")
      )
    }
  }

  def apply(p: Props) ={
    ReactComponentB[Props]("Hello")
      .renderBackend[Backend]
      .build(p)
  }

}
