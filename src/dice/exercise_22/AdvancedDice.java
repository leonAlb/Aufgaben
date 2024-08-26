package dice.exercise_22;

import dice.exercise_21.Dice;

public class AdvancedDice extends Dice
{
    int sum = 0;
    public AdvancedDice(int sides) {
        super(sides);
    }

    public int roll()
    {
        int value = (int) (Math.random() * sides) + 1;
        sumUp(value);
        return value;
    }

    private void sumUp(int diceThrow)
    {
        sum += diceThrow;
    }

    public void reset()
    {
        this.sum = 0;
    }

    public int getSum(){
        return sum;
    }
}
