package day4.battleships

object Main extends App {

  val player1 = new Board
  val player2 = new Board
  player1.addShip(3,1,1,"right")
  //player1.printGrid()
  player2.addShip(4,1,1,"right")
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
        board.printSecret()
      }
    }
  }


  def core():Unit = {
    while (!player1.lose && !player2.lose) {
      println("Player 1 to shoot: ")
      player2.printGrid()
      if (player2.shoot(scala.io.StdIn.readLine("Y coord: ").toInt, scala.io.StdIn.readLine("X coord: ").toInt)) {
        core()
      }
      else {
        println("Player 2 to shoot: ")
        player1.printGrid()
        if (player1.shoot(scala.io.StdIn.readLine("Y coord: ").toInt, scala.io.StdIn.readLine("X coord: ").toInt)) {
          core2()
        }
      }
    }
    if (player1.lose()) {println("Player 2 wins, congrats")
      println("Winner's board: ")
      player2.printSecret()}
    else { println("Player 1 wins, congrats")
      println("Winner's board: ")
      player1.printSecret()}
  }

  def core2():Unit = {
    while (!player1.lose && !player2.lose) {
      println("Player 2 to shoot: ")
      player1.printGrid()
      if (player1.shoot(scala.io.StdIn.readLine("Y coord: ").toInt, scala.io.StdIn.readLine("X coord: ").toInt)) {
        core2()
      }
      else {
        core()
      }
    }
    if (player1.lose()) {println("Player 2 wins, congrats")
      println("Winner's board: ")
      player2.printSecret()}
    else { println("Player 1 wins, congrats")
      println("Winner's board: ")
      player1.printSecret()}
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

   core()
 }

  core()
}
