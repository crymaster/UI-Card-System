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
        //load all zones from datbase
        ArrayList<Zone> zones = this.getServiceManager().getZoneManagerService().getAll();
        ArrayList zoneNode;
        ArrayList<Centre> centres;
        ArrayList centreNode;
        ArrayList centreNodes;
        ArrayList<Employee> employees;
        ArrayList<String> empNodes;
        //Each zone ArrayList is saved into ArrayList of zones
        for(int i=0; i<zones.size(); i++){
            //zone ArrayList contain zone name and an ArrayList of centres
            zoneNode = new ArrayList();
            tree.add(zoneNode);
            zoneNode.add(zones.get(i).getZone_Name());
            centreNodes = new ArrayList<>();
            zoneNode.add(centreNodes);
            //load all centres of respective zone
            centres = this.getServiceManager().getCentreManagerService().getByPinCode(zones.get(i).getPin_Code());
            //Add centre ArrayList to list of centres
            for(int j = 0; j<centres.size(); j++){
                //centre ArrayList contain centre name and an ArrayList of employees
                centreNode = new ArrayList();
                centreNodes.add(centreNode);
                centreNode.add(centres.get(j).getCentreName());
                empNodes = new ArrayList<>();
                centreNode.add(empNodes);
                //load all employees of this centre
                employees = this.getServiceManager().getEmpManagerService().getByCentreCode(centres.get(j).getCentreCode());
                //add employee to centre ArrayList
                for(int k = 0; k< employees.size() ; k++){
                    empNodes.add(employees.get(k).getEmpName());
                }
            }
        }
        this.getFormManager().loadTree(tree);
    }
}
