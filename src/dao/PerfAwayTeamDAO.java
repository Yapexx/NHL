package dao;

import pojo.PerfAwayTeam;

import java.sql.Connection;

/**
 * Created by yannx_000 on 17/06/2017.
 */
public class PerfAwayTeamDAO extends DAO<PerfAwayTeam> {

    public PerfAwayTeamDAO(Connection conn){
        super(conn);
    }

    @Override
    public boolean create(PerfAwayTeam obj) {
        return false;
    }

    @Override
    public boolean delete(PerfAwayTeam obj) {
        return false;
    }

    @Override
    public PerfAwayTeam find(int id) {
        System.out.println("Il faut donner un autre entier pour déterminer le match");
        return null;
    }

    public PerfAwayTeam find(int id, int count) {
        return null;
    }
}
