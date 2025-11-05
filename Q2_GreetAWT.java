

import java.awt.*;
import java.awt.event.*;

public class Q2_GreetAWT {
    public static void main(String[] args) {
        Frame frame = new Frame("AWT Greeting App");
        frame.setLayout(new FlowLayout());
        frame.setSize(350, 120);

        Label nameLabel = new Label("Enter your name:");
        TextField nameField = new TextField(20);
        Button greetButton = new Button("Click Me");


        greetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText().trim();
                if (name.isEmpty()) {
                    System.out.println("Hello, [No name entered]");
                } else {
                    System.out.println("Hello, " + name + "!");
                }
            }
        });

        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(greetButton);


        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                frame.dispose();
                System.exit(0);
            }
        });

        frame.setVisible(true);
    }
}
