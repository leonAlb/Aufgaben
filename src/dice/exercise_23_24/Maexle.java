package dice.exercise_23_24;

import dice.exercise_21.Dice;

import java.util.Arrays;

public class Maexle {
    final static int NUMBER_OF_SIDES = 6;

    protected int[] lives;
    protected int[] highscore;


    protected int currentMax = -1;

    final Dice diceOne;
    final Dice diceTwo;

    public Maexle(int playerCount) {
        if (playerCount < 2) {
            throw new IllegalArgumentException("Number of players must be greater than 2");
        }

        // Initializes the array with the amount of lives left
        lives = new int[playerCount];
        highscore = new int[playerCount];
        Arrays.fill(lives, 1);
        Arrays.fill(highscore, 0);

        this.diceOne = new Dice(NUMBER_OF_SIDES);
        this.diceTwo = new Dice(NUMBER_OF_SIDES);
    }

    public String play(){
        boolean winnerDetermined = false;
        int currentPlayer = 0;

        printPlayerList();

        while (!winnerDetermined){

            tryToBreakRecord(currentPlayer);

            currentPlayer = determineNextPlayer(currentPlayer);

            // checks the remaining lives and determines how many are left
            if (winnerAvailable(lives)) {
                winnerDetermined = true;
            }
        }

        // Declares the winner by looking at the index of the sole survivor
        String winner = "";
        for (int i = 0; i < lives.length; i++) {
            if (lives[i] != 0){
                winner = "Player " + i + " won the Game with " + lives[i] + " lives left";
            }
        }
        return winner;
    }

    private void tryToBreakRecord(int currentPlayer) {
        // if the player has lives left he attempts to break the record
        if (lives[currentPlayer] > 0){
            boolean beatTheRecord = roll(currentMax, currentPlayer);
            if (!beatTheRecord){
                int livesLeft = lives[currentPlayer] - 1;
                lives[currentPlayer] = livesLeft;
                System.out.println("Player " + currentPlayer + " lost a life and has " + livesLeft + " lives left");
            }
            printHighscore();
        }
    }

    /**
     * Returns true or false depending on the player in question managing to beat the currentMax
     *
     * @param valueToBeat - the highest rolled value to beat
     */
    protected boolean roll(int valueToBeat, int currentPlayer) {

        int rolledValue = rollDice();

        // Output for Exercise 24
        System.out.println(
                "Current player: " + currentPlayer +
                " | Max to beat: " + currentMax +
                " | Value rolled: " + rolledValue
        );

        // Highest possible value already reached, always loses
        if (valueToBeat == 21) {
            return false;
        }

        // Highest possible number, since it's not the currentMax
        if (rolledValue == 21) {
            this.currentMax = 21;
            highscore[currentPlayer] = 21;
            return true;
        }

        // Checks the number against doublets, if the currentMax is a doublet
        if (isDoublet(valueToBeat)) {
            return checkPairs(valueToBeat, rolledValue, currentPlayer);
        }

        // Since max can't be a doublet now the rolled value is sure to be higher
        if (isDoublet(rolledValue)) {
            this.currentMax = rolledValue;
            highscore[currentPlayer] = rolledValue;
            return true;
        }

        // replaces the currentMax if it has been beaten
        return compareValues(valueToBeat, rolledValue, currentPlayer);
    }

    private int rollDice() {
        // Rolls both die and combines them to their highest value
        int numberOne = diceOne.roll();
        int numberTwo = diceTwo.roll();
        return specialAdd(numberOne, numberTwo);
    }

    /**
     * Combines two integers by concatenating them as strings, with the larger number first.
     * The String is parsed back to an Integer and returned.
     *
     * @param number1 - First integer to combine
     * @param number2 - Second integer to combine
     * @return combined number
     */
    private int specialAdd(int number1, int number2) {
        String combined;
        if (number1 >= number2) {
            combined = "" + number1 + number2;
        } else {
            combined = "" + number2 + number1;
        }
        return Integer.parseInt(combined);
    }

    private boolean isDoublet(int number) {
        if (number == 0) {
            return false;
        }
        int firstDigit = number / 10;
        int secondDigit = number % 10;

        return firstDigit == secondDigit;
    }

    private boolean checkPairs(int valueToBeat, int rolledValue, int currentPlayer) {
        if (!isDoublet(rolledValue)) {
            return false;
        }

        return compareValues(valueToBeat, rolledValue, currentPlayer);
    }

    private boolean compareValues(int valueToBeat, int rolledValue, int currentPlayer) {
        if (rolledValue > valueToBeat) {
            this.currentMax = rolledValue;
            highscore[currentPlayer] = rolledValue;
            return true;
        } else {
            return false;
        }
    }

    protected boolean winnerAvailable(int[] players){
        int counter = 0;

        // Checks if all but one player lost all their lives
        for (int lives : players) {
            if (lives == 0) {
                counter++;
            }
        }

        return counter == players.length - 1;
    }

    protected int determineNextPlayer(int currentPlayer){
        int nextPlayer = (currentPlayer + 1) % lives.length;
        return nextPlayer;
    }

    protected void printPlayerList(){
        System.out.println("Number of players: " + lives.length);
        System.out.println("List of players: ");
        for (int i = 0; i < lives.length; i++) {
            System.out.println("Player " + i);
        }
        System.out.println("----------------------------------------------------");
    }

    protected void printHighscore(){

        int player = 0;
        for (int i = 0; i < highscore.length; i++) {
            if (highscore[i] == currentMax){
                player = i;
            }
        }
        System.out.println("Highscore: " + currentMax + " by Player: " + player);
    }
}
