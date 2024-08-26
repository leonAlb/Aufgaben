package dice.exercise_21;

public class RollWithArgs
{
    public static void main(String[] args)
    {
        int sides;
        try
        {
            sides = Integer.parseInt(args[0]);
        }
        catch (Exception e)
        {
            throw new RuntimeException("Valid number input needed");
        }
        Dice dice = new Dice(sides);

        for (int i = 0; i < sides; i++)
        {
            System.out.println(dice.roll());
        }
    }
}
