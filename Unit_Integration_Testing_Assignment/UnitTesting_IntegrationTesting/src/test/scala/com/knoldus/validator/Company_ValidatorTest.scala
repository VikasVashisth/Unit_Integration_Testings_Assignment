package com.knoldus.validator

import com.knoldus.db.Company_Read_Data
import com.knoldus.models.Company
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.flatspec.AnyFlatSpec

class Company_ValidatorTest extends AnyFlatSpec {

  val knoldusCompany: Company = Company("Knoldus", "knoldus@gmail.com", "Noida")

  val mockedCompanyReadDto = mock[Company_Read_Data]
  val mockedEmailvalidator = mock[Email_Validator]

  val companyValidator = new Company_Validator(mockedCompanyReadDto,mockedEmailvalidator)

  "Company" should "be valid" in {

    when(mockedCompanyReadDto.getCompanyByName(knoldusCompany.name)) thenReturn(None)
    when(mockedEmailvalidator.emailIdIsValid(knoldusCompany.emailId)) thenReturn(true)

    val result = companyValidator.companyIsValid(knoldusCompany)
    assert(result)
  }

  "Company" should "be invalid as it already exists in the DB" in {

    when(mockedCompanyReadDto.getCompanyByName(knoldusCompany.name)) thenReturn(Option(knoldusCompany))
    when(mockedEmailvalidator.emailIdIsValid(knoldusCompany.emailId)) thenReturn(true)

    val result = companyValidator.companyIsValid(knoldusCompany)
    assert(!result)
  }

  "Company" should "be invalid as the email id is not valid" in {

    when(mockedCompanyReadDto.getCompanyByName(knoldusCompany.name)) thenReturn(None)
    when(mockedEmailvalidator.emailIdIsValid(knoldusCompany.emailId)) thenReturn(false)

    val result = companyValidator.companyIsValid(knoldusCompany)
    assert(!result)
  }

  "Company" should "be invalid as the email id is not valid and it already exists in the DB" in {

    when(mockedCompanyReadDto.getCompanyByName(knoldusCompany.name)) thenReturn(Option(knoldusCompany))
    when(mockedEmailvalidator.emailIdIsValid(knoldusCompany.emailId)) thenReturn(false)

    val result = companyValidator.companyIsValid(knoldusCompany)
    assert(!result)
  }

}
