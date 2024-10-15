package test;

import dao.SachDAO;
import model.Sach;

import java.util.ArrayList;

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
        //Sach sach2 = new Sach("LTC","Học lập trình C",10000,2000);
        //SachDAO.getInstance().update(sach2);

        // Test delete
        //for (int i = 3; i<1000;i++) {
          //  Sach sach = new Sach("LT" + i,"Lập trình JAVA PART: " +i,20000,2025);
            //SachDAO.getInstance().delete(sach);
        //}

        ArrayList<Sach> sachlist = SachDAO.getInstance().selectAll();
        for (Sach sach : sachlist) {
            System.out.println(sach.toString());
        }
        System.out.println("---------------------------");

        Sach find = new Sach();
        find.setId("LTC");
        Sach sach2 = SachDAO.getInstance().selectById(find);
        System.out.println(sach2.toString());
        System.out.println("---------------------------");

        ArrayList<Sach> sachlist2 = SachDAO.getInstance().selectByCondition("giaBan<20000");
        for (Sach sach : sachlist2) {
            System.out.println(sach.toString());
        }
    }
}
