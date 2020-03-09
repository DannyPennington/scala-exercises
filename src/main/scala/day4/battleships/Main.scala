package day4.battleships
import scala.util.Random

object Main extends App {
  val player1 = new Board
  val player2 = new Board
  def test():Unit = {
    player1.addShip(3,2,2,"right")
    player2.addShip(4,5,5,"right")
    core()
  }

  def shipSetup(board: Board): Unit = {
    var ships = 1
    while (ships<6) {
      if (board.addShip(scala.io.StdIn.readLine(s"Enter ship $ships length: ").toInt, scala.io.StdIn.readLine("Enter starting y coord: ").toInt, scala.io.StdIn.readLine("Enter starting x coord: ").toInt, scala.io.StdIn.readLine("Enter ship direction (up/down/left/right): ").toString)) {
        ships += 1
        board.printEither(board.arr)
      }
    }
  }

  def aiSetup(board:Board):Unit = {
    var ships = 1
    val directions = List("up", "down", "left", "right")
    while (ships < 6)
      ships match {
        case 1 => if (board.addShip (2, Random.nextInt (11) + 1, Random.nextInt (11) + 1, directions (Random.nextInt (4) ) ) ) {ships +=1} else {}
        case 2 => if (board.addShip (3, Random.nextInt (11) + 1, Random.nextInt (11) + 1, directions (Random.nextInt (4) ) ) ) {ships +=1} else {}
        case 3 => if (board.addShip (4, Random.nextInt (11) + 1, Random.nextInt (11) + 1, directions (Random.nextInt (4) ) ) ) {ships +=1} else {}
        case 4 => if (board.addShip (5, Random.nextInt (11) + 1, Random.nextInt (11) + 1, directions (Random.nextInt (4) ) ) ) {ships +=1} else {}
        case 5 => if (board.addShip (7, Random.nextInt (11) + 1, Random.nextInt (11) + 1, directions (Random.nextInt (4) ) ) ) {ships +=1} else {}
      }
  }

  def core():Unit = {
    while (!player1.lose && !player2.lose) {
      println("Player 1 to shoot: ")
      player2.printEither(player2.visarr)
      if (player2.shoot(scala.io.StdIn.readLine("Y coord: ").toInt, scala.io.StdIn.readLine("X coord: ").toInt)) {
        core()
      }
      else {
        println("Player 2 to shoot: ")
        player1.printEither(player1.visarr)
        if (player1.shoot(scala.io.StdIn.readLine("Y coord: ").toInt, scala.io.StdIn.readLine("X coord: ").toInt)) {
          core2()
        }
      }
    }
  }

  def core2():Unit = {
    while (!player1.lose && !player2.lose) {
      println("Player 2 to shoot: ")
      player1.printEither(player1.visarr)
      if (player1.shoot(scala.io.StdIn.readLine("Y coord: ").toInt, scala.io.StdIn.readLine("X coord: ").toInt)) {
        core2()
      }
      else {
        core()
      }
    }
  }

  def play():Unit = {
   println("Player 2 look away while player 1 sets up ships!")
   shipSetup(player1)
   for (i <- 0 to 12) {println("")}
   println("Now player 1 look away while player 2 sets up ships!")
   Thread.sleep(3000)
   shipSetup(player2)

   core()
    if (player1.lose) {println("Player 2 wins, congrats")
      println("Winner's board: ")
      player2.printEither(player2.arr)}
    else { println("Player 1 wins, congrats")
      println("Winner's board: ")
      player1.printEither(player1.arr)}
  }

  def aiPlay():Unit = {
    println("Set up your board!")
    shipSetup(player1)
  }


  aiSetup(player2)
  player2.printEither(player2.arr)
}
