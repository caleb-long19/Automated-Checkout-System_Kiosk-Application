package Controller.Observable;

import Model.AdminSection.Observers.IStockOrders;
import java.util.ArrayList;

public class StockDatabaseSystem implements IStockDatabaseSystem {

    public final ArrayList<IStockOrders> stockItems = new ArrayList<IStockOrders>();

    private String adminNameInput;
    private int adminBarcodeInput;
    private int adminQuantity;
    private double adminPrice;
    //endregion

    public void setValues(int barcode, String stockName, int quantity, double price){
        adminBarcodeInput = barcode;
        adminNameInput = stockName;
        adminQuantity = quantity;
        adminPrice = price;

        sendUpdate();
    }

    public void sendUpdate(){
        //Store data
        for (IStockOrders stockItem : stockItems) {
            stockItem.update(adminBarcodeInput, adminNameInput, adminQuantity, adminPrice);
        }
    }

    //region Add/Remove methods used to Add or Remove a stock item from the array
    @Override
    public void Add(IStockOrders stockOrdersModel) {
        stockItems.add(stockOrdersModel);
    }

    @Override
    public void Remove(IStockOrders stockOrdersModel) {
        stockItems.remove(stockOrdersModel);
    }
    //endregion
}
    //endregion
