public class Main {
    public static void main(String[] args) {
        String name = "Nguyen Van A";
        double baseSalary = 15000000;
        int workDays = 22;
        int totalDays = 26;
        double taxRate = 0.15;
        double bonus = 2000000;

        System.out.println("========== TRƯỚC REFACTOR ==========");
        BeforePayroll before = new BeforePayroll();
        before.printPayroll(name, baseSalary, workDays, totalDays, taxRate, bonus);

        System.out.println();

        System.out.println("========== SAU REFACTOR ==========");
        AfterPayroll after = new AfterPayroll();
        after.printPayroll(name, baseSalary, workDays, totalDays, taxRate, bonus);
    }
}
