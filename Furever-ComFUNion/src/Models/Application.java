/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author joshu
 */
public class Application {
    private int applicationID;
    private String applicationType;
    private Date appointDate;
    private String appointTime;
    private String appointPlace;
    private String appointStatus;
    private int clientID;
    private String vetID;
    private String petName;
    private String petType;

    
    public Application(int applicationID, String applicationType, Date appointDate,
                       String appointTime, String appointPlace, String appointStatus,
                       int clientID, String vetID, String petName, String petType) {
        this.applicationID = applicationID;
        this.applicationType = applicationType;
        this.appointDate = appointDate;
        this.appointTime = appointTime;
        this.appointPlace = appointPlace;
        this.appointStatus = appointStatus;
        this.clientID = clientID;
        this.vetID = vetID;
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
    
    public Date getAppointDate() {
        return appointDate;
    }
    
    public String getAppointTime() {
        return appointTime;
    }
    
    public String getAppointPlace() {
        return appointPlace;
    }
    
    public String getAppointStatus() {
        return appointStatus;
    }
    
    public int getClientID() {
        return clientID;
    }
    
    public String getVetID() {
        return vetID;
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
    
    public void setAppointDate(Date appointDate) {
        this.appointDate = appointDate;
    }
    
    public void setAppointTime(String appointTime) {
        this.appointTime = appointTime;
    }
    
    public void setAppointPlace(String appointPlace) {
        this.appointPlace = appointPlace;
    }
    
    public void setAppointStatus(String appointStatus) {
        this.appointStatus = appointStatus;
    }
    
    public void setClientID(int clientID) {
        this.clientID = clientID;
    }
    
    public void setVetID(String vetID) {
        this.vetID = vetID;
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
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        try {
            applications.add(new Application(1, "R", sdf.parse("2024-06-04"), "08:30", "Vet Clinic", "S", 1, "V001", "Hammy", "Hamster"));
            applications.add(new Application(2, "R", sdf.parse("2024-03-25"), "10:30", "Vet Clinic", "S", 2, "V003", "Cooper", "Dog"));
            applications.add(new Application(3, "R", sdf.parse("2024-04-12"), "12:00", "Vet Clinic", "S", 3, "V003", "Juswa", "Cat"));
            applications.add(new Application(4, "A", sdf.parse("2024-04-19"), "15:00", "Vet Clinic", "S", 4, "V001", "Raphael", "Dog"));
            applications.add(new Application(5, "A", sdf.parse("2024-04-25"), "16:00", "Vet Clinic", "S", 4, "V001", "Juswa", "Cat"));
            applications.add(new Application(6, "A", sdf.parse("2024-04-02"), "17:00", "Vet Clinic", "C", 4, "V001", "Cooper", "Dog"));
            applications.add(new Application(7, "A", sdf.parse("2024-04-19"), "15:00", "Vet Clinic", "C", 4, "V001", "Adjie", "Rabbit"));
            applications.add(new Application(8, "A", sdf.parse("2024-06-23"), "13:00", "Vet Clinic", "S", 5, "V002", "Hammy", "Hamster"));
            applications.add(new Application(9, "A", sdf.parse("2024-06-23"), "13:30", "Vet Clinic", "P", 5, "V002", "Gigi", "Cat"));
            applications.add(new Application(10, "R", sdf.parse("2024-07-23"), "09:30", "Vet Clinic", "S", 5, "V002", "Cassyyy", "Dog"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        for(Application app : applications) {
            if(app.getClientID() == clientID) {
                matchedApplications.add(app);
            }
        }
        
        return matchedApplications;
    }
    
    // this is for the veterinarian
    public ArrayList<Application> getAllApplicationSamples(String vetID) {
        ArrayList<Application> applications = new ArrayList<>();
        ArrayList<Application> matchedApplications = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        try {
            applications.add(new Application(1, "R", sdf.parse("2024-06-04"), "08:30", "Vet Clinic", "S", 1, "V001", "Hammy", "Hamster"));
            applications.add(new Application(2, "R", sdf.parse("2024-03-25"), "10:30", "Vet Clinic", "S", 2, "V003", "Cooper", "Dog"));
            applications.add(new Application(3, "R", sdf.parse("2024-04-12"), "12:00", "Vet Clinic", "S", 3, "V003", "Juswa", "Cat"));
            applications.add(new Application(4, "A", sdf.parse("2024-04-19"), "15:00", "Vet Clinic", "S", 4, "V001", "Raphael", "Dog"));
            applications.add(new Application(5, "A", sdf.parse("2024-04-25"), "16:00", "Vet Clinic", "S", 4, "V001", "Juswa", "Cat"));
            applications.add(new Application(6, "A", sdf.parse("2024-04-02"), "17:00", "Vet Clinic", "C", 4, "V001", "Cooper", "Dog"));
            applications.add(new Application(7, "A", sdf.parse("2024-04-19"), "15:00", "Vet Clinic", "C", 4, "V001", "Adjie", "Rabbit"));
            applications.add(new Application(8, "A", sdf.parse("2024-06-23"), "13:00", "Vet Clinic", "S", 5, "V002", "Hammy", "Hamster"));
            applications.add(new Application(9, "A", sdf.parse("2024-06-23"), "13:30", "Vet Clinic", "P", 5, "V002", "Gigi", "Cat"));
            applications.add(new Application(10, "R", sdf.parse("2024-07-23"), "09:30", "Vet Clinic", "S", 5, "V002", "Cassyyy", "Dog"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        for(Application app : applications) {
            if(app.getVetID().equals(vetID)) {
                matchedApplications.add(app);
            }
        }
        
        return matchedApplications;
    }
    
    // this is for the admin
    public ArrayList<Application> getAllApplicationSamples() {
        ArrayList<Application> applications = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        try {
            applications.add(new Application(1, "R", sdf.parse("2024-06-04"), "08:30", "Vet Clinic", "S", 1, "V001", "Hammy", "Hamster"));
            applications.add(new Application(2, "R", sdf.parse("2024-03-25"), "10:30", "Vet Clinic", "S", 2, "V003", "Cooper", "Dog"));
            applications.add(new Application(3, "R", sdf.parse("2024-04-12"), "12:00", "Vet Clinic", "S", 3, "V003", "Juswa", "Cat"));
            applications.add(new Application(4, "A", sdf.parse("2024-04-19"), "15:00", "Vet Clinic", "S", 4, "V001", "Raphael", "Dog"));
            applications.add(new Application(5, "A", sdf.parse("2024-04-25"), "16:00", "Vet Clinic", "S", 4, "V001", "Juswa", "Cat"));
            applications.add(new Application(6, "A", sdf.parse("2024-04-02"), "17:00", "Vet Clinic", "C", 4, "V001", "Cooper", "Dog"));
            applications.add(new Application(7, "A", sdf.parse("2024-04-19"), "15:00", "Vet Clinic", "C", 4, "V001", "Adjie", "Rabbit"));
            applications.add(new Application(8, "A", sdf.parse("2024-06-23"), "13:00", "Vet Clinic", "S", 5, "V002", "Hammy", "Hamster"));
            applications.add(new Application(9, "A", sdf.parse("2024-06-23"), "13:30", "Vet Clinic", "P", 5, "V002", "Gigi", "Cat"));
            applications.add(new Application(10, "R", sdf.parse("2024-07-23"), "09:30", "Vet Clinic", "S", 5, "V002", "Cassyyy", "Dog"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        return applications;
    }
}
