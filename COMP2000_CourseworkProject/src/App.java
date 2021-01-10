import Controller.AdminController;
import Controller.AdminUsersController;
import Controller.CustomerController;
import Controller.StockDatabaseController;
import Model.AdminModel;
import Model.CustomerModel;
import Model.StockOrdersModel;
import View.AdminView;
import View.CustomerKioskView;

public class App {

    public static void main(String[] args){
        //region All Pieces of the MVC Method
        AdminModel am = new AdminModel("", "");
        AdminView av = new AdminView("Admin Database Man");
        AdminController ac = new AdminController(am, av);
        CustomerModel cm = new CustomerModel("");
        CustomerKioskView ckv = new CustomerKioskView("Customer Kiosk");
        CustomerController cc = new CustomerController(cm, ckv);

        StockOrdersModel som = new StockOrdersModel();
        StockDatabaseController sdc = new StockDatabaseController(som, av);
        AdminUsersController auc = new AdminUsersController(av, som, am);
        DisplayStockListData dsld = new DisplayStockListData(av, sdc);

        //Call Methods from Class Objects
        ac.initAdminController();
        sdc.LoadKioskData();
        auc.initAdminUsersController();
        dsld.initDisplayStockListData();
        //endregion
    }
}
