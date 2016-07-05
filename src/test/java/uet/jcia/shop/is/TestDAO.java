package uet.jcia.shop.is;

import java.util.Date;

import uet.jcia.shop.is.entities.Order;

public class TestDAO {
	public static void main(String[] args) {
		OrderDAOImpl orderDAOImpl = new OrderDAOImpl();
		HibernateUtils.buildSessionFactory();		
	
//		Order order = new Order("Nguyen","hieu","0978963262","cầu giấy","this is a comment",
//								1, 2000.0, new Date(),new Date());
//		System.out.println(orderDAOImpl.addNewOrder(order, null));
		
//		orderDAOImpl.deleteOrder(orderDAOImpl.getOrderById(14));
		
	//	System.out.println(orderDAOImpl.getListOrderByCustomerId(1));
		
		
		OrderItemDAOImpl test = new OrderItemDAOImpl();
		System.out.println(test.getOrderItemByOrderId(15));
		
		HibernateUtils.closeSessionFactory();
	}
}
