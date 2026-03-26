import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LibrarySection<Book> book = new LibrarySection<>();
        LibrarySection<DVD> dvd = new LibrarySection<>();
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) {
                i--;
                continue;
            }
            String[] parts = line.split("\\s+");
            String type = parts[0];
            String id = parts[1];
            String name = parts[2];
            String val1 = parts[3];
            String val2 = parts[4];
            switch (type.toLowerCase()) {
                case "b" -> book.addItem(new Book(id, name, val1, Integer.parseInt(val2)));
                case "d" -> dvd.addItem(new DVD(id, name, val1, Integer.parseInt(val2)));
                default -> System.err.println("Unknown media type: " + type);
            }
        }

        System.out.println("--------------------------------------");
        System.out.println("Khu vực sách:");
        book.displayItems();
        System.out.println();
        System.out.println("Khu vực DVD:");
        dvd.displayItems();

    }
}
