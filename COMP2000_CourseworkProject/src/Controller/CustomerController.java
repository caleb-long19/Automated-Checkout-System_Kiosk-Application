package Controller;

import Model.StockOrdersModel;
import View.CustomerKioskView;
import Model.CustomerModel;

import javax.swing.*;
import java.io.FileNotFoundException;

public class CustomerController {

    String BarcodeToInt;
    String storeBarcode;
    String separator = "\\|";
    boolean stockFound = false;

    StockDatabaseController stockDatabaseController;
    StockOrdersModel stockOrdersModel;
    CustomerModel customerModel;
    CustomerKioskView customerKioskView;

    public CustomerController(StockDatabaseController sdc, StockOrdersModel som, CustomerModel cm, CustomerKioskView ckv){
        this.stockDatabaseController = sdc;
        this.stockOrdersModel = som;
        this.customerModel = cm;
        this.customerKioskView = ckv;
    }

    public void  initCustomerController(){
        //Button presses call methods inside CustomerController Class
        customerKioskView.getBtnKioskAdd().addActionListener(e -> ScanStock());
        customerKioskView.getBtnCardPurchases().addActionListener(e -> CardPaymentOption());
        customerKioskView.getBtnCashPurchase().addActionListener(e -> CashPaymentOption());
    }

    public void ScanStock(){
        storeBarcode = customerKioskView.getTxtBarcodeScan().getText();
        customerModel.setScannedStock(storeBarcode);

        try{
            for (int i = 0; i < stockDatabaseController.allStockItems.toArray().length; i++)
            {
                int barcode= stockDatabaseController.allStockItems.get(i).getBarcode();
                if(storeBarcode.contains(Integer.toString(barcode))){
                    JOptionPane.showMessageDialog(null, "Item Found: " + stockDatabaseController.allStockItems.get(i).getName(), "Replenishing Stock", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void StockPayment(){

    }

    public void CardPaymentOption(){
        customerKioskView.getCardLayout().show(customerKioskView.MainKioskPanel, "CardPaymentPanel");
    }

    public void CashPaymentOption(){
        customerKioskView.getCardLayout().show(customerKioskView.MainKioskPanel, "CashPaymentPanel");
    }
}
