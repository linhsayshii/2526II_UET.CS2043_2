import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Robot> robots = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of robots: ");
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.print("Enter robot " + (i + 1) + ": ");
            String line = sc.nextLine().trim();
            String[] parts = line.split("\\s+");
            String type = parts[0];
            int id = Integer.parseInt(parts[1]);
            String modelName = parts[2];
            if (type.equalsIgnoreCase("DR")) {
                robots.add(new DroneRobot(id, modelName));
            } else if (type.equalsIgnoreCase("FR")) {
                robots.add(new FishRobot(id, modelName));
            } else if (type.equalsIgnoreCase("AR")) {
                robots.add(new AmphibiousRobot(id, modelName));
            } else {
                System.out.println("Invalid robot type: " + type);
            }
        }
        for (Robot robot : robots) {
            robot.performMainTask();
            System.out.println("--------------------");
        }

        System.out.println("--------------------------------");
        Robot r1 = robots.get(0); // DroneRobot
        ((DroneRobot) r1).fly(); // Cast to DroneRobot để gọi phương thức fly()
        Robot r2 = robots.get(1); // FishRobot
        if (r2 instanceof Flyable) {
            ((Flyable) r2).fly(); 
        } else {
            System.out.println("This r2 robot cannot fly.");
        }
    }
}
