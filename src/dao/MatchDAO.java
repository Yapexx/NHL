package dao;

import pojo.Match;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
        String query = "DELETE FROM ? WHERE  = ";
        try {
            PreparedStatement prepare = this.connect.prepareStatement(query,  ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet result = prepare.executeQuery();
        } catch (SQLException e) {
            System.out.println("Unable to delete the match with id " + obj.getIdMatch());
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Match find(int id) {
        return null;
    }


}
