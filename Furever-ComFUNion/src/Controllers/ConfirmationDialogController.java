/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Views.ConfirmationDialog;
import Views.UserLoggedIn;
import Views.VetLoggedIn;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.CountDownLatch;

/**
 *
 * @author joshu
 */
public class ConfirmationDialogController {
    private final ConfirmationDialog dialog;
    private UserLoggedIn userLoggedIn = (UserLoggedIn) null;
    private VetLoggedIn vetLoggedIn = (VetLoggedIn) null;
    private final CountDownLatch latch;

    public ConfirmationDialogController(ConfirmationDialog dialog, UserLoggedIn userLoggedIn, VetLoggedIn vetLoggedIn, CountDownLatch latch) {
        this.dialog = dialog;
        if(userLoggedIn != null) {
            this.userLoggedIn = userLoggedIn;
        } else if(vetLoggedIn != null) {
            this.vetLoggedIn = vetLoggedIn;
        }
        this.latch = latch;

        initializeListeners();
    }

    private void initializeListeners() {
        dialog.getYesButton().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                handleYesButtonClick();
            }

            @Override
            public void mouseEntered(MouseEvent evt) {
                dialog.getYesButton().setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/yes button hover (1).png")));
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                dialog.getYesButton().setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/yes button (1).png")));
            }
        });

        dialog.getNoButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                handleNoButtonClick();
            }

            @Override
            public void mouseEntered(MouseEvent evt) {
                dialog.getNoButton().setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/no button hover (1).png")));
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                dialog.getNoButton().setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/no button (1).png")));
            }
        });
    }

    private void handleYesButtonClick() {
        if (userLoggedIn != null) {
            // Example action: hide glass pane
            dialog.getGlassPane().setVisible(false);
        } else if(vetLoggedIn != null) {
            dialog.getGlassPane().setVisible(false);
        }
        dialog.setUserResponse(true);
        latch.countDown(); // Release the latch
        dialog.setVisible(false);
    }

    private void handleNoButtonClick() {
        if (userLoggedIn != null) {
            // Example action: hide glass pane
            dialog.getGlassPane().setVisible(false);
        } else if(vetLoggedIn != null) {
            dialog.getGlassPane().setVisible(false);
        }
        dialog.setUserResponse(false);
        latch.countDown(); // Release the latch
        dialog.setVisible(false);
    }
}
