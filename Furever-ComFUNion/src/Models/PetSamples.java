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
    private Pet cassyyy = new Pet(007, "Dog", "O", "NA", "S", 4, "Cassyyy", "M", 6, 6, "/Resources/sample pets/dog.png");
    private Pet gigi = new Pet(006, "Cat", "R", "NA", "M", 6, "Gigi", "F", 0, 5, "/Resources/sample pets/cat.png");
    private Pet hammy = new Pet(005, "Hamster", "O", "A", "T", 3, "Hammy", "M", 1, 5, "/Resources/sample pets/hamster.png");
    private Pet adjie = new Pet(004, "Rabbit", "R", "NA", "T", 15, "Adjie", "M", 0, 4, "/Resources/sample pets/rabbit.png");
    private Pet cooper = new Pet(003, "Dog", "O", "NA", "M", 7, "Cooper", "M", 2, 4, "/Resources/sample pets/dog.png");
    private Pet juswa = new Pet(002, "Cat", "O", "A", "L", 9, "Juswa", "M", 3, 4, "/Resources/sample pets/cat.png");
    private Pet raphael = new Pet(001, "Dog", "R", "A", "M", 2, "Raphael", "M", 0, 4, "/Resources/sample pets/dog.png");
    
    public ArrayList<Pet> getAllPets() {
        ArrayList<Pet> pets = new ArrayList<>();
        
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
