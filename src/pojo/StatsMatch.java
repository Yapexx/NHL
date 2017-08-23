package pojo;

/**
 * Created by stagiaire3 on 23/08/2017.
 */
public abstract class StatsMatch {
    protected Team team;
    protected int idMatch;
    protected int countMatch;
    protected int scoredGoal;
    protected int onTargetShot;
    protected float goalEfficiency;
    protected int takenGoal;
    protected int savedShot;
    protected float savedRate;
    protected int powerPlayScoredGoal;
    protected int powerPlayOpportunity;
    protected float powerPlayEfficiency;
    protected int powerPlayTakenGoal;
    protected int powerPlayPenalty;
    protected float powerPlayDefense;

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

    public Team getTeam() {
        return team;
    }

    public void setCountMatch(int countMatch) {
        this.countMatch = countMatch;
    }

    public void setGoalEfficiency(float goalEfficiency) {
        this.goalEfficiency = goalEfficiency;
    }

    public void setSavedRate(float savedRate) {
        this.savedRate = savedRate;
    }

    public void setPowerPlayEfficiency(float powerPlayEfficiency) {
        this.powerPlayEfficiency = powerPlayEfficiency;
    }

    public void setPowerPlayDefense(float powerPlayDefense) {
        this.powerPlayDefense = powerPlayDefense;
    }
}
