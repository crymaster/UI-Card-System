/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Client.Service;

/**
 *
 * @author Son
 */
public class ServiceManager {
    private ServerCommunicationService serverCommunicationService;

    public ServerCommunicationService getServerCommunicationService() {
        return serverCommunicationService;
    }

    public void setServerCommunicationService(ServerCommunicationService serverCommunicationService) {
        this.serverCommunicationService = serverCommunicationService;
    }

}
