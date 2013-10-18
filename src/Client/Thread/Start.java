/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Client.Thread;

import Client.Connection.ListeningThread;
import Client.Connection.Sending;
import Client.Connection.ServerConnection;
import Client.Controller.ControllerManager;
import Client.Controller.LoggingController;
import Client.Form.FormManager;
import Client.Form.LogIn;
import Client.Form.MainMenu;
import Client.Service.ServerCommunicationService;
import Client.Service.ServiceManager;

/**
 *
 * @author Son
 */
public class Start{
    public static void main(String[] args) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*Instantiate ServerConnection, Listening Thread, Sending*/
        ServerConnection connection = new ServerConnection();
        ListeningThread listen = new ListeningThread();
        Sending send = new Sending();
        connection.setListen(listen);
        connection.setSend(send);
        connection.connect();
        listen.setConnection(connection);
        /*Instantiate ServiceManager, ServerCommunication Service*/
        ServiceManager serviceManager = new ServiceManager();
        ServerCommunicationService serverCom = new ServerCommunicationService();
        serviceManager.setServerCommunicationService(serverCom);
        serverCom.setConnection(connection);
        /*Form*/
        FormManager formManager = new FormManager();
        LogIn logIn = formManager.getLogIn();
        MainMenu menu = formManager.getMainMenu();
        /*Controller*/
        ControllerManager controllerManager = new ControllerManager();
        listen.setControllerManager(controllerManager);
        LoggingController logInCtrl = controllerManager.getLogInController();
        /*Set FormManager and ServiceManager for controller*/
        logInCtrl.setFormManager(formManager);
        logInCtrl.setServiceManager(serviceManager);   
        /*Set Controller for Form*/
        logIn.setController(logInCtrl);
        menu.setLogController(logInCtrl);
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(formManager);
    }
}
