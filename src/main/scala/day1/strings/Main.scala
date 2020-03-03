package day1.strings

object Main extends App {

  def cut(word: String, num: Int) = {
    if (num >word.length() | num<0) {
      "Number within the length of the word!"
    }
    else {
      val num1 = word.length() - num
      word.substring(num1)
    }
  }
  // println(cut("Hello", 2))
  def joinReplace(a: String, b: String, c: String, d: String): String = {
    val word = a+b
    word.replace(c,d)
  }
  println(cut("Hello", 2))
  println(joinReplace("Ha","llo","a","e"))
}
