package dao;

import pojo.PerfAwayTeam;
import pojo.RevertTableTeam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by yannx_000 on 17/06/2017.
 */
public class PerfAwayTeamDAO extends DAO<PerfAwayTeam> {

    public PerfAwayTeamDAO(Connection conn){
        super(conn);
    }

    @Override
    public boolean create(PerfAwayTeam obj) {
        String query = "INSERT INTO PerfAwayTeam VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement prepare = this.connect.prepareStatement(query);
            prepare.setString(1, obj.getTeam().getTeamName());
            prepare.setInt(2, obj.getIdMatch());
            prepare.setInt(3, obj.getCountMatch());
            prepare.setInt(4, obj.getScoredGoal());
            prepare.setInt(5, obj.getTakenGoal());
            prepare.setFloat(6, obj.getScoredGoalMean());
            prepare.setFloat(7, obj.getTakenGoalMean());
            prepare.setFloat(8, obj.getFaceoffWinPercentageMatch());
            prepare.setFloat(9, obj.getFaceoffWinGlobalRate());
            prepare.setFloat(10, obj.getWinnerRate());
            prepare.executeUpdate();
            prepare.close();
        } catch (SQLException e) {
            System.out.println("Unable to insert match in database");
            e.printStackTrace();
            return false;
        }
        return true;
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
        RevertTableTeam revertTable = RevertTableTeam.getInstance();
        String query = "SELECT * FROM PerfAwayTeam WHERE id_match = ? AND count_match = ?";
        PerfAwayTeam perfAwayTeam = new PerfAwayTeam();
        try {
            PreparedStatement prepare = this.connect.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE);
            prepare.setInt(1, id);
            prepare.setInt(2, count);
            ResultSet result = prepare.executeQuery(query);
            if (result.first()) {
                perfAwayTeam = new PerfAwayTeam(revertTable.getTeam(result.getString(1)), result.getInt(2), result.getInt(3), result.getInt(4),
                        result.getInt(5), result.getFloat(6), result.getFloat(7), result.getFloat(8), result.getFloat(9), result.getFloat(10) );
                result.close();
                prepare.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return perfAwayTeam;
    }
}
