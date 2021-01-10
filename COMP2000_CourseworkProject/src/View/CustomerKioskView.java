package View;

import javax.swing.*;
import java.awt.*;

public class CustomerKioskView {

    //region CustomerKioskView GUI JAttributes
    private JPanel MainKioskPanel;
    private JPanel KioskPanel;
    private JPanel CashPaymentPanel;
    private JPanel CardPaymentPanel;
    private JPanel ReceiptPanel;

    private JButton btnKioskAdd;
    private JButton btnCardPurchases;
    private JButton btnCashPurchase;
    private JButton btnKioskReturn;
    private JButton btnSubmitCash;
    private JButton btnCardSubmit;

    private JTextField txtKioskStockName;
    private JTextField txtKioskPrice;
    private JTextField txtCashAmount;
    private JTextField txtCardName;
    private JTextField txtCardNumber;
    private JTextField txtBarcodeScan;

    private JList lstAllPurchasedStock;
    private JList lstShoppingCart;

    private JLabel lblCompanyName;
    private JLabel lblCurrentDate;
    private JLabel lblPaymentChoice;
    private JLabel lblCashChange;
    private JLabel lblTotalCost;
    private JComboBox cbBank;
    //endregion

    public JFrame kioskFrame;
    CardLayout cardLayout = new CardLayout();

    public CustomerKioskView(String AdminMenu){
        //Set our card layout and add our Panels to it!
        MainKioskPanel.setLayout(cardLayout);
        MainKioskPanel.add(KioskPanel, "CustomerKioskPanel");
        MainKioskPanel.add(CashPaymentPanel, "CashPaymentPanel");
        MainKioskPanel.add(CardPaymentPanel, "CardPaymentPanel");
        MainKioskPanel.add(ReceiptPanel, "ReceiptPanel");
        cardLayout.show(MainKioskPanel, "1");

        //Create our form layout
        kioskFrame = new JFrame(AdminMenu);
        kioskFrame.add(MainKioskPanel);
        kioskFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        kioskFrame.setSize(500, 500);
        kioskFrame.setLocationRelativeTo(null);
        kioskFrame.pack();
        kioskFrame.setVisible(true);
    }

    //region Get/Set Methods
    public JTextField getTxtBarcodeScan(){
        return txtBarcodeScan;
    }

    public void setTxtBarcodeScan(JTextField txtBarcodeScans){
        this.txtBarcodeScan = txtBarcodeScans;
    }
    //endregion
}
