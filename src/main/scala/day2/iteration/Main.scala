package day2.iteration

import scala.collection.mutable.ListBuffer

object Main extends App {

  def wordMultiply(word: String, num: Int): Unit = {
    for (i <- 1 to num) {
      println(word)
    }
  }
  // wordMultiply("Hello",5)

  def rectangle(word: String, num: Int):Unit = {
    for (i <- 1 to num) {
      println(word*num)
    }
  }
  // rectangle("z",5)

  def fizzBuzz(fizz: String, buzz: String, num: Int):String = {
    val fin = ListBuffer.empty[String]
    for (i <- 1 to num) {
      if (i % 3 == 0 && i % 5 == 0) {
        fin += (fizz + buzz)
      }
      else if (i % 3 == 0) {
        fin += buzz
      }
      else if (i % 5 == 0) {
        fin += fizz
      }
      else {
        fin += i.toString
      }
    }
    fin.toString
  }
  println(fizzBuzz("Fizz","Buzz",15))
}
