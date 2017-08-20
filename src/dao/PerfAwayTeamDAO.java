package dao;

import pojo.Match;
import pojo.PerfAwayTeam;
import pojo.Team;

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
        String query = "SELECT * FROM  WHERE id_match = ? AND count_match = ?";
        PerfAwayTeam perfAwayTeam = new PerfAwayTeam();
        try {
            PreparedStatement prepare = this.connect.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            prepare.setInt(1, id);
            prepare.setInt(2, count);
            ResultSet result = prepare.executeQuery(query);
            if (result.first()) {
                perfAwayTeam = new PerfAwayTeam(result.getInt("id_match"), Team.valueOf(result.getString("home_team")), Team.valueOf(result.getString("away_team")), result.getBoolean("overtime"), result.getBoolean("shootout"), Team.valueOf(result.getString("winner")));
                result.close();
                prepare.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return ma;
        return null;
    }
}
