package GUI;

import resources.Client;
import utility.Raport;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ClientList extends JPanel {

    static GridBagConstraints constraints = new GridBagConstraints();
    private static String message;
    ClientList(){

        setBackground(new Color(173, 214, 230));


        JLabel firstNameLabel = new JLabel("First name");
        JLabel lastNameLabel = new JLabel("Last name");
        JLabel addressLabel = new JLabel("Address");
        JLabel phoneNumberLabel = new JLabel("Phone number");
        JLabel emailLabel = new JLabel("Email");

        setLayout(new GridBagLayout());

        refreshClientList(this);
    }

    public void refreshClientList(JPanel panel){
        panel.removeAll();
        panel.repaint();
        panel.revalidate();
        JLabel firstNameLabel = new JLabel("First name");
        JLabel lastNameLabel = new JLabel("Last name");
        JLabel addressLabel = new JLabel("Address");
        JLabel phoneNumberLabel = new JLabel("Phone number");
        JLabel emailLabel = new JLabel("Email");

        panel.setLayout(new GridBagLayout());

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.CENTER;
        removeClientInset(constraints);
        panel.add(firstNameLabel, constraints);

        constraints.gridx++;
        panel.add(lastNameLabel, constraints);

        constraints.gridx++;
        panel.add(addressLabel, constraints);

        constraints.gridx++;
        panel.add(phoneNumberLabel, constraints);

        constraints.gridx++;
        panel.add(emailLabel, constraints);
        constraints.gridy++;
        constraints.gridx = 0;

        for (Client client : Client.Clients.getClients()) {
            addClientToPanel(panel, client);
        }
    }

    public static void addClientToPanel(JPanel panel, Client client){
        JLabel firstName = new JLabel(client.getFirstName());
        JLabel lastName = new JLabel(client.getLastName());
        JLabel address = new JLabel(client.getAddress());
        JLabel phoneNumber = new JLabel(client.getPhoneNumber());
        JLabel email = new JLabel(client.getEmail());
        JButton removeButton = new JButton("Remove");

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Client.Clients.removeClient(client);
                message = "Client" + client.getFirstName() + " " + client.getLastName() + " removed successfully";
                Raport.saveToFile(message);
                panel.remove(firstName);
                panel.remove(lastName);
                panel.remove(address);
                panel.remove(phoneNumber);
                panel.remove(email);
                panel.remove(removeButton);
                panel.repaint();
                panel.revalidate();
            }
        });
        panel.add(firstName, constraints);
        constraints.gridx++;
        panel.add(lastName, constraints);
        constraints.gridx++;
        panel.add(address, constraints);
        constraints.gridx++;
        panel.add(phoneNumber, constraints);
        constraints.gridx++;
        panel.add(email, constraints);
        constraints.gridx++;
        panel.add(removeButton, constraints);
        constraints.gridy++;
        constraints.gridx = 0;
    }
    public static void removeClientInset(GridBagConstraints constraints){
        constraints.insets = new Insets(0, 30, 20, 30);
    }
}
