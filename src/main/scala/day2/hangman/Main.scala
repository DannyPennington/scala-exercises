package day2.hangman

import scala.io.Source

object Main extends App {
  /* Steps
  * 1) Read word list and turn into array
  * 2) Choose random word from list
  * 3) Turn word into underscores and show to user
  * 4) Prompt user for letter guess
  * 5) Check if letter is in word
  * 6) Fill in letter if it is, draw picture and subtract lives if not. Remove from letter list either way
  *
   */

  def readFile(): Array[String] = {
    val lines = Source.fromFile("/home/qa-admin/Downloads/words.txt").getLines.toArray
    lines
  }

  def randomise(): String = {
    val r = scala.util.Random
    val word = readFile()
    val x = word(r.nextInt(word.length))
    x
  }

  def underscore(word: String): String = {
    var x = ""
    for (i <- (0 until word.length)) {
      x += "_ "
    }
    x
  }
  // Calling underscore(randomise) will generate the underscores for the word that is chosen
  def checkLetter(letter:String, word: String): Boolean = {
    if (word.contains(letter)) {true}
    else {false}
  }


  // Play game here:
  var lives = 7
  val answer = randomise()
  var guesses = scala.collection.mutable.ArrayBuffer.empty[String]
  println(underscore(answer))
  while (lives > 0) {
    val guess = scala.io.StdIn.readLine("Which letter will you guess? ").toString

  }
}
