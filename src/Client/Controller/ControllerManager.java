/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Client.Controller;

/**
 *
 * @author Son
 */
public class ControllerManager {
    private LogInController logInController;

    public ControllerManager() {
        logInController = new LogInController();
    }

    public LogInController getLogInController() {
        return logInController;
    }

    public void setLogInController(LogInController logInController) {
        this.logInController = logInController;
    }
    
}
