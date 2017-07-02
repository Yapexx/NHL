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

    public void parseDetailGame() throws IOException {
        int onTargetShot = 0, savedShot = 0, powerPlayOpportunity, powerPlayScoredGoal, powerPlayPenalty, powerPlayTakenGoal;
        //int  scoredGoal, takenGoal;
        float faceOfWinPercent = 0;

        //La première team est toujours celle à l'eérieur

        if(!(this.findName("boxscore"))){ //On a pas vraiment besoin de boxscore
            System.out.print("NAME boxscore absent du json");
        }

        /*
        Est ce qu'on traite le nombre de buts là ?
        if( this.findName("goal"))
        */

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
        //Question aussi du nombre de but

        if(this.findName("shots")){
            savedShot = this.reader.nextInt();
        }

        if (this.findName("powerPlayGoals")) {
            powerPlayTakenGoal = this.reader.nextInt();
        }

        if (this.findName("powerPlayOpportunities")) {
            powerPlayPenalty = this.reader.nextInt(); //Surement mettre à -1 si null
        }

        System.out.println(onTargetShot + " " + savedShot +  " " + faceOfWinPercent);

    }
}
