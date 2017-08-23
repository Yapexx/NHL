package dao;

import pojo.RevertTableTeam;
import pojo.StatsHomeMatch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by yannx_000 on 17/06/2017.
 */
public class StatsHomeMatchDAO  extends DAO<StatsHomeMatch> {

    public StatsHomeMatchDAO(Connection conn){
        super(conn);
    }

    @Override
    public boolean create(StatsHomeMatch  obj) {
        String query = "INSERT INTO StatsAwayMatch VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement prepare = this.connect.prepareStatement(query);
            prepare.setString(1, obj.getHomeTeam().getTeamName());
            prepare.setInt(2, obj.getIdMatch());
            prepare.setInt(3, obj.getCountMatch());
            prepare.setInt(4, obj.getScoredGoal());
            prepare.setInt(5, obj.getTakenGoal());
            prepare.setInt(6, obj.getOnTargetShot());
            prepare.setFloat(7, obj.getGoalEfficiency());
            prepare.setInt(8, obj.getSavedShot());
            prepare.setFloat(9, obj.getSavedRate());
            prepare.setInt(10, obj.getPowerPlayScoredGoal());
            prepare.setInt(11, obj.getPowerPlayOpportunity());
            prepare.setFloat(12, obj.getPowerPlayEfficiency());
            prepare.setInt(13, obj.getPowerPlayTakenGoal());
            prepare.setInt(14, obj.getPowerPlayPenalty());
            prepare.setFloat(15, obj.getPowerPlayDefense());
            prepare.executeUpdate(query);
            prepare.close();
        } catch (SQLException e) {
            System.out.println("Unable to insert match in database");
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(StatsHomeMatch obj) {
        return false;
    }

    @Override
    public StatsHomeMatch find(int id) {
        return null;
    }

    public StatsHomeMatch find(int id, int count) {
        RevertTableTeam revertTable = RevertTableTeam.getInstance();
        String query = "SELECT * FROM  WHERE id_match = ? AND count_match = ?";
        StatsHomeMatch statsHomeMatch = new StatsHomeMatch();
        try {
            PreparedStatement prepare = this.connect.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE);
            prepare.setInt(1, id);
            prepare.setInt(2, count);
            ResultSet result = prepare.executeQuery(query);
            if (result.first()) {
                statsHomeMatch = new StatsHomeMatch(revertTable.getTeam(result.getString(1)), result.getInt(2), result.getInt(3), result.getInt(4),
                        result.getInt(5), result.getFloat(6), result.getInt(7), result.getInt(8), result.getFloat(9), result.getInt(10),
                        result.getInt(11), result.getFloat(12), result.getInt(13), result.getInt(14), result.getFloat(15));
                result.close();
                prepare.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return statsHomeMatch;
    }
}
