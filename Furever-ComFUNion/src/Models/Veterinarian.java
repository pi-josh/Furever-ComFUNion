package Models;

/**
 * 
 * Author: joshu
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
    public String getVetID() { return vetID; }
    public String getVetPassword() { return vetPassword; }
    public int getVetAge() { return vetAge; }
    public String getVetFullName() { return vetFullName; }
    public String getVetCellNum() { return vetCellNum; }
    public String getVetEmailAdd() { return vetEmailAdd; }
    public String getVetUsername() { return vetUsername; }
    public String getVetAcctStatus() { return vetAcctStatus; }

    // setter methods
    public void setVetID(String vetID) { this.vetID = vetID; }
    public void setVetPassword(String vetPassword) { this.vetPassword = vetPassword; }
    public void setVetAge(int vetAge) { this.vetAge = vetAge; }
    public void setVetFullName(String vetFullName) { this.vetFullName = vetFullName; }
    public void setVetCellNum(String vetCellNum) { this.vetCellNum = vetCellNum; }
    public void setVetEmailAdd(String vetEmailAdd) { this.vetEmailAdd = vetEmailAdd; }
    public void setVetUsername(String vetUsername) { this.vetUsername = vetUsername; }
    public void setVetAcctStatus(String vetAcctStatus) { this.vetAcctStatus = vetAcctStatus; }
}
