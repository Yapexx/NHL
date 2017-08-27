package pojo;

/**
 * Created by yannx_000 on 17/06/2017.
 */
public class StatsAwayMatch extends StatsMatch {

    public StatsAwayMatch() {}

    public StatsAwayMatch(Team awayTeam, int idMatch, int countMatch, int scoredGoal, int onTargetShot, float goalEfficiency, int takenGoal, int savedShot, float savedRate, int powerPlayScoredGoal, int powerPlayOpportunity, float powerPlayEfficiency, int powerPlayTakenGoal, int powerPlayPenalty, float powerPlayDefense) {
        this.idMatch = idMatch;
        this.countMatch = countMatch;
        this.team = awayTeam;
        this.scoredGoal = scoredGoal;
        this.takenGoal = takenGoal;
        this.onTargetShot = onTargetShot;
        this.savedShot = savedShot;
        this.savedRate = savedRate;
        this.goalEfficiency = goalEfficiency;
        this.powerPlayScoredGoal = powerPlayScoredGoal;
        this.powerPlayOpportunity = powerPlayOpportunity;
        this.powerPlayEfficiency = powerPlayEfficiency;
        this.powerPlayTakenGoal = powerPlayTakenGoal;
        this.powerPlayPenalty = powerPlayPenalty;
        this.powerPlayDefense = powerPlayDefense;
    }

    public String tableName() {
        return ("StatsAwayMatch");
    }
}

