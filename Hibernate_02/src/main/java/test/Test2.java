package test;

import model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;
import java.util.Objects;

public class Test2 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        if (sessionFactory != null) {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            String hql = "Select p.name, p.spouse.name from Person p";
            List<Object[]> results = session.createQuery(hql).list();

            for (Object[] rs : results) {
                String name = rs[0] + "";
                String spouseName = rs[1] + "";

                System.out.println(name + " đã kết hôn với "+spouseName);
            }

            transaction.commit();
            session.close();
        }
    }
}
