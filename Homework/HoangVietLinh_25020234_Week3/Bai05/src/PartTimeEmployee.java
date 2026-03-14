class PartTimeEmployee extends Employee {
    private int workingHours;
    private double hourlyRate;
    public PartTimeEmployee(String name, int workingHours, double hourlyRate) {
        super(name);
        this.workingHours = workingHours;
        this.hourlyRate = hourlyRate;
    }
    public String getType() {
        return "Part-time";
    }
    public double getSalary() {
        return workingHours * hourlyRate;
    }
}