package day3.garage

object Main extends App {

  val dave = new Employee("Dave",25000)
  //println(dave.toString)
  val steve = new Customer("Steve", "steve@fakemail.com", 1)
  //println(steve.toString)
  val jan = new Employee("Jan", 50000)
  val big = new Employee("Mr Bigshot", 200000000)

  val ford = new Car(1980, 3000, "Ford Mustang")
  val harley = new Bike(1985, 5000, "Harley Davidson")
  //println(ford.toString)
  //println(harley.toString)

  val jason = new Garage

  jason.addVehicle(ford)
  jason.addVehicle(harley)
  jason.fix(ford)
  println(jason.currentVehicles())

  //jason.addEmployee(dave)
  //jason.addEmployee(jan)
  //jason.addEmployee(big)
  //println(jason.currentEmployees())

}
