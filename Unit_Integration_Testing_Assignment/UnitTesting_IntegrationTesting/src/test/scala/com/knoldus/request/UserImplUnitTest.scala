package com.knoldus.request
import com.knoldus.models.User
import com.knoldus.validator.User_Validator
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.flatspec.AnyFlatSpec

class User_Impl_UnitTest extends AnyFlatSpec {

  val mockedUserValidator = mock[User_Validator]
  val vikasUser: User = User("Vikas","Vashisth",22,"knoldus","vikas.vashisth@knoldus.com")

  "User" should "be created" in {
    val userImpl = new User_Impl(mockedUser_Validator)

    when(mockedUser_Validator.userIsValid(bhavyaUser)) thenReturn(true)
    val result = userImpl.createUser(vikasUser)
    assert(!result.isEmpty)
  }

  "User" should "not be created" in {
    val userImpl = new User_Impl(mockedUser_Validator)

    when(mockedUser_Validator.userIsValid(vikasUser)) thenReturn(false)
    val result = userImpl.createUser(vikasUser)
    assert(result.isEmpty)
  }

}
