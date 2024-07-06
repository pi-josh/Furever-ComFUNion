package Models;

import java.util.ArrayList;
import java.util.List;


public class Pet {
    private String petID;
    private String petType;
    private String petOrigin;
    private String petStatus;
    private String petSize;
    private String petAge;
    private String petName;
    private String petSex;
    private String picURL;

    // Default constructor
    public Pet() {}

    // Constructor with all parameters
    public Pet(String petID, String petType, String petOrigin, String petStatus, 
               String petSize, String petAge, String petName, String petSex, String picURL) {
        this.petID = petID;
        this.petType = petType;
        this.petOrigin = petOrigin;
        this.petStatus = petStatus;
        this.petSize = petSize;
        this.petAge = petAge;
        this.petName = petName;
        this.petSex = petSex;
        this.picURL = picURL;
    }

    // Constructor without picURL
    public Pet(String petID, String petType, String petOrigin, String petStatus, 
               String petSize, String petAge, String petName, String petSex) {
        this.petID = petID;
        this.petType = petType;
        this.petOrigin = petOrigin;
        this.petStatus = petStatus;
        this.petSize = petSize;
        this.petAge = petAge;
        this.petName = petName;
        this.petSex = petSex;
        setPicURLBasedOnType(petType);
    }

    // Method to set picURL based on petType
    public void setPicURLBasedOnType(String petType) {
        switch(petType) {
            case "Dog":
                this.picURL = "/Resources/sample pets/dog.png";
                break;
            case "Cat":
                this.picURL = "/Resources/sample pets/cat.png";
                break;
            case "Hamster":
                this.picURL = "/Resources/sample pets/hamster.png";
                break;
            case "Rabbit":
                this.picURL = "/Resources/sample pets/rabbit.png";
                break;
            default:
                this.picURL = "/Resources/sample pets/default.png";
                break;
        }
    }

    // Getter methods
    public String getPetID() { return petID; }
    public String getPetType() { return petType; }
    public String getPetOrigin() { return petOrigin; }
    public String getPetStatus() { return petStatus; }
    public String getPetSize() { return petSize; }
    public String getPetAge() { return petAge; }
    public String getPetName() { return petName; }
    public String getPetSex() { return petSex; }
    public String getPicURL() { return picURL; }

    // Setter methods
    public void setPetID(String petID) { this.petID = petID; }
    public void setPetType(String petType) { this.petType = petType; }
    public void setPetOrigin(String petOrigin) { this.petOrigin = petOrigin; }
    public void setPetStatus(String petStatus) { this.petStatus = petStatus; }
    public void setPetSize(String petSize) { this.petSize = petSize; }
    public void setPetAge(String petAge) { this.petAge = petAge; }
    public void setPetName(String petName) { this.petName = petName; }
    public void setPetSex(String petSex) { this.petSex = petSex; }
    public void setPicURL(String picURL) { this.picURL = picURL; }
    
    // Sample pets
    public ArrayList<Pet> getAllPetSamples() {
        ArrayList<Pet> pets = new ArrayList<>();
        
        Pet cassyyy = new Pet("P007", "Dog", "O", "NA", "S", "4", "Cassyyy", "M", "/Resources/sample pets/dog.png");
        Pet gigi = new Pet("P006", "Cat", "R", "NA", "M", "6", "Gigi", "F", "/Resources/sample pets/cat.png");
        Pet hammy = new Pet("P005", "Hamster", "O", "A", "T", "3", "Hammy", "M", "/Resources/sample pets/hamster.png");
        Pet adjie = new Pet("P004", "Rabbit", "R", "NA", "T", "15", "Adjie", "M", "/Resources/sample pets/rabbit.png");
        Pet cooper = new Pet("P003", "Dog", "O", "NA", "M", "7", "Cooper", "M", "/Resources/sample pets/dog.png");
        Pet juswa = new Pet("P002", "Cat", "O", "A", "L", "9", "Juswa", "M", "/Resources/sample pets/cat.png");
        Pet raphael = new Pet("P001", "Dog", "R", "A", "M", "2", "Raphael", "M", "/Resources/sample pets/dog.png");
        
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
