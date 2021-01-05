package main;



import controller.ControllerLogin;
import model.ModelAccount;
import model.ModelTransaction;
import ui.LoginPage;

public class Main {
    public static void main(String[] args) {
        MVC mvc = new MVC();
    }
}

class MVC{
    LoginPage loginPage = new LoginPage();
    ModelAccount modelAccount = new ModelAccount();
    ModelTransaction modelTransaction = new ModelTransaction();    
    ControllerLogin controllerLogin = new ControllerLogin(loginPage, modelAccount, modelTransaction);
}
