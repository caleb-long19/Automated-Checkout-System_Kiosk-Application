package Controller.Observable;

import Model.AdminSection.Observers.IStockOrders;

public interface IStockDatabaseSystem {

    void Add(IStockOrders stockOrdersModel);

    void Edit(IStockOrders stockOrdersModel);

    void Remove(IStockOrders stockOrdersModel);
}
