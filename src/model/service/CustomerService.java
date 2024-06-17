package model.service;

import exception.ExceptionHandle;
import model.dto.CustomerDto;
import model.entity.Customer;

import java.util.List;

public interface CustomerService  {
    List<CustomerDto> queryAllCustomers() throws ExceptionHandle;
    void addNewCustomer(Customer customer) throws ExceptionHandle;
    void updateCustomerById(Integer id) throws ExceptionHandle;
    void deleteCustomerById(Integer id);
}
