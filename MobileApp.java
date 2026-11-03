import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class MobileApp extends JFrame {

    JTextArea output;
    JButton showButton, clearButton;

    public MobileApp() {

        setTitle("Mobile Radio Application");
        setSize(550, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        JLabel title = new JLabel("MOBILE RADIO APPLICATION", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 22));

        add(title, BorderLayout.NORTH);

        output = new JTextArea();
        output.setFont(new Font("Arial", Font.PLAIN, 15));
        output.setEditable(false);

        JScrollPane scroll = new JScrollPane(output);
        add(scroll, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();

        showButton = new JButton("Show Details");
        clearButton = new JButton("Clear");

        buttonPanel.add(showButton);
        buttonPanel.add(clearButton);

        add(buttonPanel, BorderLayout.SOUTH);

        showButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                output.setText("");

                MobileDevice m1 = new SmartPhone("Samsung", "S20", "Galaxy");
                MobileDevice m2 = new BasicPhone("Sony Ericsson", "Walkman");

                m1.setStation("Hot FM");
                m1.setFrequency(97.60);

                m2.setStation("Fly FM");
                m2.setFrequency(109.8);

                output.append("SMART PHONE DETAIL:\n");
                output.append("------------------------------\n");
                output.append("Manufacturer: Samsung\n");
                output.append("Model: S20\n");
                output.append("Type: Galaxy\n");
                output.append("Station: " + m1.station + "\n");
                output.append("Frequency: " + m1.frequency + "\n\n");

                output.append("BASIC PHONE DETAIL:\n");
                output.append("------------------------------\n");
                output.append("Manufacturer: Sony Ericsson\n");
                output.append("Model: Walkman\n");
                output.append("Station: " + m2.station + "\n");
                output.append("Frequency: " + m2.frequency + "\n");
            }
        });

        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                output.setText("");
            }
        });
    }

    public static void main(String[] args) {

        MobileApp app = new MobileApp();
        app.setVisible(true);

    }
}
