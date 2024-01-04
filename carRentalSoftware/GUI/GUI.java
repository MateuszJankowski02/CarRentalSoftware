package GUI;

import authentication.LoginAuthenticator;
import resources.User;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {

    CardLayout cardLayout = new CardLayout();

    public GUI(User.Users users) {

        super("Car Rental Software");

        JPanel cardPanel = new JPanel(cardLayout);

        JPanel loginPanel = new JPanel(new GridBagLayout());
        cardPanel.add(loginPanel, "loginPanel");

        JPanel testPanel = new JPanel(new GridBagLayout());
        cardPanel.add(testPanel, "testPanel");

        // Create labels
        JLabel loginLabel = new JLabel("Login:");
        JLabel passwordLabel = new JLabel("Password:");

        // Create a button
        JButton loginButton = new JButton("Login");
        loginButton.setPreferredSize(new Dimension(100, 40));

        // Create text fields
        JTextField loginField = new JTextField();
        loginField.setPreferredSize(new Dimension(200, 40));
        JTextField passwordField = new JTextField();
        passwordField.setPreferredSize(new Dimension(200, 40));


        // Add action listener to button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginAuthenticator loginAuthenticator = new LoginAuthenticator();
                loginAuthenticator.selectBaseOfUsers(users.getUsers());
                if(loginAuthenticator.authenticate(loginField.getText(), passwordField.getText())){
                    cardLayout.show(cardPanel, "testPanel");
                }
            }
        });


        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        labelInset(constraints);
        loginPanel.add(loginLabel, constraints);

        defaultInset(constraints);
        constraints.gridy++;
        loginPanel.add(loginField, constraints);

        labelInset(constraints);
        constraints.gridy++;
        loginPanel.add(passwordLabel, constraints);

        defaultInset(constraints);
        constraints.gridy++;
        loginPanel.add(passwordField, constraints);

        constraints.gridy++;
        loginPanel.add(loginButton, constraints);

        loginPanel.setBorder(new EmptyBorder(80, 80, 80, 80));

        setContentPane(cardPanel);
        setSize(1080, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void labelInset (GridBagConstraints constraints){
        constraints.insets = new Insets(10, 30, 0, 30);
    }

    public void defaultInset (GridBagConstraints constraints){
        constraints.insets = new Insets(10, 30, 30, 30);
    }

}
