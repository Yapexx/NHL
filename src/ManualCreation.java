import bdd_connection.DummyLine;
import bdd_connection.SdzConnection;
import data_getter.ReaderProvider;
import data_getter.dataCreation;

import java.io.IOException;

/**
 * Created by stagiaire3 on 23/08/2017.
 */
public class ManualCreation {

    public static void main(String args[]) throws IOException {
        //La classe a étéé crée de manière à n'avoir qu'une seule connection sur une seule base adreese en dur dans le oode
        //Ligne de code pour tout créer à partir d'une url qui soit un calendrier après connection à la base
        //Ajout des lignes vides
        //Bien vérifier la DATE POUR LA BASE DANS SDZ CONNECTION
        //DummyLine.insertLines();


        //ATTENTION BIEN V2RIFIER LA DERNIERE DATE SINON IL VA Y AVOIR DES DOUBLONS
        dataCreation.dataTreatment("https://statsapi.web.nhl.com/api/v1/schedule?startDate=2017-12-01&endDate=2017-12-27&expand=schedule.teams,schedule.linescore");

        //Oublie car erreur
       //dataCreation.dataTreatment("https://statsapi.web.nhl.com/api/v1/schedule?startDate=2016-01-10&endDate=2016-01-10&expand=schedule.teams,schedule.linescore&teamId=13");


    }
}
