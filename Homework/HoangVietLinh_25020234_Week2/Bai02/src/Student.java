public class Student {
    private String id;
    private String name;
    private double gpa;
    private String email;
    Student() {
    }
    Student(String id, String name) {
        this.id = id;
        this.email = "N/A";
        this.name = name;
        this.gpa = 0.0;
    }
    Student(String id, String name, String email, double gpa) {
        this.id = id;
        this.name = name;
        this.email = email;
        if (gpa < 0.0 || gpa > 4.0) {
            this.gpa = 0;
        } else {
            this.gpa = gpa;
        }
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setGpa(double gpa) {
        if (gpa >= 0.0 && gpa <= 4.0) {
            this.gpa = gpa;
        } else {
            System.out.println("Invalid GPA");
        }
    }
    public void getInformation() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("GPA: " + gpa);
    }
    public static void main(String[] args) {
        Student no1 = new Student();
        no1.setId("25020222");
        no1.setName("Hoang Viet Li");
        no1.setEmail("25020222@vnu.edu.vn");
        no1.setGpa(3.99);

        Student no2 = new Student("25020233", "Hoang Viet Lin");
        Student no3 = new Student("25020234", "Hoang Viet Linh", "25020234@vnu.edu.vn", 3.99);

        //Test getInformation
        no1.getInformation();
        no2.getInformation();
        no3.getInformation();
    }
}