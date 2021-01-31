package com.knoldus.validator

import com.knoldus.db.Company_Read_Data
import com.knoldus.models.User

class User_Validator (companyName: Company_Read_Data, validateEmail: Email_Validator) {

  def userIsValid(user: User): Boolean = {

    if(!companyName.getCompanyByName(user.companyName).isEmpty &&
      validateEmail.emailIdIsValid(user.emailId))
      true
    else
      false
  }
}
