package pojo;

/**
 * Created by yannx_000 on 17/06/2017.
 */
public class PerfHomeTeam {
    private Team homeTeam;
    private int idMatch;
    private int countMatch;
    private int scoredGoal;
    private int takenGoal;
    private float scoredGoalMean;
    private float takenGoalMean;
    private float faceoffWinPercentageMatch;
    private float faceoffWinGlobalRate;
    private float winnerRate;

    public PerfHomeTeam(){}

    public PerfHomeTeam(Team homeTeam, int idMatch, int countMatch, int scoredGoal, int takenGoal, float scoredGoalMean, float takenGoalMean, float winnerRate, float faceoffWinPercentageMatch, float faceoffWinGlobalRate ) {
        this.homeTeam = homeTeam;
        this.idMatch = idMatch;
        this.countMatch = countMatch;
        this.scoredGoal = scoredGoal;
        this.takenGoal = takenGoal;
        this.scoredGoalMean = scoredGoalMean;
        this.takenGoalMean = takenGoalMean;
        this.faceoffWinPercentageMatch = faceoffWinPercentageMatch;
        this.faceoffWinGlobalRate = faceoffWinGlobalRate;
        this.winnerRate = winnerRate;
    }

    public Team getHomeTeam() {
        return homeTeam;
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
}
