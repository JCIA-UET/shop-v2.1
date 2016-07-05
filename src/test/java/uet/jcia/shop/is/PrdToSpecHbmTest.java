package uet.jcia.shop.is;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import uet.jcia.shop.is.entities.Product;
import uet.jcia.shop.is.entities.ProductSpecification;
import uet.jcia.shop.is.entities.Category;
import uet.jcia.shop.is.entities.Specification;

public class PrdToSpecHbmTest {

    public static void main(String[] args) {
        SessionFactory factory = HibernateUtils.buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        
        ProductDAO pDao = new ProductDAOImpl();
        SpecificationDAO sDao = new SpecificationDAOImpl();
        
        Product p = new Product();
        p.setProductId(1);
        p = pDao.getProduct(p);
        
        Specification s = new Specification();
        s.setSpecId(1);
        s = sDao.getSpec(s);
        
        ProductSpecification ps = new ProductSpecification();
        ps.setProduct(p);
        ps.setSpec(s);
        ps.setSpecName(s.getName());
        ps.setValue("NULL-Company");
        
        session.save(ps);
        
        transaction.commit();
        session.close();
        HibernateUtils.closeSessionFactory();
    }
}
