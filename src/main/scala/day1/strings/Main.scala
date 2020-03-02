package day1.strings

object Main extends App {

  def cut(word: String, num: Int) = {
    if (num >word.length() | num<0) {
      "Number within the length of the word!"
    }
    else {
      var num1 = word.length() - num
      word.substring(num1)
    }
  }
  println(cut("Hello", 2))
}
