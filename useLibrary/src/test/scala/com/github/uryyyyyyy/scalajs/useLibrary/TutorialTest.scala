package com.github.uryyyyyyy.scalajs.useLibrary

import org.scalajs.dom.window
import org.scalajs.jquery.jQuery
import org.scalatest._

class TutorialTest extends FunSpec with Matchers {
  describe("jQuery2") {

    it("test1", AsyncTest){
      val href = window.location.href
      println(window.name)
      println(href)
      1 shouldBe 1
    }
  }
}