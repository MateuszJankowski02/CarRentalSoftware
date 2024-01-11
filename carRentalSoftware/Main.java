import GUI.GUIFrame;
import resources.*;

public class Main {

    public static void main(String[] args) {
        NotLeasedCar.NotLeasedCars.readNotLeasedCarsFromFile("cars.txt");
        Client.Clients.readClientsFromFile("clients.txt");
        User.Users.readUsersFromFile("users.txt");
        System.out.println("------------------------------------------------------------------------------------------------------------------------");
        NotLeasedCar.NotLeasedCars.displayNotLeasedCars();

        new GUIFrame(User.Users.getUsers());
    }

}
