import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Shahid on 2017-11-20.
 */
public class Items3 extends Thing{
    public Items3(){}

    public Items3 (String name, Location location, int value, int e){
        super(name, location, value, e);
    }



    @Override
    public void interact() {
        if(this.getLocation() == location.getWorld().closet) {
            Scanner I3 = new Scanner(System.in);
            System.out.println("there is a strange item on the floor do you want to pick it up? (press p) if not (press n)");
            String answer = I3.next();
            String x = this.getName();
            if (answer.equals("p")) {
                System.out.println("the strange item is in your bag now");
                this.getLocation().getWorld().getCloset().getWorld().getStrangeItem().setValue(0);
                this.getLocation().getWorld().getStrangeItem();
            } else {
                System.out.println("move on");
            }
        }
    }
}
