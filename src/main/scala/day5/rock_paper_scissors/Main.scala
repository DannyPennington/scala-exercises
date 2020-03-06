package day5.rock_paper_scissors
import scala.util.Random

/* Challenge breakdown
 * 1) Ask user for their choice
 * 2) Get AI to make choice
 * 3) Compare choices to see who wins
 * MVP
 * 4) Weight AI choice based on previous player choices

 */
object Main extends App {
  val weights = Array(2,2,2,2,2)
  var wins = 0
  var losses = 0

  def userChoice():String ={
    scala.io.StdIn.readLine("Rock, Paper, Scissors, Lizard, Spock? ").toString
  }

  def validate(choice:String):Boolean = {
    choice match {
      case "Rock" | "rock" => true
      case "Paper" | "paper" => true
      case "Scissors" | "scissors" => true
      case "Lizard" | "lizard" => true
      case "Spock" | "spock" => true
      case _ => false
    }
  }

  def aiChoice(): String = {
    val choices = Array("Rock", "Paper", "Scissors", "Lizard", "Spock")
    choices(Random.nextInt(choices.length))
  }

  def weightedAI(weights: Array[Int]): String = {
    var num = Random.nextInt(weights.sum)
    val choices = Array("Rock", "Paper", "Scissors", "Lizard", "Spock")
    for (i <- 0 until 5) {
      num -= weights(i)
      if (num <= 0) {
        return choices(i)
      }
    }
    "Spock"
  }

  def rock(other: String, weight:Array[Int]):Unit = {
    weight(1) +=1
    weight(4) +=1
    other match {
      case "Rock" => println("It's a tie!")
      case "Paper" => println("Paper covers Rock!"); losses += 1
      case "Scissors" => println("Rock crushes scissors"); wins += 1
      case "Lizard" => println("Rock crushes Lizard!"); wins += 1
      case "Spock" => println("Spock vaporizes Rock!"); losses += 1
      case _ => println("Something went wrong...")
    }
  }

  def paper(other: String, weight:Array[Int]):Unit = {
    weight(2) +=1
    weight(3) +=1
    other match {
      case "Rock" => println("Paper covers Rock!"); wins += 1
      case "Paper" => println("It's a tie!")
      case "Scissors" => println("Scissors cut paper"); losses += 1
      case "Lizard" => println("Lizard eats Paper"); losses += 1
      case "Spock" => println("Paper disproves spock"); wins += 1
      case _ => println("Something went wrong...")
    }
  }

  def scissors(other: String, weight:Array[Int]):Unit = {
    weight(0) +=1
    weight(4) +=1
    other match {
      case "Rock" => println("Rock crushes Scissors!"); losses += 1
      case "Paper" => println("Scissors cut Paper!"); wins += 1
      case "Scissors" => println("It's a tie!")
      case "Lizard" => println("Scissors decapitate Lizard!"); wins += 1
      case "Spock" => println("Spock smashes scissors!"); losses += 1
      case _ => println("Something went wrong...")
    }
  }

  def lizard(other: String, weight:Array[Int]):Unit = {
    weight(0) +=1
    weight(2) +=1
    other match {
      case "Rock" => println("Rock crushes Lizard!"); losses += 1
      case "Paper" => println("Lizard eats Paper!"); wins += 1
      case "Scissors" => println("Scissors decapitate Lizard!"); losses += 1
      case "Lizard" => println("It's a tie!")
      case "Spock" => println("Lizard poisons Spock!"); wins += 1
      case _ => println("Something went wrong...")
    }
  }

  def spock(other: String, weight:Array[Int]):Unit = {
    weight(1) +=1
    weight(3) +=1
    other match {
      case "Rock" => println("Spock vaporizes Rock!"); wins += 1
      case "Paper" => println("Paper disproves Spock!"); losses += 1
      case "Scissors" => println("Spock smashes Scissors!"); wins += 1
      case "Lizard" => println("Lizard poisons Spock"); losses += 1
      case "Spock" => println("It's a tie")
      case _ => println("Something went wrong...")
    }
  }

  def resolve(user: String, ai: String, weights: Array[Int]):Unit = {
    user match {
      case "Rock" | "rock" => rock(ai, weights)
      case "Paper" | "paper" => paper(ai, weights)
      case "Scissors" | "scissors" => scissors(ai, weights)
      case "Lizard" | "lizard" => lizard(ai, weights)
      case "Spock" | "spock" => spock(ai, weights)
    }
  }

  @scala.annotation.tailrec
  def play():Unit = {
    val choice = userChoice()
    if (validate(choice)) {
      resolve(choice, weightedAI(weights), weights)
      println("")
      print(s"Wins: $wins   Losses: $losses")
      playAgain()
    }
    else {
        println("Please enter valid choice")
        play()
      }
  }

  def playAgain():Unit = {
    println("")
    if (scala.io.StdIn.readLine("Play again? ") == "y" ) {
      play()
    }
  }

  def testing(weights:Array[Int]): Unit = {
    println(weights.mkString(" "))
  }
  play()
}
