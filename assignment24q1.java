import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class assignment24q1 extends JFrame implements ActionListener {

    JTextField idField, nameField, authorField, priceField;
    JButton addButton, displayButton;

    String db = "jdbc:mysql://localhost:3306/college";
    String user = "root";
    String password = "Sambhav09@";

    assignment24q1() {

        setTitle("Library Management System");
        setSize(450, 300);
        setLayout(new GridLayout(5, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        add(new JLabel("Book ID:"));
        idField = new JTextField();
        add(idField);

        add(new JLabel("Book Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Author:"));
        authorField = new JTextField();
        add(authorField);

        add(new JLabel("Price:"));
        priceField = new JTextField();
        add(priceField);

        addButton = new JButton("Add Book");
        displayButton = new JButton("Display Books");

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

                String query = "INSERT INTO library VALUES (?, ?, ?, ?)";

                PreparedStatement ps = conn.prepareStatement(query);

                ps.setInt(1, Integer.parseInt(idField.getText()));
                ps.setString(2, nameField.getText());
                ps.setString(3, authorField.getText());
                ps.setDouble(4, Double.parseDouble(priceField.getText()));

                ps.executeUpdate();

                JOptionPane.showMessageDialog(this,
                        "Book added successfully!");

                conn.close();

            } catch (SQLException | NumberFormatException ex) {

                JOptionPane.showMessageDialog(this,
                        "Error: " + ex.getMessage());
            }

        } else if (e.getSource() == displayButton) {

            try {
                Connection conn = DriverManager.getConnection(db, user, password);

                Statement stmt = conn.createStatement();

                ResultSet rs = stmt.executeQuery("SELECT * FROM library");

                StringBuilder books = new StringBuilder();

                while (rs.next()) {

                    books.append("Book ID: ")
                         .append(rs.getInt("book_id"))
                         .append("\n");

                    books.append("Book Name: ")
                         .append(rs.getString("book_name"))
                         .append("\n");

                    books.append("Author: ")
                         .append(rs.getString("author"))
                         .append("\n");

                    books.append("Price: ")
                         .append(rs.getDouble("price"))
                         .append("\n");

                    books.append("-------------------------\n");
                }

                if (books.length() == 0) {
                    books.append("No books found.");
                }

                JOptionPane.showMessageDialog(this,
                        books.toString(),
                        "Library Books",
                        JOptionPane.INFORMATION_MESSAGE);

                conn.close();

            } catch (SQLException ex) {

                JOptionPane.showMessageDialog(this,
                        "Database Error: " + ex.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new assignment24q1();
    }
}