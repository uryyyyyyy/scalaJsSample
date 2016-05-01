package tutorial.webapp

import upickle.default._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.scalajs.js.JSApp
import scala.scalajs.js.annotation.JSExport

object TutorialApp extends JSApp {

  var serverUrl:String = ""

  def main(): Unit = {
    println("helloWorld")
    val sample = Sample(1, "waha")

    val json = write(sample)
    println(json)
    val value = read[Sample](json)
    println(value)

    val jsons = """{"id":1,"name":"hello"}"""
    val value_ = read[Sample](jsons)
    println(value_)


    val sample2 = Sample2(1, sample)

    val json2 = write(sample2)
    println(json2)
    val value2 = read[Sample2](json2)
    println(value2)

    val f = AjaxClient.get(this.serverUrl)
    f.map(v => {
      println(v)
      val ss = read[Sample2](v)
      println(ss)
    })

    // should not use Await.result
  }

  @JSExport
  def setMode(isProd: Boolean): Unit = {
    this.serverUrl = if(isProd){
      "http://localhost:9000/sample"
    }else{
      "http://localhost:8000/jsonClient/sample.json"
    }
  }
}