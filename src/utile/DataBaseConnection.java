package utile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    private static Connection conexion = null;

    private static final String URL = "jdbc:mysql://localhost:4306/OrderProcessingSystemDB";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private DataBaseConnection() {}

    public static Connection getConnection() {
        if (conexion == null) {
            try {
                conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conexion;
    }

    public static void closeConnection() {
        if(conexion != null) {
            try {
                conexion.close();
            }catch(SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
