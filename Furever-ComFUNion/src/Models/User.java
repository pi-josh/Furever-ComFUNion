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

public class User{
    private String fullName;
    private String currentAddress;
    private String username;
    private String occupation;
    private String contactNumber;
    private String companyName;
    private String emailAddress;
    private String workType;
    private String password;
    private String birthdate;
    private String confirmPassword;
    private boolean isVet;
    private String passcode;

    // this is for registering
    public User(String fullName, String currentAddress, String username, String occupation,
                String contactNumber, String companyName, String emailAddress, String workType,
                String password, String birthdate, String confirmPassword, boolean isVet, String passcode) {
        this.fullName = fullName;
        this.currentAddress = currentAddress;
        this.username = username;
        this.occupation = occupation;
        this.contactNumber = contactNumber;
        this.companyName = companyName;
        this.emailAddress = emailAddress;
        this.workType = workType;
        this.password = password;
        this.birthdate = birthdate;
        this.confirmPassword = confirmPassword;
        this.isVet = isVet;
        this.passcode = passcode;
    }
    
    // this is for logging in
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters and setters for all fields
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public boolean isVet() {
        return isVet;
    }

    public void setVet(boolean vet) {
        isVet = vet;
    }

    public String getPasscode() {
        return passcode;
    }

    public void setPasscode(String passcode) {
        this.passcode = passcode;
    }

    public boolean authenticate(String enteredUsername, String enteredPassword) {
        return username.equals(enteredUsername) && password.equals(enteredPassword);
    }
}

