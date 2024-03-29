package GUI;

import resources.NotLeasedCar;
import utility.Raport;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveCar extends JPanel {

    static GridBagConstraints constraints = new GridBagConstraints();
    private static String message;

    RemoveCar(){

        setBackground(new Color(173, 214, 230));

        JLabel brandLabel = new JLabel("Brand");
        JLabel modelLabel = new JLabel("Model");
        JLabel colorLabel = new JLabel("Color");
        JLabel registrationNumberLabel = new JLabel("Registration number");

        add(brandLabel);
        add(modelLabel);
        add(colorLabel);
        add(registrationNumberLabel);

        setLayout(new GridBagLayout());

        refreshCars(this);
    }
    public void refreshCars(JPanel panel){
        panel.removeAll();
        panel.repaint();
        panel.revalidate();
        JLabel brandLabel = new JLabel("Brand");
        JLabel modelLabel = new JLabel("Model");
        JLabel colorLabel = new JLabel("Color");
        JLabel registrationNumberLabel = new JLabel("Registration number");

        panel.add(brandLabel);
        panel.add(modelLabel);
        panel.add(colorLabel);
        panel.add(registrationNumberLabel);

        panel.setLayout(new GridBagLayout());

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.CENTER;
        removeCarInset(constraints);

        panel.add(brandLabel, constraints);

        constraints.gridx++;
        panel.add(modelLabel, constraints);

        constraints.gridx++;
        panel.add(colorLabel, constraints);

        constraints.gridx++;
        panel.add(registrationNumberLabel, constraints);
        constraints.gridy++;
        constraints.gridx = 0;

        for (NotLeasedCar car : NotLeasedCar.NotLeasedCars.getCars()) {
            addCarToPanel(panel, car);
        }
    }
    public static void addCarToPanel(JPanel panel, NotLeasedCar car){
        JLabel brand = new JLabel(car.getBrand());
        JLabel model = new JLabel(car.getModel());
        JLabel color = new JLabel(car.getColor());
        JLabel registrationNumber = new JLabel(car.getRegistrationNumber());
        JButton removeButton = new JButton("Remove");

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NotLeasedCar.NotLeasedCars.removeCar(car);
                message = "Car" + car.getBrand() + " " + car.getModel() + " " + car.getRegistrationNumber() + " removed successfully";
                Raport.saveToFile(message);
                panel.remove(brand);
                panel.remove(model);
                panel.remove(color);
                panel.remove(registrationNumber);
                panel.remove(removeButton);
                panel.repaint();
                panel.revalidate();
            }
        });

        panel.add(brand, constraints);
        constraints.gridx++;
        panel.add(model, constraints);
        constraints.gridx++;
        panel.add(color, constraints);
        constraints.gridx++;
        panel.add(registrationNumber, constraints);
        constraints.gridx++;
        panel.add(removeButton, constraints);
        constraints.gridy++;
        constraints.gridx = 0;
    }
    public static void removeCarInset(GridBagConstraints constraints){
        constraints.insets = new Insets(0, 30, 20, 30);
    }
}
