package pojo;

/**
 * Created by yannx_000 on 17/06/2017.
 */
public class PerfAwayTeam {
    private Team awayTeam;
    private int idMatch;
    private int countMatch;
    private int scoredGoal;
    private int takenGoal;
    private float scoredGoalMean;
    private float takenGoalMean;
    private float faceoffWinPercentageMatch;
    private float faceoffWinGlobalRate;
    private float winnerRate;

    public PerfAwayTeam(){}

    public PerfAwayTeam(Team awayTeam, int idMatch, int countMatch, int scoredGoal, int takenGoal, float scoredGoalMean, float takenGoalMean, float winnerRate, float faceoffWinPercentageMatch, float faceoffWinGlobalRate  ) {
        this.awayTeam = awayTeam;
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
}
