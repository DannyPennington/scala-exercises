package day2.conditionals

object Main extends App {

  def sum2(num1: Int,num2: Int, con: Boolean): Int = {
    con match {
      case true => num1+num2
      case false => num1*num2
      case _ => println("How did this even happen?"); 0
    }
  }
  def conditional(num1: Int,num2: Int, con: Boolean): Int = {
    if (num1==0) {
      num2
    }
    else if (num2==0) {
      num1
    }
    else if (con == true) {
      num1+num2
    }
    else {
      num1*num2
    }
  }
  //println(conditional(4,0,false))
  println(sum2(5,5,false))
}
