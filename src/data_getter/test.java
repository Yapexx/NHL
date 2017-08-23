package data_getter;

import com.google.gson.stream.JsonReader;
import pojo.RevertTableTeam;
import pojo.TableTeam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by yannx_000 on 18/06/2017.
 */
public class test {

    public static void main(String args[]) throws IOException {
        /*
        URL oracle = new URL("https://statsapi.web.nhl.com/api/v1/schedule?startDate=2017-03-15&endDate=2017-03-15&expand=schedule.teams,schedule.linescore");
        URLConnection yc = oracle.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                yc.getInputStream()));
        InputStream inputLine = yc.getInputStream();
        JsonReader reader = new JsonReader(new InputStreamReader(inputLine));

        JsonGlobalMatch jsonTools = new JsonGlobalMatch(reader);
        jsonTools.parseGame();

        TableTeam table = TableTeam.getInstance();
        TableTeam.getInstance();
        */

        //ReaderProvider rd = ReaderProvider.getInstance("https://statsapi.web.nhl.com/api/v1/game/2016021033/feed/live");
        /*
        URL oracle1 = new URL("https://statsapi.web.nhl.com//api/v1/game/2016021033/feed/live");
        URLConnection yc1 = oracle1.openConnection();
        InputStream inputLine1 = yc1.getInputStream();
        */
        /*
        System.out.println(rd.getUrl());
        JsonDetailMatch jsonTools1 = new JsonDetailMatch(rd.getReader());
        jsonTools1.parseDetailGame();
        */

        TableTeam table = TableTeam.getInstance();
        String name = table.getTeam(10).getTeamName();
        System.out.println(name);
        RevertTableTeam revert = RevertTableTeam.getInstance();
        System.out.println(revert.getTeam(name).toString());

    }
}
