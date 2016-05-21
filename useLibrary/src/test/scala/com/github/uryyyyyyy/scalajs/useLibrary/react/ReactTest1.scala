package com.github.uryyyyyyy.scalajs.useLibrary.react

import com.github.uryyyyyyy.scalajs.useLibrary._
import com.github.uryyyyyyy.scalajs.useLibrary.react.components.MyComponent
import japgolly.scalajs.react.test.{ChangeEventData, ReactTestUtils, _}
import org.scalatest._

class ReactTest1 extends FunSpec with Matchers {

  describe("react") {

    it("test1", NormalTest){
      val comp = ReactTestUtils renderIntoDocument MyComponent(MyComponent.Props(1))
//      ChangeEventData("bob").simulate(comp)
      comp.state.list shouldBe Seq("init", "hey")

    }
  }
}