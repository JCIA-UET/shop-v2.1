package uet.jcia.shop.is;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

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
			 Query<OrderItem> query = session.createQuery(hql2);
			 query.setParameter("order_id", order_id);
			 result = (List<OrderItem>)query.getResultList();
			 session.getTransaction().commit();
			 
		}
		catch(HibernateException e){
			e.printStackTrace();
			session.getTransaction().rollback();
			return null;
		}	
		finally{
			
				session.close();return result;
			}
		
		
		
	
					
	}

	@Override
	public boolean addNewOrderItem(OrderItemDAO item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteOrderItem(OrderItemDAO item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateOrderItem(OrderItemDAO item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isOrderHasItem(Order order, OrderItemDAO item) {
		// TODO Auto-generated method stub
		return false;
	}

}
