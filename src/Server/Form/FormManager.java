/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.Form;

import java.util.ArrayList;
import Server.Entity.Admin;
import Server.Entity.Centre;
import Server.Entity.Customer;
import Server.Entity.Employee;
import Server.Entity.Zone;
import javax.swing.JOptionPane;

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

    public void showMessageOnMainMenu(String message, int messageType){
        JOptionPane.showMessageDialog(this.mainMenu, message,"Message",messageType);
    }
    
    public void showMessageOnLogIn(String message, int messageType){
        JOptionPane.showMessageDialog(this.logIn, message,"Message",messageType);
    }
    
    public void disposeLogIn(){
        logIn.dispose();
        logIn.clear();
    }
    
    public void showLogIn(){
        logIn.setVisible(true);
    }
    
    public void disposeMainMenu(){
        mainMenu.dispose();
    }
    
    public void showMainMenu() {
        mainMenu.setVisible(true);
        mainMenu.refresh();
    }
    
    public void loadAdmins(ArrayList<Admin> admins) {
        mainMenu.renderAdmin(admins);
    }
    
    public void loadCentres(ArrayList<Centre> centres) {
        mainMenu.renderCentre(centres);
    }
    
    public void loadEmps(ArrayList<Employee> emps) {
        mainMenu.renderEmp(emps);
    }
    
    public void loadZones(ArrayList<Zone> zones){
        mainMenu.renderZone(zones);
    }
    
    public void loadCusts(ArrayList<Customer> custs) {
        mainMenu.renderCust(custs);
    }
    
    @Override
    public void run() {
        this.logIn.setVisible(true);
    }
}
