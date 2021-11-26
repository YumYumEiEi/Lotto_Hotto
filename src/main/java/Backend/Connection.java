package Backend;

import java.sql.DriverManager;
import java.sql.SQLException;


public class Connection {

    private static final String SQCONN = "jdbc:sqlite:lotto.sqlite";

    public static java.sql.Connection getConnection() throws SQLException{

        try{
            Class.forName("org.sqlite.JDBC");
            return DriverManager.getConnection(SQCONN);
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }
}