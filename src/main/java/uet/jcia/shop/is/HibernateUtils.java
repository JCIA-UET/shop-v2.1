package uet.jcia.shop.is;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
    
    private static final Configuration configuration =
            new Configuration().configure("/hibernate.cfg.xml");
    private static SessionFactory sessionFactory;
    
    public static SessionFactory buildSessionFactory() {
        sessionFactory = configuration.buildSessionFactory();
        return sessionFactory;
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public static void closeSessionFactory() {
        sessionFactory.close();
    }
}
