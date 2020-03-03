package day2.iteration

object Main extends App {

  def wordMultiply(word: String, num: Int) = {
    for (i <- 1 to num) {
      println(word)
    }
  }
  wordMultiply("Hello",5)
}
