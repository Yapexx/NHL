package pojo;

import java.util.Hashtable;

/**
 * Created by yannx_000 on 18/06/2017.
 */
public class TableTeam {
    private static TableTeam tableTeam;
    private Hashtable teamTable;

    private TableTeam() {
        teamTable = new Hashtable();
        for (Team team : Team.values()) {
            teamTable.put(team.getIdTeam(), team);
        }
    }

    public static TableTeam getInstance() {
        if (tableTeam == null) {
            tableTeam = new TableTeam();
        }
        return (tableTeam);
    }

    public Team getTeam(int idTeam) {
        return (Team)(teamTable.get(idTeam));
    }
}
