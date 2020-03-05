package day4.battleships

import javafx.scene.control.skin.TextInputControlSkin.Direction

import scala.collection.mutable.ArrayBuffer

object Main extends App {


  val player1 = new Board
  val player2 = new Board
  player1.addShip(player1.arr,3,1,1,"right")
  player1.shoot(y=1,x=1)
  player1.shoot(y=1,x=2)
  //player1.shoot(y=1,x=3)
  player1.shoot(y=5,x=5)
  player1.printGrid()
  println(player1.lose())

 def play():Unit = {
   val player1 = new Board
   val player2 = new Board

 }
}
