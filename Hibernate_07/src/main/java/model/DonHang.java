package model;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
public class DonHang {
    @Id
    @GeneratedValue
    private int id;
    private String tenKhachHang;
    private Date ngayMua;

    @OneToMany(mappedBy = "donHang", cascade = CascadeType.ALL)
    private List<ChiTietDonHang> danhSachChiTiet = new ArrayList<ChiTietDonHang>();

    public DonHang() {
    }

    public DonHang(int id, String tenKhachHang, Date ngayMua, List<ChiTietDonHang> chiTietDonHang) {
        this.id = id;
        this.tenKhachHang = tenKhachHang;
        this.ngayMua = ngayMua;
        this.danhSachChiTiet = chiTietDonHang;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public Date getNgayMua() {
        return ngayMua;
    }

    public void setNgayMua(Date ngayMua) {
        this.ngayMua = ngayMua;
    }

    public List<ChiTietDonHang> getChiTietDonHang() {
        return danhSachChiTiet;
    }

    public void setChiTietDonHang(List<ChiTietDonHang> danhSachChiTiet) {
        this.danhSachChiTiet = danhSachChiTiet;
    }

    public  void addCTDH (ChiTietDonHang chiTietDonHang){
        this.danhSachChiTiet.add(chiTietDonHang);
    }
}
