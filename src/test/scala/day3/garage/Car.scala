package day3.garage

class Car(val yom:Int, val price: Int, val car_model:String) extends Vehicle {

  def cost: Int = price
  def year: Int = yom
  def wheels = 4
  def model: String = car_model

  override def toString: String = s"\n Model: $car_model \n Year: $yom \n Price: £$cost"
}
