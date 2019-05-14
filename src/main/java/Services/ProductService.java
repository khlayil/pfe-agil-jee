package Services;

import Entities.Product;
import Interfaces.IProductService;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
@LocalBean
public class ProductService implements IProductService {
    @PersistenceContext(unitName="agil_per")
    EntityManager em;


    @Override
    public boolean addProduct(Product product) {
        System.out.println("methode addProduct(Product product)  invoked");

        try {
            em.persist(product);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("some problem when adding product");
        }
        return false;
    }

    @Override
    public boolean editProduct(Product product) {

        System.out.println("methode editProduct(Product product)  invoked");

        try {
            em.merge(product);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("some problem when editing product");
        }
        return false;



    }

    @Override
    public List<Product> getAllProduct() {
        System.out.println("methode getAllProduct invoked");

        TypedQuery<Product> query = em.createQuery("select p from Product p ", Product.class);
        List<Product> products = null;
        try {
            products = query.getResultList();

        } catch (NoResultException e) {
            System.out.println("-------no products------");
            e.printStackTrace();
        }
        return products;    }

    @Override
    public List<Product> getAllProductNoPromotion() {
        System.out.println("methode getAllProductNoPromotion invoked");

        TypedQuery<Product> query = em.createQuery("select p from Product p  ", Product.class);
        List<Product> products = null;
        try {
            products = query.getResultList().stream().filter(e->e.getPromotion()==null).collect(Collectors.toList());

        } catch (NoResultException e) {
            System.out.println("-------no products without promotions------");
            e.printStackTrace();
        }
        return products;    }

    @Override
    public Product getProductById(int id) {
        System.out.println("methode getProductById(int id) invoked");

        Product product= null;
        try {


            product = em.find(Product.class, id);
        } catch (NoResultException e) {
            System.out.println("-------no product with id :" + id + "------");
            e.printStackTrace();
        }
        return product;

    }

    @Override
    public boolean removeProduct(int id) {


        System.out.println("methode removeProduct(int id) invoked");

        Product product= null;
        try {


            product= em.find(Product.class, id);
            em.remove(product);
            return true;
        } catch (NoResultException e) {
            System.out.println("-------no product with id :" + id + "------");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean addStockProduct(Product product, int stock) {


        System.out.println("methode addStockProduct(Product product, int stock)  invoked");

        try {
            product.setQuantite(product.getQuantite()+stock);
            em.persist(product);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("some problem when adding stock to product");
        }
        return false;

    }


}



