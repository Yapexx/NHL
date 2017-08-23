import bdd_connection.SdzConnection;
import data_getter.ReaderProvider;
import data_getter.dataCreation;

import java.io.IOException;

/**
 * Created by stagiaire3 on 23/08/2017.
 */
public class ManualCreation {

    public static void main(String args[]) throws IOException {
        //La classe a étéé crée de manière à n'avoir qu'une seule connection sur une seule base

        //Ligne de code pour tout créer à partir d'une url qui soit un calendrier après connection à la base
        dataCreation.dataTreatment("https://statsapi.web.nhl.com/api/v1/game/2016021033/feed/live");
    }
}
