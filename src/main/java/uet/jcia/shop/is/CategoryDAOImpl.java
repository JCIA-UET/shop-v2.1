package uet.jcia.shop.is;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import uet.jcia.shop.is.entities.Category;

public class CategoryDAOImpl implements CategoryDAO {

    @Override
    public List<Category> getAllCategories() {
        Session session =  HibernateUtils.getSessionFactory().openSession();
        try {
            Query query = session.createQuery("from Category");
            return query.list();
            
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Category getCategory(Category category) {
        Session session =  HibernateUtils.getSessionFactory().openSession();
        try {
            return session.get(
                    Category.class, category.getCategoryId());
            
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean addNewCategory(Category category) {
        Session session =  HibernateUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.save(category);
            tx.commit();
            return true;
        } catch (HibernateException e) {
            e.printStackTrace();
            tx.rollback();
            return false;
        }
    }

    @Override
    public boolean deleteCategory(Category category) {
        Session session =  HibernateUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            Category c = getCategory(category);
            session.delete(c);
            tx.commit();
            return true;
            
        } catch (HibernateException e) {
            e.printStackTrace();
            tx.rollback();
            return false;
        }
    }

    @Override
    public boolean updateCategory(Category updatedCategory) {
        Session session =  HibernateUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            Category c = session.load(Category.class, updatedCategory.getCategoryId());
            
            c.setParentId(updatedCategory.getParentId());
            c.setName(updatedCategory.getName());
            c.setDescription(updatedCategory.getDescription());
            
            session.update(c);
            tx.commit();
            return true;
            
        } catch (HibernateException e) {
            e.printStackTrace();
            tx.rollback();
            return false;
        }
    }
    
}
