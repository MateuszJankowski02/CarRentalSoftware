package GUI;

import javax.swing.*;

public class AddCar extends JPanel {

    AddCar(){

        JTextField brand = new JTextField();
        JTextField model = new JTextField();
        JTextField color = new JTextField();
        JTextField registrationNumber = new JTextField();
        JTextField vinNumber = new JTextField();
        JTextField engineNumber = new JTextField();
        JTextField productionYear = new JTextField();
        JTextField engineCapacity = new JTextField();
        JTextField power = new JTextField();
        JTextField fuelType = new JTextField();
        JTextField mileage = new JTextField();
        JTextField price = new JTextField();

        JButton addButton = new JButton("Add car");
        JButton backButton = new JButton("Back");

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(brand);
        add(model);
        add(color);
        add(registrationNumber);
        add(vinNumber);
        add(engineNumber);
        add(productionYear);
        add(engineCapacity);
        add(power);
        add(fuelType);
        add(mileage);
        add(price);

        add(addButton);
        add(backButton);
    }
}
