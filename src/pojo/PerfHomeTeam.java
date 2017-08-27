package pojo;

/**
 * Created by yannx_000 on 17/06/2017.
 */
public class PerfHomeTeam extends PerfTeam {

    public PerfHomeTeam(){}

    public PerfHomeTeam(Team homeTeam, int idMatch, int countMatch, int scoredGoal, int takenGoal, float scoredGoalMean, float takenGoalMean,  float faceoffWinPercentageMatch, float faceoffWinGlobalRate, float winnerRate) {
        this.team = homeTeam;
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

    public String tableName() {
        return ("PerfHomeTeam");
    }
}
