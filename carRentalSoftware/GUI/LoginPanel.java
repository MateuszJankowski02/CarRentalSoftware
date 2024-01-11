package GUI;

import resources.User;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class LoginPanel extends JPanel{

    JButton loginButton;
    JTextField loginField;
    JTextField passwordField;

    public LoginPanel() {

        // Create labels
        JLabel loginLabel = new JLabel("Login:");
        JLabel passwordLabel = new JLabel("Password:");

        loginLabel.setFont(new Font("Verdana", Font.BOLD, 16));
        passwordLabel.setFont(new Font("Verdana", Font.BOLD, 16));

        setBackground(new Color(173, 214, 230));

        // Create a button
        loginButton = new JButton("Login");
        loginButton.setPreferredSize(new Dimension(100, 40));

        // Create text fields
        loginField = new JTextField();
        loginField.setPreferredSize(new Dimension(200, 40));
        passwordField = new JTextField();
        passwordField.setPreferredSize(new Dimension(200, 40));



        setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.CENTER;
        GUIFrame.labelInset(constraints);
        add(loginLabel, constraints);

        GUIFrame.defaultInset(constraints);
        constraints.gridy++;
        add(loginField, constraints);

        GUIFrame.labelInset(constraints);
        constraints.gridy++;
        add(passwordLabel, constraints);

        GUIFrame.defaultInset(constraints);
        constraints.gridy++;
        add(passwordField, constraints);

        constraints.gridy++;
        add(loginButton, constraints);


        setBorder(new EmptyBorder(80, 80, 80, 80));

    }

}
