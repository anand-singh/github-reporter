package utils

import domains.{Repository, User}
import play.api.libs.json.Json

/**
  * Created by anand on 5/25/16.
  */
object JsonUtility {

  implicit val userFormat = Json.format[User]
  implicit val repoFormat = Json.format[Repository]

}
