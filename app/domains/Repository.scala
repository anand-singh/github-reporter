package domains

import play.api.libs.json.{JsValue, Json}
import utils.JsonUtility._

/**
  * Created by anand on 5/28/16.
  */
case class Repository
(
  id: Long,
  name: String,
  full_name: String,
  html_url: String,
  description: String,
  language: Option[String],
  forks: Long,
  watchers: Long,
  size: Long,
  created_at: String,
  updated_at: String
) {

  def toJson: JsValue = Json.toJson(this)

  def toJsonString: String = toJson.toString()

}
