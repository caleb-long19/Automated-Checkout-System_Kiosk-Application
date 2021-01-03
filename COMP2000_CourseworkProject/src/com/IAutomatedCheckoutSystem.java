package com;


public interface IAutomatedCheckoutSystem extends IKiosk {
    IKiosk getKioskUserInterface();

    void setKioskUserInterface(IKiosk value);

    StockDatabase getStockDatabase();

    void setStockDatabase(StockDatabase value);

}
