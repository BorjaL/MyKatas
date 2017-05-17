require_relative '../lib/string_calculator'

describe StringCalculator do
  describe '.add' do
    context 'given empty string' do
      it 'returns 0' do
        expect(StringCalculator.add('')).to eq 0
      end
    end

    context 'given one number string' do
      it 'returns the same number' do
        expect(StringCalculator.add('1')).to eq 1
      end
    end

    context 'given two numbers string separated by commas' do
      it 'returns the sum of both numbers' do
        expect(StringCalculator.add('1,2')).to eq 3
      end
    end

    context 'given six numbers string separated by commas' do
      it 'returns the sum of all' do
        expect(StringCalculator.add('1,2,3,1,2,3')).to eq 12
      end
    end

    context 'given a string with \n and commas as delimiters' do
      it 'returns the sum of all' do
        expect(StringCalculator.add("1,2,3\n1,2\n3")).to eq 12
      end
    end
  end
end
