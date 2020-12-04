package day_three

import org.scalatest.flatspec.AnyFlatSpec


class TobogganTrajectoryTests extends AnyFlatSpec {

  val testTreeMap: TreeMap = TreeMap(
  maxX = 31,
    myTreeMap = Array(".............#...#....#.....##.",".#...##.........#.#.........#.#")
  )

  "A coordinates outside of the TreeMap on the X" should "return true" in {
    val in : Coordinates = Coordinates(x=33,y=1)
    val treeMap:Array[String] = Array(".............#...#....#.....##.",".#...##.........#.#.........#.#")
    assert(Something.isFinishedOnXAxis(in,testTreeMap),true)
  }

  "A coordinates outside of the TreeMap on the Y" should "return true" in {
    val in : Coordinates = Coordinates(x=2,y=3)
    val treeMap:Array[String] = Array(".............#...#....#.....##.",".#...##.........#.#.........#.#")
    assert(Something.isFinishedOnYAxis(in,testTreeMap),true)
  }

  "A coordinates that contains a tree" should "return true" in {
    val coordinates : Coordinates = Coordinates(x=1,y=1)
    val treeMap:Array[String] = Array(".............#...#....#.....##.",".#...##.........#.#.........#.#")
    assert(Something.isTree(coordinates, testTreeMap), true)
  }


}
