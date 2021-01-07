package com.View;

import com.Model.IKiosk;
import com.Model.IStockDatabase;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StockDatabase implements IStockDatabase {
    public String StockItems;

    public AdminUsers AdminUsers;

    public String filepath = "resources\\StockItemsList.txt";

    public String separator = "\\|";

    private List<IKiosk> iKiosk = new ArrayList<IKiosk> ();

    public void Add() {
//begin of modifiable zone(JavaCode)......C/8b3d51fa-099e-4b22-a806-774ba9def241

//end of modifiable zone(JavaCode)........E/8b3d51fa-099e-4b22-a806-774ba9def241
    }

    public void Remove() {
//begin of modifiable zone(JavaCode)......C/266ad1af-2e37-45e1-a9f6-aeb589e895f5

//end of modifiable zone(JavaCode)........E/266ad1af-2e37-45e1-a9f6-aeb589e895f5
    }

    public void EditStock() {
//begin of modifiable zone(JavaCode)......C/99d75bda-ab10-47d2-8608-c622c28d0de7

//end of modifiable zone(JavaCode)........E/99d75bda-ab10-47d2-8608-c622c28d0de7
    }

    public void UpdateKiosk() {
        try{
        File file = new File(filepath);

        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String tableRow = scanner.nextLine();

            String[] StockItemDetails = tableRow.split(separator);
            System.out.println(StockItemDetails[0]);
            System.out.println(StockItemDetails[1]);
            System.out.println(StockItemDetails[2]);
            System.out.println(StockItemDetails[3]);
        }
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }

}
