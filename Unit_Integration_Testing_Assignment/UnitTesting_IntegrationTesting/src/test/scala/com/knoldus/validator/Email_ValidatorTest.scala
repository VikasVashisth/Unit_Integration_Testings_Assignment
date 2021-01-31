package com.knoldus.validator
import org.scalatest.flatspec.AnyFlatSpec

class Email_ValidatorTest extends AnyFlatSpec {

  "email" should "be invalid as it does not contains recipient name" in {
    val emailValidator = new Email_Validator
    assert(!emailValidator.emailIdIsValid("@gmail.com"))
  }

  "email" should "be invalid as it does not contains @ symbol" in {
    val emailValidator = new Email_Validator
    assert(!emailValidator.emailIdIsValid("vikasgmail.com"))
  }

  "email" should "be invalid as it does not contains domain name" in {
    val emailValidator = new Email_Validator
    assert(!emailValidator.emailIdIsValid("vikas@.com"))
  }

  "email" should "be invalid as it does not contains .(com,net,org)" in {
    val emailValidator = new Email_Validator
    assert(!emailValidator.emailIdIsValid("vikas@gmail.in"))
  }

  "email" should "be valid" in {
    val emailValidator = new Email_Validator
    assert(emailValidator.emailIdIsValid("vikas@gmail.com"))
  }
}
