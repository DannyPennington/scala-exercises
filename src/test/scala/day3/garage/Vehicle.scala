package day3.garage

abstract class Vehicle {
  def year: Int
  def cost: Int
  def wheels: Int
  def model: String
  var ID:Int = 0
  def setID(x: Int) : Unit= {
    ID = x
  }

  override def toString: String = s"\n Year of manufacture: $year \n Price $cost \n Wheels: $wheels"

}
