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
public class ExitDialog extends javax.swing.JFrame {
    private JFrame exitDialogFrame;
    private boolean loginClosed = false;
    
    /**
     * Creates new form Register
     */
    public ExitDialog(JFrame exitDialogFrame) {
        initComponents();
        this.exitDialogFrame = exitDialogFrame;
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
    
    public ExitDialog() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        exitDialogPanel = new javax.swing.JPanel();
        yesButton = new javax.swing.JLabel();
        noButton = new javax.swing.JLabel();
        exitDialog = new javax.swing.JLabel();

        jScrollPane1.setViewportView(jEditorPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Developers");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        exitDialogPanel.setBackground(new java.awt.Color(255, 251, 209));
        exitDialogPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        exitDialogPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        yesButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/yes button (1).png"))); // NOI18N
        yesButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        yesButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                yesButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                yesButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                yesButtonMouseExited(evt);
            }
        });
        exitDialogPanel.add(yesButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 185, 230, 70));

        noButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/no button (1).png"))); // NOI18N
        noButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                noButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                noButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                noButtonMouseExited(evt);
            }
        });
        exitDialogPanel.add(noButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 185, 230, 70));

        exitDialog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/warning dialog (1).png"))); // NOI18N
        exitDialogPanel.add(exitDialog, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 550, 296));

        getContentPane().add(exitDialogPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 300));

        getAccessibleContext().setAccessibleName("Devs");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void yesButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_yesButtonMouseEntered
        // TODO add your handling code here:
        yesButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/yes button hover (1).png")));
    }//GEN-LAST:event_yesButtonMouseEntered

    private void yesButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_yesButtonMouseExited
        // TODO add your handling code here:
        yesButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/yes button (1).png")));
    }//GEN-LAST:event_yesButtonMouseExited

    private void yesButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_yesButtonMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        System.exit(0);
    }//GEN-LAST:event_yesButtonMouseClicked

    private void noButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_noButtonMouseEntered
        // TODO add your handling code here:
        noButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/no button hover (1).png")));
    }//GEN-LAST:event_noButtonMouseEntered

    private void noButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_noButtonMouseExited
        // TODO add your handling code here:
        noButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/no button (1).png")));
    }//GEN-LAST:event_noButtonMouseExited

    private void noButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_noButtonMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_noButtonMouseClicked

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
            java.util.logging.Logger.getLogger(ExitDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExitDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExitDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExitDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExitDialog().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel exitDialog;
    private javax.swing.JPanel exitDialogPanel;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel noButton;
    private javax.swing.JLabel yesButton;
    // End of variables declaration//GEN-END:variables
}
