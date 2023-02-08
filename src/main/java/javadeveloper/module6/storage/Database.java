package javadeveloper.module6.storage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final Database INSTANCE = new Database();
    private Database() {
    }

    public static Database getInstance() {
        return INSTANCE;
    }

    public Connection getConnection() {
        Connection connection = null;
        String connectionUrl = "jdbc:h2:./megasoft";
        try {
            connection = DriverManager.getConnection(connectionUrl, "sa", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
