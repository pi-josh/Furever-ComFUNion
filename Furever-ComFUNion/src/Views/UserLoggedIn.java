package Views;

import Controllers.ConfirmationDialogController;
import Controllers.ExitDialogController;
import Models.Application;
import Models.Client;
import Models.Pet;
import Models.Veterinarian;
import java.awt.Color;
import java.awt.MediaTracker;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author joshu
 */
public class UserLoggedIn extends javax.swing.JFrame {
    // for moving the frame
    private Point mouseDownCompCoords;

    // Client who is currently logged in
    private Client client;

    // controllers
    ExitDialogController exitController;
    ConfirmationDialogController confirmationController;

    // for confirmation dialog
    boolean userResponse;

    // sub frames
    private ExitDialog exitDialog;
    private ConfirmationDialog confirmationDialog;
    private BusinessRules businessRulesFrame;
    private Devs devsFrame;
    private Adopt adopt;
    private Rehome rehome;
    private JPanel glassPane;

    // for pet current panel temp info holder
    private boolean petPanel1Clicked = false;
    private String petURL1;
    private String petURL2;
    private String petURL3;
    private String tempPetURL;
    private String tempPetName;
    private String tempPetAge;
    private String tempPetGender;

    // buttons clickability
    private boolean homeClicked;
    private boolean aboutUsClicked;
    private boolean FAQsClicked;
    private boolean petsClicked;
    private boolean vetsClicked;
    private boolean applicationClicked;
    private boolean profileClicked;
    private int FAQsPanelCounter = 4000001;

    // app next and prev buttons
    private boolean appPrev, appNext;

    // Sample pets
    ArrayList<Pet> pets;
    private int totalPets;
    private int petIndex = 0;

    // Sample vets
    ArrayList<Veterinarian> vets;
    private int totalVets;
    private int vetIndex = 0;

    // Sample applications
    ArrayList<Application> applications;
    private int totalApplications;
    private int appIndex = 0;

    /**
     * Creates new form Main
     */
    public UserLoggedIn(Client client) {
        this.client = client;

        // alisin na lang pagkatapos
        samples();

        initComponents();

        if (client != null) {
            // update profile
            updateClientProfile();
        }

        comboBoxes();

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

        // glass pane to block out any interaction within the main frame when opening a sub frame
        glassPane = new JPanel();
        glassPane.setOpaque(false);
        glassPane.setVisible(false);
        glassPane.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // brings the active sub frame on the front and add a system beep to notify

                // for exit dialog
                if (exitDialog != null && exitDialog.isVisible()) {
                    exitDialog.toFront();
                    Toolkit.getDefaultToolkit().beep();
                }

                // for business rules in about us panel
                if (businessRulesFrame != null && businessRulesFrame.isVisible()) {
                    businessRulesFrame.toFront();
                    Toolkit.getDefaultToolkit().beep();
                }

                // for devs in about us panel
                if (devsFrame != null && devsFrame.isVisible()) {
                    devsFrame.toFront();
                    Toolkit.getDefaultToolkit().beep();
                }

                // for confirmation dialog
                if (confirmationDialog != null && confirmationDialog.isVisible()) {
                    confirmationDialog.toFront();
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        });

