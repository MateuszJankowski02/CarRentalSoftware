package resources;

import java.util.ArrayList;

public class LeasedCar extends NotLeasedCar{

    private Client carLeaser;
    private String leaseStartDate;
    private String leaseEndDate;
    private String leasePrice;


    public LeasedCar(NotLeasedCar notLeasedCar, Client carLeaser, String leaseStartDate, String leaseEndDate, String leasePrice) {
        super(notLeasedCar.getBrand(), notLeasedCar.getModel(), notLeasedCar.getColor(), notLeasedCar.getRegistrationNumber(),
                notLeasedCar.getVinNumber(), notLeasedCar.getEngineNumber(), notLeasedCar.getProductionYear(),
                notLeasedCar.getEngineCapacity(), notLeasedCar.getPower(), notLeasedCar.getFuelType(),
                notLeasedCar.getMileage());
        this.carLeaser = carLeaser;
        this.leaseStartDate = leaseStartDate;
        this.leaseEndDate = leaseEndDate;
        this.leasePrice = leasePrice;
    }

    public static class LeasedCars {
        static private ArrayList<LeasedCar> leasedCars = new ArrayList<>();

        // make a method that leases a car to a user and adds it to leasedCars ArrayList and removes it from notLeasedCars ArrayList
        public static void leaseCar(NotLeasedCar notLeasedCar, Client carLeaser, String leaseStartDate, String leaseEndDate, String leasePrice) {
            leasedCars.add(new LeasedCar(notLeasedCar, carLeaser, leaseStartDate, leaseEndDate, leasePrice));
            NotLeasedCar.NotLeasedCars.removeCar(notLeasedCar);
        }



    }

}
