package test;

import model.Cat;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

public class TestCat {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        if(sessionFactory != null){
            Session session = sessionFactory.openSession();
            try {
                Cat cat1 = new Cat();
                cat1.setName("Tom");
                cat1.setSex(true);
                session.save(cat1);
            } finally {
                session.close();
            }
        }
    }
}
