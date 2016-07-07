package uet.jcia.shop.is;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import uet.jcia.shop.is.entities.Order;
import uet.jcia.shop.is.entities.OrderItem;

public class OrderItemDAOImpl implements OrderItemDAO {

	@Override
	public List<OrderItem> getOrderItemByOrderId(int order_id) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		List<OrderItem> result = null;
		try{
			 String hql = "from OrderItem";
			 String hql2 = "select ot from OrderItem ot , Order od WHERE od.orderId = :order_id";
			  
			 result = (List<OrderItem>)session.createQuery(hql2).setParameter("order_id", order_id).list();
			 session.getTransaction().commit();
			 return result;
		}
		catch(HibernateException e){
			e.printStackTrace();
			session.getTransaction().rollback();
			return null;
		}	
				
	}

	@Override
	public boolean addNewOrderItem(OrderItem item) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		try{
			session.save(item);
			session.getTransaction().commit();
			//session.close();
			return true;
		}
		catch(HibernateException e){
			e.printStackTrace();
			session.getTransaction().rollback();
			return false;
		}
	}

	@Override
	public boolean deleteOrderItem(OrderItem item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateOrderItem(OrderItem item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isOrderHasItem(Order order, OrderItem item) {
		// TODO Auto-generated method stub
		return false;
	}

}
