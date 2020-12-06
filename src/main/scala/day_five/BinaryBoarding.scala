package day_five

import utils.MyUtils.{isConsecutive, readFromResources}

object BinaryBoarding extends App {

  def takeLowerHalf(in: List[Int]): List[Int] = {
    in.slice(0, (in.length / 2))
  }

  def takeUpperHalf(in: List[Int]): List[Int] = {
    in.slice(in.length / 2, in.length)
  }

  val plane = (0 to 127).toList
  val seats = (0 to 7).toList
  val boardingPasses: List[String] = readFromResources("day_five.txt").toList

  def splitPlane(plane: List[Int], boardingPass: String): List[Int] = {
    val letter = boardingPass.headOption.getOrElse("")
    if (letter == 'F') {
      takeLowerHalf(plane)
    } else if (letter == 'B') {
      takeUpperHalf(plane)
    }
    else {
      Nil
    }
  }

  def splitRows(row: List[Int], boardingPass: String): List[Int] = {
    val letter = boardingPass.headOption.getOrElse("")
    if (letter == 'L') {
      takeLowerHalf(row)
    } else if (letter == 'R') {
      takeUpperHalf(row)
    }
    else {
      Nil
    }
  }

  def findRow(plane: List[Int], boardingPass: List[String]): List[Int] = {
    if (boardingPass.isEmpty || plane.drop(1).isEmpty) {
      plane
    } else {
      findRow(
        splitPlane(plane, boardingPass.headOption.getOrElse("")),
        boardingPass.tail)
    }
  }

  def findSeat(row: List[Int], boardingPass: List[String]): List[Int] = {
      if (boardingPass.isEmpty || row.drop(1).isEmpty) {
      row
    } else {
      findSeat(
        splitRows(row, boardingPass.headOption.getOrElse("")),
        boardingPass.tail)
    }
  }


  val listOfSeatsFromBoardingPasses: Seq[(Int, Int)] =  boardingPasses.map{ boardingPass =>
    val row: Int = findRow(plane,boardingPass.toList.map(_.toString).take(7)).headOption.getOrElse(0)
    val seat: Int = findSeat(seats,boardingPass.toList.map(_.toString).drop(7)).headOption.getOrElse(0)
(row,seat)
  }

  val listIDs = listOfSeatsFromBoardingPasses.map(tuple =>tuple._1*8+tuple._2).toList.sorted

  val resultPart2 = isConsecutive(listIDs,0)
  println(s"listIDs : ${listIDs}")

  println(s"resultPart1 : ${listIDs.max}")
  println(s"resultPart2 : ${resultPart2}")



}
