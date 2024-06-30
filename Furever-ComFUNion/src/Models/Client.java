/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    private String clientOccupation;
    private String clientIncome;
    private String companyName;
    private String workType;
    
    public Client(int clientID, String clientPassword, String clientFullName,
                  int clientAge, String clientAddress, String cellNum,
                  String clientEmailAdd, String clientOccupation, String clientIncome,
                  String companyName, String workType) {
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
    
    public ArrayList<Client> getAllClientSamples() {
        ArrayList<Client> clients = new ArrayList<>();
        
        Client joshua = new Client(1, "tunaw123", "John Joshua Macatunao", 19, "81 Pouros Grove, Suite 091, 64822-2475, East Jaronfurt, Iowa, United States", "9892865657", "jjmelt@yahoo.com", "Photographer", "69000", "Melt Studio", "T");
        Client katrina = new Client(2, "tara8ball", "Katrina Halili", 20, "095 Loy Divide, Suite 919, 70892, Hansenstad, Wyoming, United States", "9652655123", "akonaman@gmail.com", "NASA Scientist", "405000", "NASA", "NT");
        Client joly = new Client(3, "jawlineislife", "Joly Gonzaga", 31, "Poblacion, Baliuag, Bulacan, Philippines", "9652235242", "McWater@yahoo.com", "Gym Instructor", "51000", "FItness Inc.", "NT");
        Client mark = new Client(4, "shhh!!!", "Mark Quiet", 21, "826 Loyal Point, Suite 753, 37394-6564, Kuphalton, Ohio, United States", "9528652421", "marktahimik@gmail.com", "Senior Software Engineer", "375635", "Microsoft", "NT");
        Client randy = new Client(5, "r.a.n.d.i.", "Randy Fernandez", 24, "77828 Towne Knoll, Suite 229, 24698-7170, Burniceburgh, West Virginia, United States", "9652234242", "Power.Fernandez01@y8mail.com", "Senior Fraud Analyst", "93290", "HSBC", "NT");
        
        clients.add(joshua);
        clients.add(katrina);
        clients.add(joly);
        clients.add(mark);
        clients.add(randy);

        return clients;
    }
}
