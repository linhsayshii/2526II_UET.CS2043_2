public class Employee {
    private String name;
    protected double baseSalary;
    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }
    public double calculateBonus() {
        return baseSalary * 0.1;
    }
    public String getName() {
        return name;
    }
}
