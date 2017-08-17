package data_getter;

import com.google.gson.stream.JsonReader;
import pojo.StatsAwayMatch;
import pojo.StatsHomeMatch;

import java.io.IOException;

/**
 * Created by yannx_000 on 18/06/2017.
 */
public class JsonDetailMatch extends JsonTools {
    private StatsHomeMatch homeStats;
    private StatsAwayMatch awayStats;

    public JsonDetailMatch(JsonReader reader) {
        super(reader);
    }

    public StatsHomeMatch getHomeStats() {
        return (this.homeStats);
    }

    public StatsAwayMatch getAwayStats() {
        return (this.awayStats);
    }

    public void parseDetailGame() throws IOException {
        PojoDataGetter treatment;
        int
        int onTargetShot = 0, savedShot = 0, powerPlayOpportunity = 0, powerPlayScoredGoal = 0, powerPlayPenalty = 0, powerPlayTakenGoal = 0;
        int  scoredGoal, takenGoal;
        float faceOfWinPercent = 0;

        //La première team est toujours celle à l'extérieur

        if(!(this.findName("boxscore"))){ //On a pas vraiment besoin de boxscore
            System.out.print("NAME boxscore absent du json");
        }


        if (this.findName("goals")) {
            scoredGoal = this.reader.nextInt();
        }

        if(this.findName("shots")){
            onTargetShot = this.reader.nextInt();
        }
        if (this.findName("powerPlayGoals")) {
            powerPlayScoredGoal = this.reader.nextInt();
        }

        if (this.findName("powerPlayOpportunities")) {
            powerPlayOpportunity = this.reader.nextInt(); //Surement mettre à -1 si null
        }

        if(this.findName("faceOffWinPercentage")){
            faceOfWinPercent = (float)this.reader.nextDouble();
        }

        //Pour l'équipe à Domicile il faut uniquement les powersplays
        if(!this.findName("teamStats")){
            System.out.println("lever l'exception plus proprement");
        }

        if (this.findName("goals")) {
            takenGoal = this.reader.nextInt();
        }

        if(this.findName("shots")){
            savedShot = this.reader.nextInt();
        }

        if (this.findName("powerPlayGoals")) {
            powerPlayTakenGoal = this.reader.nextInt();
        }

        if (this.findName("powerPlayOpportunities")) {
            powerPlayPenalty = this.reader.nextInt(); //Surement mettre à -1 si null
        }

        awayStats = new StatsAwayMatch(0, 0, idteam, enattente, attd, onTargetShot, 0, savedShot, 0, powerPlayScoredGoal, powerPlayOpportunity, 0,
                powerPlayTakenGoal, powerPlayPenalty, 0 );
        homeStats = new StatsHomeMatch(0, 0, idteam, enattente, attd, onTargetShot, 0, savedShot, 0, powerPlayScoredGoal, powerPlayOpportunity, 0,
                powerPlayTakenGoal, powerPlayPenalty, 0 );


        //On effectue le traitement pour JsonDetailMatch
        //Récupérer le numéro du match
        PojoDataGetter treatment = new PojoDataGetter();
        int countMatchHome = treatment.getCoutMatch(true);
        int lastMean = treatment.selectMean(countMatchHome, , true, "");








        System.out.println(onTargetShot + " " + savedShot +  " " + faceOfWinPercent);

        class dataCalcultaion{
        }

    }
}

