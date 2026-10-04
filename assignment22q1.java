import java.sql.*;
import java.util.Scanner;

public class assignment22q1 {

    public static void main(String[] args) {

        String db = "jdbc:mysql://localhost:3306/college";
        String user = "root";
        String password = "Sambhav09@";

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Username: ");
        String username = sc.nextLine();

        System.out.print("Enter Password: ");
        String loginPassword = sc.nextLine();

        try {
            Connection conn = DriverManager.getConnection(db, user, password);

            String query = "SELECT * FROM login WHERE username = ? AND password = ?";

            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, username);
            ps.setString(2, loginPassword);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Login successful!");
                System.out.println("Welcome, " + username);
            } else {
                System.out.println("Invalid username or password.");
            }

            conn.close();

        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }

        sc.close();
    }
}