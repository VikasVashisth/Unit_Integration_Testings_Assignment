package com.knoldus.validator

import com.knoldus.db.Company_Read_Data
import com.knoldus.models.Company

class Company_Validator(companyName: Company_Read_Data,validateEmail: EmailValidator) {

  def companyIsValid(company: Company): Boolean = {
    if(companyName.getCompanyByName(company.name).isEmpty &&
      validateEmail.emailIdIsValid(company.emailId))
      true
    else
      false
  }
}
