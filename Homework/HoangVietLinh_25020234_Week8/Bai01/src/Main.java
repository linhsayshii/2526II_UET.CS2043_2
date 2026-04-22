public class Main {
    public static void main(String[] args) {
        System.out.println("=== ĐOẠN A: Trước refactor ===");
        BeforeA beforeA = new BeforeA();
        System.out.println("Fee (no member): " + beforeA.calculateFee("hourly", 8, 50.0, false));
        System.out.println("Fee (member):    " + beforeA.calculateFee("hourly", 8, 50.0, true));

        System.out.println("\n=== ĐOẠN A: Sau refactor ===");
        AfterA afterA = new AfterA();
        System.out.println("Fee (no member): " + afterA.calculateFee("hourly", 8, 50.0, false));
        System.out.println("Fee (member):    " + afterA.calculateFee("hourly", 8, 50.0, true));

        System.out.println("\n=== ĐOẠN C: Trước refactor ===");
        BeforeC beforeC = new BeforeC();
        System.out.println("Rectangle 5x3: " + beforeC.getArea("rectangle", 5, 3));
        System.out.println("Triangle 5x3:  " + beforeC.getArea("triangle", 5, 3));
        System.out.println("Circle r=4:    " + beforeC.getArea("circle", 4, 0));

        System.out.println("\n=== ĐOẠN C: Sau refactor ===");
        Shape rectangle = new Rectangle(5, 3);
        Shape triangle = new Triangle(5, 3);
        Shape circle = new Circle(4);
        System.out.println("Rectangle 5x3: " + rectangle.getArea());
        System.out.println("Triangle 5x3:  " + triangle.getArea());
        System.out.println("Circle r=4:    " + circle.getArea());

        System.out.println("\n=== ĐOẠN D: Sau refactor ===");
        Author author = new Author("admin@uet.vn", "Nguyen Van A", "0123456789", "Ha Noi");
        Report report = new Report("Bao cao tuan 8", "Noi dung bao cao...", author);
        System.out.println("Title: " + report.getTitle());
        System.out.println("Author: " + report.getAuthor().getName()
                + " - " + report.getAuthor().getEmail());
    }
}
