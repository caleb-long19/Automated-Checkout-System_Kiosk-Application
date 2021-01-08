package com.View;

import com.Model.AdminUsers;
import com.Model.StockDatabase;
import com.Model.StockOrders;
import org.w3c.dom.Text;

import javax.naming.Name;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckoutSystemGUI extends CardLayout{

    public JFrame MainPanel = new JFrame("Main Panel");
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
    public JButton btnAddStockItem;
    public JButton btnRemoveStockItem;
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

    public JTextField txtBarcode;
    public JTextField txtStockName;
    public JTextField txtStockPrice;
    public JTextField txtUsername;
    public JTextField txtPassword;
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
    public JTextField txtQuantity;
    private JLabel lblLoginError;

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
        txtAreaAllStockItems.setLineWrap(true);
        MainPanel.add(MainDisplayPanel);
        MainPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainPanel.setPreferredSize(new Dimension(800, 500));
        MainPanel.pack();
        MainPanel.setVisible(true);

        DisplayStock();
        AddEditRemoveFunctions();
        selectLoginType();
        submitButtons();
        returnButtons();
    }

    public void DisplayStock(){
        StockOrders newStockDatabase = new StockOrders();

        txtAreaAllStockItems.setText(newStockDatabase.Name);
    }

    public void AddEditRemoveFunctions(){
        btnAddStockItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StockDatabase newStockDatabase = new StockDatabase();
                newStockDatabase.Add();
            }
        });

        btnRemoveStockItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StockDatabase newStockDatabase = new StockDatabase();
                newStockDatabase.Remove();
            }
        });

        btnSaveEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StockDatabase newStockDatabase = new StockDatabase();
                newStockDatabase.EditStock();
            }
        });
    }

    public void selectLoginType(){
        // Button which is used to take the customer to the Kiosk Page
        btnCustomerKiosk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(MainDisplayPanel, "KioskPage");
            }
        });

        btnAdminLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(MainDisplayPanel, "AdminLoginPage");
            }
        });

        btnAdminSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminUsers AdminManager = new AdminUsers();
                AdminManager.Login();

                if(txtUsername.getText().contains(AdminManager.getUsername()) && txtPassword.getText().contains(AdminManager.getPassword())){
                    cardLayout.show(MainDisplayPanel, "AdminPage");
                    System.out.println("Success: Correct Admin Details Provided!");
                }
                else{
                    lblLoginError.setText("Error: Incorrect Admin Details!");
                    System.out.println("Error: Incorrect Admin Details!");
                }
            }
        });
    }

    public void submitButtons(){
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
    }

    public void returnButtons(){
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
