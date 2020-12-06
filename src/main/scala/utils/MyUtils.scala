package utils

import scala.io.Source.fromResource

object MyUtils {

  def readFromResources(resource: String): Seq[String] =
    fromResource(resource).getLines.toSeq

  def isConsecutive(in: List[Int], res:Int): Int = in match {
    case a::b::_  => {
      if (a+1==b) isConsecutive(in.tail, res) else isConsecutive(in.tail, a)
    }
    case _::tail => isConsecutive(tail, res)
    case _ => res +1
  }

}