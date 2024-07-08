/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controllers.LoginController;
import java.awt.MediaTracker;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.*;

/**
 *
 * @author joshu
 */
public class Register extends javax.swing.JFrame {
    // for moving the frame
    private Point mouseDownCompCoords;
    
    // controller
    private LoginController loginController;
    
    // frames
    private LandingPage landingPage;
    private Login login;

    // Constructor with LandingPage parameter
    public Register(LandingPage landingPage) {
        this.landingPage = landingPage;
        login = landingPage.getLogin();
        initComponents();
        initializeForm();
        errorMessage.setText("");
    }

    // Default constructor
    public Register() {
        initComponents();
        initializeForm();
    }

    private void initializeForm() {
        // Common initialization for both constructors
        passcodeScroll.setVisible(false);
        passcodeLbl.setVisible(false);
        passcode.setVisible(false);

        year.addActionListener(new ComboBoxActionListener());
        month.addActionListener(new ComboBoxActionListener());

        populateComboBoxes();
        setWindowIcon();
        
        // set the default value of birthdate based on the default value of year, month, and day comboboxes
        List<String> yearMonthDay = new ArrayList<>();
        yearMonthDay.add((String) year.getSelectedItem());
        yearMonthDay.add((String) month.getSelectedItem());
        yearMonthDay.add((String) day.getSelectedItem());
        birthdate.setText("".join("-", yearMonthDay));
    }
    
