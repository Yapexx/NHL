package data_getter;

import com.google.gson.stream.JsonReader;
import pojo.TableTeam;
import pojo.Team;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by yannx_000 on 18/06/2017.
 */
public class JsonGlobalMatch extends JsonTools {
    private ArrayList matchList = new ArrayList();
    private int totalGames = 0;

    public JsonGlobalMatch(JsonReader reader) {
        super(reader);
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

        //System.out.println(idGame + " " + homeScore + " " + awayScore + " " + homeTeam + awayTeam + hasShootout + overtime + " " +winner);

    }
}
