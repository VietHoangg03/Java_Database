package test;

import dao.CatDao;
import model.Cat;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.sql.Date;
import java.util.List;

public class TestCat {
    public static void main(String[] args) {
        CatDao catDao = new CatDao();

        // Test selectAll();
//        List<Cat> listCat = catDao.selectAll();
//        for (Cat cat : listCat) {
//            System.out.println(cat.toString());
//        }

        // Test selectByID
//        Cat c = new Cat();
//        c.setId(2);
//
//        Cat c1 = catDao.selectById(c);
//        System.out.println(c1);

        //Test insert
//        Cat c3 = new Cat("Meo beo 00", new Date(2024,2,25),true);
//        Cat c4 = new Cat("Meo gay", new Date(2024,2,25),false);
//        c3.setId(5);
//        catDao.delete(c3);

        // Trong cơ sở dữ liệu => lôi lên thành persision, Đối tượng chưa động chạm gì
        // với sql thì là transient, và kết thúc kết nối với database li thành trasient
        // * Phương thức persist(): Sẽ không trả về ID, không báo lỗi khi gặp lỗi, tương
        // tự hàm save nhưng không trả về giá trị nào cả.

        // Transient chưa đông chạm setsion
//        Cat cat1 = new Cat();
//        cat1.setId(1);
//
//        catDao.selectById(cat1); // => Chuyển cat 1 thành persistent
//
//        System.out.println(catDao.selectById(cat1)); // thành 1 transion

        Cat result = null;
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            if (sessionFactory != null) {
                Session session = sessionFactory.openSession();
                Transaction tr = session.beginTransaction();

                // Thực thi câu lệnh HQL
                result = session.get(Cat.class,1); //Persision

                tr.commit();
                session.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
