package data_getter;

import pojo.Team;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by yannx_000 on 18/06/2017.
 */
//Classe pour fouiller dans la base pour récupérer les données dans la base
//On chosit de faire les pourcentages en moyenne donc il faudra faire la somme à chaque fois
public class PojoDataGetter {
    private Connection conn;
    //Voir quel attribut rajouter en fonction comment sera utiliser la classe
    private int countMatch;

    public PojoDataGetter(Connection con) {
        this.conn = conn;
    }

    private String tableName(boolean ishome) {
        String table = "PerfHomeTeam";
        if (!ishome) {
            table = "PerfAwayTeam";
        }
        return (table);
    }

    public int getCoutMatch(Team team, boolean isHome) throws java.sql.SQLException { //Pour l'exception voir de quel type il s'agit pas exemple si l'objet n'est pas trouver
        //Seach in the table with the smallest number of columns
        int count = 0;
        //Il faudra déterminer s'il s'agit de la team domicile ou extérieur
        String query = "SELECT Max(number_game) FROM ? ";
        query += "WHERE team_name =  ?";
        PreparedStatement prepare = conn.prepareStatement(query);
        prepare.setString(1, this.tableName(isHome));
        prepare.setString(2, team.toString());
        ResultSet result = prepare.executeQuery(query);
        result.next(); //Pour positionner l'objet sur la première ligne
        count = (int)result.getObject(1);

        return (count);
    }

    //Surement faire une factory qui distribue les requêtes pour éviter redondnaces du code

    //Faire excatement la même chose pour chopper les moyennes de but marqués et encaissés la requête sera la même

    public float getWinnerRate(int countMatch, Team team, boolean isHome) throws java.sql.SQLException{
        float rate = 0;
        String query = "SELECT winner_rate FROM ? ";
        query += "WHERE team_name = ?";
        query += "AND count = ?";
        PreparedStatement prepare = conn.prepareStatement(query);
        prepare.setString(1, this.tableName(isHome));
        prepare.setString(2, team.toString());
        prepare.setInt(3, countMatch);
        ResultSet result = prepare.executeQuery(query);
        rate = (float)result.getObject(1);
        return (rate);
    }


    //Récupérer les différents taux dépendant de 2 inconnues
    public void getSavedRate() {
        float rate = 0;
        String query = "SELECT SUM(), SUM() FROM ?";
        query += "WHERE team_name = ?";
    }







}
