package test;

import model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.sql.Date;

public class Test {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        if (sessionFactory != null) {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

//            Person p1 = new Person("Nguyễn Văn A", new Date(System.currentTimeMillis()), null);
//            session.save(p1);

            //Person p1 = session.find(Person.class, 1L);
            //Person p2 = new Person("Nguyễn Thị C", new Date(System.currentTimeMillis()),p1);
            //session.save(p2);

            Person p1 = session.find(Person.class, 1L);
            Person p2 = session.find(Person.class, 2L);

            p1.setSpouse(p2);
            session.saveOrUpdate(p1);

            transaction.commit();
            session.close();
        }
    }
}
