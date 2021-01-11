package Controller;

import Model.StockOrdersModel;
import View.CustomerKioskView;
import Model.CustomerModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.util.Scanner;

public class CustomerController {

    //region Objects and Variables
    //region Class Objects
    StockDatabaseController stockDatabaseController;
    StockOrdersModel stockOrdersModel;
    CustomerModel customerModel;
    CustomerKioskView customerKioskView;
    //endregion

    //region Variables
    String storedBarcode;
    String itemName;
    String itemPrice;
    double totalItemPrices;
    //endregion

    String[] columnNames = {"Name", "Price"};
    //endregion

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
        DefaultTableModel model = (DefaultTableModel) customerKioskView.tblShoppingCart.getModel();
            try{
                File file = new File(stockDatabaseController.filepath);

                Scanner scanner = new Scanner(file);

                while (scanner.hasNextLine()) {
                    String tableRow = scanner.nextLine();

                    String[] StockItemDetails = tableRow.split(stockDatabaseController.separator);
                    customerModel.setScannedStock(customerKioskView.getTxtBarcodeScan().getText());

                    int BarcodeToInt = Integer.parseInt(StockItemDetails[0]);
                    storedBarcode = Integer.toString(BarcodeToInt);

                    for(int i = 0; i < stockDatabaseController.allStockItems.size(); i++){
                        if(customerModel.getScannedStockStock().equals(storedBarcode)){
                            itemName = stockDatabaseController.allStockItems.get(i).getName();
                            itemPrice = Double.toString(stockDatabaseController.allStockItems.get(i).getPrice());
                            stockDatabaseController.allStockItems.get(i).setQuantity(stockDatabaseController.allStockItems.get(i).getQuantity() - 1);
                            stockDatabaseController.saveKioskStock();

                            double totalPrice = Double.parseDouble(itemPrice);
                            totalItemPrices = totalItemPrices + totalPrice;
                            customerKioskView.txtTotalPrice.setText("£" + totalItemPrices);
                            setTotalItemPrices(totalItemPrices);
                            System.out.println("£" + totalItemPrices);
                            customerKioskView.lblPaymentDue.setText("You Owe: £" + Double.toString(totalItemPrices));

                            String[][] shoppingData = {{itemName, itemPrice}};
                            model.setDataVector(shoppingData, columnNames);
                            JOptionPane.showMessageDialog(null, "Item Added To Cart: " + itemName,"Replenishing Stock", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }
                if(storedBarcode != customerModel.getScannedStockStock()){
                    JOptionPane.showMessageDialog(null, "Item Not Found!","Replenishing Stock", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
    }

    public void StockPayment(){

    }

    //region Card/Cash Methods
    public void CardPaymentOption(){
        customerKioskView.getCardLayout().show(customerKioskView.MainKioskPanel, "CardPaymentPanel");
    }

    public void CashPaymentOption(){
        customerKioskView.getCardLayout().show(customerKioskView.MainKioskPanel, "CashPaymentPanel");
    }
    //endregion

    //region Get/Sets
    public Double getTotalItemPrices(){
        return totalItemPrices;
    }

    public void setTotalItemPrices(double totPrice){
        this.totalItemPrices = totPrice;
    }
    //endregion
}
