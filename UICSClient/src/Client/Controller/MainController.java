/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Client.Controller;

import Client.Entity.Draft;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Son
 */
public class MainController extends BaseController {

    public void send(HashMap customer) {
        customer.put("message", "ENTRY");
        this.getServiceManager().getServerCommunicationService().send(customer);
    }

    public void entrySuccess(HashMap data) {
        this.getFormManager().toUIProcess(data);
    }

    public void entryFail() {
        this.getFormManager().showMessageOnMainMenu("An error has occured on server. Please try again", 0);
    }

    public void uiSuccess() {
        this.getFormManager().finishUIProcess();
    }

    public void uiFail() {
        this.getFormManager().showMessageOnMainMenu("An error has occured on server. Please try again", 0);
    }

    public void saveDraft(Draft draft) {
        if (draft.getDraftId() == 0) {
            this.getServiceManager().getDraftManagerService().insert(draft);
        } else {
            this.getServiceManager().getDraftManagerService().save(draft);
        }
    }

    public void load() {
        this.getFormManager().loadDraft(this.getServiceManager().getDraftManagerService().getAll());
    }

    public void delete(int draftID) {
        this.getServiceManager().getDraftManagerService().delete(draftID);
    }

    public void requestUpdateProfile(HashMap data) {
        data.put("message", "PROFILE");
        this.getServiceManager().getServerCommunicationService().send(data);
    }

    public void profileSuccess(HashMap employee) {
        this.getFormManager().showMessageOnMainMenu("Update Profile successfully", 1);
        BaseController.getSession().setCurrentEmployee(employee);
        this.getFormManager().getMainMenu().refresh();
    }

    public void profileFail() {
        this.getFormManager().showMessageOnMainMenu("This name already existed or another error occur on the server. Please try again later", 0);
    }
}
