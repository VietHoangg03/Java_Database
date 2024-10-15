package test;

import dao.UserDAO;
import model.User;

import java.util.ArrayList;

public class TestUser {
    public static void main(String[] args) {
//        User u1 = new User("u1","u123","UUU");
//        UserDAO.getInstance().insert(u1);
//        System.out.println("-----------------");

        User u_find = new User("x' or 1=1; -- ","","");
        System.out.println("------------------");

        User u_result = UserDAO.getInstance().selectById(u_find);
        System.out.println(u_result);
    }
}
