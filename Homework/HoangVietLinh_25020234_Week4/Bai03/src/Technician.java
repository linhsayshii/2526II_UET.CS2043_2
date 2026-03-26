public class Technician extends Employee {
    protected double overtimeHours;
    public Technician(String id, String name, double baseSalary, double overtimeHours) {
        super(id, name, baseSalary);
        this.overtimeHours = overtimeHours;
    }
    @Override
    public void work() {
        System.out.println("Lắp đặt thiết bị");
    }

    @Override
    public double calculatePay() {
        return baseSalary + (overtimeHours * 20000 + baseSalary);
    }
}
