public class Adventure{

    public static void main(String[] args){
        World world = new World();

        Player human = new Human(world, "cheeky", world.getEntrance(), 100,
                new java.util.ArrayList<Thing>(),
                world.getGoal());

        Player doctor = new Doctor(world, "Harris", world.getCellar());



        world.getRoom(world.getEntrance()).addPlayer(human);


        while(true){
            human.play();
            if(human.getLocation().getRow() == 2 && human.getLocation().getCol() == 0){
                doctor.play();
            }
            else{
                human.play();
            }
        }
    }
}
