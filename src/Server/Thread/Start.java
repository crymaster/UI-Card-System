/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.Thread;
import Server.Controller.AdminController;
import Server.Controller.CentreController;
import Server.Controller.CustomerController;
import Server.Controller.EmpController;
import Server.Controller.LoggingController;
import Server.Controller.ZoneController;
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
        LoggingController logInCtrl = new LoggingController();
        AdminController adminCtrl = new AdminController();
        CentreController centreCtrl = new CentreController();
        EmpController empCtrl = new EmpController();
        ZoneController zoneCtrl = new ZoneController();
        CustomerController custCtrl = new CustomerController();
        //Set Controller for Form
        logIn.setController(logInCtrl);
        mainMenu.setLogController(logInCtrl);
        mainMenu.setAdminController(adminCtrl);
        mainMenu.setCentreController(centreCtrl);
        mainMenu.setEmpController(empCtrl);
        mainMenu.setZoneController(zoneCtrl);
        mainMenu.setCustController(custCtrl);
        //Set FormManager and ServiceManager for Controller
        logInCtrl.setFormManager(formManager);
        logInCtrl.setServiceManager(serviceManager);
        adminCtrl.setFormManager(formManager);
        adminCtrl.setServiceManager(serviceManager);
        centreCtrl.setFormManager(formManager);
        centreCtrl.setServiceManager(serviceManager);
        empCtrl.setFormManager(formManager);
        empCtrl.setServiceManager(serviceManager);
        zoneCtrl.setFormManager(formManager);
        zoneCtrl.setServiceManager(serviceManager);
        custCtrl.setFormManager(formManager);
        custCtrl.setServiceManager(serviceManager);
        java.awt.EventQueue.invokeLater(formManager);
    }
}
