package day3.garage

object Main extends App {

  val dave = new Employee("Dave",1,25000)
  //println(dave.toString)
  val steve = new Customer("Steve", "steve@fakemail.com", 1)
  //println(steve.toString)

  val ford = new Car(1980, 3000, 1, "Ford Mustang")
  val harley = new Bike(1985, 5000, 1, "Harley Davidson")
  println(ford.toString)
  println(harley.toString)
}
