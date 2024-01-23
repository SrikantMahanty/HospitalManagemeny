package HospitalManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class HospitalDriver {
    private static String url = "jdbc:mysql://localhost:3307/HOSPITAL";
    // Load the Driver

    public static void main(String[] args) {


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        Scanner scanner = new Scanner(System.in);

        // Create connection
        String url = "jdbc:mysql://localhost:3307/std";
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, "root", "$k8XU9VDz");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            if (con.isClosed()) {
                System.out.println("Connection is closed");
            } else {
                System.out.println("Connection is Created....");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}