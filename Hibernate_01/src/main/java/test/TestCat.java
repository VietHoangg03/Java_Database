package test;

import dao.CatDao;
import model.Cat;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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


        Cat cat1 = new Cat();
        cat1.setId(1);
        catDao.selectById(cat1);

        System.out.println(catDao.selectById(cat1));
    }
}
