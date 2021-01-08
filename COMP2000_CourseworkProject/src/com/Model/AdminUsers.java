package com.Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AdminUsers extends StockDatabase {
    public StockOrders StockOrders;

    public String Name;

    public String Password;

    public String filepath = "resources\\AdminUserLogins.txt";

    public void Login() {
        try{
            File file = new File(filepath);

            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String tableRow = scanner.nextLine();

                String[] LoginDe = tableRow.split(separator);

                setName(LoginDe[0]);
                setPassword(LoginDe[1]);
            }
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public void AccessStock() {

    }

    public void OrderStock() {

    }

    public void ReplenishStockWarning() {

    }

    public void ReplenishStockOnDelivery() {

    }

    public String getUsername(){
        return Name;
    }

    public void setName(String username){
        this.Name = username;
    }

    public String getPassword(){
        return Password;
    }

    public void setPassword(String password){
        this.Password = password;
    }

}
