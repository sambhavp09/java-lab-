import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class assignment18q2 extends JFrame implements ActionListener {

    JTextField initialBalance, transactionAmount, updatedBalance;
    JButton depositButton, withdrawButton;

    assignment18q2() {
        setTitle("Bank Balance Calculator");

        setLayout(new GridLayout(4, 2, 10, 10));

        add(new JLabel("Initial Balance:"));
        initialBalance = new JTextField();
        add(initialBalance);

        add(new JLabel("Transaction Amount:"));
        transactionAmount = new JTextField();
        add(transactionAmount);

        depositButton = new JButton("Deposit");
        withdrawButton = new JButton("Withdraw");

        add(depositButton);
        add(withdrawButton);

        add(new JLabel("Updated Balance:"));
        updatedBalance = new JTextField();
        updatedBalance.setEditable(false);
        add(updatedBalance);

        depositButton.addActionListener(this);
        withdrawButton.addActionListener(this);

        setSize(400, 220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            double balance = Double.parseDouble(initialBalance.getText());
            double amount = Double.parseDouble(transactionAmount.getText());

            if (e.getSource() == depositButton) {
                updatedBalance.setText(String.valueOf(balance + amount));
            } else if (e.getSource() == withdrawButton) {
                updatedBalance.setText(String.valueOf(balance - amount));
            }

        } catch (NumberFormatException ex) {
            updatedBalance.setText("Invalid Input");
        }
    }

    public static void main(String[] args) {
        new assignment18q2();
    }
}