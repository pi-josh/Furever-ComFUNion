package Controllers;

import Views.Register;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class RegisterController {
    private final Register view;

    public RegisterController(Register view) {
        this.view = view;
        attachEventHandlers();
    }

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
                if(validateInput(fullName, emailAddress, username, contactNumber, password, confirmPassword, birthdate)) {
                    /* QUERY HERE: insert the record to the vet table
                    String acctStatus = 'A';
                    int age = birthdateToAge(birthdate);
                    success = methodName(username, password, fullName, age, contactNumber, emailAddress, acctStatus);    returns true if successful
                    */
                    success = true;
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
            if(validateInput(fullName, emailAddress, username, contactNumber, password, confirmPassword,
                    currentAddress, occupation, companyName, workType, birthdate)) {
                /* QUERY HERE: insert the record to the client table
                    String acctStatus = 'A';
                    int age = birthdateToAge(birthdate);
                    success = methodName(username, password, fullName, age, currentAddress, contactNumber,
                                         emailAddress, occupation, companyName, workType, acctStatus);    returns true if successful
                */
                success = true;
            }
        }

        if (success) {
            // Show success message
            JOptionPane.showMessageDialog(view, "User registered successfully!");
            // Clear fields after successful registration
            clearFields();
        } else {
            // Show error message
            JOptionPane.showMessageDialog(view, "Failed to register user. Please try again.");
        }
    }
    
    // for client
    private boolean validateInput(String fullName, String emailAddress, String username, String contactNumber, String password, String confirmPassword,
                    String currentAddress, String occupation, String companyName, String workType, String birthdate) {

        // Check if required fields are not empty
        if (fullName.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() ||
            currentAddress.isEmpty() || occupation.isEmpty() || workType.isEmpty() ||
            username.isEmpty() || companyName.isEmpty()) {
            view.getErrorMessage().setText("Please fill in all required fields.");
            view.getErrorMessage().setForeground(Color.RED);
            return false;
        } else {
            view.getErrorMessage().setText(""); // Clear error message
        }
        
        // Validate username
        if(isUsernameExist(username)) {
            view.getErrorMessage().setText("Username already exist.");
            view.getErrorMessage().setForeground(Color.RED);
            return false;
        } else {
            view.getErrorMessage().setText(""); // Clear error message
        }

        // Validate email format
        if (!isValidEmail(emailAddress)) {
            view.getErrorMessage().setText("Please enter a valid email address.");
            view.getErrorMessage().setForeground(Color.RED);
            return false;
        } else if(isEmailExist(emailAddress)) {
            view.getErrorMessage().setText("Email address already exist.");
            view.getErrorMessage().setForeground(Color.RED);
            return false;
        } else {
            view.getErrorMessage().setText(""); // Clear error message
        }

        // Validate birthdate format (example: MM/dd/yyyy)
        if (!isValidBirthdate(birthdate)) {
            view.getErrorMessage().setText("Please enter a valid birthdate (MM/dd/yyyy).");
            view.getErrorMessage().setForeground(Color.RED);
            return false;
        } else {
            view.getErrorMessage().setText(""); // Clear error message
        }

        // Validate contact number format (example: XXXXXXXXXX)
        if (!isValidContactNumber(contactNumber)) {
            view.getErrorMessage().setText("Please enter a valid contact number (XXX-XXX-XXXX).");
            view.getErrorMessage().setForeground(Color.RED);
            return false;
        } else if(isContactNumberExist(contactNumber)) {
            view.getErrorMessage().setText("Contact number already exist.");
            view.getErrorMessage().setForeground(Color.RED);
            return false;
        } else {
            view.getErrorMessage().setText(""); // Clear error message
        }

        // Check if passwords match
        if (!password.equals(confirmPassword)) {
            view.getErrorMessage().setText("Passwords do not match.");
            view.getErrorMessage().setForeground(Color.RED);
            return false;
        } else {
            view.getErrorMessage().setText(""); // Clear error message
        }
        
        return true;
    }
    
    // for vet
    private boolean validateInput(String fullName, String emailAddress, String username, String contactNumber, String password, String confirmPassword, String birthdate) {
        // Check if required fields are not empty
        if (fullName.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || username.isEmpty() ||
            emailAddress.isEmpty() || contactNumber.isEmpty() || birthdate.isEmpty()) {
            view.getErrorMessage().setText("Please fill in all required fields.");
            view.getErrorMessage().setForeground(Color.RED);
            return false;
        } else {
            view.getErrorMessage().setText(""); // Clear error message
        }
        
        // Validate username
        if(isUsernameExist(username)) {
            view.getErrorMessage().setText("Username already exist.");
            view.getErrorMessage().setForeground(Color.RED);
            return false;
        } else {
            view.getErrorMessage().setText(""); // Clear error message
        }

        // Validate email format
        if (!isValidEmail(emailAddress)) {
            view.getErrorMessage().setText("Please enter a valid email address.");
            view.getErrorMessage().setForeground(Color.RED);
            return false;
        } else if(isEmailExist(emailAddress)) {
            view.getErrorMessage().setText("Email address already exist.");
            view.getErrorMessage().setForeground(Color.RED);
            return false;
        } else {
            view.getErrorMessage().setText(""); // Clear error message
        }

        // Validate contact number format (example: XXXXXXXXXX)
        if (!isValidContactNumber(contactNumber)) {
            view.getErrorMessage().setText("Please enter a valid contact number (XXX-XXX-XXXX).");
            view.getErrorMessage().setForeground(Color.RED);
            return false;
        } else if(isContactNumberExist(contactNumber)) {
            view.getErrorMessage().setText("Contact number already exist.");
            view.getErrorMessage().setForeground(Color.RED);
            return false;
        } else {
            view.getErrorMessage().setText(""); // Clear error message
        }
        
        // Validate birthdate format (example: MM/dd/yyyy)
        if (!isValidBirthdate(birthdate)) {
            view.getErrorMessage().setText("Please enter a valid birthdate (MM/dd/yyyy).");
            view.getErrorMessage().setForeground(Color.RED);
            return false;
        } else {
            view.getErrorMessage().setText(""); // Clear error message
        }
        
        // Check if passwords match
        if (!password.equals(confirmPassword)) {
            view.getErrorMessage().setText("Passwords do not match.");
            view.getErrorMessage().setForeground(Color.RED);
            return false;
        } else {
            view.getErrorMessage().setText(""); // Clear error message
        }

        return true;
    }
    
    private boolean isUsernameExist(String username) {
        /* QUERY HERE: check if username already exist in client and vet tables
        return methodName(username);    // returns a boolean whether it exist or not
        */
        return false;
    }
    
    private boolean isEmailExist(String email) {
        /* QUERY HERE: check if email address already exist in client and vet tables
        return methodName(email);    // returns a boolean whether it exist or not
        */
        return false;
    }
    
    private boolean isContactNumberExist(String contactNumber) {
        /* QUERY HERE: check if contact number already exist in client and vet tables
        return methodName(contactNumber);    // returns a boolean whether it exist or not
        */
        return false;
    }

    private boolean isValidEmail(String email) {
        // IMPLEMENT HERE:
        return true;
    }

    private boolean isValidBirthdate(String birthdate) {
        // IMPLEMENT
        return true;
    }

    private boolean isValidContactNumber(String contactNumber) {
        // IMPLEMENT
        return true;
    }
    
    private int birthdateToAge(String birthdate) {
        // IMPLEMENT
        /*
           QUERY HERE: get the age of the user based on his/her birthday
        return methodName(birthdate);   this will return an integer value for age
        */
        return 0;
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
