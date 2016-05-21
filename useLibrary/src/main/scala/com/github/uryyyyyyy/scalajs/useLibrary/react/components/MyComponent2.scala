package com.github.uryyyyyyy.scalajs.useLibrary.react.components

import com.github.uryyyyyyy.scalajs.useLibrary.react.router.{MyPages, Search}
import japgolly.scalajs.react._
import japgolly.scalajs.react.extra.router.RouterCtl
import japgolly.scalajs.react.vdom.prefix_<^._
import org.scalajs.dom

object MyComponent2 {

  case class Props(ctr: RouterCtl[MyPages])
  private[MyComponent2] case class State(str: String)

  private[MyComponent2] class Backend($: BackendScope[Props, State]) {

    def action(e:SyntheticEvent[dom.Node]): Callback ={
      println(this.$.state.runNow())
      $.modState(s => s.copy(str = "aaa"))
    }
    def render(p: Props, s: State) = {
      <.div(
        <.div(^.onClick ==> action, p.ctr.baseUrl.value + ": base url"),
        <.button("Refresh", ^.onClick --> p.ctr.set(Search))
      )
    }
  }

  def apply(p: Props) ={
    ReactComponentB[Props]("Hello")
      .initialState(State("init"))
      .renderBackend[Backend]
      .build(p)
  }

}
