package day1.bottlecount

object Main extends App {

  def beer(num: Int): Unit = {
    var num1 = num
    do {
      if (num1 == 1) {
        println(s"$num1 bottle of beer on the wall, $num1 bottle of beer, you take one down, pass it around, ${num1-1} bottles of beer on the wall")
      }
      else
        println(s"$num1 bottles of beer on the wall, $num1 bottles of beer, you take one down, pass it around, ${num1-1} bottles of beer on the wall")
      num1 -= 1
    } while (num1 > 0)
  }
  beer(5)
}
