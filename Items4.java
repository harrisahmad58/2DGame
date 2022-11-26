import java.util.List;
import java.util.Scanner;

/**
 * Created by Shahid on 2017-11-20.
 */
public class Items4 extends Thing{

    public Items4 (String name, Location location, int value, int e){
        super(name, location, value, e);
    }



    @Override
    public void interact() {
        if(this.getLocation() == location.getWorld().furnace) {
            Scanner I1 = new Scanner(System.in);
            System.out.println("There is a Power Core on the ground, do you want it (press p) if not (press n)");
            String answer = I1.next();
            String x = this.getName();
            if (answer.equals("p")) {
                System.out.println("the Power Core is in your bag now");
                this.getLocation().getWorld().getFurnace().getWorld().getPowerCore();
                this.getLocation().getWorld().getFurnace();
            } else {
                System.out.println("move on");
            }
        }
    }
}