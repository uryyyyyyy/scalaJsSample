package com.github.uryyyyyyy.scalajs.helloworld

import org.scalajs.dom
import org.scalajs.dom.window
import org.scalajs.jquery.jQuery
import org.scalatest._

import scala.concurrent.Promise

import org.scalatest.Tag

object SlowTest extends Tag("com.mycompany.tags.SlowTest")
object DbTest extends Tag("com.mycompany.tags.DbTest")

class TutorialTest extends AsyncFunSpec with Matchers {
  describe("jQuery") {
    it("get the content of HTML by using get function.") {
      val promise = Promise[dom.Event]

      val location = window.location

      val href = window.location.href
      val jquery = jQuery

      jquery.get(href, null, (e: dom.Event) => {
        promise.success(e)
      })

      for { event <- promise.future} yield {
        event should not be (null)
      }
    }
  }
}