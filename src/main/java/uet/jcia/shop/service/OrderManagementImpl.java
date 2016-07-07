package uet.jcia.shop.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import uet.jcia.shop.is.OrderDAOImpl;
import uet.jcia.shop.is.OrderItemDAOImpl;
import uet.jcia.shop.is.entities.Order;
import uet.jcia.shop.is.entities.OrderItem;


@WebService(endpointInterface = "uet.jcia.shop.service.OrderManagement")
public class OrderManagementImpl implements OrderManagement {
	
	private OrderDAOImpl orderDAOImpl = new OrderDAOImpl();
	private OrderItemDAOImpl orderItemDAOImpl = new OrderItemDAOImpl();
	
	
	@WebMethod
	public List<Order> getAllOrder() {
		return orderDAOImpl.getAllOrder();
	}
	@WebMethod
	public List<Order> getListOrderByCustomerId(int customerId) {
		return orderDAOImpl.getListOrderByCustomerId(customerId) ;
	}
	@WebMethod

	public List<OrderItem> getListOrderItemByOrderId(int orderId){
		return orderItemDAOImpl.getOrderItemByOrderId(orderId);
	}
	@WebMethod
	public Order getOrderById(int id) {
		Order order =  orderDAOImpl.getOrderById(id);
		System.out.println(order);
		return order;
	}
	@WebMethod
	public boolean deleteOrderById(int id) {
		return orderDAOImpl.deleteOrder(id);
	}
	@WebMethod
	public boolean updateOrder(int orderId, Order order) {
		return orderDAOImpl.updateOrder(order);
	}
	@Override
	public List<Order> getListOrderByDate(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

}