    private void setWindowIcon() {
        ImageIcon icon1 = null;
        try {
            icon1 = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Resources/logo2.png")));
            if (icon1.getImageLoadStatus() == MediaTracker.ERRORED) {
                throw new NullPointerException("Image not found or cannot be loaded.");
            }
            this.setIconImage(icon1.getImage());
        } catch (NullPointerException e) {
            System.err.println("Error: Image not found. " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    // getters
    public Login getLogin() {
        return login;
    }
    
    // Getter methods for all components
    public javax.swing.JCheckBox getAskVetCheckBox() {
        return askVet;
    }

    public JLabel getBackButton() {
        return backButton;
    }

    public JTextPane getBirthdate() {
        return birthdate;
    }

    public JTextPane getCompanyName() {
        return companyName;
    }


    public JPasswordField getConfirmPassword() {
        return confirmPassword;
    }

    public JTextPane getContactNum() {
        return contactNum;
    }

    public JTextPane getCurrentAddress() {
        return currentAddress;
    }

    public JComboBox<String> getDay() {
        return day;
    }

    public JTextPane getEmailAddress() {
        return emailAddress;
    }

    public JLabel getErrorMessage() {
        return errorMessage;
    }

    public JTextPane getFullName() {
        return fullName;
    }

    public JLabel getLoginButton() {
        return loginButton;
    }
    
    public JLabel getMinimizeButton() {
        return minimizeButton;
    }

    public JComboBox<String> getMonth() {
        return month;
    }

    public JTextPane getOccupation() {
        return occupation;
    }
    
    public JTextPane getUsername() {
        return username;
    }


    public JTextPane getPasscode() {
        return passcode;
    }

    public JLabel getPasscodeLbl() {
        return passcodeLbl;
    }

    public JScrollPane getPasscodeScroll() {
        return passcodeScroll;
    }

    public JPasswordField getPassword() {
        return password;
    }

    public JLabel getPasswordLabel() {
        return passwordLabel;
    }

    public JLabel getRegisterBg() {
        return registerBg;
    }

    public JLabel getRegisterButton() {
        return registerButton;
    }


    public JComboBox<String> getWorkType() {
        return workType;
    }

    public JComboBox<String> getYear() {
        return year;
    }

    public boolean isVet() {
        return askVet.isSelected();
    }
    
    private void populateComboBoxes() {
        // Populate worktype combobox
        workType.addItem("Travel");
        workType.addItem("No Travel");

        // Populate year combobox
        int currentYear = YearMonth.now().getYear();
        for (int y = 1960; y <= currentYear; y++) {
            String yearValue = String.valueOf(y);
            year.addItem(yearValue);
        }

        // Populate month combobox
        for (int m = 1; m <= 12; m++) {
            String monthValue = String.valueOf(m);
            if(m < 10) {
                monthValue = "0" + monthValue;
            }
            
            month.addItem(monthValue);
        }

        // Initially populate day combobox based on current year and month
        updateDays();
    }

    private class ComboBoxActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            updateDays();
        }
    }

    private void updateDays() {
        Object selectedYearObj = year.getSelectedItem();
        Object selectedMonthObj = month.getSelectedItem();

        if (selectedYearObj != null && selectedMonthObj != null) {
            Integer selectedYear;
            Integer selectedMonth;

            if (selectedYearObj instanceof String) {
                selectedYear = Integer.parseInt((String) selectedYearObj);
            } else {
                selectedYear = (Integer) selectedYearObj;
            }

            if (selectedMonthObj instanceof String) {
                selectedMonth = Integer.parseInt((String) selectedMonthObj);
            } else {
                selectedMonth = (Integer) selectedMonthObj;
            }

            YearMonth yearMonth = YearMonth.of(selectedYear, selectedMonth);
            int daysInMonth = yearMonth.lengthOfMonth();
            day.removeAllItems();
            for (int d = 1; d <= daysInMonth; d++) {
                String dayValue = String.valueOf(d);
                if(d < 10) {
                    dayValue = "0" + dayValue;
                }
                day.addItem(dayValue);
            }
        }
    }
    
    public void loginButtonMouseClicked(java.awt.event.MouseEvent evt) {
        if (landingPage != null) {
            login = landingPage.getLogin();
        }
        
        if (login == null) {
            login = new Login(landingPage);
            loginController = new LoginController(login);
            login.setVisible(true);
        } else if (!login.isVisible()) {
            login.setVisible(true);
        }
        else {
            login.toFront();
            login.requestFocus();
        }
        this.dispose();
    }
  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        minimizeButton = new javax.swing.JLabel();
        backButton = new javax.swing.JLabel();
        titleContainer = new javax.swing.JPanel();
        registerHeader = new javax.swing.JLabel();
        registerContainer = new javax.swing.JPanel();
        currentAddressLabel = new javax.swing.JLabel();
        currentAddressScroll = new javax.swing.JScrollPane();
        currentAddress = new javax.swing.JTextPane();
        occupationLabel = new javax.swing.JLabel();
        occupationScroll = new javax.swing.JScrollPane();
        occupation = new javax.swing.JTextPane();
        companyNameLabel = new javax.swing.JLabel();
        companyNameScroll = new javax.swing.JScrollPane();
        companyName = new javax.swing.JTextPane();
        workTypeLabel = new javax.swing.JLabel();
        workType = new javax.swing.JComboBox<>();
        birthdateLabel = new javax.swing.JLabel();
        birthdateScroll = new javax.swing.JScrollPane();
        birthdate = new javax.swing.JTextPane();
        registerButton = new javax.swing.JLabel();
        loginDescription = new javax.swing.JLabel();
        loginButton = new javax.swing.JLabel();
        year = new javax.swing.JComboBox<>();
        month = new javax.swing.JComboBox<>();
        day = new javax.swing.JComboBox<>();
        askVet = new javax.swing.JCheckBox();
        passcodeLbl = new javax.swing.JLabel();
        passcodeScroll = new javax.swing.JScrollPane();
        passcode = new javax.swing.JTextPane();
        fullNameLabel = new javax.swing.JLabel();
        fullNameScroll = new javax.swing.JScrollPane();
        fullName = new javax.swing.JTextPane();
        contactNumber = new javax.swing.JLabel();
        contactNumScroll = new javax.swing.JScrollPane();
        contactNum = new javax.swing.JTextPane();
        emailAddressLabel = new javax.swing.JLabel();
        emailAddressScroll = new javax.swing.JScrollPane();
        emailAddress = new javax.swing.JTextPane();
        passwordLabel = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        confirmPassword = new javax.swing.JPasswordField();
        confirmPasswordLabel = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        username = new javax.swing.JTextPane();
        errorMessage = new javax.swing.JLabel();
        errorMessageContainer = new javax.swing.JLabel();
        registerBg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Register");
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        minimizeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/minimize button (1).png"))); // NOI18N
        getContentPane().add(minimizeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(815, 10, 40, 20));

        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/back button (1).png"))); // NOI18N
        getContentPane().add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(855, 5, 40, 40));

