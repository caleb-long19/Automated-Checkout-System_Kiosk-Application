package Controller;

import View.CustomerKioskView;
import Model.CustomerModel;

public class CustomerController {

    CustomerModel customerModel;
    CustomerKioskView customerKioskView;

    public CustomerController(CustomerModel cm, CustomerKioskView ckv){
        this.customerModel = cm;
        this.customerKioskView = ckv;
    }

    public void ScanStock(){

    }

    public void StockPayment(){

    }

    public void PaymentOption(){

    }
}
