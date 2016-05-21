package com.github.uryyyyyyy.scalajs.helloworld

import org.scalajs.dom.window
import org.scalajs.jquery.jQuery
import org.scalatest._

class TutorialTest extends FunSpec with Matchers {
  describe("jQuery2") {
    TutorialApp.setupUI()

    it("test1", AsyncTest){
      val href = window.location.href
      println(window.name)
      println(href)
      1 shouldBe 1
    }
    it("test2", AsyncTest){

      jQuery("p:contains('Hello World')").length shouldBe 1
    }
  }
}