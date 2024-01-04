package authentication;

import resources.User;
import java.util.ArrayList;
import java.util.List;

public class LoginAuthenticator {

        public ArrayList<User> baseOfUsers;

        public void selectBaseOfUsers(ArrayList<User> users) {
            baseOfUsers = users;
        }

        public boolean authenticate(String login, String password) {
            if(baseOfUsers == null) {
                System.out.println("Base of users is not selected");
                return false;
            }
            for(User user : baseOfUsers) {
                if(user.getLogin().equals(login) && user.getPassword().equals(password)) {
                    user.setIsLoggedIn(true);
                    System.out.println("resources.User " + user.getFirstName() + " " + user.getLastName() + " is logged in");
                    return true;
                }
            }
            System.out.println("resources.User with login " + login + " and password " + password + " is not found");
            return false;
        }
}
