package day3.garage

class Employee(employeename:String, salary: Int) extends Person {
  def name: String = employeename
  def persontype: String = "Employee"

  override def toString: String = s"\n Employee ID: $ID, Name: $name,  Salary: £$salary"

}
