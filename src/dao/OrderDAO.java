package dao;

import module.Order;
import utile.DataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class OrderDAO {
    public static Order getOrder(String id) {
        Order order = null;
        String query = "SELECT * FROM orders WHERE id = ?";

        try(Connection conexion = DataBaseConnection.getConnection()){
            PreparedStatement pstmt = conexion.prepareStatement(query);

            pstmt.setString(1,id);

            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                order = new Order(
                        rs.getString("order_id"),
                        rs.getString("customer_id"),
                        rs.getString("order_date"),
                        rs.getString("status")
                        );
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return order;
    }
    public static boolean addOrder(Order order) {
        String query = "insert into orders values(?,?,?,?)";

        try(Connection conexion = DataBaseConnection.getConnection()){
            PreparedStatement pstmt = conexion.prepareStatement(query);

            pstmt.setString(1,order.getID());
            pstmt.setString(2,order.getCustomerId());
            pstmt.setString(3,order.getOrderDate());
            pstmt.setString(4, order.getStatus());

            pstmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public static boolean addOrders(List<Order> orders) {
        String query = "INSERT INTO orders (id, customer_id, order_date, status) VALUES (?, ?, ?, ?)";

        try (Connection conexion = DataBaseConnection.getConnection();
             PreparedStatement pstmt = conexion.prepareStatement(query)) {

            conexion.setAutoCommit(false); // Disable auto-commit for batch processing

            for (Order order : orders) {
                pstmt.setString(1, order.getID());
                pstmt.setString(2, order.getCustomerId());
                pstmt.setString(3, order.getOrderDate());
                pstmt.setString(4, order.getStatus());
                pstmt.addBatch(); // Add to batch
            }

            pstmt.executeBatch(); // Execute all batched statements
            conexion.commit(); // Commit the transaction
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            try (Connection conexion = DataBaseConnection.getConnection()) {
                conexion.rollback(); // Rollback in case of error
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
            return false;
        } finally {
            try (Connection conexion = DataBaseConnection.getConnection()) {
                conexion.setAutoCommit(true); // Reset auto-commit to true
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}
