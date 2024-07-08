/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controllers.InformationDialogController;
import Models.Application;
import Models.Client;
import Models.Pet;
import Models.SPManager;
import Models.Veterinarian;
import java.awt.MediaTracker;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author joshu
 */
public class Rehome extends javax.swing.JFrame {

    SPManager spManager = new SPManager();

    // for moving the frame
    private Point mouseDownCompCoords;

    // sub frames
    private UserLoggedIn userLoggedIn;
    private boolean edit;
    private InformationDialog informationDialog;
    private Adopt adopt;
    private Rehome rehome;
    private JPanel glassPane;

    // controllers
    InformationDialogController informationController;
    
    // for information dialog
    boolean userResponse;

    // Client who is logged in
    Client client;
    
    // Current application, vet and pet being edited
    Application application;
    Pet tempPet;
    Veterinarian vet;

    // Vet records
    ArrayList<Veterinarian> vets;

    /**
     * Creates new form Rehome
     *
     * @param userLoggedIn
     */
    public Rehome(UserLoggedIn userLoggedIn, Application application, Client client, Pet pet, Veterinarian vet, boolean edit) {
        initComponents();

        // combo box
        populateVetComboBox();
        
        // pet type combo box
        petType.addItem("");
        petType.addItem("Cat");
        petType.addItem("Dog");
        petType.addItem("Hamster");
        petType.addItem("Rabbit");
        
        availableDates.addItem("");
        try {
            populateDateTimeComboBox(30);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if(userLoggedIn != null) {
            this.userLoggedIn = userLoggedIn;
            rehome = userLoggedIn.getRehome();
            adopt = userLoggedIn.getAdopt();
        }
        
        if(application != null) {
            this.application = application;
            String dateTime = application.getAppointDate() + " " + application.getAppointTime();
            availableDates.addItem(dateTime);
            availableDates.setSelectedItem(dateTime);
        }
         
        if(client != null) {
            this.client = client;
            setClientInformation(client);
        }
        if(pet != null) {
            if(edit) {
                this.tempPet = pet;
                petID.setText(pet.getPetID());
                petName.setText(pet.getPetName());
                petType.setSelectedItem(pet.getPetType());
            }
        }
        if (vet != null) {
            this.vet = vet;
            vetID.setSelectedItem(vet.getVetID());
            vetName.setSelectedItem(vet.getVetFullName());
        }
        
        this.edit = edit;
        
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
        
        // glass pane to block out any interaction within the main frame when opening a sub frame
        glassPane = new JPanel();
        glassPane.setOpaque(false);
        glassPane.setVisible(false);
        glassPane.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // brings the active sub frame on the front and add a system beep to notify

                // for exit dialog
                if (informationDialog != null && informationDialog.isVisible()) {
                    informationDialog.toFront();
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        });

        setGlassPane(glassPane);
    }

    private void populateVetComboBox() {
        // populate checkboxes with vet names
        this.vets = spManager.getAllVetsIDName();
        vetID.removeAllItems();
        vetID.addItem("");
        vetName.removeAllItems();
        vetName.addItem("");
        for (Veterinarian vet : vets) {
            vetName.addItem(vet.getVetFullName());
            vetID.addItem(vet.getVetID());
        }
    }

    private void setClientInformation(Client client) {
        this.client = client;
        String[] nameParts = client.getClientFullName().trim().split("\\s+");

        String firstNameVar = "";
        String lastNameVar = "";

        if (nameParts.length == 2) {
            // Case with one first name and one last name
            firstNameVar = nameParts[0];
            lastNameVar = nameParts[1];
        } else if (nameParts.length >= 3) {
            // Case with two words for the first name and the rest for the last name
            firstNameVar = nameParts[0] + " " + nameParts[1];

            // Remaining parts as last name
            StringBuilder lastNameBuilder = new StringBuilder();
            for (int i = 2; i < nameParts.length; i++) {
                lastNameBuilder.append(nameParts[i]);
                if (i < nameParts.length - 1) {
                    lastNameBuilder.append(" ");
                }
            }
            lastNameVar = lastNameBuilder.toString();
        }

        firstName.setText(firstNameVar);
        lastName.setText(lastNameVar);
        ownerID.setText(String.valueOf(client.getClientID()));
        age.setText(String.valueOf(client.getClientAge()));
        address.setText(client.getClientAddress());
        phoneNumber.setText(client.getCellNum());
        emailAddress.setText(client.getClientEmailAdd());
    }

