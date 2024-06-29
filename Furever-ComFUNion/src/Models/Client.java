/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author joshu
 */
public class Client {
    private int clientID;
    private String clientPassword;
    private String clientFullName;
    private int clientAge;
    private String clientAddress;
    private String cellNum;
    private String clientEmailAdd;
    private String clientOccupation;
    private String clientIncome;
    private String companyName;
    private String workType;
    
    Client(int clientID, String clientPassword, String clientFullName, int clientAge, String clientAddress, String cellNum, String clientEmailAdd, String clientOccupation, String clientIncome, String companyName, String workType) {
        this.clientID = clientID;
        this.clientPassword = clientPassword;
        this.clientFullName = clientFullName;
        this.clientAge = clientAge;
        this.clientAddress = clientAddress;
        this.cellNum = cellNum;
        this.clientEmailAdd = clientEmailAdd;
        this.clientOccupation = clientOccupation;
        this.clientIncome = clientIncome;
        this.companyName = companyName;
        this.workType = workType;
    }
    
    // getter methods
    public int getClientID() {
        return clientID;
    }
    
    public String getClientPassword() {
        return clientPassword;
    }
    
    public String getClientFullName() {
        return clientFullName;
    }
    
    public int getClientAge() {
        return clientAge;
    }
    
    public String getClientAddress() {
        return clientAddress;
    }
    
    public String getCellNum() {
        return cellNum;
    }
    
    public String getClientEmailAdd() {
        return clientEmailAdd;
    }
    
    public String getClientOccupation() {
        return clientOccupation;
    }
    
    public String getClientIncome() {
        return clientIncome;
    }
    
    public String getCompanyName() {
        return companyName;
    }
    
    public String getWorkType() {
        return workType;
    } 
    
    // setter methods
    public void setClientID(int clientID) {
        this.clientID = clientID;
    }
    
    public void setClientPassword(String clientPassword) {
        this.clientPassword = clientPassword;
    }
    
    public void setClientFullName(String clientFullName) {
        this.clientFullName = clientFullName;
    }
    
    public void setClientAge(int clientAge) {
        this.clientAge = clientAge;
    }
    
    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }
    
    public void setCellNum(String cellNum) {
        this.cellNum = cellNum;
    }
    
    public void setClientEmailAdd(String clientEmailAdd) {
        this.clientEmailAdd = clientEmailAdd;
    }
    
    public void setClientOccupation(String clientOccupation) {
        this.clientOccupation = clientOccupation;
    }
    
    public void setClientIncome(String clientIncome) {
        this.clientIncome = clientIncome;
    }
    
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    
    public void setWorkType(String workType) {
        this.workType = workType;
    } 
    
}
