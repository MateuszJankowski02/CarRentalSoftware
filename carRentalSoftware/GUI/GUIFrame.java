package GUI;

import utility.LoginAuthenticator;
import utility.Raport;
import resources.User;
import resources.Client;
import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

public class GUIFrame extends JFrame {

    LoginAuthenticator loginAuthenticator = new LoginAuthenticator();
    CardLayout cardLayout = new CardLayout();
    LoginPanel loginPanel = new LoginPanel();
    ClientList clientList = new ClientList();
    LeaseCar leaseCar = new LeaseCar();
    Menu menu = new Menu();
    AddClient addClient = new AddClient(clientList);
    RemoveCar removeCar = new RemoveCar();
    AddCar addCar = new AddCar(removeCar);

    static int FrameWidth = 1600;
    static int FrameHeight = 900;
    static private String userLogin;
    static private String userPassword;
    static private String message;


    public GUIFrame(ArrayList<User> users) {

        // Set the title of the JFrame
        super("Car Rental Software");

        setUIFont(new Font("Verdana", Font.BOLD, 14));

        // set font to verdana
        setFont(new Font("Verdana", Font.PLAIN, 12));

        // Set the background color of the JFrame
        setBackground(new Color(173, 214, 230));

        // Create a JPanels
        JPanel loginSwitch = new JPanel(cardLayout);
        JPanel contentSwitch = new JPanel(cardLayout);
        JPanel blankPage = new JPanel();

        blankPage.setBackground(new Color(173, 214, 230));

        JSplitPane menuSplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, menu, contentSwitch);
        menuSplit.setDividerLocation(FrameWidth/5);
        menuSplit.setEnabled(false);

        loginSwitch.add(loginPanel, "login");
        loginSwitch.add(menuSplit, "menuSplit");

        contentSwitch.add(blankPage, "blankPage");
        contentSwitch.add(addCar, "addCar");
        contentSwitch.add(removeCar, "removeCar");
        contentSwitch.add(leaseCar, "leaseCar");
        contentSwitch.add(clientList, "clientList");
        contentSwitch.add(addClient, "addClient");


        // Add action listener to button
        loginPanel.loginButton.addActionListener(new ActionListener() {  // KLASA ANONIMOWA
            @Override
            public void actionPerformed(ActionEvent e) {
                loginAuthenticator.selectBaseOfUsers(users);
                if(loginAuthenticator.authenticate(loginPanel.loginField.getText(), loginPanel.passwordField.getText())){
                    userLogin = loginPanel.loginField.getText();
                    userPassword = loginPanel.passwordField.getText();
                    message = "User " + userLogin + " logged in";
                    Raport.saveToFile(message);
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
                    message = "User " + userLogin + " logged out";
                    Raport.saveToFile(message);
                    cardLayout.show(loginSwitch, "login");
                }
            }
        });

        menu.clientListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
                revalidate();
                clientList.refreshClientList(clientList);
                cardLayout.show(contentSwitch, "clientList");
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
                removeCar.refreshCars(removeCar);
                cardLayout.show(contentSwitch, "removeCar");
            }
        });

        menu.leaseCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
                revalidate();
                LeaseCarCars.refreshCars(leaseCar.leaseCarCars, leaseCar);
                LeaseCarClients.refreshClientList(leaseCar.leaseCarClients, leaseCar);
                leaseCar.showLeaseCarCars();
                cardLayout.show(contentSwitch, "leaseCar");
            }
        });

        menu.downloadClientListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
                revalidate();
                if (Client.Clients.downloadClients("clientsList.txt")) {
                    message = "Client list downloaded to file clientsList.txt";
                    Raport.saveToFile(message);
                    JOptionPane.showMessageDialog(null, "Client list downloaded to file clientsList.txt");
                } else {
                    message = "Could not download client list";
                    Raport.saveToFile(message);
                    JOptionPane.showMessageDialog(null, "Could not download client list");
                }
            }
        });

        menu.addClientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
                revalidate();
                cardLayout.show(contentSwitch, "addClient");
            }
        });

        menu.serializeUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
                revalidate();
                if (User.Users.serializeUsers(users, "usersList.txt")) {
                    message = "User list serialized to file usersList.txt";
                    Raport.saveToFile(message);
                    JOptionPane.showMessageDialog(null, "User list serialized to file usersList.txt");
                } else {
                    message = "Could not serialize user list";
                    Raport.saveToFile(message);
                    JOptionPane.showMessageDialog(null, "Could not serialize user list");
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
    public static void setUIFont(Font font) {
        Enumeration<Object> keys = UIManager.getDefaults().keys();
        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value instanceof FontUIResource) {
                UIManager.put(key, font);
            }
        }
    }
}
