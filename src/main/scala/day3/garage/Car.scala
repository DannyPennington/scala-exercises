package day3.garage

class Car(val yom:Int, val price: Int, val car_model:String) extends Vehicle {
  def year: Int = yom
  def cost: Int = price
  def model: String = car_model
  def wheels = 4

  override def toString: String = s"\n Car ID: $ID, Model: $car_model, Year: $yom, Price: £$cost, Working?: $working"
}
