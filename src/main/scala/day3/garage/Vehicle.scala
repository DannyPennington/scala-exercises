package day3.garage

import scala.collection.mutable.ArrayBuffer

abstract class Vehicle {
  def year: Int
  def cost: Int
  def wheels: Int
  def model: String
  var ID:Int = 0
  var working:Boolean = false
  //var part_list:ArrayBuffer[Part]
  //part_list += Part("Engine", 500, 60, false)


  def fixVehicle():Unit = {
    working = true
  }
  def setID(x: Int) : Unit= {
    ID = x
  }

  override def toString: String = s"\n Year of manufacture: $year \n Price $cost \n Wheels: $wheels"

}
