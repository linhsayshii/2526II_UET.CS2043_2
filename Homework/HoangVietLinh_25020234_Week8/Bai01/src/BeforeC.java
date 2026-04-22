// Đoạn C - TRƯỚC refactor
// Code smell: Long Parameter List + Replace Conditional with Polymorphism
public class BeforeC {
    public double getArea(String shapeType, double a, double b) {
        if (shapeType.equals("rectangle")) return a * b;
        if (shapeType.equals("triangle"))  return 0.5 * a * b;
        if (shapeType.equals("circle"))    return 3.14159 * a * a;
        return -1;
    }
}
