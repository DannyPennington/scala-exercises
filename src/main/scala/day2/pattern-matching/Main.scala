package day2.pattern

object Main extends App {

  def wordMultiply(word: String, num: Int): String = word match {
    case _ => word*num+"\n"
  }
  //println(wordMultiply("z",5))

  def rectangle(word: String, num: Int):String = word match{
    case _ => wordMultiply(word,num)*num
  }
  //println(rectangle("z",5))

  def fizzBuzz(fizz: String, buzz: String, num: Int):String = num match {
    case _ => {val fin = scala.collection.mutable.ListBuffer.empty[String]
    for (i <- 1 to num) {
      if (i % 3 == 0 && i % 5 == 0) {
        fin += (fizz + buzz)
      }
      else if (i % 3 == 0) {
        fin += buzz
      }
      else if (i % 5 == 0) {
        fin += fizz
      }
      else {
        fin += i.toString
      }
    }
    fin.toString
  }}
  println(fizzBuzz("Fizz","Buzz",15))

}
