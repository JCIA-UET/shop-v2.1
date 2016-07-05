package uet.jcia.shop.is;

import java.util.List;

import uet.jcia.shop.is.entities.Product;
import uet.jcia.shop.is.entities.ProductSpecification;
import uet.jcia.shop.is.entities.Specification;

public interface ProductDAO {
	List<Product> getAllProducts();
	Product getProduct(Product product);
	boolean addNewProduct(Product product);
	boolean deleteProduct(Product product);
	boolean updateProduct(Product product);
	boolean addSpecValuesForProduct(ProductSpecification ps);
	List<ProductSpecification> getSpecValuesForProduct(Product product);
}
