package com.knoldus
import org.scalatest.flatspec.AnyFlatSpec

class Palindrome_and_Factorial_TraitTest extends AnyFlatSpec {

  "number" should "not be a palindrome number" in {
    val obj = new Palindrome_and_Factorial
    assert(!obj.palindrome(47538))
  }

  "number" should "not be a palindrome number as it is a negative number" in {
    val obj = new  Palindrome_and_Factorial
    assert(!obj.palindrome(-5874))
  }

  "number" should "be a palindrome number as 0 is a palindrome" in {
    val obj = new  Palindrome_and_Factorial
    assert(obj.palindrome(0))
  }

  "number" should "be a palindrome number" in {
    val obj = new  Palindrome_and_Factorial
    assert(obj.palindrome(68786))
  }

  "condition" should "be invalid as 5 will not return 110" in {
    val obj = new  Palindrome_and_Factorial
    assert(!(110==obj.factorial(5)))
  }

  "condition" should "be valid as 0 will return 1" in {
    val obj = new  Palindrome_and_Factorial
    assert(1==obj.factorial(0))
  }

  "condition" should "be valid as 6 will return 720" in {
    val obj = new  Palindrome_and_Factorial
    assert(720==obj.factorial(6))
  }
}
