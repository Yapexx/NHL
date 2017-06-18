package pojo;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * Created by yannx_000 on 10/06/2017.
 */
public enum Team {
    /**
     *pojo.Teams with short name classified as in the api
     */
    Devils(1, "New Jersey Devils"),
    Islanders(2, "New York Islanders"),
    Rangers(3, "New York Rangers"),
    Flyers(4, "Philadelphia Flyers"),
    Penguins(5, "Pittsburgh Penguins");

    /**
     * id of the team
     */
    private int idTeam;

    /**
     * Full name of the team;
     */
    private String teamName;

    /**
     * Constructor
     * @param idTeam id of the team
     * @param teamName full name
     */
    Team(int idTeam, String teamName) {
        this.idTeam = idTeam;
        this.teamName = teamName;
    }

    public int getIdTeam() {
        return (this.idTeam);
    }
}
