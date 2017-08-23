package pojo;

import java.util.Hashtable;

/**
 * Created by stagiaire3 on 23/08/2017.
 */
public class RevertTableTeam {
    private static RevertTableTeam revertTableTeam;
    private Hashtable revertTeamTable;

    private RevertTableTeam() {
        revertTeamTable = new Hashtable();
        for (Team team : Team.values()) {
            revertTeamTable.put(team.getTeamName(), team);
        }
    }

    public static RevertTableTeam getInstance() {
        if (revertTableTeam == null) {
            revertTableTeam = new RevertTableTeam();
        }
        return (revertTableTeam);
    }

    public Team getTeam(String teamName) {
        return (Team)(revertTeamTable.get(teamName));
    }
}
