package model.service;


import exception.ExceptionHandle;
import model.dto.OrderDto;
import model.dto.ProductDto;
import model.entity.Order;
import model.entity.Product;

import java.util.List;

public interface ProductService {
    List<ProductDto> queryAllProducts() throws ExceptionHandle;
    void addNewProduct(Product product) throws ExceptionHandle;
    void updateProductById(Integer id) throws ExceptionHandle;
    void deleteProductById(Integer id);
}
