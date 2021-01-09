import Controller.AdminController;
import Controller.StockDatabaseController;
import Model.AdminModel;
import Model.StockOrdersModel;
import View.AdminView;

public class App {

    public static void main(String[] args){
        //Assemble all pieces of the Model View Controller
        AdminModel am = new AdminModel("John", "1");
        AdminView av = new AdminView("Admin Database Manager");
        AdminController ac = new AdminController(am, av);
        ac.initAdminController();

        StockOrdersModel som = new StockOrdersModel(2, "Bacon", 200, 3.99);
        StockDatabaseController sdc = new StockDatabaseController(som, av);
    }
}
