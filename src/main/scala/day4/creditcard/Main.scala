package day4.creditcard

object Main extends App {

  @scala.annotation.tailrec
  def sumDigit(num:Int): Int  = {
   var sum = num.toString.map(_.asDigit).toList.sum
   if (sum.toString.toList.length != 1) {
     sumDigit(sum)
   }
   else {sum}
  }

  @scala.annotation.tailrec
  def checkDigits(num:Long, recursion_count: Int = 1,  total:Int = 0): Int= {
    var sum = total
    val digit_list = num.toString.map(_.asDigit).toList
    var checking = digit_list(digit_list.length-recursion_count)

    sum += checking
    sum += sumDigit(digit_list(digit_list.length - (recursion_count + 1)) * 2)

    if (recursion_count <= (digit_list.length/2)+2) {
      checkDigits(num, recursion_count+2, sum)
    }
    else {
      sum += digit_list.head
      sum
    }
  }

  def valid(num:Long): Boolean = {
    val sum = checkDigits(num)
    if (sum % 10 == 0) {true}
    else {false}
  }

  println(valid(49927398716L))
}
