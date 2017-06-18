package dao;

import pojo.StatsHomeMatch;

import java.sql.Connection;

/**
 * Created by yannx_000 on 17/06/2017.
 */
public class StatsHomeMatchDAO  extends DAO<StatsHomeMatch> {

    public StatsHomeMatchDAO(Connection conn){
        super(conn);
    }

    @Override
    public boolean create(StatsHomeMatch  obj) {
        return false;
    }

    @Override
    public boolean delete(StatsHomeMatch obj) {
        return false;
    }

    @Override
    public StatsHomeMatch find(int id) {
        return null;
    }
}
