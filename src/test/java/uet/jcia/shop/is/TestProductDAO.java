package uet.jcia.shop.is;

import java.util.Date;
import java.util.List;

import uet.jcia.shop.is.entities.Category;
import uet.jcia.shop.is.entities.Product;
import uet.jcia.shop.is.entities.ProductSpecification;
import uet.jcia.shop.is.entities.Specification;

public class TestProductDAO {
    
    public static void main(String[] args) {
        HibernateUtils.buildSessionFactory();
        ProductDAO pDao = new ProductDAOImpl();
        SpecificationDAO sDao = new SpecificationDAOImpl();
        
        /*List<Product> list = dao.getAllProducts();
        
        for (Product p : list) {
            System.out.println(p);
            System.out.println(p.getSpecs());
        }*/
        
        /*System.out.println(dao.getProductById(1));*/
        
        /*Category c = new Category();
        c.setCategoryId(1);
        Product product = new Product(
                20, 1, 100.0, "Lumia 920", "dien thoai nokia", "black",
                "image", new Date(), new Date(), c);
        
        dao.addNewProduct(product);*/
        
        /*Product p = new Product();
        p.setProductId(2);
        Specification s = new Specification();
        s.setSpecId(1);
        s = sDao.getSpec(s);
        
        ProductSpecification ps = new ProductSpecification();
        ps.setProduct(p);
        ps.setSpec(s);
        ps.setSpecName(s.getName());
        ps.setValue("Null company");
        
        pDao.addSpecValuesForProduct(ps);*/
        
        /*Product p = new Product();
        p.setProductId(2);
        System.out.println(pDao.getSpecValuesForProduct(p));*/
        
        /*Category c = new Category();
        c.setCategoryId(1);
        Product p = new Product(
                100, 1, 50.0, "Nokia 2626", "dien thoai nokia", "gray",
                "image", new Date(), new Date(), c);
        p.setProductId(2);
        
        pDao.updateProduct(p);*/
        
        /*Product p = new Product();
        p.setProductId(2);
        pDao.deleteProduct(p);*/
        
        HibernateUtils.closeSessionFactory();
    }
    
}
