package uet.jcia.shop.is;

import org.hibernate.Session;
import org.hibernate.query.Query;

import uet.jcia.shop.is.entities.Specification;

public class TestSpecificationDAO {

    public static void main(String[] args) {
        HibernateUtils.buildSessionFactory();
        SpecificationDAO dao = new SpecificationDAOImpl();
        
        /*System.out.println(dao.getAllSpecs());*/
        
        /*Specification s = new Specification("Dung luong RAM");
        dao.addNewSpec(s);*/
        
        /*Specification s = new Specification();
        s.setSpecId(4);
        s.setName("HDD Size");
        dao.updateSpec(s);*/
        
        /*Specification s = new Specification();
        s.setSpecId(4);
        dao.deleteSpec(s);*/
        HibernateUtils.closeSessionFactory();
    }
}
