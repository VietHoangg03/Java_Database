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

//            DonHang dh1 = new DonHang();
//            dh1.setTenKhachHang("Hoàng Đinh");
//            dh1.setNgayMua(new Date(System.currentTimeMillis()));
//
//            for (int i = 0; i < 10000; i++) {
//                ChiTietDonHang chiTietDonHang1 = new ChiTietDonHang();
//                chiTietDonHang1.setTenSanPham("Mì hảo hảo");
//                chiTietDonHang1.setSoLuong(5);
//                chiTietDonHang1.setGiaBan(5000);
//                chiTietDonHang1.setThanhTien(5*5000);
//                chiTietDonHang1.setDonHang(dh1);
//                dh1.addCTDH(chiTietDonHang1);
//            }


           // session.saveOrUpdate(dh1);

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

            long batDau = System.currentTimeMillis();
            DonHang dh = session.load(DonHang.class, 1);
            long ketThuc = System.currentTimeMillis();
            System.out.println(dh.toString());
            System.out.println("Thời gian thực hiện câu lệnh là: " +(ketThuc-batDau));

            // fetch = FetchType.EAGER
            // Có 2 kiểu load dữ liệu là EAGER và LAZY
            // LAZY: load thẳng đối tượng cần trong bảng
            // EAGER: Load đối tượng load luôn những thứ phụ thuộc vào nó
            // => EAGER: chậm hơn LAZY khi cần load dữ liệu ngay
            // EAGER load hết dữ liệu lên bộ nhớ động khi cần dử dụng sẽ nhanh hơn,
            // Nhưng khi dữ liệu quá lớn thì không thể hiển thị được nhanh, do đó
            // Cần Lazy để load từng phần dữ liêu trong data

            transaction.commit();
            session.close();
        }
    }
}
