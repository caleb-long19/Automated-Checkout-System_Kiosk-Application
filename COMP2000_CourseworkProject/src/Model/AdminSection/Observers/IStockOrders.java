package Model.AdminSection.Observers;

public interface IStockOrders {
    void update(int barcode, String stockName, int quantity, double price);

    int getBarcode();
    String getStockName();
    int getStockQuantity();
    double getStockPrice();

    void setBarcode(int barcode);
    void setStockName(String stockName);
    void setQuantity(int quantity);
    void setStockPrice(double price);
}
