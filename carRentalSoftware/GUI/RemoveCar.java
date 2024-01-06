package GUI;

import resources.NotLeasedCar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveCar extends JPanel {

    GridBagConstraints constraints = new GridBagConstraints();

    RemoveCar(Menu menu){
        JLabel brandLabel = new JLabel("Brand");
        JLabel modelLabel = new JLabel("Model");
        JLabel colorLabel = new JLabel("Color");
        JLabel registrationNumberLabel = new JLabel("Registration number");

        // create me a loop that will create a list of cars with the following criteria:
        // the list of cars is imported from NotLeasedCar.NotLeasedCars.getNotLeasedCars()
        // brand, model, color, registration number
        // each car should have a remove button next to it
        // then add it to the panel

        add(brandLabel);
        add(modelLabel);
        add(colorLabel);
        add(registrationNumberLabel);

        setLayout(new GridBagLayout());

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.CENTER;
        removeCarInset(constraints);

        add(brandLabel, constraints);

        constraints.gridx++;
        add(modelLabel, constraints);

        constraints.gridx++;
        add(colorLabel, constraints);

        constraints.gridx++;
        add(registrationNumberLabel, constraints);
        constraints.gridy++;
        constraints.gridx = 0;

                for (int i = 0; i < NotLeasedCar.NotLeasedCars.getCars().size(); i++) {
                    addCarToPanel(this, NotLeasedCar.NotLeasedCars.getCars().get(i), constraints);
                }
    }
    public static void addCarToPanel(JPanel panel, NotLeasedCar car, GridBagConstraints constraints){
        JLabel brand = new JLabel(car.getBrand());
        JLabel model = new JLabel(car.getModel());
        JLabel color = new JLabel(car.getColor());
        JLabel registrationNumber = new JLabel(car.getRegistrationNumber());
        JButton removeButton = new JButton("Remove");

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NotLeasedCar.NotLeasedCars.getCars().removeIf(car -> car.getVinNumber().equals(car.getVinNumber()));
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
