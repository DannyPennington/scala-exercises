package day3.garage

class Bike(val yom:Int, val price: Int, val bike_model:String) extends Vehicle {
  def year: Int = yom
  def cost: Int = price
  def model: String = bike_model
  def wheels = 2

  override def toString: String = s"\n Bike ID: $ID, Model: $bike_model, Year: $yom, Price: £$cost, Working?: $working"

}
