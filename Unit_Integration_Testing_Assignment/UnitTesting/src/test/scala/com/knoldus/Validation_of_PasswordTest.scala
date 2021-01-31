package com.knoldus

import org.scalatest.flatspec.AnyFlatSpec

class Validation_of_PasswordTest extends AnyFlatSpec {
  "password" should "be invalid as it contains space" in {
    val password = new Validation_of_Password("Vikas9@ vashisth")
    assert(!password.passwordIsValid)
  }

  "password" should "be invalid as it does not contains any digit" in {
    val password = new Validation_of_Password("Vikas#vashisth")
    assert(!password.passwordIsValid)
  }

  "password" should "be invalid as the length is less than 8" in {
    val password = new Validation_of_Password("Vikas9$")
    assert(!password.passwordIsValid)
  }

  "password" should "be invalid as the length is more than 15" in {
    val password = new Validation_of_Password("Vikas@vashisth97")
    assert(!password.passwordIsValid)
  }

  "password" should "be invalid as it does not contains any lowercase letter" in {
    val password = new Validation_of_Password("VIKAS@VASHISTH9")
    assert(!password.passwordIsValid)
  }

  "password" should "be invalid as it does not contains any uppercase letter" in {
    val password = new Validation_of_Password("vikas@vashisth9")
    assert(!password.passwordIsValid)
  }

  "password" should "be invalid as it does not contains any special character" in {
    val password = new Validation_of_Password("VikasVashisth9")
    assert(!password.passwordIsValid)
  }

  "password" should "be valid" in {
    val password = new Validation_of_Password("Vikas@vashist97")
    assert(password.passwordIsValid)
  }
}