require 'rspec/expectations'
require_relative '../lib/game'

describe 'bowling-game-kata' do
  let(:game) { Game.new }

  def roll_many(number, pins)
    number.times do
      game.roll(pins)
    end
  end

  def roll_a_spare
    game.roll(5)
    game.roll(5)
  end

  def roll_a_strike
    game.roll(10)
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
      roll_a_spare
      game.roll(3)
      roll_many(17, 0)
      expect(game.score).to eq 16
    end
  end

  context 'roll making a strike and then two rolls with 3 and 4 pins down' do
    it 'the score must be 10 of the strike plus the bonus and the later roll\'s score' do
      roll_a_strike
      game.roll(3)
      game.roll(4)
      roll_many(16, 0)
      expect(game.score).to eq 24
    end
  end

  context 'tenth frame is a spare' do
    it 'there is a extra roll with 3 pins downed' do
      roll_many(18, 0)
      roll_a_spare
      game.roll(3)

      expect(game.score).to eq 13
    end
  end

  context 'perfect game' do
    it 'score equal to 300' do
      roll_many(12, 10)

      expect(game.score).to eq 300
    end
  end

  context 'tenth frame is a strike' do
    it 'there are two extra roll with 3 pins downed' do
      roll_many(18, 0)
      roll_a_strike
      game.roll(3)
      game.roll(3)

      expect(game.score).to eq 16
    end
  end
end
