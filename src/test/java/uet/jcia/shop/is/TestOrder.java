package uet.jcia.shop.is;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import uet.jcia.shop.is.entities.Customer;
import uet.jcia.shop.is.entities.Order;
import uet.jcia.shop.is.entities.OrderItem;
import uet.jcia.shop.is.entities.Product;

public class TestOrder {
    
    public static void main(String[] args) {
        SessionFactory factory = HibernateUtils.buildSessionFactory();
        Session session = factory.openSession();
        Transaction tran = session.beginTransaction(); 
        
        String cSql = "select c from " + Customer.class.getName() +
                " c where c.customerId=:id";
        Query cQuery = session.createQuery(cSql);
        cQuery.setParameter("id", 1);
        
        String pSql = "select p from " + Product.class.getName() +
                " p where p.productId=:id";
        Query pQuery = session.createQuery(pSql);
        pQuery.setParameter("id", 1);
        
        String oSql = "select o from " + Order.class.getName() +
                " o";
        Query oQuery = session.createQuery(oSql);
        
        Customer customer = (Customer) cQuery.getSingleResult();
        Product product = (Product) pQuery.getSingleResult();
        
        System.out.println(oQuery.list());
        
//        Order order = new Order(
//                customer.getFirstName(), customer.getLastName(), customer.getTelephone(),
//                "this is address", "This is the comment", 1, 0.0,
//                new Date(), new Date(), customer);
//        
//        int quantity = 2;
//        double price = 1300000.0;
//        OrderItem orderItem = new OrderItem(
//                "item laptop", "model1", 
//                quantity, price, quantity * price, order, product);
//        
//        Set<OrderItem> orderItemsSet = new HashSet<>();
//        orderItemsSet.add(orderItem);
//        
//        
//        session.save(order);
//        
//        session.save(orderItem);
        
        tran.commit();
        session.close();
        HibernateUtils.closeSessionFactory();
    }
}
