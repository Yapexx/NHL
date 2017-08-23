package pojo;

/**
 * Created by yannx_000 on 17/06/2017.
 */
public class StatsHomeMatch extends StatsMatch{
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

    public StatsHomeMatch() {}

    public StatsHomeMatch(Team homeTeam, int idMatch, int countMatch, int scoredGoal, int onTargetShot, float goalEfficiency, int takenGoal, int savedShot, float savedRate, int powerPlayScoredGoal, int powerPlayOpportunity, float powerPlayEfficiency, int powerPlayTakenGoal, int powerPlayPenalty, float powerPlayDefense) {
        this.idMatch = idMatch;
        this.countMatch = countMatch;
        this.team = homeTeam;
        this.scoredGoal = scoredGoal;
        this.onTargetShot = onTargetShot;
        this.goalEfficiency = goalEfficiency;
        this.takenGoal = takenGoal;
        this.savedShot = savedShot;
        this.savedRate = savedRate;
        this.powerPlayScoredGoal = powerPlayScoredGoal;
        this.powerPlayOpportunity = powerPlayOpportunity;
        this.powerPlayEfficiency = powerPlayEfficiency;
        this.powerPlayTakenGoal = powerPlayTakenGoal;
        this.powerPlayPenalty = powerPlayPenalty;
        this.powerPlayDefense = powerPlayDefense;
    }
}
