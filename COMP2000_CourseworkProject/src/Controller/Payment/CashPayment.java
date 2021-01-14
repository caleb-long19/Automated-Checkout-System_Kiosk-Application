package Controller.Payment;

import Controller.Observable.StockDatabaseSystem;
import Model.ChoosePaymentSingleton;
import Model.CustomerSection.IPaymentMethod;
import Model.AdminSection.Observers.StockOrders;
import View.CustomerSection.CustomerKioskView;

import javax.swing.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class CashPayment implements IPaymentMethod {

    //region Objects and Variables
    //region Class Objects
    CustomerKioskView skv;
    CustomerController cc;
    StockDatabaseSystem sdc;
    StockOrders som;
    //endregion

    //region Variables
    Double CashAmount;
    Double totalCashRequired;
    Double Change;
    boolean cashPayTrue = false;

    NumberFormat formatter = new DecimalFormat("#0.00");
    //endregion
    //endregion

    public CashPayment(CustomerKioskView ckv, CustomerController cc, StockDatabaseSystem sdc, StockOrders som){
        skv = ckv;
        this.cc = cc;
        this.sdc = sdc;
        this.som = som;
    }

    public void initCashPayment(){
        //Listen for button press and run Payment Method
        skv.btnSubmitCash.addActionListener(e -> Payment());
    }

    //region Payment Method
    @Override
    public void Payment(){
        //IF the Cash Amount text box is empty, provide a warning for the user
        if(skv.txtCashAmount.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "No Cash Amount Has Been Entered!","Warning", JOptionPane.INFORMATION_MESSAGE);
        }
        else {

            //store the Total price of the customers items
            totalCashRequired = cc.getTotalItemPrices();

            //Store the users inserted amount of cash
            CashAmount = Double.parseDouble(skv.getTxtCashAmount().getText());

            //Remove the users cash from the total amount required cash and store it in Change
            Change = totalCashRequired - CashAmount;
        }

        if(Change <= 0){
            //set bool to true
            ChoosePaymentSingleton.getInstance().setCashOption(true);

            //Store Double Change in serCashAmount
            setCashAmount(Change);

            //Take user to the payment page
            skv.getCardLayout().show(skv.MainKioskPanel, "PaymentComplete");

            //Reset Text Box
            skv.txtCashAmount.setText("");
        }
        else if(Change > 0.01) {
            //Display Message Box to inform user
            JOptionPane.showMessageDialog(
                    null,
                    "Product still not paid, You still owe: " + formatter.format(Change),
                    "Replenishing Stock", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    //endregion

    //region Get/Set for the Users given cash amount
    public Double getCashAmount(){
        return CashAmount;
    }

    public void setCashAmount(Double cash){
        this.CashAmount = cash;
    }
    //endregion
}
