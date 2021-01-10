package Controller;

import Model.StockOrdersModel;
import View.CustomerKioskView;
import Model.CustomerModel;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CustomerController {

    String BarcodeToInt;
    String storeBarcode;
    String separator = "\\|";

    boolean stockFound = false;
    int selectedIndex;

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
            File file = new File(stockDatabaseController.filepath);

            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String tableRow = scanner.nextLine();

                String[] StockItemDetails = tableRow.split(separator);

                BarcodeToInt = StockItemDetails[0];

                if(storeBarcode.contains(BarcodeToInt)){
                    selectedIndex = Integer.parseInt(BarcodeToInt);
                    stockFound = true;
                }
            }
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }

        if(stockFound){
            stockFound = false;
            //Display a Message Dialog to inform the Admin that a Stock Item has been Added!
            JOptionPane.showMessageDialog(null, "Item Added To Basket: " + stockOrdersModel.getName().contains(storeBarcode),"Stock Addition", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "Barcode Number Does Not Exist: Try Again!","Stock Basket", JOptionPane.INFORMATION_MESSAGE);
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
