package com.github.uryyyyyyy.scalajs.useLibrary.react.router

sealed trait MyPages
case object Home                      extends MyPages
case object Search                    extends MyPages
case object Products                  extends MyPages
case object Products2                  extends MyPages
case class ProductInfo(id: Int) extends MyPages
case class ProductInfo2(id: Int) extends MyPages