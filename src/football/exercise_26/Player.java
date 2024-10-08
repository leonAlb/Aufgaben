package football.exercise_26;

import football.NumberUtils;

public class Player {
    private final static int MINIMAL_SKILL = 25;
    private final static int MAXIMAL_SKILL = 50;

    final int shootSkill;
    final int passSkill;
    final int dribbleSkill;
    final int defendSkill;
    final int catchSkill;

    // TODO bekommt eine Angriff und Verteidigungsstrategie der dem Verteidiger übergeben werden kann
    // TODO also attackMove() und defendMove() gibt jeweils true false zurück wenn erfolgreich
    // TODO erfolgreiche Verteidigung muss den switch der "turn" variable machen


    final boolean goalKeeper;
    int positionBonus = 0;

    public Player(boolean goalKeeper) {
        this.shootSkill = NumberUtils.generateNumberInRange(MINIMAL_SKILL, MAXIMAL_SKILL);
        this.passSkill = NumberUtils.generateNumberInRange(MINIMAL_SKILL, MAXIMAL_SKILL);
        this.dribbleSkill = NumberUtils.generateNumberInRange(MINIMAL_SKILL, MAXIMAL_SKILL);
        this.defendSkill = NumberUtils.generateNumberInRange(MINIMAL_SKILL, MAXIMAL_SKILL);
        this.catchSkill = NumberUtils.generateNumberInRange(MINIMAL_SKILL, MAXIMAL_SKILL);

        this.goalKeeper = goalKeeper;
    }

    public void increasePositionBonus() {
        positionBonus += 5;
    }

    public void resetPositionBonus() {
        this.positionBonus = 0;
    }

}
