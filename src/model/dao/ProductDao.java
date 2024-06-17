package model.dao;

import model.entity.Product;

import java.util.List;

public interface ProductDao {
    List<Product> queryAllProducts();
    int addNewProduct(Product product);
    Product searchProductById(Integer id);
    int deleteProduct(Integer id);
    int updateProduct(Integer id);
}
