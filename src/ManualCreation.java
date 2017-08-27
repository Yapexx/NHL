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
        dataCreation.dataTreatment("https://statsapi.web.nhl.com/api/v1/schedule?startDate=2014-10-18&endDate=2014-10-18&expand=schedule.teams,schedule.linescore&teamId=4");


    }
}
