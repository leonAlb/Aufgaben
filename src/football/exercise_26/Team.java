package football.exercise_26;

import java.util.stream.IntStream;

public class Team {

    Player[] players;

    int sumGoalsShot;
    int sumGoalsConceded;

    public Team() {
        players = new Player[11];
        players[0] = new Player(true);
        IntStream.range(1, 11).forEach(i -> players[i] = new Player(false));

        sumGoalsShot = 0;
        sumGoalsConceded = 0;
    }
}
