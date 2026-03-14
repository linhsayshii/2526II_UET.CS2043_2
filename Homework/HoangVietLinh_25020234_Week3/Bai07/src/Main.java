import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().trim();
        String[] parts = str.split("\\s+");
        String roomType = parts[0];
        int numberOfNights = Integer.parseInt(parts[1]);
        if (roomType.equalsIgnoreCase("S")) {
            StandardRoom room = new StandardRoom();
            System.out.println(room.getPrice(numberOfNights));
        } else if (roomType.equalsIgnoreCase("V")) {
            VIPRoom room = new VIPRoom();
            System.out.println(room.getPrice(numberOfNights));
        } else {
            System.out.println("Invalid room type");
        }
    }
}
