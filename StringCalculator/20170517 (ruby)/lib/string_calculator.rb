class StringCalculator
  class << self
    def add(numbers)
      return 0 if numbers.empty?

      numbers_array = numbers.split(',')
      return numbers_array[0].to_i + numbers_array[1].to_i if numbers_array.size == 2

      numbers.to_i
    end
  end
end
