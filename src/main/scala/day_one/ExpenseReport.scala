package day_one

import utils.ReadUtils.readFromResources


object ExpenseReport extends App{

  val expenseList: List[String] = readFromResources( "day_one.txt").toList

  val expenseListOfInt = expenseList.map(_.toInt)

  for {
    current <- expenseListOfInt
    suivant <- expenseListOfInt.drop(1)
    suivantSuivant <- expenseListOfInt.drop(2)

  } yield if ((current + suivant + suivantSuivant) == 2020) {
    println(s"Value found : ${current * suivant * suivantSuivant}")
  }



}

