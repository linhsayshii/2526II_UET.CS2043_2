public class Employee {
    private String name;
    private MyDate birthday;
    Employee(String name, MyDate birthday) {
        this.name = name;
        this.birthday = birthday;
    }
    Employee(Employee e) {
        this.name = e.name;
        this.birthday = e.birthday;
    }
    public String getName() {
        return name; 
    }
    public void setDate(MyDate birthday) {
        this.birthday = birthday;
    }
    public MyDate getBirthday() {
        return birthday;
    }
}
