package com.knoldus.request

import com.knoldus.models.Company
import com.knoldus.validator.Company_Validator

class Company_Impl(companyValidator: Company_Validator) {

  def createCompany(company: Company): Option[String] = {
    if (companyValidator.companyIsValid(company)) Option(company.name)
    else None
  }
}
