public class Main {
    public static void main(String[] args) {
        System.out.println("========== TRƯỚC REFACTOR ==========");
        BeforeStudentManager before = new BeforeStudentManager();
        before.setStudentId("25020234");
        before.setName("Hoang Viet Linh");
        before.setGpa(3.2);
        before.setCourseId("CS2043");
        before.setCourseName("Cong nghe phan mem");
        before.setCredits(3);
        before.setMidtermScore(7.5);
        before.setFinalScore(8.0);
        before.setAssignmentScore(9.0);
        before.printTranscript();

        System.out.println();

        System.out.println("========== SAU REFACTOR ==========");
        Student student = new Student("25020234", "Hoang Viet Linh", 3.2);
        Course course = new Course("CS2043", "Cong nghe phan mem", 3);
        Enrollment enrollment = new Enrollment(student, course, 7.5, 8.0, 9.0);
        TranscriptPrinter.printTranscript(enrollment);
    }
}
