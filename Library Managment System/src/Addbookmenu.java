
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Naveen Sheoran
 */
public class Addbookmenu {

    public static void addbookmenu() {
        System.out.println("Reached Add Book Menu");
        Book b = new Book();
        Scanner sc = new Scanner(System.in);
        int addstatus = 0;

        while (addstatus == 0) {
            try {
                System.out.println("Enter the Isbn code:");
                b.setIsbncode(Integer.parseInt(sc.nextLine().toString()));
                System.out.println("Enter the Book Name:");
                b.setBookname(sc.nextLine().toString());
                System.out.println("Enter the Book Description:");
                b.setBookdesc(sc.nextLine().toString());
                System.out.println("Enter the Author Name:");
                b.setAuthorname(sc.nextLine().toString());
                System.out.println("Enter the Unit available:");
                b.setUnit(Integer.parseInt(sc.nextLine().toString()));

                addbook(b);
                addstatus = 1;
            } catch (NumberFormatException e) {
                addstatus = 0;
            }
        }
    }

    public static void addbook(Book b) {
        System.out.println("Reached inside addBook for book");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/library";
            String username = "root";
            String password = "root";
            Connection con = DriverManager.getConnection(url, username, password);
            String sql = "insert into books(isbn_code,book_name,book_desc,author_name,unit_available) values(?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, b.getIsbncode());
            ps.setString(2, b.getBookname());
            ps.setString(3, b.getBookdesc());
            ps.setString(4, b.getAuthorname());
            ps.setInt(5, b.getUnit());
            ps.executeUpdate();
            System.out.println("inserted..");
            con.close();
        }catch(Exception e){
            e.printStackTrace();
    }
    }
}
