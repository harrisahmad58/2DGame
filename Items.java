import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Shahid on 2017-11-20.
 */
public class Items extends Thing{
    public Items(){}

    public Items (String name, Location location, int value, int e){
        super(name, location, value, e);
    }



    @Override
    public void interact() {
        if(this.getLocation() == location.getWorld().basment) {
            Scanner I1 = new Scanner(System.in);
            System.out.println("there is some bread on the floor do you want it (press p) if not (press n)");
            String answer = I1.next();
            String x = this.getName();
            if (answer.equals("p")) {
                System.out.println("the bread is in your bag now");
                this.getLocation().getWorld().getBasment().getWorld().getArmour().setValue(0);
                this.getLocation().getWorld().getArmour();
            } else {
                System.out.println("move on");
            }
        }
    }
}
