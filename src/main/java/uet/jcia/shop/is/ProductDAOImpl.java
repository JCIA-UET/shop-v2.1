package uet.jcia.shop.is;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


import uet.jcia.shop.is.entities.Product;
import uet.jcia.shop.is.entities.ProductSpecification;
import uet.jcia.shop.is.entities.Specification;

public class ProductDAOImpl implements ProductDAO {

    @Override
    public List<Product> getAllProducts() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            return session.createQuery("from Product").list();
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Product getProductById(Integer productId) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Product p = null;
        try {
            p = (Product)session.get(Product.class, productId);
            session.close();
            return p;
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean addNewProduct(Product product) {
        Session session =  HibernateUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        try {
            session.save(product);
            tx.commit();
            return true;
        } catch (HibernateException e) {
            e.printStackTrace();
            tx.rollback();
            return false;
        }
    }

    @Override
    public boolean deleteProduct(Product product) {
        Session session =  HibernateUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            Product p = (Product)session.get(Product.class, product.getProductId());
            session.delete(p);
            tx.commit();
            return true;
            
        } catch (HibernateException e) {
            e.printStackTrace();
            tx.rollback();
            return false;
        }
    }

    @Override
    public boolean updateProduct(Product uProduct) {
        Session session =  HibernateUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            Product p = (Product)session.load(
                   Product.class, uProduct.getProductId());
            
            p = uProduct;
            session.update(p);
            
            tx.commit();
            return true;
            
        } catch (HibernateException e) {
            e.printStackTrace();
            tx.rollback();
            return false;
        }
    }

    @Override
    public boolean addSpecValuesForProduct(ProductSpecification ps) {
        Session session =  HibernateUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        try {
            session.save(ps);
            tx.commit();
            return true;
        } catch (HibernateException e) {
            e.printStackTrace();
            tx.rollback();
            return false;
        }
    }

    @Override
    public List<ProductSpecification> getSpecValuesForProduct(Product product) {
        List<ProductSpecification> list = new ArrayList<>();
        list.addAll(product.getProductSpecs());
        return list;
    }
    
}
