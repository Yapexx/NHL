package dao;

import pojo.Match;

import java.sql.Connection;

/**
 * Created by yannx_000 on 17/06/2017.
 */
public class MatchDAO extends DAO<Match> {

    public MatchDAO(Connection conn){
        super(conn);
    }

    @Override
    public boolean create(Match obj) {
        return false;
    }

    @Override
    public boolean delete(Match obj) {
        return false;
    }

    @Override
    public Match find(int id) {
        return null;
    }


}
