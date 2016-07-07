package uet.jcia.shop.service;

import java.util.Date;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import uet.jcia.shop.is.entities.Order;
import uet.jcia.shop.is.entities.OrderItem;

@WebService
public interface OrderManagement {
	@WebMethod public List<Order> getAllOrder();
	@WebMethod public List<Order> getListOrderByCustomerId(int customerId);
	@WebMethod public List<OrderItem> getListOrderItemByOrderId(int orderId);
	@WebMethod public Order getOrderById(int id);
	@WebMethod public boolean deleteOrderById(int id);
	@WebMethod public boolean updateOrder(int orderId, Order order);
	@WebMethod public List<Order> getListOrderByDate(Date date);
}
