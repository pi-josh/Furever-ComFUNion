package Controllers;

import Models.SPManager;
import Views.Register;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class RegisterController {
    // Database Manager
    SPManager spManager = new SPManager();
    
    private Register view = null;

    public RegisterController(Register view) {
        
        this.view = view;
        attachEventHandlers();
    }
        
    public RegisterController() {}
    
    private void attachEventHandlers() {
        // Register button events
        view.getRegisterButton().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registerUser();
            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                view.getRegisterButton().setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/register acc hover.png")));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                view.getRegisterButton().setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/register acc.png")));
            }
        });

        // Back button events
        view.getBackButton().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clearFields();
                view.setVisible(false);
            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                view.getBackButton().setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/back button hover (1).png")));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                view.getBackButton().setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/back button (1).png")));
            }
        });

        // Minimize button events
        view.getMinimizeButton().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                view.setState(JFrame.ICONIFIED);
            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                view.getMinimizeButton().setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/minimize button hover (1).png")));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                view.getMinimizeButton().setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/minimize button (1).png")));
            }
        });

        // Ask vet checkbox action event
        view.getAskVetCheckBox().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (view.getAskVetCheckBox().isSelected()) {
                    view.getPasscodeScroll().setVisible(true);
                    view.getPasscodeLbl().setVisible(true);
                    view.getPasscode().setVisible(true);
                    view.getCurrentAddress().setEnabled(false);
                    view.getOccupation().setEnabled(false);
                    view.getCompanyName().setEnabled(false);
                    view.getWorkType().setEnabled(false);
                    view.getBirthdate().setEnabled(true);
                    view.getYear().setEnabled(true);
                    view.getMonth().setEnabled(true);
                    view.getDay().setEnabled(true);
                } else {
                    view.getPasscodeScroll().setVisible(false);
                    view.getPasscodeLbl().setVisible(false);
                    view.getPasscode().setVisible(false);
                    view.getCurrentAddress().setEnabled(true);
                    view.getOccupation().setEnabled(true);
                    view.getCompanyName().setEnabled(true);
                    view.getWorkType().setEnabled(true);
                    view.getBirthdate().setEnabled(true);
                    view.getYear().setEnabled(true);
                    view.getMonth().setEnabled(true);
                    view.getDay().setEnabled(true);
                }
            }
        });

        // Login button events (assuming it's from another view)
        view.getLoginButton().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clearFields();
                view.loginButtonMouseClicked(evt);
            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                view.getLoginButton().setForeground(Color.RED);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                view.getLoginButton().setForeground(new java.awt.Color(99, 71, 12));
            }
        });

        // Key listener for ENTER and TAB keys on relevant fields
        addKeyListenerToField(view.getFullName());
        addKeyListenerToField(view.getCurrentAddress());
        addKeyListenerToField(view.getOccupation());
        addKeyListenerToField(view.getContactNum());
        addKeyListenerToField(view.getCompanyName());
        addKeyListenerToField(view.getEmailAddress());
        addKeyListenerToField(view.getPassword());
        addKeyListenerToField(view.getConfirmPassword());
        addKeyListenerToField(view.getBirthdate());
        addKeyListenerToField(view.getPasscode());
    }

    private void addKeyListenerToField(javax.swing.text.JTextComponent textComponent) {
        textComponent.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    evt.consume();
                    registerUser();
                } else if (evt.getKeyCode() == KeyEvent.VK_TAB) {
                    evt.consume();
                }
            }
        });
    }
    
    
    private void registerUser() {
        boolean success = false;
        
        // Vet Passcode
        String[] passcodes = {"group8IMBestGroup!", "ma'am monina is the best!"};
        boolean isVet = false;

        // Directly handle mouse click event
        boolean isVeterinarian = view.getAskVetCheckBox().isSelected();
        if(isVeterinarian) {
            String fullName = view.getFullName().getText().trim();
            String emailAddress = view.getEmailAddress().getText().trim();
            String username = view.getUsername().getText().trim();
            String contactNumber = view.getContactNum().getText().trim();
            String password = new String(view.getPassword().getPassword());
            String confirmPassword = new String(view.getConfirmPassword().getPassword());
            String enteredPasscode = view.getPasscode().getText();
            String birthdate = view.getBirthdate().getText().trim();
            
            System.out.println(fullName + " " + emailAddress + " " + username + " " + contactNumber + " " + password + " " + confirmPassword + " " + enteredPasscode + " " + birthdate);

            if(enteredPasscode.isEmpty()) {
                view.getErrorMessage().setText("Please enter the passcode.");
                view.getErrorMessage().setForeground(Color.RED);
            } else {
                view.getErrorMessage().setText(""); // Clear error message
            }

            // Check if passcode matches
            for(String passcode : passcodes) {
                if(enteredPasscode.equals(passcode)) {
                    isVet = true;
                    break;
                }
            }

            if(isVet) {
                view.getErrorMessage().setText(""); // Clear error message
                if(validateVetInput(fullName, emailAddress, username, contactNumber, password, confirmPassword, birthdate)) {
                    //QUERY HERE: insert the record to the vet table
                    String acctStatus = "A";
                    int age = convertBirthdateToAge(birthdate);
                    success = spManager.registerVet(username, password, fullName, age, contactNumber, emailAddress, acctStatus);   // returns true if successful
                }
            } else {
                view.getErrorMessage().setText("Incorrect passcode!");
                view.getErrorMessage().setForeground(Color.RED);
            }
        } else {
            String fullName = view.getFullName().getText().trim();
            String emailAddress = view.getEmailAddress().getText().trim();
            String username = view.getUsername().getText().trim();
            String contactNumber = view.getContactNum().getText().trim();
            String password = new String(view.getPassword().getPassword());
            String confirmPassword = new String(view.getConfirmPassword().getPassword());
            String currentAddress = view.getCurrentAddress().getText().trim();
            String occupation = view.getOccupation().getText().trim();
            String companyName = view.getCompanyName().getText().trim();
            String workType = (String) view.getWorkType().getSelectedItem();
            String birthdate = view.getBirthdate().getText().trim();
            
            System.out.println(fullName + " " + emailAddress + " " + username + " " + contactNumber + " " + password + " " +
                    confirmPassword + " " + currentAddress + " " + occupation + " " + companyName + " " + workType + " " + birthdate);

            // validate inputs
            if(validateClientInput(fullName, emailAddress, username, contactNumber, password, confirmPassword,
                    currentAddress, occupation, companyName, workType, birthdate)) {
                // QUERY HERE: insert the record to the client table
                    String acctStatus = "A";
                    int age = convertBirthdateToAge(birthdate);
                    success = spManager.registerClient(username, password, fullName, age, currentAddress, contactNumber,
                                         emailAddress, occupation, companyName, workType, acctStatus);  //  returns true if successful
            }
        }

        if (success) {
            // Show success message
            JOptionPane.showMessageDialog(view, "User registered successfully!");
            // Clear fields after successful registration
            clearFields();
        }
    }
    
    // For client
    public boolean validateClientInput(String fullName, String emailAddress, String username, String contactNumber, String password, String confirmPassword,
                                       String currentAddress, String occupation, String companyName, String workType, String birthdate) {

        // Check if required fields are not empty
        if (fullName.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() ||
                currentAddress.isEmpty() || occupation.isEmpty() || workType.isEmpty() ||
                username.isEmpty() || companyName.isEmpty()) {
            showErrorDialog("Please fill in all required fields.");
            return false;
        }

        // Validate username
        if (isUsernameExist(username)) {
            showErrorDialog("Username already exists.");
            return false;
        }

        // Validate email format
        if (!isValidEmail(emailAddress)) {
            showErrorDialog("Please enter a valid email address.");
            return false;
        } else if (isEmailExist(emailAddress)) {
            showErrorDialog("Email address already exists.");
            return false;
        }

        // Validate birthdate format (example: MM/dd/yyyy)
        if (!"".equals(birthdate)) {
            if (!isValidBirthdate(birthdate)) {
                showErrorDialog("Please enter a valid birthdate (MM/dd/yyyy).");
                return false;
            }
        }

        // Validate contact number format (example: XXX-XXX-XXXX)
        if (!isValidContactNumber(contactNumber)) {
            showErrorDialog("Please enter a valid contact number (XXX-XXX-XXXX).");
            return false;
        } else if (isContactNumberExist(contactNumber)) {
            showErrorDialog("Contact number already exists.");
            return false;
        }

        // Check if passwords match
        if (!password.equals(confirmPassword)) {
            showErrorDialog("Passwords do not match.");
            return false;
        }

        return true;
    }

    // For vet
    public boolean validateVetInput(String fullName, String emailAddress, String username, String contactNumber, String password, String confirmPassword, String birthdate) {
        // Check if required fields are not empty
        if (fullName.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || username.isEmpty() ||
                emailAddress.isEmpty() || contactNumber.isEmpty() || birthdate.isEmpty()) {
            showErrorDialog("Please fill in all required fields.");
            return false;
        }

        // Validate username
        if (isUsernameExist(username)) {
            showErrorDialog("Username already exists.");
            return false;
        }

        // Validate email format
        if (!isValidEmail(emailAddress)) {
            showErrorDialog("Please enter a valid email address.");
            return false;
        } else if (isEmailExist(emailAddress)) {
            showErrorDialog("Email address already exists.");
            return false;
        }

        // Validate contact number format (example: XXX-XXX-XXXX)
        if (!isValidContactNumber(contactNumber)) {
            showErrorDialog("Please enter a valid contact number (XXX-XXX-XXXX).");
            return false;
        } else if (isContactNumberExist(contactNumber)) {
            showErrorDialog("Contact number already exists.");
            return false;
        }

        // Validate birthdate format (example: MM/dd/yyyy)
        if (!isValidBirthdate(birthdate)) {
            showErrorDialog("Please enter a valid birthdate (MM/dd/yyyy).");
            return false;
        }

        // Check if passwords match
        if (!password.equals(confirmPassword)) {
            showErrorDialog("Passwords do not match.");
            return false;
        }

        return true;
    }

    // Helper method to show error dialog
    private void showErrorDialog(String message) {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    private boolean isUsernameExist(String username) {
        // QUERY HERE: check if username already exist in client and vet tables
        return spManager.isUsernameExistQuery(username);    // returns a boolean whether it exist or not
    }
    
    private boolean isEmailExist(String email) {
        // QUERY HERE: check if email address already exist in client and vet tables
        return spManager.isEmailExistQuery(email);    // returns a boolean whether it exist or not
    }
    
    private boolean isContactNumberExist(String contactNumber) {
        // QUERY HERE: check if contact number already exist in client and vet tables
        return spManager.isCellNumExistQuery(contactNumber);    // returns a boolean whether it exist or not
    }

    private boolean isValidEmail(String email) {
        // IMPLEMENT HERE:
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        if (email == null) {
            return false;
        }
        return pattern.matcher(email).matches();
    }

    private boolean isValidBirthdate(String birthdate) {
        // IMPLEMENT HERE:
        // Ensure date is in YYYY-MM-DD format
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            LocalDate date = LocalDate.parse(birthdate, dateFormatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    private boolean isValidContactNumber(String contactNumber) {
        // IMPLEMENT HERE:
        // Check if the contact number contains only digits, has a length of 10, and starts with 9
        if (contactNumber == null || contactNumber.isEmpty()) {
            return false;
        }
        String contactNumberRegex = "^9\\d{9}$";
        return contactNumber.matches(contactNumberRegex);
    }
    
    private int convertBirthdateToAge(String birthdate) {
        // IMPLEMENT HERE:
        // QUERY HERE: get the age of the user based on his/her birthday
        return spManager.birthdateToAge(birthdate);  // this will return an integer value for age
    }

    private void clearFields() {
        // Clear all input fields after successful registration
        view.getErrorMessage().setText("");
        view.getFullName().setText("");
        view.getCurrentAddress().setText("");
        view.getOccupation().setText("");
        view.getContactNum().setText("");
        view.getCompanyName().setText("");
        view.getEmailAddress().setText("");
        view.getPassword().setText("");
        view.getConfirmPassword().setText("");
        view.getBirthdate().setText("");
        view.getPasscode().setText("");
        
        view.getAskVetCheckBox().setSelected(false);
        view.getPasscodeScroll().setVisible(false);
        view.getPasscodeLbl().setVisible(false);
        view.getPasscode().setVisible(false);
        view.getCurrentAddress().setEnabled(true);
        view.getOccupation().setEnabled(true);
        view.getCompanyName().setEnabled(true);
        view.getWorkType().setEnabled(true);
        view.getBirthdate().setEnabled(true);
        view.getYear().setEnabled(true);
        view.getMonth().setEnabled(true);
        view.getDay().setEnabled(true);
    }

    public static void main(String[] args) {
        Register view = new Register();
        RegisterController controller = new RegisterController(view);
        view.setVisible(true);
    }
}
