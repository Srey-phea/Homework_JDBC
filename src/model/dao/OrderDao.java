package model.dao;

import model.entity.Order;

import java.sql.SQLException;
import java.util.List;

public interface OrderDao {
    List<Order> queryAllOrders();
    int addNewOrder(Order order) ;
    int updateOrder(Integer id);
    int searchOrderById(Integer id);
    int deleteOrderById(Integer id);
}
