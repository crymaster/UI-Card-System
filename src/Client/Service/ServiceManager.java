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
    private DraftManagerService draftManagerService;

    public ServiceManager() {
        serverCommunicationService = new ServerCommunicationService();
        draftManagerService = new DraftManagerService();
    }

    public ServerCommunicationService getServerCommunicationService() {
        return serverCommunicationService;
    }

    public void setServerCommunicationService(ServerCommunicationService serverCommunicationService) {
        this.serverCommunicationService = serverCommunicationService;
    }

    public DraftManagerService getDraftManagerService() {
        return draftManagerService;
    }

    public void setDraftManagerService(DraftManagerService draftManagerService) {
        this.draftManagerService = draftManagerService;
    }
}
