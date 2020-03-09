package day2.hangman

import scala.collection.mutable.ArrayBuffer
import scala.io.Source
/* Steps
* 1) Read word list and turn into array
* 2) Choose random word from list
* 3) Turn word into underscores and show to user
* 4) Prompt user for letter guess
* 5) Check if letter is in word
* 6) Fill in letter if it is, draw picture and subtract lives if not. Remove from letter list either way
*
 */
//  Console.flush() to clear screen


object Main extends App {

  def readFile(): Array[String] = {
    Source.fromFile("/home/qa-admin/Downloads/words.txt").getLines.toArray
  }

  def randomise(): String = {
    val r = scala.util.Random
    val word = readFile()
    word(r.nextInt(word.length)).toLowerCase()
  }

  def underscore(word: String): String = {
    var underscores = ""
    for (i <- 0 until word.length) {
      underscores += "_ "
    }
    underscores
  }

  def checkLetter(guess:String, word: String, guesses: ArrayBuffer[String]): Boolean = {
    guesses += guess
    if (word.contains(guess)) {true}
    else {false}
  }

  def printAnswer(answer: String, guesses: ArrayBuffer[String]):Unit = {
    for (i <- answer) {
      var correctletter = false
      for (j <- guesses) {
        if (i.toString == j) {
          print(i)
          correctletter = true
        }
      }
      if (!correctletter) {
        print(" _ ")
      }
    }
  }

  def hangman(): Unit = {
    // Play game here:
    var lives = 7
    val answer = randomise()
    var guesses = ArrayBuffer.empty[String]
    var win = false
    println(underscore(answer))

    while (lives > 0) {
      val guess = scala.io.StdIn.readLine("Which letter will you guess? ").toString
      for (i <- 0 to 7) {println("\n")}
      if (!checkLetter(guess, answer, guesses)) {
        lives -= 1
      }
      printAnswer(answer, guesses)
      println("\n")
      var correctletters = 0
      for (i <- answer) {
        if (guesses.contains(i.toString)) {
          correctletters += 1
        }
        if (correctletters == answer.length) {
          println("You win!")
          win = true
          lives = 0
        }
      }
      if (!win) {
        println(s"Letters guessed: $guesses")
        println(s"You have $lives lives remaining")
        println("\n")
      }

    }
  }
  hangman()
}
