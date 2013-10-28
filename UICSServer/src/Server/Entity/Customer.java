/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.Entity;

import java.util.Date;
import java.util.HashMap;

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
    private int passport;
    private int vote;
    private int drivingLicense;
    private String health;
    private String centreCode;
    private String UICode;
    private boolean thumb;
    private boolean fingerPrint;
    private boolean retinaScan;
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

    public int getPassport() {
        return passport;
    }

    public void setPassport(int passport) {
        this.passport = passport;
    }

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }

    public int getDrivingLicense() {
        return drivingLicense;
    }

    public void setDrivingLicense(int drivingLicense) {
        this.drivingLicense = drivingLicense;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getCentreCode() {
        return centreCode;
    }

    public void setCentreCode(String centreCode) {
        this.centreCode = centreCode;
    }

    public String getUICode() {
        return UICode;
    }

    public void setUICode(String UICode) {
        this.UICode = UICode;
    }

    public boolean isThumb() {
        return thumb;
    }

    public void setThumb(boolean thumb) {
        this.thumb = thumb;
    }

    public boolean isFingerPrint() {
        return fingerPrint;
    }

    public void setFingerPrint(boolean fingerPrint) {
        this.fingerPrint = fingerPrint;
    }

    public boolean isRetinaScan() {
        return retinaScan;
    }

    public void setRetinaScan(boolean retinaScan) {
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
        if (gender == 1) {
            return "Male";
        }
        if (gender == 0) {
            return "Female";
        }
        return "";
    }

    public String getCustStatus() {
        if (status == 1) {
            return "Sent";
        }
        if (status == 0) {
            return "Waiting";
        }
        if (status == -1) {
            return "Not Ready";
        }
        return "";
    }

    public static Customer toCustomer(HashMap data) {
        Customer customer = new Customer();
        customer.firstName = (String) data.get("firstName");
        customer.middleName = (String) data.get("midName");
        customer.lastName = (String) data.get("lastName");
        customer.dob = (Date) data.get("dob");
        customer.address = (String) data.get("address");
        customer.gender = (Integer) data.get("gender");
        customer.contactDetail = (String) data.get("contact");
        customer.email = (String) data.get("email");
        customer.education = (String) data.get("education");
        customer.occupation = (String) data.get("occupation");
        customer.married = (Integer) data.get("married");
        customer.passport = (Integer) data.get("passport");
        customer.vote = (Integer) data.get("vote");
        customer.drivingLicense = (Integer) data.get("license");
        customer.health = (String) data.get("health");
        customer.centreCode = (String) data.get("centreCode");
        if (data.get("uiCode") != null) {
            customer.UICode = (String) data.get("uiCode");
        }
        if (data.get("thumb") != null) {
            customer.thumb = (Boolean) data.get("thumb");
        }
        if (data.get("finger") != null) {
            customer.fingerPrint = (Boolean) data.get("finger");
        }
        if (data.get("retina") != null) {
            customer.retinaScan = (Boolean) data.get("retina");
        }
        if (data.get("personal") != null) {
            customer.personalDetail = (String) data.get("personal");
        }
        customer.dateCreated = (Date) data.get("dateCreated");
        return customer;
    }

    public HashMap toHashMap() {
        HashMap data = new HashMap();
        data.put("firstName", firstName);
        data.put("midName", middleName);
        data.put("lastName", lastName);
        data.put("dob", dob);
        data.put("address", address);
        data.put("gender", gender);
        data.put("contact", contactDetail);
        data.put("email", email);
        data.put("occupation", occupation);
        data.put("education", education);
        data.put("married", married);
        data.put("passport", passport);
        data.put("vote", vote);
        data.put("license", drivingLicense);
        data.put("health", health);
        data.put("centreCode", centreCode);
        data.put("uiCode", UICode);
        data.put("dateCreated", dateCreated);
        return data;
    }
}