        titleContainer.setBackground(new java.awt.Color(194, 144, 69));
        titleContainer.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        titleContainer.setPreferredSize(new java.awt.Dimension(900, 75));
        titleContainer.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                titleContainerMouseDragged(evt);
            }
        });
        titleContainer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                titleContainerMousePressed(evt);
            }
        });
        titleContainer.setLayout(new java.awt.GridBagLayout());

        registerHeader.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        registerHeader.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/register header.png"))); // NOI18N
        titleContainer.add(registerHeader, new java.awt.GridBagConstraints());

        getContentPane().add(titleContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        registerContainer.setBackground(new java.awt.Color(255, 250, 205));
        registerContainer.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        registerContainer.setPreferredSize(new java.awt.Dimension(900, 575));
        registerContainer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        currentAddressLabel.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        currentAddressLabel.setText("Current Address:");
        registerContainer.add(currentAddressLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 140, -1, -1));

        currentAddressScroll.setHorizontalScrollBar(null);
        currentAddressScroll.setViewportView(currentAddress);

        registerContainer.add(currentAddressScroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 170, 280, -1));

        occupationLabel.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        occupationLabel.setText("Occupation:");
        registerContainer.add(occupationLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 210, -1, -1));

        occupationScroll.setHorizontalScrollBar(null);
        occupationScroll.setViewportView(occupation);

        registerContainer.add(occupationScroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 240, 280, -1));

        companyNameLabel.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        companyNameLabel.setText("Company Name:");
        registerContainer.add(companyNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 270, -1, -1));

        companyNameScroll.setHorizontalScrollBar(null);
        companyNameScroll.setViewportView(companyName);

        registerContainer.add(companyNameScroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 300, 280, -1));

        workTypeLabel.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        workTypeLabel.setText("Work Type:");
        registerContainer.add(workTypeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 330, -1, -1));

        registerContainer.add(workType, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 360, 280, -1));

        birthdateLabel.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        birthdateLabel.setText("Birthday (yyyy-mm-dd)");
        registerContainer.add(birthdateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 390, -1, -1));

        birthdateScroll.setHorizontalScrollBar(null);
        birthdateScroll.setViewportView(birthdate);

        registerContainer.add(birthdateScroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 420, 90, -1));

        registerButton.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        registerButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/register acc.png"))); // NOI18N
        registerContainer.add(registerButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 460, -1, -1));

        loginDescription.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        loginDescription.setText("Already have an account? ");
        registerContainer.add(loginDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 530, -1, -1));

        loginButton.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        loginButton.setForeground(new java.awt.Color(99, 71, 12));
        loginButton.setText("<html> <u>Login here</u> </html>");
        registerContainer.add(loginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 530, -1, -1));

        year.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setBirthdate(evt);
            }
        });
        registerContainer.add(year, new org.netbeans.lib.awtextra.AbsoluteConstraints(615, 420, 70, -1));

        month.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setBirthdate(evt);
            }
        });
        registerContainer.add(month, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 420, 53, -1));

        day.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setBirthdate(evt);
            }
        });
        registerContainer.add(day, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 420, 53, -1));

        askVet.setText("Are you a veterinarian?");
        registerContainer.add(askVet, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, -1, -1));

        passcodeLbl.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        passcodeLbl.setText("Passcode:");
        registerContainer.add(passcodeLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, -1, -1));

        passcodeScroll.setHorizontalScrollBar(null);
        passcodeScroll.setViewportView(passcode);

        registerContainer.add(passcodeScroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 280, -1));

        fullNameLabel.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        fullNameLabel.setText("Full Name [First, Last]:");
        registerContainer.add(fullNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, -1, -1));

        fullNameScroll.setHorizontalScrollBar(null);
        fullNameScroll.setViewportView(fullName);

        registerContainer.add(fullNameScroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 280, -1));

        contactNumber.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        contactNumber.setText("Contact Number:");
        registerContainer.add(contactNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, -1, -1));

        contactNumScroll.setHorizontalScrollBar(null);

        contactNum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                contactNumKeyTyped(evt);
            }
        });
        contactNumScroll.setViewportView(contactNum);

        registerContainer.add(contactNumScroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 110, 280, -1));

        emailAddressLabel.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        emailAddressLabel.setText("Email Address:");
        registerContainer.add(emailAddressLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, -1, -1));

        emailAddressScroll.setHorizontalScrollBar(null);
        emailAddressScroll.setViewportView(emailAddress);

        registerContainer.add(emailAddressScroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, 280, -1));

        passwordLabel.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        passwordLabel.setText("Password:");
        registerContainer.add(passwordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, -1, -1));
        registerContainer.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 360, 280, -1));
        registerContainer.add(confirmPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 420, 280, -1));

        confirmPasswordLabel.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        confirmPasswordLabel.setText("Confirm Password:");
        registerContainer.add(confirmPasswordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 390, -1, -1));

        usernameLabel.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        usernameLabel.setText("Username:");
        registerContainer.add(usernameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 270, -1, -1));

        jScrollPane10.setHorizontalScrollBar(null);
        jScrollPane10.setViewportView(username);

        registerContainer.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, 280, -1));

        errorMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        errorMessage.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        registerContainer.add(errorMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 480, 230, 40));

        errorMessageContainer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/success error container.png"))); // NOI18N
        registerContainer.add(errorMessageContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 460, 280, 80));

        registerBg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/register bg.png"))); // NOI18N
        registerBg.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        registerContainer.add(registerBg, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 25, 660, 560));

        getContentPane().add(registerContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 75, 900, 610));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void titleContainerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_titleContainerMouseDragged
        // TODO add your handling code here:
        Point currCoords = evt.getLocationOnScreen();
        setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);
    }//GEN-LAST:event_titleContainerMouseDragged

    private void titleContainerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_titleContainerMousePressed
        // TODO add your handling code here:
        mouseDownCompCoords = evt.getPoint();
    }//GEN-LAST:event_titleContainerMousePressed

    private void setBirthdate(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setBirthdate
        // TODO add your handling code here:
        List<String> yearMonthDay = new ArrayList<>();
        yearMonthDay.add((String) year.getSelectedItem());
        yearMonthDay.add((String) month.getSelectedItem());
        yearMonthDay.add((String) day.getSelectedItem());
        birthdate.setText("".join("-", yearMonthDay));
    }//GEN-LAST:event_setBirthdate

    private void contactNumKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contactNumKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        String contactNumText = ((javax.swing.JTextPane) evt.getSource()).getText();

        // Check if the character is not a digit or if the text exceeds 10 characters
        if (!Character.isDigit(c) || contactNumText.length() >= 10) {
            evt.consume();  // Ignore the event, so the character is not added to the text field
        }
    }//GEN-LAST:event_contactNumKeyTyped

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox askVet;
    private javax.swing.JLabel backButton;
    private javax.swing.JTextPane birthdate;
    private javax.swing.JLabel birthdateLabel;
    private javax.swing.JScrollPane birthdateScroll;
    private javax.swing.JTextPane companyName;
    private javax.swing.JLabel companyNameLabel;
    private javax.swing.JScrollPane companyNameScroll;
    private javax.swing.JPasswordField confirmPassword;
    private javax.swing.JLabel confirmPasswordLabel;
    private javax.swing.JTextPane contactNum;
    private javax.swing.JScrollPane contactNumScroll;
    private javax.swing.JLabel contactNumber;
    private javax.swing.JTextPane currentAddress;
    private javax.swing.JLabel currentAddressLabel;
    private javax.swing.JScrollPane currentAddressScroll;
    private javax.swing.JComboBox<String> day;
    private javax.swing.JTextPane emailAddress;
    private javax.swing.JLabel emailAddressLabel;
    private javax.swing.JScrollPane emailAddressScroll;
    private javax.swing.JLabel errorMessage;
    private javax.swing.JLabel errorMessageContainer;
    private javax.swing.JTextPane fullName;
    private javax.swing.JLabel fullNameLabel;
    private javax.swing.JScrollPane fullNameScroll;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JLabel loginButton;
    private javax.swing.JLabel loginDescription;
    private javax.swing.JLabel minimizeButton;
    private javax.swing.JComboBox<String> month;
    private javax.swing.JTextPane occupation;
    private javax.swing.JLabel occupationLabel;
    private javax.swing.JScrollPane occupationScroll;
    private javax.swing.JTextPane passcode;
    private javax.swing.JLabel passcodeLbl;
    private javax.swing.JScrollPane passcodeScroll;
    private javax.swing.JPasswordField password;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel registerBg;
    private javax.swing.JLabel registerButton;
    private javax.swing.JPanel registerContainer;
    private javax.swing.JLabel registerHeader;
    private javax.swing.JPanel titleContainer;
    private javax.swing.JTextPane username;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JComboBox<String> workType;
    private javax.swing.JLabel workTypeLabel;
    private javax.swing.JComboBox<String> year;
    // End of variables declaration//GEN-END:variables
}
