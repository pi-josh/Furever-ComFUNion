/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controllers.ConfirmationDialogController;
import java.awt.MediaTracker;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author joshu
 */
public class Summary extends javax.swing.JFrame {

    // for moving the frame
    private Point mouseDownCompCoords;

    // sub frames
    private UserLoggedIn userLoggedIn;
    private VetLoggedIn vetLoggedIn;
    private LandingPage landingPage;

    // summary display, scalar, and having conditions
    private List<String> displayAttributes = new ArrayList<>();
    private List<String> columnFunctions = new ArrayList<>();
    private List<String> havingConditions = new ArrayList<>();

    // controller
    ConfirmationDialogController confirmationController;

    /**
     * Creates new form Register
     */
    public Summary(LandingPage landingPage, UserLoggedIn userLoggedIn, VetLoggedIn vetLoggedIn) {
        initComponents();
        if (userLoggedIn != null) {
            this.userLoggedIn = userLoggedIn;
        } else if (landingPage != null) {
            this.landingPage = landingPage;
        } else if (vetLoggedIn != null) {
            this.vetLoggedIn = vetLoggedIn;
        }
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
        
        countHaving.setName("countHaving");
        minHaving.setName("minHaving");
        maxHaving.setName("maxHaving");
        sumHaving.setName("sumHaving");
        averageHaving.setName("averageHaving");
        
        JCheckBox[] havingsCb = { countCb, minCb, maxCb, sumCb, averageCb };
        JTextField[] havingsText = {countHaving, minHaving, maxHaving, sumHaving, averageHaving};
        
        for(int i = 0; i < havingsCb.length; i++) {
            havingsCb[i].setEnabled(false);
            havingsText[i].setEditable(false);
            havingsText[i].setEnabled(false);
        }
    }

