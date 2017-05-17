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
  end
end
