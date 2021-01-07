package com.View;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AdminUsers extends StockDatabase {
    public StockOrders StockOrders;

    public String Name;

    public String Password;

    public String filepath = "resources\\AdminUserLogins.txt";

    public String separator = "\\|";

    public void Login() {
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

    public void AccessStock() {
//begin of modifiable zone(JavaCode)......C/232cd6ac-ba42-49a6-95a3-03e619c504f1

//end of modifiable zone(JavaCode)........E/232cd6ac-ba42-49a6-95a3-03e619c504f1
    }

    public void OrderStock() {
//begin of modifiable zone(JavaCode)......C/e12f5406-a656-496e-81c0-99d4fa9132e0

//end of modifiable zone(JavaCode)........E/e12f5406-a656-496e-81c0-99d4fa9132e0
    }

    public void ReplenishStockWarning() {
//begin of modifiable zone(JavaCode)......C/808b4b7f-b94f-47a9-ba5d-b8a256cf5dc0

//end of modifiable zone(JavaCode)........E/808b4b7f-b94f-47a9-ba5d-b8a256cf5dc0
    }

    public void ReplenishStockOnDelivery() {
//begin of modifiable zone(JavaCode)......C/c7e30a81-a60b-4a4c-9528-971f3f6ac9c6

//end of modifiable zone(JavaCode)........E/c7e30a81-a60b-4a4c-9528-971f3f6ac9c6
    }

}
