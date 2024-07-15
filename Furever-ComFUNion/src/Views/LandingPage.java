package Views;

import Controllers.ConfirmationDialogController;
import Controllers.ExitDialogController;
import Controllers.LoginController;
import Controllers.RegisterController;
import Models.Pet;
import Models.SPManager;
import java.awt.MediaTracker;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

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

    // Database manager
    SPManager spManager = new SPManager();

    // Pet records
    ArrayList<Pet> pets;
    private int totalPets;
    private int totalPetsToDisplay;
    private int petIndex = 0;

    // filter and sorting conditions
    private List<String> petTypes = new ArrayList<>();
    private List<String> petOrigins = new ArrayList<>();
    private List<String> petStatuses = new ArrayList<>();
    private List<String> petSizes = new ArrayList<>();
    private List<String> petGenders = new ArrayList<>();
    private List<String> sortCriteria = new ArrayList<>();

    // for sorting priority
    ArrayList<JCheckBox> sortingPriority = new ArrayList<>();

    // for moving the frame
    private Point mouseDownCompCoords;

    // controllers
    ExitDialogController exitController;
    ConfirmationDialogController confirmationController;
    RegisterController registerController;
    LoginController loginController;

    // for confirmation dialog
    boolean userResponse;

    // sub frames
    private ExitDialog exitDialog;
    private BusinessRules businessRulesFrame;
    private Devs devsFrame;
    private Summary summaryFrame;
    private Login login;
    private Register register;
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
    private int FAQsPanelCounter = 0;
    private int totalFAQsPanels = 4;
    private Timer timer;

    /**
     * Creates new form Main
     *
     * @param logout
     */
    public LandingPage(boolean logout) {
        initComponents();

        // get all initial data from the database
        populatePetsFromDB();
        totalPetsToDisplay = spManager.getAllPetsCount();

        // default
        defaultWindow();

        // hide other panels
        navBar.setVisible(false);
        homeBody.setVisible(false);
        aboutUsBody.setVisible(false);
        petsBody.setVisible(false);
        FAQsBody.setVisible(false);

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

        if (!logout) {
            // Create a timer to stop the GIF after 6 seconds
            timer = new Timer(15000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    startupAnimationPanel.setVisible(false);
                    navBar.setVisible(true);
                    homeBody.setVisible(true);
                    timer.stop(); // Stop the timer
                }
            });
            timer.setRepeats(false); // Ensure the timer only runs once

            // Start the timer
            timer.start();
        } else {
            startupAnimationPanel.setVisible(false);
            navBar.setVisible(true);
            homeBody.setVisible(true);
        }

        // glass pane to block out any interaction within the main frame when opening a sub frame
        glassPane = new JPanel();
        glassPane.setOpaque(false);
        glassPane.setVisible(false);
        glassPane.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // brings the active sub frame on the front and add a system beep to notify
                if (exitDialog != null && exitDialog.isVisible()) {
                    exitDialog.toFront();
                    Toolkit.getDefaultToolkit().beep(); // Play default system beep
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
                
                // for summary in home panel
                if (summaryFrame != null && summaryFrame.isVisible()) {
                    summaryFrame.toFront();
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        });

        setGlassPane(glassPane);
    }

    // getters
    public Login getLogin() {
        return login;
    }

    public Register getRegister() {
        return register;
    }

    private void defaultWindow() {
        // set pet count
        adoptedCounter.setText(String.valueOf(totalPetsToDisplay));

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

        // button icons
        homeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/home click.png")));

        // for FAQs panels' visibility
        FAQsPanel1.setVisible(true);
        FAQsPanel2.setVisible(false);
        FAQsPanel3.setVisible(false);
        FAQsPanel4.setVisible(false);
    }

    private void populatePetsFromDB() {
        // QUERY HERE: filtering and sorting pet profiles based on the selected checkboxes
        this.pets = spManager.getFilteredSortedPets(petTypes, petOrigins, petStatuses, petSizes, petGenders, sortCriteria);  // returns all pets that meets the criteria
        totalPets = pets.size();
    }

    private void updatePanelVisibility(boolean home, boolean aboutUs, boolean faqs, boolean pets, boolean vets, boolean application, boolean profile) {
        homeBody.setVisible(home);
        aboutUsBody.setVisible(aboutUs);
        FAQsBody.setVisible(faqs);
        petsBody.setVisible(pets);
    }

    private void updateClickBackgroundVisibility(boolean home, boolean aboutUs, boolean faqs, boolean pets, boolean vets, boolean application) {
        homeClick.setVisible(home);
        aboutUsClick.setVisible(aboutUs);
        faqClick.setVisible(faqs);
        petClick.setVisible(pets);
    }

    private void updateButtonIcons(String homeIcon, String aboutUsIcon, String faqIcon, String petIcon, String vetIcon, String applicationIcon, String profileHeadIcon, String profileCollarIcon) {
        homeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(homeIcon)));
        aboutUsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(aboutUsIcon)));
        faqButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(faqIcon)));
        petButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(petIcon)));
    }

    private void updateClickabilityFlags(boolean home, boolean aboutUs, boolean faqs, boolean pets, boolean vets, boolean application, boolean profile) {
        homeClicked = home;
        aboutUsClicked = aboutUs;
        FAQsClicked = faqs;
        petsClicked = pets;
    }

    private void handleHomeButtonClick() {
        // update count of pets
        totalPetsToDisplay = spManager.getAllPetsCount();
        adoptedCounter.setText(String.valueOf(totalPetsToDisplay));

        updatePanelVisibility(true, false, false, false, false, false, false);
        updateClickBackgroundVisibility(true, false, false, false, false, false);
        homeClick.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/click bg.png")));
        line.setBackground(new java.awt.Color(255, 251, 209));
        updateClickabilityFlags(true, false, false, false, false, false, false);
        updateButtonIcons("/Resources/home click.png", "/Resources/about us.png", "/Resources/FAQs.png", "/Resources/pets.png", "/Resources/vets.png", "/Resources/application.png", "/Resources/head.png", "/Resources/collar.png");
    }

    private void handleAboutUsButtonClick() {
        updatePanelVisibility(false, true, false, false, false, false, false);
        updateClickBackgroundVisibility(false, true, false, false, false, false);
        aboutUsClick.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/click bg.png")));
        line.setBackground(new java.awt.Color(255, 251, 209));
        updateClickabilityFlags(false, true, false, false, false, false, false);
        updateButtonIcons("/Resources/home.png", "/Resources/about us click.png", "/Resources/FAQs.png", "/Resources/pets.png", "/Resources/vets.png", "/Resources/application.png", "/Resources/head.png", "/Resources/collar.png");
    }

    private void handleFaqButtonClick() {
        updatePanelVisibility(false, false, true, false, false, false, false);
        updateClickBackgroundVisibility(false, false, true, false, false, false);
        faqClick.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/click bg.png")));
        line.setBackground(new java.awt.Color(255, 251, 209));
        updateClickabilityFlags(false, false, true, false, false, false, false);
        updateButtonIcons("/Resources/home.png", "/Resources/about us.png", "/Resources/FAQs click.png", "/Resources/pets.png", "/Resources/vets.png", "/Resources/application.png", "/Resources/head.png", "/Resources/collar.png");
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
    }

    private void initializeFAQsPanel() {
        FAQsPanelCounter = 0;
        setFAQsPanelVisibility(FAQsPanelCounter);
        updateButtonVisibility();
    }

    private void FAQsChangePanel(String button) {
        if (button.equals("next")) {
            if (FAQsPanelCounter < totalFAQsPanels - 1) {
                FAQsPanelCounter++;
            }
        } else if (button.equals("prev")) {
            if (FAQsPanelCounter > 0) {
                FAQsPanelCounter--;
            }
        }

        setFAQsPanelVisibility(FAQsPanelCounter);
        updateButtonVisibility();
    }

    private void updateButtonVisibility() {
        prev.setVisible(FAQsPanelCounter > 0);
        next.setVisible(FAQsPanelCounter < totalFAQsPanels - 1);
    }

    private void setFAQsPanelVisibility(int panel) {
        FAQsPanel1.setVisible(panel == 0);
        FAQsPanel2.setVisible(panel == 1);
        FAQsPanel3.setVisible(panel == 2);
        FAQsPanel4.setVisible(panel == 3);
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
            petAge1.setText(String.valueOf(pets.get(petIndex).getPetAge()));
            petGender1.setText(pets.get(petIndex).getPetSex());
            petImg1.setIcon(new javax.swing.ImageIcon(getClass().getResource(pets.get(petIndex).getPicURL())));
            petURL1 = pets.get(petIndex).getPicURL();
            petIndex++;
        }

        // Pet Panel 2
        if (totalPets >= 2) {
            petName2.setText(pets.get(petIndex).getPetName());
            petAge2.setText(String.valueOf(pets.get(petIndex).getPetAge()));
            petGender2.setText(pets.get(petIndex).getPetSex());
            petImg2.setIcon(new javax.swing.ImageIcon(getClass().getResource(pets.get(petIndex).getPicURL())));
            petURL2 = pets.get(petIndex).getPicURL();
            petIndex++;
        }

        // Pet Panel 3
        if (totalPets >= 3) {
            petName3.setText(pets.get(petIndex).getPetName());
            petAge3.setText(String.valueOf(pets.get(petIndex).getPetAge()));
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
                petAges[i].setText(String.valueOf(pets.get(petIndex + i).getPetAge()));
                petGenders[i].setText(pets.get(petIndex + i).getPetSex());
                petImages[i].setIcon(new javax.swing.ImageIcon(getClass().getResource(pets.get(petIndex + i).getPicURL())));
            }
        }

        // Show or hide navigation buttons based on totalPets and petIndex
        petPrev.setVisible(petIndex > 0);
        petNext.setVisible(totalPets > 3 && petIndex < totalPets - 3);
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
        for (int i = 1; i <= petPanels.length && i < totalPets; i++) {
            petPanels[i - 1].setVisible(hide);
            for (JLabel component : petComponents[i - 1]) {
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
        }

        String pOrigin = "", pStatus = "", pSize = "";

        String origin = "";
        String status = "";
        String size = "";

        int diff = 2;
        // Update pet panel 1 based on selected panel
        switch (panel) {
            case 1:
                if (totalPets == 1) {
                    diff = 1;
                }
                origin = pets.get(petIndex - diff).getPetOrigin();
                status = pets.get(petIndex - diff).getPetStatus();
                size = pets.get(petIndex - diff).getPetSize();

                switch (origin.toUpperCase().charAt(0)) {
                    case 'O':
                        pOrigin = "Owned";
                        break;
                    case 'R':
                        pOrigin = "Rescued";
                        break;
                }

                if (status.toUpperCase().equals("NA")) {
                    pStatus = "Not Adopted";
                } else if (status.equals("A")) {
                    petAdoptButton.setVisible(false);
                    pStatus = "Adopted";
                }

                switch (size.toUpperCase().charAt(0)) {
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

                petID.setText(String.valueOf(pets.get(petIndex - diff).getPetID()));
                petType.setText(String.valueOf(pets.get(petIndex - diff).getPetType()));
                petOrigin.setText(pOrigin);
                petStatus.setText(pStatus);
                petSize.setText(pSize);
                break;
            case 2:
                diff = 1;
                // Display pet panel 2 information on panel 1     
                origin = pets.get(petIndex - diff).getPetOrigin();
                status = pets.get(petIndex - diff).getPetStatus();
                size = pets.get(petIndex - diff).getPetSize();

                switch (origin.toUpperCase().charAt(0)) {
                    case 'O':
                        pOrigin = "Owned";
                        break;
                    case 'R':
                        pOrigin = "Rescued";
                        break;
                }

                if (status.toUpperCase().equals("NA")) {
                    pStatus = "Not Adopted";
                } else if (status.equals("A")) {
                    petAdoptButton.setVisible(false);
                    pStatus = "Adopted";
                }

                switch (size.toUpperCase().charAt(0)) {
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
                petID.setText(String.valueOf(pets.get(petIndex - diff).getPetID()));
                petType.setText(String.valueOf(pets.get(petIndex - diff).getPetType()));
                petOrigin.setText(pOrigin);
                petStatus.setText(pStatus);
                petSize.setText(pSize);
                break;
            case 3:
                // Display pet panel 3 information on panel 1
                origin = pets.get(petIndex).getPetOrigin();
                status = pets.get(petIndex).getPetStatus();
                size = pets.get(petIndex).getPetSize();

                switch (origin.toUpperCase().charAt(0)) {
                    case 'O':
                        pOrigin = "Owned";
                        break;
                    case 'R':
                        pOrigin = "Rescued";
                        break;
                }

                if (status.toUpperCase().equals("NA")) {
                    pStatus = "Not Adopted";
                } else if (status.toUpperCase().equals("A")) {
                    petAdoptButton.setVisible(false);
                    pStatus = "Adopted";
                }

                switch (size.toUpperCase().charAt(0)) {
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

    private void petFilterBySortBy() {
        // filter
        petTypes.removeAll(petTypes);
        petOrigins.removeAll(petOrigins);
        petStatuses.removeAll(petStatuses);
        petSizes.removeAll(petSizes);
        petGenders.removeAll(petGenders);
        sortCriteria.removeAll(sortCriteria);

        JCheckBox[] types = {dogType, catType, hamsterType, rabbitType};
        JCheckBox[] origins = {rescuedOrigin, ownedOrigin};
        JCheckBox[] statuses = {adoptedStatus, notAdoptedStatus};
        JCheckBox[] sizes = {tinySize, smallSize, mediumSize, largeSize};
        JCheckBox[] genders = {femaleGender, maleGender};

        for (JCheckBox type : types) {
            if (type.isSelected()) {
                petTypes.add(type.getText());
            }
        }

        for (JCheckBox origin : origins) {
            if (origin.isSelected()) {
                petOrigins.add(origin.getText());
            }
        }

        for (JCheckBox status : statuses) {
            if (status.isSelected()) {
                petStatuses.add(status.getText());
            }
        }

        for (JCheckBox size : sizes) {
            if (size.isSelected()) {
                petSizes.add(size.getText());
            }
        }

        for (JCheckBox gender : genders) {
            if (gender.isSelected()) {
                petGenders.add(gender.getText());
            }
        }

        // sort and display the priority level
        JCheckBox checkBox;
        for (int i = 0; i < sortingPriority.size(); i++) {
            checkBox = sortingPriority.get(i);
            sortCriteria.add(checkBox.getText());

            if (checkBox.equals(orderByID)) {
                IDprio.setText(String.valueOf(i + 1));
            } else if (checkBox.equals(orderByName)) {
                namePrio.setText(String.valueOf(i + 1));
            } else if (checkBox.equals(orderByAge)) {
                agePrio.setText(String.valueOf(i + 1));
            }
        }

        populatePetsFromDB();
        petProfilesReset();
        petProfiles();
    }
    
    private void resetPetsFilterSortBy() {
        JCheckBox[] checkboxes = { dogType, catType, hamsterType, rabbitType,
                                   ownedOrigin, rescuedOrigin,
                                   adoptedStatus, notAdoptedStatus,
                                   tinySize, smallSize, mediumSize, largeSize,
                                   femaleGender, maleGender,
                                   orderByID, orderByName, orderByAge,
                                   IDdescending, nameDescending, ageDescending };
        for(JCheckBox checkbox : checkboxes) {
            checkbox.setSelected(false);
        }
        orderByIDActionPerformed(null);
        orderByNameActionPerformed(null);
        orderByAgeActionPerformed(null);
        petFilterBySortBy();
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
        startupAnimationPanel = new javax.swing.JPanel();
        startupAnimation = new javax.swing.JLabel();
        navBar = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        line = new javax.swing.JPanel();
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
        exitButton = new javax.swing.JLabel();
        minimizeButton = new javax.swing.JLabel();
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
        namePrio = new javax.swing.JLabel();
        agePrio = new javax.swing.JLabel();
        IDprio = new javax.swing.JLabel();
        sortBy = new javax.swing.JLabel();
        filterBy = new javax.swing.JLabel();
        background3 = new javax.swing.JLabel();
        FAQsBody = new javax.swing.JPanel();
        prev = new javax.swing.JLabel();
        next = new javax.swing.JLabel();
        FAQsPanel1 = new javax.swing.JLabel();
        FAQsPanel2 = new javax.swing.JLabel();
        FAQsPanel3 = new javax.swing.JLabel();
        FAQsPanel4 = new javax.swing.JLabel();
        background2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Furever ComFUNion");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(1370, 879));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        startupAnimationPanel.setBackground(new java.awt.Color(0, 0, 0));
        startupAnimationPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        startupAnimationPanel.setPreferredSize(new java.awt.Dimension(1370, 880));
        startupAnimationPanel.setLayout(new java.awt.GridBagLayout());

        startupAnimation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/startup.gif"))); // NOI18N
        startupAnimationPanel.add(startupAnimation, new java.awt.GridBagConstraints());

        getContentPane().add(startupAnimationPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 880));

        navBar.setBackground(new java.awt.Color(194, 144, 69));
        navBar.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
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
        navBar.add(homeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 65, -1, -1));

        homeClick.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/click bg.png"))); // NOI18N
        navBar.add(homeClick, new org.netbeans.lib.awtextra.AbsoluteConstraints(515, 50, -1, -1));

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
        navBar.add(aboutUsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 65, -1, -1));

        aboutUsClick.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/click bg.png"))); // NOI18N
        navBar.add(aboutUsClick, new org.netbeans.lib.awtextra.AbsoluteConstraints(635, 50, -1, -1));

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
        navBar.add(faqButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 65, -1, -1));

        faqClick.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/click bg.png"))); // NOI18N
        navBar.add(faqClick, new org.netbeans.lib.awtextra.AbsoluteConstraints(755, 50, -1, -1));

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
        navBar.add(registerButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 45, -1, -1));

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
        navBar.add(minimizeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 10, 40, 20));

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
                adoptedLabelbadgeKeyPressed(evt);
            }
        });
        homeBody.add(adoptedLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(875, 490, 350, 50));

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
        hamsterType.setText("Hamster");
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
        rabbitType.setText("Rabbit");
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
        rescuedOrigin.setText("R");
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
        adoptedStatus.setText("A");
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
        tinySize.setText("T");
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
        maleGender.setText("M");
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
        ownedOrigin.setText("O");
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
        notAdoptedStatus.setText("NA");
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
        smallSize.setText("S");
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
        femaleGender.setText("F");
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
        mediumSize.setText("M");
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
        largeSize.setText("L");
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
        catType.setText("Cat");
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
        dogType.setText("Dog");
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
        orderByName.setFont(new java.awt.Font("Tahoma", 0, 1)); // NOI18N
        orderByName.setText("petName");
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
        petsBody.add(orderByName, new org.netbeans.lib.awtextra.AbsoluteConstraints(982, 78, 15, 15));

        orderByAge.setBackground(new java.awt.Color(255, 255, 255));
        orderByAge.setFont(new java.awt.Font("Tahoma", 0, 1)); // NOI18N
        orderByAge.setText("petAge");
        orderByAge.setBorder(null);
        orderByAge.setContentAreaFilled(false);
        orderByAge.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        orderByAge.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        orderByAge.setIconTextGap(0);
        orderByAge.setMargin(new java.awt.Insets(0, 0, 0, 0));
        orderByAge.setPreferredSize(new java.awt.Dimension(30, 30));
        orderByAge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderByAgeActionPerformed(evt);
            }
        });
        petsBody.add(orderByAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(982, 106, 15, 15));

        orderByID.setBackground(new java.awt.Color(255, 255, 255));
        orderByID.setFont(new java.awt.Font("Tahoma", 0, 1)); // NOI18N
        orderByID.setText("petID");
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
        petsBody.add(orderByID, new org.netbeans.lib.awtextra.AbsoluteConstraints(982, 51, 15, 15));

        IDdescending.setBackground(new java.awt.Color(255, 255, 255));
        IDdescending.setFont(new java.awt.Font("Tahoma", 0, 1)); // NOI18N
        IDdescending.setText("DESC");
        IDdescending.setBorder(null);
        IDdescending.setContentAreaFilled(false);
        IDdescending.setEnabled(false);
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
        petsBody.add(IDdescending, new org.netbeans.lib.awtextra.AbsoluteConstraints(1111, 50, 15, 15));

        nameDescending.setBackground(new java.awt.Color(255, 255, 255));
        nameDescending.setFont(new java.awt.Font("Tahoma", 0, 1)); // NOI18N
        nameDescending.setText("DESC");
        nameDescending.setToolTipText("");
        nameDescending.setBorder(null);
        nameDescending.setContentAreaFilled(false);
        nameDescending.setEnabled(false);
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
        petsBody.add(nameDescending, new org.netbeans.lib.awtextra.AbsoluteConstraints(1111, 77, 15, 15));

        ageDescending.setBackground(new java.awt.Color(255, 255, 255));
        ageDescending.setFont(new java.awt.Font("Tahoma", 0, 1)); // NOI18N
        ageDescending.setText("DESC");
        ageDescending.setToolTipText("");
        ageDescending.setBorder(null);
        ageDescending.setContentAreaFilled(false);
        ageDescending.setEnabled(false);
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
        petsBody.add(ageDescending, new org.netbeans.lib.awtextra.AbsoluteConstraints(1111, 106, 15, 15));

        namePrio.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        namePrio.setForeground(new java.awt.Color(255, 255, 255));
        namePrio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        namePrio.setToolTipText("");
        petsBody.add(namePrio, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 78, 15, 15));

        agePrio.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        agePrio.setForeground(new java.awt.Color(255, 255, 255));
        agePrio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        agePrio.setToolTipText("");
        petsBody.add(agePrio, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 106, 15, 15));

        IDprio.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        IDprio.setForeground(new java.awt.Color(255, 255, 255));
        IDprio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IDprio.setToolTipText("");
        petsBody.add(IDprio, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 51, 15, 15));

        sortBy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/sort by.png"))); // NOI18N
        petsBody.add(sortBy, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 10, 540, 140));

        filterBy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/filter by.png"))); // NOI18N
        petsBody.add(filterBy, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 540, 140));

        background3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/paw prints.png"))); // NOI18N
        petsBody.add(background3, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 0, 1366, 738));

        getContentPane().add(petsBody, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 139, 1370, 740));

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
        FAQsBody.add(FAQsPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 20, 1000, 700));

        background2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/paw prints.png"))); // NOI18N
        FAQsBody.add(background2, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 0, 1366, 738));

        getContentPane().add(FAQsBody, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 139, 1370, 740));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
        if (login != null) {
            if (login.getRegister() != null) {
                register = login.getRegister();
            }
            login.setVisible(false);
        }

        if (register == null) {
            register = new Register(this);
            registerController = new RegisterController(register);
            register.setVisible(true);
        } else if (!register.isVisible()) {
            register.setVisible(true);
        } else {
            register.toFront();
            register.requestFocus();
        }
    }//GEN-LAST:event_registerButtonMouseClicked

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
        if (register != null) {
            if (register.getLogin() != null) {
                login = register.getLogin();
            }
            register.setVisible(false);
        }
        if (login == null) {
            login = new Login(this);
            loginController = new LoginController(login);
            login.setVisible(true);
        } else if (!login.isVisible()) {
            login.setVisible(true);
        } else {
            login.toFront();
            login.requestFocus();
        }
    }//GEN-LAST:event_loginButtonMouseClicked

    private void logoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoMouseClicked
        // TODO add your handling code here:
        handleHomeButtonClick();
    }//GEN-LAST:event_logoMouseClicked

    private void logoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoMousePressed
        // TODO add your handling code here:
        handleHomeButtonClick();
    }//GEN-LAST:event_logoMousePressed

    private void logoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoMouseReleased
        // TODO add your handling code here:
        handleHomeButtonClick();
    }//GEN-LAST:event_logoMouseReleased

    private void exitButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitButtonMouseClicked
        // TODO add your handling code here:
        if (exitDialog == null || !exitDialog.isVisible()) {
            exitDialog = new ExitDialog(this, null, null);
            exitController = new ExitDialogController(exitDialog, this, null, null);
            exitDialog.setVisible(true);
            glassPane.setVisible(true);
        } else {
            exitDialog.toFront();
            exitDialog.requestFocus();
        }
    }//GEN-LAST:event_exitButtonMouseClicked

    private void exitButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitButtonMouseEntered
        // TODO add your handling code here:
        exitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/exit button hover (1).png")));
    }//GEN-LAST:event_exitButtonMouseEntered

    private void exitButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitButtonMouseExited
        // TODO add your handling code here:
        exitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/exit button (1).png")));
    }//GEN-LAST:event_exitButtonMouseExited

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

    private void navBarMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_navBarMouseDragged
        // TODO add your handling code here:
        Point currCoords = evt.getLocationOnScreen();
        setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);
    }//GEN-LAST:event_navBarMouseDragged

    private void navBarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_navBarMousePressed
        // TODO add your handling code here:
        mouseDownCompCoords = evt.getPoint();
    }//GEN-LAST:event_navBarMousePressed

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

    private void badgeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_badgeMousePressed
        // TODO add your handling code here:
        if (!petsClicked) {
            handlePetButtonClick();
            petProfiles();
        }
    }//GEN-LAST:event_badgeMousePressed

    private void devsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_devsMouseClicked
        // TODO add your handling code here:
        if (devsFrame == null || !devsFrame.isVisible()) {
            devsFrame = new Devs(this, null, null);
            devsFrame.setVisible(true);
            glassPane.setVisible(true);
        } else {
            devsFrame.toFront();
            devsFrame.requestFocus();
        }
    }//GEN-LAST:event_devsMouseClicked

    private void devsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_devsMouseEntered
        // TODO add your handling code here:
        devs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/about us dev hover.png")));
    }//GEN-LAST:event_devsMouseEntered

    private void devsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_devsMouseExited
        // TODO add your handling code here:
        devs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/about us dev (1).png")));
    }//GEN-LAST:event_devsMouseExited

    private void businessRulesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_businessRulesMouseClicked
        // TODO add your handling code here:
        if (businessRulesFrame == null || !businessRulesFrame.isVisible()) {
            businessRulesFrame = new BusinessRules(this, null, null);
            businessRulesFrame.setVisible(true);
            glassPane.setVisible(true);
        } else {
            businessRulesFrame.toFront();
            businessRulesFrame.requestFocus();
        }
    }//GEN-LAST:event_businessRulesMouseClicked

    private void businessRulesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_businessRulesMouseEntered
        // TODO add your handling code here:
        businessRules.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/about us business rule hover.png")));
    }//GEN-LAST:event_businessRulesMouseEntered

    private void businessRulesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_businessRulesMouseExited
        // TODO add your handling code here:
        businessRules.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/about us business rule (1).png")));
    }//GEN-LAST:event_businessRulesMouseExited

    private void prevMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prevMouseClicked
        // TODO add your handling code here:
        FAQsChangePanel("prev");
        handleFaqButtonClick();
    }//GEN-LAST:event_prevMouseClicked

    private void prevMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prevMouseEntered
        // TODO add your handling code here:
        prev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/prev button hover (1).png")));
    }//GEN-LAST:event_prevMouseEntered

    private void prevMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prevMouseExited
        // TODO add your handling code here:
        prev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/prev button (1).png")));
    }//GEN-LAST:event_prevMouseExited

    private void nextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextMouseClicked
        // TODO add your handling code here:
        FAQsChangePanel("next");
        handleFaqButtonClick();
    }//GEN-LAST:event_nextMouseClicked

    private void nextMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextMouseEntered
        // TODO add your handling code here:
        next.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/next button hover (1).png")));
    }//GEN-LAST:event_nextMouseEntered

    private void nextMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextMouseExited
        // TODO add your handling code here:
        next.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/next button (1).png")));
    }//GEN-LAST:event_nextMouseExited

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

    private void petPrevMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_petPrevMouseEntered
        // TODO add your handling code here:
        petPrev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/prev button hover (1).png")));
    }//GEN-LAST:event_petPrevMouseEntered

    private void petPrevMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_petPrevMouseExited
        // TODO add your handling code here:
        petPrev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/prev button (1).png")));
    }//GEN-LAST:event_petPrevMouseExited

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

    private void petNextMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_petNextMouseEntered
        // TODO add your handling code here:
        petNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/next button hover (1).png")));
    }//GEN-LAST:event_petNextMouseEntered

    private void petNextMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_petNextMouseExited
        // TODO add your handling code here:
        petNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/next button (1).png")));
    }//GEN-LAST:event_petNextMouseExited

    private void petPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_petPanel1MouseClicked
        // TODO add your handling code here:
        hidePetPanels(false);
        setCurrentPetPanel(1);
    }//GEN-LAST:event_petPanel1MouseClicked

    private void petPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_petPanel2MouseClicked
        // TODO add your handling code here:
        hidePetPanels(false);
        setCurrentPetPanel(2);

    }//GEN-LAST:event_petPanel2MouseClicked

    private void petPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_petPanel3MouseClicked
        // TODO add your handling code here:
        hidePetPanels(false);
        setCurrentPetPanel(3);

    }//GEN-LAST:event_petPanel3MouseClicked

    private void petBackButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_petBackButtonMouseClicked
        // TODO add your handling code here:
        hidePetPanels(true);
        setCurrentPetPanel(0);
        petPanel1Clicked = false;
    }//GEN-LAST:event_petBackButtonMouseClicked

    private void petBackButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_petBackButtonMouseEntered
        // TODO add your handling code here:
        petBackButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/back button hover (2).png")));
    }//GEN-LAST:event_petBackButtonMouseEntered

    private void petBackButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_petBackButtonMouseExited
        // TODO add your handling code here:
        petBackButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/back button (2).png")));
    }//GEN-LAST:event_petBackButtonMouseExited

    private void petAdoptButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_petAdoptButtonMouseClicked
        // TODO add your handling code here:
        if (register != null) {
            if (register.getLogin() != null) {
                login = register.getLogin();
            }
            register.setVisible(false);
        }
        if (login == null) {
            login = new Login(this);
            loginController = new LoginController(login);
            login.setVisible(true);
        } else if (!login.isVisible()) {
            login.setVisible(true);
        } else {
            login.toFront();
            login.requestFocus();
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

    private void catTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_catTypeActionPerformed
        // TODO add your handling code here:
        petFilterBySortBy();
    }//GEN-LAST:event_catTypeActionPerformed

    private void dogTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dogTypeActionPerformed
        // TODO add your handling code here:
        petFilterBySortBy();
    }//GEN-LAST:event_dogTypeActionPerformed

    private void orderByNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderByNameActionPerformed
        // TODO add your handling code here:
        if (orderByName.isSelected()) {
            sortingPriority.add(orderByName);
            nameDescending.setEnabled(true);
        } else if (sortingPriority != null) {
            // remove checkbox if exist
            for (JCheckBox attr : sortingPriority) {
                if (attr.equals(orderByName)) {
                    sortingPriority.remove(attr);
                    break;
                }
            }

            // reset text
            namePrio.setText("");

            // unselect descending if checked and call the corresponding listener
            if (nameDescending.isSelected()) {
                nameDescending.setSelected(false);
                nameDescending.setEnabled(false);
                nameDescendingActionPerformed(evt);
                return;
            }
        }
        if(!orderByName.isSelected()) {
            nameDescending.setSelected(false);
            nameDescending.setEnabled(false);
        }
        petFilterBySortBy();
    }//GEN-LAST:event_orderByNameActionPerformed

    private void orderByAgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderByAgeActionPerformed
        // TODO add your handling code here:
        if (orderByAge.isSelected()) {
            sortingPriority.add(orderByAge);
            ageDescending.setEnabled(true);
        } else if (sortingPriority != null) {
            // remove checkbox if found
            for (JCheckBox attr : sortingPriority) {
                if (attr.equals(orderByAge)) {
                    sortingPriority.remove(attr);
                    break;
                }
            }

            // reset text
            agePrio.setText("");

            // unselect descending if checked and call the corresponding listener
            if (ageDescending.isSelected()) {
                ageDescending.setSelected(false);
                ageDescending.setEnabled(false);
                ageDescendingActionPerformed(evt);
                return;
            }
        }
        if(!orderByAge.isSelected()) {
            ageDescending.setSelected(false);
            ageDescending.setEnabled(false);
        }
        petFilterBySortBy();
    }//GEN-LAST:event_orderByAgeActionPerformed

    private void orderByIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderByIDActionPerformed
        // TODO add your handling code here:
        if (orderByID.isSelected()) {
            IDdescending.setEnabled(true);
            sortingPriority.add(orderByID);
        } else if (sortingPriority != null) {
            // remove checkbox if found
            for (JCheckBox attr : sortingPriority) {
                if (attr.equals(orderByID)) {
                    sortingPriority.remove(attr);
                    break;
                }
            }

            // reset text
            IDprio.setText("");

            // unselect descending if checked and call the corresponding listener
            if (IDdescending.isSelected()) {
                IDdescending.setSelected(false);
                IDdescending.setEnabled(false);
                IDdescendingActionPerformed(evt);
                return;
            }
        }
        if(!orderByID.isSelected()) {
            IDdescending.setSelected(false);
            IDdescending.setEnabled(false);
        }
        petFilterBySortBy();
    }//GEN-LAST:event_orderByIDActionPerformed

    private void IDdescendingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDdescendingActionPerformed
        // TODO add your handling code here:
        if (IDdescending.isSelected()) {
            orderByID.setText("petID DESC");
        } else {
            orderByID.setText("petID");
        }
        petFilterBySortBy();
    }//GEN-LAST:event_IDdescendingActionPerformed

    private void nameDescendingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameDescendingActionPerformed
        // TODO add your handling code here:
        if (nameDescending.isSelected()) {
            orderByName.setText("petName DESC");
        } else {
            orderByName.setText("petName");
        }
        petFilterBySortBy();
    }//GEN-LAST:event_nameDescendingActionPerformed

    private void ageDescendingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ageDescendingActionPerformed
        // TODO add your handling code here:
        if (ageDescending.isSelected()) {
            orderByAge.setText("petAge DESC");
        } else {
            orderByAge.setText("petAge");
        }
        petFilterBySortBy();
    }//GEN-LAST:event_ageDescendingActionPerformed

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

    private void homeButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeButtonMousePressed
        // TODO add your handling code here:
        if (!homeClicked) {
            handleHomeButtonClick();
        }
    }//GEN-LAST:event_homeButtonMousePressed

    private void aboutUsButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutUsButtonMouseEntered
        // TODO add your handling code here:
        if (!aboutUsClicked) {
            aboutUsClick.setVisible(true);
            aboutUsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/about us hover.png")));
            line.setBackground(new java.awt.Color(226, 204, 163));
            aboutUsClick.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/click bg dark.png")));
        }
    }//GEN-LAST:event_aboutUsButtonMouseEntered

    private void aboutUsButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutUsButtonMouseExited
        // TODO add your handling code here:
        if (!aboutUsClicked) {
            aboutUsClick.setVisible(false);
            aboutUsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/about us.png")));
            line.setBackground(new java.awt.Color(255, 251, 209));
        }
    }//GEN-LAST:event_aboutUsButtonMouseExited

    private void aboutUsButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutUsButtonMousePressed
        // TODO add your handling code here:
        if (!aboutUsClicked) {
            handleAboutUsButtonClick();
        }
    }//GEN-LAST:event_aboutUsButtonMousePressed

    private void faqButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_faqButtonMouseEntered
        // TODO add your handling code here:
        if (!FAQsClicked) {
            faqClick.setVisible(true);
            faqButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/FAQs hover.png")));
            line.setBackground(new java.awt.Color(226, 204, 163));
            faqClick.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/click bg dark.png")));
        }
    }//GEN-LAST:event_faqButtonMouseEntered

    private void faqButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_faqButtonMouseExited
        // TODO add your handling code here:
        if (!FAQsClicked) {
            faqClick.setVisible(false);
            faqButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/FAQs.png")));
            line.setBackground(new java.awt.Color(255, 251, 209));
        }
    }//GEN-LAST:event_faqButtonMouseExited

    private void faqButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_faqButtonMousePressed
        // TODO add your handling code here:
        if (!FAQsClicked) {
            initializeFAQsPanel();
            handleFaqButtonClick();
        }
    }//GEN-LAST:event_faqButtonMousePressed

    private void petButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_petButtonMouseEntered
        // TODO add your handling code here:
        if (!petsClicked) {
            petClick.setVisible(true);
            petButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/pets hover.png")));
            line.setBackground(new java.awt.Color(226, 204, 163));
            petClick.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/click bg dark.png")));
        }
    }//GEN-LAST:event_petButtonMouseEntered

    private void petButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_petButtonMouseExited
        // TODO add your handling code here:
        if (!petsClicked) {
            petClick.setVisible(false);
            petButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/pets.png")));
            line.setBackground(new java.awt.Color(255, 251, 209));
        }
    }//GEN-LAST:event_petButtonMouseExited

    private void petButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_petButtonMousePressed
        // TODO add your handling code here:
        if (!petsClicked) {
            resetPetsFilterSortBy();
            handlePetButtonClick();
            petProfiles();
        }
    }//GEN-LAST:event_petButtonMousePressed

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
                new LandingPage(false).setVisible(true);
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
    private javax.swing.JLabel IDprio;
    private javax.swing.JPanel aboutUsBody;
    private javax.swing.JLabel aboutUsButton;
    private javax.swing.JLabel aboutUsClick;
    private javax.swing.JLabel aboutUsPanel;
    private javax.swing.JLabel adoptedCounter;
    private javax.swing.JLabel adoptedLabel;
    private javax.swing.JCheckBox adoptedStatus;
    private javax.swing.JCheckBox ageDescending;
    private javax.swing.JLabel agePrio;
    private javax.swing.JLabel background;
    private javax.swing.JLabel background1;
    private javax.swing.JLabel background2;
    private javax.swing.JLabel background3;
    private javax.swing.JLabel badge;
    private javax.swing.JLabel bulletin;
    private javax.swing.JLabel businessRules;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox catType;
    private javax.swing.JLabel devs;
    private javax.swing.JCheckBox dogType;
    private javax.swing.JLabel exitButton;
    private javax.swing.JLabel faqButton;
    private javax.swing.JLabel faqClick;
    private javax.swing.JCheckBox femaleGender;
    private javax.swing.JLabel filterBy;
    private javax.swing.JCheckBox hamsterType;
    private javax.swing.JPanel homeBody;
    private javax.swing.JLabel homeButton;
    private javax.swing.JLabel homeClick;
    private javax.swing.JCheckBox largeSize;
    private javax.swing.JPanel line;
    private javax.swing.JLabel loginButton;
    private javax.swing.JLabel logo;
    private javax.swing.JCheckBox maleGender;
    private javax.swing.JCheckBox mediumSize;
    private javax.swing.JLabel minimizeButton;
    private javax.swing.JCheckBox nameDescending;
    private javax.swing.JLabel namePrio;
    private javax.swing.JPanel navBar;
    private javax.swing.JLabel next;
    private javax.swing.JCheckBox notAdoptedStatus;
    private javax.swing.JCheckBox orderByAge;
    private javax.swing.JCheckBox orderByID;
    private javax.swing.JCheckBox orderByName;
    private javax.swing.JCheckBox ownedOrigin;
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
    private javax.swing.JCheckBox rabbitType;
    private javax.swing.JLabel registerButton;
    private javax.swing.JCheckBox rescuedOrigin;
    private javax.swing.JLabel slogan;
    private javax.swing.JCheckBox smallSize;
    private javax.swing.JLabel sortBy;
    private javax.swing.JLabel startupAnimation;
    private javax.swing.JPanel startupAnimationPanel;
    private javax.swing.JCheckBox tinySize;
    // End of variables declaration//GEN-END:variables
}
