package dice;

public class Dice
{
    int sides;
    int sum = 0;

    public Dice(int sides)
    {
        this.sides = sides;
    }

    private Dice()
    {
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
}