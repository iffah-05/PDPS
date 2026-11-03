import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class EdibleApp extends JFrame {

    JTextArea output;
    JButton showButton, clearButton;

    public EdibleApp() {

        setTitle("Edible Application");
        setSize(550, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        JLabel title = new JLabel("EDIBLE APPLICATION", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));

        add(title, BorderLayout.NORTH);

        output = new JTextArea();
        output.setFont(new Font("Arial", Font.PLAIN, 16));
        output.setEditable(false);

        JScrollPane scroll = new JScrollPane(output);
        add(scroll, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();

        showButton = new JButton("Show Result");
        clearButton = new JButton("Clear");

        buttonPanel.add(showButton);
        buttonPanel.add(clearButton);

        add(buttonPanel, BorderLayout.SOUTH);

        showButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                output.setText("");

                Edible[] objects = {
                    new Animal("Chicken"),
                    new Apple("Red Apple"),
                    new Orange("Navel Orange")
                };

                Person p1 = new Person("Ali");
                Person p2 = new Person("Sarah");

                for (int i = 0; i < objects.length; i++) {

                    if (objects[i] instanceof Animal) {
                        output.append(p1.eating(objects[i]) + "\n\n");
                    } else {
                        output.append(p2.eating(objects[i]) + "\n\n");
                    }
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

        EdibleApp app = new EdibleApp();
        app.setVisible(true);

    }
}
