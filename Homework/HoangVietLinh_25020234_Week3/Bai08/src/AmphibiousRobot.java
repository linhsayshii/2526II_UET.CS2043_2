public class AmphibiousRobot extends Robot implements Flyable, Swimmable, GPS {
    public AmphibiousRobot(int id, String modelName) {
        super(id, modelName);
    }
    public void fly() {
        System.out.println("The amphibious robot is flying.");
    }
    public void swim() {
        System.out.println("The amphibious robot is swimming.");
    }
    public void getCoordinates() {
        System.out.println("Getting GPS coordinates.");
    }
    @Override
    public void performMainTask() {
        System.out.println("The AmphibiousRobot is Performing ...");
        fly();
        swim();
        getCoordinates();
    }
    
}
