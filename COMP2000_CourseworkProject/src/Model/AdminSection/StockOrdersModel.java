package Model.AdminSection;

public class StockOrdersModel {

    //region Variables
    public int Barcode;

    public String Name;

    public int Quantity;

    public double Price;
    //endregion

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
    //endregion
}
