package day4.battleships

class Board() {
  var arr: Array[Array[String]] = Array.ofDim[String](12, 12)
  for (i <- 0 until 12) {
    for (j <- 0 until 12) {
      arr(i)(j) = " ~ "
    }
  }

  def printGrid(grid: Array[Array[String]]= arr, size: Int = 12): Unit = {
    print("      A  B  C  D  E  F  G  H  I  J  K  L")
    println("")
    for (i <- 0 until size) {
      if (i < 9) {
        print(s"  ${i + 1}  ")
      }
      else {
        print(s"  ${i + 1} ")
      }
      grid(i).foreach(print)
      println("")
    }
    println("")
  }

  def addShip(board: Array[Array[String]], length: Int, y: Int, x: Int, direction: String): Array[Array[String]] = {
    board(y - 1)(x - 1) = " 1 "
    direction match {
      case "up" | "Up" => for (i <- 1 to length) {board(y - i)(x - 1) = " 1 "}
      case "down" | "Down" => for (i <- 1 to length) {board(y + i - 2)(x - 1) = " 1 "}
      case "left" | "Left" => for (i <- 1 to length) {board(y - 1)(x - i) = " 1 "}
      case "right" | "Right" => for (i <- 1 to length) {board(y - 1)(x + i - 2) = " 1 "}
    }
    board
  }

  def shoot(board: Array[Array[String]] = arr,y:Int, x:Int ):Boolean = {
    if (board(y-1)(x-1) == " 1 ") {
      println("That's a hit")
      board(y-1)(x-1) = " X "
      true
    }
    else{ println("You missed")
      board(y-1)(x-1) = " O "
      false
    }

  }

  def lose(board: Array[Array[String]] = arr):Boolean = {
    for (i <- 0 until 12) {
      for (j <- 0 until 12) {
        println(board(i)(j))
        if (board(i)(j) == " 1 ") {
          false
        }
        else {}
      }
    }
    true
  }
}
