package uet.jcia.shop.is;

import java.util.List;

import uet.jcia.shop.is.entities.Category;

public class TestCategoryDAO {
    
    public static void main(String[] args) {
        HibernateUtils.buildSessionFactory();
        
        CategoryDAO dao = new CategoryDAOImpl();
        
        // get all categories
        /*List<Category> categoriesList = dao.getAllCategories();
        
        for (Category c : categoriesList) {
            System.out.println(c);
            System.out.println(c.getProducts());
        }*/
        
        // add category
        /*Category c = new Category(0, "Do gia dung", "Ban cac loai do gia dung");
        dao.addNewCategory(c);*/
        
        // delete category
        /*dao.deleteCategory(2);*/
        
        // update category
        /*Category c = new Category();
        c.setCategoryId(3);
        c.setParentId(0);
        c.setName("Households");
        c.setDescription("category about households");
        dao.updateCategory(c);*/
        
        HibernateUtils.closeSessionFactory();
    }
    
}
