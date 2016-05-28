package services

import javax.inject.{Inject, Singleton}

import domains.{Repository, User}
import play.api.libs.ws.WSClient

import scala.concurrent.{ExecutionContext, Future}
import utils.JsonUtility._

/**
  * Created by anand on 5/28/16.
  */
@Singleton
class GitHubService @Inject()(ws: WSClient)(implicit exec: ExecutionContext) {

  val GITHUB_BASE_URL = "https://api.github.com/users/"

  def fetchData(login: String): Future[(User, List[Repository])] = {
    for {
      user <- ws.url(s"${GITHUB_BASE_URL}${login}").get()
      repos <- ws.url(s"${GITHUB_BASE_URL}${login}/repos").get()
    } yield {
      (user.json.as[User], repos.json.as[List[Repository]])
    }
  }

}
