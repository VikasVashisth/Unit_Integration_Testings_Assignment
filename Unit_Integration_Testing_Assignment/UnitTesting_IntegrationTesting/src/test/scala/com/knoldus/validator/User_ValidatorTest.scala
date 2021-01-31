package com.knoldus.validator

import com.knoldus.db.Company_Read_Data
import com.knoldus.models.{Company, User}
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.flatspec.AnyFlatSpec

class User_ValidatorTest extends AnyFlatSpec {

  val vikasUser: User = User("Vikas","Vashisth",22,"Google","vikasvashisth@knoldus.in")
  val knoldusCompany: Company = Company("Knoldus", "knoldus@gmail.com", "Noida")

  val mockedCompanyReadDto = mock[Company_Read_Data]
  val mockedEmailvalidator = mock[Email_Validator]

  val userValidator = new User_Validator(mockedCompanyReadDto,mockedEmailvalidator)

  "User" should "be valid" in {

    when(mockedCompanyReadDto.getCompanyByName(vikasUser.companyName)) thenReturn(Option(knoldusCompany))
    when(mockedEmailvalidator.emailIdIsValid(vikasUser.emailId)) thenReturn(true)

    val result = userValidator.userIsValid(vikasUser)
    assert(result)
  }

  "User" should "be invalid because his email is not valid" in {

    when(mockedCompanyReadDto.getCompanyByName(vikasUser.companyName)) thenReturn(Option(knoldusCompany))
    when(mockedEmailvalidator.emailIdIsValid(vikasUser.emailId)) thenReturn(false)

    val result = userValidator.userIsValid(vikasUser)
    assert(!result)
  }

  "User" should "be invalid because his company does not exists in DB" in {

    when(mockedCompanyReadDto.getCompanyByName(vikasUser.companyName)) thenReturn(None)
    when(mockedEmailvalidator.emailIdIsValid(vikasUser.emailId)) thenReturn(true)

    val result = userValidator.userIsValid(vikasUser)
    assert(!result)
  }

  "User" should "be invalid because his email id is not valid and his company does not exists in DB" in {

    when(mockedCompanyReadDto.getCompanyByName(vikasUser.companyName)) thenReturn(None)
    when(mockedEmailvalidator.emailIdIsValid(vikasUser.emailId)) thenReturn(false)

    val result = userValidator.userIsValid(vikasUser)
    assert(!result)
  }

}
