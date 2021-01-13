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
        for (int index = 0; index < stockItems.size(); index++) {
            stockItems.get(index).update(adminBarcodeInput, adminNameInput, adminQuantity, adminPrice);
        }
    }

    @Override
    public void Add(IStockOrders stockOrdersModel) {
        stockItems.add(stockOrdersModel);
    }

    @Override
    public void Edit(IStockOrders stockOrdersModel) {
        stockItems.add(stockOrdersModel);
    }

    @Override
    public void Remove(IStockOrders stockOrdersModel) {
        stockItems.remove(stockOrdersModel);
    }
}
    //endregion
