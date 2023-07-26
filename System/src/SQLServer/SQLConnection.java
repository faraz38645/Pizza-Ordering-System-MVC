package SQLServer;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SQLConnection {

    public Connection getConnection() throws SQLException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dburl = "jdbc:sqlserver://localhost:1433;instance=DESKTOP-R1FN2EL;databaseName=PizzaDB";
            Connection connection = DriverManager.getConnection(dburl, "sa", "1234");
            return connection;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SQLConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
