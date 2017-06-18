package dao;

import pojo.PerfHomeTeam;

import java.sql.Connection;

/**
 * Created by yannx_000 on 17/06/2017.
 */
public class PerfHomeTeamDAO extends DAO<PerfHomeTeam>{

    public PerfHomeTeamDAO(Connection conn){
        super(conn);
    }

    @Override
    public boolean create(PerfHomeTeam obj) {
        return false;
    }

    @Override
    public boolean delete(PerfHomeTeam obj) {
        return false;
    }

    @Override
    public PerfHomeTeam find(int id) {
        return null;
    }
}
