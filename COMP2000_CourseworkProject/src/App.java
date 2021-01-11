import Controller.*;
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
        StockOrdersModel som = new StockOrdersModel();
        AdminController ac = new AdminController(am, av);
        CustomerModel cm = new CustomerModel("");
        CustomerKioskView ckv = new CustomerKioskView("Customer Kiosk");
        CardPayment cardp = new CardPayment(ckv, som);
        CashPayment cashp = new CashPayment(ckv, som);

        StockDatabaseController sdc = new StockDatabaseController(som, av);
        AdminUsersController auc = new AdminUsersController(av, som, am, sdc);
        DisplayStockListData dsld = new DisplayStockListData(av, sdc, som);
        CustomerController cc = new CustomerController(sdc, som, cm, ckv);

        //Call Methods from Class Objects
        ac.initAdminController();
        sdc.LoadKioskData();
        auc.initAdminUsersController();
        dsld.initDisplayStockListData();
        cc.initCustomerController();
        //endregion
    }
}
