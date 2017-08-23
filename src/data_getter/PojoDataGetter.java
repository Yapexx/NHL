package data_getter;

import pojo.Team;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bdd_connection.SdzConnection;

/**
 * Created by yannx_000 on 18/06/2017.
 */
//Classe pour fouiller dans la base pour récupérer les données dans la base
//On chosit de faire les pourcentages en moyenne donc il faudra faire la somme à chaque fois
public class PojoDataGetter {
    private Connection conn;
    //Voir quel attribut rajouter en fonction comment sera utiliser la classe
    private int countMatch;

    public PojoDataGetter() {
        this.conn = SdzConnection.getInstance();
    }

    //Voir pour le nom de la table avec perfteam

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
        prepare.setString(2, team.getTeamName());
        ResultSet result = prepare.executeQuery(query);
        result.next(); //Pour positionner l'objet sur la première ligne
        count = (int)result.getObject(1);
        result.close();
        prepare.close();
        return (count);
    }

    //Récupérer les différents taux dépendant d'une somme
    public int  selectSumValue(Team team, boolean isHome, String typeValue) throws java.sql.SQLException {
        int sum = 0;
        String query = "SELECT SUM(?) FROM ?";
        query += "WHERE team_name = ?";
        PreparedStatement prepare = conn.prepareStatement(query);
        prepare.setString(1, typeValue);
        prepare.setString(2, this.tableName(isHome));
        prepare.setString(3, team.getTeamName());
        ResultSet result = prepare.executeQuery();
        sum = (int)result.getObject(1);
        result.close();
        prepare.close();
        return (sum);
    }


    //Fonction générale pour récupérer toutes les moyennes

    public float selectMean(int countMatch, Team team, boolean isHome, String typeMean) throws java.sql.SQLException {
        float mean = 0;
        String query = "SELECT ? FROM ? ";
        query += "WHERE team_name = ?";
        query += "AND count = ?";
        PreparedStatement prepare = conn.prepareStatement(query);
        prepare.setString(1, typeMean);
        prepare.setString(2, this.tableName(isHome));
        prepare.setString(3, team.getTeamName());
        prepare.setInt(4, countMatch);
        ResultSet result = prepare.executeQuery();
        mean = (float)result.getObject(1);
        result.close();
        prepare.close();
        return (mean);
    }


}
