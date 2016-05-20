package com.github.uryyyyyyy.scalajs.useLibrary.myModule

import scala.scalajs.js.JSApp

object MyModuleMain extends JSApp {
  def main(): Unit = {
    println("useLibrary")

    val module = new MyModule()
    val str = module.ping("ping")
    println(str)

    val num = module.count()
    println(num)
    val num2 = module.count()
    println(num2)
  }
}
