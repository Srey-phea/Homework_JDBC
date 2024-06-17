package model.dao;

import model.entity.Customer;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface CustomerDao {
    List<Customer> queryAllCustomers();
    int deleteCustomerById(Integer id);
    int updateCustomerById(Integer id);
    Customer searchCustomerById(Integer id);
    Connection connectionToDataBase() throws SQLException;
    int addNewCustomer(Customer customer);
}
