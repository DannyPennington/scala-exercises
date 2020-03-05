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
    var ships = 1
    while (ships<6) {
      if (board.addShip(scala.io.StdIn.readLine(s"Enter ship $ships length: ").toInt, scala.io.StdIn.readLine("Enter starting y coord: ").toInt, scala.io.StdIn.readLine("Enter starting x coord: ").toInt, scala.io.StdIn.readLine("Enter ship direction (up/down/left/right): ").toString)) {
        ships += 1
        board.printGrid()
      }
    }
  }


 def play():Unit = {
   val player1 = new Board
   val player2 = new Board
   println("Player 2 look away while player 1 sets up ships!")
   shipSetup(player1)
   for (i <- 0 to 12) {println("")}
   println("Now player 1 look away while player 2 sets up ships!")
   Thread.sleep(3000)
   shipSetup(player2)


 }

  play()
}
