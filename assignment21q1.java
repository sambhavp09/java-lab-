import java.sql.*;

public class assignment21q1 {

    public static void main(String[] args) {

        String db = "jdbc:mysql://localhost:3306/college";
        String user = "root";
        String password = "Sambhav09@";

        try {
            Connection conn = DriverManager.getConnection(db, user, password);

            System.out.println("Connected to the database successfully!");

            conn.close();

        } catch (SQLException e) {
            System.out.println("Database connection failed.");
            System.out.println("Error: " + e.getMessage());
        }
    }
}