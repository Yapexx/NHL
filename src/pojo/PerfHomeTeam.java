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
    private float winnerRate;

    public PerfHomeTeam(Team homeTeam, int idMatch, int countMatch, int scoredGoal, int takenGoal, float scoredGoalMean, float takenGoalMean, float winnerRate  ) {
        this.homeTeam = homeTeam;
        this.idMatch = idMatch;
        this.countMatch = countMatch;
        this.scoredGoal = scoredGoal;
        this.takenGoal = takenGoal;
        this.scoredGoalMean = scoredGoalMean;
        this.takenGoalMean = takenGoalMean;
        this.winnerRate = winnerRate;
    }
}
