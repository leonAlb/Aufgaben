package dice.exercise_22;

public class TestMethods
{
    public static void main(String[] args)
    {
        AdvancedDice dice = new AdvancedDice(6);
        for (int i = 0; i < 6; i++)
        {
            int roll = dice.roll();
            System.out.println("Dice roll: " + roll);
            System.out.println("Current sum: " + dice.getSum());
        }

        dice.reset();
        System.out.println("Reset");

        System.out.println("Current sum: " + dice.getSum());
    }
}
