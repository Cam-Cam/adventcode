package utils

import java.io.InputStream
import scala.io.Codec
import scala.util.{Failure, Success, Try}

object ResourceUtils {

  def getLinesFromResources(resourceName: String): List[String] = {
    val stream: InputStream = getClass.getResourceAsStream(resourceName)

    val result: List[String] = Try(scala.io.Source.fromInputStream(stream)(Codec.UTF8).getLines) match {
      case Success(value) =>
        value.toList
      case Failure(exception) =>
        exception.printStackTrace()
        List()
    }
    stream.close()
    result
  }
}
