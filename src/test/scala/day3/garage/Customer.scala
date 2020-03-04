package day3.garage

class Customer(val customername:String, val email:String, val customer_ID:Int, var owned_vehicles: Any) extends Person{
  def this(customername: String, email:String, customer_ID:Int) = this(customername, email, customer_ID, "None")
  def name: String = customername
  def persontype:String = "Customer"

  override def toString:String = s"$persontype $ID \n Name: $name \n Email: $email \n Vehicles in shop: $owned_vehicles"
}
