import java.util.List;

public class Room extends Human{
    protected String         description;
    protected Location       location;
    protected List<Location> adjacent;
    protected List<Player>   people;
    protected List<Thing>    things;

    public Room(String description, Location location, List<Location> adjacent,
                List<Player> people, List<Thing> things)
    {
        this.description = description;
        this.location = location;
        this.adjacent = adjacent;
        this.people = people;
        this.things = things;
    }

    /* getters */
    public Location       getLocation(){ return location; }
    public List<Location> getAdjacentRooms(){ return adjacent; }
    public List<Player>   getPlayers(){ return people; }
    public List<Thing>    getThings(){ return things; }

    public String looks(){
        System.out.println("you are in the " + getLocation() + ", the room contains " + things + ", you may exit to either one of " + getAdjacentRooms());
        // return a string describing the room
        // (what is in it, what exits you have, etc)
        return this.toString();
    }


    public void addPlayer(Player p){
        this.people.add(p);
    }

    public void removePlayer(Player p){
        this.people.remove(p);
    }

    /** add a thing t to the current room */
    public void addThing(Thing t){
        this.things.add(t);
    }



    @Override
    public String toString(){
        return description;
    }
}
