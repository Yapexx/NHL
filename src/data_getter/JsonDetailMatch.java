package data_getter;


import com.google.gson.stream.JsonReader;
import pojo.*;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by yannx_000 on 18/06/2017.
 */

class JsonDetailMatch extends JsonTools {
    private StatsHomeMatch statsHomeMatch;
    private StatsAwayMatch statsAwayMatch;
    private PerfHomeTeam perfHomeTeam;
    private PerfAwayTeam perfAwayTeam;

    JsonDetailMatch(JsonReader reader) {
        super(reader);
    }

    StatsHomeMatch getStatsHomeMatch() {
        return (this.statsHomeMatch);
    }

    StatsAwayMatch getStatsAwayMatch() {
        return (this.statsAwayMatch);
    }

    PerfHomeTeam getPerfHomeTeam() {
        return (this.perfHomeTeam);
    }

    PerfAwayTeam getPerfAwayTeam() {
        return(this.perfAwayTeam);
    }

    void parseDetailGame() throws IOException {
        PojoDataGetter treatment;
        int onTargetShotAway = 0, onTargetShotHome =0, savedShotAway = 0, savedShotHome = 0, powerPlayOpportunity = 0, powerPlayScoredGoal = 0, powerPlayPenalty = 0, powerPlayTakenGoal = 0;
        int  scoredGoal = 0, takenGoal = 0;
        float faceOfWinPercent = 0;

        //La première team est toujours celle à l'extérieur

        if(!(this.findName("boxscore"))){ //On a pas vraiment besoin de boxscore
            System.out.print("NAME boxscore absent du json");
        }


        if (this.findName("goals")) {
            scoredGoal = this.reader.nextInt();
        }

        if(this.findName("shots")){
            onTargetShotAway = this.reader.nextInt();
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
            savedShotAway = this.reader.nextInt();
        }

        if (this.findName("powerPlayGoals")) {
            powerPlayTakenGoal = this.reader.nextInt();
        }

        if (this.findName("powerPlayOpportunities")) {
            powerPlayPenalty = this.reader.nextInt(); //Surement mettre à -1 si null
        }

        //Je peux avoir et l'id du match et les team domicile extérieur, Vérifier pour les buts la question de l'overtime

        this.perfHomeTeam = new PerfHomeTeam();
        this.perfAwayTeam = new PerfAwayTeam();

        this.statsAwayMatch = new StatsAwayMatch(team, 0, 0, scoredGoal , onTargetShotAway, 0, takenGoal, savedShotAway, 0, powerPlayScoredGoal, powerPlayOpportunity, 0,
                powerPlayTakenGoal, powerPlayPenalty, 0 );
        this.statsHomeMatch = new StatsHomeMatch(team, 0, 0, takenGoal, onTargetShotHome, 0, savedShotHome, 0, powerPlayTakenGoal, powerPlayPenalty, 0,
                powerPlayScoredGoal, powerPlayOpportunity, 0 );



        /**
         * Class to calcul all missing data like means
         */
        class DataCalculation{
            private PojoDataGetter dataGetter;

            private DataCalculation() {
                this.dataGetter = new PojoDataGetter();
            }

            private void perfMeans(PerfTeam perfTeam, boolean isHome) throws SQLException {
                int countMatch = perfTeam.getCountMatch();
                Team team = perfTeam.getTeam();
                float previousScoredMean = dataGetter.selectMean(countMatch, team,  isHome, "scored_goals_mean");
                float previousTakenMean = dataGetter.selectMean(countMatch, team, isHome, "taken_goals_mean");
                float previousFaceoffWin = dataGetter.selectMean(countMatch, team, isHome, "faceoffwin_globalrate");
                float newMeanScoredGoals = ((previousScoredMean * countMatch) + perfTeam.getScoredGoal())/((float)(countMatch+1));
                float newMeanTakenGoals = ((previousTakenMean * countMatch) + perfTeam.getTakenGoal())/((float)(countMatch+1));
                float newMeanFaceoffWin = ((previousFaceoffWin * countMatch) + perfTeam.getFaceoffWinPercentageMatch())/((float)(countMatch+1));
                perfTeam.setCountMatch(countMatch);
                perfTeam.setScoredGoalMean(newMeanScoredGoals);
                perfTeam.setTakenGoalMean(newMeanTakenGoals);
                perfTeam.setFaceoffWinGlobalRate(newMeanFaceoffWin);
            }

            private void statsMeans(StatsMatch statsMatch, boolean isHome) throws SQLException {
                Team team = statsMatch.getTeam();
                int sumScoredGoals = dataGetter.selectSumValue(team, isHome, "scored_goals" );
                int totalShoots = dataGetter.selectSumValue(team, isHome, "ontarget_shots" );
                int sumTakenShots = dataGetter.selectSumValue(team, isHome, "taken_shots" );
                int sumSavedShots = dataGetter.selectSumValue(team, isHome, "saved_shots" );
                int ppScoredGoals = dataGetter.selectSumValue(team, isHome, "powerplay_scored_goals" );
                int ppOpportunity = dataGetter.selectSumValue(team, isHome, "powerplay_opportunity" );
                int ppTakenGoals = dataGetter.selectSumValue(team, isHome, "powerplay_taken_goals" );
                int ppPenalty = dataGetter.selectSumValue(team, isHome, "powerplay_penalty" );
                float goalEfficiency = ((float)(sumScoredGoals + statsMatch.getScoredGoal()))/((float)(totalShoots + statsMatch.getOnTargetShot()));
                float savedRate = ((float)(sumSavedShots + statsMatch.getSavedShot()))/((float)(sumTakenShots + statsMatch.getTakenGoal()));
                float ppEfficiency = ((float)(ppScoredGoals + statsMatch.getPowerPlayScoredGoal()))/((float)(ppOpportunity + statsMatch.getPowerPlayOpportunity()));
                float ppDefense = ((float)(ppTakenGoals + statsMatch.getPowerPlayTakenGoal()))/((float)(ppPenalty + statsMatch.getPowerPlayPenalty()));
                statsMatch.setCountMatch(this.dataGetter.getCoutMatch(team, isHome));
                statsMatch.setGoalEfficiency(goalEfficiency);
                statsMatch.setSavedRate(savedRate);
                statsMatch.setPowerPlayEfficiency(ppEfficiency);
                statsMatch.setPowerPlayDefense(ppDefense);
            }

            private void main() {
                try {
                    this.perfMeans(perfHomeTeam, true);
                    this.perfMeans(perfAwayTeam, false);
                    this.statsMeans(statsHomeMatch, true);
                    this.statsMeans(statsAwayMatch, false);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        DataCalculation dataCalculation = new DataCalculation();
        dataCalculation.main();


    }
}

