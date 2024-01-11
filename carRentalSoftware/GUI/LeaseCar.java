package GUI;

import resources.NotLeasedCar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


// this class should combine LeaseCar and LeaseCarClients
// it should display LeaseCarCars
// after clicking on a "Lease" button it should display LeaseCarClients
// after clicking on a "Back" button in LeaseCarClients it should display LeaseCarCars to choose a different car
public class LeaseCar extends JPanel {

    CardLayout cardLayout = new CardLayout();
    LeaseCarCars leaseCarCars = new LeaseCarCars(this);
    LeaseCarClients leaseCarClients = new LeaseCarClients(this);
    JPanel leaseCarSwitch = new JPanel(cardLayout);
    NotLeasedCar carToLease;

    LeaseCar(){

        setBackground(new Color(173, 214, 230));

        leaseCarSwitch.add(leaseCarCars, "leaseCarCars");
        leaseCarSwitch.add(leaseCarClients, "leaseCarClients");

        cardLayout.show(leaseCarSwitch, "leaseCarCars");

        add(leaseCarSwitch);
    }

    public void showLeaseCarClients(){
        cardLayout.show(leaseCarSwitch, "leaseCarClients");
    }

    public void showLeaseCarCars(){
        cardLayout.show(leaseCarSwitch, "leaseCarCars");
    }

    public void setCarToLease(NotLeasedCar car){
        carToLease = car;
    }
    public NotLeasedCar getCarToLease(){
        return carToLease;
    }


}
