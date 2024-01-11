package utility;

import resources.User;
import java.util.ArrayList;

interface Authenticator {
    ArrayList<User> baseOfUsers = null;
    void selectBaseOfUsers(ArrayList<User> users);
    boolean authenticate(String login, String password);

    boolean logout(String login, String password);
}

public class LoginAuthenticator implements Authenticator{

        public ArrayList<User> baseOfUsers;
        public static User loggedUser = null;

        @Override
        public void selectBaseOfUsers(ArrayList<User> users) {
            baseOfUsers = users;
        }

        @Override
        public boolean authenticate(String login, String password) { //PRZYKŁAD POLIMORFIZMU POPRZEZ PRZECIĄŻANIE METODY
            if(baseOfUsers == null) {
                System.out.println("Base of users is not selected");
                return false;
            }
            for(User user : baseOfUsers) {
                if(user.getLogin().equals(login) && user.getPassword().equals(password)) {
                    user.setIsLoggedIn(true);
                    loggedUser = user;
                    System.out.println("resources.User " + user.getFirstName() + " " + user.getLastName() + " is logged in");
                    return true;
                }
            }
            System.out.println("resources.User with login " + login + " and password " + password + " is not found");
            return false;
        }

        @Override
        public boolean logout(String login, String password) {
            if(baseOfUsers == null) {
                System.out.println("Base of users is not selected");
                return false;
            }
            for(User user : baseOfUsers) {
                if(user.getLogin().equals(login) && user.getPassword().equals(password)) {
                    user.setIsLoggedIn(false);
                    loggedUser = null;
                    System.out.println("resources.User " + user.getFirstName() + " " + user.getLastName() + " is logged out");
                    return true;
                }
            }
            System.out.println("resources.User with login " + login + " and password " + password + " is not found");
            return false;
        }

        public static User getLoggedUser() {
            return loggedUser;
        }

}
