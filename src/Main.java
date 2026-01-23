// ======================= Main.java =======================

import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;




public class Main{
    static Scanner input = new Scanner(System.in);

    static void register() {


        System.out.print("Name: ");
        String name = input.next();

        System.out.print("Email: ");
        String email = input.next();

        System.out.print("Password: ");
        String password = input.next();

        System.out.print("Age: ");
        int age = input.nextInt();

        String role;

        if (age < 18) {
            role = "CHILD";
        } else {
            System.out.println("Choose role:");
            System.out.println("1. Adult");
            System.out.println("2. Student");
            System.out.println("3. Pensioner");
            System.out.println("4. VIP");

            int choice = input.nextInt();

            role = switch (choice) {
                case 2 -> "STUDENT";
                case 3 -> "PENSIONER";
                case 4 -> "VIP";
                default -> "ADULT";
            };
        }

        DB.registerUser(name, password, email, age, role);

    }


    static void login() {
        System.out.print("Email: ");
        String email = input.next();

        System.out.print("Password: ");
        String password = input.next();

        Viewer viewer = DB.login(email, password);

        if (viewer == null) {
            System.out.println("Wrong email or password");
            return;
        }

        menu(viewer);
    }

    static void menu(Viewer viewer) {

        while (true) {
            System.out.println("\n=== USER MENU ===");
            System.out.println("1. View cinemas and movies");
            System.out.println("2. Buy ticket");
            System.out.println("0. Logout");

            int choice = input.nextInt();

            switch (choice) {
                case 1 -> Cinema.showMovies();
                case 2 -> Cinema.buyTicket(viewer);
                case 0 -> {
                    System.out.println("Logout...");
                    return;
                }
                default -> System.out.println("Wrong choice");
            }
        }
    }

    public static void main(String[] args) {
        Main app = new Main();
        while (true) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("0. Exit");

            int choice = input.nextInt();

            switch (choice) {
                case 1 -> app.register();
                case 2 -> app.login();
                case 0 -> System.exit(0);
                default -> System.out.println("Wrong choice");
            }
        }
    }
}
