package test;

import dao.SachDAO;
import model.Sach;

public class TestSachDAO {
    public static void main(String[] args) {
        // Test insert
        /*
        Sach sach1 = new Sach("LTJV","Lập trình JAVA",5000,2025);
        Sach sach2 = new Sach("LTC","Lập trình C",6000,2023);

        SachDAO.getInstance().insert(sach2);


        for (int i = 3; i < 1000;i++) {
            Sach sach = new Sach("LT" + i,"Lập trình JAVA PART: " +i,20000,2025);
            SachDAO.getInstance().insert(sach);
        }
        */

        // Test Update
        Sach sach2 = new Sach("LTC","Học lập trình C",10000,2000);
        SachDAO.getInstance().update(sach2);

        // Test delete
        for (int i = 3; i<1000;i++) {
            Sach sach = new Sach("LT" + i,"Lập trình JAVA PART: " +i,20000,2025);
            SachDAO.getInstance().delete(sach);
        }
    }
}
