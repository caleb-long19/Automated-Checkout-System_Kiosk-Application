package com.Model;

import java.util.ArrayList;
import java.util.List;

public class StockOrders {
    public int Barcode;

    public String Name;

    public int Quantity;

    public double Price;

    //region All GET Methods for StockDatabase
    public int getBarcode(){
        return Barcode;
    }

    public String getName(){
        return Name;
    }

    public int getQuantity(){
        return Quantity;
    }

    public Double getPrice(){
        return Price;
    }
    //endregion

    //region All SET Methods for StockDatabase
    public void setBarcode(int barcode){
        this.Barcode = barcode;
    }

    public void setName(String name){
        this.Name = name;
    }

    public void setQuantity(int quantity){
        this.Quantity = quantity;
    }

    public void setPrice(Double price){
        this.Price = price;
    }
    //endregion

    public List<Customer> customer = new ArrayList<Customer> ();

}
