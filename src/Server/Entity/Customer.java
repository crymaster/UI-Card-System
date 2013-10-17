/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.Entity;

import java.util.Date;

/**
 *
 * @author QUANGHUY
 */
public class Customer {
    private int custID;
    private String firstName;
    private String middleName;
    private String lastName;
    private Date dob;
    private int gender;
    private String contactDetail;
    private String email;
    private String address;
    private String education;
    private String occupation;
    private int married;
    private int addressProof;
    private String citizenProof;
    private String health;
    private int centreID;
    private String UICode;
    private int thump;
    private int fingerPrint;
    private int retinaScan;
    private int status;
    private String personalDetail;
    private Date dateCreated;
    
    private String centreName;

    public int getCustID() {
        return custID;
    }

    public void setCustID(int custID) {
        this.custID = custID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getContactDetail() {
        return contactDetail;
    }

    public void setContactDetail(String contactDetail) {
        this.contactDetail = contactDetail;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
   
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public int getMarried() {
        return married;
    }

    public void setMarried(int married) {
        this.married = married;
    }

    public int getAddressProof() {
        return addressProof;
    }

    public void setAddressProof(int addressProof) {
        this.addressProof = addressProof;
    }

    public String getCitizenProof() {
        return citizenProof;
    }

    public void setCitizenProof(String citizenProof) {
        this.citizenProof = citizenProof;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public int getCentreID() {
        return centreID;
    }

    public void setCentreID(int centreID) {
        this.centreID = centreID;
    }

    public String getUICode() {
        return UICode;
    }

    public void setUICode(String UICode) {
        this.UICode = UICode;
    }

    public int getThump() {
        return thump;
    }

    public void setThump(int thump) {
        this.thump = thump;
    }

    public int getFingerPrint() {
        return fingerPrint;
    }

    public void setFingerPrint(int fingerPrint) {
        this.fingerPrint = fingerPrint;
    }

    public int getRetinaScan() {
        return retinaScan;
    }

    public void setRetinaScan(int retinaScan) {
        this.retinaScan = retinaScan;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPersonalDetail() {
        return personalDetail;
    }

    public void setPersonalDetail(String personalDetail) {
        this.personalDetail = personalDetail;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getCentreName() {
        return centreName;
    }

    public void setCentreName(String centreName) {
        this.centreName = centreName;
    }
    
    public String getCustGender() {
        if(gender == 1) {
            return "Male";
        }
        if(gender == 0) {
            return "Female";
        }
        return "";
    }
    
    public String getCustStatus() {
        if(status == 1) {
            return "Sent";
        }
        if(status == 0) {
            return "Waiting";
        }
        return "";
    }
}
