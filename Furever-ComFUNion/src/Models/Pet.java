package Models;


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
}
