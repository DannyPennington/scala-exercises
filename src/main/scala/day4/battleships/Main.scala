package day4.battleships

import javafx.scene.control.skin.TextInputControlSkin.Direction

import scala.collection.mutable.ArrayBuffer

object Main extends App {

  def createGrid(size:Int): Array[Array[String]] = {
    var arr = Array.ofDim[String](size,size)
    for (i <- 0 until size) {
      for (j <- 0 until size) {
        arr(i)(j) = " 0 "
      }
    }
    arr
  }

  def printGrid(grid:Array[Array[String]], size:Int=12):Unit = {
    print("      A  B  C  D  E  F  G  H  I  J  K  L")
    println("")
    for (i <- 0 until size) {
      if (i < 9) {print(s"  ${i+1}  ")}
      else {print(s"  ${i+1} ")}
      grid(i).foreach(print)
      println("")
    }
  }

  def addShip(board: Array[Array[String]],length:Int, y:Int, x:Int, direction: String): Array[Array[String]]= {
    board(y-1)(x-1) = " 1 "
    direction match {
      case "up" | "Up" => {for (i <- 1 to length) {board(y-i)(x-1) = " 1 "}}
      case "down" | "Down" => {for (i <- 1 to length) {board(y+i-2)(x-1) = " 1 "}}
      case "left" | "Left" => {for (i <- 1 to length) {board(y-1)(x-i) = " 1 "}}
      case "right" | "Right" => {for (i <- 1 to length) {board(y-1)(x+i-2) = " 1 "}}
    }
    board
  }

  var board = createGrid(12)
  printGrid(addShip(board,3,2,10,"right"))

}
