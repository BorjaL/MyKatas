package com.borjafernandezpillado.stringcalculator

public class StringCalculator {

	public final static ZERO_BECAUSE_EMPTY_INPUT = 0
	public final static FIND_DELIMETERS_REGEX = /(\/\/(.+)\n)?((?:.+|\n*)*)/

	private numbers
	private numbersLine
	private delimeter = ','
	private inputStructure
	private negativeNumbers = []
	
	public int add(input){

		if (input == "") return ZERO_BECAUSE_EMPTY_INPUT
		prepareStringForAdd(input)
		
		if (numbers.length == 1) return input.toInteger()
		return giveTheSumOfTheNumbers()
	}

	private prepareStringForAdd(input){
		descomposingInput(input)
		findOutDelimeterLine()
		findOutNumberLine()
		splitNumbersByDelimeter()
		checkNegativeNumbers()
	}

	private checkNegativeNumbers(){

		for (int i = 0; i < numbers.length; i++){
			
			def number = numbers[i].toInteger()
			checkNegative(number)
		}

		if (!negativeNumbers.isEmpty()){
			throw new RuntimeException("negatives not allowed " + printTheNegativeNumbers())
		}
	}

	private giveTheSumOfTheNumbers(){

		def sum = 0;

		for (int i = 0; i < numbers.length; i++){
			def number = numbers[i].toInteger()

			sum += number
		}

		return sum
	}

	private printTheNegativeNumbers(){
		def negativeNumbersPrint = ""

		for (negativeNumber in negativeNumbers){
			negativeNumbersPrint += (negativeNumber + " ")
		}
		return negativeNumbersPrint.substring(0, negativeNumbersPrint.length() - 1)
	}

	private checkNegative(number){
		if (number < 0) negativeNumbers << number
	}

	private findOutDelimeterLine(){

		if (inputStructure.getCount() > 0 && inputStructure[0][1]){

			delimeter = inputStructure[0][2]
		}
	}

	private findOutNumberLine(){

		if (inputStructure.getCount() > 0){

			numbersLine = inputStructure[0][3]
		}
	}

	private descomposingInput(input){
		inputStructure = (input =~ FIND_DELIMETERS_REGEX)
	}

	private composeDelimeterRegex(){
		return delimeter + "|\n"
	}

	private splitNumbersByDelimeter(){
		numbers = numbersLine.split(composeDelimeterRegex())
	}
}