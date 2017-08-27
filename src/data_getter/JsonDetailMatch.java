package data_getter;


import com.google.gson.stream.JsonReader;
import pojo.*;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by yannx_000 on 18/06/2017.
 */

class JsonDetailMatch extends JsonTools {
    private Match match;
    private StatsHomeMatch statsHomeMatch;
    private StatsAwayMatch statsAwayMatch;
    private PerfHomeTeam perfHomeTeam;
    private PerfAwayTeam perfAwayTeam;

    JsonDetailMatch(JsonReader reader, Match match) {
        super(reader);
        this.match = match;
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
        int onTargetShotAway = 0, onTargetShotHome =0, powerPlayOpportunity = 0, powerPlayScoredGoal = 0, powerPlayPenalty = 0, powerPlayTakenGoal = 0;
        int  scoredGoal = 0, takenGoal = 0;
        float faceOfWinPercent = 0;

        //La première team est toujours celle à l'extérieur

        if(!(this.findName("boxscore"))){
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
            powerPlayOpportunity = this.reader.nextInt();
        }

        if(this.findName("faceOffWinPercentage")){
            faceOfWinPercent = (float)this.reader.nextDouble() / 100;
        }

        //Pour l'équipe à Domicile il faut uniquement les powersplays
        if(!this.findName("teamStats")){
            System.out.println("lever l'exception plus proprement");
        }

        if (this.findName("goals")) {
            takenGoal = this.reader.nextInt();
        }

        if(this.findName("shots")){
            onTargetShotHome = this.reader.nextInt();
        }

        if (this.findName("powerPlayGoals")) {
            powerPlayTakenGoal = this.reader.nextInt();
        }

        if (this.findName("powerPlayOpportunities")) {
            powerPlayPenalty = this.reader.nextInt();
        }

        //Always score after overtime but not shootout
        this.perfHomeTeam = new PerfHomeTeam(this.match.getHomeTeam(), this.match.getIdMatch(), 0, takenGoal, scoredGoal, 0, 0, 1-faceOfWinPercent, 0, 0);
        this.perfAwayTeam = new PerfAwayTeam(this.match.getAwayTeam(), this.match.getIdMatch(), 0, scoredGoal, takenGoal, 0, 0, faceOfWinPercent, 0, 0);

        this.statsAwayMatch = new StatsAwayMatch(this.match.getAwayTeam(), this.match.getIdMatch(), 0, scoredGoal , onTargetShotAway, 0, takenGoal, onTargetShotHome-takenGoal, 0, powerPlayScoredGoal, powerPlayOpportunity, 0,
                powerPlayTakenGoal, powerPlayPenalty, 0 );
        this.statsHomeMatch = new StatsHomeMatch(this.match.getHomeTeam(), this.match.getIdMatch(), 0, takenGoal , onTargetShotHome, 0, scoredGoal, onTargetShotAway-scoredGoal, 0, powerPlayTakenGoal, powerPlayPenalty, 0,
                powerPlayScoredGoal, powerPlayOpportunity, 0 );


        /*
         * Class to calcul all missing data like means
         */
        class DataCalculation{
            private PojoDataGetter dataGetter;

            private DataCalculation() {
                this.dataGetter = new PojoDataGetter();
            }

            private int isWinner(Team team) {
               int winner = 0;
               if (team.getTeamName().equals(match.getWinner().getTeamName())) {
                    winner = 1;
                }
                return winner;
            }

            private void perfMeans(PerfTeam perfTeam) throws SQLException {
                String tableName = perfTeam.tableName();
                Team team = perfTeam.getTeam();
                int countMatch = dataGetter.getCoutMatch(team, tableName);
                float previousScoredMean = dataGetter.selectMean(countMatch, team,  tableName, "scored_goals_mean");
                float previousTakenMean = dataGetter.selectMean(countMatch, team, tableName, "taken_goals_mean");
                float previousFaceoffWin = dataGetter.selectMean(countMatch, team, tableName, "faceoffwin_global_rate");
                float previousWinnerRate = dataGetter.selectMean(countMatch, team, tableName, "winner_rate");
                float newMeanScoredGoals = ((previousScoredMean * countMatch) + perfTeam.getScoredGoal())/((float)(countMatch+1));
                float newMeanTakenGoals = ((previousTakenMean * countMatch) + perfTeam.getTakenGoal())/((float)(countMatch+1));
                float newMeanFaceoffWin = ((previousFaceoffWin * countMatch) + perfTeam.getFaceoffWinPercentageMatch())/((float)(countMatch+1));
                float newWinnerRate = ((previousWinnerRate * countMatch) + this.isWinner(team))/((float)(countMatch+1));

                perfTeam.setCountMatch(countMatch+1);
                perfTeam.setScoredGoalMean(newMeanScoredGoals);
                perfTeam.setTakenGoalMean(newMeanTakenGoals);
                perfTeam.setFaceoffWinGlobalRate(newMeanFaceoffWin);
                perfTeam.setWinnerRate(newWinnerRate);
            }

            private void statsMeans(StatsMatch statsMatch) throws SQLException {
                Team team = statsMatch.getTeam();
                String tableName = statsMatch.tableName();
                int sumScoredGoals = dataGetter.selectSumValue(team, tableName, "scored_goals" );
                int totalShoots = dataGetter.selectSumValue(team, tableName, "on_target_shots" );
                int sumTakenGoals = dataGetter.selectSumValue(team, tableName, "taken_goals" );
                int sumSavedShots = dataGetter.selectSumValue(team, tableName, "saved_shots" );
                int ppScoredGoals = dataGetter.selectSumValue(team, tableName, "powerplay_scored_goals" );
                int ppOpportunity = dataGetter.selectSumValue(team, tableName, "powerplay_opportunities" );
                int ppTakenGoals = dataGetter.selectSumValue(team, tableName, "powerplay_taken_goals" );
                int ppPenalty = dataGetter.selectSumValue(team, tableName, "powerplay_penalties" );
                float goalEfficiency = ((float)(sumScoredGoals + statsMatch.getScoredGoal()))/((float)(totalShoots + statsMatch.getOnTargetShot()));
                float savedRate = ((float)(sumSavedShots + statsMatch.getSavedShot()))/((float)(sumSavedShots + statsMatch.getSavedShot() + sumTakenGoals + statsMatch.getTakenGoal()));
                float ppEfficiency = ((float)(ppScoredGoals + statsMatch.getPowerPlayScoredGoal()))/((float)(ppOpportunity + statsMatch.getPowerPlayOpportunity()));
                float ppDefense = 1 - ((float)(ppTakenGoals + statsMatch.getPowerPlayTakenGoal()))/((float)(ppPenalty + statsMatch.getPowerPlayPenalty()));
                statsMatch.setCountMatch(this.dataGetter.getCoutMatch(team, tableName)+1);
                statsMatch.setGoalEfficiency(goalEfficiency);
                statsMatch.setSavedRate(savedRate);
                statsMatch.setPowerPlayEfficiency(ppEfficiency);
                statsMatch.setPowerPlayDefense(ppDefense);
            }

            private void main() {
                try {
                    this.perfMeans(perfHomeTeam);
                    this.perfMeans(perfAwayTeam);
                    this.statsMeans(statsHomeMatch);
                    this.statsMeans(statsAwayMatch);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        DataCalculation dataCalculation = new DataCalculation();
        dataCalculation.main();


    }
}

