
class Game
  attr_reader :score

  def initialize
    @score = 0
  end

  def roll(pins_knowcked_down)
    @score = pins_knowcked_down
  end
end
