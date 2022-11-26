import java.util.List;
import java.util.Scanner;

public class Item2 extends Thing{
    public Item2(){}

    public Item2 (String name, Location location, int value, int e){
        super(name, location, value, e);
    }



    @Override
    public void interact() {
        if(this.getLocation() == location.getWorld().cellar) {
            Scanner I2 = new Scanner(System.in);
            System.out.println("there is a shield, if you want to pick it up(press p) if not (press n)");
            String answer = I2.next();
            String x = this.getName();
            if (answer.equals("p")) {
                System.out.println("you have a shield now");
                this.getLocation().getWorld().getCellar().getWorld().getShield().setValue(0);
                this.getLocation().getWorld().getShield();
            } else {
                System.out.println("keep going");
            }
        }
    }
}