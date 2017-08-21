package pojo;

/**
 * Created by yannx_000 on 17/06/2017.
 */
public class StatsAwayMatch {
    private Team awayTeam;
    private int idMatch;
    private int countMatch;
    private int scoredGoal;
    private int onTargetShot;
    private float goalEfficiency;
    private int takenGoal;
    private int savedShot;
    private float savedRate;
    private int powerPlayScoredGoal;
    private int powerPlayOpportunity;
    private float powerPlayEfficiency;
    private int powerPlayTakenGoal;
    private int powerPlayPenalty;
    private float powerPlayDefense;

    public StatsAwayMatch() {}

    public StatsAwayMatch(Team awayTeam, int idMatch, int countMatch, int scoredGoal, int onTargetShot, float goalEfficiency, int takenGoal, int savedShot, float savedRate, int powerPlayScoredGoal, int powerPlayOpportunity, float powerPlayEfficiency, int powerPlayTakenGoal, int powerPlayPenalty, float powerPlayDefense) {
        this.idMatch = idMatch;
        this.countMatch = countMatch;
        this.awayTeam = awayTeam;
        this.scoredGoal = scoredGoal;
        this.takenGoal = takenGoal;
        this.onTargetShot = onTargetShot;
        this.savedShot = savedShot;
        this.savedRate = savedRate;
        this.goalEfficiency = goalEfficiency;
        this.powerPlayScoredGoal = powerPlayScoredGoal;
        this.powerPlayOpportunity = powerPlayOpportunity;
        this.powerPlayEfficiency = powerPlayEfficiency;
        this.powerPlayTakenGoal = powerPlayTakenGoal;
        this.powerPlayPenalty = powerPlayPenalty;
        this.powerPlayDefense = powerPlayDefense;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public int getIdMatch() {
        return idMatch;
    }

    public int getCountMatch() {
        return countMatch;
    }

    public int getScoredGoal() {
        return scoredGoal;
    }

    public int getTakenGoal() {
        return takenGoal;
    }

    public int getOnTargetShot() {
        return onTargetShot;
    }

    public float getGoalEfficiency() {
        return goalEfficiency;
    }

    public int getSavedShot() {
        return savedShot;
    }

    public float getSavedRate() {
        return savedRate;
    }

    public int getPowerPlayScoredGoal() {
        return powerPlayScoredGoal;
    }

    public int getPowerPlayOpportunity() {
        return powerPlayOpportunity;
    }

    public float getPowerPlayEfficiency() {
        return powerPlayEfficiency;
    }

    public int getPowerPlayTakenGoal() {
        return powerPlayTakenGoal;
    }

    public int getPowerPlayPenalty() {
        return powerPlayPenalty;
    }

    public float getPowerPlayDefense() {
        return powerPlayDefense;
    }
}

