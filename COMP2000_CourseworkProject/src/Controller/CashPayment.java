package Controller;

import Model.IPaymentMethod;
import Model.StockOrdersModel;
import View.CustomerKioskView;

public class CashPayment implements IPaymentMethod {

    String CashAmount;

    CustomerKioskView customerKioskView;
    StockOrdersModel stockOrdersModel;

    public CashPayment(CustomerKioskView ckv, StockOrdersModel som){
        this.customerKioskView = ckv;
        this.stockOrdersModel = som;
        customerKioskView.btnSubmitCash.addActionListener(e -> Payment());
    }

    public void Payment(){
        setCashAmount(customerKioskView.getTxtCashAmount().getText());

        if(getCashAmount() == null){
            customerKioskView.getCardLayout().show(customerKioskView.MainKioskPanel, "ReceiptPanel");
        }
    }

    //region Get/Set Methods
    public String getCashAmount(){
        return CashAmount;
    }

    public void setCashAmount(String cash){
        this.CashAmount = cash;
    }
    //endregion
}
