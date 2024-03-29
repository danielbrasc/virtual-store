package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabase {

    private static final String DRIVER = "org.postgresql.Driver";
    private static final String HOST = System.getenv("DB_HOST");
    private static final String PORT = System.getenv("DB_PORT");
    private static final String NAME = System.getenv("DB_NAME");
    private static final String USERNAME = System.getenv("DB_USER");
    private static final String PASSWORD = System.getenv("DB_PASSWORD");

    private static final String URL = "jdbc:postgresql://"+HOST+":"+PORT+"/"+NAME+"?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException ex) {
            System.out.println("Where is your PostgreSQL JDBC Driver? Include in your pom.xml");
            return null;
        }

        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}

