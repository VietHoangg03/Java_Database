package test;

import model.GiaoVien;
import model.SinhVien;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.sql.Date;

public class Test {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        if(sessionFactory != null){
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            GiaoVien gv = new GiaoVien("GV01","Nguyễn Văn A", new Date(100,1,30),"Hibernate");
            SinhVien sv = new SinhVien("01234","Sinh Viên 1", new Date(105,2,25),9.8);

            session.save(gv);
            session.save(sv);


            transaction.commit();
            session.close();
        }
    }
}
