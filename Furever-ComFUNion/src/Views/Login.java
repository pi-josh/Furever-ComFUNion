/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import java.awt.Color;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author joshu
 */
public class Login extends javax.swing.JFrame {
    private JFrame landingPageFrame;
    private boolean loginClosed = false;
    
    /**
     * Creates new form Register
     */
    public Login(JFrame landingPageFrame) {
        initComponents();
        this.landingPageFrame = landingPageFrame;
        setVisible(true);
        
        // Window logo
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
    
    public Login() {
        initComponents();
        
        // Window logo
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
    
    public boolean getLoginClosed() {
        return loginClosed;
    }
    
    public void setLoginClosed(boolean state) {
        loginClosed = state;
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
        backButton = new javax.swing.JLabel();
        loginHeader = new javax.swing.JLabel();
        registerContainer = new javax.swing.JPanel();
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
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titleContainer.setBackground(new java.awt.Color(194, 144, 69));
        titleContainer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        titleContainer.setPreferredSize(new java.awt.Dimension(900, 75));
        titleContainer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        titleContainer.add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 10, 40, 40));

        loginHeader.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        loginHeader.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/login header.png"))); // NOI18N
        titleContainer.add(loginHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 1, -1, -1));

        getContentPane().add(titleContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        registerContainer.setBackground(new java.awt.Color(255, 250, 205));
        registerContainer.setPreferredSize(new java.awt.Dimension(500, 575));
        registerContainer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        usernameLabel.setFont(new java.awt.Font("Tahoma", 0, 19)); // NOI18N
        usernameLabel.setText("Username:");
        registerContainer.add(usernameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, -1, -1));

        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane2.setHorizontalScrollBar(null);

        username.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                usernameKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(username);

        registerContainer.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, 270, 29));

        passwordLabel.setFont(new java.awt.Font("Tahoma", 0, 19)); // NOI18N
        passwordLabel.setText("Password:");
        registerContainer.add(passwordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, -1, -1));

        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });
        registerContainer.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, 270, 30));

        loginButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/login acc.png"))); // NOI18N
        loginButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginButtonMouseExited(evt);
            }
        });
        registerContainer.add(loginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 430, -1, 60));

        registerDescription.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        registerDescription.setText("Don't have an account yet?");
        registerContainer.add(registerDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 500, -1, -1));

        registerButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        registerButton.setForeground(new java.awt.Color(74, 54, 13));
        registerButton.setText("<html>\n<u>Register here</u>\n</html>");
        registerButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                registerButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                registerButtonMouseExited(evt);
            }
        });
        registerContainer.add(registerButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 500, -1, -1));

        logo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/logo.png"))); // NOI18N
        logo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        registerContainer.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 210, 200));

        errorMessage.setText("lagayan ng error message rito");
        registerContainer.add(errorMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 370, -1, -1));

        errorMessageContainer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/login error container.png"))); // NOI18N
        registerContainer.add(errorMessageContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 340, -1, -1));

        loginFormBackground.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loginFormBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/login form bg.png"))); // NOI18N
        loginFormBackground.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        loginFormBackground.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        registerContainer.add(loginFormBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 470, 500));

        design.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/login paw prints.png"))); // NOI18N
        registerContainer.add(design, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 610));

        getContentPane().add(registerContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 75, -1, 610));

        loginDescription.setBackground(new java.awt.Color(221, 237, 250));
        loginDescription.setPreferredSize(new java.awt.Dimension(400, 500));
        loginDescription.setLayout(new java.awt.GridBagLayout());

        loginPic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/login pic.png"))); // NOI18N
        loginDescription.add(loginPic, new java.awt.GridBagConstraints());

        getContentPane().add(loginDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 75, -1, 610));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordActionPerformed

    private void loginButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginButtonMouseEntered
        // TODO add your handling code here:
        loginButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/login acc hover.png")));
    }//GEN-LAST:event_loginButtonMouseEntered

    private void loginButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginButtonMouseExited
        // TODO add your handling code here:
        loginButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/login acc.png")));
    }//GEN-LAST:event_loginButtonMouseExited

    private void registerButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerButtonMouseEntered
        // TODO add your handling code here:
        registerButton.setForeground(Color.RED);
    }//GEN-LAST:event_registerButtonMouseEntered

    private void registerButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerButtonMouseExited
        // TODO add your handling code here:
        registerButton.setForeground(new java.awt.Color(99, 71, 12));
    }//GEN-LAST:event_registerButtonMouseExited

    private void usernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usernameKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            // Ignore the event if it is the Enter key
            evt.consume();
        } else {
            // Otherwise, handle the event normally
            super.processKeyEvent(evt);
        }
    }//GEN-LAST:event_usernameKeyPressed

    private void loginButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginButtonMouseClicked
        // TODO add your handling code here:
        String tempUsername = "admin";
        String tempPassword = "admin";
        
        if(username.getText().equals(tempUsername) && password.getText().equals(tempPassword)) {
            this.setVisible(false);
            landingPageFrame.setVisible(false);
            new UserLoggedIn().setVisible(true);
        }
    }//GEN-LAST:event_loginButtonMouseClicked

    private void backButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        setLoginClosed(true);
    }//GEN-LAST:event_backButtonMouseClicked

    private void backButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMouseEntered
        // TODO add your handling code here:
        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/back button hover (1).png")));
    }//GEN-LAST:event_backButtonMouseEntered

    private void backButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMouseExited
        // TODO add your handling code here:
        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/back button (1).png")));
    }//GEN-LAST:event_backButtonMouseExited

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
    private javax.swing.JPanel loginDescription;
    private javax.swing.JLabel loginFormBackground;
    private javax.swing.JLabel loginHeader;
    private javax.swing.JLabel loginPic;
    private javax.swing.JLabel logo;
    private javax.swing.JPasswordField password;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel registerButton;
    private javax.swing.JPanel registerContainer;
    private javax.swing.JLabel registerDescription;
    private javax.swing.JPanel titleContainer;
    private javax.swing.JTextPane username;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
