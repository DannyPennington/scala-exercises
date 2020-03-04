package day3.garage

abstract class Person {
  def name: String
  def persontype: String
  def ID: Int

  override def toString: String = s"$name, $persontype"


}
