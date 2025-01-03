/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Views.ExitDialog;
import Views.LandingPage;
import Views.UserLoggedIn;
import Views.VetLoggedIn;
import javax.swing.JPanel;

/**
 *
 * @author joshu
 */
public class ExitDialogController {
    private ExitDialog view = null;
    private LandingPage landingPage = null;
    private UserLoggedIn userLoggedIn = null;
    private VetLoggedIn vetLoggedIn = null;

    public ExitDialogController(ExitDialog view, LandingPage landingPage, UserLoggedIn userLoggedIn, VetLoggedIn vetLoggedIn) {
        if(view != null) {
            this.view = view;
        }
        if(userLoggedIn != null) {
            this.userLoggedIn = userLoggedIn;
        } else if(vetLoggedIn != null) {
            this.vetLoggedIn = vetLoggedIn;
        } else if(landingPage != null) {
            this.landingPage = landingPage;
        }

        // Initialize event listeners or additional logic here if needed
        initEventHandlers();
    }

    private void initEventHandlers() {
        view.getYesButton().addMouseListener(new java.awt.event.MouseAdapter() {
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

        view.getNoButton().addMouseListener(new java.awt.event.MouseAdapter() {
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
    }

    private void yesButtonMouseClicked(java.awt.event.MouseEvent evt) {
        view.dispose();
        System.exit(0);
    }

    private void noButtonMouseClicked(java.awt.event.MouseEvent evt) {
        if (landingPage != null) {
            view.setGlassPaneVisible((JPanel) landingPage.getGlassPane(), false);
        }

        if (userLoggedIn != null) {
            view.setGlassPaneVisible((JPanel) userLoggedIn.getGlassPane(), false);
        }
        if (vetLoggedIn != null) {
            view.setGlassPaneVisible((JPanel) vetLoggedIn.getGlassPane(), false);
        }
        view.setVisible(false);
    }

    private void yesButtonMouseEntered(java.awt.event.MouseEvent evt) {
        view.getYesButton().setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/yes button hover (1).png")));
    }

    private void yesButtonMouseExited(java.awt.event.MouseEvent evt) {
        view.getYesButton().setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/yes button (1).png")));
    }

    private void noButtonMouseEntered(java.awt.event.MouseEvent evt) {
        view.getNoButton().setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/no button hover (1).png")));
    }

    private void noButtonMouseExited(java.awt.event.MouseEvent evt) {
        view.getNoButton().setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/no button (1).png")));
    }
}
