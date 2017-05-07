require 'rspec/expectations'
require_relative '../lib/game'

describe 'bowling-game-kata' do
  let(:game) { Game.new }

  context 'a simple roll with 0 pins down' do
    it 'the score must be 0' do
      game.roll(0)
      expect(game.score).to eq 0
    end
  end
end
