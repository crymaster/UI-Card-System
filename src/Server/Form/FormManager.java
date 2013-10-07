/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.Form;

import java.util.ArrayList;
import Server.Entity.Admin;

/**
 *
 * @author Son
 */
public class FormManager implements Runnable {

    private LogIn logIn;
    private MainMenu mainMenu;

    public FormManager() {
        logIn = new LogIn();
        mainMenu = new MainMenu();
    }

    public LogIn getLogIn() {
        return logIn;
    }

    public void setLogIn(LogIn logIn) {
        this.logIn = logIn;
    }

    public MainMenu getMainMenu() {
        return mainMenu;
    }

    public void setMainMenu(MainMenu mainMenu) {
        this.mainMenu = mainMenu;
    }

    public void logInSuccess() {
        logIn.showMessage("Login successfully !", 1);
        logIn.dispose();
        showMainMenu();
    }

    private void showMainMenu() {
        mainMenu.setVisible(true);
        mainMenu.refresh();
    }
    
    public void logInFail() {
        logIn.showMessage("Login fail !\\nAccount name or password is incorrect.", 0);
    }

    public void loadAdmins(ArrayList<Admin> admins) {
        mainMenu.render(admins);
    }

    public void addAdminSuccess(){
        mainMenu.showMessage("Add successfully !", 1);
    }
    
    public void addAdminFail(){
        mainMenu.showMessage("Admin name has existed or saving error !", 0);
    }
    @Override
    public void run() {
        this.logIn.setVisible(true);
    }
}
