package com.app;

import java.time.LocalDate;

/**
 * Model - Đại diện cho dữ liệu sinh viên.
 * Chỉ chứa dữ liệu và getter/setter, KHÔNG chứa logic UI.
 */
public class Student {
    private String fullName;
    private String studentId;
    private String email;
    private LocalDate birthDate;
    private String faculty;
    private String gender;
    private boolean agreedToTerms;

    // Constructor rỗng
    public Student() {}

    // Constructor đầy đủ
    public Student(String fullName, String studentId, String email,
                   LocalDate birthDate, String faculty, String gender,
                   boolean agreedToTerms) {
        this.fullName = fullName;
        this.studentId = studentId;
        this.email = email;
        this.birthDate = birthDate;
        this.faculty = faculty;
        this.gender = gender;
        this.agreedToTerms = agreedToTerms;
    }

    // Getters và Setters
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public LocalDate getBirthDate() { return birthDate; }
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }

    public String getFaculty() { return faculty; }
    public void setFaculty(String faculty) { this.faculty = faculty; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public boolean isAgreedToTerms() { return agreedToTerms; }
    public void setAgreedToTerms(boolean agreedToTerms) { this.agreedToTerms = agreedToTerms; }

    @Override
    public String toString() {
        return "Student{" +
            "fullName='" + fullName + '\'' +
            ", studentId='" + studentId + '\'' +
            ", email='" + email + '\'' +
            ", birthDate=" + birthDate +
            ", faculty='" + faculty + '\'' +
            ", gender='" + gender + '\'' +
            '}';
    }
}
