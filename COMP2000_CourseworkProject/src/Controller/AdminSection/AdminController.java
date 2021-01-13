package Controller.AdminSection;
import Model.AdminSection.AdminModel;
import View.AdminSection.AdminView;

public class AdminController {

    private final AdminModel adminModel;
    private final AdminView adminView;

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
        //Detect button press and run saveAdminUser Method
        adminView.getBtnLogin().addActionListener(e -> saveAdminUser());
    }

    private void saveAdminUser(){
        //Store the user text input into the setAdminUsername
        adminModel.setAdminUsername(adminView.getTxtUsername().getText());
        System.out.println("Welcome " + adminModel.getAdminUsername());
    }
}
