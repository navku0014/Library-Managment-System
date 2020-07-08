/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Naveen Sheoran
 */
;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;



public class libFunction {

    public static void callIssueMenu() {
        System.out.println("Reached inside Issue Book menu");
        Scanner sc = new Scanner(System.in);
        member m = new member();
        Book b = new Book();
        int addstatus = 0;

        while (addstatus == 0) {
            try {
                System.out.println("Enter the Member Id:");
                m.setMemberid(Integer.parseInt(sc.nextLine().toString()));
                System.out.println("Enter the Isbn COde:");
                b.setIsbncode(Integer.parseInt(sc.nextLine().toString()));
                IssueBook(m, b);
                addstatus = 1;
            } catch (NumberFormatException e) {
                addstatus = 0;
            }
        }
    }

    public static void IssueBook(member m, Book b) {
        System.out.println("Reached inside Book Issue ");

        try {
            long millis = System.currentTimeMillis();
            java.sql.Date date = new java.sql.Date(millis);

            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/library";
            String username = "root";
            String password = "root";
            Connection con = DriverManager.getConnection(url, username, password);
            String sql = "select m.member_id,b.isbn_code,mbr.rec_id from member m, books b,record mbr\n"
                    + " where m.member_id = " + m.getMemberid() + "\n"
                    + " and b.isbn_code = " + b.getIsbncode() + "\n"
                    + "and m.member_id = mbr.member_id\n"
                    + "and b.isbn_code = mbr.isbn_code and mbr.dor is null";
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("Already issued");
                Integer memberId = rs.getInt(2);
                Integer isbnCode = rs.getInt(2);
                Integer recId = rs.getInt(2);
                System.out.println("Values are::"+memberId+"::"+isbnCode+"::"+recId+"::");

            } else {
                String q = "insert into record(member_id,isbn_code,doi) values(?,?,?) ";
                PreparedStatement pst = con.prepareStatement(q);
                pst.setInt(1, m.getMemberid());
                pst.setInt(2, b.getIsbncode());
                pst.setDate(3, date);
                int k = pst.executeUpdate();
                if (k > 0) {
                    String p = "update books set unit_available=(unit_available-1)\n"
                            + "where isbn_code =" + b.getIsbncode() + "";
                    PreparedStatement pts = con.prepareStatement(p);
                    k = pts.executeUpdate();
                    if (k > 0) {
                        System.out.println("Book is Issued");
                    } else {
                        System.out.println("book is Already issued");
                    }
                }

            }
            System.out.println("inserted..");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void callReturnMenu() {
        System.out.println("Reached inside Return Book menu");
        Scanner sc = new Scanner(System.in);
        member m = new member();
        Book b = new Book();
        int addstatus = 0;

        while (addstatus == 0) {
            try {
                System.out.println("Enter the Member Id:");
                m.setMemberid(Integer.parseInt(sc.nextLine().toString()));
                System.out.println("Enter the Isbn COde:");
                b.setIsbncode(Integer.parseInt(sc.nextLine().toString()));
                ReturnBook(m, b);
                addstatus = 1;
            } catch (NumberFormatException e) {
                addstatus = 0;
            }
        }
    }

    public static void ReturnBook(member m, Book b) {
        System.out.println("Reached inside Book Return");

        try {
            long millis = System.currentTimeMillis();
            java.sql.Date date = new java.sql.Date(millis);

            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/library";
            String username = "root";
            String password = "root";
            Connection con = DriverManager.getConnection(url, username, password);
            String sql = "select m.member_id,b.isbn_code,mbr.rec_id from member m, books b,record mbr\n"
                    + " where m.member_id = " + m.getMemberid() + "\n"
                    + " and b.isbn_code = " + b.getIsbncode() + "\n"
                    + "and m.member_id = mbr.member_id\n"
                    + "and b.isbn_code = mbr.isbn_code and mbr.dor is null";
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("Process to Return the book");
                String q = "insert into record(member_id,isbn_code,dor) values(?,?,?) ";
                PreparedStatement pst = con.prepareStatement(q);
                pst.setInt(1, m.getMemberid());
                pst.setInt(2, b.getIsbncode());
                pst.setDate(3, date);
                int k = pst.executeUpdate();
                if (k > 0) {
                    String p = "update books set unit_available=(unit_available+1)\n"
                            + "where isbn_code =" + b.getIsbncode() + "";
                    PreparedStatement pts = con.prepareStatement(p);
                    k = pts.executeUpdate();
                    if (k > 0) {
                        System.out.println("Book is Returned");
                    } else {
                        System.out.println("else");
                    }
                }
            } else {
                

            }
            System.out.println("inserted..");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
