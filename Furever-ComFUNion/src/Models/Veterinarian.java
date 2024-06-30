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
    
    public Veterinarian(int vetID, String vetPassword, String vetFullName, int vetAge, String vetCellNum, String vetEmailAdd) {
        this.vetID = vetID;
        this.vetPassword = vetPassword;
        this.vetAge = vetAge;
        this.vetFullName = vetFullName;
        this.vetCellNum = vetCellNum;
        this.vetEmailAdd = vetEmailAdd;
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
    
    public ArrayList<Veterinarian> getAllVetSamples() {
        ArrayList<Veterinarian> vets = new ArrayList<>();
        
        Veterinarian snoop = new Veterinarian(001, "pogiako123", "Snoop Dog", 52, "9124512315", "wildyoungfree@yahoo.com");
        Veterinarian wally = new Veterinarian(002, "wallybayola17", "Wally Bayola", 51, "9632634189", "wallyeatbulaga@gmail.com");
        Veterinarian coco = new Veterinarian(003, "angprobinsyano7", "Coco Martin", 42, "9326168234", "buhaypasicardo@gmail.comwildyoungfree@yahoo.com");
        Veterinarian snoop1 = new Veterinarian(001, "pogiako123", "Snoop Dog1", 52, "9124512315 (1)", "wildyoungfree@yahoo.com");
        Veterinarian wally1 = new Veterinarian(002, "wallybayola17", "Wally Bayola1", 51, "9632634189 (1)", "wallyeatbulaga@gmail.com");
        Veterinarian coco1 = new Veterinarian(003, "angprobinsyano7", "Coco Martin1", 42, "9326168234 (1)", "buhaypasicardo@gmail.comwildyoungfree@yahoo.com");
        Veterinarian snoop2 = new Veterinarian(001, "pogiako123", "Snoop Dog2", 52, "9124512315 (2)", "wildyoungfree@yahoo.com");
        Veterinarian wally2 = new Veterinarian(002, "wallybayola17", "Wally Bayola2", 51, "9632634189 (2)", "wallyeatbulaga@gmail.com");
        Veterinarian coco2 = new Veterinarian(003, "angprobinsyano7", "Coco Martin2", 42, "9326168234 (2)", "buhaypasicardo@gmail.comwildyoungfree@yahoo.com");
        
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
