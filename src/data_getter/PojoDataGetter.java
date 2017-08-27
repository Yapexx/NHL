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


    public int getCoutMatch(Team team, String tableName) throws java.sql.SQLException { //Pour l'exception voir de quel type il s'agit pas exemple si l'objet n'est pas trouver
        //Seach in the table with the smallest number of columns
        int count = 0;
        //Il faudra déterminer s'il s'agit de la team domicile ou extérieur
        String query = "SELECT Max(count_match) FROM " + tableName;
        query += " WHERE team_name = ?";
        PreparedStatement prepare = conn.prepareStatement(query);
        prepare.setString(1, team.getTeamName());
        ResultSet result = prepare.executeQuery();
        result.next(); //Pour positionner l'objet sur la première ligne
        count = result.getInt(1);
        result.close();
        prepare.close();
        return (count);
    }

    //Récupérer les différents taux dépendant d'une somme
    public int  selectSumValue(Team team, String tableName, String typeValue) throws java.sql.SQLException {
        int sum = 0;
        String query = "SELECT SUM(" + typeValue + ") FROM " + tableName;
        query += " WHERE team_name = ? ";
        PreparedStatement prepare = conn.prepareStatement(query);
        prepare.setString(1, team.getTeamName());
        ResultSet result = prepare.executeQuery();
        result.next();
        sum = (int)result.getInt(1);
        result.close();
        prepare.close();
        return (sum);
    }


    //Fonction générale pour récupérer toutes les moyennes
    public float selectMean(int countMatch, Team team, String tableName, String typeMean) throws java.sql.SQLException {
        float mean = 0;
        String query = "SELECT " + typeMean + " FROM " + tableName;
        query += " WHERE team_name = ? ";
        query += "AND count_match = ? ";
        PreparedStatement prepare = conn.prepareStatement(query);
        prepare.setString(1, team.getTeamName());
        prepare.setInt(2, countMatch);
        ResultSet result = prepare.executeQuery();
        result.next();
        mean = result.getFloat(1);
        result.close();
        prepare.close();
        return (mean);
    }


}
