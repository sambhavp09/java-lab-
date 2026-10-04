import java.sql.*;
import java.util.Scanner;

public class assignment22q2 {

    public static void main(String[] args) {

        String db = "jdbc:mysql://localhost:3306/college";
        String user = "root";
        String password = "Sambhav09@";

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Login ID: ");
        String loginId = sc.nextLine();

        System.out.print("Enter Password: ");
        String loginPassword = sc.nextLine();

        try {
            Connection conn = DriverManager.getConnection(db, user, password);

            String query = "SELECT role FROM hospital_staff WHERE login_id = ? AND password = ?";

            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, loginId);
            ps.setString(2, loginPassword);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                String role = rs.getString("role");

                System.out.println("Authentication successful!");
                System.out.println("Welcome, " + role + "!");
                System.out.println("Access granted.");

            } else {

                System.out.println("Authentication failed.");
                System.out.println("Invalid Login ID or Password.");
                System.out.println("Access denied.");

            }

            conn.close();

        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }

        sc.close();
    }
}