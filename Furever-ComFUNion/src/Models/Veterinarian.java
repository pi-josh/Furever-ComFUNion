/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

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
    
    Veterinarian(int vetID, String vetPassword, String vetFullName, int vetAge, String vetCellNum, String vetEmailAdd) {
        this.vetID = vetID;
        this.vetPassword = vetPassword;
        this.vetAge = vetAge;
        this.vetFullName = vetFullName;
        this.vetCellNum = vetCellNum;
        this.vetEmailAdd = vetEmailAdd;
    }
    
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
}
