import java.util.ArrayList;

public class User {
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

    protected String getLogin() {
        return login;
    }

    protected String getPassword() {
        return password;
    }

    protected boolean getIsLoggedIn() {
        return isLoggedIn;
    }

    protected void setIsLoggedIn(boolean isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
    }

    public static class Users {

        private ArrayList<User> users = new ArrayList<>();

        public Users() {
            users.add(new User("John", "Smith", "1234 Main St.",
                    "1234567890", "john.smith@gmail.com", "johnsmith", "password"));
            users.add(new User("Jane", "Doe", "1234 Main St.",
                    "1234567890", "jane.doe@gmail.com", "janedoe", "password"));
            users.add(new User("Bob", "Smith", "1234 Main St.",
                    "1234567890", "bob.smith@gmail.com", "bobsmith", "password"));
            users.add(new User("Mary", "Doe", "1234 Main St.",
                    "1234567890", "mary.doe@gmail.com", "marydoe", "password"));
            users.add(new User("James", "Smith", "1234 Main St.",
                    "1234567890", "james.smith@gmail.com", "jamessmith", "password"));
            users.add(new User("Jennifer", "Doe", "1234 Main St.",
                    "1234567890", "jennifer.doe@gmail.com", "jenniferdoe", "password"));
            users.add(new User("Michael", "Smith", "1234 Main St.",
                    "1234567890", "michael.smith@gmail.com", "michaelsmith", "password"));
        }

        public ArrayList<User> getUsers() {
            return users;
        }

    }

}
