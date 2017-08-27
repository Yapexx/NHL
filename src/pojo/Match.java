package pojo;
/**
 * Created by yannx_000 on 10/06/2017.
 */
public class Match {
    private int idMatch;
    private Team homeTeam;
    private Team awayTeam;
    private boolean overtime;
    private boolean shootOut;
    private Team winner;


    public Match(){
    }
    /**
     * Constructor of Match object
     * @param idMatch
     * @param homeTeam
     * @param awayTeam
     * @param overtime
     * @param shootOut
     * @param winner
     */
    public Match(int idMatch, Team homeTeam, Team awayTeam, boolean overtime, boolean shootOut, Team winner ) {
        this.idMatch = idMatch;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.overtime = overtime;
        this.shootOut = shootOut;
        this.winner = winner;
    }

    //Ajouter setter et getter
    public int getIdMatch() {
        return (this.idMatch);
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public boolean getOvertime() {
        return overtime;
    }

    public boolean getShootout() {
        return shootOut;
    }

    public Team getWinner() {
        return winner;
    }

    public String toString() {
        String info = this.idMatch + "/" + this.homeTeam + "/" + this.awayTeam + "/" + this.overtime + "/" + this.shootOut + "/" + this.winner;
        return (info);
    }
}
