package com.github.uryyyyyyy.scalajs.helloworld

import org.scalajs.dom
import org.scalajs.dom.window
import org.scalajs.jquery.jQuery
import org.scalatest._

import scala.concurrent.Promise
import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue

class AsyncScalaTest extends FunSpec with Matchers {
  describe("jQuery") {
    it("get the content of HTML by using get function.", NormalTest) {
      val promise = Promise[dom.Event]

      jQuery.get(window.location.href, null, (e: dom.Event) => {
        promise.success(e)
      })

      for {event <- promise.future} yield {
        event should not be (null)
      }
    }
  }

}