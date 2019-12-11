package nu.t4.opendata.backend;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author erikh
 */
public class ConnectionFactory {

    /**
     *
     * @return Returns a connection to the DB
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        String user = "root";
        String password = "";
        String url = "jdbc:mysql://localhost/opendata_db";
        Class.forName("com.mysql.jdbc.Driver");
        return (Connection) DriverManager.getConnection(url, user, password);
    }
}

