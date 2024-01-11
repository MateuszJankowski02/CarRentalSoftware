package resources;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Client {

    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    private String email;
    private String identityVerificator;
    private boolean hasLeasedCar = false;
    private NotLeasedCar leasedCar;

    public Client(String firstName, String lastName, String address, String phoneNumber, String email, String identityVerificator) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.identityVerificator = identityVerificator;
    }

    public static class Clients{

        private static ArrayList<Client> clients = new ArrayList<>();

        public static boolean addClient(Client client){
            return clients.add(client);
        }

        public static void removeClient(Client client){
            clients.remove(client);
        }

        public static void readClientsFromFile(String fileName){
            try {
                File file = new File(fileName);
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String[] clientData = scanner.nextLine().split(",");
                    clients.add(new Client(clientData[0], clientData[1], clientData[2], clientData[3], clientData[4], clientData[5]));
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public static boolean downloadClients(String fileName){
            try {
                FileWriter fileWriter = new FileWriter(fileName);
                for (Client client : clients) {
                    fileWriter.write(client.getFirstName() + "," + client.getLastName() + "," + client.getAddress() + "," + client.getPhoneNumber() + "," + client.getEmail() + "," + client.getIdentityVerificator() + "\n");
                }
                fileWriter.close();
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        public void showClients(){
            for (Client client : clients) {
                System.out.println(client.getFirstName() + " " + client.getLastName() + " " + client.getAddress() + " " + client.getPhoneNumber() + " " + client.getEmail() + " " + client.getIdentityVerificator());
            }
        }

        public static ArrayList<Client> getClients() {
            return clients;
        }

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getIdentityVerificator() {
        return identityVerificator;
    }

    public void leaseCar (NotLeasedCar leasedCar) {
        this.leasedCar = leasedCar;
        hasLeasedCar = true;
    }

    public boolean hasLeasedCar() {
        return hasLeasedCar;
    }

    public NotLeasedCar getLeasedCar() {
        return leasedCar;
    }
}
