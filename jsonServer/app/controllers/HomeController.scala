package controllers

import javax.inject._

import play.api._
import play.api.libs.json.Json
import play.api.mvc._
import tutorial.webapp.{Sample, Sample2}
import upickle.default._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject() extends Controller {

  /**
   * Create an Action to render an HTML page with a welcome message.
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def json = Action {
    val rawStr = """{"id":1,"name":"waha"}"""
    val sample = read[Sample](rawStr)
    val json = write(sample)
    Ok(json)
  }

  def json2 = Action {
    val rawStr = """{"id":1,"sample":{"id":1,"name":"waha"}}"""
    val sample2 = read[Sample2](rawStr)
    val json2 = write(sample2)
    Ok(json2)
  }

  def json3 = Action {request =>
    val rawStr = request.body.asJson.get.toString()
    val sample2 = read[Sample2](rawStr)
    val json2 = write(sample2)
    Ok(json2)
  }

}
