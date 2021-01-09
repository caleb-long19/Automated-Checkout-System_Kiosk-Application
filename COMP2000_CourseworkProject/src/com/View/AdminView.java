package View;

import javax.swing.*;

public class AdminView {

    private JFrame adminFrame;
    private JPanel AdminPanel;
    private JTextField txtUsername;
    private JTextField txtPassword;
    private JButton btnAdminSubmit;
    private JTextField txtAdminBarcode;
    private JTextField txtAdminStockName;
    private JTextField txtAdminQuantity;
    private JTextField txtAdminPrice;
    private JButton btnAddItem;
    private JButton btnRemoveItem;
    private JButton btnEditItem;
    private JTextArea textArea1;
    private int selectedIndex;

    public AdminView(String AdminMenu){
        //Create the principle form
        adminFrame = new JFrame(AdminMenu);
        adminFrame.setContentPane(AdminPanel);
        adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adminFrame.setSize(500, 500);
        adminFrame.setLocationRelativeTo(null);
        adminFrame.setVisible(true);

        //Create UI Elements
        txtUsername = new JTextField();
        txtPassword = new JTextField();
        btnAdminSubmit = new JButton();

    }

    //region Get/Set Methods
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
    //endregion

    //region Text Box Get/Set Methods
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
    //endregion
    //endregion
}
