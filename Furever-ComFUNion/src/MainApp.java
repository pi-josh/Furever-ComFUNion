/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Views.LandingPage;
// import Views.UserLoggedIn;

/**
 *
 * @author joshu
 */
public class MainApp {
    public static void main(String[] args) {
        LandingPage landingPage = new LandingPage(false);
        landingPage.setVisible(true);
        
        // UserLoggedIn userLoggedIn = new UserLoggedIn();
        // userLoggedIn.setVisible(true);
    }
}

