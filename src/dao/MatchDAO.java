package dao;

import pojo.Match;
import pojo.Team;

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
        String query = "INSERT INTO game VALUES(?, ?, ?, ?, ?, ?) ";
        try {
            PreparedStatement prepare = this.connect.prepareStatement(query);
            prepare.setInt(1, obj.getIdMatch());
            prepare.setString(2, obj.getHomeTeam().toString());
            prepare.setString(3, obj.getAwayTeam().toString());
            prepare.setBoolean(4, obj.getOvertime());
            prepare.setBoolean(5, obj.getShootout());
            prepare.setString(6, obj.getWinner().toString());
            prepare.executeUpdate();
            prepare.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Unable to insert match in database");
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(Match obj) {
        String query = "DELETE FROM ? WHERE  = ";
        try {
            PreparedStatement prepare = this.connect.prepareStatement(query);
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
        String query = "SELECT * FROM Game WHERE id_match = ?";
        Match match = new Match();
        try {
            PreparedStatement prepare = this.connect.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            prepare.setInt(1, id);
            ResultSet result = prepare.executeQuery(query);
            if (result.first()) {
                match = new Match(result.getInt("id_match"), Team.valueOf(result.getString("home_team")), Team.valueOf(result.getString("away_team")), result.getBoolean("overtime"), result.getBoolean("shootout"), Team.valueOf(result.getString("winner")));
                result.close();
                prepare.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return match;
    }



}
