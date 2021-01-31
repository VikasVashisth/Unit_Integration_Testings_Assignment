package com.knoldus.request
import com.knoldus.models.Company
import com.knoldus.validator.Company_Validator
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.flatspec.AnyFlatSpec

class Company_Impl_UnitTest extends AnyFlatSpec {
  val mockedCompanyValidator = mock[Company_Validator]
  val knoldusCompany: Company = Company("Knoldus", "knoldus@gmail.com", "Noida")

  "Company" should "be created" in {
    val companyImpl = new CompanyImpl(mockedCompanyValidator)

    when(mockedCompany_Validator.companyIsValid(knoldusCompany)) thenReturn(true)
    val result = companyImpl.createCompany(knoldusCompany)
    assert(!result.isEmpty)
  }

  "Company" should "not be created" in {
    val companyImpl = new Company_Impl(mockedCompanyValidator)

    when(mockedCompany_Validator.companyIsValid(knoldusCompany)) thenReturn(false)
    val result = companyImpl.createCompany(knoldusCompany)
    assert(result.isEmpty)
  }
}
