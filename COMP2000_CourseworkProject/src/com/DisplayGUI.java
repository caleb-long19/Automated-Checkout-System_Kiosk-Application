package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisplayGUI extends CardLayout{

    private JFrame MainPanel = new JFrame("Main Panel");
    CardLayout cardLayout = new CardLayout();

    private JPanel MainDisplayPanel;
    private JPanel LandingPage;
    private JPanel KioskPage;
    private JPanel AdminLogin;
    private JPanel StockAdminPage;

    private JButton btnAdminLogin;
    private JButton btnCustomerKiosk;
    private JButton btnAdminSubmit;
    private JButton btnKioskReturn;

    private JTextField txtBarcode;
    private JTextField txtStockName;
    private JTextField txtStockPrice;
    private JTextArea txtTotalPrice;
    private JTextField txtUsername;
    private JTextField txtPassword;
    private JButton btnExit;
    private JButton btnLogout;


    public DisplayGUI(){
        MainDisplayPanel.setLayout(cardLayout);
        MainDisplayPanel.add(LandingPage, "LandingPage");
        MainDisplayPanel.add(KioskPage, "KioskPage");
        MainDisplayPanel.add(AdminLogin, "AdminLoginPage");
        MainDisplayPanel.add(StockAdminPage, "AdminPage");

        cardLayout.show(MainDisplayPanel, "1");

        //Set the Content Panel to our JPanels
        MainPanel.add(MainDisplayPanel);
        MainPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainPanel.setPreferredSize(new Dimension(650, 550));
        MainPanel.pack();
        MainPanel.setVisible(true);

        // Button which is used to take the customer to the Kiosk Page
        btnCustomerKiosk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(MainDisplayPanel, "KioskPage");
            }
        });

        // Button which is used to take the User to the Admin Login Page
        btnAdminLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(MainDisplayPanel, "AdminLoginPage");
            }
        });

        btnAdminSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(MainDisplayPanel, "AdminPage");
            }
        });

        btnKioskReturn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(MainDisplayPanel, "LandingPage");
            }
        });

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(MainDisplayPanel, "LandingPage");
            }
        });
        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(MainDisplayPanel, "LandingPage");
            }
        });
    }

    public static void main(String[] args){
        new DisplayGUI();
    };
}
