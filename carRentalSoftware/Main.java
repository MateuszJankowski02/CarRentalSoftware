import GUI.GUIFrame;
import resources.*;

public class Main {

    public static void main(String[] args) {
        NotLeasedCar.NotLeasedCars.readNotLeasedCarsFromFile("cars.txt");
        LeasedCar.LeasedCars leasedCars = new LeasedCar.LeasedCars();
        User.Users.readUsersFromFile("users.txt");
        System.out.println("------------------------------------------------------------------------------------------------------------------------");

        new GUIFrame(User.Users.getUsers());
    }

}
