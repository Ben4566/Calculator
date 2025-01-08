package Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {

    private JFrame frame;
    private JTextField textField;
    private Logic Logic;
    private boolean isOperatorClicked = false;

    public GUI() {
        Logic = new Logic();

        // Create frame
        frame = new JFrame("Calculator");
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create text field
        textField = new JTextField();
        textField.setFont(new Font("Arial", Font.BOLD, 24));
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setEditable(false);
        frame.add(textField, BorderLayout.NORTH);

        // Create buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(8, 4, 10, 10));

        String[] buttonLabels = {
                "DEL", "CLEAR", "(", ")",
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+",
                "X^2", "X^n", "√", "n^√",
                "π", "ℇ", "!", "n/n",
                "sin", "tan", "cos", "ln"
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.BOLD, 20));
            button.addActionListener(new ButtonClickListener());
            buttonPanel.add(button);
        }

        frame.add(buttonPanel, BorderLayout.CENTER);

        // Make frame visible
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GUI::new);
    }

    private class ButtonClickListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if ("0123456789.".contains(command)) {
                if (isOperatorClicked) {
                    textField.setText("");
                    isOperatorClicked = false;
                }
                textField.setText(textField.getText() + command);
            } else if ("/*-+".contains(command)) {
                Logic.setNumber(Double.parseDouble(textField.getText()));
                Logic.setOperator(command);
                isOperatorClicked = true;
            } else if ("=".equals(command)) {
                try {
                    Logic.setNumber(Double.parseDouble(textField.getText()));
                    double result = Logic.calculate();
                    textField.setText(String.valueOf(result));
                } catch (ArithmeticException ex) {
                    JOptionPane.showMessageDialog(frame, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
                isOperatorClicked = true;
            }
        }
    }
}