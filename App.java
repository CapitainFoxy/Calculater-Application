import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorApp extends JFrame implements ActionListener {
    private JTextField inputField;
    private double num1, num2, result;
    private char operator;

    public CalculatorApp() {
        setTitle("Calculator");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        inputField = new JTextField();
        inputField.setEditable(false);
        inputField.setHorizontalAlignment(SwingConstants.RIGHT);
        add(inputField, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));

        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            panel.add(button);
            button.addActionListener(this);
        }

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.charAt(0) >= '0' && command.charAt(0) <= '9' || command.equals(".")) {
            inputField.setText(inputField.getText() + command);
        } else if (command.charAt(0) == '=') {
            num2 = Double.parseDouble(inputField.getText());
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
            inputField.setText(String.valueOf(result));
        } else {
            if (!inputField.getText().isEmpty()) {
                num1 = Double.parseDouble(inputField.getText());
                operator = command.charAt(0);
                inputField.setText("");
            }
        }
    }

    public static void main(String[] args) {
        new CalculatorApp();
    }
}
