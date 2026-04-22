// Sau refactor - áp dụng:
// 1. Replace Magic Number with Constant
// 2. Extract Method: tách logic tính toán thành các phương thức riêng
// 3. Introduce Explaining Variable: dùng biến trung gian có tên rõ nghĩa
public class AfterPayroll {

    // --- Hằng số thay thế magic number ---
    private static final double SOCIAL_INSURANCE_RATE = 0.08;
    private static final double HEALTH_INSURANCE_RATE = 0.015;
    private static final double PERSONAL_DEDUCTION = 11_000_000;

    private static final double TAX_BRACKET_1_LIMIT = 5_000_000;
    private static final double TAX_BRACKET_2_LIMIT = 10_000_000;
    private static final double TAX_RATE_BRACKET_1 = 0.05;
    private static final double TAX_RATE_BRACKET_2 = 0.10;
    private static final double TAX_BRACKET_1_MAX = 250_000;
    private static final double TAX_BRACKET_2_MAX = 750_000;

    // --- Phương thức tính lương thực tế ---
    private double calculateActualSalary(double baseSalary, int workDays, int totalDays) {
        return baseSalary * workDays / totalDays;
    }

    // --- Phương thức tính bảo hiểm ---
    private double calculateInsurance(double actualSalary) {
        double socialInsurance = actualSalary * SOCIAL_INSURANCE_RATE;
        double healthInsurance = actualSalary * HEALTH_INSURANCE_RATE;
        return socialInsurance + healthInsurance;
    }

    // --- Phương thức tính thuế TNCN ---
    private double calculateTax(double actualSalary, double insurance, double taxRate) {
        double taxableIncome = actualSalary - insurance - PERSONAL_DEDUCTION;
        if (taxableIncome <= 0) {
            return 0;
        }
        if (taxableIncome <= TAX_BRACKET_1_LIMIT) {
            return taxableIncome * TAX_RATE_BRACKET_1;
        }
        if (taxableIncome <= TAX_BRACKET_2_LIMIT) {
            return TAX_BRACKET_1_MAX + (taxableIncome - TAX_BRACKET_1_LIMIT) * TAX_RATE_BRACKET_2;
        }
        return TAX_BRACKET_2_MAX + (taxableIncome - TAX_BRACKET_2_LIMIT) * taxRate;
    }

    // --- Phương thức tính lương thực nhận ---
    private double calculateNetSalary(double actualSalary, double insurance,
                                      double tax, double bonus) {
        return actualSalary - insurance - tax + bonus;
    }

    // --- printPayroll chỉ gọi phương thức con và in kết quả ---
    public void printPayroll(String name, double baseSalary,
                             int workDays, int totalDays,
                             double taxRate, double bonus) {
        System.out.println("=== BẢNG LƯƠNG ===");
        System.out.println("Nhân viên: " + name);

        double actualSalary = calculateActualSalary(baseSalary, workDays, totalDays);
        double insurance = calculateInsurance(actualSalary);
        double tax = calculateTax(actualSalary, insurance, taxRate);
        double netSalary = calculateNetSalary(actualSalary, insurance, tax, bonus);

        System.out.println("Lương cơ bản: " + baseSalary);
        System.out.println("Ngày công: " + workDays + "/" + totalDays);
        System.out.println("Lương thực tế: " + actualSalary);
        System.out.println("Bảo hiểm: " + insurance);
        System.out.println("Thuế TNCN: " + tax);
        System.out.println("Thưởng: " + bonus);
        System.out.println("Thực nhận: " + netSalary);
    }
}
