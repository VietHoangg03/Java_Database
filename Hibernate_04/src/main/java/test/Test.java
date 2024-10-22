package test;

import model.Customer;
import model.My_Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        if(sessionFactory != null){
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

//            Customer c1 = new Customer("001","Đinh Việt Hoàng","hoang@gmail.com");
//            My_Order o1 = new My_Order("OD01","Hà Nội",c1);
//            My_Order o2 = new My_Order("OD02","HCM",c1);
//            My_Order o3 = new My_Order("OD03","Huế",c1);
//            My_Order o4 = new My_Order("OD04","Đã Nẵng",c1);
//
//            List<My_Order> list = new ArrayList<My_Order>();
//            list.add(o1);
//            list.add(o2);
//            list.add(o3);
//            list.add(o4);
//
//            c1.setOrders(list);
//
//            session.saveOrUpdate(c1);
//            session.saveOrUpdate(o1);
//            session.saveOrUpdate(o2);
//            session.saveOrUpdate(o3);
//            session.saveOrUpdate(o4);
//
//            Customer c2 = new Customer("002","Nguyễn Khánh Linh","Linh@gmail.com");
//            session.saveOrUpdate(c2);

            String hql = "from Customer c where size(c.myOrders) > 0";
            List<Customer> results = session.createQuery(hql).list();
            for(Customer customer : results){
                System.out.println(customer);
            }

            transaction.commit();
            session.close();
        }
    }
}
