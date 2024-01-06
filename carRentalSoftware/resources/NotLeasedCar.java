package resources;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class NotLeasedCar {

    private String brand;
    private String model;
    private String color;
    private String registrationNumber;
    private String vinNumber;
    private String engineNumber;
    private String productionYear;
    private String engineCapacity;
    private String power;
    private String fuelType;
    private String mileage;
    private String price;

    public NotLeasedCar(String brand, String model, String color, String registrationNumber, String vinNumber,
                        String engineNumber, String productionYear, String engineCapacity, String power,
                        String fuelType, String mileage, String price) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.registrationNumber = registrationNumber;
        this.vinNumber = vinNumber;
        this.engineNumber = engineNumber;
        this.productionYear = productionYear;
        this.engineCapacity = engineCapacity;
        this.power = power;
        this.fuelType = fuelType;
        this.mileage = mileage;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getVinNumber() {
        return vinNumber;
    }

    public String getEngineNumber() {
        return engineNumber;
    }

    public String getProductionYear() {
        return productionYear;
    }

    public String getEngineCapacity() {
        return engineCapacity;
    }

    public String getPower() {
        return power;
    }

    public String getFuelType() {
        return fuelType;
    }

    public String getMileage() {
        return mileage;
    }

    public String getPrice() {
        return price;
    }

    public static class NotLeasedCars {
        private static ArrayList<NotLeasedCar> notLeasedCars = new ArrayList<>();

        public static ArrayList<NotLeasedCar> readNotLeasedCarsFromFile(String fileName) {
            try {
                File file = new File(fileName);
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String[] notLeasedCar = scanner.nextLine().split("\t");
                    //System.out.println(notLeasedCar[0] + " " + notLeasedCar[1] + " " + notLeasedCar[2] + " " + notLeasedCar[3] + " " + notLeasedCar[4] + " " + notLeasedCar[5] + " " + notLeasedCar[6] + " " + notLeasedCar[7] + " " + notLeasedCar[8] + " " + notLeasedCar[9] + " " + notLeasedCar[10] + " " + notLeasedCar[11]);
                    notLeasedCars.add(new NotLeasedCar(notLeasedCar[0], notLeasedCar[1], notLeasedCar[2], notLeasedCar[3], notLeasedCar[4], notLeasedCar[5], notLeasedCar[6], notLeasedCar[7], notLeasedCar[8], notLeasedCar[9], notLeasedCar[10], notLeasedCar[11]));
                }
                scanner.close();
                return notLeasedCars;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return null;
            }
        }

        public static void displayNotLeasedCars() {
            for (NotLeasedCar notLeasedCar : notLeasedCars) {
                System.out.println(notLeasedCar.getBrand() + " " + notLeasedCar.getModel() + " " + notLeasedCar.getColor() + " " + notLeasedCar.getRegistrationNumber() + " " + notLeasedCar.getVinNumber() + " " + notLeasedCar.getEngineNumber() + " " + notLeasedCar.getProductionYear() + " " + notLeasedCar.getEngineCapacity() + " " + notLeasedCar.getPower() + " " + notLeasedCar.getFuelType() + " " + notLeasedCar.getMileage() + " " + notLeasedCar.getPrice());
            }
        }

        public ArrayList<NotLeasedCar> getCars() {
            return notLeasedCars;
        }

        public void addCar(NotLeasedCar notLeasedCar) {
            notLeasedCars.add(notLeasedCar);
        }

        public static void removeCar(NotLeasedCar notLeasedCar) {
            notLeasedCars.remove(notLeasedCar);
        }

    }

}
