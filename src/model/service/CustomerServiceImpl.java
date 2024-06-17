package model.service;

import exception.ExceptionHandle;
import mapper.CustomerMapper;
import model.dao.CustomerDao;
import model.dao.CustomerDaoImpl;
import model.dto.CustomerDto;
import model.entity.Customer;


import java.util.List;

public class CustomerServiceImpl implements CustomerService{
    private final CustomerDao customerDao = new CustomerDaoImpl();
    @Override
    public List<CustomerDto> queryAllCustomers() {
        try {
            List<Customer> customers = customerDao.queryAllCustomers();
            if(!(customers.isEmpty())){
                return customerDao.queryAllCustomers().stream().map(CustomerMapper::mapCustomerToCustomerDto).toList();
            }else {
                throw new ExceptionHandle("No Data !");
            }
        }catch (ExceptionHandle e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void addNewCustomer(Customer customer){
        try{
            if (customerDao.addNewCustomer(customer) > 0) {
                throw new ExceptionHandle("Customer Added Successfully !");
            }else{
                throw new ExceptionHandle("Cant add customer");
            }
        }catch (ExceptionHandle e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateCustomerById(Integer id){
        try {
            if (customerDao.updateCustomerById(id) > 0) {
                throw new ExceptionHandle("Customer Updated Successfully !");
            }else {
                throw new ExceptionHandle("Cant update customer");
            }
        }catch (ExceptionHandle e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteCustomerById(Integer id) {
        try {
            if (customerDao.deleteCustomerById(id) > 0) {
                throw new ExceptionHandle("Customer Deleted Successfully !");
            }else {
                throw new ExceptionHandle("Cant delete customer");
            }
        }catch (ExceptionHandle e){
            System.out.println(e.getMessage());
        }
    }


}
