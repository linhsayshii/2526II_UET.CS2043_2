public class Main {
    public static void main(String[] args) {
        MyDate date1 = new MyDate(1, 1, 2000);
        MyDate date2 = new MyDate(2,2,2002);
        Employee emp1 = new Employee("Hoang Viet Linh", date1);
        Employee emp2 = new Employee(emp1);
        emp1.setDate(date2);
        emp1.getBirthday().getFormattedDate();
        emp2.getBirthday().getFormattedDate();
    }
}