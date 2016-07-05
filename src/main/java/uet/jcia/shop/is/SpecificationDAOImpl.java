package uet.jcia.shop.is;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import uet.jcia.shop.is.entities.Product;
import uet.jcia.shop.is.entities.Specification;

public class SpecificationDAOImpl implements SpecificationDAO {

    @Override
    public List<Specification> getAllSpecs() {
        Session session =  HibernateUtils.getSessionFactory().openSession();
        try {
            Query query = session.createQuery("from Specification");
            return query.list();
            
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean addNewSpec(Specification spec) {
        Session session =  HibernateUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.save(spec);
            tx.commit();
            return true;
        } catch (HibernateException e) {
            e.printStackTrace();
            tx.rollback();
            return false;
        }
    }

    @Override
    public boolean deleteSpec(Specification spec) {
        Session session =  HibernateUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            Specification s = session.get(Specification.class, spec.getSpecId());
            session.delete(s);
            tx.commit();
            return true;
            
        } catch (HibernateException e) {
            e.printStackTrace();
            tx.rollback();
            return false;
        }
    }

    @Override
    public boolean updateSpec(Specification updatedSpec) {
        Session session =  HibernateUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            Specification s = session.load(
                   Specification.class, updatedSpec.getSpecId());
            
            s = updatedSpec;
            session.update(s);
            
            tx.commit();
            return true;
            
        } catch (HibernateException e) {
            e.printStackTrace();
            tx.rollback();
            return false;
        }
    }

    @Override
    public Specification getSpec(Specification spec) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            return session.get(Specification.class, spec.getSpecId());
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        }
    }

}
