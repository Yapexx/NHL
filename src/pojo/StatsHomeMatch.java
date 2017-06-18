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
    private int givenpowerPlay;
    private int powerPlayScoredGoal;
    private int powerPlayOpportunitie;
    private int powerPlayTakenGoal;
    private int powerPlayPenalty;
    private float powerPlayDefense;
    private int powerlayPercent;
    private float faceoffWinPercentage;


    public StatsHomeMatch(int idMatch, int countMatch, Team awayTeam, int scoredGoal, int onTargetShot, float goalEfficiency, int givenpowerPlay, int powerPlayScoredGoal, int powerPlayOpportunitie, int powerPlayTakenGoal, int powerPlayPenalty, float powerPlayDefense, int powerlayPercent, float faceoffWinPercentage) {
        this.idMatch = idMatch;
        this.countMatch = countMatch;
        this.awayTeam = awayTeam;
        this.scoredGoal = scoredGoal;
        this.onTargetShot = onTargetShot;
        this.goalEfficiency = goalEfficiency;
        this.givenpowerPlay = givenpowerPlay;
        this.powerPlayScoredGoal = powerPlayScoredGoal;
        this.powerPlayOpportunitie = powerPlayOpportunitie;
        this.powerPlayTakenGoal = powerPlayTakenGoal;
        this.powerPlayPenalty = powerPlayPenalty;
        this.powerPlayDefense = powerPlayDefense;
        this.powerlayPercent = powerlayPercent;
        this.faceoffWinPercentage = faceoffWinPercentage;
    }
}
