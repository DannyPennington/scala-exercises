package day3.garage

import scala.collection.mutable.ArrayBuffer

class Garage {
  var  vehicle_array: ArrayBuffer[Vehicle] = ArrayBuffer.empty[Vehicle]
  var  employee_array: ArrayBuffer[Employee] = ArrayBuffer.empty[Employee]

  def addVehicle(item:Vehicle): Unit = {
    item.ID = vehicle_array.length
    vehicle_array += item
  }
  def currentVehicles():ArrayBuffer[Vehicle] = {
    vehicle_array
  }
  def removeVehicle(item: Int): Unit = {
    vehicle_array.remove(item)
  }
  def addEmployee(item: Employee): Unit = {
    item.ID = employee_array.length
    employee_array += item
  }
  def currentEmployees():ArrayBuffer[Employee] = {
    employee_array
  }
  def removeEmployee(item: Int): Unit = {
    employee_array.remove(item)
  }
  def fix(item:Vehicle):Unit = {
    item.fixVehicle()
  }

}
