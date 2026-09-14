import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class assignment18q1 extends JFrame implements ActionListener {

    private JTextField display;
    private double firstNumber = 0;
    private String operation = "";
    private boolean newNumber = true;

    public assignment18q1() {

        setTitle("Calculator");
        setSize(350, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Display
        display = new JTextField();
        display.setFont(new Font("Arial", Font.BOLD, 28));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        // Button panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4, 5, 5));

        String[] buttons = {
            "7", "8", "9", "+",
            "4", "5", "6", "-",
            "1", "2", "3", "C",
            "0", ".", "=", ""
        };

        for (String text : buttons) {
            if (!text.equals("")) {
                JButton button = new JButton(text);
                button.setFont(new Font("Arial", Font.BOLD, 20));
                button.addActionListener(this);
                panel.add(button);
            } else {
                panel.add(new JLabel());
            }
        }

        add(panel, BorderLayout.CENTER);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        String command = e.getActionCommand();

        // Number buttons
        if (command.matches("[0-9]") || command.equals(".")) {

            if (newNumber) {
                display.setText(command);
                newNumber = false;
            } else {
                display.setText(display.getText() + command);
            }
        }

        // Addition or subtraction
        else if (command.equals("+") || command.equals("-")) {

            firstNumber = Double.parseDouble(display.getText());
            operation = command;
            newNumber = true;
        }

        // Calculate result
        else if (command.equals("=")) {

            double secondNumber = Double.parseDouble(display.getText());
            double result = 0;

            if (operation.equals("+")) {
                result = firstNumber + secondNumber;
            } else if (operation.equals("-")) {
                result = firstNumber - secondNumber;
            }

            display.setText(String.valueOf(result));
            newNumber = true;
        }

        // Clear button
        else if (command.equals("C")) {
            display.setText("");
            firstNumber = 0;
            operation = "";
            newNumber = true;
        }
    }

    public static void main(String[] args) {
        new assignment18q1();
    }
}