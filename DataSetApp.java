import java.text.DecimalFormat;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class DataSetApp extends JFrame {

    JTextArea output;
    JButton calculateButton, clearButton;

    public DataSetApp() {

        setTitle("DataSet Application");
        setSize(600, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        JLabel title = new JLabel("DATASET APPLICATION", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));

        add(title, BorderLayout.NORTH);

        output = new JTextArea();
        output.setFont(new Font("Arial", Font.PLAIN, 14));
        output.setEditable(false);

        JScrollPane scroll = new JScrollPane(output);
        add(scroll, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();

        calculateButton = new JButton("Calculate");
        clearButton = new JButton("Clear");

        buttonPanel.add(calculateButton);
        buttonPanel.add(clearButton);

        add(buttonPanel, BorderLayout.SOUTH);

        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                DecimalFormat df = new DecimalFormat("0.00");

                output.setText("");

                // BANK ACCOUNT
                DataSet bankData = new DataSet();

                bankData.add(new BankAccount(0));
                bankData.add(new BankAccount(10000));
                bankData.add(new BankAccount(2000));

                output.append("BANK ACCOUNT\n");
                output.append("------------------------------\n");
                output.append("Average Balance: "
                        + df.format(bankData.getAverage()) + "\n");
                output.append("Highest Balance: "
                        + df.format(bankData.getMax().getMeasure()) + "\n\n");

                // COIN
                DataSet coinData = new DataSet();

                coinData.add(new Coin(0.25, "Quarter"));
                coinData.add(new Coin(0.1, "Dime"));
                coinData.add(new Coin(0.05, "Nickel"));

                output.append("COIN\n");
                output.append("------------------------------\n");
                output.append("Average Coin Value: "
                        + df.format(coinData.getAverage()) + "\n");
                output.append("Highest Coin Value: "
                        + df.format(coinData.getMax().getMeasure()) + "\n");
                output.append("Highest Coin Name: "
                        + coinData.getMax().getName() + "\n\n");

                // STUDENT
                DataSet studentData = new DataSet();

                studentData.add(new Student("Ali", 157.50));
                studentData.add(new Student("Alex", 165.00));
                studentData.add(new Student("Maria", 147.00));

                output.append("STUDENT\n");
                output.append("------------------------------\n");
                output.append("Average Height: "
                        + df.format(studentData.getAverage()) + "\n");
                output.append("Tallest Height: "
                        + df.format(studentData.getMax().getMeasure()) + "\n");
                output.append("Tallest Student: "
                        + studentData.getMax().getName() + "\n");
            }
        });

        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                output.setText("");
            }
        });
    }

    public static void main(String[] args) {

        DataSetApp app = new DataSetApp();
        app.setVisible(true);

    }
}
