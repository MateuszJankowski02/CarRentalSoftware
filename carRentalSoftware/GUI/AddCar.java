package GUI;

import resources.NotLeasedCar;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AddCar extends JPanel {

    AddCar(RemoveCar removeCar){

        JLabel brandLabel = new JLabel("Brand:");
        JTextField brand = new JTextField();
        brandLabel.setPreferredSize(new Dimension(100, 30));
        brand.setPreferredSize(new Dimension(150, 30));

        JLabel modelLabel = new JLabel("Model:");
        JTextField model = new JTextField();
        modelLabel.setPreferredSize(new Dimension(100, 30));
        model.setPreferredSize(new Dimension(150, 30));

        JLabel colorLabel = new JLabel("Color:");
        JTextField color = new JTextField();
        colorLabel.setPreferredSize(new Dimension(100, 30));
        color.setPreferredSize(new Dimension(150, 30));

        JLabel registrationNumberLabel = new JLabel("Registration number:");
        JTextField registrationNumber = new JTextField();
        registrationNumberLabel.setPreferredSize(new Dimension(100, 30));
        registrationNumber.setPreferredSize(new Dimension(150, 30));

        JLabel vinNumberLabel = new JLabel("VIN number:");
        JTextField vinNumber = new JTextField();
        vinNumberLabel.setPreferredSize(new Dimension(100, 30));
        vinNumber.setPreferredSize(new Dimension(150, 30));

        JLabel engineNumberLabel = new JLabel("Engine number:");
        JTextField engineNumber = new JTextField();
        engineNumberLabel.setPreferredSize(new Dimension(100, 30));
        engineNumber.setPreferredSize(new Dimension(150, 30));

        JLabel productionYearLabel = new JLabel("Production year:");
        JTextField productionYear = new JTextField();
        productionYearLabel.setPreferredSize(new Dimension(100, 30));
        productionYear.setPreferredSize(new Dimension(150, 30));

        JLabel engineCapacityLabel = new JLabel("Engine capacity:");
        JTextField engineCapacity = new JTextField();
        engineCapacityLabel.setPreferredSize(new Dimension(100, 30));
        engineCapacity.setPreferredSize(new Dimension(150, 30));

        JLabel powerLabel = new JLabel("Power:");
        JTextField power = new JTextField();
        powerLabel.setPreferredSize(new Dimension(100, 30));
        power.setPreferredSize(new Dimension(150, 30));

        JLabel fuelTypeLabel = new JLabel("Fuel type:");
        JTextField fuelType = new JTextField();
        fuelTypeLabel.setPreferredSize(new Dimension(100, 30));
        fuelType.setPreferredSize(new Dimension(150, 30));

        JLabel mileageLabel = new JLabel("Mileage:");
        JTextField mileage = new JTextField();
        mileageLabel.setPreferredSize(new Dimension(100, 30));
        mileage.setPreferredSize(new Dimension(150, 30));

        JButton addButton = new JButton("Add car");
        addButton.setPreferredSize(new Dimension(100, 30));

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

        add(addButton);

        setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        // add another column to the grid
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.CENTER;
        // brand
        addCarInset(constraints);
        add(brandLabel, constraints);


        addCarInset(constraints);
        constraints.gridx++;
        add(brand, constraints);

        // model
        addCarInset(constraints);
        constraints.gridx--;
        constraints.gridy++;
        add(modelLabel, constraints);

        addCarInset(constraints);
        constraints.gridx++;
        add(model, constraints);

        // color
        addCarInset(constraints);
        constraints.gridx--;
        constraints.gridy++;
        add(colorLabel, constraints);

        addCarInset(constraints);
        constraints.gridx++;
        add(color, constraints);

        // registration number
        addCarInset(constraints);
        constraints.gridx--;
        constraints.gridy++;
        add(registrationNumberLabel, constraints);

        addCarInset(constraints);
        constraints.gridx++;
        add(registrationNumber, constraints);

        // vin number
        addCarInset(constraints);
        constraints.gridx--;
        constraints.gridy++;
        add(vinNumberLabel, constraints);

        addCarInset(constraints);
        constraints.gridx++;
        add(vinNumber, constraints);

        // engine number
        addCarInset(constraints);
        constraints.gridx--;
        constraints.gridy++;
        add(engineNumberLabel, constraints);

        addCarInset(constraints);
        constraints.gridx++;
        add(engineNumber, constraints);

        // production year
        addCarInset(constraints);
        constraints.gridx--;
        constraints.gridy++;
        add(productionYearLabel, constraints);

        addCarInset(constraints);
        constraints.gridx++;
        add(productionYear, constraints);

        // engine capacity
        addCarInset(constraints);
        constraints.gridx--;
        constraints.gridy++;
        add(engineCapacityLabel, constraints);

        addCarInset(constraints);
        constraints.gridx++;
        add(engineCapacity, constraints);

        // power
        addCarInset(constraints);
        constraints.gridx--;
        constraints.gridy++;
        add(powerLabel, constraints);

        addCarInset(constraints);
        constraints.gridx++;
        add(power, constraints);

        // fuel type
        addCarInset(constraints);
        constraints.gridx--;
        constraints.gridy++;
        add(fuelTypeLabel, constraints);

        addCarInset(constraints);
        constraints.gridx++;
        add(fuelType, constraints);

        // mileage
        addCarInset(constraints);
        constraints.gridx--;
        constraints.gridy++;
        add(mileageLabel, constraints);

        addCarInset(constraints);
        constraints.gridx++;
        add(mileage, constraints);

        // add button
        constraints.gridy++;
        add(addButton, constraints);

        setBorder(new EmptyBorder(20, 20, 20, 20));

        addButton.addActionListener(e -> {
            NotLeasedCar notLeasedCar = new NotLeasedCar(brand.getText(), model.getText(), color.getText(), registrationNumber.getText(),
                    vinNumber.getText(), engineNumber.getText(), productionYear.getText(), engineCapacity.getText(),
                    power.getText(), fuelType.getText(), mileage.getText());
            if (NotLeasedCar.NotLeasedCars.addCar(notLeasedCar)) {

                JOptionPane.showMessageDialog(null, "Car added successfully");
                brand.setText("");
                model.setText("");
                color.setText("");
                registrationNumber.setText("");
                vinNumber.setText("");
                engineNumber.setText("");
                productionYear.setText("");
                engineCapacity.setText("");
                power.setText("");
                fuelType.setText("");
                mileage.setText("");
                RemoveCar.addCarToPanel(removeCar, notLeasedCar, removeCar.constraints);
            } else {
                JOptionPane.showMessageDialog(null, "Car not added");
            }
        });
    }
    public static void addCarInset(GridBagConstraints constraints){
        constraints.insets = new Insets(0, 30, 10, 30);
    }

}
