package GUI;

import resources.Client;
import resources.LeasedCar;
import utility.Raport;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

public class LeaseCarClients extends JPanel {

    static GridBagConstraints constraints = new GridBagConstraints();
    private static String message;
    LeaseCarClients(LeaseCar leaseCar){

        setBackground(new Color(173, 214, 230));

        JLabel firstNameLabel = new JLabel("First name");
        JLabel lastNameLabel = new JLabel("Last name");
        JLabel addressLabel = new JLabel("Address");
        JLabel phoneNumberLabel = new JLabel("Phone number");
        JLabel emailLabel = new JLabel("Email");

        setLayout(new GridBagLayout());

        refreshClientList(this, leaseCar);
    }

    public static void refreshClientList(JPanel panel, LeaseCar leaseCar){
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
            if(client.hasLeasedCar()) continue;
            addClientToPanel(panel, leaseCar ,client);
        }
    }

    public static void addClientToPanel(JPanel panel, LeaseCar leaseCar, Client client){
        JLabel firstName = new JLabel(client.getFirstName());
        JLabel lastName = new JLabel(client.getLastName());
        JLabel address = new JLabel(client.getAddress());
        JLabel phoneNumber = new JLabel(client.getPhoneNumber());
        JLabel email = new JLabel(client.getEmail());
        JButton leaseButton = new JButton("Lease car");

        leaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date startDate = new Date();
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(startDate);
                calendar.add(Calendar.DAY_OF_MONTH, 14);
                Date endDate = calendar.getTime();
                client.leaseCar(leaseCar.getCarToLease());
                message = "Leased car " + leaseCar.getCarToLease().getBrand() + " " + leaseCar.getCarToLease().getModel() + " " + leaseCar.getCarToLease().getColor() + " " + leaseCar.getCarToLease().getRegistrationNumber() + " to " + client.getFirstName() + " " + client.getLastName();
                Raport.saveToFile(message);
                JOptionPane.showMessageDialog(null, "Leased car " + leaseCar.getCarToLease().getBrand() + " " + leaseCar.getCarToLease().getModel() + " " + leaseCar.getCarToLease().getColor() + " " + leaseCar.getCarToLease().getRegistrationNumber() + " to " + client.getFirstName() + " " + client.getLastName());

                LeasedCar.LeasedCars.leaseCar(leaseCar.getCarToLease(), client, startDate.toString(), endDate.toString(), "2000 zł");
                LeaseCarCars.refreshCars(leaseCar.leaseCarCars, leaseCar);
                LeaseCarClients.refreshClientList(leaseCar.leaseCarClients, leaseCar);
                leaseCar.showLeaseCarCars();
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
        panel.add(leaseButton, constraints);
        constraints.gridy++;
        constraints.gridx = 0;
    }
    public static void removeClientInset(GridBagConstraints constraints){
        constraints.insets = new Insets(0, 30, 20, 30);
    }
}
