package Models;

public class Application {
    private int applicationID;
    private String applicationType;
    private String appointDate;
    private String appointTime;
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
    public int getApplicationID() { return applicationID; }
    public String getApplicationType() { return applicationType; }
    public String getAppointDate() { return appointDate; }
    public String getAppointTime() { return appointTime; }
    public String getAppointStatus() { return appointStatus; }
    public int getClientID() { return clientID; }
    public String getVetName() { return vetName; }
    public String getPetName() { return petName; }
    public String getPetType() { return petType; }

    // setter methods
    public void setApplicationID(int applicationID) { this.applicationID = applicationID; }
    public void setApplicationType(String applicationType) { this.applicationType = applicationType; }
    public void setAppointDate(String appointDate) { this.appointDate = appointDate; }
    public void setAppointTime(String appointTime) { this.appointTime = appointTime; }
    public void setAppointStatus(String appointStatus) { this.appointStatus = appointStatus; }
    public void setClientID(int clientID) { this.clientID = clientID; }
    public void setVetName(String vetName) { this.vetName = vetName; }
    public void setPetName(String petName) { this.petName = petName; }
    public void setPetType(String petType) { this.petType = petType; }
}
