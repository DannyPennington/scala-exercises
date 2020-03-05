package day4.battleships

class Board() {
  val arr: Array[Array[String]] = Array.ofDim[String](12, 12)
  var visarr: Array[Array[String]]  = Array.ofDim[String](12, 12)
  for (i <- 0 until 12) {
    for (j <- 0 until 12) {
      visarr(i)(j) = " ~ "
      arr(i)(j) = " ~ "
    }
  }

  def printGrid(size: Int = 12): Unit = {
    print("      A  B  C  D  E  F  G  H  I  J  K  L")
    println("")
    for (i <- 0 until size) {
      if (i < 9) {
        print(s"  ${i + 1}  ")
      }
      else {
        print(s"  ${i + 1} ")
      }
      visarr(i).foreach(print)
      println("")
    }
    println("")
  }
  def printSecret(size: Int = 12): Unit = {
    print("      A  B  C  D  E  F  G  H  I  J  K  L")
    println("")
    for (i <- 0 until size) {
      if (i < 9) {
        print(s"  ${i + 1}  ")
      }
      else {
        print(s"  ${i + 1} ")
      }
      arr(i).foreach(print)
      println("")
    }
    println("")
  }

  def checkValid(y:Int, x:Int):Boolean = {
    if (arr(y-1)(x-1) == " ~ ") {
      true
    }
    else {
      println("Please enter a valid selection!")
      println("")
      false
    }
    }

  def addShip(length: Int, y: Int, x: Int, direction: String): Boolean = {
    var temp_arr = arr
    if (checkValid(y,x)){
      temp_arr(y - 1)(x - 1) = " 1 "
      direction match {
        case "up" | "Up" => for (i <- 1 to length) {temp_arr(y - i)(x - 1) = " 1 "}
        case "down" | "Down" => for (i <- 1 to length) {temp_arr(y + i - 2)(x - 1) = " 1 "}
        case "left" | "Left" => for (i <- 1 to length) {temp_arr(y - 1)(x - i) = " 1 "}
        case "right" | "Right" => for (i <- 1 to length) {temp_arr(y - 1)(x + i - 2) = " 1 "}
        case _ =>
          temp_arr(y - 1)(x - 1) = " ~ "
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

  def shoot(y:Int, x:Int ):Boolean = {
    if (arr(y-1)(x-1) == " 1 ") {
      println("That's a hit")
      visarr(y-1)(x-1) = " X "
      arr(y-1)(x-1) = " X "
      true
    }
    else{ println("You missed")
      visarr(y-1)(x-1) = " O "
      false
    }

  }

  def lose():Boolean = {

    for (i <- 0 until 12) {
      for (j <- 0 until 12) {
        if (arr(i)(j) == " 1 ") {
          return false
        }
      }
    }
  true
  }
}
