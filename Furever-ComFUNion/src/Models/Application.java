package Models;

import java.util.ArrayList;

public class Application {
    private int applicationID;
    private String applicationType;
    private String appointDate;
    private String appointStatus;
    private int clientID;
    private String vetName;
    private String petName;
    private String petType;

    public Application(int applicationID, String applicationType, String appointDate, 
                       String appointStatus, int clientID, String vetName, String petName, String petType) {
        this.applicationID = applicationID;
        this.applicationType = applicationType;
        this.appointDate = appointDate;
        this.appointStatus = appointStatus;
        this.clientID = clientID;
        this.vetName = vetName;
        this.petName = petName;
        this.petType = petType;
    }
    
    public Application() {}
    
    // getter methods
    public int getApplicationID() {
        return applicationID;
    }
    
    public String getApplicationType() {
        return applicationType;
    }
    
    public String getAppointDate() {
        return appointDate;
    }
    
    public String getAppointStatus() {
        return appointStatus;
    }
    
    public int getClientID() {
        return clientID;
    }
    
    public String getVetName() {
        return vetName;
    }
    
    public String getPetName() {
        return petName;
    }
    
    public String getPetType() {
        return petType;
    }
    
    // setter methods
    public void setApplicationID(int applicationID) {
        this.applicationID = applicationID;
    }
    
    public void setApplicationType(String applicationType) {
        this.applicationType = applicationType;
    }
    
    public void setAppointDate(String appointDate) {
        this.appointDate = appointDate;
    }
    
    public void setAppointStatus(String appointStatus) {
        this.appointStatus = appointStatus;
    }
    
    public void setClientID(int clientID) {
        this.clientID = clientID;
    }
    
    public void setVetName(String vetName) {
        this.vetName = vetName;
    }
    
    public void setPetName(String petName) {
        this.petName = petName;
    }
    
    public void setPetType(String petType) {
        this.petType = petType;
    }
    
    // this is for the client
    public ArrayList<Application> getAllApplicationSamples(int clientID) {
        ArrayList<Application> applications = new ArrayList<>();
        ArrayList<Application> matchedApplications = new ArrayList<>();
        
        applications.add(new Application(1, "R", "2024-06-04", "S", 1, "Snoop Dog", "Hammy", "Hamster"));
        applications.add(new Application(2, "R", "2024-03-25", "S", 2, "Coco Martin", "Cooper", "Dog"));
        applications.add(new Application(3, "R", "2024-04-12", "S", 3, "Coco Martin", "Juswa", "Cat"));
        applications.add(new Application(4, "A", "2024-04-19", "S", 4, "Snoop Dog", "Raphael", "Dog"));
        applications.add(new Application(5, "A", "2024-04-25", "S", 4, "Snoop Dog", "Juswa", "Cat"));
        applications.add(new Application(6, "A", "2024-04-02", "C", 4, "Snoop Dog", "Cooper", "Dog"));
        applications.add(new Application(7, "A", "2024-04-19", "C", 4, "Snoop Dog", "Adjie", "Rabbit"));
        applications.add(new Application(8, "A", "2024-06-23", "S", 5, "Wally Bayola", "Hammy", "Hamster"));
        applications.add(new Application(9, "A", "2024-06-23", "P", 5, "Wally Bayola", "Gigi", "Cat"));
        applications.add(new Application(10, "R", "2024-07-23", "S", 5, "Wally Bayola", "Cassyyy", "Dog"));
        
        for(Application app : applications) {
            if(app.getClientID() == clientID) {
                matchedApplications.add(app);
            }
        }
        
        return matchedApplications;
    }
    
    // this is for the veterinarian
    public ArrayList<Application> getAllApplicationSamples(String vetName) {
        ArrayList<Application> applications = new ArrayList<>();
        ArrayList<Application> matchedApplications = new ArrayList<>();
        
        applications.add(new Application(1, "R", "2024-06-04", "S", 1, "Snoop Dog", "Hammy", "Hamster"));
        applications.add(new Application(2, "R", "2024-03-25", "S", 2, "Coco Martin", "Cooper", "Dog"));
        applications.add(new Application(3, "R", "2024-04-12", "S", 3, "Coco Martin", "Juswa", "Cat"));
        applications.add(new Application(4, "A", "2024-04-19", "S", 4, "Snoop Dog", "Raphael", "Dog"));
        applications.add(new Application(5, "A", "2024-04-25", "S", 4, "Snoop Dog", "Juswa", "Cat"));
        applications.add(new Application(6, "A", "2024-04-02", "C", 4, "Snoop Dog", "Cooper", "Dog"));
        applications.add(new Application(7, "A", "2024-04-19", "C", 4, "Snoop Dog", "Adjie", "Rabbit"));
        applications.add(new Application(8, "A", "2024-06-23", "S", 5, "Wally Bayola", "Hammy", "Hamster"));
        applications.add(new Application(9, "A", "2024-06-23", "P", 5, "Wally Bayola", "Gigi", "Cat"));
        applications.add(new Application(10, "R", "2024-07-23", "S", 5, "Wally Bayola", "Cassyyy", "Dog"));
        
        for(Application app : applications) {
            if(app.getVetName().equals(vetName)) {
                matchedApplications.add(app);
            }
        }
        
        return matchedApplications;
    }
    
    // this is for the default
    public ArrayList<Application> getAllApplicationSamples() {
        ArrayList<Application> applications = new ArrayList<>();
        
        applications.add(new Application(1, "R", "2024-06-04", "S", 1, "Snoop Dog", "Hammy", "Hamster"));
        applications.add(new Application(2, "R", "2024-03-25", "S", 2, "Coco Martin", "Cooper", "Dog"));
        applications.add(new Application(3, "R", "2024-04-12", "S", 3, "Coco Martin", "Juswa", "Cat"));
        applications.add(new Application(4, "A", "2024-04-19", "S", 4, "Snoop Dog", "Raphael", "Dog"));
        applications.add(new Application(5, "A", "2024-04-25", "S", 4, "Snoop Dog", "Juswa", "Cat"));
        applications.add(new Application(6, "A", "2024-04-02", "C", 4, "Snoop Dog", "Cooper", "Dog"));
        applications.add(new Application(7, "A", "2024-04-19", "C", 4, "Snoop Dog", "Adjie", "Rabbit"));
        applications.add(new Application(8, "A", "2024-06-23", "S", 5, "Wally Bayola", "Hammy", "Hamster"));
        applications.add(new Application(9, "A", "2024-06-23", "P", 5, "Wally Bayola", "Gigi", "Cat"));
        applications.add(new Application(10, "R", "2024-07-23", "S", 5, "Wally Bayola", "Cassyyy", "Dog"));
        
        return applications;
    }
}
