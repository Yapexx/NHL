import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by stagiaire3 on 23/06/2017.
 */
public class SdzConnection {
    private String url;
    private String user;
    private String password;
    private static Connection connect;


    private SdzConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            connect = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getInstance(){
        if(connect == null){
            new SdzConnection();
        }
        return connect;
    }

}
