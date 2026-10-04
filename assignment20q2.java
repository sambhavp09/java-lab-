import java.sql.*;
import java.util.Scanner;

public class assignment20q2 {

    static String db = "jdbc:mysql://localhost:3306/college";
    static String user = "root";
    static String password = "Sambhav09@";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            Connection conn = DriverManager.getConnection(db, user, password);

            
            System.out.print("Enter Roll Number: ");
            int rollNo = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Student Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Course: ");
            String course = sc.nextLine();

            System.out.print("Enter Marks: ");
            int marks = sc.nextInt();

            String insert = "INSERT INTO student VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(insert);

            ps.setInt(1, rollNo);
            ps.setString(2, name);
            ps.setString(3, course);
            ps.setInt(4, marks);

            ps.executeUpdate();

            System.out.println("Student record inserted.");

            // READ
            System.out.println("\nStudent Records:");

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM student");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("roll_no") + " | " +
                    rs.getString("name") + " | " +
                    rs.getString("course") + " | " +
                    rs.getInt("marks")
                );
            }

            // UPDATE
            System.out.print("\nEnter Roll Number to update marks: ");
            int updateRoll = sc.nextInt();

            System.out.print("Enter new marks: ");
            int newMarks = sc.nextInt();

            String update = "UPDATE student SET marks = ? WHERE roll_no = ?";
            ps = conn.prepareStatement(update);

            ps.setInt(1, newMarks);
            ps.setInt(2, updateRoll);

            ps.executeUpdate();

            System.out.println("Student record updated.");

            // DELETE
            System.out.print("\nEnter Roll Number to delete: ");
            int deleteRoll = sc.nextInt();

            String delete = "DELETE FROM student WHERE roll_no = ?";
            ps = conn.prepareStatement(delete);

            ps.setInt(1, deleteRoll);

            ps.executeUpdate();

            System.out.println("Student record deleted.");

            conn.close();

        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }

        sc.close();
    }
}