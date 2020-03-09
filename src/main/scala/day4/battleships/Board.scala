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
      false
    }
  }

  def addShip(length: Int, y: Int, x: Int, direction: String): Boolean = {
    if (checkValid(y, x)) {
      direction match {
        case "up" | "Up" => if (y-length>=1) {for (i <- 1 to length) {
          if (checkValid(y-i,x)){
          arr(y - i)(x - 1) = " 1 "
        }}}
        else {arr(y - 1)(x - 1) = " ~ "
        return false
        }
        case "down" | "Down" => if (y+length <=12) {for (i <- 1 to length) {
          if (checkValid(y+i,x)) {
          arr(y + i - 2)(x - 1) = " 1 "
        }}}
        else {arr(y - 1)(x - 1) = " ~ "
        return false
        }
        case "left" | "Left" => if (x-length>=1) {for (i <- 1 to length) {
          if (checkValid(y,x-i)) {
          arr(y - 1)(x - i) = " 1 "
        }}}
        else {arr(y - 1)(x - 1) = " ~ "
        return false
        }
        case "right" | "Right" => if (x+length<=12) {for (i <- 1 to length) {
          if (checkValid(y,x+i)) {
          arr(y - 1)(x + i - 2) = " 1 "
        }}}
        else {
          arr(y - 1)(x - 1) = " ~ "
          return false
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