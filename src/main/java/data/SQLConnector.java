package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnector {
    private static Connection connection;
    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection("jdbc:mysql://db.diplomportal.dk/chbu?" +
                        "user=chbu&password=tIp1POywlKKdZaQuVR3V1");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
