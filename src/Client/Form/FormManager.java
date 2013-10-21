/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Client.Form;

import java.util.ArrayList;
import java.util.HashMap;
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
    
    public void logInConnected(){
        logIn.connected();
    }
    
    public void showMessageOnLogIn(String message, int messageType){
        JOptionPane.showMessageDialog(this.logIn, message,"Message",messageType);
    }
    
    public void showMessageOnMainMenu(String message, int messageType){
        JOptionPane.showMessageDialog(this.mainMenu, message,"Message",messageType);
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
    
    public void showMainMenu(){
        mainMenu.setVisible(true);
        mainMenu.refresh();
    }
    
    public void toUIProcess(HashMap data){
        mainMenu.toUIProcess(data);
    }
    
    public void finishUIProcess(){
        mainMenu.finishUIProcess();
    }
    
    public void loadDraft(ArrayList drafts){
        mainMenu.renderDraft(drafts);
    }
    
    @Override
    public void run() {
        this.logIn.setVisible(true);
    }
}
