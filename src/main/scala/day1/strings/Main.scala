package day1.strings

object Main extends App {

  def cut(word: String, num: Int) = {
    var num1 = word.length() - num
    word.substring(num1)

  }
  println(cut("Hello", 2))
}
