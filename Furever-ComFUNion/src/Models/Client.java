package Models;

/**
 * 
 * Author: joshu
 */
public class Client {
    private int clientID;
    private String clientPassword;
    private String clientFullName;
    private int clientAge;
    private String clientAddress;
    private String cellNum;
    private String clientEmailAdd;
    private String clientUsername;
    private String clientOccupation;
    private String companyName;
    private String workType;
    private String clientAcctStatus;
    
    public Client(int clientID, String clientUsername, String clientPassword, String clientFullName,
                  int clientAge, String clientAddress, String cellNum, String clientEmailAdd,
                  String clientOccupation, String companyName, String workType, String clientAcctStatus) {
        this.clientID = clientID;
        this.clientPassword = clientPassword;
        this.clientFullName = clientFullName;
        this.clientAge = clientAge;
        this.clientAddress = clientAddress;
        this.cellNum = cellNum;
        this.clientEmailAdd = clientEmailAdd;
        this.clientUsername = clientUsername;
        this.clientOccupation = clientOccupation;
        this.companyName = companyName;
        this.workType = workType;
        this.clientAcctStatus = clientAcctStatus;
    }
    
    public Client(String enteredUsername, String enteredPassword) {
        this.clientUsername = enteredUsername;
        this.clientPassword = enteredPassword;
    }
    
    public Client() {}

    // getter methods
    public int getClientID() { return clientID; }
    public String getClientPassword() { return clientPassword; }
    public String getClientFullName() { return clientFullName; }
    public int getClientAge() { return clientAge; }
    public String getClientAddress() { return clientAddress; }
    public String getCellNum() { return cellNum; }
    public String getClientEmailAdd() { return clientEmailAdd; }
    public String getClientUsername() { return clientUsername; }
    public String getClientOccupation() { return clientOccupation; }
    public String getCompanyName() { return companyName; }
    public String getWorkType() { return workType; }
    public String getClientAcctStatus() { return clientAcctStatus; }

    // setter methods
    public void setClientID(int clientID) { this.clientID = clientID; }
    public void setClientPassword(String clientPassword) { this.clientPassword = clientPassword; }
    public void setClientFullName(String clientFullName) { this.clientFullName = clientFullName; }
    public void setClientAge(int clientAge) { this.clientAge = clientAge; }
    public void setClientAddress(String clientAddress) { this.clientAddress = clientAddress; }
    public void setCellNum(String cellNum) { this.cellNum = cellNum; }
    public void setClientEmailAdd(String clientEmailAdd) { this.clientEmailAdd = clientEmailAdd; }
    public void setClientUsername(String clientUsername) { this.clientUsername = clientUsername; }
    public void setClientOccupation(String clientOccupation) { this.clientOccupation = clientOccupation; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }
    public void setWorkType(String workType) { this.workType = workType; }
    public void setClientAcctStatus(String clientAcctStatus) { this.clientAcctStatus = clientAcctStatus; }
}
