package com.github.uryyyyyyy.scalajs.useLibrary.json

import org.scalajs.dom

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object AjaxClient {
  def get(url: String): Future[String] = {
    dom.ext.Ajax.get(
      url = url,
      responseType = "application/json",
      headers = Map("Content-Type" -> "application/json")
    ).map(r => r.response.asInstanceOf[String])
  }

  def post(body: String): Future[String] = {
    dom.ext.Ajax.post(
      data = body,
      url = "/",
      responseType = "application/json",
      headers = Map("Content-Type" -> "application/json")
    ).map(r => r.response.asInstanceOf[String])
  }
}