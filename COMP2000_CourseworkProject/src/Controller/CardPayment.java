package Controller;

import Model.IPaymentMethod;
import Model.StockOrdersModel;
import View.CustomerKioskView;

import javax.swing.*;

public class CardPayment implements IPaymentMethod {

    private JComboBox Bank;
    private String BankNumber;
    private String CustomerName;

    CustomerKioskView customerKioskView;
    StockOrdersModel stockOrdersModel;

    public CardPayment(CustomerKioskView ckv, StockOrdersModel som){
        this.customerKioskView = ckv;
        this.stockOrdersModel = som;
        customerKioskView.btnCardSubmit.addActionListener(e -> Payment());
    }

    public void Payment(){
        StoreBankDetails();
    }

    public void StoreBankDetails(){
        setBank(customerKioskView.getCbBank());
        setCustomerName(customerKioskView.getTxtCardName().getText());
        setBankNumber(customerKioskView.getTxtCardName().getText());
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
