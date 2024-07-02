package Models;

import java.util.ArrayList;

/**
 * 
 * @author joshu
 */
public class Veterinarian {
    private String vetID;
    private String vetPassword;
    private int vetAge;
    private String vetFullName;
    private String vetCellNum;
    private String vetEmailAdd;
    private String vetUsername;
    private String vetAcctStatus;

    public Veterinarian(String vetID, String vetUsername, String vetPassword, String vetFullName,
                        int vetAge, String vetCellNum, String vetEmailAdd, String vetAcctStatus) {
        this.vetID = vetID;
        this.vetPassword = vetPassword;
        this.vetAge = vetAge;
        this.vetFullName = vetFullName;
        this.vetCellNum = vetCellNum;
        this.vetEmailAdd = vetEmailAdd;
        this.vetUsername = vetUsername;
        this.vetAcctStatus = vetAcctStatus;
    }

    public Veterinarian() {}

    // getter methods
    public String getVetID() {
        return vetID;
    }

    public String getVetPassword() {
        return vetPassword;
    }

    public int getVetAge() {
        return vetAge;
    }

    public String getVetFullName() {
        return vetFullName;
    }

    public String getVetCellNum() {
        return vetCellNum;
    }

    public String getVetEmailAdd() {
        return vetEmailAdd;
    }

    public String getVetUsername() {
        return vetUsername;
    }

    public String getVetAcctStatus() {
        return vetAcctStatus;
    }

    // setter methods
    public void setVetID(String vetID) {
        this.vetID = vetID;
    }

    public void setVetPassword(String vetPassword) {
        this.vetPassword = vetPassword;
    }

    public void setVetAge(int vetAge) {
        this.vetAge = vetAge;
    }

    public void setVetFullName(String vetFullName) {
        this.vetFullName = vetFullName;
    }

    public void setVetCellNum(String vetCellNum) {
        this.vetCellNum = vetCellNum;
    }

    public void setVetEmailAdd(String vetEmailAdd) {
        this.vetEmailAdd = vetEmailAdd;
    }

    public void setVetUsername(String vetUsername) {
        this.vetUsername = vetUsername;
    }

    public void setVetAcctStatus(String vetAcctStatus) {
        this.vetAcctStatus = vetAcctStatus;
    }

    public ArrayList<Veterinarian> getAllVetSamples() {
        ArrayList<Veterinarian> vets = new ArrayList<>();
        
        vets.add(new Veterinarian("V001", "Snoopy420", "pogiako123", "Snoop Dog", 52, "9124512315", "wildyoungfree1@yahoo.com", "A"));
        vets.add(new Veterinarian("V002", "WallyBayola123", "wallybayola17", "Wally Bayola", 51, "9632634189", "wallyeatbulaga1@gmail.com", "A"));
        vets.add(new Veterinarian("V003", "CMartin01", "angprobinsyano7", "Coco Martin", 42, "9326168234", "buhaypasicardo1@gmail.com", "A"));
        
        return vets;
    }
}
