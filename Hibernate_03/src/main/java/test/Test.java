package test;

import model.Author;
import model.Book;
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

Author author_1 = new Author("001", "Nguyễn Nhật Ánh", new Date(System.currentTimeMillis()));
//            Book b1 = new Book("b01","Cho tôi xin một vé đi tuổi thơ", 50000, author_1);
//            Book b2 = new Book("b02","Thấy hoa vàng trên cỏ xanh", 50000, author_1);
//            Book b3 = new Book("b03","Dế mèn phưu lưu kí", 50000, author_1);
//            Book b4 = new Book("b04","ti là beto", 50000, author_1);
//
session.saveOrUpdate(author_1);
//            session.saveOrUpdate(b1);
//            session.saveOrUpdate(b2);
//            session.saveOrUpdate(b3);
//            session.saveOrUpdate(b4);

            Author author_2 = new Author("002", "Dinh Viet Hoang", new Date(System.currentTimeMillis()));
            Book b5 = new Book("b05","Lập trình C", 50000, author_2);
            Book b6 = new Book("b06","Lập trình Java", 50000, author_2);
            Book b7 = new Book("b07","Hệ điều hành", 50000, author_2);

            session.saveOrUpdate(author_2);
          session.saveOrUpdate(b5);
          session.saveOrUpdate(b6);
           session.saveOrUpdate(b7);

            transaction.commit();
            session.close();
        }
    }
}
