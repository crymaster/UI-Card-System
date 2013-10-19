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
    private MainController mainController;

    public ControllerManager() {
        logInController = new LoggingController();
        mainController = new MainController();
    }

    public LoggingController getLogInController() {
        return logInController;
    }

    public void setLogInController(LoggingController logInController) {
        this.logInController = logInController;
    }

    public MainController getMainController() {
        return mainController;
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
