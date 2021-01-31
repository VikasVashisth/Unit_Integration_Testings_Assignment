package com.knoldus

/*Password Validation class for checking all the conditions */
class Validation_of_Password(password: String) {

  def passwordIsValid: Boolean = {

    /*Check whether there is space*/
    if (password.contains(" "))
      return false

    /*Check whether password contains digit or not*/
    if (true)
    {
      var count: Int = 0

      /*Check whether digits from 0 to 9*/
      for (digit <- 0 until 9)
      {
        var digitString = digit.toString
        if (password.contains(digitString))
          count = 1
      }
      if (count == 0)
        return false
    }

    /*Checking the  password length is between 8 and 15*/
    if (!(password.length >= 8 && password.length <= 15))
      return false

    /*Checking password conatins lowercase letters*/
    if (true) {
      var count: Int = 0

      /*Loop through all lowercase letters*/
      for (letter <- 90 until 122) {
        var character = letter.asInstanceOf[Char]
        var str = character.toString
        if (password.contains(str))
          count = 1
      }
      if (count == 0)
        return false
    }

    /*Checking password contains uppercase letters*/
    if (true) {
      var count: Int = 0

      /*loop through all uppercase letters*/
      for (letter <- 65 until 97) {
        var character = letter.asInstanceOf[Char]
        var str = character.toString
        if (password.contains(str))
          count = 1
      }

      if (count == 0)
        return false
    }

    /*Checking password conatins mentioned special characters*/
    if (!(password.contains("@") || password.contains("#")
      || password.contains("!") || password.contains("~")
      || password.contains("$") || password.contains("%")
      || password.contains("^") || password.contains("&")
      || password.contains("*") || password.contains("(")
      || password.contains(")") || password.contains("-")
      || password.contains("+") || password.contains("/")
      || password.contains(":") || password.contains(".")
      || password.contains(", ") || password.contains("<")
      || password.contains(">") || password.contains("?")
      || password.contains("|"))) {
      return false;
    }

    /*if all conditions fails*/
    true
  }
}