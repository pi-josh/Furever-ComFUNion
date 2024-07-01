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
    
    public Veterinarian(int vetID, String vetPassword, String vetFullName,
                        int vetAge, String vetCellNum, String vetEmailAdd,
                        String vetUsername) {
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
        
        Veterinarian snoop = new Veterinarian(001, "pogiako123", "Snoop Dog", 52, "9124512315", "wildyoungfree1@yahoo.com", "wildyoungfree1");
        Veterinarian wally = new Veterinarian(002, "wallybayola17", "Wally Bayola", 51, "9632634189", "wallyeatbulaga1@gmail.com", "wallyeatbulaga1");
        Veterinarian coco = new Veterinarian(003, "angprobinsyano7", "Coco Martin", 42, "9326168234", "buhaypasicardo1@gmail.com", "buhaypasicardo1");
        Veterinarian snoop1 = new Veterinarian(001, "pogiako123", "Snoop Dog1", 52, "9124512315 (1)", "wildyoungfree2@yahoo.com", "wildyoungfree2");
        Veterinarian wally1 = new Veterinarian(002, "wallybayola17", "Wally Bayola1", 51, "9632634189 (1)", "wallyeatbulaga2@gmail.com", "wallyeatbulaga2");
        Veterinarian coco1 = new Veterinarian(003, "angprobinsyano7", "Coco Martin1", 42, "9326168234 (1)", "buhaypasicardo2@gmail.com", "buhaypasicardo2");
        Veterinarian snoop2 = new Veterinarian(001, "pogiako123", "Snoop Dog2", 52, "9124512315 (2)", "wildyoungfree3@yahoo.com", "wildyoungfree3");
        Veterinarian wally2 = new Veterinarian(002, "wallybayola17", "Wally Bayola2", 51, "9632634189 (2)", "wallyeatbulaga3@gmail.com", "wallyeatbulaga3");
        Veterinarian coco2 = new Veterinarian(003, "angprobinsyano7", "Coco Martin2", 42, "9326168234 (2)", "buhaypasicardo3@gmail.com", "buhaypasicardo3");
        
        vets.add(snoop);
        vets.add(wally);
        vets.add(coco);
        vets.add(snoop1);
        vets.add(wally1);
        vets.add(coco1);
        vets.add(snoop2);
        vets.add(wally2);
        vets.add(coco2);
        
        return vets;
    }
}
