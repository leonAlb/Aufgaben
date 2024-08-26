package dice.exercise_21;

public class Dice
{
    protected int sides;

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