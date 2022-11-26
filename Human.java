import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/** A human (user) players in the game */

public class Human extends Player{

    private static boolean verbose = true; // set true for debugging
    // set false for submitted code

    /** Creates a player in the game
     *
     * @param w is the world that the player lives in
     * @param name is the name of the player
     * @param location is where in the world the player is
     * @param health is the health of the player (which may or may not be relevant in your game)
     * @param things is a list of Thing objects that the player initially possesses
     * @param goal is the Thing that the human player is trying to retrieve in the game
     */
    public Human(World w, String name, Location location, int health,
                 List<Thing>  things, Thing goal){
        super(w, name, location, health, things, goal);
    }
    public Human(){}


    /** Plays a turn for this player
     *
     * For computer players will have the AI for that player.
     * For human player querie user for input and then react
     * appropriately for the input.
     */
    @Override
    public void play(){
        if(verbose){System.err.println("the room as " + w.getRoom(getLocation()).getPlayers() + " players");}
        if(verbose){System.err.println("the room as " + w.getRoom(getLocation()).getThings() + " things");}
        Scanner in = new Scanner(System.in);
        System.out.print("What would you like to do? [type h <enter>] ");
        String action = in.nextLine();
        if( action.trim().equals("h") ){
            help();
        }else if(action.trim().equals("l") ){
            look();
        }else if(action.trim().charAt(0) == 'g'){
            switch( action.trim().charAt(action.trim().length()-1) ){
                case 'e' :
                    if(verbose){System.err.print("human was in " + this.getLocation());}
                    this.w.getRoom(this.getLocation()).removePlayer(this);
                    this.setLocation( this.getLocation().east() );
                    if(this.getLocation().getCol() > 2){
                        System.out.println("you may not go there!!");
                        this.setLocation( this.getLocation().west() );
                    }
                    else{
                        this.w.getRoom(this.getLocation()).addPlayer(this);
                        if(verbose){System.err.print("human now in " + this.getLocation());}
                        break;
                    }
                    this.w.getRoom(this.getLocation()).addPlayer(this);
                    if(verbose){System.err.print("human now in " + this.getLocation());}
                    break;
                case 'w' :
                    if(verbose){System.err.print("human was in " + this.getLocation());}
                    this.w.getRoom(this.getLocation()).removePlayer(this);
                    this.setLocation( this.getLocation().west() );
                    if(this.getLocation().getCol() < 0){
                        System.out.println("you may not go there!!");
                        this.setLocation( this.getLocation().east() );
                    }
                    else{
                        this.w.getRoom(this.getLocation()).addPlayer(this);
                        if(verbose){System.err.print("human now in " + this.getLocation());}
                        break;
                    }
                    this.w.getRoom(this.getLocation()).addPlayer(this);
                    if(verbose){System.err.print("human now in " + this.getLocation());}
                    break;
                case 's' :
                    if(verbose){System.err.print("human was in " + this.getLocation());}
                    this.w.getRoom(this.getLocation()).removePlayer(this);
                    this.setLocation( this.getLocation().south() );
                    if(this.getLocation().getRow() > 2){
                        System.out.println("you may not go there!!");
                        this.setLocation( this.getLocation().north() );
                    }
                    else{
                        this.w.getRoom(this.getLocation()).addPlayer(this);
                        if(verbose){System.err.print("human now in " + this.getLocation());}
                        break;
                    }
                    this.w.getRoom(this.getLocation()).addPlayer(this);
                    if(verbose){System.err.print("human now in " + this.getLocation());}
                    break;
                case 'n' :
                    if(verbose){System.err.print("human was in " + this.getLocation());}
                    this.w.getRoom(this.getLocation()).removePlayer(this);
                    this.setLocation( this.getLocation().north() );
                    if(this.getLocation().getRow() < 0){
                        System.out.println("you may not go there!!");
                        this.setLocation( this.getLocation().south() );
                    }
                    else{
                        this.w.getRoom(this.getLocation()).addPlayer(this);
                        if(verbose){System.err.print("human now in " + this.getLocation());}
                        break;
                    }
                    this.w.getRoom(this.getLocation()).addPlayer(this);
                    if(verbose){System.err.print("human now in " + this.getLocation());}
                    break;
            }

        }
        else if(action.trim().equals("hl")){
            health();
        }
        else if(action.trim().equals("in")){
            interact();
        }
        else if(action.trim().equals("things")){
            listThings();
        }
        else if(action.trim().equals("exit")){
            exit();
        }
        if (this.getHealth() == 0) {
            System.out.println("sorry but you died ur health went to 0...");
            System.exit(0);
        } else if (this.things.contains(getWorld().PowerCore)) {
            if (this.getLocation().getRow() == 2 && this.getLocation().getCol() == 2) {
                System.out.println("you have brought back the power core congratulation you win...");
                System.exit(0);
            }
        }

    }

    public void exit(){
        System.out.println("thanks for playing!!");
        System.exit(0);
    }

