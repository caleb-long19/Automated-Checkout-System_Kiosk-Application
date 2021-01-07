package com.View;

import java.util.ArrayList;
import java.util.List;

public class StockOrders {
    public int Barcode;

    public String Name;

    public int Quantity;

    public double Price;


    public int getBarcode(){
        return Barcode;
    }

    public void setBarcode(int barcode){
        this.Barcode = barcode;
    }

    public String getName(){
        return Name;
    }

    public void setName(String name){
        this.Name = name;
    }

    public int getQuantity(){
        return Quantity;
    }

    public void setQuantity(int quantity){
        this.Quantity = quantity;
    }

    public Double getPrice(){
        return Price;
    }

    public void setPrice(Double price){
        this.Price = price;
    }

    public List<Customer> customer = new ArrayList<Customer> ();

}
