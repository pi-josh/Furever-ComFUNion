/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.ArrayList;

/**
 *
 * @author joshu
 */
public class VetSamples {
    private Veterinarian snoop = new Veterinarian(001, "pogiako123", "Snoop Dog", 52, "9124512315", "wildyoungfree@yahoo.com");
    private Veterinarian wally = new Veterinarian(002, "wallybayola17", "Wally Bayola", 51, "9632634189", "wallyeatbulaga@gmail.com");
    private Veterinarian coco = new Veterinarian(003, "angprobinsyano7", "Coco Martin", 42, "9326168234", "buhaypasicardo@gmail.comwildyoungfree@yahoo.com");
    private Veterinarian snoop1 = new Veterinarian(001, "pogiako123", "Snoop Dog1", 52, "9124512315 (1)", "wildyoungfree@yahoo.com");
    private Veterinarian wally1 = new Veterinarian(002, "wallybayola17", "Wally Bayola1", 51, "9632634189 (1)", "wallyeatbulaga@gmail.com");
    private Veterinarian coco1 = new Veterinarian(003, "angprobinsyano7", "Coco Martin1", 42, "9326168234 (1)", "buhaypasicardo@gmail.comwildyoungfree@yahoo.com");
    private Veterinarian snoop2 = new Veterinarian(001, "pogiako123", "Snoop Dog2", 52, "9124512315 (2)", "wildyoungfree@yahoo.com");
    private Veterinarian wally2 = new Veterinarian(002, "wallybayola17", "Wally Bayola2", 51, "9632634189 (2)", "wallyeatbulaga@gmail.com");
    private Veterinarian coco2 = new Veterinarian(003, "angprobinsyano7", "Coco Martin2", 42, "9326168234 (2)", "buhaypasicardo@gmail.comwildyoungfree@yahoo.com");
    
    public ArrayList<Veterinarian> getAllVeterinarians() {
        ArrayList<Veterinarian> vets = new ArrayList();
        
        vets.add(snoop);
        vets.add(wally);
        vets.add(coco);
        vets.add(snoop1);
        vets.add(wally1);
        vets.add(coco1);
        vets.add(snoop2);
        vets.add(wally2);
        vets.add(coco2);
        
        
        return vets;
    }
}
