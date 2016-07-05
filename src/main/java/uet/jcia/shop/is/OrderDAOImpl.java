package uet.jcia.shop.is;

import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import uet.jcia.shop.is.entities.Customer;
import uet.jcia.shop.is.entities.Order;

public class OrderDAOImpl implements OrderDao {

	private NativeQuery<Order> addEntity;

	@Override
	public List<Order> getAllOrder() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        session.beginTransaction();
        List<Order> listOrder = null ; 
        
		try {
			String cHql= "from Order";
			Query<Order> cQuery = session.createQuery(cHql);
			listOrder = cQuery.list();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
			return listOrder;
		}
		
	}

	@SuppressWarnings("finally")
	@Override
	public Order getOrderById(Integer orderId) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		Order order = null;
		try{
			order = session.load(Order.class, orderId);
			Hibernate.initialize(order);
			session.getTransaction().commit();
		}
		catch(HibernateException e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		finally{
			session.close();
			return order;
		}
		
		
	}

	@SuppressWarnings("finally")
	@Override
	public boolean addNewOrder(Order order, Customer customer) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		if(customer == null) return false;
		try{
			order.setCustomer(customer);
		    session.save(order);
			session.getTransaction().commit();
		}
		catch(HibernateException e){
			e.printStackTrace();
			session.getTransaction().rollback();
			return false;
		}
		finally{
			session.close();
			return true;
		}
					
		
	}

	@SuppressWarnings("finally")
	@Override
	public boolean deleteOrder(Order order) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		if(order == null) return false;
		try{
			 session.delete("Order", order);
			 session.getTransaction().commit();
		}
		catch(HibernateException e){
			e.printStackTrace();
			session.getTransaction().rollback();
			return false;
		}
		finally{
			session.close();
			return true;
		}
					
		
	}

	@SuppressWarnings("finally")
	@Override
	public boolean updateOrder(Order order, int orderId) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		if(order == null) return  false;
		try{
			 org.hibernate.Transaction tx1 = session.beginTransaction();
			 Order orderGet = session.load(Order.class, orderId);
			 Hibernate.initialize(orderGet);
			 tx1.commit();
			 
			 orderGet.setAddress(order.getAddress());
			 orderGet.setComment(order.getComment());
			 orderGet.setCustomer(order.getCustomer());
			 orderGet.setDateAdded(order.getDateAdded());
			 orderGet.setDateModified(order.getDateModified());
			 orderGet.setFirstName(order.getFirstName());
			 orderGet.setLastName(order.getLastName());
			 orderGet.setOrderItems(order.getOrderItems());
			 orderGet.setStatus(order.getStatus());
			 orderGet.setTelephone(order.getTelephone());
			 orderGet.setTotal(order.getTotal());
			 
			 org.hibernate.Transaction tx2 = session.beginTransaction();
			 session.update(orderGet);
			 tx2.commit();
		}
		catch(HibernateException e){
			e.printStackTrace();
			session.getTransaction().rollback();
			return false;
		}
		finally{
			session.close();
			return true;
		}
					
	}

	@Override
	public Double getTotal(Order order) {
		// TODO Auto-generated method stub
		return order.getTotal();
	}

	
	@Override
	public List<Order> getListOrderByCustomerId(int customer_id) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		List<Order> result = null;
		try{
			String hql = "select o from Order o , Customer c Where c.customerId = :customer_id";
			Query<Order> query = session.createQuery(hql);
			query.setParameter("customer_id", customer_id);
			result = (List<Order>) query.getResultList();
			session.getTransaction().commit();
		}
		catch(HibernateException e){
			e.printStackTrace();
			session.getTransaction().rollback();
			return null;
		}
		finally{
			session.close();
			return result;
		}
					
	}

}
