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
    Penguins(5, "Pittsburgh Penguins"),
    Bruins(6, "Boston Bruins"),
    Sabres(7, "Buffalo Sabres"),
    Canadiens(8, "Montréal Canadiens"),
    Senators(9, "Ottawa Senators"),
    MapleLeafs(10, "Toronto Maple Leafs"), //deal with space il faut changer quand je créée mon objet sinon problème de type
    Hurricanes(12, "Carolina Hurricanes"),
    Panthers(13, "Floraida Panthers"),
    Ligthning(14, "Tampa Bay Lightning"),
    Capitals(15, "Washington Capitals"),
    Blackhawks(16, "Chicago Blackhawks"),
    RedWings(17, "Detroit Red Wings"),
    Predators(18, "Nashville Predators"),
    Blues(19, "St. Louis Blues"),
    Flames(20, "Calgary Flames"),
    Avalanche(21, "Colorado Avalanche"),
    Oilers(22, "Edmonton Oilers"),
    Canucks(23, "Vancouver Canucks"),
    Ducks(24, "Anaheim Ducks"),
    Stars(25, "Dallas Stars"),
    Kings(26, "Los Angeles Kings"),
    Sharks(28, "San Jose Sharks"),
    BlueJackets(29, "Colombus Blue Jackets"), //space
    Wild(30, "Minnesota Wild"),
    Jets(52, "Winnipeg Jets"),
    Coyotes(53, "Arizona Coyotes"),
    GoldenKnights(54, "Vegas Golden Knights"); //space

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

    public String getTeamName() {
        return (this.teamName);
    }
}
