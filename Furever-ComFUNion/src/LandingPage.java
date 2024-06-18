import Views.Login;
import Views.Register;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joshu
 */
public class LandingPage extends javax.swing.JFrame {
    // buttons clickability
    private boolean homeClicked;
    private boolean aboutUsClicked;
    private boolean FAQsClicked;
    private boolean petsClicked;
    private boolean start = true;
    
    /**
     * Creates new form Main
     */
    public LandingPage() {
        initComponents();
        
        // default 
        defaultWindow();
        
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
    
    private void defaultWindow() {       
        // click bg
        homeClick.setVisible(true);
        aboutUsClick.setVisible(false);
        faqClick.setVisible(false);
        petClick.setVisible(false);
        
        // set clickability
        homeClicked = true;
        
        // button icons
        homeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/home click.png")));
    }
    
    private void homeButton() {
        // set visiblity
        homeBody.setVisible(true);
        aboutUsBody.setVisible(false);
        FAQsBody.setVisible(false);
        petsBody.setVisible(false);
        
        // click bg
        homeClick.setVisible(true);
        aboutUsClick.setVisible(false);
        faqClick.setVisible(false);
        petClick.setVisible(false);

        
        // set clickability
        homeClicked = true;
        aboutUsClicked = false;
        FAQsClicked = false;
        petsClicked = false;
        
        // button icons
        homeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/home click.png")));
        aboutUsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/about us.png")));
        faqButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/FAQs.png")));
        petButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/pets.png")));
    }
    
    private void aboutUsButton() {
        // set visiblity
        homeBody.setVisible(false);
        aboutUsBody.setVisible(true);
        FAQsBody.setVisible(false);
        petsBody.setVisible(false);
        
        // click bg
        homeClick.setVisible(false);
        aboutUsClick.setVisible(true);
        faqClick.setVisible(false);
        petClick.setVisible(false);
            

        // set clickability
        homeClicked = false;
        aboutUsClicked = true;
        FAQsClicked = false;
        petsClicked = false;
        
        // button icons
        homeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/home.png")));
        aboutUsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/about us click.png")));
        faqButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/FAQs.png")));
        petButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/pets.png")));
    }
    
    private void faqButton() {
        // set visiblity
        homeBody.setVisible(false);
        aboutUsBody.setVisible(false);
        FAQsBody.setVisible(true);
        petsBody.setVisible(false);
        
        // click bg
        homeClick.setVisible(false);
        aboutUsClick.setVisible(false);
        faqClick.setVisible(true);
        petClick.setVisible(false);

        
        // set clickability
        homeClicked = false;
        aboutUsClicked = false;
        FAQsClicked = true;
        petsClicked = false;
        
        // button icons
        homeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/home.png")));
        aboutUsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/about us.png")));
        faqButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/FAQs click.png")));
        petButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/pets.png")));
    }
    
    private void petButton() {
        // set visiblity
        homeBody.setVisible(false);
        aboutUsBody.setVisible(false);
        FAQsBody.setVisible(false);
        petsBody.setVisible(true);
        
        // click bg
        homeClick.setVisible(false);
        aboutUsClick.setVisible(false);
        faqClick.setVisible(false);
        petClick.setVisible(true);

        
        // set clickability
        homeClicked = false;
        aboutUsClicked = false;
        FAQsClicked = false;
        petsClicked = true;
        
        // button icons
        homeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/home.png")));
        aboutUsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/about us.png")));
        faqButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/FAQs.png")));
        petButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/pets click.png")));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        navBar = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        homeButton = new javax.swing.JLabel();
        homeClick = new javax.swing.JLabel();
        aboutUsButton = new javax.swing.JLabel();
        aboutUsClick = new javax.swing.JLabel();
        faqButton = new javax.swing.JLabel();
        faqClick = new javax.swing.JLabel();
        petButton = new javax.swing.JLabel();
        petClick = new javax.swing.JLabel();
        loginButton = new javax.swing.JLabel();
        registerButton = new javax.swing.JLabel();
        line = new javax.swing.JPanel();
        homeBody = new javax.swing.JPanel();
        slogan = new javax.swing.JLabel();
        description = new javax.swing.JLabel();
        adoptedCounter = new javax.swing.JLabel();
        adoptedLabel = new javax.swing.JLabel();
        badge = new javax.swing.JLabel();
        bulletin = new javax.swing.JLabel();
        background = new javax.swing.JLabel();
        aboutUsBody = new javax.swing.JPanel();
        devs = new javax.swing.JLabel();
        businessRules = new javax.swing.JLabel();
        aboutUsPanel = new javax.swing.JLabel();
        background2 = new javax.swing.JLabel();
        FAQsBody = new javax.swing.JPanel();
        next = new javax.swing.JLabel();
        FAQsPanel = new javax.swing.JLabel();
        background3 = new javax.swing.JLabel();
        petsBody = new javax.swing.JPanel();
        petPrev = new javax.swing.JLabel();
        petNext = new javax.swing.JLabel();
        petPanel1 = new javax.swing.JLabel();
        petPanel2 = new javax.swing.JLabel();
        petPanel3 = new javax.swing.JLabel();
        petHeader = new javax.swing.JLabel();
        background4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Furever ComFUNion");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(1370, 879));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        navBar.setBackground(new java.awt.Color(194, 144, 69));
        navBar.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        navBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/navLogo.png"))); // NOI18N
        logo.setIconTextGap(0);
        logo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                logoMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                logoMouseReleased(evt);
            }
        });
        navBar.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        homeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/home click.png"))); // NOI18N
        homeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                homeButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                homeButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                homeButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                homeButtonMouseReleased(evt);
            }
        });
        navBar.add(homeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 65, -1, -1));

        homeClick.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/click bg.png"))); // NOI18N
        navBar.add(homeClick, new org.netbeans.lib.awtextra.AbsoluteConstraints(515, 50, -1, -1));

        aboutUsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/about us.png"))); // NOI18N
        aboutUsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aboutUsButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                aboutUsButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                aboutUsButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                aboutUsButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                aboutUsButtonMouseReleased(evt);
            }
        });
        navBar.add(aboutUsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 65, -1, -1));

        aboutUsClick.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/click bg.png"))); // NOI18N
        navBar.add(aboutUsClick, new org.netbeans.lib.awtextra.AbsoluteConstraints(635, 50, -1, -1));

        faqButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/FAQs.png"))); // NOI18N
        faqButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                faqButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                faqButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                faqButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                faqButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                faqButtonMouseReleased(evt);
            }
        });
        navBar.add(faqButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 65, -1, -1));

        faqClick.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/click bg.png"))); // NOI18N
        navBar.add(faqClick, new org.netbeans.lib.awtextra.AbsoluteConstraints(755, 50, -1, -1));

        petButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/pets.png"))); // NOI18N
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
            public void mousePressed(java.awt.event.MouseEvent evt) {
                petButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                petButtonMouseReleased(evt);
            }
        });
        navBar.add(petButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 65, -1, -1));

        petClick.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/click bg.png"))); // NOI18N
        navBar.add(petClick, new org.netbeans.lib.awtextra.AbsoluteConstraints(875, 50, -1, -1));

        loginButton.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        loginButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/login.png"))); // NOI18N
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
        loginButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                loginButtonKeyPressed(evt);
            }
        });
        navBar.add(loginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 45, -1, -1));

        registerButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/register.png"))); // NOI18N
        registerButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registerButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                registerButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                registerButtonMouseExited(evt);
            }
        });
        registerButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                registerButtonKeyPressed(evt);
            }
        });
        navBar.add(registerButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 45, -1, -1));

        line.setBackground(new java.awt.Color(255, 251, 209));
        line.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout lineLayout = new javax.swing.GroupLayout(line);
        line.setLayout(lineLayout);
        lineLayout.setHorizontalGroup(
            lineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1368, Short.MAX_VALUE)
        );
        lineLayout.setVerticalGroup(
            lineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );

        navBar.add(line, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 109, 1370, 30));

        getContentPane().add(navBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 140));

        homeBody.setBackground(new java.awt.Color(255, 251, 209));
        homeBody.setBorder(new javax.swing.border.MatteBorder(null));
        homeBody.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        slogan.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        slogan.setForeground(new java.awt.Color(51, 51, 255));
        slogan.setText("<html> <head> <style> p {     font-family: 'Comic Sans MS', cursive;     font-size: 60px;     color: #000000; /* Black text */     text-align: center;     margin-top: 50px;     text-shadow:          -1px -1px 0 #ffffff,           1px -1px 0 #ffffff,         -1px 1px 0 #ffffff,         1px 1px 0 #ffffff; /* White border */ } </style> </head> <body> <p>Connecting Hearts with Paws</p> </body> </html> ");
        homeBody.add(slogan, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 670, 260));

        description.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        description.setText("<html> <head> <style> p { \tfont-family: 'Open Sans', sans-serif;             font-size: 14px;             color: #000000;             text-align: justify;             margin-top: 20px;             max-width: 100%;             margin-left: auto;             margin-right: auto; \t\t\t} \t\t</style> \t</head> \t<body> \t\t<p>Finding a loving home for every furry friend is our mission. <br>             <br>With \"Furever ComFUNion,\" adopting/rehoming a pet becomes an effortless and joyful experience. <br><br>             Make a lasting impact—bring joy to an animal's life and enrich your own by giving a pet a forever home today. <br>             <br>With Furever ComFUNion, the perfect companion is just a few clicks away.</p> \t</body> </html>");
        homeBody.add(description, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 350, 520, 270));

        adoptedCounter.setFont(new java.awt.Font("Tahoma", 1, 72)); // NOI18N
        adoptedCounter.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        adoptedCounter.setText("100");
        adoptedCounter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                adoptedCounterbadgeKeyPressed(evt);
            }
        });
        homeBody.add(adoptedCounter, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 240, 220, 120));

        adoptedLabel.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        adoptedLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        adoptedLabel.setText("Pets are adopted");
        adoptedLabel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                adoptedLabelbadgeKeyPressed(evt);
            }
        });
        homeBody.add(adoptedLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 490, 320, 50));

        badge.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/badge2.png"))); // NOI18N
        badge.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                badgeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                badgeMouseExited(evt);
            }
        });
        badge.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                badgeKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                badgeKeyReleased(evt);
            }
        });
        homeBody.add(badge, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 100, -1, -1));

        bulletin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/bulletin.png"))); // NOI18N
        homeBody.add(bulletin, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, 650, 410));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/paw prints.png"))); // NOI18N
        homeBody.add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 740));

        getContentPane().add(homeBody, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 139, 1370, 740));

        aboutUsBody.setBackground(new java.awt.Color(255, 251, 209));
        aboutUsBody.setBorder(new javax.swing.border.MatteBorder(null));
        aboutUsBody.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        devs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/about us dev (1).png"))); // NOI18N
        aboutUsBody.add(devs, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 540, -1, 200));

        businessRules.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/about us business rule (1).png"))); // NOI18N
        aboutUsBody.add(businessRules, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 540, 400, 200));

        aboutUsPanel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/about us panel (1).png"))); // NOI18N
        aboutUsBody.add(aboutUsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, 850, 780));

        background2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/paw prints.png"))); // NOI18N
        aboutUsBody.add(background2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 740));

        getContentPane().add(aboutUsBody, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 139, 1370, 740));

        FAQsBody.setBackground(new java.awt.Color(255, 251, 209));
        FAQsBody.setBorder(new javax.swing.border.MatteBorder(null));
        FAQsBody.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        next.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/next button (1).png"))); // NOI18N
        FAQsBody.add(next, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 580, 350, 100));

        FAQsPanel.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        FAQsPanel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/FAQs panel (1).png"))); // NOI18N
        FAQsBody.add(FAQsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 960, 640));

        background3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/paw prints.png"))); // NOI18N
        FAQsBody.add(background3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 740));

        getContentPane().add(FAQsBody, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 139, 1370, 740));

        petsBody.setBackground(new java.awt.Color(255, 251, 209));
        petsBody.setBorder(new javax.swing.border.MatteBorder(null));
        petsBody.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        petPrev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/prev button (1).png"))); // NOI18N
        petsBody.add(petPrev, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 590, 350, 100));

        petNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/next button (1).png"))); // NOI18N
        petsBody.add(petNext, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 590, 350, 100));

        petPanel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/pets panel (1).png"))); // NOI18N
        petsBody.add(petPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 400, 530));

        petPanel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/pets panel (1).png"))); // NOI18N
        petPanel2.setPreferredSize(new java.awt.Dimension(400, 400));
        petsBody.add(petPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 90, 400, 530));

        petPanel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/pets panel (1).png"))); // NOI18N
        petsBody.add(petPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 90, 400, 530));

        petHeader.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        petHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        petHeader.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/pets header.png"))); // NOI18N
        petsBody.add(petHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 250, 90));

        background4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/paw prints.png"))); // NOI18N
        petsBody.add(background4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 740));

        getContentPane().add(petsBody, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 139, 1370, 740));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void registerButtonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_registerButtonKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_registerButtonKeyPressed

    private void registerButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerButtonMouseExited
        // TODO add your handling code here:
        registerButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/register.png")));
    }//GEN-LAST:event_registerButtonMouseExited

    private void registerButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerButtonMouseEntered
        // TODO add your handling code here:
        registerButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/register hover.png")));
    }//GEN-LAST:event_registerButtonMouseEntered

    private void registerButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerButtonMouseClicked
        // TODO add your handling code here:
        new Register().setVisible(true);
    }//GEN-LAST:event_registerButtonMouseClicked

    private void loginButtonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_loginButtonKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_loginButtonKeyPressed

    private void loginButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginButtonMouseExited
        // TODO add your handling code here:
        loginButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/login.png")));
    }//GEN-LAST:event_loginButtonMouseExited

    private void loginButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginButtonMouseEntered
        // TODO add your handling code here:
        loginButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/login hover.png")));
    }//GEN-LAST:event_loginButtonMouseEntered

    private void loginButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginButtonMouseClicked
        // TODO add your handling code here:
        new Login(this).setVisible(true);
    }//GEN-LAST:event_loginButtonMouseClicked

    private void logoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoMouseClicked
        // TODO add your handling code here:
        homeButton();
    }//GEN-LAST:event_logoMouseClicked

    private void logoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoMousePressed
        // TODO add your handling code here:
        homeButton();
    }//GEN-LAST:event_logoMousePressed

    private void logoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoMouseReleased
        // TODO add your handling code here:
        homeButton();
    }//GEN-LAST:event_logoMouseReleased

    private void adoptedCounterbadgeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_adoptedCounterbadgeKeyPressed
        // TODO add your handling code here:
        // This will show the records of the adopted pets
    }//GEN-LAST:event_adoptedCounterbadgeKeyPressed

    private void adoptedLabelbadgeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_adoptedLabelbadgeKeyPressed
        // TODO add your handling code here:
        // This will show the records of the adopted pets
    }//GEN-LAST:event_adoptedLabelbadgeKeyPressed

    private void badgeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_badgeMouseEntered
        // TODO add your handling code here:
        badge.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/badge2 hover.png")));
        adoptedCounter.setForeground(java.awt.Color.yellow);
        adoptedLabel.setForeground(java.awt.Color.yellow);
    }//GEN-LAST:event_badgeMouseEntered

    private void badgeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_badgeMouseExited
        // TODO add your handling code here:
        badge.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/badge2.png")));
        adoptedCounter.setForeground(java.awt.Color.black);
        adoptedLabel.setForeground(java.awt.Color.black);
    }//GEN-LAST:event_badgeMouseExited

    private void badgeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_badgeKeyPressed
        // TODO add your handling code here:
        // This will show the records of the adopted pets
    }//GEN-LAST:event_badgeKeyPressed

    private void badgeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_badgeKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_badgeKeyReleased

    private void homeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeButtonMouseClicked
        // TODO add your handling code here:
        homeButton();
    }//GEN-LAST:event_homeButtonMouseClicked

    private void homeButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeButtonMouseEntered
        // TODO add your handling code here:
        if(!homeClicked) {
            homeClick.setVisible(true);
            homeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/home hover.png")));
        }
    }//GEN-LAST:event_homeButtonMouseEntered

    private void homeButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeButtonMouseExited
        // TODO add your handling code here:
        if(!homeClicked) {
            homeClick.setVisible(false);
            homeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/home.png")));
        }
    }//GEN-LAST:event_homeButtonMouseExited

    private void homeButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeButtonMousePressed
        // TODO add your handling code here:
        homeButton();
    }//GEN-LAST:event_homeButtonMousePressed

    private void homeButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeButtonMouseReleased
        // TODO add your handling code here:
        homeButton();
    }//GEN-LAST:event_homeButtonMouseReleased

    private void aboutUsButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutUsButtonMouseClicked
        // TODO add your handling code here:
        aboutUsButton();
    }//GEN-LAST:event_aboutUsButtonMouseClicked

    private void aboutUsButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutUsButtonMouseEntered
        // TODO add your handling code here:
        if(!aboutUsClicked) {
            aboutUsClick.setVisible(true);
            aboutUsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/about us hover.png")));
        }
    }//GEN-LAST:event_aboutUsButtonMouseEntered

    private void aboutUsButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutUsButtonMouseExited
        // TODO add your handling code here:
        if(!aboutUsClicked) {
            aboutUsClick.setVisible(false);
            aboutUsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/about us.png")));
        }
    }//GEN-LAST:event_aboutUsButtonMouseExited

    private void aboutUsButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutUsButtonMousePressed
        // TODO add your handling code here:
        aboutUsButton();
    }//GEN-LAST:event_aboutUsButtonMousePressed

    private void aboutUsButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutUsButtonMouseReleased
        // TODO add your handling code here:
        aboutUsButton();
    }//GEN-LAST:event_aboutUsButtonMouseReleased

    private void faqButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_faqButtonMouseClicked
        // TODO add your handling code here:
        // for FAQs panels' visibility
        faqButton();
    }//GEN-LAST:event_faqButtonMouseClicked

    private void faqButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_faqButtonMouseEntered
        // TODO add your handling code here:
        if(!FAQsClicked) {
            faqClick.setVisible(true);
            faqButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/FAQs hover.png")));
        }
    }//GEN-LAST:event_faqButtonMouseEntered

    private void faqButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_faqButtonMouseExited
        // TODO add your handling code here:
        if(!FAQsClicked) {
            faqClick.setVisible(false);
            faqButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/FAQs.png")));
        }
    }//GEN-LAST:event_faqButtonMouseExited

    private void faqButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_faqButtonMousePressed
        // TODO add your handling code here:
        faqButton();
    }//GEN-LAST:event_faqButtonMousePressed

    private void faqButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_faqButtonMouseReleased
        // TODO add your handling code here:
        faqButton();
    }//GEN-LAST:event_faqButtonMouseReleased

    private void petButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_petButtonMouseClicked
        // TODO add your handling code here:
        petButton();
    }//GEN-LAST:event_petButtonMouseClicked

    private void petButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_petButtonMouseEntered
        // TODO add your handling code here:
        if(!petsClicked) {
            petClick.setVisible(true);
            petButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/pets hover.png")));
        }
    }//GEN-LAST:event_petButtonMouseEntered

    private void petButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_petButtonMouseExited
        // TODO add your handling code here:
        if(!petsClicked) {
            petClick.setVisible(false);
            petButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/pets.png")));
        }
    }//GEN-LAST:event_petButtonMouseExited

    private void petButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_petButtonMousePressed
        // TODO add your handling code here:
        petButton();
    }//GEN-LAST:event_petButtonMousePressed

    private void petButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_petButtonMouseReleased
        // TODO add your handling code here:
        petButton();
    }//GEN-LAST:event_petButtonMouseReleased

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
            java.util.logging.Logger.getLogger(LandingPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LandingPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LandingPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LandingPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LandingPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel FAQsBody;
    private javax.swing.JLabel FAQsPanel;
    private javax.swing.JPanel aboutUsBody;
    private javax.swing.JLabel aboutUsButton;
    private javax.swing.JLabel aboutUsClick;
    private javax.swing.JLabel aboutUsPanel;
    private javax.swing.JLabel adoptedCounter;
    private javax.swing.JLabel adoptedLabel;
    private javax.swing.JLabel background;
    private javax.swing.JLabel background2;
    private javax.swing.JLabel background3;
    private javax.swing.JLabel background4;
    private javax.swing.JLabel badge;
    private javax.swing.JLabel bulletin;
    private javax.swing.JLabel businessRules;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel description;
    private javax.swing.JLabel devs;
    private javax.swing.JLabel faqButton;
    private javax.swing.JLabel faqClick;
    private javax.swing.JPanel homeBody;
    private javax.swing.JLabel homeButton;
    private javax.swing.JLabel homeClick;
    private javax.swing.JPanel line;
    private javax.swing.JLabel loginButton;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel navBar;
    private javax.swing.JLabel next;
    private javax.swing.JLabel petButton;
    private javax.swing.JLabel petClick;
    private javax.swing.JLabel petHeader;
    private javax.swing.JLabel petNext;
    private javax.swing.JLabel petPanel1;
    private javax.swing.JLabel petPanel2;
    private javax.swing.JLabel petPanel3;
    private javax.swing.JLabel petPrev;
    private javax.swing.JPanel petsBody;
    private javax.swing.JLabel registerButton;
    private javax.swing.JLabel slogan;
    // End of variables declaration//GEN-END:variables
}
