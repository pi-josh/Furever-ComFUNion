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
public class PetSamples {
    // Pet #7
    private Pet cassyyy = new Pet(007, "Dog", "O", "NA", "S", 4, "Cassyyy", "M", 6, 6, "/Resources/sample pets/pochaco.jpg");
    private Pet gigi = new Pet(006, "Cat", "R", "NA", "M", 6, "Hammy", "M", 1, 1, "/Resources/sample pets/cinnamoroll.jpg");
    private Pet hammy = new Pet(005, "Hamster", "O", "A", "T", 3, "Hammy", "M", 1, 1, "/Resources/sample pets/kuromi.jpg");
    private Pet adjie = new Pet(004, "Rabbit", "R", "NA", "T", 15, "Hammy", "M", 1, 1, "/Resources/sample pets/keroppi.jpg");
    private Pet cooper = new Pet(003, "Dog", "O", "NA", "M", 7, "Hammy", "M", 1, 1, "/Resources/sample pets/hello kitty.jpg");
    private Pet juswa = new Pet(002, "Cat", "O", "A", "L", 9, "Hammy", "M", 1, 1, "/Resources/sample pets/my melody.jpg");
    private Pet raphael = new Pet(001, "Dog", "R", "A", "M", 2, "Hammy", "M", 1, 1, "/Resources/sample pets/pompompurin.jpg");
    
    public ArrayList<Pet> getAllPets() {
        ArrayList<Pet> pets = new ArrayList();
        
        pets.add(cassyyy);
        pets.add(gigi);
        pets.add(hammy);
        pets.add(adjie);
        pets.add(cooper);
        pets.add(juswa);
        pets.add(raphael);
        
        return pets;
    }
}