package bdd_connection;

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

    /*Si je change pour avoir plusieurs connections
    public void setUrl(String url) {
        this.url = url;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    */

    private SdzConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            connect = DriverManager.getConnection(url, user, password);
        } catch (SQLException | ClassNotFoundException e ) {
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
