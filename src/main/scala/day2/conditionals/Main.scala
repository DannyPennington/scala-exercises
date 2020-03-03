package day2.conditionals

object Main extends App {

  def sum2(num1: Int,num2: Int, con: Boolean): Int = {
    if (con == true) {
      num1+num2
    }
    else {
      num1*num2
    }
  }
  println(sum2(5,5,false))
}
