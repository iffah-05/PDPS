import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class PriceApp extends JFrame {

    JTextArea output;
    JButton checkButton, clearButton;

    public PriceApp() {

        setTitle("Product and Price Application");
        setSize(650, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        JLabel title = new JLabel("PRODUCT & PRICE APPLICATION", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 22));

        add(title, BorderLayout.NORTH);

        output = new JTextArea();
        output.setFont(new Font("Arial", Font.PLAIN, 14));
        output.setEditable(false);

        JScrollPane scroll = new JScrollPane(output);
        add(scroll, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();

        checkButton = new JButton("Check Price");
        clearButton = new JButton("Clear");

        buttonPanel.add(checkButton);
        buttonPanel.add(clearButton);

        add(buttonPanel, BorderLayout.SOUTH);

        checkButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                output.setText("");

                SmartPhone sp = new SmartPhone(
                    "SmartPhone", "Iphone 14 ProMax", 5500.00);

                Laptop lp = new Laptop(
                    "Laptop", "Lenovo Yoga", 6000.00);

                Car c = new Car("BMW", 200000.0);

                Customer c1 = new Customer("Sally", 3000.00);
                Customer c2 = new Customer("Aaron", 8000.00);
                Customer c3 = new Customer("Simon", 10000.00);

                output.append("SMARTPHONE\n");
                output.append("------------------------------\n");
                output.append(sp.toString() + "\n");
                output.append("Customer: " + c1.getName() + "\n");
                output.append("Salary: RM" + c1.getSalary() + "\n");

                if (c1.getSalary() > 4000.0) {
                    output.append("Status: Can buy this product.\n\n");
                } else {
                    output.append("Status: Cannot buy this product.\n\n");
                }

                output.append("LAPTOP\n");
                output.append("------------------------------\n");
                output.append(lp.toString() + "\n");
                output.append("Customer: " + c2.getName() + "\n");
                output.append("Salary: RM" + c2.getSalary() + "\n");

                if (c2.getSalary() > 4000.0) {
                    output.append("Status: Can buy this product.\n\n");
                } else {
                    output.append("Status: Cannot buy this product.\n\n");
                }

                output.append("CAR\n");
                output.append("------------------------------\n");
                output.append(c.toString() + "\n");
                output.append("Customer: " + c3.getName() + "\n");
                output.append("Salary: RM" + c3.getSalary() + "\n");

                if (c3.getSalary() > 8000.0) {
                    output.append("Status: Can buy this car.\n");
                } else {
                    output.append("Status: Cannot buy this car.\n");
                }
            }
        });

        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                output.setText("");
            }
        });
    }

    public static void main(String[] args) {

        PriceApp app = new PriceApp();
        app.setVisible(true);

    }
}
