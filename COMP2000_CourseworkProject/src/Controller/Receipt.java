package Controller;

import Model.IPaymentMethod;
import View.CustomerKioskView;


public class Receipt implements IPaymentMethod {

    //region Objects and Attributes
    //region Class Objects
    CustomerController customerController;
    CustomerKioskView customerKioskView;
    CardPayment cardPayment;
    CashPayment cashPayment;
    //endregion

    //region String Variables
    String CompanyName;
    String Date;
    String PaymentOption;
    String Change;
    String TotalCost;
    //endregion

    Thread verifyData = new Thread();
    //endregion

    public Receipt(CustomerController cc, CustomerKioskView ckv, CardPayment cardp, CashPayment cashp) {
        customerController = cc;
        customerKioskView = ckv;
        cardPayment = cardp;
        cashPayment = cashp;
        customerKioskView.btnCardSubmit.addActionListener(e -> Payment());
        customerKioskView.btnSubmitCash.addActionListener(e -> Payment());
    }

    //region Payment, PrintourData, and VerifyReceiptData Methods
    public void Payment() {
        if(cardPayment.cardPayTrue){
            VerifyReceiptData();
        }else if(cashPayment.cashPayTrue){
            VerifyReceiptData();
        }
    }

    public void PrintoutData() {
        customerKioskView.lblCompanyName.setText(getCompanyName());
        customerKioskView.lblCurrentDate.setText(getDate());
        customerKioskView.lblPaymentChoice.setText(getPaymentOption());
        customerKioskView.lblCashChange.setText(getChange());
        customerKioskView.lblTotalCost.setText(getTotalCost());
    }

    public void VerifyReceiptData() {
        try {
            verifyData.start();
            Thread.sleep(500);
            setCompanyName("Caleb's Shopping Kiosk");
            setDate("11/01/2021");

            Thread.sleep(500);
                if(cardPayment.cardPayTrue){
                    setPaymentOption("Credit Card");
                    setChange("£0.00");
                }else if(cashPayment.cashPayTrue){
                    setPaymentOption("Cash");
                    setChange("£" + cashPayment.getCashAmount().toString());
                }
                Thread.sleep(500);
                setTotalCost(customerController.getTotalItemPrices().toString());
        } catch (Exception e) {
            System.out.print(e);
        }
        if (verifyData.isAlive()) {
            System.out.println("Thread is still open!");
        } else {
            PrintoutData();
            customerKioskView.getCardLayout().show(customerKioskView.MainKioskPanel, "ReceiptPanel");
        }
    }
    //endregion

    //region Get/Set Methods
    public String getCompanyName(){
        return CompanyName;
    }

    public void setCompanyName(String companyName){
        this.CompanyName = companyName;
    }

    public String getDate(){
        return Date;
    }

    public void setDate(String date){
        this.Date = date;
    }

    public String getPaymentOption(){
        return PaymentOption;
    }

    public void setPaymentOption(String paymentOption){
        this.PaymentOption = paymentOption;
    }

    public String getChange(){
        return Change;
    }

    public void setChange(String change){
        this.Change = change;
    }

    public String getTotalCost(){
        return TotalCost;
    }

    public void setTotalCost(String totalCost){
        this.TotalCost = totalCost;
    }
    //endregion

}
