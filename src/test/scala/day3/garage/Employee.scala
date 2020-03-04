package day3.garage

class Employee(employeename:String, employee_ID: Int, salary: Int) extends Person {
  def name: String = employeename
  def persontype: String = "Employee"
  def ID: Int = employee_ID
  override def toString: String = s"$persontype $ID \n Name: $name \n Salary: £$salary"

}
