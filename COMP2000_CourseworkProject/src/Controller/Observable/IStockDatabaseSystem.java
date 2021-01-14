package Controller.Observable;

import Model.AdminSection.Observers.IStockOrders;

public interface IStockDatabaseSystem {

    //region Abstract Methods used in StockDatabaseSystem
    void Add(IStockOrders stockOrdersModel);

    void Remove(IStockOrders stockOrdersModel);
    //endregion
}
