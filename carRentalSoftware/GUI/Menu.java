package GUI;

import javax.swing.*;
import java.awt.*;

public class Menu extends JPanel {

    JButton addCarButton;
    JButton removeCarButton;
    JButton leaseCar;
    JButton addClientButton;
    JButton clientListButton;
    JButton downloadClientListButton;
    JButton logoutButton;

    Menu(){

        Dimension buttonSize = new Dimension(GUIFrame.getFrameWidth() / 5 - 10, 40);

        addCarButton = new JButton("Add car");
        addCarButton.setPreferredSize(buttonSize);

        removeCarButton = new JButton("Remove car");
        removeCarButton.setPreferredSize(buttonSize);


        leaseCar = new JButton("Lease car");
        leaseCar.setPreferredSize(buttonSize);

        addClientButton = new JButton("Add client");
        addClientButton.setPreferredSize(buttonSize);

        clientListButton = new JButton("Client list");
        clientListButton.setPreferredSize(buttonSize);

        downloadClientListButton = new JButton("Download client list");
        downloadClientListButton.setPreferredSize(buttonSize);

        logoutButton = new JButton("Logout");
        logoutButton.setPreferredSize(buttonSize);

        setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(0, 0, 20, 0);
        add(addCarButton, constraints);

        constraints.gridy++;
        add(removeCarButton, constraints);

        constraints.gridy++;
        add(leaseCar, constraints);

        constraints.gridy++;
        add(addClientButton, constraints);

        constraints.gridy++;
        add(clientListButton, constraints);

        constraints.gridy++;
        add(downloadClientListButton, constraints);

        constraints.gridy++;
        add(logoutButton, constraints);
    }
}
