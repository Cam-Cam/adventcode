package day_three

case class Coordinates(
                        x: Int = 0,
                        y: Int = 0
                      )

object Coordinates {

  def move(currentCoordinates: Coordinates): Coordinates = {
    Coordinates(currentCoordinates.x + 3, currentCoordinates.y + 1)
  }

}
