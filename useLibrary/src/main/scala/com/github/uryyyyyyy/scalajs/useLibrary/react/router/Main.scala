package com.github.uryyyyyyy.scalajs.useLibrary.react.router

import com.github.uryyyyyyy.scalajs.useLibrary.react.components.{MyComponent, MyComponent2, MyComponent3}
import japgolly.scalajs.react.ReactDOM
import japgolly.scalajs.react.extra.router.StaticDsl.Route
import japgolly.scalajs.react.extra.router._
import org.scalajs.dom
import org.scalajs.dom.document

import scala.scalajs.js.JSApp

object Main extends JSApp {
  def main(): Unit = {

    val routerConfig = RouterConfigDsl[MyPages].buildConfig { dsl =>
      import dsl._

      val r: Route[Int] = "#user" / int / "profile"
      val r2: Route[Int] = "#user2" / int / "profile"

      val fooPf:PartialFunction[MyPages, ProductInfo2] = { case v:ProductInfo2 => v}

      (emptyRule
        | staticRoute(root,     Home)  ~> render(MyComponent(MyComponent.Props(1)))
        | staticRoute("#hello",     Search)  ~> render(MyComponent(MyComponent.Props(2)))
        | staticRoute("#otherJS",     Products)  ~> render(MyComponent3())
        | staticRoute("#hello" / "hello",     Products2)  ~> render(MyComponent(MyComponent.Props(4)))
        | dynamicRouteCT(r.caseClass[ProductInfo])  ~> dynRender(v => MyComponent(MyComponent.Props(5)))
        | dynamicRoute(r2.caseClass[ProductInfo2])(fooPf)  ~> dynRenderR((v, ctr) => MyComponent2(MyComponent2.Props(ctr)))
        ) .notFound(redirectToPage(Home)(Redirect.Replace))
    }

    val baseUrl = BaseUrl(dom.window.location.href.takeWhile(_ != '#'))

    val router = Router(baseUrl, routerConfig)()

    ReactDOM.render(router, document.getElementById("content"))
  }
}

