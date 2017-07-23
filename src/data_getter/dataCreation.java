package data_getter;

import java.io.IOException;

/**
 * Created by stagiaire3 on 23/06/2017.
 */
public class dataCreation {

    public static void dataTreatment(String url) {
        int gameToTreat = 0;
        int count = 1;
        try {
            ReaderProvider rd = ReaderProvider.getInstance(url);
            JsonGlobalMatch globalMatchReader = new JsonGlobalMatch(rd.getReader());
            gameToTreat = globalMatchReader.getTotalGames();

            while (count < gameToTreat) {
                globalMatchReader.parseGame();
                rd.setUrl(globalMatchReader.getLinkDetailMatch());
                JsonDetailMatch detailMatchReader = new JsonDetailMatch(rd.getReader());
                //Gérer l'ajout dans la base et le traitement des données dans la base
                count = count + 1;
            }
        }
        catch (IOException e) {
            System.out.println("Treatment interrupted on game " + count + " on " + gameToTreat );
            e.printStackTrace();
        }

        System.out.println(count + "have been added to the databse");
    }
}
