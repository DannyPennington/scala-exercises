package day4.battleships

class Board() {
  val arr: Array[Array[String]] = Array.ofDim[String](12, 12)
  val visarr: Array[Array[String]] = Array.ofDim[String](12, 12)
  for (i <- 0 until 12) {
    for (j <- 0 until 12) {
      visarr(i)(j) = " ~ "
      arr(i)(j) = " ~ "
    }
  }

  def printEither(board: Array[Array[String]], size: Int = 12): Unit = {
    print("      A  B  C  D  E  F  G  H  I  J  K  L")
    println("")
    for (i <- 0 until size) {
      if (i < 9) {
        print(s"  ${i + 1}  ")
      }
      else {
        print(s"  ${i + 1} ")
      }
      board(i).foreach(print)
      println("")
    }
    println("")
  }

  def checkValid(y: Int, x: Int): Boolean = {
    if (arr(y - 1)(x - 1) == " ~ ") {
      true
    }
    else {
      println("Please enter a valid selection!")
      println("")
      false
    }
  }

  def addShip(length: Int, y: Int, x: Int, direction: String): Boolean = {
    if (checkValid(y, x)) {
      arr(y - 1)(x - 1) = " 1 "
      direction match {
        case "up" | "Up" => for (i <- 1 to length) {
          arr(y - i)(x - 1) = " 1 "
        }
        case "down" | "Down" => for (i <- 1 to length) {
          arr(y + i - 2)(x - 1) = " 1 "
        }
        case "left" | "Left" => for (i <- 1 to length) {
          arr(y - 1)(x - i) = " 1 "
        }
        case "right" | "Right" => for (i <- 1 to length) {
          arr(y - 1)(x + i - 2) = " 1 "
        }
        case _ =>
          arr(y - 1)(x - 1) = " ~ "
          println("Please enter a valid selection!")
          println("")
          return false
      }
    }
    else {
      return false
    }
    true
  }

  def shoot(y: Int, x: Int): Boolean = {
    if (arr(y - 1)(x - 1) == " 1 ") {
      println("That's a hit")
      visarr(y - 1)(x - 1) = " X "
      arr(y - 1)(x - 1) = " X "
      true
    }
    else {
      println("You missed")
      visarr(y - 1)(x - 1) = " 0 "
      arr(y - 1)(x - 1) = " 0 "
      false
    }
  }

  def lose: Boolean = {
    if (arr.flatMap(_.toList).contains(" 1 ")) false
    else true
  }
}