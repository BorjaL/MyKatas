
package com.borjafernandezpillado.stringcalculator

import spock.lang.Specification

class StringCalculatorSpec extends Specification {

	def calculator

	def setup() {
		calculator = new StringCalculator()
	}

	def "returns 0 if it is passed an empty string"(){
		given:
		def emptyInput = ""

		when:
		def result = calculator.add(emptyInput)

		then:
		result == StringCalculator.ZERO_BECAUSE_EMPTY_INPUT
	}

	def "return the same number if it is the only one passed"(){
		given:
		def oneNumberInput = "1"

		when:
		def result = calculator.add(oneNumberInput)

		then:
		result == oneNumberInput.toInteger()
	}

	def "return the sum of the input numbers"(){
		given:
		def twoNumberInput = "1,2"

		when:
		def result = calculator.add(twoNumberInput)

		then:
		result == 3
	}

	def "return the sum of an unknonw amount of numbers"(){
		given:
		def multipleNumberInput = "1,2,1,2,1,3"

		when:
		def result = calculator.add(multipleNumberInput)

		then:
		result == 10
	}

	def "return the sum of the numbers separated by multiple delimeters"(){
		given:
		def inputWithDifferentDelimeters = "1,2,3\n4,5"

		when:
		def result = calculator.add(inputWithDifferentDelimeters)

		then:
		result == 15
	}

	def "is able to pass the delimeter in the first line"(){
		given:
		def inputWithDelimeterLine = "//;\n1;2\n3;4"

		when:
		def result = calculator.add(inputWithDelimeterLine)

		then:
		result == 10
	}

	def "throws an exception when there is a negative number"(){
		given:
		def inputWithNegativeNumbers = "1,2,-4,5"

		when:
		def result = calculator.add(inputWithNegativeNumbers)

		then:
		def negativeNumberException = thrown(RuntimeException)
		negativeNumberException.message == 'negatives not allowed -4'
	}

}