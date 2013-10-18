/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.Entity;

/**
 *
 * @author QUANGHUY
 */
public class Centre {
  
    private String pin_Code;
    private String centreName;
    private String centreCode;
    private String location;
    private String ip;
    private String zoneName;

    public String getPin_Code() {
        return pin_Code;
    }

    public void setPin_Code(String pin_Code) {
        this.pin_Code = pin_Code;
    }
    
    public String getCentreName() {
        return centreName;
    }

    public void setCentreName(String centreName) {
        this.centreName = centreName;
    }
    
    public String getCentreCode() {
        return centreCode;
    }

    public void setCentreCode(String centreCode) {
        this.centreCode = centreCode;
    }
    
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }
}