    public Summary() {
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

    private void getSummary() {
    // Clear previous selections
    displayAttributes.clear();
    columnFunctions.clear();
    havingConditions.clear();

    JCheckBox[] displays = {appointStatus, clientFullName, vetFullName, petType, petName, petGender, petOrigin, petSize, petStatus};
    JCheckBox[] scalars = {count, min, max, sum, average};
    JCheckBox[] havingsCb = { countCb, minCb, maxCb, sumCb, averageCb };
    JTextField[] havingsText = {countHaving, minHaving, maxHaving, sumHaving, averageHaving};
    String[] havingsInitialInputs = new String[] {"TotalRecord", "MinimumTotalRecord", "MaximumTotalRecord", "SumTotalRecord", "AverageTotalRecord" };

    // Add selected display attributes
        for (JCheckBox display : displays) {
            if (display.isSelected()) {
                displayAttributes.add(display.getText());
            }
        }

        // Map scalar checkboxes to their corresponding text fields
        for (int i = 0; i < scalars.length; i++) {
            JCheckBox scalar = scalars[i];
            JTextField havingTextField = havingsText[i];
            JCheckBox havingCb = havingsCb[i];
            String havingInput = havingsInitialInputs[i];

            if (scalar.isSelected()) {
                columnFunctions.add(scalar.getText());
                havingTextField.setEnabled(true);
                havingTextField.setEditable(true);
                havingTextField.setFocusable(true);
                havingCb.setEnabled(true);
            } else {
                havingTextField.setText(havingInput);
                havingCb.setSelected(false);
                havingCb.setEnabled(false);
                havingTextField.setEditable(false);
                havingTextField.setEnabled(false);
            }
        }

        // Add having conditions from text fields if their corresponding checkbox is selected
        for (int i = 0; i < havingsCb.length; i++) {
            JCheckBox cb = havingsCb[i];
            JTextField textField = havingsText[i];

            if (cb.isSelected()) {
                String having = textField.getText().trim();
                if (!having.isEmpty()) {
                    havingConditions.add(having);
                }
            }
        }
    }
    
    
    public void setHavingTextFields() {
        havingConditions.clear();
        
        JCheckBox[] havingsCb = { countCb, minCb, maxCb, sumCb, averageCb };
        JTextField[] havingsText = {countHaving, minHaving, maxHaving, sumHaving, averageHaving};
        
        // Add having conditions from text fields if their corresponding checkbox is selected
        for (int i = 0; i < havingsCb.length; i++) {
            JCheckBox cb = havingsCb[i];
            JTextField textField = havingsText[i];

            if (cb.isSelected()) {
                String having = textField.getText().trim();
                if (!having.isEmpty()) {
                    havingConditions.add(having);
                }
            }
        }
    }

    private boolean validateHavingField(JTextField textField) {
        String text = textField.getText().trim();

        // Regular expression to match <attribute> <operator> <value> where value is a positive or negative integer
        String regex = "^(TotalRecord|MinimumTotalRecord|MaximumTotalRecord|SumTotalRecord|AverageTotalRecord)\\s*(>=|<=|>|<|=)\\s*-?\\d+$";
        if (!text.matches(regex)) {
            return false;
        }

        // Further validate the numeric value
        try {
            // Split text around the operator
            String[] parts = text.split("\\s*(>=|<=|>|<|=)\\s*");
            if (parts.length != 2) {
                return false; // Invalid format if parts are not exactly two
            }

            int value = Integer.parseInt(parts[1]);

            // Adjust the range validation as per your application's requirements
            if (value < Integer.MIN_VALUE || value > Integer.MAX_VALUE) {
                return false;
            }
        } catch (NumberFormatException e) {
            return false; // Invalid integer format
        }

        return true;
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
        header = new javax.swing.JLabel();
        summaryPanel = new javax.swing.JPanel();
        confirmButton = new javax.swing.JLabel();
        minCb = new javax.swing.JCheckBox();
        maxCb = new javax.swing.JCheckBox();
        sumCb = new javax.swing.JCheckBox();
        averageCb = new javax.swing.JCheckBox();
        countCb = new javax.swing.JCheckBox();
        averageHaving = new javax.swing.JTextField();
        countHaving = new javax.swing.JTextField();
        minHaving = new javax.swing.JTextField();
        maxHaving = new javax.swing.JTextField();
        sumHaving = new javax.swing.JTextField();
        petStatus = new javax.swing.JCheckBox();
        petSize = new javax.swing.JCheckBox();
        petOrigin = new javax.swing.JCheckBox();
        petGender = new javax.swing.JCheckBox();
        petName = new javax.swing.JCheckBox();
        appointStatus = new javax.swing.JCheckBox();
        average = new javax.swing.JCheckBox();
        clientFullName = new javax.swing.JCheckBox();
        vetFullName = new javax.swing.JCheckBox();
        sum = new javax.swing.JCheckBox();
        min = new javax.swing.JCheckBox();
        max = new javax.swing.JCheckBox();
        count = new javax.swing.JCheckBox();
        petType = new javax.swing.JCheckBox();
        summaryTableScroll = new javax.swing.JScrollPane();
        summaryTable = new javax.swing.JTable();
        summaryBg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Summary");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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

        summaryPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        summaryPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        confirmButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/confirm button (2).png"))); // NOI18N
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
        summaryPanel.add(confirmButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 135, 70, 70));

        minCb.setBackground(new java.awt.Color(255, 255, 255));
        minCb.setFont(new java.awt.Font("Tahoma", 0, 1)); // NOI18N
        minCb.setBorder(null);
        minCb.setContentAreaFilled(false);
        minCb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minCb.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        minCb.setIconTextGap(0);
        minCb.setMargin(new java.awt.Insets(0, 0, 0, 0));
        minCb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minCbActionPerformed(evt);
            }
        });
        summaryPanel.add(minCb, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 147, 15, 15));
        minCb.getAccessibleContext().setAccessibleName("minCb");

        maxCb.setBackground(new java.awt.Color(255, 255, 255));
        maxCb.setFont(new java.awt.Font("Tahoma", 0, 1)); // NOI18N
        maxCb.setBorder(null);
        maxCb.setContentAreaFilled(false);
        maxCb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        maxCb.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        maxCb.setIconTextGap(0);
        maxCb.setMargin(new java.awt.Insets(0, 0, 0, 0));
        maxCb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maxCbActionPerformed(evt);
            }
        });
        summaryPanel.add(maxCb, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 170, 15, 15));

        sumCb.setBackground(new java.awt.Color(255, 255, 255));
        sumCb.setFont(new java.awt.Font("Tahoma", 0, 1)); // NOI18N
        sumCb.setBorder(null);
        sumCb.setContentAreaFilled(false);
        sumCb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sumCb.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sumCb.setIconTextGap(0);
        sumCb.setMargin(new java.awt.Insets(0, 0, 0, 0));
        sumCb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sumCbActionPerformed(evt);
            }
        });
        summaryPanel.add(sumCb, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 193, 15, 15));

        averageCb.setBackground(new java.awt.Color(255, 255, 255));
        averageCb.setFont(new java.awt.Font("Tahoma", 0, 1)); // NOI18N
        averageCb.setBorder(null);
        averageCb.setContentAreaFilled(false);
        averageCb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        averageCb.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        averageCb.setIconTextGap(0);
        averageCb.setMargin(new java.awt.Insets(0, 0, 0, 0));
        averageCb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                averageCbActionPerformed(evt);
            }
        });
        summaryPanel.add(averageCb, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 217, 15, 15));

        countCb.setBackground(new java.awt.Color(255, 255, 255));
        countCb.setFont(new java.awt.Font("Tahoma", 0, 1)); // NOI18N
        countCb.setBorder(null);
        countCb.setContentAreaFilled(false);
        countCb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        countCb.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        countCb.setIconTextGap(0);
        countCb.setMargin(new java.awt.Insets(0, 0, 0, 0));
        countCb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                countCbActionPerformed(evt);
            }
        });
        summaryPanel.add(countCb, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 125, 15, 15));

        averageHaving.setEditable(false);
        averageHaving.setText("AverageTotalRecord");
        averageHaving.setEnabled(false);
        averageHaving.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                averageHavingActionPerformed(evt);
            }
        });
        summaryPanel.add(averageHaving, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 212, 200, -1));
        averageHaving.getAccessibleContext().setAccessibleName("averageHaving");

        countHaving.setEditable(false);
        countHaving.setText("TotalRecord");
        countHaving.setEnabled(false);
        summaryPanel.add(countHaving, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 120, 200, -1));
        countHaving.getAccessibleContext().setAccessibleName("countHaving");

        minHaving.setEditable(false);
        minHaving.setText("MinimumTotalRecord");
        minHaving.setEnabled(false);
        minHaving.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minHavingActionPerformed(evt);
            }
        });
        summaryPanel.add(minHaving, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 143, 200, -1));
        minHaving.getAccessibleContext().setAccessibleName("minHaving");

        maxHaving.setEditable(false);
        maxHaving.setText("MaximumTotalRecord");
        maxHaving.setEnabled(false);
        maxHaving.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maxHavingActionPerformed(evt);
            }
        });
        summaryPanel.add(maxHaving, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 166, 200, -1));
        maxHaving.getAccessibleContext().setAccessibleName("maxHaving");

        sumHaving.setEditable(false);
        sumHaving.setText("SumTotalRecord");
        sumHaving.setEnabled(false);
        summaryPanel.add(sumHaving, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 189, 200, -1));
        sumHaving.getAccessibleContext().setAccessibleName("sumHaving");

        petStatus.setBackground(new java.awt.Color(255, 255, 255));
        petStatus.setFont(new java.awt.Font("Tahoma", 0, 1)); // NOI18N
        petStatus.setText("PetStatus");
        petStatus.setBorder(null);
        petStatus.setContentAreaFilled(false);
        petStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        petStatus.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        petStatus.setIconTextGap(0);
        petStatus.setMargin(new java.awt.Insets(0, 0, 0, 0));
        petStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                petStatusActionPerformed(evt);
            }
        });
        summaryPanel.add(petStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 169, 15, 15));

        petSize.setBackground(new java.awt.Color(255, 255, 255));
        petSize.setFont(new java.awt.Font("Tahoma", 0, 1)); // NOI18N
        petSize.setText("PetSize");
        petSize.setBorder(null);
        petSize.setContentAreaFilled(false);
        petSize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        petSize.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        petSize.setIconTextGap(0);
        petSize.setMargin(new java.awt.Insets(0, 0, 0, 0));
        petSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                petSizeActionPerformed(evt);
            }
        });
        summaryPanel.add(petSize, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 190, 15, 15));

        petOrigin.setBackground(new java.awt.Color(255, 255, 255));
        petOrigin.setFont(new java.awt.Font("Tahoma", 0, 1)); // NOI18N
        petOrigin.setText("PetOrigin");
        petOrigin.setBorder(null);
        petOrigin.setContentAreaFilled(false);
        petOrigin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        petOrigin.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        petOrigin.setIconTextGap(0);
        petOrigin.setMargin(new java.awt.Insets(0, 0, 0, 0));
        petOrigin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                petOriginActionPerformed(evt);
            }
        });
        summaryPanel.add(petOrigin, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 149, 15, 15));

        petGender.setBackground(new java.awt.Color(255, 255, 255));
        petGender.setFont(new java.awt.Font("Tahoma", 0, 1)); // NOI18N
        petGender.setText("PetGender");
        petGender.setBorder(null);
        petGender.setContentAreaFilled(false);
        petGender.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        petGender.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        petGender.setIconTextGap(0);
        petGender.setMargin(new java.awt.Insets(0, 0, 0, 0));
        petGender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                petGenderActionPerformed(evt);
            }
        });
        summaryPanel.add(petGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 209, 15, 15));

        petName.setBackground(new java.awt.Color(255, 255, 255));
        petName.setFont(new java.awt.Font("Tahoma", 0, 1)); // NOI18N
        petName.setText("PetName");
        petName.setBorder(null);
        petName.setContentAreaFilled(false);
        petName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        petName.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        petName.setIconTextGap(0);
        petName.setMargin(new java.awt.Insets(0, 0, 0, 0));
        petName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                petNameActionPerformed(evt);
            }
        });
        summaryPanel.add(petName, new org.netbeans.lib.awtextra.AbsoluteConstraints(168, 130, 15, 15));

        appointStatus.setBackground(new java.awt.Color(255, 255, 255));
        appointStatus.setFont(new java.awt.Font("Tahoma", 0, 1)); // NOI18N
        appointStatus.setText("AppointStatus");
        appointStatus.setBorder(null);
        appointStatus.setContentAreaFilled(false);
        appointStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        appointStatus.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        appointStatus.setIconTextGap(0);
        appointStatus.setMargin(new java.awt.Insets(0, 0, 0, 0));
        appointStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                appointStatusActionPerformed(evt);
            }
        });
        summaryPanel.add(appointStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 130, 15, 15));

        average.setBackground(new java.awt.Color(255, 255, 255));
        average.setFont(new java.awt.Font("Tahoma", 0, 1)); // NOI18N
        average.setText("AVG(COUNT(*)) AverageCountRecord");
        average.setBorder(null);
        average.setContentAreaFilled(false);
        average.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        average.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        average.setIconTextGap(0);
        average.setMargin(new java.awt.Insets(0, 0, 0, 0));
        average.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                averageActionPerformed(evt);
            }
        });
        summaryPanel.add(average, new org.netbeans.lib.awtextra.AbsoluteConstraints(378, 163, 15, 15));

        clientFullName.setBackground(new java.awt.Color(255, 255, 255));
        clientFullName.setFont(new java.awt.Font("Tahoma", 0, 1)); // NOI18N
        clientFullName.setText("ClientFullName");
        clientFullName.setBorder(null);
        clientFullName.setContentAreaFilled(false);
        clientFullName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        clientFullName.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        clientFullName.setIconTextGap(0);
        clientFullName.setMargin(new java.awt.Insets(0, 0, 0, 0));
        clientFullName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientFullNameActionPerformed(evt);
            }
        });
        summaryPanel.add(clientFullName, new org.netbeans.lib.awtextra.AbsoluteConstraints(168, 171, 15, 15));

        vetFullName.setBackground(new java.awt.Color(255, 255, 255));
        vetFullName.setFont(new java.awt.Font("Tahoma", 0, 1)); // NOI18N
        vetFullName.setText("VetFullName");
        vetFullName.setBorder(null);
        vetFullName.setContentAreaFilled(false);
        vetFullName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        vetFullName.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        vetFullName.setIconTextGap(0);
        vetFullName.setMargin(new java.awt.Insets(0, 0, 0, 0));
        vetFullName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vetFullNameActionPerformed(evt);
            }
        });
        summaryPanel.add(vetFullName, new org.netbeans.lib.awtextra.AbsoluteConstraints(168, 151, 15, 15));

        sum.setBackground(new java.awt.Color(255, 255, 255));
        sum.setFont(new java.awt.Font("Tahoma", 0, 1)); // NOI18N
        sum.setText("SUM(COUNT(*)) SumTotalRecord");
        sum.setBorder(null);
        sum.setContentAreaFilled(false);
        sum.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sum.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sum.setIconTextGap(0);
        sum.setMargin(new java.awt.Insets(0, 0, 0, 0));
        sum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sumActionPerformed(evt);
            }
        });
        summaryPanel.add(sum, new org.netbeans.lib.awtextra.AbsoluteConstraints(378, 200, 15, 15));

        min.setBackground(new java.awt.Color(255, 255, 255));
        min.setFont(new java.awt.Font("Tahoma", 0, 1)); // NOI18N
        min.setText("MIN(COUNT(*)) MinimumTotalRecord");
        min.setBorder(null);
        min.setContentAreaFilled(false);
        min.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        min.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        min.setIconTextGap(0);
        min.setMargin(new java.awt.Insets(0, 0, 0, 0));
        min.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minActionPerformed(evt);
            }
        });
        summaryPanel.add(min, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 146, 15, 15));

        max.setBackground(new java.awt.Color(255, 255, 255));
        max.setFont(new java.awt.Font("Tahoma", 0, 1)); // NOI18N
        max.setText("MAX(COUNT(*)) MaximumTotalRecord");
        max.setBorder(null);
        max.setContentAreaFilled(false);
        max.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        max.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        max.setIconTextGap(0);
        max.setMargin(new java.awt.Insets(0, 0, 0, 0));
        max.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maxActionPerformed(evt);
            }
        });
        summaryPanel.add(max, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 180, 15, 15));

        count.setBackground(new java.awt.Color(255, 255, 255));
        count.setFont(new java.awt.Font("Tahoma", 0, 1)); // NOI18N
        count.setText("COUNT(*) TotalRecord");
        count.setBorder(null);
        count.setContentAreaFilled(false);
        count.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        count.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        count.setIconTextGap(0);
        count.setMargin(new java.awt.Insets(0, 0, 0, 0));
        count.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                countActionPerformed(evt);
            }
        });
        summaryPanel.add(count, new org.netbeans.lib.awtextra.AbsoluteConstraints(378, 130, 15, 15));

        petType.setBackground(new java.awt.Color(255, 255, 255));
        petType.setFont(new java.awt.Font("Tahoma", 0, 1)); // NOI18N
        petType.setText("PetType");
        petType.setBorder(null);
        petType.setContentAreaFilled(false);
        petType.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        petType.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        petType.setIconTextGap(0);
        petType.setMargin(new java.awt.Insets(0, 0, 0, 0));
        petType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                petTypeActionPerformed(evt);
            }
        });
        summaryPanel.add(petType, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 130, 15, 15));

        summaryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        summaryTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        summaryTable.getTableHeader().setReorderingAllowed(false);
        summaryTableScroll.setViewportView(summaryTable);
        if (summaryTable.getColumnModel().getColumnCount() > 0) {
            summaryTable.getColumnModel().getColumn(0).setResizable(false);
            summaryTable.getColumnModel().getColumn(1).setResizable(false);
            summaryTable.getColumnModel().getColumn(2).setResizable(false);
            summaryTable.getColumnModel().getColumn(3).setResizable(false);
            summaryTable.getColumnModel().getColumn(3).setHeaderValue("Title 4");
        }

        summaryPanel.add(summaryTableScroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, 660, 410));

        summaryBg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/SUMMARY.png"))); // NOI18N
        summaryPanel.add(summaryBg, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, -1, -1));

        getContentPane().add(summaryPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 680));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMouseDragged
        // TODO add your handling code here:
        Point currCoords = evt.getLocationOnScreen();
        setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);
    }//GEN-LAST:event_headerMouseDragged

    private void headerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMousePressed
        // TODO add your handling code here:
        mouseDownCompCoords = evt.getPoint();
    }//GEN-LAST:event_headerMousePressed

    private void maxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maxActionPerformed
        // TODO add your handling code here:
        getSummary();
    }//GEN-LAST:event_maxActionPerformed

    private void countActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_countActionPerformed
        // TODO add your handling code here:
        getSummary();
    }//GEN-LAST:event_countActionPerformed

    private void petTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_petTypeActionPerformed
        // TODO add your handling code here:
        getSummary();
    }//GEN-LAST:event_petTypeActionPerformed

    private void petStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_petStatusActionPerformed
        // TODO add your handling code here:
        getSummary();
    }//GEN-LAST:event_petStatusActionPerformed

    private void petSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_petSizeActionPerformed
        // TODO add your handling code here:
        getSummary();
    }//GEN-LAST:event_petSizeActionPerformed

    private void petOriginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_petOriginActionPerformed
        // TODO add your handling code here:
        getSummary();
    }//GEN-LAST:event_petOriginActionPerformed

    private void petGenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_petGenderActionPerformed
        // TODO add your handling code here:
        getSummary();
    }//GEN-LAST:event_petGenderActionPerformed

    private void petNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_petNameActionPerformed
        // TODO add your handling code here:
        getSummary();
    }//GEN-LAST:event_petNameActionPerformed

    private void appointStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appointStatusActionPerformed
        // TODO add your handling code here:
        getSummary();
    }//GEN-LAST:event_appointStatusActionPerformed

    private void averageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_averageActionPerformed
        // TODO add your handling code here:
        getSummary();
    }//GEN-LAST:event_averageActionPerformed

    private void clientFullNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientFullNameActionPerformed
        // TODO add your handling code here:
        getSummary();
    }//GEN-LAST:event_clientFullNameActionPerformed

    private void vetFullNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vetFullNameActionPerformed
        // TODO add your handling code here:
        getSummary();
    }//GEN-LAST:event_vetFullNameActionPerformed

    private void sumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sumActionPerformed
        // TODO add your handling code here:
        getSummary();
    }//GEN-LAST:event_sumActionPerformed

    private void minActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minActionPerformed
        // TODO add your handling code here:
        getSummary();
    }//GEN-LAST:event_minActionPerformed

    private void minHavingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minHavingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_minHavingActionPerformed

    private void confirmButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmButtonMouseClicked
        // TODO add your handling code here
        // Validate all having text fields before proceeding
        JTextField[] havingsText = {countHaving, minHaving, maxHaving, sumHaving, averageHaving};
        JCheckBox[] havingsCb = {countCb, minCb, maxCb, sumCb, averageCb};

        boolean isValid = true;
        for (int i = 0; i < havingsText.length; i++) {
            JTextField textField = havingsText[i];
            JCheckBox checkbox = havingsCb[i];

            // Check if the checkbox is selected before validating the text field
            if (checkbox.isSelected() && !validateHavingField(textField)) {
                isValid = false;
                // Optionally, show an error message or indicate which field is invalid
                JOptionPane.showMessageDialog(this, "Invalid format in " + textField.getName(), "Validation Error", JOptionPane.ERROR_MESSAGE);
                break; // Stop validation on first error
            }
        }

        // If all fields are valid, proceed with generating the summary/query
        if (isValid) {
            setHavingTextFields(); // Optional method call
            
            // Print the summary
            System.out.println("SELECT " + String.join(",", displayAttributes) + (columnFunctions.isEmpty() ? "" : "," + String.join(",", columnFunctions)));
            System.out.println("GROUP BY " + String.join(",", displayAttributes));
            if (!havingConditions.isEmpty()) {
                System.out.println("HAVING " + String.join(",", havingConditions));
            }

            System.out.println("\n\n\n");
            
            /*
            // QUERY HERE: get summary by display attributes, scalar functions, and having conditions
            dataStructureToBeUsed = spManager.methodName(displayAttributes, columnFunctions, havingConditions);
            */
        }
    }//GEN-LAST:event_confirmButtonMouseClicked

    private void confirmButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmButtonMouseEntered
        // TODO add your handling code here:
        confirmButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/confirm button hover (2).png")));
    }//GEN-LAST:event_confirmButtonMouseEntered

    private void confirmButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmButtonMouseExited
        // TODO add your handling code here:
        confirmButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/confirm button (2).png")));
    }//GEN-LAST:event_confirmButtonMouseExited

    private void averageHavingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_averageHavingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_averageHavingActionPerformed

    private void countCbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_countCbActionPerformed
        // TODO add your handling code here:
        setHavingTextFields();
    }//GEN-LAST:event_countCbActionPerformed

    private void minCbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minCbActionPerformed
        // TODO add your handling code here:
        setHavingTextFields();
    }//GEN-LAST:event_minCbActionPerformed

    private void maxCbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maxCbActionPerformed
        // TODO add your handling code here:
        setHavingTextFields();
    }//GEN-LAST:event_maxCbActionPerformed

    private void sumCbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sumCbActionPerformed
        // TODO add your handling code here:
        setHavingTextFields();
    }//GEN-LAST:event_sumCbActionPerformed

    private void averageCbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_averageCbActionPerformed
        // TODO add your handling code here:
        setHavingTextFields();
    }//GEN-LAST:event_averageCbActionPerformed

    private void maxHavingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maxHavingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maxHavingActionPerformed

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
            java.util.logging.Logger.getLogger(Summary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Summary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Summary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Summary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new Summary(null, null, null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox appointStatus;
    private javax.swing.JCheckBox average;
    private javax.swing.JCheckBox averageCb;
    private javax.swing.JTextField averageHaving;
    private javax.swing.JLabel backButton;
    private javax.swing.JCheckBox clientFullName;
    private javax.swing.JLabel confirmButton;
    private javax.swing.JCheckBox count;
    private javax.swing.JCheckBox countCb;
    private javax.swing.JTextField countHaving;
    private javax.swing.JLabel header;
    private javax.swing.JCheckBox max;
    private javax.swing.JCheckBox maxCb;
    private javax.swing.JTextField maxHaving;
    private javax.swing.JCheckBox min;
    private javax.swing.JCheckBox minCb;
    private javax.swing.JTextField minHaving;
    private javax.swing.JLabel minimizeButton;
    private javax.swing.JCheckBox petGender;
    private javax.swing.JCheckBox petName;
    private javax.swing.JCheckBox petOrigin;
    private javax.swing.JCheckBox petSize;
    private javax.swing.JCheckBox petStatus;
    private javax.swing.JCheckBox petType;
    private javax.swing.JCheckBox sum;
    private javax.swing.JCheckBox sumCb;
    private javax.swing.JTextField sumHaving;
    private javax.swing.JLabel summaryBg;
    private javax.swing.JPanel summaryPanel;
    private javax.swing.JTable summaryTable;
    private javax.swing.JScrollPane summaryTableScroll;
    private javax.swing.JCheckBox vetFullName;
    // End of variables declaration//GEN-END:variables
}
