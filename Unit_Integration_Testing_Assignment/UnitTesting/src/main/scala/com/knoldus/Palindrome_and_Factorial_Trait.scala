package com.knoldus

/*Trait creation*/

trait Palindrome_and_Factorial_Trait {
  def palindrome(number: Int): Boolean
  def factorial(number: Int): Int
}

/*Class for Palindrome and Factorial implementation*/

class Palindrome_and_Factorial extends Palindrome_and_Factorial_Trait {

/* For Palindrome*/
  def palindrome(number: Int): Boolean = {
    var reverse: Int = 0
    var remainder: Int = 0
    var temp: Int = number

    while(temp>0){
      remainder = temp % 10
      reverse = reverse * 10 + remainder
      temp /= 10
    }

    if(reverse == number)
      true
    else
      false
  }

/*For Factorial*/

  def factorial(number: Int): Int = {
    var result:Int = 1

    for(i <- 2 to number){
      result *= i
    }
    result
  }
}
