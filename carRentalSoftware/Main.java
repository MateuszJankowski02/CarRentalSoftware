import GUI.GUI;
import authentication.LoginAuthenticator;
import resources.User;

public class Main {

    public static void main(String[] args) {
        User.Users users = new User.Users();

        new GUI(users);


        User user = new User("John", "Smith", "1234 Main St.",
                "1234567890", "sadf", "johnsmith", "password");
        LoginAuthenticator loginAuthenticator = new LoginAuthenticator();
        loginAuthenticator.selectBaseOfUsers(users.getUsers());
        loginAuthenticator.authenticate(user.getLogin(), user.getPassword());
    }

}
