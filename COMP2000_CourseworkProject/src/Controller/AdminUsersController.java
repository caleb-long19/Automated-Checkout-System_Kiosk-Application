package Controller;

import Model.AdminModel;
import Model.StockOrdersModel;
import View.AdminView;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AdminUsersController {

    private AdminModel adminModel;
    private StockOrdersModel stockOrdersModel;
    private AdminView adminView;

    public String Name;
    public String Password;
    public String filepath = "resources\\AdminUserLogins.txt";
    public String separator = "\\|";

    public AdminUsersController(AdminView av, StockOrdersModel som, AdminModel am){
        adminView = av;
        stockOrdersModel = som;
        adminModel = am;
    }

    public void initAdminUsersController(){
        adminView.getBtnLogin().addActionListener(e -> Login());
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

            adminView.getCardLayout().show(adminView.AdminPanel, "AdminDatabasePage");
            System.out.println("Success: Correct Admin Details Provided!");
        }
        else{
            adminView.getLblDetailsIncorrect().setText("Error: Incorrect Admin Details!");
            System.out.println("Error: Incorrect Admin Details!");
        }
    }

    public void OrderStock() {

    }

    public void ReplenishStockWarning() {
        //Display a Message Dialog to inform the Admin that a Stock Item has been Added!
        JOptionPane.showMessageDialog(null, "Stock is low on these item(s): " + stockOrdersModel.getName(),"Stock Supply Warning!", JOptionPane.INFORMATION_MESSAGE);
    }

    public void ReplenishStockOnDelivery() {

    }
}
