package com.knoldus.request

import com.knoldus.models.User
import com.knoldus.validator.User_Validator

class User_Impl(userValidator: UserValidator) {

  def createUser(user: User): Option[String] = {
    if (userValidator.userIsValid(user)) Option(user.emailId)
    else None
  }
}
