package carRental;

public class Main {
    public static void main(String[] args) {

        try {
            DatabaseConnection.connectDB("TestDB", "root", "password");
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }

    }
}
