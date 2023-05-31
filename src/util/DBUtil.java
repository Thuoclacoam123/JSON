package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
    public static Connection getConnection() throws Exception {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Assigment_JDBC","sa","12345678");
            System.out.println("connected to DB");
            return conn;
        } catch(Exception e) {
            throw new Exception("Connection failed");
        }
    }
}
