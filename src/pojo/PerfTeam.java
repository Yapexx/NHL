package pojo;

/**
 * Created by stagiaire3 on 23/08/2017.
 */
public abstract class PerfTeam {
    protected Team team;
    protected int idMatch;
    protected int countMatch;
    protected int scoredGoal;
    protected int takenGoal;
    protected float scoredGoalMean;
    protected float takenGoalMean;
    protected float faceoffWinPercentageMatch;
    protected float faceoffWinGlobalRate;
    protected float winnerRate;

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

    public float getScoredGoalMean() {
        return scoredGoalMean;
    }

    public float getTakenGoalMean() {
        return takenGoalMean;
    }

    public float getFaceoffWinPercentageMatch() {
        return faceoffWinPercentageMatch;
    }

    public float getFaceoffWinGlobalRate() {
        return faceoffWinGlobalRate;
    }

    public float getWinnerRate() {
        return winnerRate;
    }

    public void setCountMatch(int countMatch) {
        this.countMatch = countMatch;
    }

    public Team getTeam() {
        return team;
    }

    public void setScoredGoalMean(float scoredGoalMean) {
        this.scoredGoalMean = scoredGoalMean;
    }

    public void setTakenGoalMean(float takenGoalMean) {
        this.takenGoalMean = takenGoalMean;
    }

    public void setFaceoffWinGlobalRate(float faceoffWinGlobalRate) {
        this.faceoffWinGlobalRate = faceoffWinGlobalRate;
    }

    public void setWinnerRate(float winnerRate) {
        this.winnerRate = winnerRate;
    }

    public String toString() {
        String info = this.idMatch + "/" + this.countMatch + "/" + this.team + "/" + this.scoredGoal + "/" + this.takenGoal + "/" + " Moyenne : " + this.scoredGoalMean + "/" + this.takenGoalMean
                + "/" + this.faceoffWinPercentageMatch + "/" + "  faceoffglobalrate : " + this.faceoffWinGlobalRate + "/" + this.winnerRate;
        return (info);
    }

    public abstract String tableName();

}
