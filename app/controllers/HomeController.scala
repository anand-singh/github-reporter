package controllers

import javax.inject._

import play.api._
import play.api.mvc._
import services.GitHubService

import scala.concurrent.ExecutionContext
import scala.util.control.NonFatal

/**
  * This controller creates an `Action` to handle HTTP requests to the
  * application's home page.
  */
@Singleton
class HomeController @Inject()(service: GitHubService)(implicit exec: ExecutionContext) extends Controller {

  /**
    * Create an Action to render an HTML page with a welcome message.
    * The configuration in the `routes` file means that this method
    * will be called when the application receives a `GET` request with
    * a path of `/`.
    */
  def index(login: String) = Action.async {
    service.fetchData(login).map { case (user, repos) =>
      println(s"User : ${user}, repos: ${repos.size}")
      Ok(views.html.index(user, repos))
    }.recover { case NonFatal(t: Throwable) => Ok(views.html.error("Please check your GitHub login id!!!")) }
  }

}