    // available dates
    public List<String> getAvailableDateTimes(int daysAhead, String selectedVetID) throws ParseException {
        List<String> availableDateTimes = new ArrayList<>();
        if("".equals(selectedVetID)) {
            availableDateTimes.add("");
        } else {
            List<Application> existingApplications = spManager.getAllExistingApplications();
            Set<String> reservedDateTimes = new HashSet<>();

            // Filter applications by vetID and collect reserved date times
            for (Application app : existingApplications) {
                if (app.getVetID().equals(selectedVetID)) {
                    reservedDateTimes.add(app.getAppointDate() + " " + app.getAppointTime());
                }
            }
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Calendar calendar = Calendar.getInstance();

            for (int i = 1; i <= daysAhead; i++) {
                calendar.add(Calendar.DAY_OF_YEAR, 1);
                String date = dateFormat.format(calendar.getTime());
                for (int hour = 9; hour <= 17; hour++) { // Example: 9 AM to 5 PM
                    String dateTimeStr = date + " " + String.format("%02d:00:00", hour);
                    if (!reservedDateTimes.contains(dateTimeStr)) {
                        availableDateTimes.add(dateTimeStr);
                    }
                }
            }
        }
        return availableDateTimes;
    }

    private void populateDateTimeComboBox(int daysAhead) throws ParseException {
        List<String> availableDateTimes = getAvailableDateTimes(daysAhead, (String) vetID.getSelectedItem());
        availableDates.removeAllItems();
        availableDates.addItem("");
        for (String dateTime : availableDateTimes) {
            availableDates.addItem(dateTime);
        }
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
    
    public CountDownLatch countDownLatch() {
        // Create a CountDownLatch
        CountDownLatch latch = new CountDownLatch(1);

        // Show the custom frame on the EDT
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                if (informationDialog == null || !informationDialog.isVisible()) {
                    informationDialog = new InformationDialog(null, Rehome.this, null, latch);
                    informationController = new InformationDialogController(informationDialog, null, Rehome.this, null, latch);
                    informationDialog.setVisible(true);
                    glassPane.setVisible(true);
                } else {
                    informationDialog.toFront();
                    informationDialog.requestFocus();
                }
            }
        });
        return latch;
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
        petType = new javax.swing.JComboBox<>();
        petAge = new javax.swing.JTextField();
        vetID = new javax.swing.JComboBox<>();
        vetName = new javax.swing.JComboBox<>();
        availableDates = new javax.swing.JComboBox<>();
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
        rehomePanel1.add(rehomeNext, new org.netbeans.lib.awtextra.AbsoluteConstraints(605, 590, 220, 70));

        firstName.setEditable(false);
        rehomePanel1.add(firstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 287, 232, 32));

        ownerID.setEditable(false);
        rehomePanel1.add(ownerID, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, 324, 354, 32));

        lastName.setEditable(false);
        rehomePanel1.add(lastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(541, 287, 238, 32));

        age.setEditable(false);
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

        address.setEditable(false);
        address.setColumns(20);
        address.setRows(5);
        addressScroll.setViewportView(address);

        rehomePanel1.add(addressScroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, 360, 563, 59));

        phoneNumber.setEditable(false);
        rehomePanel1.add(phoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 424, 207, 32));

        emailAddress.setEditable(false);
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
        rehomePanel2.add(rehomeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 605, -1, -1));

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
        rehomePanel2.add(rehomePrev, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 590, 220, 75));

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

        rehomePanel2.add(petType, new org.netbeans.lib.awtextra.AbsoluteConstraints(206, 358, 290, 32));

        petAge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                petAgeActionPerformed(evt);
            }
        });
        rehomePanel2.add(petAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(615, 323, 162, 32));

        vetID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vetIDActionPerformed(evt);
            }
        });
        rehomePanel2.add(vetID, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 461, 200, 32));

        vetName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vetNameActionPerformed(evt);
            }
        });
        rehomePanel2.add(vetName, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 498, 200, 32));

        availableDates.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                availableDatesActionPerformed(evt);
            }
        });
        rehomePanel2.add(availableDates, new org.netbeans.lib.awtextra.AbsoluteConstraints(539, 462, 238, 32));

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
        rescued.setEnabled(false);
        rescued.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rescued.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        rescued.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rescuedActionPerformed(evt);
            }
        });
        rehomePanel2.add(rescued, new org.netbeans.lib.awtextra.AbsoluteConstraints(588, 364, 20, 20));

        owned.setSelected(true);
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
        adopted.setEnabled(false);
        adopted.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        adopted.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        adopted.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adoptedActionPerformed(evt);
            }
        });
        rehomePanel2.add(adopted, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 397, 20, 20));

        notAdopted.setSelected(true);
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
        rehomePanel2.add(iAgree, new org.netbeans.lib.awtextra.AbsoluteConstraints(414, 619, 20, 20));

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
            adopt = new Adopt(userLoggedIn, null, client, null, null, false);
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
        // pet name
        if("".equals(petName.getText())) {
            JOptionPane.showMessageDialog(null, "Please enter a pet name.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // pet age
        if("".equals(petAge.getText())) {
            JOptionPane.showMessageDialog(null, "Please enter a pet age.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // pet type
        if("".equals((String)petType.getSelectedItem())) {
            JOptionPane.showMessageDialog(null, "Please choose a pet type.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String petSex = "";
        String petSize = "";
        
        // pet sex
        if(male.isSelected()) {
            petSex = "M";
        } else if(female.isSelected()) {
            petSex = "F";
        }
        
        if ("".equals(petSex)) {
            JOptionPane.showMessageDialog(null, "Please choose a pet sex.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // pet size
        if(tiny.isSelected()) {
            petSize = "T";
        } else if(small.isSelected()) {
            petSize = "S";
        } else if(medium.isSelected()) {
            petSize = "M";
        } else if(large.isSelected()) {
            petSize = "L";
        }
        
        if ("".equals(petSize)) {
            JOptionPane.showMessageDialog(null, "Please choose a pet size.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // reason
        if ("".equals(reason.getText())) {
            JOptionPane.showMessageDialog(null, "Please enter a reason.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // available dates
        if ("".equals((String) availableDates.getSelectedItem())) {
            JOptionPane.showMessageDialog(null, "Please select an available date.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // vet id
        if ("".equals((String) vetID.getSelectedItem())) {
            JOptionPane.showMessageDialog(null, "Please select a vet ID.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // agreement
        if (!iAgree.isSelected()) {
            JOptionPane.showMessageDialog(null, "You must agree to the terms.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // if all information is not empty
        final String enteredPetName = petName.getText().trim();
        String enteredPetAge = "";
        if(Integer.valueOf(petAge.getText().trim()) > 1) {
            enteredPetAge = petAge.getText().trim() + " months";
        } else {
            enteredPetAge = petAge.getText().trim() + " month";
        }
        final String finalEnteredPetAge = enteredPetAge;
        final String selectedPetType = ((String)petType.getSelectedItem()).trim();
        final String selectedPetSex = petSex;
        final String selectedPetOrigin = "O";
        final String selectedPetStatus = "NA";
        final String selectedPetSize = petSize;
        
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
                userResponse = informationDialog.getUserResponse();

                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        if (userResponse) {
                            int selectedPetID = 0;
                            // QUERY HERE: update pet record in the pet table by pet id
                            // the method will return the pet id if successful, otherwise return an empty string
                            if(edit) {
                                selectedPetID = spManager.updatePetRecordByID(Integer.valueOf(tempPet.getPetID()), selectedPetType, selectedPetOrigin, selectedPetStatus, selectedPetSize,
                                                      finalEnteredPetAge, enteredPetName, selectedPetSex);
                            } else {
                                // QUERY HERE: insert pet record in the pet table
                                // the method will return the pet id if successful, otherwise return an empty string
                                selectedPetID = spManager.insertPetRecord(selectedPetType, selectedPetOrigin, selectedPetStatus, selectedPetSize,
                                                      finalEnteredPetAge, enteredPetName, selectedPetSex);
                            }

                            if(selectedPetID == 0) {
                                JOptionPane.showMessageDialog(null, "Insertion of pet record unsuccessful", "Validation Error", JOptionPane.ERROR_MESSAGE);
                                return;
                            }
                            
                            String applicationType = "R";
                            String[] appointDateTime = ((String) availableDates.getSelectedItem()).trim().split(" ");
                            String appointDate = appointDateTime[0];
                            String appointTime = appointDateTime[1];
                            String appointPlace = "Vet Clinic";
                            String appointStatus = "P";
                            int clientID = Integer.valueOf(ownerID.getText().trim());
                            int selectedVetID = Integer.valueOf(((String) vetID.getSelectedItem()).trim());

                            // QUERY HERE: update rehome application form in the application table by application id
                            // the method will return true if successful, otherwise false
                            if(edit) {
                                if(spManager.updateApplicationRecord(application.getApplicationID(), applicationType, appointDate, appointTime, appointPlace, appointStatus, clientID, selectedPetID, selectedVetID)) {
                                    JOptionPane.showMessageDialog(null, "Application Updated Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                                            } else {
                                    JOptionPane.showMessageDialog(null, "Application Update Failed", "Failed", JOptionPane.ERROR_MESSAGE);
                                }
                            } else {
                                // QUERY HERE: insert rehome application form in the application table
                                // the method will return true if successful, otherwise false
                                if(spManager.insertApplicationRecord(applicationType, appointDate, appointTime, appointPlace, appointStatus, clientID, selectedPetID, selectedVetID)) {
                                    JOptionPane.showMessageDialog(null, "Application Submitted!", "Success", JOptionPane.INFORMATION_MESSAGE);
                                } else {
                                    JOptionPane.showMessageDialog(null, "Application Failed", "Failed", JOptionPane.ERROR_MESSAGE);
                                    spManager.deletePetRecordByID(selectedPetID);
                                }
                            }
                            userLoggedIn.setApplicationClicked(false);
                            userLoggedIn.populateAppsFromDB();
                            userLoggedIn.handleApplicationButtonClick();
                            userLoggedIn.applications();
                            userLoggedIn.applicationEditVisibility(false);
                            Rehome.this.dispose();
                        }
                    }
                });
            }
        }).start();
        
        
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
        String currentVetID = (String) vetID.getSelectedItem();
        for (Veterinarian vet : vets) {
            if (vet.getVetID().equals(currentVetID)) {
                vetName.setSelectedItem(vet.getVetFullName());
                try {
                    populateDateTimeComboBox(30);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return;
            }
        }
        try {
            populateDateTimeComboBox(30);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        vetName.setSelectedItem("");
    }//GEN-LAST:event_vetIDActionPerformed

    private void vetNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vetNameActionPerformed
        // TODO add your handling code here:
        String currentVetName = (String) vetName.getSelectedItem();
        for (Veterinarian vet : vets) {
            if (vet.getVetFullName().equals(currentVetName)) {
                vetID.setSelectedItem(String.valueOf(vet.getVetID()));
                try {
                    populateDateTimeComboBox(30);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return;
            }
        }
        try {
            populateDateTimeComboBox(30);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        vetID.setSelectedItem("");
    }//GEN-LAST:event_vetNameActionPerformed

    private void availableDatesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_availableDatesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_availableDatesActionPerformed

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
    private javax.swing.JComboBox<String> availableDates;
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
    private javax.swing.JComboBox<String> petType;
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
    private javax.swing.JComboBox<String> vetID;
    private javax.swing.JComboBox<String> vetName;
    // End of variables declaration//GEN-END:variables
}
