package uet.jcia.shop.service;

import java.util.Date;
import java.util.Set;

import javax.jws.WebMethod;
import javax.jws.WebService;

import uet.jcia.shop.is.CustomerDAOImpl;
import uet.jcia.shop.is.OrderDAOImpl;
import uet.jcia.shop.is.OrderItemDAOImpl;
import uet.jcia.shop.is.ProductDAOImpl;
import uet.jcia.shop.is.entities.Address;
import uet.jcia.shop.is.entities.Customer;
import uet.jcia.shop.is.entities.Order;
import uet.jcia.shop.is.entities.OrderItem;
import uet.jcia.shop.is.entities.Product;


@WebService(endpointInterface = "uet.jcia.shop.service.Transaction")
public class TransactionImplementation implements Transaction {

	
	@WebMethod
	@Override
	public boolean doBuy(int customerId, Set<Product> list) {
		CustomerDAOImpl manageCus = new CustomerDAOImpl();
		Customer customer = manageCus.getCustomerById(customerId);
		
		Address address = manageCus.getDefaultAddress(customer);
		
		if(customer == null || list == null) return false;
		else {
			Order order = new Order(customer.getFirstName(), customer.getLastName(), customer.getTelephone(), address.getAddress(),"no comment",  1, 6.6, new Date(), new Date());
			OrderDAOImpl orderDAOImpl = new OrderDAOImpl();
			orderDAOImpl.addNewOrder(order, customer);
			
			OrderItemDAOImpl orderItemDAOImpl = new OrderItemDAOImpl();
			ProductDAOImpl productDAOImpl = new ProductDAOImpl();
			
			for(Product product:list){
				OrderItem orderItem = new OrderItem(product.getName(), product.getModel(), product.getQuantity(), product.getPrice(),product.getQuantity()* product.getPrice() );
				orderItem.setProduct(product);
				orderItem.setOrder(order);
				orderItemDAOImpl.addNewOrderItem(orderItem);
				
				Product product1 = productDAOImpl.getProductById(product.getProductId());
				product1.setQuantity(product1.getQuantity()-product.getQuantity());
				productDAOImpl.updateProduct(product1);
			}
			return true;
		}
	}

}
