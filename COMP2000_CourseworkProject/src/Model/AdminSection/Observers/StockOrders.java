package Model.AdminSection.Observers;

import Controller.Observable.IStockDatabaseSystem;

public class StockOrders implements IStockOrders {

    //region Variables
    public int Barcode;

    public String Name;

    public int Quantity;

    public double Price;
    //endregion

    public StockOrders(IStockDatabaseSystem stockDatabase){
        stockDatabase.Add(this);
    }

    //region All GET Methods for StockDatabase to retrieve stored file read Barcode, Name, Quantity, Price
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

    //region All SET Methods for StockDatabase to store file read Barcode, Name, Quantity, Price
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

    @Override
    public void update(int barcode, String stockName, int quantity, double price) {

        setBarcode(barcode);
        setName(stockName);
        setQuantity(quantity);
        setPrice(price);

        System.out.println("Barcode: " + barcode);
        System.out.println("Name: " + stockName);
        System.out.println("Quantity: " + quantity);
        System.out.println("Price: " + price);
    }
    //endregion
}
