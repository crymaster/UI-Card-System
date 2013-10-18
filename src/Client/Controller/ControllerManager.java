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
    private LoggingController logInController;

    public ControllerManager() {
        logInController = new LoggingController();
    }

    public LoggingController getLogInController() {
        return logInController;
    }

    public void setLogInController(LoggingController logInController) {
        this.logInController = logInController;
    }
    
}
