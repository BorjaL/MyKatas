
class Game
  def initialize
    @score = 0
    @rolls = []
  end

  def roll(pins_knowcked_down)
    @rolls << pins_knowcked_down
  end

  def score
    frame_index = 0
    10.times do
      frame_score = @rolls[frame_index] + @rolls[frame_index + 1]
      @score += frame_score
      frame_index += 2
    end
    @score
  end
end
