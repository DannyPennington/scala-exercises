package day2.iteration

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
  rectangle("z",5)
}
