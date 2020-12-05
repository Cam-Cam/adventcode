//package day_three
//
//import utils.ResourceUtils
//
//case class TreeMap(myTreeMap: Array[String], maxX: Int) {
//
//  def addNewTreeMap(currentTreeMap: TreeMap): TreeMap = {
//    val newTreeMap: Array[String] = currentTreeMap.myTreeMap ++ currentTreeMap.myTreeMap
//    TreeMap(
//      myTreeMap = myTreeMap,
//      maxX = updateMaxX(newTreeMap)
//    )
//
//  }
//
//  def updateMaxX(treeMap: Array[String]): Int = {
//    maxX + treeMap.headOption.map(_.length).getOrElse(0)
//  }
//}
//
//object Something {
//
//  def isFinishedOnXAxis(in: Coordinates, currentTreeMap: TreeMap): Boolean = {
//    if (in.x > currentTreeMap.maxX) {
//      true
//    } else {
//      false
//    }
//  }
//
//  def isFinishedOnYAxis(in: Coordinates, currentTreeMap: TreeMap): Boolean = {
//    val maxY: Int = currentTreeMap.myTreeMap.length
//    if (in.y >= maxY) {
//      true
//    } else {
//      false
//    }
//  }
//
//  def isTree(in: Coordinates, currentTreeMap: TreeMap): Boolean = {
//    val valueOnTreeMap: Option[Char] = currentTreeMap.myTreeMap(in.y).lift(in.x - 1)
//    if (valueOnTreeMap.contains('#')) {
//      true
//    } else {
//      false
//    }
//  }
//
//}
//
//
//object Main extends App {
//
//  def run(startCoordinates: Coordinates, treeMap: TreeMap, numberOfTrees: Int): Int = {
//println("|")
//    if (Something.isFinishedOnYAxis(startCoordinates, treeMap)) {
//      numberOfTrees
//    }
//    else if (Something.isFinishedOnXAxis(startCoordinates, treeMap)) {
//      val newTreeMap: TreeMap = treeMap.addNewTreeMap(treeMap)
//      val increasedCoordinates: Coordinates = Coordinates(startCoordinates.x + 3, startCoordinates.y + 1)
//      run(increasedCoordinates, newTreeMap, numberOfTrees)
//    }
//    else if (Something.isTree(startCoordinates, treeMap)) {
//      val newNumberOfTrees = numberOfTrees + 1
//      println("Tree found!")
//      println(s"coordinates : ${startCoordinates}")
//      println(s"numberOfTrees : ${newNumberOfTrees}")
//      println(s"${treeMap.myTreeMap(startCoordinates.y)}")
//      val increasedCoordinates: Coordinates = Coordinates(startCoordinates.x + 3, startCoordinates.y + 1)
//      run(increasedCoordinates, treeMap, newNumberOfTrees)
//    } else {
//
//      println("No tree found!")
//
//      println(s"coordinates : ${startCoordinates}")
//      println(s"numberOfTrees : ${numberOfTrees}")
//      println(s"${treeMap.myTreeMap(startCoordinates.y)}")
//
//      val increasedCoordinates: Coordinates = Coordinates(startCoordinates.x + 3, startCoordinates.y + 1)
//      run(increasedCoordinates, treeMap, numberOfTrees)
//
//    }
//  }
//
//  println("Starting the slope!")
//  val initialTreeMap: TreeMap= TreeMap(
//    maxX = 31,
//    myTreeMap = ResourceUtils.getLinesFromResources("/day_three.txt").toArray
//  )
//
//  val result = run(
//    startCoordinates = Coordinates(0, 1),
//    treeMap = initialTreeMap,
//    numberOfTrees = 0)
//  println(s"I encountered ${result} trees")
//}
//
