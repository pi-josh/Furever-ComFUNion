/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import java.awt.MediaTracker;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author joshu
 */
public class Rescued extends javax.swing.JFrame {
    // for moving the frame
    private Point mouseDownCompCoords;
    
    // sub frames
    private UserLoggedIn userLoggedIn;
    
    /**
     * Creates new form Rehome
     * @param userLoggedIn
     */
    public Rescued(UserLoggedIn userLoggedIn) {
        this.userLoggedIn = userLoggedIn;
        
        initComponents();
        setVisible(true);

        // Window logo
        setWindowIcon();
        
        // radio buttons   
        petSex.add(male);
        petSex.add(female);
        
        petOrigin.add(owned);
        petOrigin.add(rescued);
        
        petStatus.add(adopted);
        petStatus.add(notAdopted);
        
        petSize.add(tiny);
        petSize.add(small);
        petSize.add(medium);
        petSize.add(large);
    }
    
    public Rescued() {
        initComponents();
        
        // Window logo
        setWindowIcon();
        
        // radio buttons   
        petSex.add(male);
        petSex.add(female);
        
        petOrigin.add(owned);
        petOrigin.add(rescued);
        
        petStatus.add(adopted);
        petStatus.add(notAdopted);
        
        petSize.add(tiny);
        petSize.add(small);
        petSize.add(medium);
        petSize.add(large);
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

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        petSex = new javax.swing.ButtonGroup();
        petOrigin = new javax.swing.ButtonGroup();
        petStatus = new javax.swing.ButtonGroup();
        petSize = new javax.swing.ButtonGroup();
        minimizeButton = new javax.swing.JLabel();
        backButton = new javax.swing.JLabel();
        header = new javax.swing.JLabel();
        rescuedPanel = new javax.swing.JPanel();
        rescuedButton = new javax.swing.JLabel();
        petID = new javax.swing.JTextField();
        petName = new javax.swing.JTextField();
        vetID = new javax.swing.JTextField();
        vetName = new javax.swing.JComboBox<>();
        petType = new javax.swing.JTextField();
        petAge = new javax.swing.JTextField();
        female = new javax.swing.JCheckBox();
        male = new javax.swing.JCheckBox();
        rescued = new javax.swing.JCheckBox();
        owned = new javax.swing.JCheckBox();
        adopted = new javax.swing.JCheckBox();
        notAdopted = new javax.swing.JCheckBox();
        tiny = new javax.swing.JCheckBox();
        small = new javax.swing.JCheckBox();
        medium = new javax.swing.JCheckBox();
        large = new javax.swing.JCheckBox();
        iAgree = new javax.swing.JCheckBox();
        rescuedBg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Rehome");
        setMinimumSize(new java.awt.Dimension(900, 680));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        getContentPane().add(minimizeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(815, 10, 40, 20));

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
        getContentPane().add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(855, 5, 40, 40));

