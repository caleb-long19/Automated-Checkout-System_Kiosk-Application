package Controller;

import Model.IPaymentMethod;
import Model.StockOrdersModel;
import View.CustomerKioskView;

import javax.swing.*;

public class CardPayment implements IPaymentMethod {

    //region Variables
    String BankNumber;
    String CustomerName;
    String VerificationMessage = "Verifying Your Details: ";
    boolean cardPayTrue = false;
    JComboBox Bank;
    //endregion

    CustomerKioskView customerKioskView;
    StockOrdersModel stockOrdersModel;

    public CardPayment(CustomerKioskView ckv, StockOrdersModel som){
        this.customerKioskView = ckv;
        this.stockOrdersModel = som;
        customerKioskView.btnCardSubmit.addActionListener(e -> Payment());
    }

    public void Payment(){
        setBank(customerKioskView.getCbBank());
        if(customerKioskView.txtCardName.getText().equals("") || customerKioskView.txtCardNumber.getText().equals("")){
            JOptionPane.showMessageDialog(null, VerificationMessage + getBank().getModel().getSelectedItem() + ": Your Details Are Invalid!","Verification Screen", JOptionPane.INFORMATION_MESSAGE);
        }else{
            StoreBankDetails();
        }
    }

    public void StoreBankDetails(){
        cardPayTrue = true;
        setBank(customerKioskView.getCbBank());
        setCustomerName(customerKioskView.getTxtCardName().getText());
        setBankNumber(customerKioskView.getTxtCardNumber().getText());JOptionPane.showMessageDialog(null, VerificationMessage + getBank().getModel().getSelectedItem() + ": Your Details Are Verified!!","Verification Screen", JOptionPane.INFORMATION_MESSAGE);
        System.out.println("Bank:" + getBank().getModel().getSelectedItem() + " Card Name:" + getCustomerName() + " Bank Number:" + getBankNumber());
    }

    //region Get/Set Methods
    public JComboBox getBank(){
        return Bank;
    }

    public void setBank(JComboBox Banks){
        this.Bank = Banks;
    }

    public String getBankNumber(){
        return BankNumber;
    }

    public void setBankNumber(String BankNumbers){
        this.BankNumber = BankNumbers;
    }

    public String getCustomerName(){
        return CustomerName;
    }

    public void setCustomerName(String CustomerNames){
        this.CustomerName = CustomerNames;
    }
    //endregion

}
