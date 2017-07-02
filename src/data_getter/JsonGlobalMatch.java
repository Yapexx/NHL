package data_getter;

import com.google.gson.stream.JsonReader;
import pojo.Match;
import pojo.TableTeam;
import pojo.Team;

import java.io.IOException;


/**
 * Created by yannx_000 on 18/06/2017.
 */
public class JsonGlobalMatch extends JsonTools {
    private Match match;
    private String linkDetailMatch = "";
    private int totalGames = 0;

    public JsonGlobalMatch(JsonReader reader) {
        super(reader);
    }

    private void setMatch(int idMatch, Team homeTeam, Team awayTeam, boolean overtime, boolean shootOut, Team winner){
        this.match = new Match(idMatch, homeTeam, awayTeam, overtime, shootOut, winner);
    }

    public String getLinkDetailMatch() {
        return (this.linkDetailMatch);
    }

    public int getTotalGames() {
        return (this.totalGames);
    }

    public Match getMatch() {
        return (this.match);
    }

    public void numberTotalMatch() throws IOException {
        this.findName("totalGames");
        totalGames = this.reader.nextInt();
    }

    private void setLinkDetailMatch(int idMatch) {
        String link = "https://statsapi.web.nhl.com/api/v1/game/";
        link = link + idMatch + "/feed/live";
    }

    /**
     * Method to get the data of one game
     */
    public void parseGame() throws IOException {
        TableTeam table = TableTeam.getInstance();
        int idGame = 0, homeScore = 0, awayScore = 0;
        Team homeTeam = null, awayTeam = null, winner = null;
        boolean overtime = false, hasShootout = false;


        if (this.findName("gamePk")) {
            idGame = this.reader.nextInt();
            this.setLinkDetailMatch(idGame);
        }
        else { //throw Exception more properly
           System.out.println("NAME gamepk not found in Json");
        }


        if (this.findName("score")) {
            awayScore = this.reader.nextInt();
        }
        else {
            System.out.println("score not found in json");
        }

        if(this.findName("id")) {
            awayTeam = table.getTeam(this.reader.nextInt());
        }

        if (this.findName("score")) {
            homeScore = this.reader.nextInt();
        }

        if(this.findName("id")) {
            homeTeam = table.getTeam(this.reader.nextInt());
        }

        if(this.findName("linescore")) {
            if(this.findName("currentPeriodOrdinal")) {
                switch (this.reader.nextString()) {
                    case "3rd":
                        break;
                    case "OT":
                        overtime = true;
                        break;
                    case "SO":
                        overtime = true;
                        hasShootout = true;
                        break;
                    default:
                        System.out.println("Situation inconnue");
                        break;
                }

            }
        }

        if (awayScore > homeScore) {
            winner = awayTeam;
        }
        else {
            winner = homeTeam;
        }

        this.setMatch(idGame, homeTeam, awayTeam, overtime, hasShootout, winner);

        //System.out.println(idGame + " " + homeScore + " " + awayScore + " " + homeTeam + awayTeam + hasShootout + overtime + " " +winner);



    }
}
