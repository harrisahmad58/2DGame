import java.util.List;
import java.util.Scanner;

import static sun.awt.FontConfiguration.verbose;

/**
 * Created by Shahid on 2017-12-06.
 */
public class Doctor extends Player{

    public Doctor(World w, String name, Location location){
        super(w, name, location);
    }

    public void play(){
        if(verbose){System.err.println("this room has" + w.getRoom(getLocation()).getPlayers() + " players");}
        Scanner in = new Scanner(System.in);
        System.out.print("you have come across the doctor press 'ip' for conversation");
        String action = in.nextLine();
        if(action.trim().equals("ip")){
            interact(this);
        }

    }

    public void interact(Player p){
        if(this.getLocation().getRow() == 2 && this.getLocation().getCol() == 0){
            Scanner p1 = new Scanner(System.in);
            System.out.println("hey are you in need of some medical attention press 'yes' or 'no'");
            String answer = p1.next();
            if(answer.equals("yes")){
                System.out.println("there you go all patched up take a look press 'hl' have a nice day");
                if(p.getHealth() == 100){
                    p.getHealth();
                }
                else if(p.getHealth() != 100){
                    p.setHealth(100);
                }
            }
            else{
                System.out.println("I guess I'll be on my way then see you around");
            }
        }
    }

}
