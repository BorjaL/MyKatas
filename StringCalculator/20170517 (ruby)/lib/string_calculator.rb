class StringCalculator
  class << self
    def add(numbers)
      return 0 if numbers.empty?

      numbers_array = numbers.split(',')
      return array_sum(numbers_array) if numbers_array.size >= 2

      numbers.to_i
    end

    private

    def array_sum(numbers)
      numbers.inject(0) { |sum, i| sum + i.to_i }
    end
  end
end
