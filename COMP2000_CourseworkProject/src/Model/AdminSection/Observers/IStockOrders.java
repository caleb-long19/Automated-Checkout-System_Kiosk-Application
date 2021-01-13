package Model.AdminSection.Observers;

public interface IStockOrders {
    void update(int barcode, String stockName, int quantity, double price);
}
