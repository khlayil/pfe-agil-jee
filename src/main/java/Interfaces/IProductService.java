package Interfaces;

import Entities.Product;

import javax.ejb.Remote;
import java.util.List;
@Remote

public interface IProductService {


    public boolean addProduct(Product product);
    public boolean editProduct(Product product);
    public List<Product> getAllProduct();
    public Product getProductById(int id);
    public List<Product> getAllProductNoPromotion() ;


        public boolean removeProduct(int id);
    public boolean addStockProduct(Product product,int stock);

}
