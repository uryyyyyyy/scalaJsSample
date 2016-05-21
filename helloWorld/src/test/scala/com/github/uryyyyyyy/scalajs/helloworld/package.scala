package com.github.uryyyyyyy.scalajs

package object helloworld {
  import org.scalatest.Tag

  object SlowTest extends Tag("SlowTest")
  object DbTest extends Tag("DbTest")
  object NormalTest extends Tag("NormalTest")
  object AsyncTest extends Tag("AsyncTest")
}

