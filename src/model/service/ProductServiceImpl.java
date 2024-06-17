package model.service;

import exception.ExceptionHandle;
import mapper.ProductMapper;
import model.dao.ProductDao;
import model.dao.ProductDaoImpl;
import model.dto.ProductDto;
import model.entity.Product;

import java.util.List;


public class ProductServiceImpl implements ProductService {
    private final ProductDao productDao = new ProductDaoImpl();

    @Override
    public List<ProductDto> queryAllProducts() throws ExceptionHandle {
        try {
            List<Product> products = productDao.queryAllProducts();
            if (!(products.isEmpty())) {
                return productDao.queryAllProducts().stream().map(ProductMapper::mapProductToProductDto).toList();
            }else {
                throw new ExceptionHandle("No Data !");
            }
        }catch (ExceptionHandle e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void addNewProduct(Product product) throws ExceptionHandle {
        try {
            if (productDao.addNewProduct(product) > 0) {
                throw new ExceptionHandle("Product Added Successfully !");
            }else {
                throw new ExceptionHandle("Cant add product !");
            }
        }catch (ExceptionHandle e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateProductById(Integer id) throws ExceptionHandle {
        try{
            if (productDao.updateProduct(id)>0){
                throw new ExceptionHandle("Product Updated Successfully !");
            }else {
                throw new ExceptionHandle("Cant update product !");
            }
        }catch (ExceptionHandle e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteProductById(Integer id) {
        try{
            if (productDao.deleteProduct(id)>0){
                throw new ExceptionHandle("Product Deleted Successfully !");
            }else {
                throw new ExceptionHandle("Cant delete product !");
            }
        }catch (ExceptionHandle e){
            System.out.println(e.getMessage());
        }
    }
}
