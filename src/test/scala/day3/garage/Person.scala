package day3.garage

abstract class Person {
  def name: String
  def persontype: String
  var ID:Int = 0

  def setID(x: Int) : Unit= {
    ID = x
  }
  override def toString: String = s"$name, $persontype"


}
