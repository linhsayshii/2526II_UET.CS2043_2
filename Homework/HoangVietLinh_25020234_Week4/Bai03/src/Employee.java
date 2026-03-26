public abstract class Employee implements IWorkable {
    protected String id;
    protected String name;
    protected double baseSalary;
    public Employee(String id, String name, double baseSalary) {
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
    }
    public abstract double calculatePay();
    public String getName() {
        return name;
    }
}
interface IWorkable {
    void work();
}
