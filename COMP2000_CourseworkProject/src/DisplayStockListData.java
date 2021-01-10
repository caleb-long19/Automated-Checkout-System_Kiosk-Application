import Controller.StockDatabaseController;
import Model.StockOrdersModel;
import View.AdminView;

public class DisplayStockListData {
    AdminView adminView;
    StockDatabaseController stockDatabaseController;

    public DisplayStockListData(AdminView av, StockDatabaseController sdc){
        adminView = av;
        stockDatabaseController = sdc;
    }

    public void initDisplayStockListData(){
        adminView.getLstStockEditDisplay().addListSelectionListener(e -> DisplayData());
        adminView.getLstDisplayStock().addListSelectionListener(e -> DisplayViewData());
    }

    //region Display selected index data from JLists properly
    public void DisplayData(){
        //allStockItems array Gets selected index item from lstStockEditDisplay and stores it in StockOrderModel class object
        StockOrdersModel currentEditSelectedItem = stockDatabaseController.allStockItems.get(adminView.getLstStockEditDisplay().getSelectedIndex());

        //Temp variables to store correct selected index data
        int tempEditBarcodeNum = currentEditSelectedItem.getBarcode();
        String tempEditStockName = currentEditSelectedItem.getName();
        int tempEditStockQuantity = currentEditSelectedItem.getQuantity();
        double tempEditStockPrice = currentEditSelectedItem.getPrice();

        // Display the temp variable data in the correct text boxes
        adminView.txtEditBarcode.setText(Integer.toString(tempEditBarcodeNum));
        adminView.txtEditName.setText(tempEditStockName);
        adminView.txtEditQuantity.setText(Integer.toString(tempEditStockQuantity));
        adminView.txtEditPrice.setText(Double.toString(tempEditStockPrice));
    }

    public void DisplayViewData(){
        //allStockItems array Gets selected index item from lstDisplayStock and stores it in StockOrderModel class object
        StockOrdersModel currentViewSelectedItem = stockDatabaseController.allStockItems.get(adminView.getLstDisplayStock().getSelectedIndex());

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
