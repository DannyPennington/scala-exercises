package day1.typeinference

object Main extends App {

  def ret(item: Any) = {
    item
  }
  println(ret(2.0))
  println(ret(2))
  println(ret("Hello"))
  println(ret(true))
}
