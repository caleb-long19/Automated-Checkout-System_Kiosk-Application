import Controller.*;
import Controller.AdminSection.AdminController;
import Controller.AdminSection.AdminUsersController;
import Controller.Payment.CardPayment;
import Controller.Payment.CashPayment;
import Controller.Payment.CustomerController;
import Controller.Payment.Receipt;
import Model.AdminSection.AdminModel;
import Model.Bank;
import Model.CustomerSection.CustomerModel;
import Model.CustomerSection.IPaymentMethod;
import Model.AdminSection.StockOrdersModel;
import View.AdminSection.AdminView;
import View.CustomerSection.CustomerKioskView;

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
        CustomerModel cm = new CustomerModel();
        //endregion

        //region Controller Objects
        IPaymentMethod cpipm = new CardPayment(ckv, som);
        AdminController ac = new AdminController(am, av);
        StockDatabaseController sdc = new StockDatabaseController(som, av);
        AdminUsersController auc = new AdminUsersController(av, som, am, sdc);
        CustomerController cc = new CustomerController(sdc, som, cm, ckv);
        //endregion

        //region Class Objects
        DisplayStockListData dsld = new DisplayStockListData(av, sdc, som);
        CardPayment cardPayment = new CardPayment(ckv, som);
        CashPayment cashPayment = new CashPayment(ckv,cc, sdc, som);
        Receipt r = new Receipt(cpipm, cc, ckv, sdc, cardPayment, cashPayment);
        //endregion

        //region Calling Methods From Class Objects
        //Call Methods from Class Objects
        ac.initAdminController();
        sdc.LoadKioskData();
        auc.initAdminUsersController();
        dsld.initDisplayStockListData();
        cardPayment.initCPayment();
        cashPayment.initCashPayment();
        r.initReceipt();
        //endregion

        //endregion
    }
}
