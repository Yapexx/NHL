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
        return null;
    }
}
