package com.knoldus.request
import com.knoldus.db.Company_Read_Data
import com.knoldus.models.Company
import com.knoldus.validator.{Company_Validator, Email_Validator}
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.flatspec.AnyFlatSpec

class Company_Impl_IntegrationTest extends AnyFlatSpec {

  val companyName = new Company_Read_Data
  val validateEmail = new Email_Validator
  val companyValidator = new Company_Validator(companyName,validateEmail)

  "Company" should "not be created as it already exists in DB" in {
    val knoldusCompany: Company = Company("Knoldus", "knoldus@gmail.com", "Noida")

    val companyImpl = new Company_Impl(companyValidator)
    val result = companyImpl.createCompany(knoldusCompany)
    assert(result.isEmpty)
  }

  "Company" should "not be created as email id is not valid" in {
    val hitachiCompany: Company = Company("Hitachi", "hitachi@gmail", "Noida")

    val companyImpl = new Company_Impl(companyValidator)
    val result = companyImpl.createCompany(googleCompany)
    assert(result.isEmpty)
  }

  "Company" should "not be created as it already exists in DB and email id is not valid" in {
    val knoldusCompany: Company = Company("Knoldus", "knoldus@gmailcom", "Noida")

    val companyImpl = new Company_Impl(companyValidator)
    val result = companyImpl.createCompany(knoldusCompany)
    assert(result.isEmpty)
  }

  "Company" should "be created" in {
    val googleCompany: Company = Company("Google", "hitachi@gmail.com", "Noida")

    val companyImpl = new Company_Impl(companyValidator)
    val result = companyImpl.createCompany(googleCompany)
    assert(!result.isEmpty)
  }

}
