import Controller.AdminController;
import Controller.AdminUsersController;
import Controller.StockDatabaseController;
import Model.AdminModel;
import Model.StockOrdersModel;
import View.AdminView;

public class App {

    public static void main(String[] args){
        //Assemble all pieces of the Model View Controller
        AdminModel am = new AdminModel("", "");
        AdminView av = new AdminView("Admin Database Man");
        AdminController ac = new AdminController(am, av);
        StockOrdersModel som = new StockOrdersModel();
        StockDatabaseController sdc = new StockDatabaseController(som, av);
        AdminUsersController auc = new AdminUsersController(av, som, am);
        DisplayStockListData dsld = new DisplayStockListData(av, sdc);

        ac.initAdminController();
        sdc.LoadKioskData();
        auc.initAdminUsersController();
        dsld.initDisplayStockListData();
    }
}
