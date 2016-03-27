package com.borjafernandezpillado.fizzbuzz

import spock.lang.Specification

class FizzBuzzSpec extends Specification {

	def fizzBuzz

	def setup() {
		fizzBuzz = new FizzBuzz()
	}

	def "says Fizz when the number is divisible by 3"() {
		expect:
		fizzBuzz.apply(3) == 'Fizz'
	}

	def "returns the number when is not divisible by 3 or 5"(){
		expect:
		fizzBuzz.apply(1) == 1
		fizzBuzz.apply(2) == 2
	}

	def "returns Buzz when the number is divisible by 5"(){
		expect:
		fizzBuzz.apply(5) == "Buzz"
	}

	def "returns FizzBuzz when the number is multiples of both three and five"(){
		expect:
		fizzBuzz.apply(15) == "FizzBuzz"
	}
}