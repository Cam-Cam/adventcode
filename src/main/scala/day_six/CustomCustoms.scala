package day_six

import utils.MyUtils.readFromResources

object CustomCustoms extends App {

  val answers = readFromResources("day_six.txt")

  val groupedAnswers = answers.foldLeft("") {
    (acc, passport) => if (passport == " ") acc else acc ++ " " ++ passport
  }.split("  ").toList.map(
    _.split(" ").toList.filterNot(_ == "")
  )

  val groupedAnswersToList = groupedAnswers.map(_.flatMap(_.toList))

  val groupedAnswerDistinct = groupedAnswersToList.map(_.distinct)

  val numPeoplePerGroup = groupedAnswers.map(_.length)

  val occurencesPerGroupedAnswers = groupedAnswersToList.map(occurences)

  val zipped = numPeoplePerGroup zip occurencesPerGroupedAnswers

  val occurencesToKeep = zipped.map { tuple =>
    tuple._2.filter(_._2 == tuple._1).keys.toList
  }


  def occurences(in: List[Char]): Map[Char, Int] = {
    in.groupBy(identity).map { tuple =>
      (tuple._1, tuple._2.size)
    }
  }


  println(s"resultPart1 : ${groupedAnswerDistinct.map(_.length).sum}")
  println(s"resultPart2 : ${occurencesToKeep.map(_.length).sum}")


}