        header.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                headerMouseDragged(evt);
            }
        });
        header.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                headerMousePressed(evt);
            }
        });
        getContentPane().add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 110));

        rescuedPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        rescuedPanel.setPreferredSize(new java.awt.Dimension(900, 680));
        rescuedPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rescuedButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/rescue button (1).png"))); // NOI18N
        rescuedButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rescuedButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                rescuedButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                rescuedButtonMouseExited(evt);
            }
        });
        rescuedPanel.add(rescuedButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(375, 620, -1, -1));

        petID.setEnabled(false);
        petID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                petIDActionPerformed(evt);
            }
        });
        rescuedPanel.add(petID, new org.netbeans.lib.awtextra.AbsoluteConstraints(206, 287, 393, 32));

        petName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                petNameActionPerformed(evt);
            }
        });
        rescuedPanel.add(petName, new org.netbeans.lib.awtextra.AbsoluteConstraints(206, 323, 362, 32));

        vetID.setEnabled(false);
        vetID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vetIDActionPerformed(evt);
            }
        });
        rescuedPanel.add(vetID, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 461, 200, 32));

        rescuedPanel.add(vetName, new org.netbeans.lib.awtextra.AbsoluteConstraints(494, 461, 283, 32));

        petType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                petTypeActionPerformed(evt);
            }
        });
        rescuedPanel.add(petType, new org.netbeans.lib.awtextra.AbsoluteConstraints(206, 358, 290, 32));

        petAge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                petAgeActionPerformed(evt);
            }
        });
        rescuedPanel.add(petAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(616, 324, 162, 32));

        female.setContentAreaFilled(false);
        female.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        female.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        female.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femaleActionPerformed(evt);
            }
        });
        rescuedPanel.add(female, new org.netbeans.lib.awtextra.AbsoluteConstraints(669, 291, 20, 20));

        male.setContentAreaFilled(false);
        male.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        male.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        male.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maleActionPerformed(evt);
            }
        });
        rescuedPanel.add(male, new org.netbeans.lib.awtextra.AbsoluteConstraints(729, 291, 20, 20));

        rescued.setContentAreaFilled(false);
        rescued.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rescued.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        rescued.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rescuedActionPerformed(evt);
            }
        });
        rescuedPanel.add(rescued, new org.netbeans.lib.awtextra.AbsoluteConstraints(588, 364, 20, 20));

        owned.setContentAreaFilled(false);
        owned.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        owned.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        owned.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ownedActionPerformed(evt);
            }
        });
        rescuedPanel.add(owned, new org.netbeans.lib.awtextra.AbsoluteConstraints(699, 364, 20, 20));

        adopted.setContentAreaFilled(false);
        adopted.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        adopted.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        adopted.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adoptedActionPerformed(evt);
            }
        });
        rescuedPanel.add(adopted, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 397, 20, 20));

        notAdopted.setContentAreaFilled(false);
        notAdopted.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        notAdopted.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        notAdopted.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                notAdoptedActionPerformed(evt);
            }
        });
        rescuedPanel.add(notAdopted, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 397, 20, 20));

        tiny.setContentAreaFilled(false);
        tiny.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tiny.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tiny.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tinyActionPerformed(evt);
            }
        });
        rescuedPanel.add(tiny, new org.netbeans.lib.awtextra.AbsoluteConstraints(466, 397, 20, 20));

        small.setContentAreaFilled(false);
        small.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        small.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        small.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smallActionPerformed(evt);
            }
        });
        rescuedPanel.add(small, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 396, 20, 20));

        medium.setContentAreaFilled(false);
        medium.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        medium.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        medium.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mediumActionPerformed(evt);
            }
        });
        rescuedPanel.add(medium, new org.netbeans.lib.awtextra.AbsoluteConstraints(608, 396, 20, 20));

        large.setContentAreaFilled(false);
        large.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        large.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        large.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                largeActionPerformed(evt);
            }
        });
        rescuedPanel.add(large, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 397, 20, 20));

        iAgree.setContentAreaFilled(false);
        iAgree.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iAgree.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        iAgree.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iAgreeActionPerformed(evt);
            }
        });
        rescuedPanel.add(iAgree, new org.netbeans.lib.awtextra.AbsoluteConstraints(414, 580, 20, 20));

        rescuedBg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Rescued.png"))); // NOI18N
        rescuedPanel.add(rescuedBg, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 896, 676));

        getContentPane().add(rescuedPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 680));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMouseClicked
        // TODO add your handling code here:
        this.dispose();
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

    private void headerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMousePressed
        // TODO add your handling code here:
        mouseDownCompCoords = evt.getPoint();
    }//GEN-LAST:event_headerMousePressed

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMouseDragged
        // TODO add your handling code here:
        Point currCoords = evt.getLocationOnScreen();
        setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);
    }//GEN-LAST:event_headerMouseDragged

    private void rescuedButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rescuedButtonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rescuedButtonMouseClicked

    private void rescuedButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rescuedButtonMouseEntered
        // TODO add your handling code here:
        rescuedButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/rescue button hover (1).png")));
    }//GEN-LAST:event_rescuedButtonMouseEntered

    private void rescuedButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rescuedButtonMouseExited
        // TODO add your handling code here:
        rescuedButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/rescue button (1).png")));
    }//GEN-LAST:event_rescuedButtonMouseExited

    private void petIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_petIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_petIDActionPerformed

    private void petNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_petNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_petNameActionPerformed

    private void petTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_petTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_petTypeActionPerformed

    private void femaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_femaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_femaleActionPerformed

    private void maleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maleActionPerformed

    private void rescuedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rescuedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rescuedActionPerformed

    private void ownedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ownedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ownedActionPerformed

    private void adoptedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adoptedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_adoptedActionPerformed

    private void notAdoptedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_notAdoptedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_notAdoptedActionPerformed

    private void tinyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tinyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tinyActionPerformed

    private void smallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smallActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_smallActionPerformed

    private void mediumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mediumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mediumActionPerformed

    private void largeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_largeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_largeActionPerformed

    private void iAgreeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iAgreeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_iAgreeActionPerformed

    private void vetIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vetIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vetIDActionPerformed

    private void petAgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_petAgeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_petAgeActionPerformed

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
            java.util.logging.Logger.getLogger(Rescued.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Rescued.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Rescued.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Rescued.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Rescued().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox adopted;
    private javax.swing.JLabel backButton;
    private javax.swing.JCheckBox female;
    private javax.swing.JLabel header;
    private javax.swing.JCheckBox iAgree;
    private javax.swing.JCheckBox large;
    private javax.swing.JCheckBox male;
    private javax.swing.JCheckBox medium;
    private javax.swing.JLabel minimizeButton;
    private javax.swing.JCheckBox notAdopted;
    private javax.swing.JCheckBox owned;
    private javax.swing.JTextField petAge;
    private javax.swing.JTextField petID;
    private javax.swing.JTextField petName;
    private javax.swing.ButtonGroup petOrigin;
    private javax.swing.ButtonGroup petSex;
    private javax.swing.ButtonGroup petSize;
    private javax.swing.ButtonGroup petStatus;
    private javax.swing.JTextField petType;
    private javax.swing.JCheckBox rescued;
    private javax.swing.JLabel rescuedBg;
    private javax.swing.JLabel rescuedButton;
    private javax.swing.JPanel rescuedPanel;
    private javax.swing.JCheckBox small;
    private javax.swing.JCheckBox tiny;
    private javax.swing.JTextField vetID;
    private javax.swing.JComboBox<String> vetName;
    // End of variables declaration//GEN-END:variables
}
