package uet.jcia.shop.is;

import java.util.List;

import uet.jcia.shop.is.entities.Order;
import uet.jcia.shop.is.entities.OrderItem;

public interface OrderItemDAO {
	List<OrderItem> getOrderItemByOrderId(int orderId);
	boolean addNewOrderItem(OrderItemDAO item);
	boolean deleteOrderItem(OrderItemDAO item);
	boolean updateOrderItem(OrderItemDAO item);
	boolean isOrderHasItem(Order order, OrderItemDAO item);
}
