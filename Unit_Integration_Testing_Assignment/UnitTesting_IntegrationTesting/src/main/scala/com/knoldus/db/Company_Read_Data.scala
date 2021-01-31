package com.knoldus.db

import com.knoldus.models.Company

import scala.collection.immutable.HashMap

class Company_Read_Data {

  val knoldusCompany: Company = Company("Knoldus", "knoldus@gmail.com", "Noida")
  val hitachiCompany: Company = Company("Hitachi", "hitachi123@gmail.com", "Noida")
  val companies: HashMap[String, Company] = HashMap("Knoldus" -> knoldusCompany, "Hitachi" ->hitachiCompany)

  def getCompanyByName(name: String): Option[Company] = companies.get(name)

}
