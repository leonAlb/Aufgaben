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
        return (int) (Math.random() * sides) + 1;
    }
}