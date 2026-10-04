import java.sql.*;

public class assignment23q2 {

    public static void main(String[] args) {

        String db = "jdbc:mysql://localhost:3306/college";
        String user = "root";
        String password = "Sambhav09@";

        try {
            Connection conn = DriverManager.getConnection(db, user, password);

            String query = "SELECT * FROM employee";

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(query);

            System.out.println("Employee Records:");
            System.out.println("-------------------------");

            while (rs.next()) {

                System.out.println("Employee ID: " + rs.getInt("employee_id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Department: " + rs.getString("department"));
                System.out.println("Salary: " + rs.getDouble("salary"));

                System.out.println("-------------------------");
            }

            conn.close();

        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }
    }
}