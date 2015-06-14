package com.example

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._
import org.scalajs.dom._
import upickle._

import scala.scalajs.js.Dynamic.{global => g}
import scala.scalajs.js.JSApp

object TutorialApp extends JSApp {
  def main(): Unit = {
    g.console.log("Hello world!")
    val s = Sample(1, "nama")
    val json = write(s)
    g.console.log(json)

    val value = read[Sample](json)
    g.console.log(value.toString)


    val HelloMessage = ReactComponentB[String]("HelloMessage")
      .render(name => <.div(^.onClick ==> hello, "Hello " + name))
      .build

    val ei = EitherSample.eitherL()
    EitherSample.match_(ei)
    val ei2 = EitherSample.eitherR()
    EitherSample.match_(ei2)

    val dao = DaoFactory.getDao()
    g.console.log(dao.getStr())

    React.render(HelloMessage("John"), document.body)

  }

  case class Sample(id:Long, name:String)

  private def hello(e: ReactEventI): Unit = {
    g.console.log("Hello world!")
  }
}


object EitherSample {

  def eitherL(): Either[Int, String] ={
    Left(2)
  }

  def eitherR(): Either[Int, String] ={
    Right("error")
  }

  def match_ (ei: Either[Int, String]): Unit ={
    ei match{
      case Left(v) => g.console.log("left" + v)
      case Right(v) => g.console.log("right" + v)
    }
  }

}

object DaoFactory extends JSApp{
  var mode:String = null
  def main() = {
    this.mode = "dao1"
  }
  def getDao():DaoSample = {
    if(mode == "dao1"){
      DaoSample1
    }else{
      DaoSample2
    }
  }
}

trait DaoSample {
  def getStr():String
}

object DaoSample1 extends DaoSample{
  def getStr():String = {
    g.console.log("dao1 injected")
    "dao1"
  }
}

object DaoSample2 extends DaoSample{
  def getStr():String = {
    g.console.log("dao2 injected")
    "dao2"
  }
}