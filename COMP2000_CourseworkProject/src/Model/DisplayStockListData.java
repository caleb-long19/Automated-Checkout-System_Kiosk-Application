package Model;

import Controller.Observable.StockDatabaseSystem;
import Model.AdminSection.Observers.IStockOrders;
import Model.AdminSection.Observers.StockOrders;
import View.AdminSection.AdminView;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class DisplayStockListData {
    AdminView adminView;
    StockDatabaseSystem stockDatabaseSystem;
    StockOrders stockOrders;

    int selectedEditIndex;
    int selectedViewIndex;

    public DisplayStockListData(AdminView av, StockDatabaseSystem sds, StockOrders som){
        adminView = av;
        stockDatabaseSystem = sds;
        stockOrders = som;
    }

    public void SetUpLstData(){
        adminView.lstStockEditDisplay.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(!adminView.lstStockEditDisplay.isSelectionEmpty()){
                    selectedEditIndex = adminView.lstStockEditDisplay.getMinSelectionIndex();
                    DisplayData();
                }
            }
        });

        adminView.lstDisplayStock.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(!adminView.lstDisplayStock.isSelectionEmpty()){
                    selectedViewIndex = adminView.lstDisplayStock.getMinSelectionIndex();
                    DisplayViewData();
                }
            }
        });
    }

    //region Display selected index data from JLists properly
    public void DisplayData(){
        //allStockItems array Gets selected index item from lstStockEditDisplay and stores it in StockOrderModel class object
        IStockOrders currentSelectedEditItem = stockDatabaseSystem.stockItems.get(selectedEditIndex);

        //Temp variables to store correct selected index data
        int tempEditBarcodeNum = currentSelectedEditItem.getBarcode();
        String tempEditStockName = currentSelectedEditItem.getStockName();
        int tempEditStockQuantity = currentSelectedEditItem.getStockQuantity();
        double tempEditStockPrice = currentSelectedEditItem.getStockPrice();

        // Display the temp variable data in the correct text boxes
        adminView.txtEditBarcode.setText(Integer.toString(tempEditBarcodeNum));
        adminView.txtEditName.setText(tempEditStockName);
        adminView.txtEditQuantity.setText(Integer.toString(tempEditStockQuantity));
        adminView.txtEditPrice.setText(Double.toString(tempEditStockPrice));
    }

    public void DisplayViewData(){
        //allStockItems array Gets selected index item from lstDisplayStock and stores it in StockOrderModel class object
        IStockOrders currentViewSelectedItem = stockDatabaseSystem.stockItems.get(selectedViewIndex);

        //Temp variables to store correct selected index data
        int tempViewBarcodeNum = currentViewSelectedItem.getBarcode();
        String tempViewStockName = currentViewSelectedItem.getStockName();
        int tempViewStockQuantity = currentViewSelectedItem.getStockQuantity();
        double tempViewStockPrice = currentViewSelectedItem.getStockPrice();

        //Display the temp variable data in the correct text boxes
        adminView.txtViewBarcode.setText(Integer.toString(tempViewBarcodeNum));
        adminView.txtViewName.setText(tempViewStockName);
        adminView.txtViewQuantity.setText(Integer.toString(tempViewStockQuantity));
        adminView.txtViewPrice.setText(Double.toString(tempViewStockPrice));
    }
    //endregion
}
