package football.exercise_26;

public class Player {
    private final static int MINIMAL_SKILL = 25;
    private final static int MAXIMAL_SKILL = 50;

    final int shootSkill;
    final int passSkill;
    final int dribbleSkill;
    final int defendSkill;
    final int catchSkill;

    final boolean goalKeeper;
    int positionBonus = 0;

    public Player(boolean goalKeeper) {
        this.shootSkill = generateRandomSkills();
        this.passSkill = generateRandomSkills();
        this.dribbleSkill = generateRandomSkills();
        this.defendSkill = generateRandomSkills();
        this.catchSkill = generateRandomSkills();

        this.goalKeeper = goalKeeper;
    }

    private int generateRandomSkills(){
        return MINIMAL_SKILL + (int)(Math.random() * ((MAXIMAL_SKILL - MINIMAL_SKILL) + 1));
    }



}
