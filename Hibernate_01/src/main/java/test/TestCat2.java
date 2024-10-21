package test;

import dao.CatDao;
import model.Cat;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.sql.Date;

public class TestCat2 {
    public static void main(String[] args) {
        // Transient
        Cat cat_1 = new Cat("Mèo long xu", new Date(System.currentTimeMillis()),true);

        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            if (sessionFactory != null) {
                Session session = sessionFactory.openSession();
                Transaction tr = session.beginTransaction();

                // Thực thi câu lệnh HQL
                session.save(cat_1); // Persistent

                tr.commit();

                // Detached => Persistent
                session.refresh(cat_1);
                session.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(cat_1);
    }
}
