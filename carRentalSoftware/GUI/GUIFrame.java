package GUI;

import authentication.LoginAuthenticator;
import resources.User;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUIFrame extends JFrame {

    LoginAuthenticator loginAuthenticator = new LoginAuthenticator();
    CardLayout cardLayout = new CardLayout();
    LoginPanel loginPanel = new LoginPanel();
    Menu menu = new Menu();
    AddCar addCar = new AddCar();
    static int FrameWidth = 1080;
    static int FrameHeight = 720;
    static private String userLogin;
    static private String userPassword;


    public GUIFrame(ArrayList<User> users) {

        // Set the title of the JFrame
        super("Car Rental Software");

        // Create a JPanels
        JPanel loginSwitch = new JPanel(cardLayout);
        JPanel contentSwitch = new JPanel(cardLayout);
        JPanel blankPage = new JPanel();
        JPanel downloadClientList = new JPanel();

        JLabel downloadClientListLabelSuccess = new JLabel("Client list downloaded to file clients.txt");
        JLabel downloadClientListLabelFail = new JLabel("Could not download client list");

        downloadClientList.setLayout(new GridLayout());

        JSplitPane menuSplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, menu, contentSwitch);
        menuSplit.setDividerLocation(FrameWidth/5);
        menuSplit.setEnabled(false);

        loginSwitch.add(loginPanel, "login");
        loginSwitch.add(menuSplit, "menuSplit");

        contentSwitch.add(blankPage, "blankPage");
        contentSwitch.add(downloadClientList, "downloadClientList");
        contentSwitch.add(addCar, "addCar");



        // Add action listener to button
        loginPanel.loginButton.addActionListener(new ActionListener() {  // KLASA ANONIMOWA
            @Override
            public void actionPerformed(ActionEvent e) {
                loginAuthenticator.selectBaseOfUsers(users);
                if(loginAuthenticator.authenticate(loginPanel.loginField.getText(), loginPanel.passwordField.getText())){
                    userLogin = loginPanel.loginField.getText();
                    userPassword = loginPanel.passwordField.getText();
                    cardLayout.show(loginSwitch, "menuSplit");
                }
            }
        });

        menu.logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(loginAuthenticator.logout(userLogin, userPassword)){
                    loginPanel.loginField.setText("");
                    loginPanel.passwordField.setText("");
                    cardLayout.show(loginSwitch, "login");
                }
            }
        });

        menu.addCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentSwitch, "addCar");
            }
        });

        menu.downloadClientListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (User.Users.saveUsersToFile("clients.txt")) {
                    downloadClientList.remove(downloadClientListLabelFail);
                    downloadClientList.add(downloadClientListLabelSuccess);
                    cardLayout.show(contentSwitch, "downloadClientList");
                } else {
                    downloadClientList.remove(downloadClientListLabelSuccess);
                    downloadClientList.add(downloadClientListLabelFail);
                    cardLayout.show(contentSwitch, "downloadClientList");
                }
            }
        });

        // Set the content pane of the JFrame
        setContentPane(loginSwitch);
        // Set the size of the JFrame
        setSize(FrameWidth, FrameHeight);
        setMinimumSize(new Dimension(FrameWidth / 4, FrameHeight / 4));
        // Set the default close operation of the JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set the JFrame to be visible
        setVisible(true);
    }

    public static int getFrameHeight() {
        return FrameHeight;
    }

    public static int getFrameWidth() {
        return FrameWidth;
    }
}
