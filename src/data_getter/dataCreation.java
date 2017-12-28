package data_getter;

import bdd_connection.SdzConnection;
import dao.*;

import java.io.IOException;
import java.sql.Connection;

/**
 * Created by stagiaire3 on 23/06/2017.
 */
public class dataCreation {

    public static void dataTreatment(String url) {
        int gameToTreat = 0;
        int count = 1;
        Connection connection = SdzConnection.getInstance();
        MatchDAO matchDAO = new MatchDAO(connection);
        PerfAwayTeamDAO perfAwayTeamDAO = new PerfAwayTeamDAO(connection);
        PerfHomeTeamDAO perfHomeTeamDAO = new PerfHomeTeamDAO(connection);
        StatsAwayMatchDAO statsAwayMatchDAO = new StatsAwayMatchDAO(connection);
        StatsHomeMatchDAO statsHomeMatchDAO = new StatsHomeMatchDAO(connection);

        try {
            ReaderProvider rd = ReaderProvider.getInstance(url);
            JsonGlobalMatch globalMatchReader = new JsonGlobalMatch(rd.getReader());
            globalMatchReader.numberTotalMatch();
            gameToTreat = globalMatchReader.getTotalGames();

            System.out.println(gameToTreat + " to be treated");
            while (count <= gameToTreat) {
                globalMatchReader.parseGame();
                rd.setUrl(globalMatchReader.getLinkDetailMatch());
                JsonDetailMatch detailMatchReader = new JsonDetailMatch(rd.getReader(), globalMatchReader.getMatch());
                detailMatchReader.parseDetailGame();

                ///*
                //Add data into the base
                matchDAO.create(globalMatchReader.getMatch());
                perfAwayTeamDAO.create(detailMatchReader.getPerfAwayTeam());
                perfHomeTeamDAO.create(detailMatchReader.getPerfHomeTeam());
                statsAwayMatchDAO.create(detailMatchReader.getStatsAwayMatch());
                statsHomeMatchDAO.create(detailMatchReader.getStatsHomeMatch());
                //*/
                System.out.println("Game number : " + count);

                /*
                System.out.println("");
                System.out.println("Match processed number  : " + count);
                System.out.println(globalMatchReader.getMatch().toString());
                System.out.println(detailMatchReader.getPerfAwayTeam().toString());
                System.out.println(detailMatchReader.getPerfHomeTeam().toString());
                System.out.println(detailMatchReader.getStatsAwayMatch().toString());
                System.out.println(detailMatchReader.getStatsHomeMatch().toString());
                */

                count = count + 1;
            }
        }
        catch (IOException e) {
            System.out.println("Treatment interrupted on game " + count + " on " + gameToTreat );
            e.printStackTrace();
        }

        count = count - 1;
        System.out.println(count + " games have been added to the database");
    }
}
