package test;

import model.CuocHop;
import model.NhanVien;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.sql.Date;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        if(sessionFactory != null){
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            NhanVien nv1 = new NhanVien("NV1","Đinh Việt Hoàng", new Date(2000,10,26));
            session.saveOrUpdate(nv1);

            CuocHop ch1 = new CuocHop();
            ch1.setTenCuocHop("Hội đồng quản trị công ty");
            ch1.setThoiGian(new Date(2025,2,28));
            ch1.setDiaDiem("Phòng họp 1");
            ch1.addNhanVien(nv1);

            session.saveOrUpdate(ch1);

            transaction.commit();
            session.close();
        }
    }
}
