package com.knoldus.request

import com.knoldus.models.Employee
import com.knoldus.validator.Employee_Validator

class Employee_Impl(employeeValidator: Employee_Validator) {

  def createEmployee(employee: Employee): Option[String] = {
    if (employeeValidator.employeeIsValid(employee)) Option(employee.emailId)
    else None
  }
}
