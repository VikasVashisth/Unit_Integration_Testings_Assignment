package com.knoldus.db

import com.knoldus.models.Employee

import scala.collection.immutable.HashMap

class Employee_Read_Data {

  val vikasEmployee: Employee = Employee("Vikas","Vashisth",25,13548,"Intern","Knoldus","vikas.vashisth@knoldus.com")
  val rahulEmployee: Employee = Employee("Harshit","Gupta",28,15000,"Software Engineer","Hitachi","harshit.gupta@philips.com")
  val employees: HashMap[String, Employee] = HashMap("Vikas" -> vikasEmployee, "Harshit" -> harshitEmployee)

  def getEmployeeByName(name: String): Option[Employee] = employees.get(name)

}
