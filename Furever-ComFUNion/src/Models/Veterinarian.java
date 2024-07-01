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
public class Veterinarian {
    private int vetID;
    private String vetPassword;
    private int vetAge;
    private String vetFullName;
    private String vetCellNum;
    private String vetEmailAdd;
    private String vetUsername;
    
    public Veterinarian(int vetID, String vetUsername, String vetPassword, String vetFullName,
                        int vetAge, String vetCellNum, String vetEmailAdd) {
        this.vetID = vetID;
        this.vetPassword = vetPassword;
        this.vetAge = vetAge;
        this.vetFullName = vetFullName;
        this.vetCellNum = vetCellNum;
        this.vetEmailAdd = vetEmailAdd;
        this.vetUsername = vetUsername;
    }
    
    public Veterinarian() {}
    
    // getter methods
    public int getVetID() {
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
    
    // setter methods
    public void setVetID(int vetID) {
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
    
    public ArrayList<Veterinarian> getAllVetSamples() {
        ArrayList<Veterinarian> vets = new ArrayList<>();
        
        vets.add(new Veterinarian(001, "Snoopy420", "pogiako123", "Snoop Dog", 52, "9124512315", "wildyoungfree1@yahoo.com"));
        vets.add(new Veterinarian(002, "WallyBayola123", "wallybayola17", "Wally Bayola", 51, "9632634189", "wallyeatbulaga1@gmail.com"));
        vets.add(new Veterinarian(003, "CMartin01", "angprobinsyano7", "Coco Martin", 42, "9326168234", "buhaypasicardo1@gmail.com"));
        
        return vets;
    }
}
