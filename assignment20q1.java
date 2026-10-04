import java.sql.*;
import java.util.Scanner;

public class assignment20q1 {

    static String db = "jdbc:mysql://localhost:3306/college";
    static String user = "root";
    static String password = "Sambhav09@";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            Connection conn = DriverManager.getConnection(db, user, password);

            // CREATE
            System.out.print("Enter Employee ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Employee Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Department: ");
            String department = sc.nextLine();

            System.out.print("Enter Salary: ");
            double salary = sc.nextDouble();

            String insert = "INSERT INTO employee VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(insert);

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, department);
            ps.setDouble(4, salary);

            ps.executeUpdate();

            System.out.println("Employee record inserted.");

            // READ
            System.out.println("\nEmployee Records:");

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM employee");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("employee_id") + " | " +
                    rs.getString("name") + " | " +
                    rs.getString("department") + " | " +
                    rs.getDouble("salary")
                );
            }

            // UPDATE
            System.out.print("\nEnter Employee ID to update salary: ");
            int updateId = sc.nextInt();

            System.out.print("Enter new salary: ");
            double newSalary = sc.nextDouble();

            String update = "UPDATE employee SET salary = ? WHERE employee_id = ?";
            ps = conn.prepareStatement(update);

            ps.setDouble(1, newSalary);
            ps.setInt(2, updateId);

            ps.executeUpdate();

            System.out.println("Employee record updated.");

            // DELETE
            System.out.print("\nEnter Employee ID to delete: ");
            int deleteId = sc.nextInt();

            String delete = "DELETE FROM employee WHERE employee_id = ?";
            ps = conn.prepareStatement(delete);

            ps.setInt(1, deleteId);

            ps.executeUpdate();

            System.out.println("Employee record deleted.");

            conn.close();

        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }

        sc.close();
    }
}