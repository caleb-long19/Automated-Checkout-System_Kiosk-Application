package Controller;

import Model.AdminModel;
import Model.StockOrdersModel;
import View.AdminView;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AdminUsersController {

    //region Class Objects and Variables
    private AdminModel adminModel;
    private StockOrdersModel stockOrdersModel;
    private AdminView adminView;
    private StockDatabaseController stockDatabaseController;

    public String Name;
    public String Password;
    public String filepath = "resources\\AdminUserLogins.txt";
    public String separator = "\\|";

    int Quantity;
    boolean trigger = false;
    //endregion

    public AdminUsersController(AdminView av, StockOrdersModel som, AdminModel am, StockDatabaseController sdc){
        adminView = av;
        stockOrdersModel = som;
        adminModel = am;
        stockDatabaseController = sdc;
    }

    public void initAdminUsersController(){
        adminView.getBtnLogin().addActionListener(e -> Login());
        adminView.btnDelivery.addActionListener(e -> OrderStock());
    }

    public void Login() {

        //Get value from txtUsername and txtPassword and store them in Name and Password variables
        Name = adminView.getTxtUsername().getText();
        Password = adminView.getTxtPassword().getText();

        //Store Name and Password into setAdminUsername and SetAdminPassword
        adminModel.setAdminUsername(Name);
        adminModel.setAdminPassword(Password);

        try{
            File file = new File(filepath);

            Scanner scanner = new Scanner(file);

            //Run a loop to check if Username and Password are valid in the AdminUserLogins text file
            while (scanner.hasNextLine()) {
                String tableRow = scanner.nextLine();

                String[] LoginDe = tableRow.split(separator);

                Name = LoginDe[0];
                Password = LoginDe[1];

                AccessStock();
            }
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public void AccessStock() {
        //If the Username and Password entered by the user are equal to the Name & Password variables, let them enter
        if(adminView.getTxtUsername().getText().equals(Name) && adminView.getTxtPassword().getText().equals(Password)){
            ReplenishStockWarning();
            adminView.getCardLayout().show(adminView.AdminPanel, "AdminDatabasePage");
            System.out.println("Success: Correct Admin Details Provided!");
        }
        else{
            adminView.getLblDetailsIncorrect().setText("Error: Incorrect Admin Details!");
            System.out.println("Error: Incorrect Admin Details!");
        }
    }

    public void OrderStock() {
        for (int i = 0; i < stockDatabaseController.allStockItems.toArray().length; i++)
        {
            Quantity = stockDatabaseController.allStockItems.get(i).getQuantity();
            if(Quantity < 50){
                JOptionPane.showMessageDialog(null, "Replenishing Stock On All Low Stock Items","Replenishing Stock", JOptionPane.INFORMATION_MESSAGE);
                trigger = true;
                ReplenishStockOnDelivery();
            }
        }
        if(Quantity >= 50){
            JOptionPane.showMessageDialog(null, "No Stock Needs To Be Replenished!","Replenishing Stock", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void ReplenishStockWarning() {
        for (int i = 0; i < stockDatabaseController.allStockItems.toArray().length; i++)
        {
            int Quantity = stockDatabaseController.allStockItems.get(i).getQuantity();
            if(Quantity < 50){
                JOptionPane.showMessageDialog(null, "Stock is low on these item(s): " + stockDatabaseController.allStockItems.get(i).getName(),"Stock Supply Warning!", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    public void ReplenishStockOnDelivery() {
        JOptionPane.showMessageDialog(null, "Stock Delivery is on the way!","Replenishing Stock", JOptionPane.INFORMATION_MESSAGE);
        try {
            Thread.sleep(10000);
            if(trigger == true){
                for (int i = 0; i < stockDatabaseController.allStockItems.toArray().length; i++)
                {
                    Quantity = stockDatabaseController.allStockItems.get(i).getQuantity();
                    if(Quantity < 50){
                        JOptionPane.showMessageDialog(null, "Stock Delivery Has Been Made For: " + stockDatabaseController.allStockItems.get(i).getName(),"Replenishing Stock", JOptionPane.INFORMATION_MESSAGE);
                        stockDatabaseController.allStockItems.get(i).setQuantity(100);
                        stockDatabaseController.saveKioskStock();
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
