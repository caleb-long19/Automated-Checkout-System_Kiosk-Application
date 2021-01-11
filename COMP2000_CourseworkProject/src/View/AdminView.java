package View;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminView {

    //region GUI JAttributes
    public JFrame adminFrame;
    public JPanel AdminPanel;
    public JPanel LoginPanel;
    public JPanel AdminDatabasePanel;
    private JTabbedPane adminTabbedPane;

    private JTextField txtUsername;
    private JTextField txtPassword;
    private JTextField txtAdminBarcode;
    private JTextField txtAdminStockName;
    private JTextField txtAdminQuantity;
    private JTextField txtAdminPrice;
    public JTextField txtEditBarcode;
    public JTextField txtEditName;
    public JTextField txtEditQuantity;
    public JTextField txtEditPrice;
    public JTextField txtViewBarcode;
    public JTextField txtViewName;
    public JTextField txtViewQuantity;
    public JTextField txtViewPrice;
    private JLabel lblDetailsIncorrect;

    private JButton btnLogin;
    private JButton btnExit;
    private JButton btnAdminSubmit;
    private JButton btnRemoveItem;
    private JButton btnEditItem;
    private JButton btnAddItem;

    public JList lstStockEditDisplay;
    public JList lstDisplayStock;
    public JButton btnRefresh;
    public JButton btnDelivery;
    //endregion

    CardLayout cardLayout = new CardLayout();

    public AdminView(String AdminMenu){

        //Create the principle form
        AdminPanel.setLayout(cardLayout);
        AdminPanel.add(LoginPanel, "AdminLoginPage");
        AdminPanel.add(AdminDatabasePanel, "AdminDatabasePage");
        cardLayout.show(AdminPanel, "1");

        //Create the principle form
        adminFrame = new JFrame(AdminMenu);
        adminFrame.add(AdminPanel);
        adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adminFrame.setSize(500, 400);
        adminFrame.setVisible(true);

        GUIMethods();
    }

    //region AdminView GUI Methods
    public void GUIMethods(){
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               System.exit(0);
            }
        });
    }
    //endregion

    //region Get/Set Methods
    //region CardLayout Get/Set Methods
    public CardLayout getCardLayout(){
        return cardLayout;
    }

    public void setCardLayout(CardLayout cardLayoutNew){
        this.cardLayout = cardLayoutNew;
    }
    //endregion

    //region Get/Set Admin Username & Password Methods
    public JTextField getTxtUsername(){
        return txtUsername;
    }

    public void setTxtUsername(JTextField txtAdminUsername){
        this.txtUsername = txtAdminUsername;
    }

    public JTextField getTxtPassword(){
        return txtPassword;
    }

    public void setTxtPassword(JTextField txtAdminPassword){
        this.txtPassword = txtAdminPassword;
    }
    //endregion

    //region Button Get/Set Methods
    public JButton getBtnAdminSubmit(){
        return btnAdminSubmit;
    }

    public void setBtnAdminSubmit(JButton btnSubmitAdmin){
        this.btnAdminSubmit = btnSubmitAdmin;
    }

    public JButton getBtnAddItem(){
        return btnAddItem;
    }

    public void setBtnAddItem(JButton btnAdd){
        this.btnAdminSubmit = btnAdd;
    }

    public JButton getBtnRemoveItem(){
        return btnRemoveItem;
    }

    public void setBtnRemoveItem(JButton btnRemove){
        this.btnRemoveItem = btnRemove;
    }

    public JButton getBtnEditItem(){
        return btnEditItem;
    }

    public void setBtnEditItem(JButton btnEditItem){
        this.btnRemoveItem = btnEditItem;
    }

    public JButton getBtnLogin(){
        return btnLogin;
    }

    public void setBtnLogin(JButton btnALogin){
        this.btnLogin = btnALogin;
    }
    //endregion

    //region Text Box and label Boxes Get/Set Methods
    public JTextField getTxtAdminBarcode(){
        return txtAdminBarcode;
    }

    public void setTxtAdminBarcode(JTextField txtAdminBarcodes){
        this.txtAdminBarcode = txtAdminBarcodes;
    }

    public JTextField getTxtAdminStockName(){
        return txtAdminStockName;
    }

    public void setTxtAdminStockName(JTextField txtAdminStockNames){
        this.txtAdminStockName = txtAdminStockNames;
    }

    public JTextField getTxtAdminQuantity(){
        return txtAdminQuantity;
    }

    public void setTxtAdminQuantity(JTextField txtAdminStockQuantity){
        this.txtAdminQuantity = txtAdminStockQuantity;
    }

    public JTextField getTxtAdminPrice(){
        return txtAdminPrice;
    }

    public void setTxtAdminPrice(JTextField txtAdminPrices){
        this.txtAdminPrice = txtAdminPrices;
    }

    public JLabel getLblDetailsIncorrect(){
        return lblDetailsIncorrect;
    }

    public void setLblDetailsIncorrect(JLabel lblDetailsIncorrect){
        this.lblDetailsIncorrect = lblDetailsIncorrect;
    }
    //endregion

    //region JList Get/Set Methods
    public JList getLstStockEditDisplay() {
        return lstStockEditDisplay;
    }

    public void setLstStockEditDisplay(JList listStockEditDisplay){
        this.lstStockEditDisplay = listStockEditDisplay;
    }

    public JList getLstDisplayStock() {
        return lstDisplayStock;
    }

    public void setLstDisplayStock(JList listStockDisplay){
        this.lstDisplayStock = listStockDisplay;
    }

    //endregion
    //endregion
}
