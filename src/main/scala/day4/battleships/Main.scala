package day4.battleships

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
    if (player1.lose()) {println("Player 2 wins, congrats")
      println("Winner's board: ")
      player2.printEither(player2.arr)}
    else { println("Player 1 wins, congrats")
      println("Winner's board: ")
      player1.printEither(player1.arr)}
 }
  play()
}
