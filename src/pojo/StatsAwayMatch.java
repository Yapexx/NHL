package pojo;

/**
 * Created by yannx_000 on 17/06/2017.
 */
public class StatsAwayMatch {
    private Team awayTeam;
    private int idMatch;
    private int countMatch;
    private int scoredGoal;
    private int takenGoal;
    private int onTargetShot;
    private float goalEfficiency;
    private int savedShot;
    private float savedRate;
    private int powerPlayScoredGoal;
    private int powerPlayOpportunitie;
    private float powerPlayEfficiency;
    private int powerPlayTakenGoal;
    private int powerPlayPenalty;
    private float powerPlayDefense;



    public StatsAwayMatch(int idMatch, int countMatch, Team awayTeam, int savedShot, float savedRate, int scoredGoal, int takenGoal, int onTargetShot, float goalEfficiency, int powerPlayScoredGoal, int powerPlayOpportunitie, float powerPlayEfficiency, int powerPlayTakenGoal, int powerPlayPenalty, float powerPlayDefense, int powerlayPercent) {
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
        this.powerPlayOpportunitie = powerPlayOpportunitie;
        this.powerPlayEfficiency = powerPlayEfficiency;
        this.powerPlayTakenGoal = powerPlayTakenGoal;
        this.powerPlayPenalty = powerPlayPenalty;
        this.powerPlayDefense = powerPlayDefense;
    }
}
