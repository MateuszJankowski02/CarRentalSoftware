package resources;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class NotLeasedCar {

    private static int carCouter = 0;
    private int ID = 0;
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

    public NotLeasedCar(String brand, String model, String color, String registrationNumber, String vinNumber,
                        String engineNumber, String productionYear, String engineCapacity, String power,
                        String fuelType, String mileage) {
        this.ID = carCouter;
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
        this.carCouter++;
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

    public int getID() {
        return ID;
    }

    public static class NotLeasedCars {
        private static ArrayList<NotLeasedCar> notLeasedCars = new ArrayList<>();

        public static ArrayList<NotLeasedCar> readNotLeasedCarsFromFile(String fileName) {
            // ID should be incremented by 1 for each car
            int ID = 0;
            try {
                File file = new File(fileName);
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String[] car = scanner.nextLine().split(",");
                    notLeasedCars.add(new NotLeasedCar(car[0], car[1], car[2], car[3], car[4], car[5],
                            car[6], car[7], car[8], car[9], car[10]));
                    ID++;
                }
                scanner.close();
                return notLeasedCars;
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
                return null;
            }
        }

        public static void displayNotLeasedCars() {
            for (NotLeasedCar notLeasedCar : notLeasedCars) {
                System.out.println(notLeasedCar.getID() + " " + notLeasedCar.getBrand() + " " + notLeasedCar.getModel() + " " + notLeasedCar.getColor() + " " + notLeasedCar.getRegistrationNumber() + " " + notLeasedCar.getVinNumber() + " " + notLeasedCar.getEngineNumber() + " " + notLeasedCar.getProductionYear() + " " + notLeasedCar.getEngineCapacity() + " " + notLeasedCar.getPower() + " " + notLeasedCar.getFuelType() + " " + notLeasedCar.getMileage());
            }
        }

        public static ArrayList<NotLeasedCar> getCars() {
            return notLeasedCars;
        }

        public static boolean addCar(NotLeasedCar notLeasedCar) {
            return notLeasedCars.add(notLeasedCar);
        }

        public static void removeCar(NotLeasedCar notLeasedCar) {
            notLeasedCars.remove(notLeasedCar);
        }

        public static NotLeasedCar getCarByID(int ID) {
            return notLeasedCars.get(ID);
        }

    }

}
