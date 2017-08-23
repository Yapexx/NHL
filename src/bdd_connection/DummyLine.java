package bdd_connection;

import dao.PerfAwayTeamDAO;
import dao.PerfHomeTeamDAO;
import dao.StatsAwayMatchDAO;
import dao.StatsHomeMatchDAO;
import pojo.*;

/**
 * Created by yannx_000 on 20/08/2017.
 */

//To add empty line in all the table of the bdd
public class DummyLine {

    public static void insertLines(){
        for (Team team : Team.values()) {
            PerfAwayTeam perfAwayTeam = new PerfAwayTeam(team ,0, 0, 0, 0, 0, 0, 0, 0, 0);
            PerfHomeTeam perfHomeTeam = new PerfHomeTeam(team, 0,0,0,0,0,0,0,0,0);
            StatsAwayMatch statsAwayMatch = new StatsAwayMatch(team, 0,0,0,0,0,0,0,0,0,0,0,0,0,0);
            StatsHomeMatch statsHomeMatch = new StatsHomeMatch(team, 0,0,0,0,0,0,0,0,0,0,0,0,0,0);
            PerfAwayTeamDAO perfAwayTeamDAO = new PerfAwayTeamDAO(SdzConnection.getInstance());
            PerfHomeTeamDAO perfHomeTeamDAO = new PerfHomeTeamDAO(SdzConnection.getInstance());
            StatsAwayMatchDAO statsAwayMatchDAO = new StatsAwayMatchDAO(SdzConnection.getInstance());
            StatsHomeMatchDAO statsHomeMatchDAO = new StatsHomeMatchDAO(SdzConnection.getInstance());

            perfAwayTeamDAO.create(perfAwayTeam);
            perfHomeTeamDAO.create(perfHomeTeam);
            statsHomeMatchDAO.create(statsHomeMatch);
            statsAwayMatchDAO.create(statsAwayMatch);
        }
    }
}
