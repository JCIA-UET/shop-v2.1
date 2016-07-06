package uet.jcia.shop.service;

import java.util.List;

import javax.jws.WebService;

import uet.jcia.shop.is.entities.Order;
import uet.jcia.shop.is.entities.OrderItem;


@WebService
public class OrderManagementImpl implements OrderManagement {

	@Override
	public List<Order> getAllOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getListOrderByCustomerId(int customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderItem> getListOrderItemByOrderId(int orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order getOrderById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteOrderById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateOrder(int orderId, Order order) {
		// TODO Auto-generated method stub
		return false;
	}

}
