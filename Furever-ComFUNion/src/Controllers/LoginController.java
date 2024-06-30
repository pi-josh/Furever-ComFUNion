/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Views.Login;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;

/**
 *
 * @author joshu
 */
public class LoginController {
    private final Login view;

    public LoginController(Login view) {
        this.view = view;
        attachEventHandlers();
        
        view.resetErrorMessage();
    }

    private void attachEventHandlers() {
        view.getLoginButton().addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                view.loginButtonActionPerformed();
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                view.getLoginButton().setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/login acc hover.png")));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                view.getLoginButton().setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/login acc.png")));
            }
        });

        view.getRegisterButton().addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resetLoginView();
                view.registerButtonMouseClicked(evt);
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                view.getRegisterButton().setForeground(Color.RED);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                view.getRegisterButton().setForeground(new java.awt.Color(99, 71, 12));
            }
        });

        view.getUsernameField().addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
                    evt.consume();
                    view.loginButtonActionPerformed();
                } else if (evt.getKeyChar() == KeyEvent.VK_TAB) {
                    evt.consume();
                }
            }
        });

        view.getPasswordField().addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
                    evt.consume();
                    view.loginButtonActionPerformed();
                } else if (evt.getKeyChar() == KeyEvent.VK_TAB) {
                    evt.consume();
                }
            }
        });

        view.getBackButton().addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resetLoginView();
                view.setVisible(false);
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                view.getBackButton().setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/back button hover (1).png")));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                view.getBackButton().setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/back button (1).png")));
            }
        });

        view.getMinimizeButton().addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                view.setState(JFrame.ICONIFIED);
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                view.getMinimizeButton().setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/minimize button hover (1).png")));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                view.getMinimizeButton().setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/minimize button (1).png")));
            }
        });
    }
    
    private void resetLoginView() {
        view.getUsernameField().setText(""); // Clear username field
        view.getPasswordField().setText(""); // Clear password field
        view.resetErrorMessage(); // Reset error message
    }

}