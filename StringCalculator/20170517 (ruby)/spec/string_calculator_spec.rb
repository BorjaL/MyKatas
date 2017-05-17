require_relative '../lib/string_calculator'

describe StringCalculator do
  describe '.add' do
    context 'given empty string' do
      it 'returns 0' do
        expect(StringCalculator.add('')).to eq 0
      end
    end
  end
end
