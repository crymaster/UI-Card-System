/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.Thread;
import Server.Controller.AdminController;
import Server.Controller.LogInController;
import Server.Form.FormManager;
import Server.Form.LogIn;
import Server.Form.MainMenu;
import Server.Service.ServiceManager;
/**
 *
 * @author Son
 */
public class Start {
    public static void main(String[] args) {
        //Start server
        ClientListeningThread server = new ClientListeningThread();
        server.start();
        //Service
        ServiceManager serviceManager = new ServiceManager();
        //Form
        FormManager formManager = new FormManager();
        LogIn logIn = formManager.getLogIn();
        MainMenu mainMenu = formManager.getMainMenu();
        //Controller
        LogInController logInCtrl = new LogInController();
        logIn.setController(logInCtrl);
        logInCtrl.setFormManager(formManager);
        logInCtrl.setServiceManager(serviceManager);
        AdminController adminCtrl = new AdminController();
        mainMenu.setAdminController(adminCtrl);
        adminCtrl.setFormManager(formManager);
        adminCtrl.setServiceManager(serviceManager);
        java.awt.EventQueue.invokeLater(formManager);
    }
}
