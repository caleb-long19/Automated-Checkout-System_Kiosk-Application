import Controller.*;
import Model.AdminModel;
import Model.CustomerModel;
import Model.StockOrdersModel;
import View.AdminView;
import View.CustomerKioskView;

public class App {

    public static void main(String[] args){
        //region All Pieces of the MVC Method

        //region View Objects
        AdminView av = new AdminView("Admin Database Man");
        CustomerKioskView ckv = new CustomerKioskView("Customer Kiosk");
        //endregion

        //region Model Objects
        AdminModel am = new AdminModel("", "");
        StockOrdersModel som = new StockOrdersModel();
        CustomerModel cm = new CustomerModel("");
        //endregion

        //region Controller Objects
        AdminController ac = new AdminController(am, av);
        StockDatabaseController sdc = new StockDatabaseController(som, av);
        AdminUsersController auc = new AdminUsersController(av, som, am, sdc);
        CustomerController cc = new CustomerController(sdc, som, cm, ckv);
        //endregion

        //region Class Objects
        DisplayStockListData dsld = new DisplayStockListData(av, sdc, som);
        CardPayment cardp = new CardPayment(ckv, som);
        CashPayment cashp = new CashPayment(ckv,cc, som);
        Receipt r = new Receipt(cc, ckv ,cardp, cashp);
        //endregion

        //region Calling Methods From Class Objects
        //Call Methods from Class Objects
        ac.initAdminController();
        sdc.LoadKioskData();
        auc.initAdminUsersController();
        dsld.initDisplayStockListData();
        cc.initCustomerController();
        //endregion

        //endregion
    }
}
