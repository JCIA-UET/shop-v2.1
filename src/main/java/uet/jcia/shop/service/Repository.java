/**
 * Repository.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package uet.jcia.shop.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import uet.jcia.shop.exception.InvalidArgumentException;
import uet.jcia.shop.is.entities.Category;
import uet.jcia.shop.is.entities.Product;
import uet.jcia.shop.is.entities.Specification;

@WebService
public interface Repository {
    @WebMethod public Product getProductById(Integer productId) throws InvalidArgumentException;
    @WebMethod public void updateProduct(Product p);
    @WebMethod public void addProduct(Product p);
    @WebMethod public void deleteProduct(Product p);
    @WebMethod public List<Product> getProductsByCategoryId(Integer categoryId);
   
    @WebMethod public Category getCategoryById(Integer categoryId) throws InvalidArgumentException;
    @WebMethod public void updateCategory(Category c);
    @WebMethod public List<Category> getAllCategories();
    @WebMethod public void addCategory(Category c);
    @WebMethod public void deleteCategory(Category c);
    
    @WebMethod public void addSpecification(Specification s);
    @WebMethod public List<Specification> getAllSpecification();
    @WebMethod public void deleteSpecification(Specification s);
    @WebMethod public void updateSpecification(Specification s);
}
