package Controller;

import Model.IPaymentMethod;

public class CashPayment implements IPaymentMethod {

    String CashAmount;

    public void Payment(){

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
