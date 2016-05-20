package com.github.uryyyyyyy.scalajs.useLibrary.myModule

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

@JSName("MyModule")
@js.native
class MyModule extends js.Object{

  def ping(str:String): String = js.native

  def count(): Int = js.native

}
