import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class assignment24q2 extends JFrame implements ActionListener {

    JTextField bookIdField, studentField, issueDateField, returnDateField;
    JButton addButton, displayButton;

    String db = "jdbc:mysql://localhost:3306/college";
    String user = "root";
    String password = "Sambhav09@";

    assignment24q2() {

        setTitle("Book Issue Tracking System");
        setSize(500, 300);
        setLayout(new GridLayout(5, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        add(new JLabel("Book ID:"));
        bookIdField = new JTextField();
        add(bookIdField);

        add(new JLabel("Student Name:"));
        studentField = new JTextField();
        add(studentField);

        add(new JLabel("Issue Date (YYYY-MM-DD):"));
        issueDateField = new JTextField();
        add(issueDateField);

        add(new JLabel("Return Date (YYYY-MM-DD):"));
        returnDateField = new JTextField();
        add(returnDateField);

        addButton = new JButton("Issue Book");
        displayButton = new JButton("Display Records");

        add(addButton);
        add(displayButton);

        addButton.addActionListener(this);
        displayButton.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == addButton) {

            try {
                Connection conn = DriverManager.getConnection(db, user, password);

                String query = "INSERT INTO book_issue VALUES (?, ?, ?, ?)";

                PreparedStatement ps = conn.prepareStatement(query);

                ps.setInt(1, Integer.parseInt(bookIdField.getText()));
                ps.setString(2, studentField.getText());
                ps.setDate(3, Date.valueOf(issueDateField.getText()));
                ps.setDate(4, Date.valueOf(returnDateField.getText()));

                ps.executeUpdate();

                JOptionPane.showMessageDialog(this,
                        "Book issue record added successfully!");

                conn.close();

            } catch (SQLException | IllegalArgumentException ex) {

                JOptionPane.showMessageDialog(this,
                        "Error: " + ex.getMessage());
            }

        } else if (e.getSource() == displayButton) {

            try {
                Connection conn = DriverManager.getConnection(db, user, password);

                Statement stmt = conn.createStatement();

                ResultSet rs = stmt.executeQuery(
                        "SELECT * FROM book_issue");

                StringBuilder records = new StringBuilder();

                while (rs.next()) {

                    records.append("Book ID: ")
                           .append(rs.getInt("book_id"))
                           .append("\n");

                    records.append("Student Name: ")
                           .append(rs.getString("student_name"))
                           .append("\n");

                    records.append("Issue Date: ")
                           .append(rs.getDate("issue_date"))
                           .append("\n");

                    records.append("Return Date: ")
                           .append(rs.getDate("return_date"))
                           .append("\n");

                    records.append("-------------------------\n");
                }

                if (records.length() == 0) {
                    records.append("No issue records found.");
                }

                JOptionPane.showMessageDialog(this,
                        records.toString(),
                        "Book Issue Records",
                        JOptionPane.INFORMATION_MESSAGE);

                conn.close();

            } catch (SQLException ex) {

                JOptionPane.showMessageDialog(this,
                        "Database Error: " + ex.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new assignment24q2();
    }
}