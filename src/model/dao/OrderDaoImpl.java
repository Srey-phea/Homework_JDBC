package model.dao;

import model.dao.OrderDao;
import model.entity.Customer;
import model.entity.Order;

import java.nio.file.Path;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDaoImpl implements OrderDao {
    @Override
    public List<Order> queryAllOrders() {
        String sql = """
                SELECT * FROM "order" 
                INNER JOIN "customer" c on c.id = "order".cus_id
                """;
        try(
                Connection connection = DriverManager.getConnection(
                        "jdbc:postgresql://localhost:5433/postgres",
                        "postgres",
                        "a1B;sksh2@"
                );
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
        ){
            List<Order> orders = new ArrayList<>();
            while (resultSet.next()){
                orders.add(
                        Order.builder()
                                .id(resultSet.getInt("id"))
                                .orderName(resultSet.getString("order_name"))
                                .orderDescription(resultSet.getString("order_description"))
                                .orderedAt(resultSet.getDate("ordered_at"))
                                .customer(Customer.builder()
                                        .id(resultSet.getInt("cus_id"))
                                        .name(resultSet.getString("name"))
                                        .email(resultSet.getString("email"))
                                        .password(resultSet.getString("password"))
                                        .createDate(resultSet.getDate("created_date"))
                                        .isDeleted(resultSet.getBoolean("is_deleted"))
                                        .build())
                                .build()
                );
            }
            return orders;
        }catch (SQLException sqlException){
            System.out.println(sqlException.getMessage());
        }
        return new ArrayList<>();
    }

    @Override
    public int addNewOrder(Order order)  {
        String sql = """
                INSERT INTO "order" (order_name, order_description, cus_id, ordered_at)
                VALUES (?,?,?,?)
                """;
        try(
                Connection connection = DriverManager.getConnection(
                        "jdbc:postgresql://localhost:5433/postgres",
                        "postgres",
                        "a1B;sksh2@"
                );
                PreparedStatement preparedStatement
                        = connection.prepareStatement(sql);
                ){
            preparedStatement.setString(1,order.getOrderName());
            preparedStatement.setString(2,order.getOrderDescription());
            preparedStatement.setInt(3,order.getCustomer().getId());
            preparedStatement.setDate(4,order.getOrderedAt());
            int rowAffected = preparedStatement.executeUpdate();
            if (rowAffected > 0){
                System.out.println("Successfully");
            }else {
                System.out.println("Cannot Add Order");
            }
        }catch (SQLException sqlException){
            System.out.println(sqlException.getMessage());
        }
        return 0;
    }

    @Override
    public int updateOrder(Integer id) {
        String sql = """
                SELECT * FROM "order"
                WHERE id = ?              
                """;
        try(
                Connection connection = DriverManager.getConnection(
                        "jdbc:postgresql://localhost:5433/postgres",
                        "postgres",
                        "a1B;sksh2@"
                );
                PreparedStatement preparedStatement
                        = connection.prepareStatement(sql);
        ){
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Order order = null;
            while (resultSet.next()){
                order = Order
                        .builder()
                        .id(resultSet.getInt("id"))
                        .orderName(resultSet.getString("order_name"))
                        .orderDescription(resultSet.getString("order_description"))
                        .orderedAt(resultSet.getDate("ordered_at"))
                        .build();
            }
            return order.getId();
        }catch (SQLException sqlException){
            System.out.println(sqlException.getMessage());
        }
        return 0;
    }

    @Override
    public int searchOrderById(Integer id) {
        String sql = """
            SELECT * FROM "order"
            WHERE id = ?              
            """;
        try(
                Connection connection = DriverManager.getConnection(
                        "jdbc:postgresql://localhost:5433/postgres",
                        "postgres",
                        "a1B;sksh2@"
                );
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ){
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Order order = Order
                        .builder()
                        .id(resultSet.getInt("id"))
                        .orderName(resultSet.getString("order_name"))
                        .orderDescription(resultSet.getString("order_description"))
                        .orderedAt(resultSet.getDate("ordered_at"))
                        .build();
                return order.getId();
            } else {
                System.out.println("Order not found with ID: " + id);
                return -1;
            }
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
        return 0;
    }

    @Override
    public int deleteOrderById(Integer id) {
        String sql = """
                DELETE FROM "order"
                WHERE id = ?
                """;
        try(
                Connection connection = DriverManager.getConnection(
                        "jdbc:postgresql://localhost:5433/postgres",
                        "postgres",
                        "a1B;sksh2@"
                );

        ){

        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
        return 0;
    }
}