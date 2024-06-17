package model.service;

import exception.ExceptionHandle;
import model.dto.OrderDto;
import model.entity.Order;

import java.util.List;

public interface OrderService {
    List<OrderDto> queryAllOrders() throws ExceptionHandle;
    void addNewOrder(Order order) throws ExceptionHandle;
    void updateOrderById(Integer id) throws ExceptionHandle;
    void deleteOrderById(Integer id);
}
