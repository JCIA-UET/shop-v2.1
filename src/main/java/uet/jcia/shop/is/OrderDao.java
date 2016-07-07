package uet.jcia.shop.is;

import java.util.Date;
import java.util.List;

import uet.jcia.shop.is.entities.Customer;
import uet.jcia.shop.is.entities.Order;

public interface OrderDao {
	List<Order> getAllOrder();
	List<Order> getListOrderByCustomerId(int customer_id);
	Order getOrderById(Integer orderId);
	boolean addNewOrder(Order order, Customer customer);
	boolean deleteOrder(int orderId);
	boolean updateOrder(Order order);
	Double getTotal(Order order);
	public List<Order> getListOrderByDate(Date date);
}
