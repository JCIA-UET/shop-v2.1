package uet.jcia.shop.is;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


import uet.jcia.shop.is.entities.Category;

public class CategoryDAOImpl implements CategoryDAO {

    @Override
    public List<Category> getAllCategories() {
        Session session =  HibernateUtils.getSessionFactory().openSession();
        try {
             
            return session.createQuery("from Category").list();
            
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Category getCategoryById(Integer categoryId) {
        Session session =  HibernateUtils.getSessionFactory().openSession();
        try {
            return (Category)session.get(
                    Category.class, categoryId);
            
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean addCategory(Category category) {
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
            Category c = getCategoryById(category.getCategoryId());
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
            Category c = (Category)session.load(Category.class, updatedCategory.getCategoryId());
            
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
