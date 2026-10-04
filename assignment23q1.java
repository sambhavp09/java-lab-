import java.sql.*;

public class assignment23q1 {

    public static void main(String[] args) {

        String db = "jdbc:mysql://localhost:3306/college";
        String user = "root";
        String password = "Sambhav09@";

        try {
            Connection conn = DriverManager.getConnection(db, user, password);

            String query = "SELECT * FROM student";

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(query);

            System.out.println("Student Records:");
            System.out.println("-------------------------");

            while (rs.next()) {

                System.out.println("Student ID: " + rs.getInt("student_id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Course: " + rs.getString("course"));
                System.out.println("Marks: " + rs.getInt("marks"));

                System.out.println("-------------------------");
            }

            conn.close();

        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }
    }
}