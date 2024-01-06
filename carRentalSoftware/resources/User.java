package resources;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class User implements Serializable {
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    private String email;
    private String login;
    private String password;
    private boolean isLoggedIn = false;

    public User(String firstName, String lastName, String address, String phoneNumber, String email, String login, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.login = login;
        this.password = password;
    }

    private static void serializeUser(Object object, String fileName) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(object);
            System.out.println("Object serialized and saved to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Object deserializeUser(String fileName) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            return inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
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

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    protected boolean getIsLoggedIn() {
        return isLoggedIn;
    }

    public void setIsLoggedIn(boolean isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
    }

    public static class Users {     // KLASA WEWNĘTRZNA

        private static ArrayList<User> users = new ArrayList<>();

        public static ArrayList<User> readUsersFromFile(String fileName) {
            try {
                File file = new File(fileName);
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String[] user = scanner.nextLine().split(",");
                    //System.out.println(user[0] + " " + user[1] + " " + user[2] + " " + user[3] + " " + user[4] + " " + user[5] + " " + user[6]);
                    users.add(new User(user[0], user[1], user[2], user[3], user[4], user[5], user[6]));
                }
                scanner.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            return users;
        }

        public static boolean saveUsersToFile(String fileName) {
            try {
                FileWriter fileWriter = new FileWriter(fileName);
                for (User user : users) {
                    fileWriter.write(user.getFirstName() + "," + user.getLastName() + "," + user.getAddress() + "," + user.getPhoneNumber() + "," + user.getEmail() + "," + user.getLogin() + "," + user.getPassword() + "\n");
                }
                fileWriter.close();
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }

        public static ArrayList<User> getUsers() {
            return users;
        }

        public static void displayUsers() {
            for (User user : users) {
                System.out.println(user.getFirstName() + " " + user.getLastName() + " " + user.getAddress() + " " + user.getPhoneNumber() + " " + user.getEmail() + " " + user.getLogin() + " " + user.getPassword());
            }
        }

    }

}
