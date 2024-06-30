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
public class ClientSamples {
    private Client joshua = new Client(1, "tunaw123", "John Joshua Macatunao", 19, "81 Pouros Grove, Suite 091, 64822-2475, East Jaronfurt, Iowa, United States", "9892865657", "jjmelt@yahoo.com", "Photographer", "69000", "Melt Studio", "T");
    private Client katrina = new Client(2, "tara8ball", "Katrina Halili", 20, "095 Loy Divide, Suite 919, 70892, Hansenstad, Wyoming, United States", "9652655123", "akonaman@gmail.com", "NASA Scientist", "405000", "NASA", "NT");
    private Client joly = new Client(3, "jawlineislife", "Joly Gonzaga", 31, "Poblacion, Baliuag, Bulacan, Philippines", "9652235242", "McWater@yahoo.com", "Gym Instructor", "51000", "FItness Inc.", "NT");
    private Client mark = new Client(4, "shhh!!!", "Mark Quiet", 21, "826 Loyal Point, Suite 753, 37394-6564, Kuphalton, Ohio, United States", "9528652421", "marktahimik@gmail.com", "Senior Software Engineer", "375635", "Microsoft", "NT");
    private Client randy = new Client(5, "r.a.n.d.i.", "Randy Fernandez", 24, "77828 Towne Knoll, Suite 229, 24698-7170, Burniceburgh, West Virginia, United States", "9652234242", "Power.Fernandez01@y8mail.com", "Senior Fraud Analyst", "93290", "HSBC", "NT");

    public ArrayList<Client> getAllClients() {
        ArrayList<Client> clients = new ArrayList<>();
        
        clients.add(joshua);
        clients.add(katrina);
        clients.add(joly);
        clients.add(mark);
        clients.add(randy);

        return clients;
    }
    
    
}
