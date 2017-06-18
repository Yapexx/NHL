package dao;

import pojo.StatsAwayMatch;

import java.sql.Connection;

/**
 * Created by yannx_000 on 17/06/2017.
 */
public class StatsAwayMatchDAO extends DAO<StatsAwayMatch> {

    public StatsAwayMatchDAO(Connection conn){
        super(conn);
    }

    @Override
    public boolean create(StatsAwayMatch  obj) {
        return false;
    }

    @Override
    public boolean delete(StatsAwayMatch obj) {
        return false;
    }

    @Override
    public StatsAwayMatch find(int id) {
        return null;
    }
}
