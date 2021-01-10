package Controller;
import Model.AdminModel;
import View.AdminView;

public class AdminController {

    private AdminModel adminModel;
    private AdminView adminView;

    public AdminController(AdminModel am, AdminView av){
        adminModel = am;
        adminView = av;
        initAdminView();
    }

    public void initAdminView(){
        adminView.getTxtUsername().setText(adminModel.getAdminUsername());
        adminView.getTxtPassword().setText(adminModel.getAdminPassword());
    }

    public void initAdminController(){
        adminView.getBtnLogin().addActionListener(e -> saveAdminUser());
    }

    private void saveAdminUser(){
        adminModel.setAdminUsername(adminView.getTxtUsername().getText());
        System.out.println("Welcome " + adminModel.getAdminUsername());
    }
}
