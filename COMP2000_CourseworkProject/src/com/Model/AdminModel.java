package Model;

public class AdminModel {

    String adminUsername;
    String adminPassword;

    public AdminModel(String username, String password){
        this.adminUsername = username;
        this.adminPassword = password;
    }

    public String getAdminUsername(){
        return adminUsername;
    }

    public void setAdminUsername(String AdminUsername){
        this.adminUsername = AdminUsername;
    }

    public String getAdminPassword(){
        return adminPassword;
    }

    public void setAdminPassword(String AdminPassword){
        this.adminPassword = AdminPassword;
    }
}
