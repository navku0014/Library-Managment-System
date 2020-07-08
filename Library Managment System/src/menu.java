
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
public class menu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int option;
        do {
            System.out.println("----------------------------------");
            System.out.println("1. ADD A BOOK");
            System.out.println("2. ADD A MEMBER");
            System.out.println("3. ISSUE A BOOK");
            System.out.println("4. RETURN A BOOK");
            System.out.println("0. TO EXIT");

            System.out.print("ENTER YOUR OPTION:");
            option = sc.nextInt();

            switch (option) {
                case 0:
                    break;
                case 1:
                    System.out.println("----------------------------------");
                    System.out.println("You have choose option 1");
                    Addbookmenu.addbookmenu();
                    break;
                case 2:
                    System.out.println("----------------------------------");
                    
                    System.out.println("2. ADD A MEMBER");
                    addmember.addmembermenu();
                    break;
                case 3:
                    System.out.println("----------------------------------");
                    System.out.println("3. ISSUE A BOOK");
                    libFunction.callIssueMenu();
                    break;
                case 4:
                    System.out.println("----------------------------------");
                    System.out.println("5. RETURN A BOOK");
                    libFunction.callReturnMenu();
                    break;
                default:
                    System.out.println("----------------------------------");
                    System.out.println("ENTER A VALID OPTION");
                    break;

            }

        } while (option != 0);
    }

}
