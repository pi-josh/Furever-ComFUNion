/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Views.LandingPage;
import Views.UserLoggedIn;

/**
 *
 * @author joshu
 */
public class Main {
    public static void main(String[] args) {
        LandingPage landingPage = new LandingPage(true);
        UserLoggedIn userLoggedIn = new UserLoggedIn();
        landingPage.setVisible(true);
        // userLoggedIn.setVisible(true);
    }
}

