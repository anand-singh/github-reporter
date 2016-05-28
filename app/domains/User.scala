package domains

import play.api.libs.json.{JsValue, Json}
import utils.JsonUtility._

/**
  * Created by anand on 5/25/16.
  */
case class User
(
  id: Long,
  login: String,
  name: String,
  followers: Long,
  following: Long,
  public_repos: Long,
  html_url: String
) {

  def toJson: JsValue = Json.toJson(this)

  def toJsonString: String = toJson.toString()

}
