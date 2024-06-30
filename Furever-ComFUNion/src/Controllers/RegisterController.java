package Controllers;

import Models.User;
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
                // Directly handle mouse click event
                String fullName = view.getFullName().getText();
                String currentAddress = view.getCurrentAddress().getText();
                String username = view.getUsername().getText();
                String occupation = view.getOccupation().getText();
                String contactNumber = view.getContactNumber().getText();
                String companyName = view.getCompanyName().getText();
                String emailAddress = view.getEmailAddress().getText();
                String workType = (String) view.getWorkType().getSelectedItem();
                String password = new String(view.getPassword().getPassword());
                String birthdate = view.getBirthdate().getText();
                String confirmPassword = new String(view.getConfirmPassword().getPassword());
                boolean isVeterinarian = view.getAskVetCheckBox().isSelected();
                String passcode = view.getPasscode().getText();

                if (!validateInput(fullName, currentAddress, username, occupation, contactNumber, emailAddress,
                        workType, password, birthdate, confirmPassword, passcode)) {
                    return;
                }

                // Create a User object from input
                User newUser = new User(fullName, currentAddress, username, occupation, contactNumber,
                        companyName, emailAddress, workType, password, birthdate,
                        confirmPassword, isVeterinarian, passcode);

                // Save the user to database (simulate saving for demo)
                boolean success = saveUserToDatabase(newUser);

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
                } else {
                    view.getPasscodeScroll().setVisible(false);
                    view.getPasscodeLbl().setVisible(false);
                    view.getPasscode().setVisible(false);
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
        addKeyListenerToField(view.getUsername());
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
        String fullName = view.getFullName().getText();
        String currentAddress = view.getCurrentAddress().getText();
        String username = view.getUsername().getText();
        String occupation = view.getOccupation().getText();
        String contactNumber = view.getContactNumber().getText();
        String companyName = view.getCompanyName().getText();
        String emailAddress = view.getEmailAddress().getText();
        String workType = (String) view.getWorkType().getSelectedItem();
        String password = new String(view.getPassword().getPassword());
        String birthdate = view.getBirthdate().getText();
        String confirmPassword = new String(view.getConfirmPassword().getPassword());
        boolean isVeterinarian = view.getAskVetCheckBox().isSelected();
        String passcode = view.getPasscode().getText();

        // Validate input and show errors in label instead of dialog
        if (!validateInput(fullName, currentAddress, username, occupation, contactNumber, emailAddress,
                workType, password, birthdate, confirmPassword, passcode)) {
            return;
        }

        // Create a User object from input
        User newUser = new User(fullName, currentAddress, username, occupation, contactNumber,
                companyName, emailAddress, workType, password, birthdate,
                confirmPassword, isVeterinarian, passcode);

        // Save the user to database (simulate saving for demo)
        boolean success = saveUserToDatabase(newUser);

        if (success) {
            // Show success message (could update a status label if needed)
            view.getErrorMessage().setText("User registered successfully!");
            view.getErrorMessage().setForeground(Color.GREEN);
            // Clear fields after successful registration
            clearFields();
        } else {
            // Show error message in error label
            view.getErrorMessage().setText("Failed to register user. Please try again.");
            view.getErrorMessage().setForeground(Color.RED);
        }
    }

    private boolean validateInput(String fullName, String currentAddress, String username, String occupation,
                              String contactNumber, String emailAddress, String workType, String password,
                              String birthdate, String confirmPassword, String passcode) {
        boolean isValid = true;

        // Check if required fields are not empty
        if (fullName.isEmpty() || username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            view.getErrorMessage().setText("Please fill in all required fields.");
            view.getErrorMessage().setForeground(Color.RED);
            isValid = false;
            return false;
        } else {
            view.getErrorMessage().setText(""); // Clear error message
        }

        // Validate email format
        if (!isValidEmail(emailAddress)) {
            view.getErrorMessage().setText("Please enter a valid email address.");
            view.getErrorMessage().setForeground(Color.RED);
            isValid = false;
            return false;
        } else {
            view.getErrorMessage().setText(""); // Clear error message
        }

        // Validate birthdate format (example: MM/dd/yyyy)
        if (!isValidBirthdate(birthdate)) {
            view.getErrorMessage().setText("Please enter a valid birthdate (MM/dd/yyyy).");
            view.getErrorMessage().setForeground(Color.RED);
            isValid = false;
            return false;
        } else {
            view.getErrorMessage().setText(""); // Clear error message
        }

        // Validate contact number format (example: XXX-XXX-XXXX)
        if (!isValidContactNumber(contactNumber)) {
            view.getErrorMessage().setText("Please enter a valid contact number (XXX-XXX-XXXX).");
            view.getErrorMessage().setForeground(Color.RED);
            isValid = false;
            return false;
        } else {
            view.getErrorMessage().setText(""); // Clear error message
        }

        // Check if passwords match
        if (!password.equals(confirmPassword)) {
            view.getErrorMessage().setText("Passwords do not match.");
            view.getErrorMessage().setForeground(Color.RED);
            isValid = false;
            return false;
        } else {
            view.getErrorMessage().setText(""); // Clear error message
        }

        // Check if passcode is required for certain users
        if (view.getAskVetCheckBox().isSelected() && passcode.isEmpty()) {
            view.getErrorMessage().setText("Please enter a passcode.");
            view.getErrorMessage().setForeground(Color.RED);
            isValid = false;
            return false;
        } else {
            view.getErrorMessage().setText(""); // Clear error message
        }

        return isValid;
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


    private boolean saveUserToDatabase(User user) {
        // Example: Simulate saving user to database
        // Replace with actual database logic in your application
        System.out.println("Saving user to database: " + user.toString());
        // Simulate success/failure
        return true;  // For demo purposes, assume success
    }

    private void clearFields() {
        // Clear all input fields after successful registration
        view.getErrorMessage().setText("");
        view.getFullName().setText("");
        view.getCurrentAddress().setText("");
        view.getUsername().setText("");
        view.getOccupation().setText("");
        view.getContactNum().setText("");
        view.getCompanyName().setText("");
        view.getEmailAddress().setText("");
        view.getPassword().setText("");
        view.getConfirmPassword().setText("");
        view.getBirthdate().setText("");
        view.getPasscode().setText("");
    }

    public static void main(String[] args) {
        Register view = new Register();
        RegisterController controller = new RegisterController(view);
        view.setVisible(true);
    }
}
