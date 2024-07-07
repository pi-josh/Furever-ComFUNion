/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controllers.LoginController;
import Controllers.RegisterController;
import Models.Client;
import Models.SPManager;
import Models.Veterinarian;
import java.awt.Color;
import java.awt.MediaTracker;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextPane;

/**
 *
 * @author joshu
 */
public class Login extends javax.swing.JFrame {
    SPManager spManager = new SPManager();
    
    // for moving the frame
    private Point mouseDownCompCoords;
    
    // controller
    private RegisterController registerController;
    
    // frames
    private LandingPage landingPage;
    private Register register;
    
    public Login(LandingPage landingPage) {
        initComponents();
        this.landingPage = landingPage;
        register = landingPage.getRegister();
        setVisible(true);

        // Window logo
        setWindowIcon();
        
        resetErrorMessage();
    }
    
    // Default constructor
    public Login() {
        initComponents();
        
        // controller
        LoginController controller = new LoginController(this);
        
        // Window logo
        setWindowIcon();
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
    
    public Register getRegister() {
        return register;
    }
    
    // Getters for UI components
    public JLabel getBackButton() {
        return backButton;
    }

    public JLabel getLoginButton() {
        return loginButton;
    }

    public JLabel getRegisterButton() {
        return registerButton;
    }

    public JTextPane getUsernameField() {
        return username;
    }

    public JPasswordField getPasswordField() {
        return password;
    }

    public JLabel getMinimizeButton() {
        return minimizeButton;
    }

    // Event handling methods
    public void loginButtonActionPerformed() {
        String enteredUsername = username.getText();
        String enteredPassword = new String(password.getPassword());

        // Simulate authentication
        Client client = null;
        Veterinarian vet = null;
        
        //QUERY HERE: check if the entered username and password exist in client or vet table
        // default acc for viewing sample infos
        if(enteredUsername.equals("admin") && enteredPassword.equals("admin")) {
            this.setVisible(false);
            landingPage.setVisible(false);
            new UserLoggedIn(null).setVisible(true);
            return;
        }
        // client
        client = spManager.getClientByCredentials(enteredUsername, enteredPassword);  // this will return the client if exist, else null
        if(client != null) {
            this.setVisible(false);
            landingPage.setVisible(false);
            new UserLoggedIn(client).setVisible(true);
            return;
        }
        // veterinarian
        vet = spManager.getVetByCredentials(enteredUsername, enteredPassword); // this will return the veterinarian if exist, else null
        if(vet != null) {
            this.setVisible(false);
            landingPage.setVisible(false);
            new VetLoggedIn(vet).setVisible(true);
            return;
        }
        // if not existing at both tables, display an error
        errorMessage.setText("Invalid username or password");
        errorMessage.setForeground(Color.RED);
    }

    public void registerButtonMouseClicked(java.awt.event.MouseEvent evt) {
        if (landingPage != null) {
            register = landingPage.getRegister();
        }
        if (register == null) {
            register = new Register(landingPage);
            registerController = new RegisterController(register);
            register.setVisible(true);
        } else if (!register.isVisible()) {
            register.setVisible(true);
        } else {
            register.toFront();
            register.requestFocus();
        }
        this.dispose();
    }
    
    public void resetErrorMessage() {
        errorMessage.setText(""); // Reset the error message label
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleContainer = new javax.swing.JPanel();
        minimizeButton = new javax.swing.JLabel();
        backButton = new javax.swing.JLabel();
        loginHeader = new javax.swing.JLabel();
        loginContainer = new javax.swing.JPanel();
        usernameLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        username = new javax.swing.JTextPane();
        passwordLabel = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        loginButton = new javax.swing.JLabel();
        registerDescription = new javax.swing.JLabel();
        registerButton = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        errorMessage = new javax.swing.JLabel();
        errorMessageContainer = new javax.swing.JLabel();
        loginFormBackground = new javax.swing.JLabel();
        design = new javax.swing.JLabel();
        loginDescription = new javax.swing.JPanel();
        loginPic = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Login");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titleContainer.setBackground(new java.awt.Color(194, 144, 69));
        titleContainer.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 1, 2, new java.awt.Color(0, 0, 0)));
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
        titleContainer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        minimizeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/minimize button (1).png"))); // NOI18N
        minimizeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizeButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                minimizeButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                minimizeButtonMouseExited(evt);
            }
        });
        titleContainer.add(minimizeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(815, 10, 40, 20));

        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/back button (1).png"))); // NOI18N
        backButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                backButtonMouseExited(evt);
            }
        });
        titleContainer.add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(855, 5, 40, 40));

        loginHeader.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        loginHeader.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/login header.png"))); // NOI18N
        titleContainer.add(loginHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 1, -1, -1));

        getContentPane().add(titleContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        loginContainer.setBackground(new java.awt.Color(255, 250, 205));
        loginContainer.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 2, 2, 0, new java.awt.Color(0, 0, 0)));
        loginContainer.setPreferredSize(new java.awt.Dimension(500, 575));
        loginContainer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        usernameLabel.setFont(new java.awt.Font("Tahoma", 0, 19)); // NOI18N
        usernameLabel.setText("Username:");
        loginContainer.add(usernameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, -1, -1));

        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane2.setHorizontalScrollBar(null);
        jScrollPane2.setViewportView(username);

        loginContainer.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, 270, 29));

        passwordLabel.setFont(new java.awt.Font("Tahoma", 0, 19)); // NOI18N
        passwordLabel.setText("Password:");
        loginContainer.add(passwordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, -1, -1));
        loginContainer.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, 270, 30));

        loginButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/login acc.png"))); // NOI18N
        loginContainer.add(loginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 430, -1, 60));

        registerDescription.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        registerDescription.setText("Don't have an account yet?");
        loginContainer.add(registerDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 500, -1, -1));

        registerButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        registerButton.setForeground(new java.awt.Color(74, 54, 13));
        registerButton.setText("<html>\n<u>Register here</u>\n</html>");
        loginContainer.add(registerButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 500, -1, -1));

        logo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/logo.png"))); // NOI18N
        logo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        loginContainer.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 210, 200));

        errorMessage.setText("lagayan ng error message rito");
        loginContainer.add(errorMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 370, -1, -1));

        errorMessageContainer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/login error container.png"))); // NOI18N
        loginContainer.add(errorMessageContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 340, -1, -1));

        loginFormBackground.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loginFormBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/login form bg.png"))); // NOI18N
        loginFormBackground.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        loginFormBackground.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        loginContainer.add(loginFormBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 470, 500));

        design.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/login paw prints.png"))); // NOI18N
        loginContainer.add(design, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 496, 606));

        getContentPane().add(loginContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 75, 500, 610));

        loginDescription.setBackground(new java.awt.Color(221, 237, 250));
        loginDescription.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 2, 2, new java.awt.Color(0, 0, 0)));
        loginDescription.setPreferredSize(new java.awt.Dimension(400, 500));
        loginDescription.setLayout(new java.awt.GridBagLayout());

        loginPic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/login pic.png"))); // NOI18N
        loginDescription.add(loginPic, new java.awt.GridBagConstraints());

        getContentPane().add(loginDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 75, 400, 610));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_backButtonMouseClicked

    private void backButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMouseEntered
        // TODO add your handling code here:
        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/back button hover (1).png")));
    }//GEN-LAST:event_backButtonMouseEntered

    private void backButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMouseExited
        // TODO add your handling code here:
        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/back button (1).png")));
    }//GEN-LAST:event_backButtonMouseExited

    private void minimizeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeButtonMouseClicked
        // TODO add your handling code here:
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_minimizeButtonMouseClicked

    private void minimizeButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeButtonMouseEntered
        // TODO add your handling code here:
        minimizeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/minimize button hover (1).png")));
    }//GEN-LAST:event_minimizeButtonMouseEntered

    private void minimizeButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeButtonMouseExited
        // TODO add your handling code here:
        minimizeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/minimize button (1).png")));
    }//GEN-LAST:event_minimizeButtonMouseExited

    private void titleContainerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_titleContainerMousePressed
        // TODO add your handling code here:
        mouseDownCompCoords = evt.getPoint();
    }//GEN-LAST:event_titleContainerMousePressed

    private void titleContainerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_titleContainerMouseDragged
        // TODO add your handling code here:
        Point currCoords = evt.getLocationOnScreen();
        setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);
    }//GEN-LAST:event_titleContainerMouseDragged

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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backButton;
    private javax.swing.JLabel design;
    private javax.swing.JLabel errorMessage;
    private javax.swing.JLabel errorMessageContainer;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel loginButton;
    private javax.swing.JPanel loginContainer;
    private javax.swing.JPanel loginDescription;
    private javax.swing.JLabel loginFormBackground;
    private javax.swing.JLabel loginHeader;
    private javax.swing.JLabel loginPic;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel minimizeButton;
    private javax.swing.JPasswordField password;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel registerButton;
    private javax.swing.JLabel registerDescription;
    private javax.swing.JPanel titleContainer;
    private javax.swing.JTextPane username;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
