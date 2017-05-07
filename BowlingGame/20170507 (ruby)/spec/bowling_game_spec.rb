require 'rspec/expectations'
require_relative '../lib/game'

describe 'bowling-game-kata' do
  let(:game) { Game.new }

  def roll_many(number, pins)
    number.times do
      game.roll(pins)
    end
  end

  context 'a simple roll with 0 pins down' do
    it 'the score must be 0' do
      game.roll(0)
      roll_many(19, 0)
      expect(game.score).to eq 0
    end
  end

  context 'a simple roll with 5 pins down' do
    it 'the score must be 5' do
      game.roll(5)
      roll_many(19, 0)
      expect(game.score).to eq 5
    end
  end

  context '10 rolls with 1 pins down each' do
    it 'the score must be 10' do
      10.times do
        game.roll(1)
      end
      roll_many(10, 0)
      expect(game.score).to eq 10
    end
  end

  context '2 rolls making a spare and a later roll with 3 pins down' do
    it 'the score must be 10 of spare plus the bonus and the later roll\'s score' do
      game.roll(5)
      game.roll(5) # spare
      game.roll(3)
      roll_many(17, 0)
      expect(game.score).to eq 16
    end
  end
end
