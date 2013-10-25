/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.Controller;

import java.util.ArrayList;
import Server.Entity.Zone;
import Server.Entity.Centre;
import Server.Entity.Employee;
/**
 *
 * @author Son
 */
public class TreeController extends BaseController{
    public void load(){
        ArrayList tree = new ArrayList();
        ArrayList<Zone> zones = this.getServiceManager().getZoneManagerService().getAll();
        ArrayList zoneNode;
        ArrayList<Centre> centres;
        ArrayList centreNode;
        ArrayList centreNodes;
        ArrayList<Employee> employees;
        ArrayList<String> empNodes;
        for(int i=0; i<zones.size(); i++){
            zoneNode = new ArrayList();
            tree.add(zoneNode);
            zoneNode.add(zones.get(i).getZone_Name());
            centreNodes = new ArrayList<>();
            zoneNode.add(centreNodes);
            centres = this.getServiceManager().getCentreManagerService().getByPinCode(zones.get(i).getPin_Code());
            for(int j = 0; j<centres.size(); j++){
                centreNode = new ArrayList();
                centreNodes.add(centreNode);
                centreNode.add(centres.get(j).getCentreName());
                empNodes = new ArrayList<>();
                centreNode.add(empNodes);
                employees = this.getServiceManager().getEmpManagerService().getByCentreCode(centres.get(j).getCentreCode());
                for(int k = 0; k< employees.size() ; k++){
                    empNodes.add(employees.get(k).getEmpName());
                }
            }
        }
        this.getFormManager().loadTree(tree);
    }
}
