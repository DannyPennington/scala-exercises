package day1.challenge

object Main extends App {

  def sumMultiply(a: Int, b: Int, c: Int): Int = {
    val x = List(a,b,c).sorted
    val sum = x(0) + x(1)
    sum*x(2)
  }
  println(sumMultiply(1,7,7))
}
