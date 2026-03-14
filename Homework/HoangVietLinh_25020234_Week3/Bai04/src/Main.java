public class Main {
    public static void main(String[] args) {
        // Bước 1: Upcasting (An toàn)
        Animal a = new Dog(); // Dog kế thừa Animal (lấy từ Bài 2)
        // Bước 2: Downcasting (Rủi ro) - Hãy viết dòng này:
        if (a instanceof Cat) {
            Cat c = (Cat) a;
            // Bước 3: Gọi hàm
            c.makeSound();
        } else {
            System.err.println("Đây không phải là Mèo!");
        }

    }
}