package dice.exercise_25;

import dice.exercise_23_24.Maexle;

import java.util.Arrays;

public class MaexleWithRules extends Maexle {
    public MaexleWithRules(int playerCount) {
        super(playerCount);
        Arrays.fill(lives, 3);
    }

    @Override
    public String play() {
        boolean winnerDetermined = false;
        int currentPlayer = 0;

        printPlayerList();

        while (!winnerDetermined) {

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
            if (lives[i] != 0) {

                if (lives[i] != 1) {
                    System.out.println("Player " + i + " won the game with " + lives[i] + " lives left");
                } else {
                    System.out.println("Player " + i + " won the game with " + lives[i] + " life left");
                }

            }
        }
        return winner;
    }

    private void tryToBreakRecord(int currentPlayer) {
        // if the player has lives left he attempts to break the record
        if (isAllowedToPlay(currentPlayer)) {
            printHighscore();
            boolean beatTheRecord = roll(currentMax, currentPlayer);
            if (!beatTheRecord) {
                // Player loses a life
                int livesLeft = lives[currentPlayer] - 1;
                lives[currentPlayer] = livesLeft;

                if (lives[currentPlayer] != 1) {
                    System.out.println("Player " + currentPlayer + " lost a life and has " + livesLeft + " lives left");
                } else {
                    System.out.println("Player " + currentPlayer + " lost a life and has " + livesLeft + " life left");
                }


                // Check to see if the round starts anew
                if (livesLeft >= 1) {
                    currentMax = -1;
                    Arrays.fill(highscore, 0);
                    roll(currentMax, currentPlayer);
                } else {
                    currentMax = -1;
                    Arrays.fill(highscore, 0);
                }
            }

            if (lives[currentPlayer] != 1) {
                System.out.println("Player " + currentPlayer + " has " + lives[currentPlayer] + " lives");
            } else {
                System.out.println("Player " + currentPlayer + " has " + lives[currentPlayer] + " life");
            }
        }
    }

    // Is allowed to play if the player has lives left and doesn't hold the highscore
    private boolean isAllowedToPlay(int currentPlayer) {
        return lives[currentPlayer] > 0 && highscore[currentPlayer] != currentMax;
    }
}