    public List<Thing> listThings(){
        System.out.println(this.getThings());
        if (this.getThings().isEmpty()){
            return things;
        }
        else if (this.things.contains(getWorld().Armour)){
            Scanner I1 = new Scanner(System.in);
            System.out.println("you have bread would you like to eat it enter 'yes' or 'no': ");
            String answer = I1.next();
            if(answer.equals("yes")){
                System.out.println("ahh! the bread was poisoned find the doctor to heal press 'hl' to see current health: ");
                setHealth(getHealth()/2);
                removeThing(this.getWorld().Armour);
            }
            else{
                System.out.println("use it any time continue for now;)");
            }
        }
        else if (this.things.contains(getWorld().StrangeItem)){
            Scanner I3 = new Scanner(System.in);
            System.out.println("you have a strange item would you like to examine it enter 'yes' or 'no': ");
            String answer = I3.next();
            if(answer.equals("yes")){
                System.out.println("Oh no! you have been transported back to the entrance! ");
                this.setLocation(getWorld().entrance);
                removeThing(this.getWorld().StrangeItem);
            }
            else{
                System.out.println("check it out whenever you want to;)");
            }
        }
        else if(this.things.contains(getWorld().shield)){
            Scanner I2 = new Scanner(System.in);
            System.out.println("would you like to wield your shield 'yes' or 'no': ");									//
            String answer = I2.next();																					//
            if(answer.equals("yes")){																					//
                System.out.println("You now wield the shield ");														//
                setHealth(getHealth() + 25);																			//
                removeThing(this.getWorld().shield);																	//
            }
            else{
                System.out.println("use it any time continue for now;)");												//
            }
        }
        else {
            return things;
        }
        return things;
    }

    public void interact(){
        if(this.getLocation().getRow() == 1 && this.getLocation().getCol() == 0) {
            String x = this.getLocation().getWorld().getArmour().getName();
            Scanner I1 = new Scanner(System.in);
            System.out.println("there is some " + x + " on the floor do you want it (press p) if not (press n)");
            String answer = I1.next();
            if (answer.equals("p")) {
                System.out.println("the bread is in your bag now press 'things' to see");
                this.addThing(getWorld().Armour);
            } else {
                System.out.println("move on");
            }
        }
        else if(this.getLocation().getRow() == 1 && this.getLocation().getCol() == 2)
        {
            Scanner I4 = new Scanner(System.in);
            System.out.println("There is a Power Core on the ground do you want it? (press p) if not (press n)");
            String answer = I4.next();
            if(answer.equals("p"))
            {
                System.out.println("The Power Core is now in your bag, type 'things' to see");
                this.addThing(getWorld().PowerCore);
                this.getLocation().getWorld().getFurnace().getWorld().getFurnace();
            }else
            {
                System.out.println("Moving on");
            }
        }
        else if(this.getLocation().getRow() == 0 && this.getLocation().getCol() == 2){
            Scanner I3= new Scanner(System.in);
            System.out.println("There is a Strange item on the floor do you want to risk it? (press p) if not (press n)");
            String answer = I3.next();
            if(answer.equals("p"))
            {
                System.out.println("The Strange item is now in your bag, type 'things' to see");
                this.addThing(getWorld().StrangeItem);
                this.getLocation().getWorld().getCloset().getWorld().getCloset();
            }else
            {
                System.out.println("Moving on");
            }
        }
        else if(this.getLocation().getRow() == 1 && this.getLocation().getCol() == 1) {
            Scanner I2 = new Scanner(System.in);
            System.out.println("there is a shield on the floor do you want it (press s) if not (press n)");				//
            String answer = I2.next();																					//
            if (answer.equals("s")) {
                System.out.println("you now have the shield now press 'things' to see");								//
                this.addThing(getWorld().shield);
                this.getLocation().getWorld().getMainRoom().getWorld().getShield().setValue(0);							//
            } else {
                System.out.println("move on");
            }																											//
        }
    }

    public int health(){
        int x = getHealth();
        System.out.println(x);
        return x;
    }

    public void look(){
        String y = w.getRoom(getLocation()).getAdjacentRooms().toString();
        String x = w.getRoom(getLocation()).getThings().toString();
        String s = "You are currently in ";
        s += w.getRoom(getLocation()).toString();
        System.out.println(s);
        System.out.println("the room contains " + x + ", you may exit to either one of " + y );
    }

    public void help(){
        System.out.println("Hi your objective is to get the PowerCore in ur bag and reach the generator room (2,2)goodLuck!");
        String s = "Your options are:\n ";
        s += "'h' for help \n ";
        s += "'l' to look around the room and see where you can go \n ";
        s += "'g x' to go in direction x (x can be n,e,w,s) \n ";
        s += "'w' to list what you have \n ";
        s += "'hl' to display your current health \n";
        s += " 'in' use this if there is a thing in the room to interact with it \n";
        s += " 'things' for list of items \n";
        s += " 'exit' to exit game \n";
        System.out.println(s);
    }

}