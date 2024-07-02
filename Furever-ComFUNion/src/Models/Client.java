package Models;

import java.util.ArrayList;

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
    private String clientUsername;
    private String clientOccupation;
    private String clientIncome;
    private String companyName;
    private String workType;
    private String clientAcctStatus;
    
    public Client(int clientID, String clientUsername, String clientPassword, String clientFullName,
                  int clientAge, String clientAddress, String cellNum, String clientEmailAdd,
                  String clientOccupation, String clientIncome, String companyName,
                  String workType, String clientAcctStatus) {
        this.clientID = clientID;
        this.clientPassword = clientPassword;
        this.clientFullName = clientFullName;
        this.clientAge = clientAge;
        this.clientAddress = clientAddress;
        this.cellNum = cellNum;
        this.clientEmailAdd = clientEmailAdd;
        this.clientUsername = clientUsername;
        this.clientOccupation = clientOccupation;
        this.clientIncome = clientIncome;
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
    
    public String getClientUsername() {
        return clientUsername;
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
    
    public String getClientAcctStatus() {
        return clientAcctStatus;
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
    
    public void setClientUsername(String clientUsername) {
        this.clientUsername = clientUsername;
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
    
    public void setClientAcctStatus(String clientAcctStatus) {
        this.clientAcctStatus = clientAcctStatus;
    }
    
    public ArrayList<Client> getAllClientSamples() {
        ArrayList<Client> clients = new ArrayList<>();
        
        clients.add(new Client(1, "JJMacatunao", "tunaw123", "John Joshua Macatunao", 19, "81 Pouros Grove, Suite 091, 64822-2475, East Jaronfurt, Iowa, United States", "9892865657", "jjmelt@yahoo.com", "Photographer", "69000", "Melt Studio", "T", "A"));
        clients.add(new Client(2, "Katrina14", "tara8ball", "Katrina Halili", 20, "095 Loy Divide, Suite 919, 70892, Hansenstad, Wyoming, United States", "9652655123", "akonaman@gmail.com", "NASA Scientist", "405000", "NASA", "NT", "A"));
        clients.add(new Client(3, "Joly@123", "jawlineislife", "Joly Gonzaga", 31, "Poblacion, Baliuag, Bulacan, Philippines", "9652235242", "McWater@yahoo.com", "Gym Instructor", "51000", "FItness Inc.", "NT", "A"));
        clients.add(new Client(4, "MarkQuiet28", "shhh!!!", "Mark Quiet", 21, "826 Loyal Point, Suite 753, 37394-6564, Kuphalton, Ohio, United States", "9528652421", "marktahimik@gmail.com", "Senior Software Engineer", "375635", "Microsoft", "NT", "A"));
        clients.add(new Client(5, "RandyF", "r.a.n.d.i.", "Randy Fernandez", 24, "77828 Towne Knoll, Suite 229, 24698-7170, Burniceburgh, West Virginia, United States", "9652234242", "Power.Fernandez01@y8mail.com", "Senior Fraud Analyst", "93290", "HSBC", "NT", "A"));

        return clients;
    }
}
