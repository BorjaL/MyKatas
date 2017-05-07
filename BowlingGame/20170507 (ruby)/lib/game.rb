
class Game
  def initialize
    @score = 0
    @rolls = []
    @frame_index = 0
  end

  def roll(pins_knowcked_down)
    @rolls << pins_knowcked_down
  end

  def score
    10.times do
      if strike?
        @score += @rolls[@frame_index] + @rolls[@frame_index + 1] + @rolls[@frame_index + 2]
        @frame_index += 1
      elsif spare?
        @score += frame_score + @rolls[@frame_index + 2]
        @frame_index += 2
      else
        @score += frame_score
        @frame_index += 2
      end
    end
    @score
  end

  private

  def spare?
    @rolls[@frame_index] + @rolls[@frame_index + 1] == 10
  end

  def strike?
    @rolls[@frame_index] == 10
  end

  def frame_score
    @rolls[@frame_index] + @rolls[@frame_index + 1]
  end
end
