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
                    view.getBirthdate().setEnabled(false);
                    view.getYear().setEnabled(false);
                    view.getMonth().setEnabled(false);
                    view.getDay().setEnabled(false);
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
            String fullName = view.getFullName().getText();
            String emailAddress = view.getEmailAddress().getText();
            String username = view.getUsername().getText();
            String contactNumber = view.getContactNumber().getText();
            String password = new String(view.getPassword().getPassword());
            String confirmPassword = new String(view.getConfirmPassword().getPassword());
            String enteredPasscode = view.getPasscode().getText();

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
                if(validateInput(fullName, emailAddress, username, contactNumber, password, confirmPassword)) {
                    success = true;
                }
            } else {
                view.getErrorMessage().setText("Incorrect passcode!");
                view.getErrorMessage().setForeground(Color.RED);
            }
        } else {
            String fullName = view.getFullName().getText();
            String emailAddress = view.getEmailAddress().getText();
            String username = view.getUsername().getText();
            String contactNumber = view.getContactNumber().getText();
            String password = new String(view.getPassword().getPassword());
            String confirmPassword = new String(view.getConfirmPassword().getPassword());
            String currentAddress = view.getCurrentAddress().getText();
            String occupation = view.getOccupation().getText();
            String companyName = view.getCompanyName().getText();
            String workType = (String) view.getWorkType().getSelectedItem();
            String birthdate = view.getBirthdate().getText();

            // validate inputs
            if(validateInput(fullName, emailAddress, username, contactNumber, password, confirmPassword,
                    currentAddress, occupation, companyName, workType, birthdate)) {
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

        // Validate email format
        if (!isValidEmail(emailAddress)) {
            view.getErrorMessage().setText("Please enter a valid email address.");
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

        // Validate contact number format (example: XXX-XXX-XXXX)
        if (!isValidContactNumber(contactNumber)) {
            view.getErrorMessage().setText("Please enter a valid contact number (XXX-XXX-XXXX).");
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
    private boolean validateInput(String fullName, String emailAddress, String username, String contactNumber, String password, String confirmPassword) {
        // Check if required fields are not empty
        if (fullName.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || username.isEmpty() ||
            emailAddress.isEmpty() || contactNumber.isEmpty()) {
            view.getErrorMessage().setText("Please fill in all required fields.");
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
        } else {
            view.getErrorMessage().setText(""); // Clear error message
        }

        // Validate contact number format (example: XXX-XXX-XXXX)
        if (!isValidContactNumber(contactNumber)) {
            view.getErrorMessage().setText("Please enter a valid contact number (XXX-XXX-XXXX).");
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

    private boolean isValidEmail(String email) {
        // IMPLEMENT
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
