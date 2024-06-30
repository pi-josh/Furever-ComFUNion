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
public class Pet {
    private int petID;
    private String petType;
    private String petOrigin;
    private String petStatus;
    private String petSize;
    private int petAge;
    private String petName;
    private String petSex;
    private int petHistory;
    private int applicationID;
    private String picURL; // sample lang to since hindi ko alam kung pano yung blob sa db
    
    public Pet(int petID, String petType, String petOrigin, String petStatus, String petSize, int petAge, String petName, String petSex, int petHistory, int applicationID, String picURL) {
        this.petID = petID;
        this.petType = petType;
        this.petOrigin = petOrigin;
        this.petStatus = petStatus;
        this.petSize = petSize;
        this.petAge = petAge;
        this.petName = petName;
        this.petSex = petSex;
        this.petHistory = petHistory;
        this.picURL = picURL;
    }
    
    public Pet() {}
    
    // getter methods
    public int getPetID() {
        return petID;
    }
    
    public String getPetType() {
        return petType;
    }
    
    public String getPetOrigin() {
        return petOrigin;
    }
    
    public String getPetStatus() {
        return petStatus;
    }
    
    public String getPetSize() {
        return petSize;
    }
    
    public int getPetAge() {
        return petAge;
    }
    
    public String getPetName() {
        return petName;
    }
    
    public String getPetSex() {
        return petSex;
    }
    
    public int getPetHistory() {
        return petHistory;
    }
    
    public int getApplicationID() {
        return applicationID;
    }
    
    public String getPicURL() {
        return picURL;
    }
    
    
    // setter methods
    public void setPetID(int petID) {
        this.petID = petID;
    }
    
    public void setPetType(String petType) {
        this.petType = petType;
    }
    
    public void setPetOrigin(String petOrigin) {
        this.petOrigin = petOrigin;
    }
    
    public void setPetStatus(String petStatus) {
        this.petStatus = petStatus;
    }
    
    public void setPetSize(String petSize) {
        this.petSize = petSize;
    }
    
    public void setPetAge(int petAge) {
        this.petAge = petAge;
    }
    
    public void setPetName(String petName) {
        this.petName = petName;
    }
    
    public void setPetSex(String petSex) {
        this.petSex = petSex;
    }
    
    public void setPetHistory(int petHistory) {
        this.petHistory = petHistory;
    }
    
    public void setApplicationID(int applicationID) {
        this.applicationID = applicationID;
    }
    
    public void setPicURL(String picURL) {
        this.picURL = picURL;
    }
    
    public ArrayList<Pet> getAllPetSamples() {
        ArrayList<Pet> pets = new ArrayList<>();
        
        Pet cassyyy = new Pet(007, "Dog", "O", "NA", "S", 4, "Cassyyy", "M", 6, 6, "/Resources/sample pets/dog.png");
        Pet gigi = new Pet(006, "Cat", "R", "NA", "M", 6, "Gigi", "F", 0, 5, "/Resources/sample pets/cat.png");
        Pet hammy = new Pet(005, "Hamster", "O", "A", "T", 3, "Hammy", "M", 1, 5, "/Resources/sample pets/hamster.png");
        Pet adjie = new Pet(004, "Rabbit", "R", "NA", "T", 15, "Adjie", "M", 0, 4, "/Resources/sample pets/rabbit.png");
        Pet cooper = new Pet(003, "Dog", "O", "NA", "M", 7, "Cooper", "M", 2, 4, "/Resources/sample pets/dog.png");
        Pet juswa = new Pet(002, "Cat", "O", "A", "L", 9, "Juswa", "M", 3, 4, "/Resources/sample pets/cat.png");
        Pet raphael = new Pet(001, "Dog", "R", "A", "M", 2, "Raphael", "M", 0, 4, "/Resources/sample pets/dog.png");
        
        pets.add(cassyyy);
        pets.add(gigi);
        pets.add(hammy);
        pets.add(adjie);
        pets.add(cooper);
        pets.add(juswa);
        pets.add(raphael);
        
        return pets;
    }
}
