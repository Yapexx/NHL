package pojo;

/**
 * Created by yannx_000 on 17/06/2017.
 */
public class StatsHomeMatch {
    private int idMatch;
    private int countMatch;
    private Team awayTeam;
    private int scoredGoal;
    private int onTargetShot;
    private float goalEfficiency;
    private int takenGoal;
    private int savedShot;
    private float savedRate;
    private int powerPlayScoredGoal;
    private int powerPlayOpportunitie;
    private float powerPlayEfficiency;
    private int powerPlayTakenGoal;
    private int powerPlayPenalty;
    private float powerPlayDefense;
    private float faceoffWinPercentage;


    public StatsHomeMatch(int idMatch, int countMatch, Team awayTeam, int scoredGoal, int onTargetShot, float goalEfficiency, int takenGoal, int savedShot, float savedRate, int powerPlayScoredGoal, int powerPlayOpportunitie, float powerPlayEfficiency, int powerPlayTakenGoal, int powerPlayPenalty, float powerPlayDefense, float faceoffWinPercentage) {
        this.idMatch = idMatch;
        this.countMatch = countMatch;
        this.awayTeam = awayTeam;
        this.scoredGoal = scoredGoal;
        this.onTargetShot = onTargetShot;
        this.goalEfficiency = goalEfficiency;
        this.takenGoal = takenGoal;
        this.savedShot = savedShot;
        this.savedRate = savedRate;
        this.powerPlayScoredGoal = powerPlayScoredGoal;
        this.powerPlayOpportunitie = powerPlayOpportunitie;
        this.powerPlayEfficiency = powerPlayEfficiency;
        this.powerPlayTakenGoal = powerPlayTakenGoal;
        this.powerPlayPenalty = powerPlayPenalty;
        this.powerPlayDefense = powerPlayDefense;
        this.faceoffWinPercentage = faceoffWinPercentage;
    }
}
