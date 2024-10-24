package dao;

import model.Cat;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class CatDao implements DAOInterface<Cat> {
    public static CatDao instance;
    public static CatDao getInstance() {
        if (instance == null) {
            instance = new CatDao();
        }
        return instance;
    }

    @Override
    public List<Cat> selectAll() {
        List<Cat> cats = new ArrayList<>();
         try {
             SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
             if (sessionFactory != null) {
                 Session session = sessionFactory.openSession();
                 Transaction tr = session.beginTransaction();
                 // Thực thi câu lệnh HQL
                 String hql = "from Cat";
                 Query query = session.createQuery(hql);
                 cats = query.getResultList();
                 tr.commit();
                 session.close();
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
     return cats;
    }

    @Override
    public Cat selectById(Cat cat) {
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
        return  result;
    }

    public boolean saveOrUpdate(Cat cat) {
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            if (sessionFactory != null) {
                Session session = sessionFactory.openSession();
                Transaction tr = session.beginTransaction();
                // Thực thi câu lệnh HQL
                // Chỉ lu khi chưa tồn tại
                // session.save(cat);

                // Thêm mới khi chưa tồn tại, cập nhật dữ liệu khi đã tồn tại
                session.saveOrUpdate(cat);

                tr.commit();
                session.close();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean insert(Cat cat) {
        return saveOrUpdate(cat);
    }

    @Override
    public boolean update(Cat cat) {
        return saveOrUpdate(cat);
    }

    @Override
    public boolean delete(Cat cat) {
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            if (sessionFactory != null) {
                Session session = sessionFactory.openSession();
                Transaction tr = session.beginTransaction();
                // Thực thi câu lệnh HQL
                session.delete(cat);

                tr.commit();
                session.close();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
