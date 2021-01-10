package Controller;

import Model.IPaymentMethod;

public class CardPayment implements IPaymentMethod {

    String VerificationMessage;
    String Bank;
    String BankNumber;
    String CustomerName;

    public void Payment(){

    }

    //region Get/Set Methods
    public String getBank(){
        return Bank;
    }

    public void setBank(String Banks){
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
