package pojo;

/**
 * Created by yannx_000 on 17/06/2017.
 */
public class PerfAwayTeam extends PerfTeam {

    public PerfAwayTeam(){}

    public PerfAwayTeam(Team awayTeam, int idMatch, int countMatch, int scoredGoal, int takenGoal, float scoredGoalMean, float takenGoalMean, float winnerRate, float faceoffWinPercentageMatch, float faceoffWinGlobalRate  ) {
        this.team = awayTeam;
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
