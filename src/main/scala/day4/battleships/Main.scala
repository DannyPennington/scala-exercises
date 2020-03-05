package day4.battleships

import javafx.scene.control.skin.TextInputControlSkin.Direction

import scala.collection.mutable.ArrayBuffer

object Main extends App {


  val player1 = new Board
  val player2 = new Board
  //player1.addShip(3,1,1,"right")
  //player1.printGrid()
  //player1.addShip(4,1,1,"right")
  //player1.shoot(y=1,x=1)
  //player1.shoot(y=1,x=2)
  //player1.shoot(y=1,x=3)
  //player1.shoot(y=5,x=5)

  //println(player1.lose())
  def shipSetup(board: Board): Unit = {
    for (i <- 1 to 5) {
      board.addShip(scala.io.StdIn.readLine(s"Enter ship $i length: ").toInt, scala.io.StdIn.readLine("Enter starting y coord: ").toInt, scala.io.StdIn.readLine("Enter starting x coord: ").toInt, scala.io.StdIn.readLine("Enter ship direction: ").toString)
      board.printGrid()
    }
  }
  player2.printGrid()
  shipSetup(player2)
  player2.printGrid()

 def play():Unit = {
   val player1 = new Board
   val player2 = new Board


 }
}
