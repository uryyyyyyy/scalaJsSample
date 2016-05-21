package com.github.uryyyyyyy.scalajs.useLibrary.react.components

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._
import org.scalajs.dom

object MyComponent {

  case class Props(id: Int)
  private[MyComponent] case class State(list: Seq[String])

  private[MyComponent] class Backend($: BackendScope[Props, State]) {

    def action(e:SyntheticEvent[dom.Node]): Callback ={
      println(this.$.state.runNow())
      $.modState(s => s.copy(list = Seq("hello", "aaa")))
    }
    def render(p: Props, s: State) = {
      <.div(
        <.div(^.onClick ==> action, p.id + " items found:"),
        <.ol(s.list.map(i => <.li(i)))
      )
    }
  }

  def apply(p: Props) =
    ReactComponentB[Props]("Hello")
      .initialState(State(Seq("init", "hey")))
      .renderBackend[Backend]
      .build(p)
}
