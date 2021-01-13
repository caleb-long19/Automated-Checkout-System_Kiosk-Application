package Controller;

import Controller.Observable.StockDatabaseSystem;
import Model.AdminSection.Observers.StockOrders;
import View.AdminSection.AdminView;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StockDatabaseController {

    //region Variables and Class Objects
    public String filepath = "resources\\StockItemsList.txt";
    public String separator = "\\|";

    //Create a default list model called dm
    DefaultListModel<String> dm = new DefaultListModel<>();

    public final ArrayList<StockOrders> allStockItems = new ArrayList<>();
    StockDatabaseSystem sdss;
    public StockOrders som;
    private final AdminView av;
    //endregion

    public StockDatabaseController(StockDatabaseSystem sdss, StockOrders stockModel, AdminView adminV){
        this.sdss = sdss;
        som = stockModel;
        av = adminV;

        //Calls buttons from AdminView Class
        av.getBtnAddItem().addActionListener(e -> Add());
        av.getBtnEditItem().addActionListener(e -> Edit());
        av.getBtnRemoveItem().addActionListener(e -> Remove());
    }

    //region Add, Edit, and Remove Functions
    public void Add() {
        StockOrders NewStockItem = new StockOrders(sdss);

        //Stores the text that has been input into the txt boxes on the Admin Menu GUI!
        NewStockItem.setBarcode(Integer.parseInt(av.getTxtAdminBarcode().getText()));
        NewStockItem.setName(av.getTxtAdminStockName().getText());
        NewStockItem.setQuantity(Integer.parseInt(av.getTxtAdminQuantity().getText()));
        NewStockItem.setPrice(Double.parseDouble(av.getTxtAdminPrice().getText()));

        //Add Stock Item data (Barcode, Name, Quantity, and Price to allStockItems ArrayList)
        addNewStockItem(NewStockItem);

        //Write New Stock Item into StockItemsList.txt
        saveKioskStock();

        //Display a Message Dialog to inform the Admin that a Stock Item has been Added!
        JOptionPane.showMessageDialog(null, "New Item Added","Stock Addition", JOptionPane.INFORMATION_MESSAGE);
    }

    public void Edit() {
        //Retrieve the Users Input from the Text Boxes and store them into the Set values inside StockOrdersModel
        som = getStockAt(av.lstStockEditDisplay.getSelectedIndex());
        som.setBarcode(Integer.parseInt(av.txtEditBarcode.getText()));
        som.setName(av.txtEditName.getText());
        som.setQuantity(Integer.parseInt(av.txtEditQuantity.getText()));
        som.setPrice(Double.parseDouble(av.txtEditPrice.getText()));

        //Write data to text file
        saveKioskStock();
    }

    public void Remove() {
        //Create a StockOrdersModel Object called removeStock and store the selectedIndex value
        StockOrders removeValue = getStockAt(av.lstStockEditDisplay.getSelectedIndex());

        //Remove selectedIndex item from allstockitems array
        removeStockItem(removeValue);

        //Write to file to save change
        saveKioskStock();
    }
    //endregion

    //region Load/Save File Data Methods
    public void LoadKioskData() {
        try{
            File file = new File(filepath);

            Scanner scanner = new Scanner(file);

            //Run a while loop until no more text lines are found in the StockItemsList text file
            while (scanner.hasNextLine()) {
                String tableRow = scanner.nextLine();

                //Create a String array with a split to store separate values
                String[] StockItemDetails = tableRow.split(separator);

                //Create a new StockOrderModel object
                StockOrders stockItem = new StockOrders(sdss);

                //Store StockItemDetails Index 0 data into BarcodeToInt and store into setBarcode
                int BarcodeToInt = Integer.parseInt(StockItemDetails[0]);
                stockItem.setBarcode(BarcodeToInt);

                //Store StockItemDetails Index 1 data and store into setName
                stockItem.setName(StockItemDetails[1]);

                //Store StockItemDetails Index 02data into quantityToInt and store into setQuantity
                int quantityToInt = Integer.parseInt(StockItemDetails[2]);
                stockItem.setQuantity(quantityToInt);

                //Store StockItemDetails Index 3 data into priceToDouble and store into setPrice
                double priceToDouble = Double.parseDouble(StockItemDetails[3]);
                stockItem.setPrice(priceToDouble);

                //Add stock items to Array
                allStockItems.add(stockItem);
            }
            //Call Refresh Method
            Refresh();
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public void saveKioskStock(){
        try{
            FileWriter writer = new FileWriter(filepath);

            //For loop used to add a new item to end of text file which loops based on the size of the allstockitems array
            for(int index = 0; index < allStockItems.size(); index++){
                String dataRow = "";

                if(index > 0){
                    dataRow += "\n";
                }

                //Retrieve the Barcode, Name, Quantity and Price and insert them into the datarow String
                dataRow += allStockItems.get(index).getBarcode();

                String nameToString = allStockItems.get(index).getName();
                dataRow += "|" + nameToString;

                String quantityToString = Integer.toString(allStockItems.get(index).getQuantity());
                dataRow += "|" + quantityToString;

                String priceToString = Double.toString(allStockItems.get(index).getPrice());
                dataRow += "|" + priceToString;

                //Save new row into the StockItemsList text file
                writer.write(dataRow);
            }
            writer.close();
            System.out.println("Stock File has been saved!");
            Refresh();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    //endregion

    //region Refresh, Retrieve, Add, and Remove Stock
    public StockOrders getStockAt(int index){
        if(index >= allStockItems.size()){
            return null;
        }
        return allStockItems.get(index);
    }

    //Add new item to array
    public void addNewStockItem(StockOrders newItem){
        allStockItems.add(newItem);
    }

    //Remove item from array
    public void removeStockItem(StockOrders stockOutOfDate){
        allStockItems.remove(stockOutOfDate);
    }

    //Refresh
    public void Refresh(){
        //Retrieve the default list model and remove all elements
        dm.removeAllElements();

        //set the models for StockEditDisplay & DisplayStock Lists
        av.lstStockEditDisplay.setModel(dm);
        av.lstDisplayStock.setModel(dm);

        //Run a for loop based on the size of allstockitems array and add the stock items names to the default list model
        for (int i = 0; i < allStockItems.size(); i++)
        {
            String Name = allStockItems.get(i).getName();
            dm.addElement(Name);

        }
    }
    //endregion
}
