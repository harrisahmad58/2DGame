public class World{
    protected Room[][] rooms;
    protected Location entrance;
    protected Location hallway;
    protected Location closet;
    protected Location basment;
    protected Location mainRoom;
    protected Location furnace;
    protected Location cellar;
    protected Location wineCellar;
    protected Location generator;
    protected Thing    goal;
    protected Thing Armour;
    protected Thing PowerCore;
    protected Thing StrangeItem;
    protected Thing shield;


    public World(){
        Room r1 = new Room("The Enterance", new Location(this,0,0),
                new java.util.ArrayList<Location>(),
                new java.util.ArrayList<Player>(),
                new java.util.ArrayList<Thing>());
        Room r2 = new Room("Main Hallway", new Location(this,0,1),
                new java.util.ArrayList<Location>(),
                new java.util.ArrayList<Player>(),
                new java.util.ArrayList<Thing>());
        Room r3 = new Room("Tool Closet", new Location(this,0,2),
                new java.util.ArrayList<Location>(),
                new java.util.ArrayList<Player>(),
                new java.util.ArrayList<Thing>());
        Room r4 = new Room("Basement Entrance", new Location(this,1,0),
                new java.util.ArrayList<Location>(),
                new java.util.ArrayList<Player>(),
                new java.util.ArrayList<Thing>());
        Room r5 = new Room("Basement Main Room", new Location(this,1,1),
                new java.util.ArrayList<Location>(),
                new java.util.ArrayList<Player>(),
                new java.util.ArrayList<Thing>());
        Room r6 = new Room("Basement Furnace", new Location(this,1,2),
                new java.util.ArrayList<Location>(),
                new java.util.ArrayList<Player>(),
                new java.util.ArrayList<Thing>());
        Room r7 = new Room("Cellar Entrance", new Location(this,2,0),
                new java.util.ArrayList<Location>(),
                new java.util.ArrayList<Player>(),
                new java.util.ArrayList<Thing>());
        Room r8 = new Room("Wine Cellar", new Location(this,2,1),
                new java.util.ArrayList<Location>(),
                new java.util.ArrayList<Player>(),
                new java.util.ArrayList<Thing>());
        Room r9 = new Room("Generator Room", new Location(this,2,2),
                new java.util.ArrayList<Location>(),
                new java.util.ArrayList<Player>(),
                new java.util.ArrayList<Thing>());

        r1.getAdjacentRooms().add(r2.getLocation());
        r1.getAdjacentRooms().add(r4.getLocation());
        r2.getAdjacentRooms().add(r1.getLocation());
        r2.getAdjacentRooms().add(r3.getLocation());
        r2.getAdjacentRooms().add(r5.getLocation());
        r3.getAdjacentRooms().add(r2.getLocation());
        r4.getAdjacentRooms().add(r1.getLocation());
        r4.getAdjacentRooms().add(r5.getLocation());
        r4.getAdjacentRooms().add(r7.getLocation());
        r5.getAdjacentRooms().add(r2.getLocation());
        r5.getAdjacentRooms().add(r6.getLocation());
        r5.getAdjacentRooms().add(r8.getLocation());
        r5.getAdjacentRooms().add(r4.getLocation());
        r6.getAdjacentRooms().add(r3.getLocation());
        r6.getAdjacentRooms().add(r5.getLocation());
        r6.getAdjacentRooms().add(r9.getLocation());
        r7.getAdjacentRooms().add(r4.getLocation());
        r7.getAdjacentRooms().add(r8.getLocation());
        r8.getAdjacentRooms().add(r7.getLocation());
        r8.getAdjacentRooms().add(r5.getLocation());
        r8.getAdjacentRooms().add(r9.getLocation());
        r9.getAdjacentRooms().add(r8.getLocation());
        r9.getAdjacentRooms().add(r6.getLocation());

        rooms = new Room[3][3];
        rooms[0][0] = r1;
        rooms[0][1] = r2;
        rooms[0][2] = r3;
        rooms[1][0] = r4;
        rooms[1][1] = r5;
        rooms[1][2] = r6;
        rooms[2][0] = r7;
        rooms[2][1] = r8;
        rooms[2][2] = r9;

        entrance = r1.getLocation();
        hallway = r2.getLocation();
        closet = r3.getLocation();
        basment = r4.getLocation();
        mainRoom = r5.getLocation();
        furnace = r6.getLocation();
        cellar = r7.getLocation();
        wineCellar = r8.getLocation();
        generator = r9.getLocation();


        goal = new Items("thing", generator, 1, 7);
        r9.addThing(goal);

        Armour = new Items("green bread", basment, 2, 6);
        r4.addThing(Armour);

        PowerCore = new Items4("Power Core", furnace, 2, 8);
        r6.addThing(PowerCore);

        StrangeItem = new Items3("Strange Item", closet, 3, 5);
        r3.addThing(StrangeItem);

        shield = new Item2("Shield", mainRoom, 2, 4);
        r5.addThing(shield);

    }

    public World(String worldFileName){

        // create world described in file worldFileName
    }

    public Location getEntrance(){
        return entrance;
    }

    public Location getHallway() {
        return hallway;
    }

    public Location getCloset() {
        return closet;
    }

    public Location getBasment() {
        return basment;
    }

    public Location getMainRoom() {
        return mainRoom;
    }

    public Location getFurnace() {
        return furnace;
    }

    public Location getCellar() {
        return cellar;
    }

    public Location getWineCellar() {
        return wineCellar;
    }

    public Location getGenerator() {
        return generator;
    }

    public Thing getGoal(){ return goal;}

    public Thing getArmour() {return Armour;}

    public Thing getPowerCore() { return PowerCore;}

    public Thing getStrangeItem() { return StrangeItem;}

    public Thing getShield() {return  shield;}
    /** returns room of spcified Player */
    public Room getRoom(Player p){
        int r = p.getLocation().getRow();
        int c = p.getLocation().getCol();
        return rooms[r][c];
    }
    /** returns room of specified location
     *
     * @return the room that this is at this location in this world.
     *         Returns null if there is no such room.
     */
    public Room getRoom(Location location){
        return rooms[location.getRow()][location.getCol()];
    }
}