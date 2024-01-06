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

    public Client(String firstName, String lastName, String address, String phoneNumber, String email, String identityVerificator) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.identityVerificator = identityVerificator;
    }

    class Clients{

        private ArrayList<Client> clients = new ArrayList<>();

        public void addClient(Client client){
            clients.add(client);
        }

        public void removeClient(Client client){
            clients.remove(client);
        }

        public void uploadClients(){
            try {
                File file = new File("clients.txt");
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String[] clientData = scanner.nextLine().split("\t");
                    clients.add(new Client(clientData[0], clientData[1], clientData[2], clientData[3], clientData[4], clientData[5]));
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public void downloadClients(){
            try {
                FileWriter fileWriter = new FileWriter("clients.txt");
                for (Client client : clients) {
                    fileWriter.write(client.getFirstName() + "\t" + client.getLastName() + "\t" + client.getAddress() + "\t" + client.getPhoneNumber() + "\t" + client.getEmail() + "\t" + client.getIdentityVerificator() + "\n");
                }
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public void showClients(){
            for (Client client : clients) {
                System.out.println(client.getFirstName() + " " + client.getLastName() + " " + client.getAddress() + " " + client.getPhoneNumber() + " " + client.getEmail() + " " + client.getIdentityVerificator());
            }
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

    public boolean isHasLeasedCar() {
        return hasLeasedCar;
    }
}
