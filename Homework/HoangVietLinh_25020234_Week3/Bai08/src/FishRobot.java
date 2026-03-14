public class FishRobot extends Robot implements Swimmable {
    public FishRobot(int id, String modelName) {
        super(id, modelName);
    }
    @Override
    public void swim() {
        System.out.println("The fish robot is swimming.");
    }
    @Override
    public void performMainTask() {
        System.out.println("The FishRobot is Performing ...");
        swim();
    }
}
