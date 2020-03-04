package day3.garage

class Bike(val yom:Int, val price: Int, val bike_model:String) extends Vehicle {
  def year: Int = yom

  def cost:Int = price
  def model:String = bike_model
  def wheels:Int = 2

  override def toString: String = s"\n ID: $ID \n Model: $bike_model \n Year: $yom \n Price: £$cost"

}
