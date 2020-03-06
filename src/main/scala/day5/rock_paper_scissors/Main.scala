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

  def rock(other: String):Unit = {
    other match {
      case "Rock" => println("It's a tie!")
      case "Paper" => println("Paper covers Rock!")
      case "Scissors" => println("Rock crushes scissors")
      case "Lizard" => println("Rock crushes Lizard!")
      case "Spock" => println("Spock vaporizes Rock!")
      case _ => println("Something went wrong...")
    }
  }

  def paper(other: String):Unit = {
    other match {
      case "Rock" => println("Paper covers Rock!")
      case "Paper" => println("It's a tie!")
      case "Scissors" => println("Scissors cut paper")
      case "Lizard" => println("Lizard eats Paper")
      case "Spock" => println("Paper disproves spock")
      case _ => println("Something went wrong...")
    }
  }

  def scissors(other: String):Unit = {
    other match {
      case "Rock" => println("Rock crushes Scissors!")
      case "Paper" => println("Scissors cut Paper!")
      case "Scissors" => println("It's a tie!")
      case "Lizard" => println("Scissors decapitate Lizard!")
      case "Spock" => println("Spock smashes scissors!")
      case _ => println("Something went wrong...")
    }
  }

  def lizard(other: String):Unit = {
    other match {
      case "Rock" => println("Rock crushes Lizard!")
      case "Paper" => println("Lizard eats Paper!")
      case "Scissors" => println("Scissors decapitate Lizard!")
      case "Lizard" => println("It's a tie!")
      case "Spock" => println("Lizard poisons Spock!")
      case _ => println("Something went wrong...")
    }
  }

  def spock(other: String):Unit = {
    other match {
      case "Rock" => println("Spock vaporizes Rock!")
      case "Paper" => println("Paper disproves Spock!")
      case "Scissors" => println("Spock smashes Scissors!")
      case "Lizard" => println("Lizard poisons Spock")
      case "Spock" => println("It's a tie")
      case _ => println("Something went wrong...")
    }
  }


  def resolve(user: String, ai: String):Unit = {
    user match {
      case "Rock" | "rock" => rock(ai)
      case "Paper" | "paper" => paper(ai)
      case "Scissors" | "scissors" => scissors(ai)
      case "Lizard" | "lizard" => lizard(ai)
      case "Spock" | "spock" => spock(ai)
    }
  }

  @scala.annotation.tailrec
  def play():Unit = {
    val choice = userChoice()
    if (validate(choice)) {
      resolve(choice, aiChoice())
      playAgain()
    }
    else {
        println("Please enter valid choice")
        play()
      }
  }

  def playAgain():Unit = {
    println("")
    if (scala.io.StdIn.readLine("Play again? ") == "yes") {
      play()
    }
  }

  play()
}
