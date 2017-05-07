
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
      if @rolls[frame_index] == 10
        @score += @rolls[frame_index] + @rolls[frame_index + 1] + @rolls[frame_index + 2]
        frame_index += 1
      elsif spare?(frame_index)
        @score += frame_score + @rolls[frame_index + 2]
        frame_index += 2
      else
        @score += frame_score
        frame_index += 2
      end
    end
    @score
  end

  private

  def spare?(frame_index)
    @rolls[frame_index] + @rolls[frame_index + 1] == 10
  end
end
