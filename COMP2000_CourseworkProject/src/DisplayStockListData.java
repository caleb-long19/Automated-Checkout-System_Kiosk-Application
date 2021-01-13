import Controller.StockDatabaseController;
import Model.AdminSection.Observers.StockOrders;
import View.AdminSection.AdminView;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class DisplayStockListData {
    private static DisplayStockListData instance;

    AdminView adminView;
    StockDatabaseController stockDatabaseController;
    StockOrders stockOrders;

    int selectedEditIndex;
    int selectedViewIndex;

    public DisplayStockListData(AdminView av, StockDatabaseController ssd, StockOrders som){
        adminView = av;
        stockDatabaseController = ssd;
        stockOrders = som;
    }

    public void initDisplayStockListData(){
        adminView.lstStockEditDisplay.addListSelectionListener(e -> SetUpLstData());
        adminView.lstDisplayStock.addListSelectionListener(e -> SetUpLstData());
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
        StockOrders currentSelectedEditItem = stockDatabaseController.allStockItems.get(selectedEditIndex);

        //Temp variables to store correct selected index data
        int tempEditBarcodeNum = currentSelectedEditItem.getBarcode();
        String tempEditStockName = currentSelectedEditItem.getName();
        int tempEditStockQuantity = currentSelectedEditItem.getQuantity();
        double tempEditStockPrice = currentSelectedEditItem.getPrice();

        // Display the temp variable data in the correct text boxes
        adminView.txtEditBarcode.setText(Integer.toString(tempEditBarcodeNum));
        adminView.txtEditName.setText(tempEditStockName);
        adminView.txtEditQuantity.setText(Integer.toString(tempEditStockQuantity));
        adminView.txtEditPrice.setText(Double.toString(tempEditStockPrice));
    }

    public void DisplayViewData(){
        //allStockItems array Gets selected index item from lstDisplayStock and stores it in StockOrderModel class object
        StockOrders currentViewSelectedItem = stockDatabaseController.allStockItems.get(selectedViewIndex);

        //Temp variables to store correct selected index data
        int tempViewBarcodeNum = currentViewSelectedItem.getBarcode();
        String tempViewStockName = currentViewSelectedItem.getName();
        int tempViewStockQuantity = currentViewSelectedItem.getQuantity();
        double tempViewStockPrice = currentViewSelectedItem.getPrice();

        //Display the temp variable data in the correct text boxes
        adminView.txtViewBarcode.setText(Integer.toString(tempViewBarcodeNum));
        adminView.txtViewName.setText(tempViewStockName);
        adminView.txtViewQuantity.setText(Integer.toString(tempViewStockQuantity));
        adminView.txtViewPrice.setText(Double.toString(tempViewStockPrice));
    }
    //endregion
}
