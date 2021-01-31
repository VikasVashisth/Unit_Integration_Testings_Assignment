package com.knoldus.db
import org.scalatest.flatspec.AnyFlatSpec

class Company_Read_DataTest extends AnyFlatSpec {

  "Company" should "exist" in {
    val companyReadDto = new Company_Read_Data
    val result = companyReadDto.getCompanyByName("Knoldus")
    assert(!result.isEmpty)
  }

  "Company" should "not exist" in {
    val companyReadDto = new Company_Read_Data
    val result = companyReadDto.getCompanyByName("Hitachi")
    assert(result.isEmpty)
  }
}
