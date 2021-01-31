package com.knoldus.request

import com.knoldus.db.Company_Read_Data
import com.knoldus.models.User
import com.knoldus.validator.{Email_Validator, User_Validator}
import org.scalatest.flatspec.AnyFlatSpec

class User_Impl_IntegrationTest extends AnyFlatSpec {

  val companyName = new Company_Read_Data
  val validateEmail = new Email_Validator
  val userValidator = new User_Validator(companyName,validateEmail)

  val userImpl = new User_Impl(userValidator)

  "User" should "not be created as company does not exists in DB" in {
    val rahulUser: User = User("Harshit","Gupta",25,"Hitachi","harshit.gupta@gmail.com")

    val result = userImpl.createUser(harshitUser)
    assert(result.isEmpty)
  }

  "User" should "not be created as email id is not valid" in {
    val akashUser: User = User("Akash","Rai",21,"Knoldus","akash.rai@knoldus")

    val result = userImpl.createUser(akashUser)
    assert(result.isEmpty)
  }

  "User" should "not be created as company does not exists in DB and email id is not valid" in {
    val gauravUser: User = User("Ajay","Kumar",22,"Microsoft","ajay.kumar@microsoft")

    val result = userImpl.createUser(ajayUser)
    assert(result.isEmpty)
  }

  "User" should "be created" in {
    val bhavyaUser: User = User("Vikas","Vashisth",22,"Knoldus","vikas.vashisth@knoldus.com")

    val result = userImpl.createUser(vikasUser)
    assert(!result.isEmpty)
  }

}
