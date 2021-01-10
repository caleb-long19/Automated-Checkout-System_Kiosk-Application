package Model;

public class CustomerModel {

    String scannedStock;
    String cardPayment;
    String cashPayment;

    public CustomerModel(String stock){
        this.scannedStock = stock;
    }

    //region Get/Set Methods
    //region Get/Set Item Stock Methods
    public String getStock(){
        return scannedStock;
    }

    public void setScannedStock(String stocks){
        this.scannedStock = stocks;
    }
    //endregion

    //region Get/Set Card & Cash Methods
    public String getCardPayment(){
        return cardPayment;
    }

    public void setCardPayment(String cardChosen){
        this.cardPayment = cardChosen;
    }

    public String getCashPayment(){
        return cashPayment;
    }

    public void setCashPayment(String cashChosen){
        this.cashPayment = cashChosen;
    }
    //endregion
    //endregion
}