        setGlassPane(glassPane);
    }

    private void updateClientProfile() {
        String firstName = client.getClientFullName().split(" ")[0];

        name.setText(firstName);
        profileName.setText(client.getClientFullName());
        profileUsername.setText(client.getClientUsername());
        profileContactNum.setText(client.getCellNum());
        profileEmailAddress.setText(client.getClientEmailAdd());
        profilePassword.setText(client.getClientPassword());
        profileAddress.setText(client.getClientAddress());
        profileOccupation.setText(client.getClientOccupation());
        profileWorkType.setText(client.getWorkType());
        profileAge.setText(String.valueOf(client.getClientAge()));
        profileUsername.setText(client.getClientUsername());

    }

    // getters
    public Adopt getAdopt() {
        return adopt;
    }

    public Rehome getRehome() {
        return rehome;
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
        exitButton = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        minimizeButton = new javax.swing.JLabel();
        line = new javax.swing.JPanel();
        homeButton = new javax.swing.JLabel();
        homeClick = new javax.swing.JLabel();
        aboutUsButton = new javax.swing.JLabel();
        aboutUsClick = new javax.swing.JLabel();
        faqButton = new javax.swing.JLabel();
        faqClick = new javax.swing.JLabel();
        petButton = new javax.swing.JLabel();
        petClick = new javax.swing.JLabel();
        vetButton = new javax.swing.JLabel();
        vetClick = new javax.swing.JLabel();
        applicationButton = new javax.swing.JLabel();
        applicationClick = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        profileHead = new javax.swing.JLabel();
        profileCollar = new javax.swing.JLabel();
        homeBody = new javax.swing.JPanel();
        slogan = new javax.swing.JLabel();
        adoptedCounter = new javax.swing.JLabel();
        adoptedLabel = new javax.swing.JLabel();
        badge = new javax.swing.JLabel();
        bulletin = new javax.swing.JLabel();
        background = new javax.swing.JLabel();
        aboutUsBody = new javax.swing.JPanel();
        devs = new javax.swing.JLabel();
        businessRules = new javax.swing.JLabel();
        aboutUsPanel = new javax.swing.JLabel();
        background1 = new javax.swing.JLabel();
        FAQsBody = new javax.swing.JPanel();
        prev = new javax.swing.JLabel();
        next = new javax.swing.JLabel();
        FAQsPanel1 = new javax.swing.JLabel();
        FAQsPanel2 = new javax.swing.JLabel();
        FAQsPanel3 = new javax.swing.JLabel();
        FAQsPanel4 = new javax.swing.JLabel();
        background2 = new javax.swing.JLabel();
        petsBody = new javax.swing.JPanel();
        petPrev = new javax.swing.JLabel();
        petNext = new javax.swing.JLabel();
        petImg1 = new javax.swing.JLabel();
        petImg2 = new javax.swing.JLabel();
        petImg3 = new javax.swing.JLabel();
        petName1 = new javax.swing.JLabel();
        petName2 = new javax.swing.JLabel();
        petName3 = new javax.swing.JLabel();
        petAge1 = new javax.swing.JLabel();
        petAge2 = new javax.swing.JLabel();
        petAge3 = new javax.swing.JLabel();
        petGender1 = new javax.swing.JLabel();
        petGender2 = new javax.swing.JLabel();
        petGender3 = new javax.swing.JLabel();
        petPanel1 = new javax.swing.JLabel();
        petPanel2 = new javax.swing.JLabel();
        petPanel3 = new javax.swing.JLabel();
        petBackButton = new javax.swing.JLabel();
        petAdoptButton = new javax.swing.JLabel();
        petSize = new javax.swing.JLabel();
        petStatus = new javax.swing.JLabel();
        petOrigin = new javax.swing.JLabel();
        petType = new javax.swing.JLabel();
        petID = new javax.swing.JLabel();
        petPanelClick = new javax.swing.JLabel();
        petNoResultsFound = new javax.swing.JLabel();
        petHeader = new javax.swing.JLabel();
        hamsterType = new javax.swing.JCheckBox();
        rabbitType = new javax.swing.JCheckBox();
        rescuedOrigin = new javax.swing.JCheckBox();
        adoptedStatus = new javax.swing.JCheckBox();
        tinySize = new javax.swing.JCheckBox();
        maleGender = new javax.swing.JCheckBox();
        ownedOrigin = new javax.swing.JCheckBox();
        notAdoptedStatus = new javax.swing.JCheckBox();
        smallSize = new javax.swing.JCheckBox();
        femaleGender = new javax.swing.JCheckBox();
        mediumSize = new javax.swing.JCheckBox();
        largeSize = new javax.swing.JCheckBox();
        catType = new javax.swing.JCheckBox();
        dogType = new javax.swing.JCheckBox();
        orderByName = new javax.swing.JCheckBox();
        orderByAge = new javax.swing.JCheckBox();
        orderByID = new javax.swing.JCheckBox();
        IDdescending = new javax.swing.JCheckBox();
        nameDescending = new javax.swing.JCheckBox();
        ageDescending = new javax.swing.JCheckBox();
        sortBy = new javax.swing.JLabel();
        filterBy = new javax.swing.JLabel();
        background3 = new javax.swing.JLabel();
        vetsBody = new javax.swing.JPanel();
        vetName1 = new javax.swing.JLabel();
        vetName2 = new javax.swing.JLabel();
        vetName3 = new javax.swing.JLabel();
        vetName4 = new javax.swing.JLabel();
        vetName5 = new javax.swing.JLabel();
        vetName6 = new javax.swing.JLabel();
        vetContact1 = new javax.swing.JLabel();
        vetContact2 = new javax.swing.JLabel();
        vetContact3 = new javax.swing.JLabel();
        vetContact4 = new javax.swing.JLabel();
        vetContact5 = new javax.swing.JLabel();
        vetContact6 = new javax.swing.JLabel();
        vetEmail1 = new javax.swing.JLabel();
        vetEmail2 = new javax.swing.JLabel();
        vetEmail3 = new javax.swing.JLabel();
        vetEmail4 = new javax.swing.JLabel();
        vetEmail5 = new javax.swing.JLabel();
        vetEmail6 = new javax.swing.JLabel();
        vetPrev = new javax.swing.JLabel();
        vetNext = new javax.swing.JLabel();
        vetNoResultsFound = new javax.swing.JLabel();
        vetsPanel = new javax.swing.JLabel();
        background4 = new javax.swing.JLabel();
        applicationBody = new javax.swing.JPanel();
        appID5 = new javax.swing.JLabel();
        appType5 = new javax.swing.JLabel();
        appPetName5 = new javax.swing.JLabel();
        appPetType5 = new javax.swing.JLabel();
        appAppointDate5 = new javax.swing.JLabel();
        appVet5 = new javax.swing.JLabel();
        appStatus5 = new javax.swing.JLabel();
        highlight5 = new javax.swing.JLabel();
        appID4 = new javax.swing.JLabel();
        appType4 = new javax.swing.JLabel();
        appPetName4 = new javax.swing.JLabel();
        appPetType4 = new javax.swing.JLabel();
        appAppointDate4 = new javax.swing.JLabel();
        appVet4 = new javax.swing.JLabel();
        appStatus4 = new javax.swing.JLabel();
        highlight4 = new javax.swing.JLabel();
        appID3 = new javax.swing.JLabel();
        appType3 = new javax.swing.JLabel();
        appPetName3 = new javax.swing.JLabel();
        appPetType3 = new javax.swing.JLabel();
        appAppointDate3 = new javax.swing.JLabel();
        appVet3 = new javax.swing.JLabel();
        appStatus3 = new javax.swing.JLabel();
        highlight3 = new javax.swing.JLabel();
        appID2 = new javax.swing.JLabel();
        appType2 = new javax.swing.JLabel();
        appPetName2 = new javax.swing.JLabel();
        appPetType2 = new javax.swing.JLabel();
        appAppointDate2 = new javax.swing.JLabel();
        appVet2 = new javax.swing.JLabel();
        appStatus2 = new javax.swing.JLabel();
        appStatus1 = new javax.swing.JLabel();
        highlight2 = new javax.swing.JLabel();
        appVet1 = new javax.swing.JLabel();
        appAppointDate1 = new javax.swing.JLabel();
        appPetType1 = new javax.swing.JLabel();
        appPetName1 = new javax.swing.JLabel();
        appType1 = new javax.swing.JLabel();
        appID1 = new javax.swing.JLabel();
        highlight1 = new javax.swing.JLabel();
        editButton = new javax.swing.JLabel();
        cancelButton = new javax.swing.JLabel();
        confirmButton = new javax.swing.JLabel();
        deleteButton1 = new javax.swing.JLabel();
        deleteButton2 = new javax.swing.JLabel();
        deleteButton3 = new javax.swing.JLabel();
        deleteButton4 = new javax.swing.JLabel();
        deleteButton5 = new javax.swing.JLabel();
        applicationPrev = new javax.swing.JLabel();
        applicationNext = new javax.swing.JLabel();
        adoptButton = new javax.swing.JLabel();
        rehomeButton = new javax.swing.JLabel();
        appNoResultsFound = new javax.swing.JLabel();
        applicationPanel = new javax.swing.JLabel();
        background5 = new javax.swing.JLabel();
        profileBody = new javax.swing.JPanel();
        profilePicture = new javax.swing.JLabel();
        fullNameScroll = new javax.swing.JScrollPane();
        fullName = new javax.swing.JTextPane();
        profileName = new javax.swing.JLabel();
        usernameScroll = new javax.swing.JScrollPane();
        username1 = new javax.swing.JTextPane();
        profileUsername = new javax.swing.JLabel();
        contactNumScroll = new javax.swing.JScrollPane();
        contactNum = new javax.swing.JTextPane();
        profileContactNum = new javax.swing.JLabel();
        emailAddressScroll = new javax.swing.JScrollPane();
        emailAddress = new javax.swing.JTextPane();
        profileEmailAddress = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        confirmPasswordLabel = new javax.swing.JLabel();
        confirmPassword = new javax.swing.JPasswordField();
        profilePassword = new javax.swing.JLabel();
        currentAddressScroll = new javax.swing.JScrollPane();
        currentAddress = new javax.swing.JTextPane();
        profileAddress = new javax.swing.JLabel();
        occupationScroll = new javax.swing.JScrollPane();
        occupation = new javax.swing.JTextPane();
        profileOccupation = new javax.swing.JLabel();
        companyScroll = new javax.swing.JScrollPane();
        companyName = new javax.swing.JTextPane();
        profileCompany = new javax.swing.JLabel();
        workType = new javax.swing.JComboBox<>();
        profileWorkType = new javax.swing.JLabel();
        birthdayScroll = new javax.swing.JScrollPane();
        birthdate = new javax.swing.JTextPane();
        year = new javax.swing.JComboBox<>();
        month = new javax.swing.JComboBox<>();
        day = new javax.swing.JComboBox<>();
        profileAge = new javax.swing.JLabel();
        profileDeleteButton = new javax.swing.JLabel();
        profileEditButton = new javax.swing.JLabel();
        profileCancelButton = new javax.swing.JLabel();
        profileConfirmButton = new javax.swing.JLabel();
        logoutButton = new javax.swing.JLabel();
        profilePanel = new javax.swing.JLabel();
        background6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Furever ComFUNion");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1370, 880));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        navBar.setBackground(new java.awt.Color(194, 144, 69));
        navBar.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        navBar.setMinimumSize(new java.awt.Dimension(1370, 140));
        navBar.setPreferredSize(new java.awt.Dimension(1370, 140));
        navBar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                navBarMouseDragged(evt);
            }
        });
        navBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                navBarMousePressed(evt);
            }
        });
        navBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        exitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/exit button (1).png"))); // NOI18N
        exitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitButtonMouseExited(evt);
            }
        });
        navBar.add(exitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1325, 5, 40, 40));

        logo.setBackground(navBar.getBackground());
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/navLogo.png"))); // NOI18N
        logo.setIconTextGap(0);
        logo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                logoMousePressed(evt);
            }
        });
        navBar.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

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
        navBar.add(minimizeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1285, 10, 40, 20));

        line.setBackground(new java.awt.Color(255, 251, 209));
        line.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 1, new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout lineLayout = new javax.swing.GroupLayout(line);
        line.setLayout(lineLayout);
        lineLayout.setHorizontalGroup(
            lineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1368, Short.MAX_VALUE)
        );
        lineLayout.setVerticalGroup(
            lineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 29, Short.MAX_VALUE)
        );

        navBar.add(line, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 109, 1370, 30));

        homeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/home click.png"))); // NOI18N
        homeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                homeButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                homeButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                homeButtonMousePressed(evt);
            }
        });
        navBar.add(homeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 65, -1, -1));

        homeClick.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/click bg.png"))); // NOI18N
        navBar.add(homeClick, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 50, -1, -1));

        aboutUsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/about us.png"))); // NOI18N
        aboutUsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                aboutUsButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                aboutUsButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                aboutUsButtonMousePressed(evt);
            }
        });
        navBar.add(aboutUsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 65, -1, -1));

        aboutUsClick.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/click bg.png"))); // NOI18N
        navBar.add(aboutUsClick, new org.netbeans.lib.awtextra.AbsoluteConstraints(525, 50, -1, -1));

        faqButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/FAQs.png"))); // NOI18N
        faqButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                faqButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                faqButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                faqButtonMousePressed(evt);
            }
        });
        navBar.add(faqButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 65, -1, -1));

        faqClick.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/click bg.png"))); // NOI18N
        navBar.add(faqClick, new org.netbeans.lib.awtextra.AbsoluteConstraints(645, 50, -1, -1));

        petButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/pets.png"))); // NOI18N
        petButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                petButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                petButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                petButtonMousePressed(evt);
            }
        });
        navBar.add(petButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 65, -1, -1));

        petClick.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/click bg.png"))); // NOI18N
        navBar.add(petClick, new org.netbeans.lib.awtextra.AbsoluteConstraints(765, 50, -1, -1));

        vetButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/vets.png"))); // NOI18N
        vetButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                vetButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                vetButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                vetButtonMousePressed(evt);
            }
        });
        navBar.add(vetButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 65, -1, -1));

        vetClick.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/click bg.png"))); // NOI18N
        navBar.add(vetClick, new org.netbeans.lib.awtextra.AbsoluteConstraints(885, 50, -1, -1));

        applicationButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/application.png"))); // NOI18N
        applicationButton.setToolTipText("");
        applicationButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                applicationButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                applicationButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                applicationButtonMousePressed(evt);
            }
        });
        navBar.add(applicationButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 45, -1, -1));

        applicationClick.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/click bg 2.png"))); // NOI18N
        navBar.add(applicationClick, new org.netbeans.lib.awtextra.AbsoluteConstraints(1005, 20, -1, -1));

        name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        name.setText("Joshua");
        navBar.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(1195, 75, 90, -1));

        profileHead.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/head.png"))); // NOI18N
        profileHead.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                profileHeadMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                profileHeadMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                profileHeadMousePressed(evt);
            }
        });
        navBar.add(profileHead, new org.netbeans.lib.awtextra.AbsoluteConstraints(1207, 10, -1, -1));

        profileCollar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/collar.png"))); // NOI18N
        profileCollar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                profileCollarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                profileCollarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                profileCollarMousePressed(evt);
            }
        });
        navBar.add(profileCollar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 55, -1, -1));

        getContentPane().add(navBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 140));

        homeBody.setBackground(new java.awt.Color(255, 251, 209));
        homeBody.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        homeBody.setPreferredSize(new java.awt.Dimension(1370, 740));
        homeBody.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        slogan.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        slogan.setForeground(new java.awt.Color(51, 51, 255));
        slogan.setText("<html> <head> <style> p {     font-family: 'Comic Sans MS', cursive;     font-size: 60px;     color: #000000; /* Black text */     text-align: center;     margin-top: 50px;     text-shadow:          -1px -1px 0 #ffffff,           1px -1px 0 #ffffff,         -1px 1px 0 #ffffff,         1px 1px 0 #ffffff; /* White border */ } </style> </head> <body> <p>Connecting Hearts with Paws</p> </body> </html> ");
        homeBody.add(slogan, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 670, 260));

        adoptedCounter.setFont(new java.awt.Font("Tahoma", 1, 72)); // NOI18N
        adoptedCounter.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        adoptedCounter.setText("100");
        homeBody.add(adoptedCounter, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 240, 220, 120));

        adoptedLabel.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        adoptedLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        adoptedLabel.setText("Wonderful Pets");
        adoptedLabel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                badgeKeyPressed(evt);
            }
        });
        homeBody.add(adoptedLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 490, 320, 50));

        badge.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/badge2.png"))); // NOI18N
        badge.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                badgeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                badgeMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                badgeMousePressed(evt);
            }
        });
        homeBody.add(badge, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 100, -1, -1));

        bulletin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/bulletin.png"))); // NOI18N
        homeBody.add(bulletin, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, 650, 410));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/paw prints.png"))); // NOI18N
        homeBody.add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 0, 1366, 738));

        getContentPane().add(homeBody, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 139, 1370, 740));

        aboutUsBody.setBackground(new java.awt.Color(255, 251, 209));
        aboutUsBody.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        aboutUsBody.setPreferredSize(new java.awt.Dimension(1370, 740));
        aboutUsBody.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        devs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/about us dev (1).png"))); // NOI18N
        devs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                devsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                devsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                devsMouseExited(evt);
            }
        });
        aboutUsBody.add(devs, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 545, -1, 200));

        businessRules.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/about us business rule (1).png"))); // NOI18N
        businessRules.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                businessRulesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                businessRulesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                businessRulesMouseExited(evt);
            }
        });
        aboutUsBody.add(businessRules, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 545, 400, 200));

        aboutUsPanel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/about us panel (1).png"))); // NOI18N
        aboutUsBody.add(aboutUsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 850, 780));

        background1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/paw prints.png"))); // NOI18N
        aboutUsBody.add(background1, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 0, 1366, 738));

        getContentPane().add(aboutUsBody, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 139, 1370, 740));

        FAQsBody.setBackground(new java.awt.Color(255, 251, 209));
        FAQsBody.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        FAQsBody.setPreferredSize(new java.awt.Dimension(1370, 740));
        FAQsBody.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        prev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/prev button (1).png"))); // NOI18N
        prev.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                prevMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                prevMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                prevMouseExited(evt);
            }
        });
        FAQsBody.add(prev, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 610, 350, 120));

        next.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/next button (1).png"))); // NOI18N
        next.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nextMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nextMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nextMouseExited(evt);
            }
        });
        FAQsBody.add(next, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 620, 350, 100));

        FAQsPanel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        FAQsPanel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/FAQs_1.png"))); // NOI18N
        FAQsBody.add(FAQsPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 20, 1000, 700));

        FAQsPanel2.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        FAQsPanel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/FAQs_2.png"))); // NOI18N
        FAQsBody.add(FAQsPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 20, 1000, 700));

        FAQsPanel3.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        FAQsPanel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/FAQs_3.png"))); // NOI18N
        FAQsBody.add(FAQsPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 20, 1000, 700));

        FAQsPanel4.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        FAQsPanel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/FAQs_4.png"))); // NOI18N
        FAQsPanel4.setLabelFor(FAQsPanel4);
        FAQsBody.add(FAQsPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 20, 1000, 700));

        background2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/paw prints.png"))); // NOI18N
        FAQsBody.add(background2, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 0, 1366, 738));

        getContentPane().add(FAQsBody, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 139, 1370, 740));

        petsBody.setBackground(new java.awt.Color(255, 251, 209));
        petsBody.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        petsBody.setPreferredSize(new java.awt.Dimension(1370, 740));
        petsBody.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        petPrev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/prev button (1).png"))); // NOI18N
        petPrev.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                petPrevMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                petPrevMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                petPrevMouseExited(evt);
            }
        });
        petsBody.add(petPrev, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 620, 350, 120));

        petNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/next button (1).png"))); // NOI18N
        petNext.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                petNextMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                petNextMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                petNextMouseExited(evt);
            }
        });
        petsBody.add(petNext, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 630, 350, 100));

        petImg1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        petsBody.add(petImg1, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 258, 190, 170));

        petImg2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        petsBody.add(petImg2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 258, 190, 170));

        petImg3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        petsBody.add(petImg3, new org.netbeans.lib.awtextra.AbsoluteConstraints(995, 258, 190, 170));

        petName1.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        petName1.setText("Caliver");
        petsBody.add(petName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 507, 170, -1));

        petName2.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        petName2.setText("Tiktok");
        petsBody.add(petName2, new org.netbeans.lib.awtextra.AbsoluteConstraints(639, 507, 180, -1));

        petName3.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        petName3.setText("Clover");
        petsBody.add(petName3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1053, 507, 162, -1));

        petAge1.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        petAge1.setText("24 months");
        petsBody.add(petAge1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 544, 200, -1));

        petAge2.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        petAge2.setText("18 months");
        petsBody.add(petAge2, new org.netbeans.lib.awtextra.AbsoluteConstraints(623, 544, 196, -1));

        petAge3.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        petAge3.setText("28 months");
        petsBody.add(petAge3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1025, 544, 190, -1));

        petGender1.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        petGender1.setText("Male");
        petsBody.add(petGender1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 580, 160, -1));

        petGender2.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        petGender2.setText("Female");
        petsBody.add(petGender2, new org.netbeans.lib.awtextra.AbsoluteConstraints(661, 580, 158, -1));

        petGender3.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        petGender3.setText("Male");
        petsBody.add(petGender3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 580, 155, -1));

        petPanel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/pets panel (1).png"))); // NOI18N
        petPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                petPanel1MouseClicked(evt);
            }
        });
        petsBody.add(petPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 400, 530));

        petPanel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/pets panel (1).png"))); // NOI18N
        petPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                petPanel2MouseClicked(evt);
            }
        });
        petsBody.add(petPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 150, 400, 530));

        petPanel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/pets panel (1).png"))); // NOI18N
        petPanel3.setPreferredSize(new java.awt.Dimension(400, 400));
        petPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                petPanel3MouseClicked(evt);
            }
        });
        petsBody.add(petPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 150, 400, 530));

        petBackButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/back button (2).png"))); // NOI18N
        petBackButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                petBackButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                petBackButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                petBackButtonMouseExited(evt);
            }
        });
        petsBody.add(petBackButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 260, -1, -1));

        petAdoptButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/adopt button (1).png"))); // NOI18N
        petAdoptButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                petAdoptButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                petAdoptButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                petAdoptButtonMouseExited(evt);
            }
        });
        petsBody.add(petAdoptButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 600, 250, 70));

        petSize.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        petSize.setText("Small");
        petsBody.add(petSize, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 553, -1, -1));

        petStatus.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        petStatus.setText("A");
        petsBody.add(petStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 488, -1, -1));

        petOrigin.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        petOrigin.setText("Owned");
        petsBody.add(petOrigin, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 420, -1, -1));

        petType.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        petType.setText("Dog");
        petsBody.add(petType, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 353, -1, -1));

        petID.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        petID.setText("P008");
        petsBody.add(petID, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 283, -1, -1));

        petPanelClick.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/pet panel click (1).png"))); // NOI18N
        petsBody.add(petPanelClick, new org.netbeans.lib.awtextra.AbsoluteConstraints(441, 213, 790, 450));

        petNoResultsFound.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        petNoResultsFound.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/no result found (1).png"))); // NOI18N
        petNoResultsFound.setToolTipText("");
        petsBody.add(petNoResultsFound, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 240, 730, 330));

        petHeader.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        petHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        petHeader.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/pets header.png"))); // NOI18N
        petsBody.add(petHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 250, 90));

        hamsterType.setBackground(new java.awt.Color(255, 255, 255));
        hamsterType.setFont(new java.awt.Font("Tahoma", 0, 1)); // NOI18N
        hamsterType.setText("'Hamster'");
        hamsterType.setBorder(null);
        hamsterType.setContentAreaFilled(false);
        hamsterType.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hamsterType.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        hamsterType.setIconTextGap(0);
        hamsterType.setMargin(new java.awt.Insets(0, 0, 0, 0));
        hamsterType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hamsterTypeActionPerformed(evt);
            }
        });
        petsBody.add(hamsterType, new org.netbeans.lib.awtextra.AbsoluteConstraints(298, 45, 15, 15));

        rabbitType.setBackground(new java.awt.Color(255, 255, 255));
        rabbitType.setFont(new java.awt.Font("Tahoma", 0, 1)); // NOI18N
        rabbitType.setText("'Rabbit'");
        rabbitType.setBorder(null);
        rabbitType.setContentAreaFilled(false);
        rabbitType.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rabbitType.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        rabbitType.setIconTextGap(0);
        rabbitType.setMargin(new java.awt.Insets(0, 0, 0, 0));
        rabbitType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rabbitTypeActionPerformed(evt);
            }
        });
        petsBody.add(rabbitType, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 45, 15, 15));

        rescuedOrigin.setBackground(new java.awt.Color(255, 255, 255));
        rescuedOrigin.setFont(new java.awt.Font("Tahoma", 0, 1)); // NOI18N
        rescuedOrigin.setText("'R'");
        rescuedOrigin.setBorder(null);
        rescuedOrigin.setContentAreaFilled(false);
        rescuedOrigin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rescuedOrigin.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        rescuedOrigin.setIconTextGap(0);
        rescuedOrigin.setMargin(new java.awt.Insets(0, 0, 0, 0));
        rescuedOrigin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rescuedOriginActionPerformed(evt);
            }
        });
        petsBody.add(rescuedOrigin, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 63, 15, 15));

        adoptedStatus.setBackground(new java.awt.Color(255, 255, 255));
        adoptedStatus.setFont(new java.awt.Font("Tahoma", 0, 1)); // NOI18N
        adoptedStatus.setText("'A'");
        adoptedStatus.setBorder(null);
        adoptedStatus.setContentAreaFilled(false);
        adoptedStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        adoptedStatus.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        adoptedStatus.setIconTextGap(0);
        adoptedStatus.setMargin(new java.awt.Insets(0, 0, 0, 0));
        adoptedStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adoptedStatusActionPerformed(evt);
            }
        });
        petsBody.add(adoptedStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 81, 15, 15));

        tinySize.setBackground(new java.awt.Color(255, 255, 255));
        tinySize.setFont(new java.awt.Font("Tahoma", 0, 1)); // NOI18N
        tinySize.setText("'T'");
        tinySize.setBorder(null);
        tinySize.setContentAreaFilled(false);
        tinySize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tinySize.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tinySize.setIconTextGap(0);
        tinySize.setMargin(new java.awt.Insets(0, 0, 0, 0));
        tinySize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tinySizeActionPerformed(evt);
            }
        });
        petsBody.add(tinySize, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 98, 15, 15));

        maleGender.setBackground(new java.awt.Color(255, 255, 255));
        maleGender.setFont(new java.awt.Font("Tahoma", 0, 1)); // NOI18N
        maleGender.setText("'M'");
        maleGender.setToolTipText("");
        maleGender.setBorder(null);
        maleGender.setContentAreaFilled(false);
        maleGender.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        maleGender.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        maleGender.setIconTextGap(0);
        maleGender.setMargin(new java.awt.Insets(0, 0, 0, 0));
        maleGender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maleGenderActionPerformed(evt);
            }
        });
        petsBody.add(maleGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 115, 15, 15));

        ownedOrigin.setBackground(new java.awt.Color(255, 255, 255));
        ownedOrigin.setFont(new java.awt.Font("Tahoma", 0, 1)); // NOI18N
        ownedOrigin.setText("'O'");
        ownedOrigin.setBorder(null);
        ownedOrigin.setContentAreaFilled(false);
        ownedOrigin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ownedOrigin.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ownedOrigin.setIconTextGap(0);
        ownedOrigin.setMargin(new java.awt.Insets(0, 0, 0, 0));
        ownedOrigin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ownedOriginActionPerformed(evt);
            }
        });
        petsBody.add(ownedOrigin, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 63, 15, 15));

        notAdoptedStatus.setBackground(new java.awt.Color(255, 255, 255));
        notAdoptedStatus.setFont(new java.awt.Font("Tahoma", 0, 1)); // NOI18N
        notAdoptedStatus.setText("'NA'");
        notAdoptedStatus.setBorder(null);
        notAdoptedStatus.setContentAreaFilled(false);
        notAdoptedStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        notAdoptedStatus.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        notAdoptedStatus.setIconTextGap(0);
        notAdoptedStatus.setMargin(new java.awt.Insets(0, 0, 0, 0));
        notAdoptedStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                notAdoptedStatusActionPerformed(evt);
            }
        });
        petsBody.add(notAdoptedStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 81, 15, 15));

        smallSize.setBackground(new java.awt.Color(255, 255, 255));
        smallSize.setFont(new java.awt.Font("Tahoma", 0, 1)); // NOI18N
        smallSize.setText("'S'");
        smallSize.setBorder(null);
        smallSize.setContentAreaFilled(false);
        smallSize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        smallSize.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        smallSize.setIconTextGap(0);
        smallSize.setMargin(new java.awt.Insets(0, 0, 0, 0));
        smallSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smallSizeActionPerformed(evt);
            }
        });
        petsBody.add(smallSize, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 98, 15, 15));

        femaleGender.setBackground(new java.awt.Color(255, 255, 255));
        femaleGender.setFont(new java.awt.Font("Tahoma", 0, 1)); // NOI18N
        femaleGender.setText("'F'");
        femaleGender.setBorder(null);
        femaleGender.setContentAreaFilled(false);
        femaleGender.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        femaleGender.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        femaleGender.setIconTextGap(0);
        femaleGender.setMargin(new java.awt.Insets(0, 0, 0, 0));
        femaleGender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femaleGenderActionPerformed(evt);
            }
        });
        petsBody.add(femaleGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 115, 15, 15));

        mediumSize.setBackground(new java.awt.Color(255, 255, 255));
        mediumSize.setFont(new java.awt.Font("Tahoma", 0, 1)); // NOI18N
        mediumSize.setText("'M'");
        mediumSize.setBorder(null);
        mediumSize.setContentAreaFilled(false);
        mediumSize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mediumSize.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        mediumSize.setIconTextGap(0);
        mediumSize.setMargin(new java.awt.Insets(0, 0, 0, 0));
        mediumSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mediumSizeActionPerformed(evt);
            }
        });
        petsBody.add(mediumSize, new org.netbeans.lib.awtextra.AbsoluteConstraints(298, 98, 15, 15));

        largeSize.setBackground(new java.awt.Color(255, 255, 255));
        largeSize.setFont(new java.awt.Font("Tahoma", 0, 1)); // NOI18N
        largeSize.setText("'L'");
        largeSize.setBorder(null);
        largeSize.setContentAreaFilled(false);
        largeSize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        largeSize.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        largeSize.setIconTextGap(0);
        largeSize.setMargin(new java.awt.Insets(0, 0, 0, 0));
        largeSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                largeSizeActionPerformed(evt);
            }
        });
        petsBody.add(largeSize, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 98, 15, 15));

        catType.setBackground(new java.awt.Color(255, 255, 255));
        catType.setFont(new java.awt.Font("Tahoma", 0, 1)); // NOI18N
        catType.setText("'Cat'");
        catType.setBorder(null);
        catType.setContentAreaFilled(false);
        catType.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        catType.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        catType.setIconTextGap(0);
        catType.setMargin(new java.awt.Insets(0, 0, 0, 0));
        catType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                catTypeActionPerformed(evt);
            }
        });
        petsBody.add(catType, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 45, 15, 15));

        dogType.setBackground(new java.awt.Color(255, 255, 255));
        dogType.setFont(new java.awt.Font("Tahoma", 0, 1)); // NOI18N
        dogType.setText("'Dog'");
        dogType.setBorder(null);
        dogType.setContentAreaFilled(false);
        dogType.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dogType.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        dogType.setIconTextGap(0);
        dogType.setMargin(new java.awt.Insets(0, 0, 0, 0));
        dogType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dogTypeActionPerformed(evt);
            }
        });
        petsBody.add(dogType, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 45, 15, 15));

        orderByName.setBackground(new java.awt.Color(255, 255, 255));
        orderByName.setBorder(null);
        orderByName.setContentAreaFilled(false);
        orderByName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        orderByName.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        orderByName.setIconTextGap(0);
        orderByName.setMargin(new java.awt.Insets(0, 0, 0, 0));
        orderByName.setPreferredSize(new java.awt.Dimension(30, 30));
        orderByName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderByNameActionPerformed(evt);
            }
        });
        petsBody.add(orderByName, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 70, 30, 30));

        orderByAge.setBackground(new java.awt.Color(255, 255, 255));
        orderByAge.setBorder(null);
        orderByAge.setContentAreaFilled(false);
        orderByAge.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        orderByAge.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        orderByAge.setIconTextGap(0);
        orderByAge.setMargin(new java.awt.Insets(0, 0, 0, 0));
        orderByAge.setPreferredSize(new java.awt.Dimension(30, 30));
        petsBody.add(orderByAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 100, 30, 30));

        orderByID.setBackground(new java.awt.Color(255, 255, 255));
        orderByID.setBorder(null);
        orderByID.setContentAreaFilled(false);
        orderByID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        orderByID.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        orderByID.setIconTextGap(0);
        orderByID.setMargin(new java.awt.Insets(0, 0, 0, 0));
        orderByID.setPreferredSize(new java.awt.Dimension(30, 30));
        orderByID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderByIDActionPerformed(evt);
            }
        });
        petsBody.add(orderByID, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 40, 30, 30));

        IDdescending.setBackground(new java.awt.Color(255, 255, 255));
        IDdescending.setBorder(null);
        IDdescending.setContentAreaFilled(false);
        IDdescending.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IDdescending.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        IDdescending.setIconTextGap(0);
        IDdescending.setMargin(new java.awt.Insets(0, 0, 0, 0));
        IDdescending.setPreferredSize(new java.awt.Dimension(30, 30));
        IDdescending.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDdescendingActionPerformed(evt);
            }
        });
        petsBody.add(IDdescending, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 50, 30, 30));

        nameDescending.setBackground(new java.awt.Color(255, 255, 255));
        nameDescending.setBorder(null);
        nameDescending.setContentAreaFilled(false);
        nameDescending.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameDescending.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nameDescending.setIconTextGap(0);
        nameDescending.setMargin(new java.awt.Insets(0, 0, 0, 0));
        nameDescending.setPreferredSize(new java.awt.Dimension(30, 30));
        nameDescending.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameDescendingActionPerformed(evt);
            }
        });
        petsBody.add(nameDescending, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 80, 30, 30));

        ageDescending.setBackground(new java.awt.Color(255, 255, 255));
        ageDescending.setBorder(null);
        ageDescending.setContentAreaFilled(false);
        ageDescending.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ageDescending.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ageDescending.setIconTextGap(0);
        ageDescending.setMargin(new java.awt.Insets(0, 0, 0, 0));
        ageDescending.setPreferredSize(new java.awt.Dimension(30, 30));
        ageDescending.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ageDescendingActionPerformed(evt);
            }
        });
        petsBody.add(ageDescending, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 100, 30, 30));

        sortBy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/sort by.png"))); // NOI18N
        petsBody.add(sortBy, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 10, 540, 140));

        filterBy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/filter by.png"))); // NOI18N
        petsBody.add(filterBy, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 540, 140));

        background3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/paw prints.png"))); // NOI18N
        petsBody.add(background3, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 0, 1366, 738));

        getContentPane().add(petsBody, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 139, 1370, 740));

        vetsBody.setBackground(new java.awt.Color(255, 251, 209));
        vetsBody.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        vetsBody.setPreferredSize(new java.awt.Dimension(1370, 740));
        vetsBody.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        vetName1.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        vetName1.setForeground(new java.awt.Color(255, 255, 255));
        vetName1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        vetName1.setText("Pangalan ni Vet1");
        vetName1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        vetsBody.add(vetName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 240, 200, 25));

        vetName2.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        vetName2.setForeground(new java.awt.Color(255, 255, 255));
        vetName2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        vetName2.setText("Pangalan ni Vet2");
        vetName2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        vetsBody.add(vetName2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 300, 200, 25));

        vetName3.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        vetName3.setForeground(new java.awt.Color(255, 255, 255));
        vetName3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        vetName3.setText("Pangalan ni Vet3");
        vetName3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        vetsBody.add(vetName3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 360, 200, 25));

        vetName4.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        vetName4.setForeground(new java.awt.Color(255, 255, 255));
        vetName4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        vetName4.setText("Pangalan ni Vet4");
        vetName4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        vetsBody.add(vetName4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 420, 200, 25));

        vetName5.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        vetName5.setForeground(new java.awt.Color(255, 255, 255));
        vetName5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        vetName5.setText("Pangalan ni Vet5");
        vetName5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        vetsBody.add(vetName5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 480, 200, 25));

        vetName6.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        vetName6.setForeground(new java.awt.Color(255, 255, 255));
        vetName6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        vetName6.setText("Pangalan ni Vet6");
        vetName6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        vetsBody.add(vetName6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 540, 200, 25));

        vetContact1.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        vetContact1.setForeground(new java.awt.Color(255, 255, 255));
        vetContact1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        vetContact1.setText("Contact ni Vet1");
        vetContact1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        vetsBody.add(vetContact1, new org.netbeans.lib.awtextra.AbsoluteConstraints(835, 240, 200, 25));

        vetContact2.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        vetContact2.setForeground(new java.awt.Color(255, 255, 255));
        vetContact2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        vetContact2.setText("Contact ni Vet2");
        vetContact2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        vetsBody.add(vetContact2, new org.netbeans.lib.awtextra.AbsoluteConstraints(835, 300, 200, 25));

        vetContact3.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        vetContact3.setForeground(new java.awt.Color(255, 255, 255));
        vetContact3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        vetContact3.setText("Contact ni Vet3");
        vetContact3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        vetsBody.add(vetContact3, new org.netbeans.lib.awtextra.AbsoluteConstraints(835, 360, 200, 25));

        vetContact4.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        vetContact4.setForeground(new java.awt.Color(255, 255, 255));
        vetContact4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        vetContact4.setText("Contact ni Vet4");
        vetContact4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        vetsBody.add(vetContact4, new org.netbeans.lib.awtextra.AbsoluteConstraints(835, 420, 200, 25));

        vetContact5.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        vetContact5.setForeground(new java.awt.Color(255, 255, 255));
        vetContact5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        vetContact5.setText("Contact ni Vet5");
        vetContact5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        vetsBody.add(vetContact5, new org.netbeans.lib.awtextra.AbsoluteConstraints(835, 480, 200, 25));

        vetContact6.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        vetContact6.setForeground(new java.awt.Color(255, 255, 255));
        vetContact6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        vetContact6.setText("Contact ni Vet6");
        vetContact6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        vetsBody.add(vetContact6, new org.netbeans.lib.awtextra.AbsoluteConstraints(835, 540, 200, 25));

        vetEmail1.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        vetEmail1.setForeground(new java.awt.Color(255, 255, 255));
        vetEmail1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        vetEmail1.setText("Email ni Vet1");
        vetEmail1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        vetsBody.add(vetEmail1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 240, 250, 25));

        vetEmail2.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        vetEmail2.setForeground(new java.awt.Color(255, 255, 255));
        vetEmail2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        vetEmail2.setText("Email ni Vet2");
        vetEmail2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        vetsBody.add(vetEmail2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 300, 250, 25));

        vetEmail3.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        vetEmail3.setForeground(new java.awt.Color(255, 255, 255));
        vetEmail3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        vetEmail3.setText("Email ni Vet3");
        vetEmail3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        vetsBody.add(vetEmail3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 360, 250, 25));

        vetEmail4.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        vetEmail4.setForeground(new java.awt.Color(255, 255, 255));
        vetEmail4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        vetEmail4.setText("Email ni Vet4");
        vetEmail4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        vetsBody.add(vetEmail4, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 420, 250, 25));

        vetEmail5.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        vetEmail5.setForeground(new java.awt.Color(255, 255, 255));
        vetEmail5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        vetEmail5.setText("Email ni Vet5");
        vetEmail5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        vetsBody.add(vetEmail5, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 480, 250, 25));

        vetEmail6.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        vetEmail6.setForeground(new java.awt.Color(255, 255, 255));
        vetEmail6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        vetEmail6.setText("Email ni Vet6");
        vetEmail6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        vetsBody.add(vetEmail6, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 540, 250, 25));

        vetPrev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/prev button (1).png"))); // NOI18N
        vetPrev.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vetPrevMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                vetPrevMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                vetPrevMouseExited(evt);
            }
        });
        vetsBody.add(vetPrev, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 620, 350, 120));

        vetNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/next button (1).png"))); // NOI18N
        vetNext.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vetNextMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                vetNextMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                vetNextMouseExited(evt);
            }
        });
        vetsBody.add(vetNext, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 630, 350, 100));

        vetNoResultsFound.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        vetNoResultsFound.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/no result found (1).png"))); // NOI18N
        vetNoResultsFound.setToolTipText("");
        vetsBody.add(vetNoResultsFound, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 240, 730, 330));

        vetsPanel.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        vetsPanel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        vetsPanel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/vets panel (1).png"))); // NOI18N
        vetsBody.add(vetsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 15, -1, 710));

        background4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/paw prints.png"))); // NOI18N
        vetsBody.add(background4, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 0, 1366, 738));

        getContentPane().add(vetsBody, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 139, 1370, 740));

        applicationBody.setBackground(new java.awt.Color(255, 251, 209));
        applicationBody.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        applicationBody.setPreferredSize(new java.awt.Dimension(1370, 740));
        applicationBody.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        appID5.setBackground(new java.awt.Color(255, 255, 255));
        appID5.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        appID5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        appID5.setText("1");
        appID5.setToolTipText("");
        applicationBody.add(appID5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 580, 40, -1));

        appType5.setBackground(new java.awt.Color(255, 255, 255));
        appType5.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        appType5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        appType5.setText("Rehome");
        appType5.setToolTipText("");
        applicationBody.add(appType5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 580, 80, -1));

        appPetName5.setBackground(new java.awt.Color(255, 255, 255));
        appPetName5.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        appPetName5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        appPetName5.setText("Clovernistic");
        appPetName5.setToolTipText("");
        applicationBody.add(appPetName5, new org.netbeans.lib.awtextra.AbsoluteConstraints(443, 580, 120, -1));

        appPetType5.setBackground(new java.awt.Color(255, 255, 255));
        appPetType5.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        appPetType5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        appPetType5.setText("Hamster");
        appPetType5.setToolTipText("");
        applicationBody.add(appPetType5, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 580, 110, -1));

        appAppointDate5.setBackground(new java.awt.Color(255, 255, 255));
        appAppointDate5.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        appAppointDate5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        appAppointDate5.setText("9999-99-99");
        appAppointDate5.setToolTipText("");
        applicationBody.add(appAppointDate5, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 580, 150, -1));

        appVet5.setBackground(new java.awt.Color(255, 255, 255));
        appVet5.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        appVet5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        appVet5.setText("Rafael Lafuente");
        appVet5.setToolTipText("");
        applicationBody.add(appVet5, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 580, 160, -1));

        appStatus5.setBackground(new java.awt.Color(255, 255, 255));
        appStatus5.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        appStatus5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        appStatus5.setText("Cancelled");
        appStatus5.setToolTipText("");
        applicationBody.add(appStatus5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 580, 100, -1));

        highlight5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/highlight (1).png"))); // NOI18N
        applicationBody.add(highlight5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 560, 880, 70));

        appID4.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        appID4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        appID4.setText("1");
        appID4.setToolTipText("");
        applicationBody.add(appID4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 513, 40, -1));

        appType4.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        appType4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        appType4.setText("Rehome");
        appType4.setToolTipText("");
        applicationBody.add(appType4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 513, 80, -1));

        appPetName4.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        appPetName4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        appPetName4.setText("Clovernistic");
        appPetName4.setToolTipText("");
        applicationBody.add(appPetName4, new org.netbeans.lib.awtextra.AbsoluteConstraints(443, 513, 120, -1));

        appPetType4.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        appPetType4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        appPetType4.setText("Hamster");
        appPetType4.setToolTipText("");
        applicationBody.add(appPetType4, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 513, 110, -1));

        appAppointDate4.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        appAppointDate4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        appAppointDate4.setText("9999-99-99");
        appAppointDate4.setToolTipText("");
        applicationBody.add(appAppointDate4, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 513, 150, -1));

        appVet4.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        appVet4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        appVet4.setText("Rafael Lafuente");
        appVet4.setToolTipText("");
        applicationBody.add(appVet4, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 513, 160, -1));

        appStatus4.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        appStatus4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        appStatus4.setText("Cancelled");
        appStatus4.setToolTipText("");
        applicationBody.add(appStatus4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 513, 100, -1));

        highlight4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/highlight (1).png"))); // NOI18N
        applicationBody.add(highlight4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 490, 880, 70));

        appID3.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        appID3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        appID3.setText("1");
        appID3.setToolTipText("");
        applicationBody.add(appID3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 443, 40, -1));

        appType3.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        appType3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        appType3.setText("Rehome");
        appType3.setToolTipText("");
        applicationBody.add(appType3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 443, 80, -1));

        appPetName3.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        appPetName3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        appPetName3.setText("Clovernistic");
        appPetName3.setToolTipText("");
        applicationBody.add(appPetName3, new org.netbeans.lib.awtextra.AbsoluteConstraints(443, 443, 120, -1));

        appPetType3.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        appPetType3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        appPetType3.setText("Hamster");
        appPetType3.setToolTipText("");
        applicationBody.add(appPetType3, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 443, 110, -1));

        appAppointDate3.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        appAppointDate3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        appAppointDate3.setText("9999-99-99");
        appAppointDate3.setToolTipText("");
        applicationBody.add(appAppointDate3, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 443, 150, -1));

        appVet3.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        appVet3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        appVet3.setText("Rafael Lafuente");
        appVet3.setToolTipText("");
        applicationBody.add(appVet3, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 443, 160, -1));

        appStatus3.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        appStatus3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        appStatus3.setText("Cancelled");
        appStatus3.setToolTipText("");
        applicationBody.add(appStatus3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 443, 100, -1));

        highlight3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/highlight (1).png"))); // NOI18N
        applicationBody.add(highlight3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 420, 880, 70));

        appID2.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        appID2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        appID2.setText("1");
        appID2.setToolTipText("");
        applicationBody.add(appID2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 373, 40, -1));

        appType2.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        appType2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        appType2.setText("Rehome");
        appType2.setToolTipText("");
        applicationBody.add(appType2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 373, 80, -1));

        appPetName2.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        appPetName2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        appPetName2.setText("Clovernistic");
        appPetName2.setToolTipText("");
        applicationBody.add(appPetName2, new org.netbeans.lib.awtextra.AbsoluteConstraints(443, 373, 120, -1));

        appPetType2.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        appPetType2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        appPetType2.setText("Hamster");
        appPetType2.setToolTipText("");
        applicationBody.add(appPetType2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 373, 110, -1));

        appAppointDate2.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        appAppointDate2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        appAppointDate2.setText("9999-99-99");
        appAppointDate2.setToolTipText("");
        applicationBody.add(appAppointDate2, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 373, 150, -1));

        appVet2.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        appVet2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        appVet2.setText("Rafael Lafuente");
        appVet2.setToolTipText("");
        applicationBody.add(appVet2, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 373, 160, -1));

        appStatus2.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        appStatus2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        appStatus2.setText("Cancelled");
        appStatus2.setToolTipText("");
        applicationBody.add(appStatus2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 373, 100, -1));

        appStatus1.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        appStatus1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        appStatus1.setText("Cancelled");
        appStatus1.setToolTipText("");
        applicationBody.add(appStatus1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 303, 100, -1));

        highlight2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/highlight (1).png"))); // NOI18N
        applicationBody.add(highlight2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 350, 880, 70));

        appVet1.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        appVet1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        appVet1.setText("Rafael Lafuente");
        appVet1.setToolTipText("");
        applicationBody.add(appVet1, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 303, 160, -1));

        appAppointDate1.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        appAppointDate1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        appAppointDate1.setText("9999-99-99");
        appAppointDate1.setToolTipText("");
        applicationBody.add(appAppointDate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 303, 150, -1));

        appPetType1.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        appPetType1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        appPetType1.setText("Hamster");
        appPetType1.setToolTipText("");
        applicationBody.add(appPetType1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 303, 110, -1));

        appPetName1.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        appPetName1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        appPetName1.setText("Clovernistic");
        appPetName1.setToolTipText("");
        applicationBody.add(appPetName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(443, 303, 120, -1));

        appType1.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        appType1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        appType1.setText("Rehome");
        appType1.setToolTipText("");
        applicationBody.add(appType1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 303, 80, -1));

        appID1.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        appID1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        appID1.setText("1");
        appID1.setToolTipText("");
        applicationBody.add(appID1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 303, 40, -1));

        highlight1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/highlight (1).png"))); // NOI18N
        applicationBody.add(highlight1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 280, 880, 70));

        editButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/edit button (1).png"))); // NOI18N
        editButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                editButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                editButtonMouseExited(evt);
            }
        });
        applicationBody.add(editButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 100, 90, 90));

        cancelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/cancel button (1).png"))); // NOI18N
        cancelButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cancelButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cancelButtonMouseExited(evt);
            }
        });
        applicationBody.add(cancelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 100, 90, 90));

        confirmButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/confirm button (1).png"))); // NOI18N
        confirmButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                confirmButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                confirmButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                confirmButtonMouseExited(evt);
            }
        });
        applicationBody.add(confirmButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 100, 90, 90));

        deleteButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/delete button (1).png"))); // NOI18N
        deleteButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteButton1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deleteButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deleteButton1MouseExited(evt);
            }
        });
        applicationBody.add(deleteButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1125, 290, 50, 50));

        deleteButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/delete button (1).png"))); // NOI18N
        deleteButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteButton2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deleteButton2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deleteButton2MouseExited(evt);
            }
        });
        applicationBody.add(deleteButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1125, 360, 50, 50));

        deleteButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/delete button (1).png"))); // NOI18N
        deleteButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteButton3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deleteButton3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deleteButton3MouseExited(evt);
            }
        });
        applicationBody.add(deleteButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1125, 430, 50, 50));

        deleteButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/delete button (1).png"))); // NOI18N
        deleteButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteButton4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deleteButton4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deleteButton4MouseExited(evt);
            }
        });
        applicationBody.add(deleteButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1125, 500, 50, 50));

        deleteButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/delete button (1).png"))); // NOI18N
        deleteButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteButton5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deleteButton5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deleteButton5MouseExited(evt);
            }
        });
        applicationBody.add(deleteButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1125, 570, 50, 50));

        applicationPrev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/prev button (1).png"))); // NOI18N
        applicationPrev.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                applicationPrevMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                applicationPrevMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                applicationPrevMouseExited(evt);
            }
        });
        applicationBody.add(applicationPrev, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 625, 350, 120));

        applicationNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/next button (1).png"))); // NOI18N
        applicationNext.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                applicationNextMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                applicationNextMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                applicationNextMouseExited(evt);
            }
        });
        applicationBody.add(applicationNext, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 635, 350, 100));

        adoptButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/adopt button (1).png"))); // NOI18N
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
        applicationBody.add(adoptButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, 250, 70));

        rehomeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/rehome button (1).png"))); // NOI18N
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
        applicationBody.add(rehomeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 20, 250, 70));

        appNoResultsFound.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        appNoResultsFound.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/no result found (1).png"))); // NOI18N
        appNoResultsFound.setToolTipText("");
        applicationBody.add(appNoResultsFound, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 290, 730, 330));

        applicationPanel.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        applicationPanel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/application panel (1).png"))); // NOI18N
        applicationBody.add(applicationPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 1000, 640));

        background5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/paw prints.png"))); // NOI18N
        applicationBody.add(background5, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 0, 1366, 738));

        getContentPane().add(applicationBody, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 139, 1370, 740));

        profileBody.setBackground(new java.awt.Color(255, 251, 209));
        profileBody.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        profileBody.setPreferredSize(new java.awt.Dimension(1370, 740));
        profileBody.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        profilePicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/profile pic (1).jpg"))); // NOI18N
        profileBody.add(profilePicture, new org.netbeans.lib.awtextra.AbsoluteConstraints(253, 55, 240, 230));

        fullNameScroll.setHorizontalScrollBar(null);

        fullName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fullNameenterTabKeyPressed(evt);
            }
        });
        fullNameScroll.setViewportView(fullName);

        profileBody.add(fullNameScroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 373, 280, -1));

        profileName.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        profileName.setForeground(new java.awt.Color(139, 83, 18));
        profileName.setText("Joshua C. Macatunao");
        profileBody.add(profileName, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 373, 280, -1));

        usernameScroll.setHorizontalScrollBar(null);

        username1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                username1enterTabKeyPressed(evt);
            }
        });
        usernameScroll.setViewportView(username1);

        profileBody.add(usernameScroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 540, 220, -1));

        profileUsername.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        profileUsername.setForeground(new java.awt.Color(139, 83, 18));
        profileUsername.setText("icedew07_");
        profileBody.add(profileUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 540, 220, -1));

        contactNumScroll.setHorizontalScrollBar(null);

        contactNum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                contactNumenterTabKeyPressed(evt);
            }
        });
        contactNumScroll.setViewportView(contactNum);

        profileBody.add(contactNumScroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 488, 200, -1));

        profileContactNum.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        profileContactNum.setForeground(new java.awt.Color(139, 83, 18));
        profileContactNum.setText("+639458722802");
        profileBody.add(profileContactNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 488, 200, -1));

        emailAddressScroll.setHorizontalScrollBar(null);

        emailAddress.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                emailAddressenterTabKeyPressed(evt);
            }
        });
        emailAddressScroll.setViewportView(emailAddress);

        profileBody.add(emailAddressScroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 435, 250, -1));

        profileEmailAddress.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        profileEmailAddress.setForeground(new java.awt.Color(139, 83, 18));
        profileEmailAddress.setText("joshua.macatunao007@gmail.com");
        profileBody.add(profileEmailAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 435, 250, -1));

        passwordLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        passwordLabel.setText("Password:");
        profileBody.add(passwordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 570, -1, -1));

        password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordenterTabKeyPressed(evt);
            }
        });
        profileBody.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 590, 220, -1));

        confirmPasswordLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        confirmPasswordLabel.setText("Confirm Password:");
        profileBody.add(confirmPasswordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 620, -1, -1));

        confirmPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmPasswordActionPerformed(evt);
            }
        });
        confirmPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                confirmPasswordenterTabKeyPressed(evt);
            }
        });
        profileBody.add(confirmPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 640, 220, -1));

        profilePassword.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        profilePassword.setForeground(new java.awt.Color(139, 83, 18));
        profilePassword.setText("**********");
        profileBody.add(profilePassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 593, 220, -1));

        currentAddressScroll.setHorizontalScrollBar(null);
        currentAddressScroll.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                currentAddressScrollenterTabKeyPressed(evt);
            }
        });
        currentAddressScroll.setViewportView(currentAddress);

        profileBody.add(currentAddressScroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 382, 270, -1));

        profileAddress.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        profileAddress.setForeground(new java.awt.Color(139, 83, 18));
        profileAddress.setText("Mandaluyong City, Metro Manila");
        profileBody.add(profileAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 382, 270, -1));

        occupationScroll.setHorizontalScrollBar(null);

        occupation.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                occupationenterTabKeyPressed(evt);
            }
        });
        occupationScroll.setViewportView(occupation);

        profileBody.add(occupationScroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 488, 230, -1));

        profileOccupation.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        profileOccupation.setForeground(new java.awt.Color(139, 83, 18));
        profileOccupation.setText("Software Engineer");
        profileBody.add(profileOccupation, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 488, 230, -1));

        companyScroll.setHorizontalScrollBar(null);

        companyName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                companyNameenterTabKeyPressed(evt);
            }
        });
        companyScroll.setViewportView(companyName);

        profileBody.add(companyScroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 540, 250, -1));

        profileCompany.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        profileCompany.setForeground(new java.awt.Color(139, 83, 18));
        profileCompany.setText("Google");
        profileBody.add(profileCompany, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 540, 250, -1));

        workType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                workTypeActionPerformed(evt);
            }
        });
        workType.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                workTypeenterTabKeyPressed(evt);
            }
        });
        profileBody.add(workType, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 593, 230, -1));

        profileWorkType.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        profileWorkType.setForeground(new java.awt.Color(139, 83, 18));
        profileWorkType.setText("No Travel");
        profileBody.add(profileWorkType, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 593, 230, -1));

        birthdayScroll.setHorizontalScrollBar(null);

        birthdate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                birthdateenterTabKeyPressed(evt);
            }
        });
        birthdayScroll.setViewportView(birthdate);

        profileBody.add(birthdayScroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 430, 130, -1));

        profileBody.add(year, new org.netbeans.lib.awtextra.AbsoluteConstraints(455, 430, 70, -1));

        month.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthActionPerformed(evt);
            }
        });
        profileBody.add(month, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 430, 53, -1));

        day.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayActionPerformed(evt);
            }
        });
        profileBody.add(day, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 430, 53, -1));

        profileAge.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        profileAge.setForeground(new java.awt.Color(139, 83, 18));
        profileAge.setText("20");
        profileBody.add(profileAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 432, 320, -1));

        profileDeleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/delete button (2).png"))); // NOI18N
        profileDeleteButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profileDeleteButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                profileDeleteButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                profileDeleteButtonMouseExited(evt);
            }
        });
        profileBody.add(profileDeleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 250, 70, 70));

        profileEditButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/edit button (2).png"))); // NOI18N
        profileEditButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profileEditButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                profileEditButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                profileEditButtonMouseExited(evt);
            }
        });
        profileBody.add(profileEditButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 250, 70, 70));

        profileCancelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/cancel button (2).png"))); // NOI18N
        profileCancelButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profileCancelButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                profileCancelButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                profileCancelButtonMouseExited(evt);
            }
        });
        profileBody.add(profileCancelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 250, 70, 70));

        profileConfirmButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/confirm button (2).png"))); // NOI18N
        profileConfirmButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profileConfirmButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                profileConfirmButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                profileConfirmButtonMouseExited(evt);
            }
        });
        profileBody.add(profileConfirmButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 250, 70, 70));

        logoutButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/logout button (1).png"))); // NOI18N
        logoutButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logoutButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logoutButtonMouseExited(evt);
            }
        });
        profileBody.add(logoutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 245, 250, 80));

        profilePanel.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        profilePanel.setForeground(new java.awt.Color(139, 83, 18));
        profilePanel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/profile panel (1).png"))); // NOI18N
        profileBody.add(profilePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 10, 1080, 720));

        background6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/paw prints.png"))); // NOI18N
        profileBody.add(background6, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 0, 1366, 738));

        getContentPane().add(profileBody, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 139, 1370, 740));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void defaultWindow() {
        // set pet count
        adoptedCounter.setText(String.valueOf(pets.size()));

        // set visiblity
        homeBody.setVisible(true);
        aboutUsBody.setVisible(false);
        FAQsBody.setVisible(false);
        petsBody.setVisible(false);
        vetsBody.setVisible(false);
        applicationBody.setVisible(false);
        profileBody.setVisible(false);

        // click bg
        homeClick.setVisible(true);
        aboutUsClick.setVisible(false);
        faqClick.setVisible(false);
        petClick.setVisible(false);
        vetClick.setVisible(false);
        applicationClick.setVisible(false);

        // set clickability
        homeClicked = true;

        // button icons
        homeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/home click.png")));

        // for FAQs panels' visibility
        FAQsPanel1.setVisible(true);
        FAQsPanel2.setVisible(false);
        FAQsPanel3.setVisible(false);
        FAQsPanel4.setVisible(false);
    }

    private void comboBoxes() {
        // action listener for year and month to dynamically adjust days
        year.addActionListener(new ComboBoxActionListener());
        month.addActionListener(new ComboBoxActionListener());

        // populate the combo boxes
        populateComboBoxes();
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
                day.addItem(dayValue);
            }
        }
    }

    private void samples() {
        Pet petSamples = new Pet();
        this.pets = petSamples.getAllPetSamples();
        totalPets = pets.size();

        Veterinarian vetSamples = new Veterinarian();
        this.vets = vetSamples.getAllVetSamples();
        totalVets = vets.size();

        Application appSamples = new Application();
        if (client != null) {
            this.applications = appSamples.getAllApplicationSamples(client.getClientID());
        } else {
            this.applications = appSamples.getAllApplicationSamples();
        }
        totalApplications = applications.size();
    }

    private void updatePanelVisibility(boolean home, boolean aboutUs, boolean faqs, boolean pets, boolean vets, boolean application, boolean profile) {
        homeBody.setVisible(home);
        aboutUsBody.setVisible(aboutUs);
        FAQsBody.setVisible(faqs);
        petsBody.setVisible(pets);
        vetsBody.setVisible(vets);
        applicationBody.setVisible(application);
        profileBody.setVisible(profile);
    }

    private void updateClickBackgroundVisibility(boolean home, boolean aboutUs, boolean faqs, boolean pets, boolean vets, boolean application) {
        homeClick.setVisible(home);
        aboutUsClick.setVisible(aboutUs);
        faqClick.setVisible(faqs);
        petClick.setVisible(pets);
        vetClick.setVisible(vets);
        applicationClick.setVisible(application);
    }

    private void updateButtonIcons(String homeIcon, String aboutUsIcon, String faqIcon, String petIcon, String vetIcon, String applicationIcon, String profileHeadIcon, String profileCollarIcon) {
        homeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(homeIcon)));
        aboutUsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(aboutUsIcon)));
        faqButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(faqIcon)));
        petButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(petIcon)));
        vetButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(vetIcon)));
        applicationButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(applicationIcon)));
        profileHead.setIcon(new javax.swing.ImageIcon(getClass().getResource(profileHeadIcon)));
        profileCollar.setIcon(new javax.swing.ImageIcon(getClass().getResource(profileCollarIcon)));
    }

    private void updateClickabilityFlags(boolean home, boolean aboutUs, boolean faqs, boolean pets, boolean vets, boolean application, boolean profile) {
        homeClicked = home;
        aboutUsClicked = aboutUs;
        FAQsClicked = faqs;
        petsClicked = pets;
        vetsClicked = vets;
        applicationClicked = application;
        profileClicked = profile;
    }

    private void handleHomeButtonClick() {
        // update count of pets
        adoptedCounter.setText(String.valueOf(pets.size()));

        updatePanelVisibility(true, false, false, false, false, false, false);
        updateClickBackgroundVisibility(true, false, false, false, false, false);
        homeClick.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/click bg.png")));
        line.setBackground(new java.awt.Color(255, 251, 209));
        updateClickabilityFlags(true, false, false, false, false, false, false);
        updateButtonIcons("/Resources/home click.png", "/Resources/about us.png", "/Resources/FAQs.png", "/Resources/pets.png", "/Resources/vets.png", "/Resources/application.png", "/Resources/head.png", "/Resources/collar.png");
        name.setForeground(Color.BLACK);
    }

    private void handleAboutUsButtonClick() {
        updatePanelVisibility(false, true, false, false, false, false, false);
        updateClickBackgroundVisibility(false, true, false, false, false, false);
        aboutUsClick.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/click bg.png")));
        line.setBackground(new java.awt.Color(255, 251, 209));
        updateClickabilityFlags(false, true, false, false, false, false, false);
        updateButtonIcons("/Resources/home.png", "/Resources/about us click.png", "/Resources/FAQs.png", "/Resources/pets.png", "/Resources/vets.png", "/Resources/application.png", "/Resources/head.png", "/Resources/collar.png");
        name.setForeground(Color.BLACK);
    }

    private void handleFaqButtonClick() {
        updatePanelVisibility(false, false, true, false, false, false, false);
        updateClickBackgroundVisibility(false, false, true, false, false, false);
        faqClick.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/click bg.png")));
        line.setBackground(new java.awt.Color(255, 251, 209));
        updateClickabilityFlags(false, false, true, false, false, false, false);
        updateButtonIcons("/Resources/home.png", "/Resources/about us.png", "/Resources/FAQs click.png", "/Resources/pets.png", "/Resources/vets.png", "/Resources/application.png", "/Resources/head.png", "/Resources/collar.png");
        name.setForeground(Color.BLACK);
    }

    private void handlePetButtonClick() {
        petProfilesReset();
        petBackButton.setVisible(false);
        updatePanelVisibility(false, false, false, true, false, false, false);
        petPrev.setVisible(false);
        updateClickBackgroundVisibility(false, false, false, true, false, false);
        petClick.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/click bg.png")));
        line.setBackground(new java.awt.Color(255, 251, 209));
        updateClickabilityFlags(false, false, false, true, false, false, false);
        updateButtonIcons("/Resources/home.png", "/Resources/about us.png", "/Resources/FAQs.png", "/Resources/pets click.png", "/Resources/vets.png", "/Resources/application.png", "/Resources/head.png", "/Resources/collar.png");
        name.setForeground(Color.BLACK);
    }

    private void handleVetButtonClick() {
        vetProfilesReset();
        updatePanelVisibility(false, false, false, false, true, false, false);
        updateClickBackgroundVisibility(false, false, false, false, true, false);
        vetClick.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/click bg.png")));
        line.setBackground(new java.awt.Color(255, 251, 209));
        updateClickabilityFlags(false, false, false, false, true, false, false);
        updateButtonIcons("/Resources/home.png", "/Resources/about us.png", "/Resources/FAQs.png", "/Resources/pets.png", "/Resources/vets click.png", "/Resources/application.png", "/Resources/head.png", "/Resources/collar.png");
        name.setForeground(Color.BLACK);
    }

    private void handleApplicationButtonClick() {
        applicationsReset();
        updatePanelVisibility(false, false, false, false, false, true, false);
        updateClickBackgroundVisibility(false, false, false, false, false, true);
        applicationClick.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/click bg 2.png")));
        line.setBackground(new java.awt.Color(255, 251, 209));
        updateClickabilityFlags(false, false, false, false, false, true, false);
        updateButtonIcons("/Resources/home.png", "/Resources/about us.png", "/Resources/FAQs.png", "/Resources/pets.png", "/Resources/vets.png", "/Resources/application click.png", "/Resources/head.png", "/Resources/collar.png");
        name.setForeground(Color.BLACK);
    }

    private void handleProfileButtonClick() {
        updatePanelVisibility(false, false, false, false, false, false, true);
        updateClickBackgroundVisibility(false, false, false, false, false, false);
        line.setBackground(new java.awt.Color(255, 251, 209));
        updateClickabilityFlags(false, false, false, false, false, false, true);
        updateButtonIcons("/Resources/home.png", "/Resources/about us.png", "/Resources/FAQs.png", "/Resources/pets.png", "/Resources/vets.png", "/Resources/application.png", "/Resources/head click.png", "/Resources/collar click.png");
        name.setForeground(Color.YELLOW);
    }

    private void FAQsChangePanel(String button) {
        if (button.equals("next")) {
            FAQsPanelCounter++;
        } else if (button.equals("prev")) {
            FAQsPanelCounter--;
        }
        int counter = Math.abs(FAQsPanelCounter) % 4;
        setFAQsPanelVisibility(counter);
    }

    private void setFAQsPanelVisibility(int panel) {
        FAQsPanel1.setVisible(panel == 1);
        FAQsPanel2.setVisible(panel == 2);
        FAQsPanel3.setVisible(panel == 3);
        FAQsPanel4.setVisible(panel == 0);
    }

    private void petProfiles() {
        // pet click widgets
        JComponent[] components = {petBackButton, petAdoptButton, petSize, petStatus,
            petOrigin, petType, petID, petPanelClick, petNoResultsFound};

        for (JComponent component : components) {
            component.setVisible(false);
        }

        if (totalPets == 0) {
            petNoResultsFound.setVisible(true);
        } else {
            petNoResultsFound.setVisible(false);
        }

        // Pet Panel 1
        if (totalPets >= 1) {
            petName1.setText(pets.get(petIndex).getPetName());
            petAge1.setText(String.valueOf(pets.get(petIndex).getPetAge()) + " months");
            petGender1.setText(pets.get(petIndex).getPetSex());
            petImg1.setIcon(new javax.swing.ImageIcon(getClass().getResource(pets.get(petIndex).getPicURL())));
            petURL1 = pets.get(petIndex).getPicURL();
            petIndex++;
        }

        // Pet Panel 2
        if (totalPets >= 2) {
            petName2.setText(pets.get(petIndex).getPetName());
            petAge2.setText(String.valueOf(pets.get(petIndex).getPetAge()) + " months");
            petGender2.setText(pets.get(petIndex).getPetSex());
            petImg2.setIcon(new javax.swing.ImageIcon(getClass().getResource(pets.get(petIndex).getPicURL())));
            petURL2 = pets.get(petIndex).getPicURL();
            petIndex++;
        }

        // Pet Panel 3
        if (totalPets >= 3) {
            petName3.setText(pets.get(petIndex).getPetName());
            petAge3.setText(String.valueOf(pets.get(petIndex).getPetAge()) + " months");
            petGender3.setText(pets.get(petIndex).getPetSex());
            petImg3.setIcon(new javax.swing.ImageIcon(getClass().getResource(pets.get(petIndex).getPicURL())));
            petURL3 = pets.get(petIndex).getPicURL();
        }
    }

    private void petProfilesReset() {
        // totalPets = 0;
        // totalPets = 1;
        // totalPets = 2;
        // totalPets = 3;

        // Reset pet index
        petIndex = 0;

        // Arrays of pet panels and associated components
        JLabel[] petPanels = {petPanel1, petPanel2, petPanel3};
        JLabel[] petImages = {petImg1, petImg2, petImg3};
        JLabel[] petNames = {petName1, petName2, petName3};
        JLabel[] petAges = {petAge1, petAge2, petAge3};
        JLabel[] petGenders = {petGender1, petGender2, petGender3};

        // Reset visibility of pet panels and associated components based on totalPets
        for (int i = 0; i < 3; i++) {
            boolean showPanel = i < totalPets;
            petPanels[i].setVisible(showPanel);
            petImages[i].setVisible(showPanel);
            petNames[i].setVisible(showPanel);
            petAges[i].setVisible(showPanel);
            petGenders[i].setVisible(showPanel);

            // Update pet profile information if it's visible
            if (showPanel && petIndex + i < pets.size()) {
                petNames[i].setText(pets.get(petIndex + i).getPetName());
                petAges[i].setText(String.valueOf(pets.get(petIndex + i).getPetAge()) + " months");
                petGenders[i].setText(pets.get(petIndex + i).getPetSex());
                petImages[i].setIcon(new javax.swing.ImageIcon(getClass().getResource(pets.get(petIndex + i).getPicURL())));
            }
        }

        // Show or hide navigation buttons based on totalPets and petIndex
        petPrev.setVisible(petIndex > 0);
        petNext.setVisible(totalPets > 3 && petIndex < totalPets - 3);
    }

    private void vetProfiles() {
        // Vet Panel 1
        if (totalVets >= 1) {
            vetName1.setText(vets.get(vetIndex).getVetFullName());
            vetEmail1.setText(vets.get(vetIndex).getVetEmailAdd());
            vetContact1.setText(vets.get(vetIndex).getVetCellNum());
        }
        vetIndex++;

        // Vet Panel 2
        if (totalVets >= 2) {
            vetName2.setText(vets.get(vetIndex).getVetFullName());
            vetEmail2.setText(vets.get(vetIndex).getVetEmailAdd());
            vetContact2.setText(vets.get(vetIndex).getVetCellNum());
        }
        vetIndex++;

        // Vet Panel 3
        if (totalVets >= 3) {
            vetName3.setText(vets.get(vetIndex).getVetFullName());
            vetEmail3.setText(vets.get(vetIndex).getVetEmailAdd());
            vetContact3.setText(vets.get(vetIndex).getVetCellNum());
        }
        vetIndex++;

        // Vet Panel 4
        if (totalVets >= 4) {
            vetName4.setText(vets.get(vetIndex).getVetFullName());
            vetEmail4.setText(vets.get(vetIndex).getVetEmailAdd());
            vetContact4.setText(vets.get(vetIndex).getVetCellNum());
        }
        vetIndex++;

        // Vet Panel 5
        if (totalVets >= 5) {
            vetName5.setText(vets.get(vetIndex).getVetFullName());
            vetEmail5.setText(vets.get(vetIndex).getVetEmailAdd());
            vetContact5.setText(vets.get(vetIndex).getVetCellNum());
        }
        vetIndex++;

        // Vet Panel 6
        if (totalVets >= 6) {
            vetName6.setText(vets.get(vetIndex).getVetFullName());
            vetEmail6.setText(vets.get(vetIndex).getVetEmailAdd());
            vetContact6.setText(vets.get(vetIndex).getVetCellNum());
        }
        vetIndex++;
    }

    private void vetProfilesReset() {
        // Reset vet index and total vets if not already clicked
        if (!vetsClicked) {
            vetIndex = 0;
            totalVets = vets.size();
        }

        // totalVets = 0;
        // Array of vet name and contact labels
        JLabel[] vetNames = {vetName1, vetName2, vetName3, vetName4, vetName5, vetName6};
        JLabel[] vetEmails = {vetEmail1, vetEmail2, vetEmail3, vetEmail4, vetEmail5, vetEmail6};
        JLabel[] vetContacts = {vetContact1, vetContact2, vetContact3, vetContact4, vetContact5, vetContact6};

        // Iterate through the arrays and set visibility based on totalVets
        for (int i = 0; i < vetNames.length; i++) {
            if (i < totalVets) {
                vetNames[i].setVisible(true);
                vetEmails[i].setVisible(true);
                vetContacts[i].setVisible(true);
            } else {
                vetNames[i].setVisible(false);
                vetEmails[i].setVisible(false);
                vetContacts[i].setVisible(false);
            }
        }

        if (totalVets == 0) {
            vetNoResultsFound.setVisible(true);
        } else {
            vetNoResultsFound.setVisible(false);
        }

        // Show or hide prev button based on vetIndex
        vetPrev.setVisible(vetIndex > 0);

        // Show or hide next button based on totalVets
        vetNext.setVisible(totalVets > 6);
    }

    private void applicationEditVisibility(boolean edit) {
        JLabel[] deleteButtons = {deleteButton1, deleteButton2, deleteButton3, deleteButton4, deleteButton5};
        JLabel[] highlighters = {highlight1, highlight2, highlight3, highlight4, highlight5};

        for (JLabel deleteButton : deleteButtons) {
            deleteButton.setVisible(edit);
        }
        for (JLabel highlighter : highlighters) {
            highlighter.setVisible(false);
        }

        editButton.setVisible(!edit);
        cancelButton.setVisible(edit);
        confirmButton.setVisible(edit);
        if (edit) {
            // Iterate through the arrays and set visibility based on total applcations
            for (int i = 0; i < deleteButtons.length; i++) {
                if (i < totalApplications) {
                    deleteButtons[i].setVisible(true);
                } else {
                    deleteButtons[i].setVisible(false);
                }
            }
            applicationPrev.setVisible(false);
            applicationNext.setVisible(false);
        } else {
            // Array of app infos
            JLabel[] appIDs = {appID1, appID2, appID3, appID4, appID5};
            JLabel[] appTypes = {appType1, appType2, appType3, appType4, appType5};
            JLabel[] appPetNames = {appPetName1, appPetName2, appPetName3, appPetName4, appPetName5};
            JLabel[] appPetTypes = {appPetType1, appPetType2, appPetType3, appPetType4, appPetType5};
            JLabel[] appAppointDates = {appAppointDate1, appAppointDate2, appAppointDate3, appAppointDate4, appAppointDate5};
            JLabel[] appVets = {appVet1, appVet2, appVet3, appVet4, appVet5};
            JLabel[] appStatuses = {appStatus1, appStatus2, appStatus3, appStatus4, appStatus5};

            // Iterate through the arrays and set the foreground based on total applications
            for (int i = 0; i < appIDs.length; i++) {
                if (i < totalApplications) {
                    appIDs[i].setForeground(Color.white);
                    appTypes[i].setForeground(Color.white);
                    appPetNames[i].setForeground(Color.white);
                    appPetTypes[i].setForeground(Color.white);
                    appAppointDates[i].setForeground(Color.white);
                    appVets[i].setForeground(Color.white);
                    appStatuses[i].setForeground(Color.white);
                }
            }
        }
    }

    private void applications() {
        // Application 1
        if (totalApplications >= 1) {
            String status1 = applications.get(appIndex).getAppointStatus();
            switch (status1.charAt(0)) {
                case 'S':
                    status1 = "Success";
                    break;
                case 'C':
                    status1 = "Cancelled";
                    break;
                case 'P':
                    status1 = "Pending";
                    break;
            }

            appID1.setText(String.valueOf(applications.get(appIndex).getApplicationID()));
            appType1.setText(applications.get(appIndex).getApplicationType());
            appPetName1.setText(applications.get(appIndex).getPetName());
            appPetType1.setText(applications.get(appIndex).getPetType());
            appAppointDate1.setText(String.valueOf(applications.get(appIndex).getAppointDate()));
            appVet1.setText(applications.get(appIndex).getVetName());
            appStatus1.setText(status1);
        }
        appIndex++;

        // Application 2
        if (totalApplications >= 2) {
            String status2 = applications.get(appIndex).getAppointStatus();
            switch (status2.charAt(0)) {
                case 'S':
                    status2 = "Success";
                    break;
                case 'C':
                    status2 = "Cancelled";
                    break;
                case 'P':
                    status2 = "Pending";
                    break;
            }

            appID2.setText(String.valueOf(applications.get(appIndex).getApplicationID()));
            appType2.setText(applications.get(appIndex).getApplicationType());
            appPetName2.setText(applications.get(appIndex).getPetName());
            appPetType2.setText(applications.get(appIndex).getPetType());
            appAppointDate2.setText(String.valueOf(applications.get(appIndex).getAppointDate()));
            appVet2.setText(applications.get(appIndex).getVetName());
            appStatus2.setText(status2);
        }
        appIndex++;

        // Application 3
        if (totalApplications >= 3) {
            String status3 = applications.get(appIndex).getAppointStatus();
            switch (status3.charAt(0)) {
                case 'S':
                    status3 = "Success";
                    break;
                case 'C':
                    status3 = "Cancelled";
                    break;
                case 'P':
                    status3 = "Pending";
                    break;
            }

            appID3.setText(String.valueOf(applications.get(appIndex).getApplicationID()));
            appType3.setText(applications.get(appIndex).getApplicationType());
            appPetName3.setText(applications.get(appIndex).getPetName());
            appPetType3.setText(applications.get(appIndex).getPetType());
            appAppointDate3.setText(String.valueOf(applications.get(appIndex).getAppointDate()));
            appVet3.setText(applications.get(appIndex).getVetName());
            appStatus3.setText(status3);
        }
        appIndex++;

        // Application 4
        if (totalApplications >= 4) {
            String status4 = applications.get(appIndex).getAppointStatus();
            switch (status4.charAt(0)) {
                case 'S':
                    status4 = "Success";
                    break;
                case 'C':
                    status4 = "Cancelled";
                    break;
                case 'P':
                    status4 = "Pending";
                    break;
            }

            appID4.setText(String.valueOf(applications.get(appIndex).getApplicationID()));
            appType4.setText(applications.get(appIndex).getApplicationType());
            appPetName4.setText(applications.get(appIndex).getPetName());
            appPetType4.setText(applications.get(appIndex).getPetType());
            appAppointDate4.setText(String.valueOf(applications.get(appIndex).getAppointDate()));
            appVet4.setText(applications.get(appIndex).getVetName());
            appStatus4.setText(status4);
        }
        appIndex++;

        // Application 5
        if (totalApplications >= 5) {
            String status5 = applications.get(appIndex).getAppointStatus();
            switch (status5.charAt(0)) {
                case 'S':
                    status5 = "Success";
                    break;
                case 'C':
                    status5 = "Cancelled";
                    break;
                case 'P':
                    status5 = "Pending";
                    break;
            }

            appID5.setText(String.valueOf(applications.get(appIndex).getApplicationID()));
            appType5.setText(applications.get(appIndex).getApplicationType());
            appPetName5.setText(applications.get(appIndex).getPetName());
            appPetType5.setText(applications.get(appIndex).getPetType());
            appAppointDate5.setText(String.valueOf(applications.get(appIndex).getAppointDate()));
            appVet5.setText(applications.get(appIndex).getVetName());
            appStatus5.setText(status5);
        }
        appIndex++;

    }

    private void applicationsReset() {
        // Reset app index and total applications if not already clicked
        if (!applicationClicked) {
            appIndex = 0;
            totalApplications = applications.size();
        }

        // totalApplications = 3;
        // Array of app infos
        JLabel[] appIDs = {appID1, appID2, appID3, appID4, appID5};
        JLabel[] appTypes = {appType1, appType2, appType3, appType4, appType5};
        JLabel[] appPetNames = {appPetName1, appPetName2, appPetName3, appPetName4, appPetName5};
        JLabel[] appPetTypes = {appPetType1, appPetType2, appPetType3, appPetType4, appPetType5};
        JLabel[] appAppointDates = {appAppointDate1, appAppointDate2, appAppointDate3, appAppointDate4, appAppointDate5};
        JLabel[] appVets = {appVet1, appVet2, appVet3, appVet4, appVet5};
        JLabel[] appStatuses = {appStatus1, appStatus2, appStatus3, appStatus4, appStatus5};

        // Iterate through the arrays and set visibility and foreground based on totalApplications
        for (int i = 0; i < appIDs.length; i++) {
            if (i < totalApplications) {
                appIDs[i].setVisible(true);
                appTypes[i].setVisible(true);
                appPetNames[i].setVisible(true);
                appPetTypes[i].setVisible(true);
                appAppointDates[i].setVisible(true);
                appVets[i].setVisible(true);
                appStatuses[i].setVisible(true);

                appIDs[i].setForeground(Color.white);
                appTypes[i].setForeground(Color.white);
                appPetNames[i].setForeground(Color.white);
                appPetTypes[i].setForeground(Color.white);
                appAppointDates[i].setForeground(Color.white);
                appVets[i].setForeground(Color.white);
                appStatuses[i].setForeground(Color.white);
            } else {
                appIDs[i].setVisible(false);
                appTypes[i].setVisible(false);
                appPetNames[i].setVisible(false);
                appPetTypes[i].setVisible(false);
                appAppointDates[i].setVisible(false);
                appVets[i].setVisible(false);
                appStatuses[i].setVisible(false);
            }
        }

        if (totalApplications == 0) {
            appNoResultsFound.setVisible(true);
            editButton.setVisible(false);
        } else {
            appNoResultsFound.setVisible(false);
            editButton.setVisible(true);
        }

        // Show or hide prev button based on appIndex
        applicationPrev.setVisible(appIndex > 0);

        // Show or hide next button based on totalApplications
        applicationNext.setVisible(totalApplications > 6);
    }

    private void profileEditVisibility(boolean edit) {
        // buttons
        profileEditButton.setVisible(!edit);
        profileDeleteButton.setVisible(!edit);
        profileCancelButton.setVisible(edit);
        profileConfirmButton.setVisible(edit);

        // labels
        profileName.setVisible(!edit);
        profileUsername.setVisible(!edit);
        profileContactNum.setVisible(!edit);
        profileEmailAddress.setVisible(!edit);
        profilePassword.setVisible(!edit);
        profileAddress.setVisible(!edit);
        profileOccupation.setVisible(!edit);
        profileCompany.setVisible(!edit);
        profileWorkType.setVisible(!edit);
        profileAge.setVisible(!edit);

        // password labels
        passwordLabel.setVisible(edit);
        confirmPasswordLabel.setVisible(edit);

        // text fields
        fullName.setVisible(edit);
        username1.setVisible(edit);
        contactNum.setVisible(edit);
        emailAddress.setVisible(edit);
        currentAddress.setVisible(edit);
        occupation.setVisible(edit);
        companyName.setVisible(edit);
        birthdate.setVisible(edit);

        // combo boxes
        day.setVisible(edit);
        month.setVisible(edit);
        year.setVisible(edit);
        workType.setVisible(edit);

        // password fields
        password.setVisible(edit);
        confirmPassword.setVisible(edit);

        // scrolls
        fullNameScroll.setVisible(edit);
        usernameScroll.setVisible(edit);
        contactNumScroll.setVisible(edit);
        emailAddressScroll.setVisible(edit);
        currentAddressScroll.setVisible(edit);
        occupationScroll.setVisible(edit);
        companyScroll.setVisible(edit);
        birthdayScroll.setVisible(edit);
    }

    private void hidePetPanels(boolean hide) {
        JComponent[] components = {petBackButton, petAdoptButton, petSize,
            petStatus, petOrigin, petType, petID, petPanelClick};

        for (JComponent component : components) {
            component.setVisible(!hide);
        }

        // Arrays for pet panels and associated components
        JLabel[] petPanels = {petPanel2, petPanel3};
        JLabel[][] petComponents = {
            {petImg2, petName2, petAge2, petGender2},
            {petImg3, petName3, petAge3, petGender3}
        };

        // Hide or show pet panels and their components
        for (int i = 0; i < petPanels.length; i++) {
            petPanels[i].setVisible(hide);
            for (JLabel component : petComponents[i]) {
                component.setVisible(hide);
            }
        }

        // Hide navigation buttons if necessary
        if (petPrev.isVisible()) {
            petPrev.setVisible(hide);
        } else if (petIndex > 2) {
            petPrev.setVisible(hide);
        }

        if (petNext.isVisible()) {
            petNext.setVisible(hide);
        } else if (petIndex < totalPets - 1) {
            petNext.setVisible(hide);
        }
    }

    private void setCurrentPetPanel(int panel) {
        if (!petPanel1Clicked) {
            // Store initial pet panel 1 information
            tempPetURL = petURL1;
            tempPetName = petName1.getText();
            tempPetAge = petAge1.getText();
            tempPetGender = petGender1.getText();
            petPanel1Clicked = true;

            System.out.println(tempPetName); // Optional: Print stored pet name
        }

        String pOrigin = "", pStatus = "", pSize = "";

        String origin = "";
        String status = "";
        String size = "";
        // Update pet panel 1 based on selected panel
        switch (panel) {
            case 1:
                origin = pets.get(petIndex - 2).getPetOrigin();
                status = pets.get(petIndex - 2).getPetStatus();
                size = pets.get(petIndex - 2).getPetSize();

                switch (origin.charAt(0)) {
                    case 'O':
                        pOrigin = "Owned";
                        break;
                    case 'R':
                        pOrigin = "Rehome";
                        break;
                }

                if (status.equals("NA")) {
                    pStatus = "Not Adopted";
                } else if (status.equals("A")) {
                    pStatus = "Adopted";
                }

                switch (size.charAt(0)) {
                    case 'T':
                        pSize = "Tiny";
                        break;
                    case 'S':
                        pSize = "Small";
                        break;
                    case 'M':
                        pSize = "Medium";
                        break;
                    case 'L':
                        pSize = "Large";
                        break;
                }

                petID.setText(String.valueOf(pets.get(petIndex - 2).getPetID()));
                petType.setText(String.valueOf(pets.get(petIndex - 2).getPetType()));
                petOrigin.setText(pOrigin);
                petStatus.setText(pStatus);
                petSize.setText(pSize);
                break;
            case 2:
                // Display pet panel 2 information on panel 1     
                origin = pets.get(petIndex - 2).getPetOrigin();
                status = pets.get(petIndex - 2).getPetStatus();
                size = pets.get(petIndex - 2).getPetSize();

                switch (origin.charAt(0)) {
                    case 'O':
                        pOrigin = "Owned";
                        break;
                    case 'R':
                        pOrigin = "Rehome";
                        break;
                }

                if (status.equals("NA")) {
                    pStatus = "Not Adopted";
                } else if (status.equals("A")) {
                    pStatus = "Adopted";
                }

                switch (size.charAt(0)) {
                    case 'T':
                        pSize = "Tiny";
                        break;
                    case 'S':
                        pSize = "Small";
                        break;
                    case 'M':
                        pSize = "Medium";
                        break;
                    case 'L':
                        pSize = "Large";
                        break;
                }

                petName1.setText(petName2.getText());
                petAge1.setText(petAge2.getText());
                petGender1.setText(petGender2.getText());
                petImg1.setIcon(new javax.swing.ImageIcon(getClass().getResource(petURL2)));
                petID.setText(String.valueOf(pets.get(petIndex - 1).getPetID()));
                petType.setText(String.valueOf(pets.get(petIndex - 1).getPetType()));
                petOrigin.setText(pOrigin);
                petStatus.setText(pStatus);
                petSize.setText(pSize);
                break;
            case 3:
                // Display pet panel 3 information on panel 1
                origin = pets.get(petIndex - 2).getPetOrigin();
                status = pets.get(petIndex - 2).getPetStatus();
                size = pets.get(petIndex - 2).getPetSize();

                switch (origin.charAt(0)) {
                    case 'O':
                        pOrigin = "Owned";
                        break;
                    case 'R':
                        pOrigin = "Rehome";
                        break;
                }

                if (status.equals("NA")) {
                    pStatus = "Not Adopted";
                } else if (status.equals("A")) {
                    pStatus = "Adopted";
                }

                switch (size.charAt(0)) {
                    case 'T':
                        pSize = "Tiny";
                        break;
                    case 'S':
                        pSize = "Small";
                        break;
                    case 'M':
                        pSize = "Medium";
                        break;
                    case 'L':
                        pSize = "Large";
                        break;
                }

                petName1.setText(petName3.getText());
                petAge1.setText(petAge3.getText());
                petGender1.setText(petGender3.getText());
                petImg1.setIcon(new javax.swing.ImageIcon(getClass().getResource(petURL3)));
                petID.setText(String.valueOf(pets.get(petIndex).getPetID()));
                petType.setText(String.valueOf(pets.get(petIndex).getPetType()));
                petOrigin.setText(pOrigin);
                petStatus.setText(pStatus);
                petSize.setText(pSize);
                break;
            default:
                // Fallback to initial stored pet information
                petName1.setText(tempPetName);
                petAge1.setText(tempPetAge);
                petGender1.setText(tempPetGender);
                petImg1.setIcon(new javax.swing.ImageIcon(getClass().getResource(tempPetURL)));
        }
    }

    public CountDownLatch countDownLatch() {
        // Create a CountDownLatch
        CountDownLatch latch = new CountDownLatch(1);

        // Show the custom frame on the EDT
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                if (confirmationDialog == null || !confirmationDialog.isVisible()) {
                    confirmationDialog = new ConfirmationDialog(UserLoggedIn.this, latch);
                    confirmationController = new ConfirmationDialogController(confirmationDialog, UserLoggedIn.this, latch);
                    confirmationDialog.setVisible(true);
                    glassPane.setVisible(true);
                } else {
                    confirmationDialog.toFront();
                    confirmationDialog.requestFocus();
                }
            }
        });
        return latch;
    }

    private void petFilterBySortBy() {
        // QUERY HERE:
        /*
        String wherePetType = "WHERE petType IN (";
        String wherePetOrigin = "WHERE petOrigin IN (";
        String wherePetStatus = "WHERE petStatus IN (";
        String wherePetSize = "WHERE petSize IN (";
        String wherePetGender = "WHERE petGender IN (";

        String text;
        if (selectedPetTypes.size() == 1) {
            wherePetType = "WHERE petType = '" + selectedPetTypes.get(0).getText() + "'";
        } else {
            for (int i = 0; i < selectedPetTypes.size(); i++) {
                text = selectedPetTypes.get(i).getText();
                if (i == selectedPetTypes.size() - 1) {
                    wherePetType += text + ")";
                } else {
                    wherePetType += text + ", ";
                }
            }
        }

        if(!selectedPetTypes.isEmpty()) {
            System.out.println(wherePetType);
        } else  {
            System.out.println("tinulugan ako ni raf");
        }
        */
        String wherePetType = "";
        String wherePetOrigin = "";
        String wherePetStatus = "";
        String wherePetSize = "";
        String wherePetGender = "";
        
        
        // for pet types
        JCheckBox[] petTypes = {dogType, catType, hamsterType, rabbitType};
        ArrayList<JCheckBox> selectedPetTypes = new ArrayList<>();
        
        for (JCheckBox petType : petTypes) {
            if (petType.isSelected()) {
                selectedPetTypes.add(petType);
            }
        }
        
        String typeCondition;
        if (selectedPetTypes.size() == 1) {
            wherePetType = "'" + selectedPetTypes.get(0).getText() + "'";
        } else {
            for (int i = 0; i < selectedPetTypes.size(); i++) {
                typeCondition = selectedPetTypes.get(i).getText();
                if (i == selectedPetTypes.size() - 1) {
                    wherePetType += typeCondition + ")";
                } else {
                    wherePetType += typeCondition + ", ";
                }
            }
        }
        
        // for pet origin
        JCheckBox[] petOrigins = {ownedOrigin, rescuedOrigin};
        ArrayList<JCheckBox> selectedPetOrigins = new ArrayList<>();
        
        for (JCheckBox petOrigin : petOrigins) {
            if (petOrigin.isSelected()) {
                selectedPetOrigins.add(petOrigin);
            }
        }
        
        String originCondition;
        if (selectedPetOrigins.size() == 1) {
            wherePetOrigin = "'" + selectedPetOrigins.get(0).getText() + "'";
        } else {
            for (int i = 0; i < selectedPetOrigins.size(); i++) {
                originCondition = selectedPetOrigins.get(i).getText();
                if (i == selectedPetOrigins.size() - 1) {
                    wherePetOrigin += originCondition + ")";
                } else {
                    wherePetOrigin += originCondition + ", ";
                }
            }
        }
        
        // for pet status
        JCheckBox[] petStatuses = {adoptedStatus, notAdoptedStatus};
        ArrayList<JCheckBox> selectedPetStatuses = new ArrayList<>();
        
        for (JCheckBox petStatus : petStatuses) {
            if (petStatus.isSelected()) {
                selectedPetStatuses.add(petStatus);
            }
        }
        
        String statusCondition;
        if (selectedPetStatuses.size() == 1) {
            wherePetStatus = "'" + selectedPetStatuses.get(0).getText() + "'";
        } else {
            for (int i = 0; i < selectedPetStatuses.size(); i++) {
                statusCondition = selectedPetStatuses.get(i).getText();
                if (i == selectedPetStatuses.size() - 1) {
                    wherePetStatus += statusCondition + ")";
                } else {
                    wherePetStatus += statusCondition + ", ";
                }
            }
        }
        
        // for pet size
        JCheckBox[] petSizes = {tinySize, smallSize, mediumSize, largeSize};
        ArrayList<JCheckBox> selectedPetSizes = new ArrayList<>();
        
        for (JCheckBox petSize : petSizes) {
            if (petSize.isSelected()) {
                selectedPetSizes.add(petSize);
            }
        }
        
        String sizeCondition;
        if (selectedPetSizes.size() == 1) {
            wherePetSize = "'" + selectedPetSizes.get(0).getText() + "'";
        } else {
            for (int i = 0; i < selectedPetSizes.size(); i++) {
                sizeCondition = selectedPetSizes.get(i).getText();
                if (i == selectedPetSizes.size() - 1) {
                    wherePetSize += sizeCondition + ")";
                } else {
                    wherePetSize += sizeCondition + ", ";
                }
            }
        }
        
        // for pet gender
        JCheckBox[] petGenders = {maleGender, femaleGender};
        ArrayList<JCheckBox> selectedPetGenders = new ArrayList<>();
        
        for (JCheckBox petGender : petGenders) {
            if (petGender.isSelected()) {
                selectedPetGenders.add(petGender);
            }
        }
        
        String genderCondition;
        if (selectedPetGenders.size() == 1) {
            wherePetGender = "'" + selectedPetGenders.get(0).getText() + "'";
        } else {
            for (int i = 0; i < selectedPetGenders.size(); i++) {
                genderCondition = selectedPetGenders.get(i).getText();
                if (i == selectedPetGenders.size() - 1) {
                    wherePetGender += genderCondition + ")";
                } else {
                    wherePetGender += genderCondition + ", ";
                }
            }
        }
        
        
        // sorting
        
    }

    private void badgeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_badgeKeyPressed
        // TODO add your handling code here:
        // This will show the records of the adopted pets
    }//GEN-LAST:event_badgeKeyPressed

    private void badgeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_badgeMouseExited
        // TODO add your handling code here:
        badge.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/badge2.png")));
        adoptedCounter.setForeground(java.awt.Color.black);
        adoptedLabel.setForeground(java.awt.Color.black);
    }//GEN-LAST:event_badgeMouseExited

    private void badgeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_badgeMouseEntered
        // TODO add your handling code here:
        badge.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/badge2 hover.png")));
        adoptedCounter.setForeground(java.awt.Color.yellow);
        adoptedLabel.setForeground(java.awt.Color.yellow);
    }//GEN-LAST:event_badgeMouseEntered

    private void faqButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_faqButtonMouseExited
        // TODO add your handling code here:
        if (!FAQsClicked) {
            faqClick.setVisible(false);
            faqButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/FAQs.png")));
            line.setBackground(new java.awt.Color(255, 251, 209));
        }
    }//GEN-LAST:event_faqButtonMouseExited

    private void faqButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_faqButtonMouseEntered
        // TODO add your handling code here:
        if (!FAQsClicked) {
            faqClick.setVisible(true);
            faqButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/FAQs hover.png")));
            line.setBackground(new java.awt.Color(226, 204, 163));
            faqClick.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/click bg dark.png")));
        }
    }//GEN-LAST:event_faqButtonMouseEntered

    private void aboutUsButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutUsButtonMouseExited
        // TODO add your handling code here:
        if (!aboutUsClicked) {
            aboutUsClick.setVisible(false);
            aboutUsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/about us.png")));
            line.setBackground(new java.awt.Color(255, 251, 209));
        }
    }//GEN-LAST:event_aboutUsButtonMouseExited

    private void aboutUsButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutUsButtonMouseEntered
        // TODO add your handling code here:
        if (!aboutUsClicked) {
            aboutUsClick.setVisible(true);
            aboutUsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/about us hover.png")));
            line.setBackground(new java.awt.Color(226, 204, 163));
            aboutUsClick.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/click bg dark.png")));
        }
    }//GEN-LAST:event_aboutUsButtonMouseEntered

    private void petButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_petButtonMouseExited
        // TODO add your handling code here:
        if (!petsClicked) {
            petClick.setVisible(false);
            petButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/pets.png")));
            line.setBackground(new java.awt.Color(255, 251, 209));
        }
    }//GEN-LAST:event_petButtonMouseExited

    private void petButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_petButtonMouseEntered
        // TODO add your handling code here:
        if (!petsClicked) {
            petClick.setVisible(true);
            petButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/pets hover.png")));
            line.setBackground(new java.awt.Color(226, 204, 163));
            petClick.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/click bg dark.png")));
        }
    }//GEN-LAST:event_petButtonMouseEntered

    private void vetButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vetButtonMouseExited
        // TODO add your handling code here:
        if (!vetsClicked) {
            vetClick.setVisible(false);
            vetButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/vets.png")));
            line.setBackground(new java.awt.Color(255, 251, 209));
        }
    }//GEN-LAST:event_vetButtonMouseExited

    private void vetButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vetButtonMouseEntered
        // TODO add your handling code here:
        if (!vetsClicked) {
            vetClick.setVisible(true);
            vetButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/vets hover.png")));
            line.setBackground(new java.awt.Color(226, 204, 163));
            vetClick.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/click bg dark.png")));
        }
    }//GEN-LAST:event_vetButtonMouseEntered

    private void applicationButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_applicationButtonMouseExited
        // TODO add your handling code here:
        if (!applicationClicked) {
            applicationClick.setVisible(false);
            applicationButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/application.png")));
            line.setBackground(new java.awt.Color(255, 251, 209));
        }
    }//GEN-LAST:event_applicationButtonMouseExited

    private void applicationButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_applicationButtonMouseEntered
        if (!applicationClicked) {
            applicationClick.setVisible(true);
            applicationButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/application hover.png")));
            line.setBackground(new java.awt.Color(226, 204, 163));
            applicationClick.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/click bg dark 2.png")));
        }
    }//GEN-LAST:event_applicationButtonMouseEntered

    private void homeButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeButtonMouseEntered
        // TODO add your handling code here:
        if (!homeClicked) {
            homeClick.setVisible(true);
            homeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/home hover.png")));
            line.setBackground(new java.awt.Color(226, 204, 163));
            homeClick.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/click bg dark.png")));
        }
    }//GEN-LAST:event_homeButtonMouseEntered

    private void homeButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeButtonMouseExited
        // TODO add your handling code here:
        if (!homeClicked) {
            homeClick.setVisible(false);
            homeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/home.png")));
            line.setBackground(new java.awt.Color(255, 251, 209));
        }
    }//GEN-LAST:event_homeButtonMouseExited

    private void profileCollarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileCollarMouseEntered
        // TODO add your handling code here:
        if (!profileClicked) {
            profileCollar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/collar hover.png")));
            profileHead.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/head hover.png")));
            name.setForeground(Color.YELLOW);
        }
    }//GEN-LAST:event_profileCollarMouseEntered

    private void profileCollarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileCollarMouseExited
        // TODO add your handling code here:
        if (!profileClicked) {
            profileCollar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/collar.png")));
            profileHead.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/head.png")));
            name.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_profileCollarMouseExited

    private void profileHeadMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileHeadMouseEntered
        // TODO add your handling code here:
        if (!profileClicked) {
            profileCollar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/collar hover.png")));
            profileHead.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/head hover.png")));
            name.setForeground(Color.YELLOW);
        }
    }//GEN-LAST:event_profileHeadMouseEntered

    private void profileHeadMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileHeadMouseExited
        // TODO add your handling code here:
        if (!profileClicked) {
            profileCollar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/collar.png")));
            profileHead.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/head.png")));
            name.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_profileHeadMouseExited

    private void aboutUsButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutUsButtonMousePressed
        // TODO add your handling code here:
        if (!aboutUsClicked) {
            handleAboutUsButtonClick();
        }
    }//GEN-LAST:event_aboutUsButtonMousePressed

    private void homeButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeButtonMousePressed
        // TODO add your handling code here:
        if (!homeClicked) {
            handleHomeButtonClick();
        }
    }//GEN-LAST:event_homeButtonMousePressed

    private void faqButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_faqButtonMousePressed
        // TODO add your handling code here:
        if (!FAQsClicked) {
            handleFaqButtonClick();
        }
    }//GEN-LAST:event_faqButtonMousePressed

    private void petButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_petButtonMousePressed
        // TODO add your handling code here:
        if (!petsClicked) {
            handlePetButtonClick();
            petProfiles();
        }
    }//GEN-LAST:event_petButtonMousePressed

    private void vetButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vetButtonMousePressed
        // TODO add your handling code here:
        if (!vetsClicked) {
            handleVetButtonClick();
            vetProfiles();
        }
    }//GEN-LAST:event_vetButtonMousePressed

    private void applicationButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_applicationButtonMousePressed
        // TODO add your handling code here:
        if (!applicationClicked) {
            handleApplicationButtonClick();
            applications();
            applicationEditVisibility(false);
        }
    }//GEN-LAST:event_applicationButtonMousePressed

    private void logoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoMousePressed
        // TODO add your handling code here:
        if (!homeClicked) {
            handleHomeButtonClick();
        }
    }//GEN-LAST:event_logoMousePressed

    private void businessRulesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_businessRulesMouseEntered
        // TODO add your handling code here:
        businessRules.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/about us business rule hover.png")));
    }//GEN-LAST:event_businessRulesMouseEntered

    private void businessRulesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_businessRulesMouseExited
        // TODO add your handling code here:
        businessRules.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/about us business rule (1).png")));
    }//GEN-LAST:event_businessRulesMouseExited

    private void devsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_devsMouseEntered
        // TODO add your handling code here:
        devs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/about us dev hover.png")));
    }//GEN-LAST:event_devsMouseEntered

    private void devsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_devsMouseExited
        // TODO add your handling code here:
        devs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/about us dev (1).png")));
    }//GEN-LAST:event_devsMouseExited

    private void prevMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prevMouseEntered
        // TODO add your handling code here:
        prev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/prev button hover (1).png")));
    }//GEN-LAST:event_prevMouseEntered

    private void prevMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prevMouseExited
        // TODO add your handling code here:
        prev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/prev button (1).png")));
    }//GEN-LAST:event_prevMouseExited

    private void nextMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextMouseEntered
        // TODO add your handling code here:
        next.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/next button hover (1).png")));
    }//GEN-LAST:event_nextMouseEntered

    private void nextMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextMouseExited
        // TODO add your handling code here:
        next.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/next button (1).png")));
    }//GEN-LAST:event_nextMouseExited

    private void petPrevMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_petPrevMouseExited
        // TODO add your handling code here:
        petPrev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/prev button (1).png")));
    }//GEN-LAST:event_petPrevMouseExited

    private void petPrevMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_petPrevMouseEntered
        // TODO add your handling code here:
        petPrev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/prev button hover (1).png")));
    }//GEN-LAST:event_petPrevMouseEntered

    private void petNextMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_petNextMouseEntered
        // TODO add your handling code here:
        petNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/next button hover (1).png")));
    }//GEN-LAST:event_petNextMouseEntered

    private void petNextMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_petNextMouseExited
        // TODO add your handling code here:
        petNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/next button (1).png")));
    }//GEN-LAST:event_petNextMouseExited

    private void nextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextMouseClicked
        // TODO add your handling code here:
        FAQsChangePanel("next");
        handleFaqButtonClick();
    }//GEN-LAST:event_nextMouseClicked

    private void prevMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prevMouseClicked
        // TODO add your handling code here:
        FAQsChangePanel("prev");
        handleFaqButtonClick();
    }//GEN-LAST:event_prevMouseClicked

    private void exitButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitButtonMouseEntered
        // TODO add your handling code here:
        exitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/exit button hover (1).png")));
    }//GEN-LAST:event_exitButtonMouseEntered

    private void exitButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitButtonMouseExited
        // TODO add your handling code here:
        exitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/exit button (1).png")));
    }//GEN-LAST:event_exitButtonMouseExited

    private void exitButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitButtonMouseClicked
        // TODO add your handling code here:
        if (exitDialog == null || !exitDialog.isVisible()) {
            exitDialog = new ExitDialog(null, this, null);
            exitController = new ExitDialogController(exitDialog, null, this, null);
            exitDialog.setVisible(true);
            glassPane.setVisible(true);
        } else {
            exitDialog.toFront();
            exitDialog.requestFocus();
        }
    }//GEN-LAST:event_exitButtonMouseClicked

    private void adoptButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adoptButtonMouseEntered
        // TODO add your handling code here:
        adoptButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/adopt button hover (1).png")));
    }//GEN-LAST:event_adoptButtonMouseEntered

    private void adoptButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adoptButtonMouseExited
        // TODO add your handling code here:
        adoptButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/adopt button (1).png")));
    }//GEN-LAST:event_adoptButtonMouseExited

    private void rehomeButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rehomeButtonMouseEntered
        // TODO add your handling code here:
        rehomeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/rehome button hover (1).png")));
    }//GEN-LAST:event_rehomeButtonMouseEntered

    private void rehomeButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rehomeButtonMouseExited
        // TODO add your handling code here:
        rehomeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/rehome button (1).png")));
    }//GEN-LAST:event_rehomeButtonMouseExited

    private void editButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editButtonMouseEntered
        // TODO add your handling code here:
        editButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/edit button hover (1).png")));
    }//GEN-LAST:event_editButtonMouseEntered

    private void editButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editButtonMouseExited
        // TODO add your handling code here:
        editButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/edit button (1).png")));
    }//GEN-LAST:event_editButtonMouseExited

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

    private void devsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_devsMouseClicked
        // TODO add your handling code here:
        if (devsFrame == null || !devsFrame.isVisible()) {
            devsFrame = new Devs(this);
            devsFrame.setVisible(true);
            glassPane.setVisible(true);
        } else {
            devsFrame.toFront();
            devsFrame.requestFocus();
        }
    }//GEN-LAST:event_devsMouseClicked

    private void businessRulesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_businessRulesMouseClicked
        // TODO add your handling code here:
        if (businessRulesFrame == null || !businessRulesFrame.isVisible()) {
            businessRulesFrame = new BusinessRules(this);
            businessRulesFrame.setVisible(true);
            glassPane.setVisible(true);
        } else {
            businessRulesFrame.toFront();
            businessRulesFrame.requestFocus();
        }
    }//GEN-LAST:event_businessRulesMouseClicked

    private void petPrevMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_petPrevMouseClicked
        // TODO add your handling code here:
        if (petIndex == 3) {
            petNext.setVisible(true);
            petPrev.setVisible(false);
        }

        if (petIndex > 2) {
            petNext.setVisible(true);
            petIndex -= 3;
            petProfiles();
        }
    }//GEN-LAST:event_petPrevMouseClicked

    private void petNextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_petNextMouseClicked
        // TODO add your handling code here:
        if (petIndex < totalPets) {
            petIndex -= 1;
            petProfiles();
        }

        if (petIndex == totalPets - 1) {
            petNext.setVisible(false);
        }

        if (petIndex == 3) {
            petPrev.setVisible(true);
        }
    }//GEN-LAST:event_petNextMouseClicked

    private void profileHeadMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileHeadMousePressed
        // TODO add your handling code here:
        if (!profileClicked) {
            handleProfileButtonClick();
            profileEditVisibility(false);
        }
    }//GEN-LAST:event_profileHeadMousePressed

    private void profileCollarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileCollarMousePressed
        // TODO add your handling code here:
        if (!profileClicked) {
            handleProfileButtonClick();
            profileEditVisibility(false);
        }
    }//GEN-LAST:event_profileCollarMousePressed

    private void badgeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_badgeMousePressed
        // TODO add your handling code here:
        if (!petsClicked) {
            handlePetButtonClick();
            petProfiles();
        }
    }//GEN-LAST:event_badgeMousePressed

    private void vetPrevMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vetPrevMouseClicked
        // TODO add your handling code here:
        if (vetIndex > 5) {
            vetIndex -= 12;
            totalVets += 6;
            vetProfilesReset();
            vetProfiles();
        }

        if (vetIndex == 6) {
            vetNext.setVisible(true);
            vetPrev.setVisible(false);
        }
    }//GEN-LAST:event_vetPrevMouseClicked

    private void vetPrevMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vetPrevMouseEntered
        // TODO add your handling code here:
        vetPrev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/prev button hover (1).png")));
    }//GEN-LAST:event_vetPrevMouseEntered

    private void vetPrevMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vetPrevMouseExited
        // TODO add your handling code here:
        vetPrev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/prev button (1).png")));
    }//GEN-LAST:event_vetPrevMouseExited

    private void vetNextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vetNextMouseClicked
        // TODO add your handling code here:
        if (vetIndex == 6) {
            vetPrev.setVisible(true);
        }

        if (vetIndex < totalVets) {
            totalVets -= 6;
            vetProfilesReset();
            vetProfiles();
        }

        if (vetIndex == totalVets - 1) {
            vetNext.setVisible(false);
        }
    }//GEN-LAST:event_vetNextMouseClicked

    private void vetNextMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vetNextMouseEntered
        // TODO add your handling code here:
        vetNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/next button hover (1).png")));
    }//GEN-LAST:event_vetNextMouseEntered

    private void vetNextMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vetNextMouseExited
        // TODO add your handling code here:
        vetNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/next button (1).png")));
    }//GEN-LAST:event_vetNextMouseExited

    private void applicationPrevMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_applicationPrevMouseClicked
        // TODO add your handling code here:
        if (appIndex > 4) {
            appIndex -= 10;
            totalApplications += 5;
            applicationsReset();
            applications();
        }

        if (appIndex == 5) {
            applicationNext.setVisible(true);
            applicationPrev.setVisible(false);
        }
    }//GEN-LAST:event_applicationPrevMouseClicked

    private void applicationPrevMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_applicationPrevMouseEntered
        // TODO add your handling code here:
        applicationPrev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/prev button hover (1).png")));
    }//GEN-LAST:event_applicationPrevMouseEntered

    private void applicationPrevMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_applicationPrevMouseExited
        // TODO add your handling code here:
        applicationPrev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/prev button (1).png")));
    }//GEN-LAST:event_applicationPrevMouseExited

    private void applicationNextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_applicationNextMouseClicked
        // TODO add your handling code here:
        if (appIndex == 5) {
            applicationPrev.setVisible(true);
        }

        if (appIndex < totalApplications) {
            totalApplications -= 5;
            applicationsReset();
            applications();
        }

        if (appIndex == totalApplications - 1) {
            applicationNext.setVisible(false);
        }

    }//GEN-LAST:event_applicationNextMouseClicked

    private void applicationNextMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_applicationNextMouseEntered
        // TODO add your handling code here:
        applicationNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/next button hover (1).png")));

    }//GEN-LAST:event_applicationNextMouseEntered

    private void applicationNextMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_applicationNextMouseExited
        // TODO add your handling code here:
        applicationNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/next button (1).png")));
    }//GEN-LAST:event_applicationNextMouseExited

    private void cancelButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelButtonMouseEntered
        // TODO add your handling code here:
        cancelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/cancel button hover (1).png")));
    }//GEN-LAST:event_cancelButtonMouseEntered

    private void cancelButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelButtonMouseExited
        // TODO add your handling code here:
        cancelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/cancel button (1).png")));
    }//GEN-LAST:event_cancelButtonMouseExited

    private void confirmButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmButtonMouseEntered
        // TODO add your handling code here:
        confirmButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/confirm button hover (1).png")));
    }//GEN-LAST:event_confirmButtonMouseEntered

    private void confirmButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmButtonMouseExited
        // TODO add your handling code here:
        confirmButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/confirm button (1).png")));
    }//GEN-LAST:event_confirmButtonMouseExited

    private void deleteButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteButton1MouseClicked
        // TODO add your handling code here:
        JLabel[] infos = {appID1, appType1, appPetName1, appPetType1, appAppointDate1, appVet1, appStatus1};

        if (highlight1.isVisible()) {
            highlight1.setVisible(false);
            for (JLabel info : infos) {
                info.setForeground(Color.white);
            }
        } else {
            highlight1.setVisible(true);
            for (JLabel info : infos) {
                info.setForeground(Color.black);
            }
        }
    }//GEN-LAST:event_deleteButton1MouseClicked

    private void deleteButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteButton1MouseEntered
        // TODO add your handling code here:
        deleteButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/delete button hover (1).png")));
    }//GEN-LAST:event_deleteButton1MouseEntered

    private void deleteButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteButton1MouseExited
        // TODO add your handling code here:
        deleteButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/delete button (1).png")));
    }//GEN-LAST:event_deleteButton1MouseExited

    private void deleteButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteButton2MouseClicked
        // TODO add your handling code here:
        JLabel[] infos = {appID2, appType2, appPetName2, appPetType2, appAppointDate2, appVet2, appStatus2};

        if (highlight2.isVisible()) {
            highlight2.setVisible(false);
            for (JLabel info : infos) {
                info.setForeground(Color.white);
            }
        } else {
            highlight2.setVisible(true);
            for (JLabel info : infos) {
                info.setForeground(Color.black);
            }
        }
    }//GEN-LAST:event_deleteButton2MouseClicked

    private void deleteButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteButton2MouseEntered
        // TODO add your handling code here:
        deleteButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/delete button hover (1).png")));
    }//GEN-LAST:event_deleteButton2MouseEntered

    private void deleteButton2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteButton2MouseExited
        // TODO add your handling code here:
        deleteButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/delete button (1).png")));
    }//GEN-LAST:event_deleteButton2MouseExited

    private void deleteButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteButton3MouseClicked
        // TODO add your handling code here:
        JLabel[] infos = {appID3, appType3, appPetName3, appPetType3, appAppointDate3, appVet3, appStatus3};
        if (highlight3.isVisible()) {
            highlight3.setVisible(false);
            for (JLabel info : infos) {
                info.setForeground(Color.white);
            }
        } else {
            highlight3.setVisible(true);
            for (JLabel info : infos) {
                info.setForeground(Color.black);
            }
        }
    }//GEN-LAST:event_deleteButton3MouseClicked

    private void deleteButton3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteButton3MouseEntered
        // TODO add your handling code here:
        deleteButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/delete button hover (1).png")));
    }//GEN-LAST:event_deleteButton3MouseEntered

    private void deleteButton3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteButton3MouseExited
        // TODO add your handling code here:
        deleteButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/delete button (1).png")));
    }//GEN-LAST:event_deleteButton3MouseExited

    private void deleteButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteButton4MouseClicked
        // TODO add your handling code here:
        JLabel[] infos = {appID4, appType4, appPetName4, appPetType4, appAppointDate4, appVet4, appStatus4};
        if (highlight4.isVisible()) {
            highlight4.setVisible(false);
            for (JLabel info : infos) {
                info.setForeground(Color.white);
            }
        } else {
            highlight4.setVisible(true);
            for (JLabel info : infos) {
                info.setForeground(Color.black);
            }
        }
    }//GEN-LAST:event_deleteButton4MouseClicked

    private void deleteButton4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteButton4MouseEntered
        // TODO add your handling code here:
        deleteButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/delete button hover (1).png")));
    }//GEN-LAST:event_deleteButton4MouseEntered

    private void deleteButton4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteButton4MouseExited
        // TODO add your handling code here:
        deleteButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/delete button (1).png")));
    }//GEN-LAST:event_deleteButton4MouseExited

    private void deleteButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteButton5MouseClicked
        // TODO add your handling code here:
        JLabel[] infos = {appID5, appType5, appPetName5, appPetType5, appAppointDate5, appVet5, appStatus5};
        if (highlight5.isVisible()) {
            highlight5.setVisible(false);
            for (JLabel info : infos) {
                info.setForeground(Color.white);
            }
        } else {
            highlight5.setVisible(true);
            for (JLabel info : infos) {
                info.setForeground(Color.black);
            }
        }
    }//GEN-LAST:event_deleteButton5MouseClicked

    private void deleteButton5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteButton5MouseEntered
        // TODO add your handling code here:
        deleteButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/delete button hover (1).png")));
    }//GEN-LAST:event_deleteButton5MouseEntered

    private void deleteButton5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteButton5MouseExited
        // TODO add your handling code here:
        deleteButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/delete button (1).png")));
    }//GEN-LAST:event_deleteButton5MouseExited

    private void editButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editButtonMouseClicked
        // TODO add your handling code here:
        appPrev = applicationPrev.isVisible();
        appNext = applicationNext.isVisible();
        applicationEditVisibility(true);
    }//GEN-LAST:event_editButtonMouseClicked

    private void confirmButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmButtonMouseClicked
        // TODO add your handling code here:
        CountDownLatch latch = countDownLatch();

        // Use a separate thread to wait for the user's response
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // Wait for the user to respond
                    latch.await();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }

                // Continue with code execution based on user's response
                userResponse = confirmationDialog.getUserResponse();

                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        if (userResponse) {
                            applicationEditVisibility(false);
                            applicationPrev.setVisible(appPrev);
                            applicationNext.setVisible(appNext);
                        }
                    }
                });
            }
        }).start();
    }//GEN-LAST:event_confirmButtonMouseClicked

    private void cancelButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelButtonMouseClicked
        // TODO add your handling code here:
        // Create a CountDownLatch
        CountDownLatch latch = countDownLatch();

        // Use a separate thread to wait for the user's response
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // Wait for the user to respond
                    latch.await();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }

                // Continue with code execution based on user's response
                userResponse = confirmationDialog.getUserResponse();

                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        if (userResponse) {
                            applicationEditVisibility(false);
                            applicationPrev.setVisible(appPrev);
                            applicationNext.setVisible(appNext);
                        }
                    }
                });
            }
        }).start();
    }//GEN-LAST:event_cancelButtonMouseClicked

    private void profileEditButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileEditButtonMouseClicked
        // TODO add your handling code here:
        profileEditVisibility(true);
    }//GEN-LAST:event_profileEditButtonMouseClicked

    private void profileEditButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileEditButtonMouseEntered
        // TODO add your handling code here:
        profileEditButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/edit button hover (2).png")));
    }//GEN-LAST:event_profileEditButtonMouseEntered

    private void profileEditButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileEditButtonMouseExited
        // TODO add your handling code here:
        profileEditButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/edit button (2).png")));
    }//GEN-LAST:event_profileEditButtonMouseExited

    private void profileDeleteButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileDeleteButtonMouseClicked
        // TODO add your handling code here:
        CountDownLatch latch = countDownLatch();

        // Use a separate thread to wait for the user's response
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // Wait for the user to respond
                    latch.await();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }

                // Continue with code execution based on user's response
                userResponse = confirmationDialog.getUserResponse();

                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        if (userResponse) {
                        }
                    }
                });
            }
        }).start();
    }//GEN-LAST:event_profileDeleteButtonMouseClicked

    private void profileDeleteButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileDeleteButtonMouseEntered
        // TODO add your handling code here:
        profileDeleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/delete button hover (2).png")));
    }//GEN-LAST:event_profileDeleteButtonMouseEntered

    private void profileDeleteButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileDeleteButtonMouseExited
        // TODO add your handling code here:
        profileDeleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/delete button (2).png")));
    }//GEN-LAST:event_profileDeleteButtonMouseExited

    private void logoutButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutButtonMouseClicked
        // TODO add your handling code here:     
        CountDownLatch latch = countDownLatch();

        // Use a separate thread to wait for the user's response
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // Wait for the user to respond
                    latch.await();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }

                // Continue with code execution based on user's response
                userResponse = confirmationDialog.getUserResponse();

                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        if (userResponse) {
                            UserLoggedIn.this.setVisible(false);
                            new LandingPage(true).setVisible(true);
                        }
                    }
                });
            }
        }).start();
    }//GEN-LAST:event_logoutButtonMouseClicked

    private void logoutButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutButtonMouseEntered
        // TODO add your handling code here:
        logoutButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/logout button hover (1).png")));
    }//GEN-LAST:event_logoutButtonMouseEntered

    private void logoutButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutButtonMouseExited
        // TODO add your handling code here:
        logoutButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/logout button (1).png")));
    }//GEN-LAST:event_logoutButtonMouseExited

    private void profileConfirmButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileConfirmButtonMouseClicked
        // TODO add your handling code here
        // Create a CountDownLatch
        CountDownLatch latch = countDownLatch();

        // Use a separate thread to wait for the user's response
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // Wait for the user to respond
                    latch.await();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }

                // Continue with code execution based on user's response
                userResponse = confirmationDialog.getUserResponse();

                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        if (userResponse) {
                            profileEditVisibility(false);
                        }
                    }
                });
            }
        }).start();
    }//GEN-LAST:event_profileConfirmButtonMouseClicked

    private void profileConfirmButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileConfirmButtonMouseEntered
        // TODO add your handling code here:
        profileConfirmButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/confirm button hover (2).png")));
    }//GEN-LAST:event_profileConfirmButtonMouseEntered

    private void profileConfirmButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileConfirmButtonMouseExited
        // TODO add your handling code here:
        profileConfirmButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/confirm button (2).png")));
    }//GEN-LAST:event_profileConfirmButtonMouseExited

    private void profileCancelButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileCancelButtonMouseClicked
        // Create a CountDownLatch
        CountDownLatch latch = countDownLatch();

        // Use a separate thread to wait for the user's response
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // Wait for the user to respond
                    latch.await();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }

                // Continue with code execution based on user's response
                userResponse = confirmationDialog.getUserResponse();

                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        if (userResponse) {
                            profileEditVisibility(false);
                        }
                    }
                });
            }
        }).start();
    }//GEN-LAST:event_profileCancelButtonMouseClicked

    private void profileCancelButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileCancelButtonMouseEntered
        // TODO add your handling code here:
        profileCancelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/cancel button hover (2).png")));

    }//GEN-LAST:event_profileCancelButtonMouseEntered

    private void profileCancelButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileCancelButtonMouseExited
        // TODO add your handling code here:
        profileCancelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/cancel button (2).png")));
    }//GEN-LAST:event_profileCancelButtonMouseExited

    private void rehomeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rehomeButtonMouseClicked
        // TODO add your handling code here:
        if (adopt != null) {
            if (adopt.getRehome() != null) {
                rehome = adopt.getRehome();
            }
            adopt.setVisible(false);
        }

        if (rehome == null) {
            rehome = new Rehome(this);
            rehome.setVisible(true);
        } else if (!rehome.isVisible()) {
            rehome.setVisible(true);
        } else {
            rehome.toFront();
            rehome.requestFocus();
        }
    }//GEN-LAST:event_rehomeButtonMouseClicked

    private void adoptButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adoptButtonMouseClicked
        // TODO add your handling code here:
        if (rehome != null) {
            if (rehome.getAdopt() != null) {
                adopt = rehome.getAdopt();
            }
            rehome.setVisible(false);
        }
        if (adopt == null) {
            adopt = new Adopt(this);
            adopt.setVisible(true);
        } else if (!adopt.isVisible()) {
            adopt.setVisible(true);
        } else {
            adopt.toFront();
            adopt.requestFocus();
        }
    }//GEN-LAST:event_adoptButtonMouseClicked

    private void petPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_petPanel1MouseClicked
        // TODO add your handling code here:
        setCurrentPetPanel(1);
        hidePetPanels(false);
    }//GEN-LAST:event_petPanel1MouseClicked

    private void petPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_petPanel2MouseClicked
        // TODO add your handling code here:
        setCurrentPetPanel(2);
        hidePetPanels(false);
    }//GEN-LAST:event_petPanel2MouseClicked

    private void petPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_petPanel3MouseClicked
        // TODO add your handling code here:
        setCurrentPetPanel(3);
        hidePetPanels(false);
    }//GEN-LAST:event_petPanel3MouseClicked

    private void petBackButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_petBackButtonMouseClicked
        // TODO add your handling code here:
        setCurrentPetPanel(0);
        hidePetPanels(true);
        petPanel1Clicked = false;
    }//GEN-LAST:event_petBackButtonMouseClicked

    private void fullNameenterTabKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fullNameenterTabKeyPressed
        // TODO add your handling code here:
        switch (evt.getKeyChar()) {
            case KeyEvent.VK_ENTER:
                // Ignore the event if it is the Enter key
                evt.consume();
                break;
            case KeyEvent.VK_TAB:
                evt.consume();
                break;
            default:
                // Otherwise, handle the event normally
                super.processKeyEvent(evt);
                break;
        }
    }//GEN-LAST:event_fullNameenterTabKeyPressed

    private void username1enterTabKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_username1enterTabKeyPressed
        // TODO add your handling code here:
        switch (evt.getKeyChar()) {
            case KeyEvent.VK_ENTER:
                // Ignore the event if it is the Enter key
                evt.consume();
                break;
            case KeyEvent.VK_TAB:
                evt.consume();
                break;
            default:
                // Otherwise, handle the event normally
                super.processKeyEvent(evt);
                break;
        }
    }//GEN-LAST:event_username1enterTabKeyPressed

    private void birthdateenterTabKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_birthdateenterTabKeyPressed
        // TODO add your handling code here:
        switch (evt.getKeyChar()) {
            case KeyEvent.VK_ENTER:
                // Ignore the event if it is the Enter key
                evt.consume();
                break;
            case KeyEvent.VK_TAB:
                evt.consume();
                break;
            default:
                // Otherwise, handle the event normally
                super.processKeyEvent(evt);
                break;
        }
    }//GEN-LAST:event_birthdateenterTabKeyPressed

    private void monthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_monthActionPerformed

    private void dayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dayActionPerformed

    private void contactNumenterTabKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contactNumenterTabKeyPressed
        // TODO add your handling code here:
        switch (evt.getKeyChar()) {
            case KeyEvent.VK_ENTER:
                // Ignore the event if it is the Enter key
                evt.consume();
                break;
            case KeyEvent.VK_TAB:
                evt.consume();
                break;
            default:
                // Otherwise, handle the event normally
                super.processKeyEvent(evt);
                break;
        }
    }//GEN-LAST:event_contactNumenterTabKeyPressed

    private void passwordenterTabKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordenterTabKeyPressed
        // TODO add your handling code here:
        switch (evt.getKeyChar()) {
            case KeyEvent.VK_ENTER:
                // Ignore the event if it is the Enter key
                evt.consume();
                break;
            case KeyEvent.VK_TAB:
                evt.consume();
                break;
            default:
                // Otherwise, handle the event normally
                super.processKeyEvent(evt);
                break;
        }
    }//GEN-LAST:event_passwordenterTabKeyPressed

    private void confirmPasswordenterTabKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_confirmPasswordenterTabKeyPressed
        // TODO add your handling code here:
        switch (evt.getKeyChar()) {
            case KeyEvent.VK_ENTER:
                // Ignore the event if it is the Enter key
                evt.consume();
                break;
            case KeyEvent.VK_TAB:
                evt.consume();
                break;
            default:
                // Otherwise, handle the event normally
                super.processKeyEvent(evt);
                break;
        }
    }//GEN-LAST:event_confirmPasswordenterTabKeyPressed

    private void confirmPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_confirmPasswordActionPerformed

    private void currentAddressScrollenterTabKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_currentAddressScrollenterTabKeyPressed
        // TODO add your handling code here:
        switch (evt.getKeyChar()) {
            case KeyEvent.VK_ENTER:
                // Ignore the event if it is the Enter key
                evt.consume();
                break;
            case KeyEvent.VK_TAB:
                evt.consume();
                break;
            default:
                // Otherwise, handle the event normally
                super.processKeyEvent(evt);
                break;
        }
    }//GEN-LAST:event_currentAddressScrollenterTabKeyPressed

    private void occupationenterTabKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_occupationenterTabKeyPressed
        // TODO add your handling code here:
        switch (evt.getKeyChar()) {
            case KeyEvent.VK_ENTER:
                // Ignore the event if it is the Enter key
                evt.consume();
                break;
            case KeyEvent.VK_TAB:
                evt.consume();
                break;
            default:
                // Otherwise, handle the event normally
                super.processKeyEvent(evt);
                break;
        }
    }//GEN-LAST:event_occupationenterTabKeyPressed

    private void emailAddressenterTabKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailAddressenterTabKeyPressed
        // TODO add your handling code here:
        switch (evt.getKeyChar()) {
            case KeyEvent.VK_ENTER:
                // Ignore the event if it is the Enter key
                evt.consume();
                break;
            case KeyEvent.VK_TAB:
                evt.consume();
                break;
            default:
                // Otherwise, handle the event normally
                super.processKeyEvent(evt);
                break;
        }
    }//GEN-LAST:event_emailAddressenterTabKeyPressed

    private void workTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_workTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_workTypeActionPerformed

    private void workTypeenterTabKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_workTypeenterTabKeyPressed
        // TODO add your handling code here:
        switch (evt.getKeyChar()) {
            case KeyEvent.VK_ENTER:
                // Ignore the event if it is the Enter key
                evt.consume();
                break;
            case KeyEvent.VK_TAB:
                evt.consume();
                break;
            default:
                // Otherwise, handle the event normally
                super.processKeyEvent(evt);
                break;
        }
    }//GEN-LAST:event_workTypeenterTabKeyPressed

    private void companyNameenterTabKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_companyNameenterTabKeyPressed
        // TODO add your handling code here:
        switch (evt.getKeyChar()) {
            case KeyEvent.VK_ENTER:
                // Ignore the event if it is the Enter key
                evt.consume();
                break;
            case KeyEvent.VK_TAB:
                evt.consume();
                break;
            default:
                // Otherwise, handle the event normally
                super.processKeyEvent(evt);
                break;
        }
    }//GEN-LAST:event_companyNameenterTabKeyPressed

    private void petAdoptButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_petAdoptButtonMouseClicked
        // TODO add your handling code here:
        if (rehome != null) {
            if (rehome.getAdopt() != null) {
                adopt = rehome.getAdopt();
            }
            rehome.setVisible(false);
        }
        if (adopt == null) {
            adopt = new Adopt(this);
            adopt.setVisible(true);
        } else if (!adopt.isVisible()) {
            adopt.setVisible(true);
        } else {
            adopt.toFront();
            adopt.requestFocus();
        }
    }//GEN-LAST:event_petAdoptButtonMouseClicked

    private void petAdoptButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_petAdoptButtonMouseEntered
        // TODO add your handling code here:
        petAdoptButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/adopt button hover (1).png")));
    }//GEN-LAST:event_petAdoptButtonMouseEntered

    private void petAdoptButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_petAdoptButtonMouseExited
        // TODO add your handling code here:
        petAdoptButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/adopt button (1).png")));
    }//GEN-LAST:event_petAdoptButtonMouseExited

    private void petBackButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_petBackButtonMouseEntered
        // TODO add your handling code here:
        petBackButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/back button hover (2).png")));
    }//GEN-LAST:event_petBackButtonMouseEntered

    private void petBackButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_petBackButtonMouseExited
        // TODO add your handling code here:
        petBackButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/back button (2).png")));
        if (adopt != null) {
            adopt.dispose();
        }
    }//GEN-LAST:event_petBackButtonMouseExited

    private void catTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_catTypeActionPerformed
        // TODO add your handling code here:
        petFilterBySortBy();
    }//GEN-LAST:event_catTypeActionPerformed

    private void hamsterTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hamsterTypeActionPerformed
        // TODO add your handling code here:
        petFilterBySortBy();
    }//GEN-LAST:event_hamsterTypeActionPerformed

    private void rabbitTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rabbitTypeActionPerformed
        // TODO add your handling code here:
        petFilterBySortBy();
    }//GEN-LAST:event_rabbitTypeActionPerformed

    private void rescuedOriginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rescuedOriginActionPerformed
        // TODO add your handling code here:
        petFilterBySortBy();
    }//GEN-LAST:event_rescuedOriginActionPerformed

    private void adoptedStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adoptedStatusActionPerformed
        // TODO add your handling code here:
        petFilterBySortBy();
    }//GEN-LAST:event_adoptedStatusActionPerformed

    private void tinySizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tinySizeActionPerformed
        // TODO add your handling code here:
        petFilterBySortBy();
    }//GEN-LAST:event_tinySizeActionPerformed

    private void maleGenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maleGenderActionPerformed
        // TODO add your handling code here:
        petFilterBySortBy();
    }//GEN-LAST:event_maleGenderActionPerformed

    private void ownedOriginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ownedOriginActionPerformed
        // TODO add your handling code here:
        petFilterBySortBy();
    }//GEN-LAST:event_ownedOriginActionPerformed

    private void notAdoptedStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_notAdoptedStatusActionPerformed
        // TODO add your handling code here:
        petFilterBySortBy();
    }//GEN-LAST:event_notAdoptedStatusActionPerformed

    private void smallSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smallSizeActionPerformed
        // TODO add your handling code here:
        petFilterBySortBy();
    }//GEN-LAST:event_smallSizeActionPerformed

    private void femaleGenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_femaleGenderActionPerformed
        // TODO add your handling code here:
        petFilterBySortBy();
    }//GEN-LAST:event_femaleGenderActionPerformed

    private void mediumSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mediumSizeActionPerformed
        // TODO add your handling code here:
        petFilterBySortBy();
    }//GEN-LAST:event_mediumSizeActionPerformed

    private void largeSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_largeSizeActionPerformed
        // TODO add your handling code here:
        petFilterBySortBy();
    }//GEN-LAST:event_largeSizeActionPerformed

    private void orderByNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderByNameActionPerformed
        // TODO add your handling code here:
        petFilterBySortBy();
    }//GEN-LAST:event_orderByNameActionPerformed

    private void dogTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dogTypeActionPerformed
        // TODO add your handling code here:
        petFilterBySortBy();
    }//GEN-LAST:event_dogTypeActionPerformed

    private void IDdescendingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDdescendingActionPerformed
        // TODO add your handling code here:
        petFilterBySortBy();
    }//GEN-LAST:event_IDdescendingActionPerformed

    private void ageDescendingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ageDescendingActionPerformed
        // TODO add your handling code here:
        petFilterBySortBy();
    }//GEN-LAST:event_ageDescendingActionPerformed

    private void orderByIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderByIDActionPerformed
        // TODO add your handling code here:
        petFilterBySortBy();
    }//GEN-LAST:event_orderByIDActionPerformed

    private void navBarMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_navBarMouseDragged
        // TODO add your handling code here:
        Point currCoords = evt.getLocationOnScreen();
        setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);
    }//GEN-LAST:event_navBarMouseDragged

    private void navBarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_navBarMousePressed
        // TODO add your handling code here:
        mouseDownCompCoords = evt.getPoint();
    }//GEN-LAST:event_navBarMousePressed

    private void nameDescendingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameDescendingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameDescendingActionPerformed

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
            java.util.logging.Logger.getLogger(UserLoggedIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserLoggedIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserLoggedIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserLoggedIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserLoggedIn(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel FAQsBody;
    private javax.swing.JLabel FAQsPanel1;
    private javax.swing.JLabel FAQsPanel2;
    private javax.swing.JLabel FAQsPanel3;
    private javax.swing.JLabel FAQsPanel4;
    private javax.swing.JCheckBox IDdescending;
    private javax.swing.JPanel aboutUsBody;
    private javax.swing.JLabel aboutUsButton;
    private javax.swing.JLabel aboutUsClick;
    private javax.swing.JLabel aboutUsPanel;
    private javax.swing.JLabel adoptButton;
    private javax.swing.JLabel adoptedCounter;
    private javax.swing.JLabel adoptedLabel;
    private javax.swing.JCheckBox adoptedStatus;
    private javax.swing.JCheckBox ageDescending;
    private javax.swing.JLabel appAppointDate1;
    private javax.swing.JLabel appAppointDate2;
    private javax.swing.JLabel appAppointDate3;
    private javax.swing.JLabel appAppointDate4;
    private javax.swing.JLabel appAppointDate5;
    private javax.swing.JLabel appID1;
    private javax.swing.JLabel appID2;
    private javax.swing.JLabel appID3;
    private javax.swing.JLabel appID4;
    private javax.swing.JLabel appID5;
    private javax.swing.JLabel appNoResultsFound;
    private javax.swing.JLabel appPetName1;
    private javax.swing.JLabel appPetName2;
    private javax.swing.JLabel appPetName3;
    private javax.swing.JLabel appPetName4;
    private javax.swing.JLabel appPetName5;
    private javax.swing.JLabel appPetType1;
    private javax.swing.JLabel appPetType2;
    private javax.swing.JLabel appPetType3;
    private javax.swing.JLabel appPetType4;
    private javax.swing.JLabel appPetType5;
    private javax.swing.JLabel appStatus1;
    private javax.swing.JLabel appStatus2;
    private javax.swing.JLabel appStatus3;
    private javax.swing.JLabel appStatus4;
    private javax.swing.JLabel appStatus5;
    private javax.swing.JLabel appType1;
    private javax.swing.JLabel appType2;
    private javax.swing.JLabel appType3;
    private javax.swing.JLabel appType4;
    private javax.swing.JLabel appType5;
    private javax.swing.JLabel appVet1;
    private javax.swing.JLabel appVet2;
    private javax.swing.JLabel appVet3;
    private javax.swing.JLabel appVet4;
    private javax.swing.JLabel appVet5;
    private javax.swing.JPanel applicationBody;
    private javax.swing.JLabel applicationButton;
    private javax.swing.JLabel applicationClick;
    private javax.swing.JLabel applicationNext;
    private javax.swing.JLabel applicationPanel;
    private javax.swing.JLabel applicationPrev;
    private javax.swing.JLabel background;
    private javax.swing.JLabel background1;
    private javax.swing.JLabel background2;
    private javax.swing.JLabel background3;
    private javax.swing.JLabel background4;
    private javax.swing.JLabel background5;
    private javax.swing.JLabel background6;
    private javax.swing.JLabel badge;
    private javax.swing.JTextPane birthdate;
    private javax.swing.JScrollPane birthdayScroll;
    private javax.swing.JLabel bulletin;
    private javax.swing.JLabel businessRules;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel cancelButton;
    private javax.swing.JCheckBox catType;
    private javax.swing.JTextPane companyName;
    private javax.swing.JScrollPane companyScroll;
    private javax.swing.JLabel confirmButton;
    private javax.swing.JPasswordField confirmPassword;
    private javax.swing.JLabel confirmPasswordLabel;
    private javax.swing.JTextPane contactNum;
    private javax.swing.JScrollPane contactNumScroll;
    private javax.swing.JTextPane currentAddress;
    private javax.swing.JScrollPane currentAddressScroll;
    private javax.swing.JComboBox<String> day;
    private javax.swing.JLabel deleteButton1;
    private javax.swing.JLabel deleteButton2;
    private javax.swing.JLabel deleteButton3;
    private javax.swing.JLabel deleteButton4;
    private javax.swing.JLabel deleteButton5;
    private javax.swing.JLabel devs;
    private javax.swing.JCheckBox dogType;
    private javax.swing.JLabel editButton;
    private javax.swing.JTextPane emailAddress;
    private javax.swing.JScrollPane emailAddressScroll;
    private javax.swing.JLabel exitButton;
    private javax.swing.JLabel faqButton;
    private javax.swing.JLabel faqClick;
    private javax.swing.JCheckBox femaleGender;
    private javax.swing.JLabel filterBy;
    private javax.swing.JTextPane fullName;
    private javax.swing.JScrollPane fullNameScroll;
    private javax.swing.JCheckBox hamsterType;
    private javax.swing.JLabel highlight1;
    private javax.swing.JLabel highlight2;
    private javax.swing.JLabel highlight3;
    private javax.swing.JLabel highlight4;
    private javax.swing.JLabel highlight5;
    private javax.swing.JPanel homeBody;
    private javax.swing.JLabel homeButton;
    private javax.swing.JLabel homeClick;
    private javax.swing.JCheckBox largeSize;
    private javax.swing.JPanel line;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel logoutButton;
    private javax.swing.JCheckBox maleGender;
    private javax.swing.JCheckBox mediumSize;
    private javax.swing.JLabel minimizeButton;
    private javax.swing.JComboBox<String> month;
    private javax.swing.JLabel name;
    private javax.swing.JCheckBox nameDescending;
    private javax.swing.JPanel navBar;
    private javax.swing.JLabel next;
    private javax.swing.JCheckBox notAdoptedStatus;
    private javax.swing.JTextPane occupation;
    private javax.swing.JScrollPane occupationScroll;
    private javax.swing.JCheckBox orderByAge;
    private javax.swing.JCheckBox orderByID;
    private javax.swing.JCheckBox orderByName;
    private javax.swing.JCheckBox ownedOrigin;
    private javax.swing.JPasswordField password;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel petAdoptButton;
    private javax.swing.JLabel petAge1;
    private javax.swing.JLabel petAge2;
    private javax.swing.JLabel petAge3;
    private javax.swing.JLabel petBackButton;
    private javax.swing.JLabel petButton;
    private javax.swing.JLabel petClick;
    private javax.swing.JLabel petGender1;
    private javax.swing.JLabel petGender2;
    private javax.swing.JLabel petGender3;
    private javax.swing.JLabel petHeader;
    private javax.swing.JLabel petID;
    private javax.swing.JLabel petImg1;
    private javax.swing.JLabel petImg2;
    private javax.swing.JLabel petImg3;
    private javax.swing.JLabel petName1;
    private javax.swing.JLabel petName2;
    private javax.swing.JLabel petName3;
    private javax.swing.JLabel petNext;
    private javax.swing.JLabel petNoResultsFound;
    private javax.swing.JLabel petOrigin;
    private javax.swing.JLabel petPanel1;
    private javax.swing.JLabel petPanel2;
    private javax.swing.JLabel petPanel3;
    private javax.swing.JLabel petPanelClick;
    private javax.swing.JLabel petPrev;
    private javax.swing.JLabel petSize;
    private javax.swing.JLabel petStatus;
    private javax.swing.JLabel petType;
    private javax.swing.JPanel petsBody;
    private javax.swing.JLabel prev;
    private javax.swing.JLabel profileAddress;
    private javax.swing.JLabel profileAge;
    private javax.swing.JPanel profileBody;
    private javax.swing.JLabel profileCancelButton;
    private javax.swing.JLabel profileCollar;
    private javax.swing.JLabel profileCompany;
    private javax.swing.JLabel profileConfirmButton;
    private javax.swing.JLabel profileContactNum;
    private javax.swing.JLabel profileDeleteButton;
    private javax.swing.JLabel profileEditButton;
    private javax.swing.JLabel profileEmailAddress;
    private javax.swing.JLabel profileHead;
    private javax.swing.JLabel profileName;
    private javax.swing.JLabel profileOccupation;
    private javax.swing.JLabel profilePanel;
    private javax.swing.JLabel profilePassword;
    private javax.swing.JLabel profilePicture;
    private javax.swing.JLabel profileUsername;
    private javax.swing.JLabel profileWorkType;
    private javax.swing.JCheckBox rabbitType;
    private javax.swing.JLabel rehomeButton;
    private javax.swing.JCheckBox rescuedOrigin;
    private javax.swing.JLabel slogan;
    private javax.swing.JCheckBox smallSize;
    private javax.swing.JLabel sortBy;
    private javax.swing.JCheckBox tinySize;
    private javax.swing.JTextPane username1;
    private javax.swing.JScrollPane usernameScroll;
    private javax.swing.JLabel vetButton;
    private javax.swing.JLabel vetClick;
    private javax.swing.JLabel vetContact1;
    private javax.swing.JLabel vetContact2;
    private javax.swing.JLabel vetContact3;
    private javax.swing.JLabel vetContact4;
    private javax.swing.JLabel vetContact5;
    private javax.swing.JLabel vetContact6;
    private javax.swing.JLabel vetEmail1;
    private javax.swing.JLabel vetEmail2;
    private javax.swing.JLabel vetEmail3;
    private javax.swing.JLabel vetEmail4;
    private javax.swing.JLabel vetEmail5;
    private javax.swing.JLabel vetEmail6;
    private javax.swing.JLabel vetName1;
    private javax.swing.JLabel vetName2;
    private javax.swing.JLabel vetName3;
    private javax.swing.JLabel vetName4;
    private javax.swing.JLabel vetName5;
    private javax.swing.JLabel vetName6;
    private javax.swing.JLabel vetNext;
    private javax.swing.JLabel vetNoResultsFound;
    private javax.swing.JLabel vetPrev;
    private javax.swing.JPanel vetsBody;
    private javax.swing.JLabel vetsPanel;
    private javax.swing.JComboBox<String> workType;
    private javax.swing.JComboBox<String> year;
    // End of variables declaration//GEN-END:variables
}
