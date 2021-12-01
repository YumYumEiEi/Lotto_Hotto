package Backend;

import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseConnection {

    private static final String SQCONN = "jdbc:sqlite:lotto.sqlite";

    public static java.sql.Connection getConnection(){

        try{
            Class.forName("org.sqlite.JDBC");
            return DriverManager.getConnection(SQCONN);
        }
        catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}