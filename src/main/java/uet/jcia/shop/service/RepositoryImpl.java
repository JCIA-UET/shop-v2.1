package uet.jcia.shop.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.jws.WebService;

import uet.jcia.shop.exception.InvalidArgumentException;
import uet.jcia.shop.is.CategoryDAO;
import uet.jcia.shop.is.CategoryDAOImpl;
import uet.jcia.shop.is.ProductDAO;
import uet.jcia.shop.is.ProductDAOImpl;
import uet.jcia.shop.is.SpecificationDAO;
import uet.jcia.shop.is.SpecificationDAOImpl;
import uet.jcia.shop.is.entities.Category;
import uet.jcia.shop.is.entities.Product;
import uet.jcia.shop.is.entities.Specification;

@WebService(endpointInterface = "uet.jcia.shop.service.Repository")
public class RepositoryImpl implements Repository {

	private CategoryDAO cDao = new CategoryDAOImpl();
	private ProductDAO pDao = new ProductDAOImpl();
	private SpecificationDAO sDao = new SpecificationDAOImpl();
	
	@Override
	public Category getCategoryById(Integer categoryId) throws InvalidArgumentException {
		Category c = cDao.getCategoryById(categoryId);
		if (c == null) throw new InvalidArgumentException("invalid category id");
		else return c;
	}

	@Override
	public List<Category> getAllCategories() {
		return cDao.getAllCategories();
	}

	@Override
	public void addCategory(Category c) {
		cDao.addCategory(c);
		
	}

	@Override
	public void updateCategory(Category c) {
		cDao.updateCategory(c);
		
	}

	@Override
	public void deleteCategory(Category c) {
		cDao.deleteCategory(c);
		
	}

	@Override
	public Product getProductById(Integer productId) throws InvalidArgumentException {
		Product p = pDao.getProductById(productId);
		if (p == null) throw new InvalidArgumentException("invalid product id");
		else return p;
	}

	@Override
	public List<Product> getProductsByCategoryId(Integer categoryId) {
		Category c = cDao.getCategoryById(categoryId);
		Set<Product> set = c.getProducts();
		List<Product> list = new ArrayList<>();
		list.addAll(set);
		return list;
	}

	@Override
	public void addProduct(Product p) {
		pDao.addProduct(p);
	}

	@Override
	public void updateProduct(Product p) {
		pDao.updateProduct(p);
	}

	@Override
	public void deleteProduct(Product p) {
		pDao.deleteProduct(p);
	}

	@Override
	public List<Specification> getAllSpecification() {
		return sDao.getAllSpecs();
	}

	@Override
	public void addSpecification(Specification s) {
		sDao.addSpec(s);
	}

	@Override
	public void updateSpecification(Specification s) {
		sDao.updateSpec(s);
		
	}

	@Override
	public void deleteSpecification(Specification s) {
		sDao.deleteSpec(s);
	}


}
