
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.sql.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Naveen Sheoran
 */
public class addmember {

    public static void addmembermenu() {
        System.out.println("Reached Add Member Menu");
        member m = new member();
        Scanner sc = new Scanner(System.in);
        int addstatus = 0;

        while (addstatus == 0) {
            try {
                System.out.println("Enter the Member Id:");
                m.setMemberid(Integer.parseInt(sc.nextLine().toString()));
                System.out.println("Enter the Member Name:");
                m.setMembername(sc.nextLine().toString());

                addMember(m);
                addstatus = 1;
            } catch (NumberFormatException e) {
                addstatus = 0;
            }
        }
    }

    public static void addMember(member m) {
        System.out.println("Reached inside addMembr for Member");
        try {
            long millis = System.currentTimeMillis();
            java.sql.Date date = new java.sql.Date(millis);

            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/library";
            String username = "root";
            String password = "root";
            Connection con = DriverManager.getConnection(url, username, password);
            String sql = "insert into member(member_id,member_name,doj) values(?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, m.getMemberid());
            ps.setString(2, m.getMembername());
            ps.setDate(3, date);

            ps.executeUpdate();
            System.out.println("inserted..");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
