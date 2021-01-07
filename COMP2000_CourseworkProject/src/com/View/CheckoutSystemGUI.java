package com.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckoutSystemGUI extends CardLayout{

    private JFrame MainPanel = new JFrame("Main Panel");
    CardLayout cardLayout = new CardLayout();

    private JPanel MainDisplayPanel;
    private JPanel LandingPage;
    private JPanel KioskPage;
    private JPanel AdminLogin;
    private JPanel StockAdminPage;
    private JPanel PurchasePage;
    private JPanel CardPaymentPage;
    private JPanel CashPaymentPage;
    private JPanel VerificationScreen;
    private JPanel ReceiptPage;

    private JButton btnAdminLogin;
    private JButton btnCustomerKiosk;
    private JButton btnAdminSubmit;
    private JButton btnReturn;
    private JButton btnExit;
    private JButton btnLogout;
    private JButton btnSaveEdit;
    private JButton btnAddStockItem;
    private JButton btnRemoveStockItem;
    private JButton btnPurchase;
    private JButton btnCashPayment;
    private JButton btnCardPayment;
    private JButton btnSubmitCard;
    private JButton btnCardReturn;
    private JButton btnPaymentReturn;
    private JButton btnCashReturn;
    private JButton btnReceipt;
    private JButton btnReceiptReturn;
    private JButton btnCashSubmit;

    private JTextField txtBarcode;
    private JTextField txtStockName;
    private JTextField txtStockPrice;
    private JTextField txtUsername;
    private JTextField txtPassword;
    private JTextField txtAddBarcode;
    private JTextField txtItemName;
    private JTextField txtItemPrice;
    private JTextField txtTotalPrice;
    private JTextField txtCardName;
    private JTextField txtCardNumber;
    private JTextField txtEnterCash;

    private JTextArea txtAreaAllStockItems;
    private JTextArea txtAreaTotalItems;
    private JTextArea txtAreaAllItems;

    private JLabel lblCompanyName;
    private JLabel lblPurchaseDate;
    private JLabel lblPaymentType;
    private JLabel lblCustomerName;
    private JLabel lblChange;

    private JComboBox cbChooseBank;

    public CheckoutSystemGUI(){
        MainDisplayPanel.setLayout(cardLayout);
        MainDisplayPanel.add(LandingPage, "LandingPage");
        MainDisplayPanel.add(KioskPage, "KioskPage");
        MainDisplayPanel.add(AdminLogin, "AdminLoginPage");
        MainDisplayPanel.add(StockAdminPage, "AdminPage");
        MainDisplayPanel.add(PurchasePage, "PaymentPage");
        MainDisplayPanel.add(CardPaymentPage, "CardPaymentPage");
        MainDisplayPanel.add(CashPaymentPage, "CashPaymentPage");
        MainDisplayPanel.add(VerificationScreen, "VerificationPage");
        MainDisplayPanel.add(ReceiptPage, "ReceiptPage");

        cardLayout.show(MainDisplayPanel, "1");

        //Set the Content Panel to our JPanels
        MainPanel.add(MainDisplayPanel);
        MainPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainPanel.setPreferredSize(new Dimension(600, 500));
        MainPanel.pack();
        MainPanel.setVisible(true);

        StockDatabase test3 = new StockDatabase();

        txtAreaAllStockItems.append(test3.StockItems);

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

        btnPurchase.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(MainDisplayPanel, "PaymentPage");
            }
        });

        btnCardPayment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(MainDisplayPanel, "CardPaymentPage");
            }
        });

        btnCashPayment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(MainDisplayPanel, "CashPaymentPage");
            }
        });

        btnSubmitCard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(MainDisplayPanel, "VerificationPage");
            }
        });

        btnCashSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(MainDisplayPanel, "ReceiptPage");
            }
        });

        btnReceipt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(MainDisplayPanel, "ReceiptPage");
            }
        });

        btnReturn.addActionListener(new ActionListener() {
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

        btnCardReturn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(MainDisplayPanel, "PaymentPage");
            }
        });

        btnCashReturn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(MainDisplayPanel, "PaymentPage");
            }
        });

        btnPaymentReturn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(MainDisplayPanel, "KioskPage");
            }
        });

        btnReceiptReturn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(MainDisplayPanel, "KioskPage");
            }
        });

        btnReceipt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(MainDisplayPanel, "ReceiptPage");
            }
        });
    }

    public static void main(String[] args){
        new CheckoutSystemGUI();
    };

}
