package com.borjafernandezpillado.fizzbuzz

public class FizzBuzz {

	def apply(number) {

		if (isDivisibleBy3(number) && isDivisibleBy5(number)) return "FizzBuzz"
		if (isDivisibleBy3(number)) return "Fizz"
		if (isDivisibleBy5(number)) return "Buzz"

		return number
	}

	private isDivisibleBy3(number) {
		return number % 3 == 0
	}

	private isDivisibleBy5(number) {
		return number % 5 == 0
	}
}