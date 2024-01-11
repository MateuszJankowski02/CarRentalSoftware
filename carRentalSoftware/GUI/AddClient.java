package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import resources.Client;
import utility.Raport;


public class AddClient extends JPanel{

    private static String message;


    AddClient(ClientList clientList){

        setBackground(new Color(173, 214, 230));

        JLabel firstNameLabel = new JLabel("First name:");
        JTextField firstName = new JTextField();
        firstName.setPreferredSize(new Dimension(150, 30));

        JLabel lastNameLabel = new JLabel("Last name:");
        JTextField lastName = new JTextField();
        lastName.setPreferredSize(new Dimension(150, 30));

        JLabel addressLabel = new JLabel("Address:");
        JTextField address = new JTextField();
        address.setPreferredSize(new Dimension(150, 30));

        JLabel phoneNumberLabel = new JLabel("Phone number:");
        JTextField phoneNumber = new JTextField();
        phoneNumber.setPreferredSize(new Dimension(150, 30));

        JLabel emailLabel = new JLabel("E-mail:");
        JTextField email = new JTextField();
        email.setPreferredSize(new Dimension(150, 30));

        JLabel identityLabel = new JLabel("Identity verificator:");
        JTextField identity = new JTextField();
        identity.setPreferredSize(new Dimension(150, 30));

        JButton addClientButton = new JButton("Add client");
        addClientButton.setPreferredSize(new Dimension(100, 40));

        Dimension labelSize = identityLabel.getPreferredSize();
        firstNameLabel.setSize(new Dimension((int) labelSize.getWidth(), (int) labelSize.getHeight()));
        lastNameLabel.setSize(new Dimension((int) labelSize.getWidth(), (int) labelSize.getHeight()));
        addressLabel.setSize(new Dimension((int) labelSize.getWidth(), (int) labelSize.getHeight()));
        phoneNumberLabel.setSize(new Dimension((int) labelSize.getWidth(), (int) labelSize.getHeight()));
        emailLabel.setSize(new Dimension((int) labelSize.getWidth(), (int) labelSize.getHeight()));
        identityLabel.setSize(new Dimension((int) labelSize.getWidth(), (int) labelSize.getHeight()));

        firstNameLabel.setFont(new Font("Verdana", Font.BOLD, 16));
        lastNameLabel.setFont(new Font("Verdana", Font.BOLD, 16));
        addressLabel.setFont(new Font("Verdana", Font.BOLD, 16));
        phoneNumberLabel.setFont(new Font("Verdana", Font.BOLD, 16));
        emailLabel.setFont(new Font("Verdana", Font.BOLD, 16));
        identityLabel.setFont(new Font("Verdana", Font.BOLD, 16));

        add(firstNameLabel);
        add(firstName);
        add(lastNameLabel);
        add(lastName);
        add(addressLabel);
        add(address);
        add(phoneNumberLabel);
        add(phoneNumber);
        add(emailLabel);
        add(email);
        add(identityLabel);
        add(identity);
        add(addClientButton);

        setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();

        constraints.gridx = 0;
        constraints.gridy = 0;
        // add another column to the grid
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.CENTER;
        // firstName
        addClientInset(constraints);
        add(firstNameLabel, constraints);


        addClientInset(constraints);
        constraints.gridx++;
        add(firstName, constraints);

        // lastName
        addClientInset(constraints);
        constraints.gridx--;
        constraints.gridy++;
        add(lastNameLabel, constraints);

        addClientInset(constraints);
        constraints.gridx++;
        add(lastName, constraints);

        // address
        addClientInset(constraints);
        constraints.gridx--;
        constraints.gridy++;
        add(addressLabel, constraints);

        addClientInset(constraints);
        constraints.gridx++;
        add(address, constraints);

        // phoneNumber
        addClientInset(constraints);
        constraints.gridx--;
        constraints.gridy++;
        add(phoneNumberLabel, constraints);

        addClientInset(constraints);
        constraints.gridx++;
        add(phoneNumber, constraints);

        // email
        addClientInset(constraints);
        constraints.gridx--;
        constraints.gridy++;
        add(emailLabel, constraints);

        addClientInset(constraints);
        constraints.gridx++;
        add(email, constraints);

        // identity
        addClientInset(constraints);
        constraints.gridx--;
        constraints.gridy++;
        add(identityLabel, constraints);

        addClientInset(constraints);
        constraints.gridx++;
        add(identity, constraints);

        // addClientButton
        addClientInset(constraints);
        constraints.gridx--;
        constraints.gridy++;
        constraints.gridwidth = 2;
        add(addClientButton, constraints);

        setBorder(new EmptyBorder(20, 20, 20, 20));

        addClientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Client client = new Client(firstName.getText(), lastName.getText(), address.getText(), phoneNumber.getText(), email.getText(), identity.getText());
                if (checkIfNoEmptyFields(firstName, lastName, address, phoneNumber, email, identity) && Client.Clients.addClient(client)) {
                    message = "Client " + firstName.getText() + " " + lastName.getText() + " has been added";
                    Raport.saveToFile(message);
                    JOptionPane.showMessageDialog(null, "Client " + firstName.getText() + " " + lastName.getText() + " has been added");
                    firstName.setText("");
                    lastName.setText("");
                    address.setText("");
                    phoneNumber.setText("");
                    email.setText("");
                    identity.setText("");
                } else {
                    message = "Could not add client" + firstName.getText() + " " + lastName.getText();
                    Raport.saveToFile(message);
                    JOptionPane.showMessageDialog(null, "Couldn't add client. Check if all fields are filled");
                }
            }
        });


    }
    public static void addClientInset(GridBagConstraints constraints){
        constraints.insets = new Insets(0, 30, 10, 40);
    }

    public static boolean checkIfNoEmptyFields(JTextField... textFields){
        for (JTextField textField : textFields) {
            if (textField.getText().isEmpty()) {
                return false;
            }
        }
        return true;
    }
}
