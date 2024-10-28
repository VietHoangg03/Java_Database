package test;

import model.ChiTietDonHang;
import model.DonHang;
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

            DonHang dh1 = new DonHang();
            dh1.setTenKhachHang("Hoàng Đinh");
            dh1.setNgayMua(new Date(System.currentTimeMillis()));

            ChiTietDonHang chiTietDonHang1 = new ChiTietDonHang();
            chiTietDonHang1.setTenSanPham("Mì hảo hảo");
            chiTietDonHang1.setSoLuong(5);
            chiTietDonHang1.setGiaBan(5000);
            chiTietDonHang1.setThanhTien(5*5000);
            chiTietDonHang1.setDonHang(dh1);

            ChiTietDonHang chiTietDonHang2 = new ChiTietDonHang();
            chiTietDonHang2.setTenSanPham("Sữa tươi");
            chiTietDonHang2.setSoLuong(5);
            chiTietDonHang2.setGiaBan(5000);
            chiTietDonHang2.setThanhTien(5*5000);
            chiTietDonHang2.setDonHang(dh1);

            dh1.addCTDH(chiTietDonHang1);
            dh1.addCTDH(chiTietDonHang2);

            session.saveOrUpdate(dh1);

            //Cascode ALL : Khi sửa dữ liệu hoặc xoá một mối quan hệ của đơn hàng
            // Sẽ xoá luôn dữ liệu ở thằng con
            // CascadeType.ALL = khi xoá  dữ liệu phía ONE thì sẽ xoá luôn MANY
//            DonHang dh = session.load(DonHang.class, 1);
//            session.remove(dh);

            //CascadeType.PERSIST: Chỉ lưu đối tượng gọi hàm save
            //CascadeType.REMOVE: Khi lưu lưu phía ONE, Còn khi xoá sẽ xoá cả phía MANY
            //CascadeType.MERGE: Khi ONE cập nhật sẽ thay đổi toàn bộ thằng con bị thay đổi
            // và cập nhật theo

            // Trong thực tế thì dùng CascadeType.ALL nhiều nhất.

            transaction.commit();
            session.close();
        }
    }
}
