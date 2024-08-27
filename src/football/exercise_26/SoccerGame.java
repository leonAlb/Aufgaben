package football.exercise_26;

import java.util.stream.IntStream;
import football.NumberUtils;

public class SoccerGame {
    private final static int HALFTIME = 45;
    private final static int TEAM_SIZE = 11;

    int overtimeOne;
    int overtimeTwo;

    int overallPlayTimeFirstHalf;
    int overallPlayTimeSecondHalf;


    Team teamOne;
    Team teamTwo;

    int currentTurn;
    int attackingPlayer;
    int defendingPlayer;

    int goalsTeamOne;
    int goalsTeamTwo;

    public SoccerGame() {
        // Creates two Teams and sets their score to 0
        teamOne = new Team();
        goalsTeamOne = 0;

        // Same procedure as for teamOne
        teamTwo = new Team();
        goalsTeamTwo = 0;

        // 0 => teamOne starts | 1 => teamTwo starts
        currentTurn = NumberUtils.generateNumberInRange(0,1);

        // random attacker and random defender (except goalkeepers)
        attackingPlayer = NumberUtils.generateNumberInRange(1,TEAM_SIZE - 1);
        defendingPlayer = NumberUtils.generateNumberInRange(1,TEAM_SIZE - 1);

        // randomized overtime
        overtimeOne = NumberUtils.generateNumberInRange(0,5);
        overtimeTwo = NumberUtils.generateNumberInRange(0,5);

        // calculate time to be played
        overallPlayTimeFirstHalf = HALFTIME + overtimeOne;
        overallPlayTimeSecondHalf = HALFTIME + overtimeTwo;

    }
}

