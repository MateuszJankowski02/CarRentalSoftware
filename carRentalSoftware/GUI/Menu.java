package GUI;

import javax.swing.*;
import java.awt.*;

public class Menu extends JPanel {

    JLabel titleLabel;
    JButton addCarButton;
    JButton removeCarButton;
    JButton leaseCarButton;
    JButton addClientButton;
    JButton clientListButton;
    JButton downloadClientListButton;
    JButton logoutButton;
    JButton serializeUser;

    Menu(){

        Dimension buttonSize = new Dimension(GUIFrame.getFrameWidth() / 5 - 10, 40);

        setBackground(new Color(173, 214, 230));

        titleLabel = new JLabel("Wypożyczalnia samochodów");
        titleLabel.setFont(new Font(titleLabel.getFont().getName(), Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setForeground(new Color(0, 145, 108));

        addCarButton = new JButton("Add car");
        addCarButton.setPreferredSize(buttonSize);

        removeCarButton = new JButton("Remove car");
        removeCarButton.setPreferredSize(buttonSize);


        leaseCarButton = new JButton("Lease car");
        leaseCarButton.setPreferredSize(buttonSize);

        addClientButton = new JButton("Add client");
        addClientButton.setPreferredSize(buttonSize);

        clientListButton = new JButton("Client list");
        clientListButton.setPreferredSize(buttonSize);

        downloadClientListButton = new JButton("Download client list");
        downloadClientListButton.setPreferredSize(buttonSize);

        logoutButton = new JButton("Logout");
        logoutButton.setPreferredSize(buttonSize);

        serializeUser = new JButton("Serialize user");
        serializeUser.setPreferredSize(buttonSize);

        Color buttonColor = new Color(20, 20, 20);

        addCarButton.setBackground(buttonColor);
        addCarButton.setForeground(Color.WHITE);
        removeCarButton.setBackground(buttonColor);
        removeCarButton.setForeground(Color.WHITE);
        leaseCarButton.setBackground(buttonColor);
        leaseCarButton.setForeground(Color.WHITE);
        addClientButton.setBackground(buttonColor);
        addClientButton.setForeground(Color.WHITE);
        clientListButton.setBackground(buttonColor);
        clientListButton.setForeground(Color.WHITE);
        downloadClientListButton.setBackground(buttonColor);
        downloadClientListButton.setForeground(Color.WHITE);
        logoutButton.setBackground(buttonColor);
        logoutButton.setForeground(Color.WHITE);
        serializeUser.setBackground(buttonColor);
        serializeUser.setForeground(Color.WHITE);


        setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(0, 0, 60, 0);
        add(titleLabel, constraints);
        constraints.gridy++;
        constraints.insets = new Insets(0, 0, 30, 0);

        add(addCarButton, constraints);

        constraints.gridy++;
        add(removeCarButton, constraints);

        constraints.gridy++;
        add(leaseCarButton, constraints);

        constraints.gridy++;
        add(addClientButton, constraints);

        constraints.gridy++;
        add(clientListButton, constraints);

        constraints.gridy++;
        add(downloadClientListButton, constraints);

        constraints.gridy++;
        add(serializeUser, constraints);

        constraints.gridy++;
        add(logoutButton, constraints);
    }
}
