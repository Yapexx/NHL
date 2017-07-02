package pojo;

/**
 * Created by yannx_000 on 17/06/2017.
 */
public class StatsAwayMatch {
    private int idMatch;
    private int countMatch;
    private Team homeTeam;
    private int scoredGoal;
    private int onTargetShotAgainst;
    private int takenGoal;
    private int onTargetShot;
    private float goalEfficiency;
    private int powerPlayScoredGoal;
    private int powerPlayOpportunitie;
    private float powerPlayEfficiency;
    private int powerPlayTakenGoal;
    private int powerPlayPenalty;
    private float powerPlayDefense;
    private int powerlayPercent;
    private float faceoffWinPercentage;


    public StatsAwayMatch(int idMatch, int countMatch, Team homeTeam, int scoredGoal, int takenGoal, int onTargetShot, float goalEfficiency, int powerPlayScoredGoal, int powerPlayOpportunitie, float powerPlayEfficiency, int powerPlayTakenGoal, int powerPlayPenalty, float powerPlayDefense, int powerlayPercent, float faceoffWinPercentage) {
        this.idMatch = idMatch;
        this.countMatch = countMatch;
        this.homeTeam = homeTeam;
        this.scoredGoal = scoredGoal;
        this.takenGoal = takenGoal;
        this.onTargetShot = onTargetShot;
        this.goalEfficiency = goalEfficiency;
        this.powerPlayEfficiency = powerPlayEfficiency;
        this.powerPlayScoredGoal = powerPlayScoredGoal;
        this.powerPlayOpportunitie = powerPlayOpportunitie;
        this.powerPlayTakenGoal = powerPlayTakenGoal;
        this.powerPlayPenalty = powerPlayPenalty;
        this.powerPlayDefense = powerPlayDefense;
        this.powerlayPercent = powerlayPercent;
        this.faceoffWinPercentage = faceoffWinPercentage;
    }
}
