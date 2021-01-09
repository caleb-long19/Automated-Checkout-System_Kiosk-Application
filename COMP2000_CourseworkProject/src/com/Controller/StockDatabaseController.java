package Controller;

import Model.IStockDatabaseController;
import Model.StockOrdersModel;
import View.AdminView;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StockDatabaseController implements IStockDatabaseController {

    public final ArrayList<StockOrdersModel> allStockItems = new ArrayList<StockOrdersModel>();
    public String filepath = "resources\\StockItemsList.txt";
    public String separator = "\\|";

    private StockOrdersModel stockOrdersModel;
    public AdminView adminView;

    public StockDatabaseController(StockOrdersModel stockModel, AdminView adminV){
        stockOrdersModel = stockModel;
        adminView = adminV;
        adminView.getBtnAddItem().addActionListener(e -> Add());
        adminView.getBtnRemoveItem().addActionListener(e -> Remove());
    }

    //region Add, Edit, and Remove Functions
    public void Add() {
        System.out.println("Button Pressed...");

        StockOrdersModel stockItem = new StockOrdersModel(2, "Bacon", 200, 3.99);

        stockItem.setBarcode(Integer.parseInt(adminView.getTxtAdminBarcode().getText()));
        stockItem.setName(adminView.getTxtAdminStockName().getText());
        stockItem.setQuantity(Integer.parseInt(adminView.getTxtAdminQuantity().getText()));
        stockItem.setPrice(Double.parseDouble(adminView.getTxtAdminPrice().getText()));

        //Add Stock Item data (Barcode, Name, Quantity, and Price to allStockItems ArrayList)
        addNewStockItem(stockItem);

        //Read new Stock Item into StockItemsList.txt
        saveKioskStock();

        //Display a Message Dialog to inform the Admin that a Stock Item has been Added!
        JOptionPane.showMessageDialog(null, "New Item Added: " + stockOrdersModel.getName(),"Stock Addition", JOptionPane.INFORMATION_MESSAGE);
    }

    public void Edit() {

    }

    public void Remove() {
        StockOrdersModel removeStock = getStockAt(0);
        removeStockItem(removeStock);
        saveKioskStock();
    }
    //endregion

    //region Load/Save File Data Methods
    public void LoadKioskData() {
        try{
            File file = new File(filepath);

            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String tableRow = scanner.nextLine();

                String[] StockItemDetails = tableRow.split(separator);

                StockOrdersModel stockItem = new StockOrdersModel(1, "Cake", 200, 3.99);

                int BarcodeToInt = Integer.parseInt(StockItemDetails[0]);
                stockItem.setBarcode(BarcodeToInt);

                stockItem.setName(StockItemDetails[1]);

                int quantityToInt = Integer.parseInt(StockItemDetails[2]);
                stockItem.setQuantity(quantityToInt);

                double priceToDouble = Double.parseDouble(StockItemDetails[3]);
                stockItem.setPrice(priceToDouble);

                allStockItems.add(stockItem);
            }
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public void saveKioskStock(){
        try{
            FileWriter writer = new FileWriter(filepath);

            for(int index = 0; index < allStockItems.size(); index++){
                String dataRow = "";

                if(index > 0){
                    dataRow += "\n";
                }

                dataRow += allStockItems.get(index).getBarcode();

                String nameToString = allStockItems.get(index).getName();
                dataRow += "|" + nameToString;

                String quantityToString = Integer.toString(allStockItems.get(index).getQuantity());
                dataRow += "|" + quantityToString;

                String priceToString = Double.toString(allStockItems.get(index).getPrice());
                dataRow += "|" + priceToString;

                writer.write(dataRow);
            }
            writer.close();
            System.out.println("Stock File has been saved!");

        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    //endregion

    //region Retrieve, Add, and Remove Stock
    public StockOrdersModel getStockAt(int index){
        if(index >= allStockItems.size()){
            return null;
        }
        return allStockItems.get(index);
    }

    public void addNewStockItem(StockOrdersModel newItem){
        allStockItems.add(newItem);
    }

    public void removeStockItem(StockOrdersModel stockOutOfDate){
        allStockItems.remove(stockOutOfDate);
    }
    //endregion
}
