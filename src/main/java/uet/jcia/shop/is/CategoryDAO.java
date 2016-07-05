package uet.jcia.shop.is;

import java.util.List;

import uet.jcia.shop.is.entities.Category;

public interface CategoryDAO {
    
	List<Category> getAllCategories();
	Category getCategory(Category categoryId);
	boolean addNewCategory(Category category);
	boolean deleteCategory(Category categoryId);
	boolean updateCategory(Category category);
}
