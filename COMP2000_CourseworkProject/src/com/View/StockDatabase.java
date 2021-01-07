package com.View;

import com.Model.IKiosk;
import com.Model.IStockDatabase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StockDatabase implements IStockDatabase {
    public String StockItems;

    public AdminUsers AdminUsers;

    public String filepath = "resources\\StockItemsList.txt";

    public String separator = "\\|";

    private List<IKiosk> iKiosk = new ArrayList<IKiosk> ();

    private final ArrayList<StockOrders> allStockItems = new ArrayList<StockOrders>();

    public void Add() {
        StockDatabase addItemManager = new StockDatabase();

        addItemManager.UpdateKiosk();

        StockOrders stockItem = new StockOrders();
        stockItem.setBarcode(20);
        stockItem.setName("Cake");
        stockItem.setQuantity(600);
        stockItem.setPrice(0.49);

        addItemManager.addNewStockItem(stockItem);

        addItemManager.saveStock();
        System.out.println(stockItem.Name);
    }

    public void Remove() {
        StockDatabase removeItemManager = new StockDatabase();

        removeItemManager.UpdateKiosk();

        StockOrders removeStock = removeItemManager.getStockAt(3);
        removeItemManager.removeStockItem(removeStock);

        removeItemManager.saveStock();
    }

    public void EditStock() {
        StockDatabase editStockItem = new StockDatabase();

        editStockItem.UpdateKiosk();

        StockOrders stockItem = editStockItem.getStockAt(1);
        stockItem.setBarcode(19);
        stockItem.setName("Peach");
        stockItem.setQuantity(400);
        stockItem.setPrice(0.99);

        editStockItem.saveStock();
    }

    public void UpdateKiosk() {
        try{
        File file = new File(filepath);

        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String tableRow = scanner.nextLine();

            String[] StockItemDetails = tableRow.split(separator);

            StockOrders stockItem = new StockOrders();

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

    public void saveStock(){
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

    public StockOrders getStockAt(int index){
        if(index >= allStockItems.size()){
            return null;
        }
        return allStockItems.get(index);
    }

    public void addNewStockItem(StockOrders newItem){
        allStockItems.add(newItem);
    }

    public void removeStockItem(StockOrders stockOutOfDate){
        allStockItems.remove(stockOutOfDate);
    }

}
