package Controller;

import Model.IPaymentMethod;
import Model.StockOrdersModel;
import View.CustomerKioskView;

import javax.swing.*;

public class CashPayment implements IPaymentMethod {

    //region Objects and Variables
    //region Class Objects
    CustomerKioskView customerKioskView;
    CustomerController customerController;
    StockOrdersModel stockOrdersModel;
    //endregion

    //region Variables
    Double CashAmount;
    Double totalCashRequired;
    Double Change;
    boolean cashPayTrue = false;
    //endregion
    //endregion

    public CashPayment(CustomerKioskView ckv, CustomerController cc,  StockOrdersModel som){
        customerKioskView = ckv;
        customerController = cc;
        stockOrdersModel = som;
        customerKioskView.btnSubmitCash.addActionListener(e -> Payment());
    }

    public void Payment(){
        totalCashRequired = customerController.getTotalItemPrices();
        CashAmount = Double.parseDouble(customerKioskView.getTxtCashAmount().getText());

        Change = totalCashRequired - CashAmount;
        System.out.println(Change);

        if(Change == 0){
            System.out.println("No change required!");
        }else if(Change >= 0){
            JOptionPane.showMessageDialog(null, "Product still not paid, You still owe: " + Change,"Replenishing Stock", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            System.out.println("Your Change: " + Change);
        }
        cashPayTrue = true;
        setCashAmount(Change);
    }

    //region Get/Set Methods
    public Double getCashAmount(){
        return CashAmount;
    }

    public void setCashAmount(Double cash){
        this.CashAmount = cash;
    }
    //endregion
}
