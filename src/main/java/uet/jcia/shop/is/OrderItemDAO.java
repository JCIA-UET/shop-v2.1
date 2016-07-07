package uet.jcia.shop.is;

import java.util.List;

import uet.jcia.shop.is.entities.Order;
import uet.jcia.shop.is.entities.OrderItem;

public interface OrderItemDAO {
	List<OrderItem> getOrderItemByOrderId(int orderId);
	boolean addNewOrderItem(OrderItem item);
	boolean deleteOrderItem(OrderItem item);
	boolean updateOrderItem(OrderItem item);
	boolean isOrderHasItem(Order order, OrderItem item);
}
