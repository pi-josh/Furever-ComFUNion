/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Models.Client;
import Models.Pet;
import java.awt.MediaTracker;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author joshu
 */
public class Rehome extends javax.swing.JFrame {
    // for moving the frame
    private Point mouseDownCompCoords;
    
    // sub frames
    private UserLoggedIn userLoggedIn;
    private Adopt adopt;
    private Rehome rehome;
    
    // Client who is logged in
    Client client;
    
    
    /**
     * Creates new form Rehome
     * @param userLoggedIn
     */
    public Rehome(UserLoggedIn userLoggedIn) {
        this.userLoggedIn = userLoggedIn;
        adopt = userLoggedIn.getAdopt();
        rehome = userLoggedIn.getRehome();
        
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
        
        // hide 2nd panel
        rehomePanel2.setVisible(false);
    }
    
    public Rehome(UserLoggedIn userLoggedIn, Client client) {
        this.userLoggedIn = userLoggedIn;
        adopt = userLoggedIn.getAdopt();
        rehome = userLoggedIn.getRehome();
        
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
        
        // hide 2nd panel
        rehomePanel2.setVisible(false);
    }
    
    public Rehome() {
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
        
        // hide 2nd panel
        rehomePanel2.setVisible(false);
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
    public Adopt getAdopt() {
        return adopt;
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
        petButton = new javax.swing.JLabel();
        adoptButton = new javax.swing.JLabel();
        minimizeButton = new javax.swing.JLabel();
        backButton = new javax.swing.JLabel();
        header = new javax.swing.JLabel();
        rehomePanel1 = new javax.swing.JPanel();
        rehomeNext = new javax.swing.JLabel();
        firstName = new javax.swing.JTextField();
        ownerID = new javax.swing.JTextField();
        lastName = new javax.swing.JTextField();
        age = new javax.swing.JTextField();
        reasonScroll = new javax.swing.JScrollPane();
        reason = new javax.swing.JTextArea();
        addressScroll = new javax.swing.JScrollPane();
        address = new javax.swing.JTextArea();
        phoneNumber = new javax.swing.JTextField();
        emailAddress = new javax.swing.JTextField();
        rehome1 = new javax.swing.JLabel();
        rehomePanel2 = new javax.swing.JPanel();
        rehomeButton = new javax.swing.JLabel();
        rehomePrev = new javax.swing.JLabel();
        petID = new javax.swing.JTextField();
        petName = new javax.swing.JTextField();
        petType = new javax.swing.JTextField();
        petAge = new javax.swing.JTextField();
        vetID = new javax.swing.JTextField();
        vetName = new javax.swing.JComboBox<>();
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
        rehome2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Rehome");
        setMinimumSize(new java.awt.Dimension(900, 680));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        petButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/pet button (1).png"))); // NOI18N
        petButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                petButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                petButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                petButtonMouseExited(evt);
            }
        });
        getContentPane().add(petButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 175, -1, -1));

        adoptButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/app adopt button.png"))); // NOI18N
        adoptButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adoptButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                adoptButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                adoptButtonMouseExited(evt);
            }
        });
        getContentPane().add(adoptButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 175, -1, -1));

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

        rehomePanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        rehomePanel1.setPreferredSize(new java.awt.Dimension(900, 680));
        rehomePanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rehomeNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/app next button.png"))); // NOI18N
        rehomeNext.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rehomeNextMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                rehomeNextMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                rehomeNextMouseExited(evt);
            }
        });
        rehomePanel1.add(rehomeNext, new org.netbeans.lib.awtextra.AbsoluteConstraints(605, 575, 220, 70));
        rehomePanel1.add(firstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 287, 232, 32));
        rehomePanel1.add(ownerID, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, 324, 354, 32));
        rehomePanel1.add(lastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(541, 287, 238, 32));

        age.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ageActionPerformed(evt);
            }
        });
        rehomePanel1.add(age, new org.netbeans.lib.awtextra.AbsoluteConstraints(616, 324, 162, 32));

        reasonScroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        reason.setColumns(20);
        reason.setRows(5);
        reasonScroll.setViewportView(reason);

        rehomePanel1.add(reasonScroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 490, 649, 81));

        addressScroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        address.setColumns(20);
        address.setRows(5);
        addressScroll.setViewportView(address);

        rehomePanel1.add(addressScroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, 360, 563, 59));
        rehomePanel1.add(phoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 424, 207, 32));
        rehomePanel1.add(emailAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(481, 424, 297, 32));

        rehome1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/REHOME Fp1.png"))); // NOI18N
        rehomePanel1.add(rehome1, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 896, 676));

        getContentPane().add(rehomePanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 680));

        rehomePanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        rehomePanel2.setPreferredSize(new java.awt.Dimension(900, 680));
        rehomePanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rehomeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/app rehome button.png"))); // NOI18N
        rehomeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rehomeButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                rehomeButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                rehomeButtonMouseExited(evt);
            }
        });
        rehomePanel2.add(rehomeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(375, 620, -1, -1));

        rehomePrev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/app prev button.png"))); // NOI18N
        rehomePrev.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rehomePrevMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                rehomePrevMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                rehomePrevMouseExited(evt);
            }
        });
        rehomePanel2.add(rehomePrev, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 565, 220, 75));

        petID.setEnabled(false);
        petID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                petIDActionPerformed(evt);
            }
        });
        rehomePanel2.add(petID, new org.netbeans.lib.awtextra.AbsoluteConstraints(206, 287, 393, 32));

        petName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                petNameActionPerformed(evt);
            }
        });
        rehomePanel2.add(petName, new org.netbeans.lib.awtextra.AbsoluteConstraints(206, 323, 362, 32));

        petType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                petTypeActionPerformed(evt);
            }
        });
        rehomePanel2.add(petType, new org.netbeans.lib.awtextra.AbsoluteConstraints(206, 358, 290, 32));

        petAge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                petAgeActionPerformed(evt);
            }
        });
        rehomePanel2.add(petAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(615, 323, 162, 32));

        vetID.setEnabled(false);
        vetID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vetIDActionPerformed(evt);
            }
        });
        rehomePanel2.add(vetID, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 461, 200, 32));

        rehomePanel2.add(vetName, new org.netbeans.lib.awtextra.AbsoluteConstraints(494, 461, 283, 32));

        female.setContentAreaFilled(false);
        female.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        female.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        female.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femaleActionPerformed(evt);
            }
        });
        rehomePanel2.add(female, new org.netbeans.lib.awtextra.AbsoluteConstraints(669, 291, 20, 20));

        male.setContentAreaFilled(false);
        male.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        male.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        male.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maleActionPerformed(evt);
            }
        });
        rehomePanel2.add(male, new org.netbeans.lib.awtextra.AbsoluteConstraints(729, 291, 20, 20));

        rescued.setContentAreaFilled(false);
        rescued.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rescued.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        rescued.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rescuedActionPerformed(evt);
            }
        });
        rehomePanel2.add(rescued, new org.netbeans.lib.awtextra.AbsoluteConstraints(588, 364, 20, 20));

        owned.setContentAreaFilled(false);
        owned.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        owned.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        owned.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ownedActionPerformed(evt);
            }
        });
        rehomePanel2.add(owned, new org.netbeans.lib.awtextra.AbsoluteConstraints(699, 364, 20, 20));

        adopted.setContentAreaFilled(false);
        adopted.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        adopted.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        adopted.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adoptedActionPerformed(evt);
            }
        });
        rehomePanel2.add(adopted, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 397, 20, 20));

        notAdopted.setContentAreaFilled(false);
        notAdopted.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        notAdopted.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        notAdopted.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                notAdoptedActionPerformed(evt);
            }
        });
        rehomePanel2.add(notAdopted, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 397, 20, 20));

        tiny.setContentAreaFilled(false);
        tiny.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tiny.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tiny.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tinyActionPerformed(evt);
            }
        });
        rehomePanel2.add(tiny, new org.netbeans.lib.awtextra.AbsoluteConstraints(466, 397, 20, 20));

        small.setContentAreaFilled(false);
        small.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        small.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        small.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smallActionPerformed(evt);
            }
        });
        rehomePanel2.add(small, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 396, 20, 20));

        medium.setContentAreaFilled(false);
        medium.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        medium.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        medium.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mediumActionPerformed(evt);
            }
        });
        rehomePanel2.add(medium, new org.netbeans.lib.awtextra.AbsoluteConstraints(608, 396, 20, 20));

        large.setContentAreaFilled(false);
        large.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        large.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        large.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                largeActionPerformed(evt);
            }
        });
        rehomePanel2.add(large, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 397, 20, 20));

        iAgree.setContentAreaFilled(false);
        iAgree.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iAgree.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        iAgree.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iAgreeActionPerformed(evt);
            }
        });
        rehomePanel2.add(iAgree, new org.netbeans.lib.awtextra.AbsoluteConstraints(414, 580, 20, 20));

        rehome2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/REHOME Fp2.png"))); // NOI18N
        rehomePanel2.add(rehome2, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 896, 676));

        getContentPane().add(rehomePanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 680));

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

    private void ageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ageActionPerformed

    private void petButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_petButtonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_petButtonMouseClicked

    private void petButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_petButtonMouseEntered
        // TODO add your handling code here:
        petButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/pet button hover (1).png")));
    }//GEN-LAST:event_petButtonMouseEntered

    private void petButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_petButtonMouseExited
        // TODO add your handling code here:
        petButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/pet button (1).png")));
    }//GEN-LAST:event_petButtonMouseExited

    private void adoptButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adoptButtonMouseClicked
        // TODO add your handling code here:
        if (userLoggedIn != null) {
            adopt = userLoggedIn.getAdopt();
        }
        if (adopt == null) {
            adopt = new Adopt(userLoggedIn);
            adopt.setVisible(true);
        } else if (!adopt.isVisible()) {
            adopt.setVisible(true);
        } else {
            adopt.toFront();
            adopt.requestFocus();
        }
        this.dispose();
    }//GEN-LAST:event_adoptButtonMouseClicked

    private void adoptButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adoptButtonMouseEntered
        // TODO add your handling code here:
        adoptButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/app adopt button hover.png")));
    }//GEN-LAST:event_adoptButtonMouseEntered

    private void adoptButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adoptButtonMouseExited
        // TODO add your handling code here:
        adoptButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/app adopt button.png")));
    }//GEN-LAST:event_adoptButtonMouseExited

    private void rehomeNextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rehomeNextMouseClicked
        // TODO add your handling code here:
        rehomePanel1.setVisible(false);
        rehomePanel2.setVisible(true);
    }//GEN-LAST:event_rehomeNextMouseClicked

    private void rehomeNextMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rehomeNextMouseEntered
        // TODO add your handling code here:
        rehomeNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/app next button hover.png")));
    }//GEN-LAST:event_rehomeNextMouseEntered

    private void rehomeNextMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rehomeNextMouseExited
        // TODO add your handling code here:
        rehomeNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/app next button.png")));
    }//GEN-LAST:event_rehomeNextMouseExited

    private void rehomeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rehomeButtonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rehomeButtonMouseClicked

    private void rehomeButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rehomeButtonMouseEntered
        // TODO add your handling code here:
        rehomeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/app rehome button hover.png")));
    }//GEN-LAST:event_rehomeButtonMouseEntered

    private void rehomeButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rehomeButtonMouseExited
        // TODO add your handling code here:
        rehomeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/app rehome button.png")));
    }//GEN-LAST:event_rehomeButtonMouseExited

    private void rehomePrevMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rehomePrevMouseClicked
        // TODO add your handling code here:
        rehomePanel1.setVisible(true);
        rehomePanel2.setVisible(false);
    }//GEN-LAST:event_rehomePrevMouseClicked

    private void rehomePrevMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rehomePrevMouseEntered
        // TODO add your handling code here
        rehomePrev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/app prev button hover.png")));
    }//GEN-LAST:event_rehomePrevMouseEntered

    private void rehomePrevMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rehomePrevMouseExited
        // TODO add your handling code here:
        rehomePrev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/app prev button.png")));
    }//GEN-LAST:event_rehomePrevMouseExited

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

    private void petAgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_petAgeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_petAgeActionPerformed

    private void vetIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vetIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vetIDActionPerformed

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
            java.util.logging.Logger.getLogger(Rehome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Rehome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Rehome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Rehome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Rehome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea address;
    private javax.swing.JScrollPane addressScroll;
    private javax.swing.JLabel adoptButton;
    private javax.swing.JCheckBox adopted;
    private javax.swing.JTextField age;
    private javax.swing.JLabel backButton;
    private javax.swing.JTextField emailAddress;
    private javax.swing.JCheckBox female;
    private javax.swing.JTextField firstName;
    private javax.swing.JLabel header;
    private javax.swing.JCheckBox iAgree;
    private javax.swing.JCheckBox large;
    private javax.swing.JTextField lastName;
    private javax.swing.JCheckBox male;
    private javax.swing.JCheckBox medium;
    private javax.swing.JLabel minimizeButton;
    private javax.swing.JCheckBox notAdopted;
    private javax.swing.JCheckBox owned;
    private javax.swing.JTextField ownerID;
    private javax.swing.JTextField petAge;
    private javax.swing.JLabel petButton;
    private javax.swing.JTextField petID;
    private javax.swing.JTextField petName;
    private javax.swing.ButtonGroup petOrigin;
    private javax.swing.ButtonGroup petSex;
    private javax.swing.ButtonGroup petSize;
    private javax.swing.ButtonGroup petStatus;
    private javax.swing.JTextField petType;
    private javax.swing.JTextField phoneNumber;
    private javax.swing.JTextArea reason;
    private javax.swing.JScrollPane reasonScroll;
    private javax.swing.JLabel rehome1;
    private javax.swing.JLabel rehome2;
    private javax.swing.JLabel rehomeButton;
    private javax.swing.JLabel rehomeNext;
    private javax.swing.JPanel rehomePanel1;
    private javax.swing.JPanel rehomePanel2;
    private javax.swing.JLabel rehomePrev;
    private javax.swing.JCheckBox rescued;
    private javax.swing.JCheckBox small;
    private javax.swing.JCheckBox tiny;
    private javax.swing.JTextField vetID;
    private javax.swing.JComboBox<String> vetName;
    // End of variables declaration//GEN-END:variables
}
