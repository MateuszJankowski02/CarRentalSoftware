package GUI;

import authentication.LoginAuthenticator;
import resources.User;
import resources.Client;
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
    RemoveCar removeCar = new RemoveCar(menu);
    AddCar addCar = new AddCar(removeCar);

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

        JSplitPane menuSplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, menu, contentSwitch);
        menuSplit.setDividerLocation(FrameWidth/5);
        menuSplit.setEnabled(false);

        loginSwitch.add(loginPanel, "login");
        loginSwitch.add(menuSplit, "menuSplit");

        contentSwitch.add(blankPage, "blankPage");
        contentSwitch.add(addCar, "addCar");
        contentSwitch.add(removeCar, "removeCar");



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
                    repaint();
                    revalidate();
                    loginPanel.loginField.setText("");
                    loginPanel.passwordField.setText("");
                    cardLayout.show(loginSwitch, "login");
                }
            }
        });

        menu.addCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
                revalidate();
                cardLayout.show(contentSwitch, "addCar");
            }
        });

        menu.removeCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
                revalidate();
                cardLayout.show(contentSwitch, "removeCar");
            }
        });

        menu.downloadClientListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
                revalidate();
                if (Client.Clients.downloadClients("clients.txt")) {
                    JOptionPane.showMessageDialog(null, "Client list downloaded to file clients.txt");
                } else {
                    JOptionPane.showMessageDialog(null, "Could not download client list");
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

    public static void labelInset(GridBagConstraints constraints){
        constraints.insets = new Insets(0, 20, 0, 20);
    }

    public static void defaultInset(GridBagConstraints constraints){
        constraints.insets = new Insets(20, 20, 20, 20);
    }
}
