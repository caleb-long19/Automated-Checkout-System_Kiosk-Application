package com.Model;


import com.Model.IKiosk;
import com.View.StockDatabase;

public interface IAutomatedCheckoutSystem extends IKiosk {
    IKiosk getKioskUserInterface();

    void setKioskUserInterface(IKiosk value);

    StockDatabase getStockDatabase();

    void setStockDatabase(StockDatabase value);

}
