package com.app;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * DatabaseHelper - Quản lý kết nối và thao tác với SQLite database.
 * Sử dụng JDBC (Java Database Connectivity) để giao tiếp.
 */
public class DatabaseHelper {
    // SQLite tạo file database ngay trong thư mục project
    private static final String DB_URL = "jdbc:sqlite:students.db";

    /**
     * Tạo kết nối đến database.
     */
    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    /**
     * Khởi tạo database - tạo bảng students nếu chưa tồn tại.
     */
    public static void initializeDatabase() {
        String sql = """
            CREATE TABLE IF NOT EXISTS students (
                id          INTEGER PRIMARY KEY AUTOINCREMENT,
                full_name   TEXT    NOT NULL,
                student_id  TEXT    NOT NULL UNIQUE,
                email       TEXT    NOT NULL,
                birth_date  TEXT,
                faculty     TEXT,
                gender      TEXT,
                created_at  DATETIME DEFAULT CURRENT_TIMESTAMP
            )
            """;

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Database đã sẵn sàng.");
        } catch (SQLException e) {
            System.err.println("Lỗi khởi tạo database: " + e.getMessage());
        }
    }

    /**
     * Lưu sinh viên vào database (INSERT).
     * Trả về true nếu thành công, false nếu thất bại.
     */
    public static boolean saveStudent(Student student) {
        String sql = """
            INSERT INTO students (full_name, student_id, email, birth_date, faculty, gender)
            VALUES (?, ?, ?, ?, ?, ?)
            """;

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, student.getFullName());
            pstmt.setString(2, student.getStudentId());
            pstmt.setString(3, student.getEmail());
            pstmt.setString(4, student.getBirthDate() != null
                ? student.getBirthDate().toString() : null);
            pstmt.setString(5, student.getFaculty());
            pstmt.setString(6, student.getGender());

            pstmt.executeUpdate();
            System.out.println("Đã lưu sinh viên: " + student.getStudentId());
            return true;

        } catch (SQLException e) {
            System.err.println("Lỗi lưu database: " + e.getMessage());
            return false;
        }
    }

    /**
     * Tải danh sách tất cả sinh viên từ database (SELECT).
     */
    public static List<Student> loadAllStudents() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students ORDER BY created_at DESC";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Student student = new Student();
                student.setFullName(rs.getString("full_name"));
                student.setStudentId(rs.getString("student_id"));
                student.setEmail(rs.getString("email"));

                String birthStr = rs.getString("birth_date");
                if (birthStr != null && !birthStr.isEmpty()) {
                    student.setBirthDate(LocalDate.parse(birthStr));
                }

                student.setFaculty(rs.getString("faculty"));
                student.setGender(rs.getString("gender"));
                students.add(student);
            }

            System.out.println("Đã tải " + students.size() + " sinh viên từ database.");

        } catch (SQLException e) {
            System.err.println("Lỗi tải database: " + e.getMessage());
        }

        return students;
    }

    /**
     * Tải sinh viên gần nhất từ database.
     */
    public static Student loadLatestStudent() {
        String sql = "SELECT * FROM students ORDER BY created_at DESC LIMIT 1";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            if (rs.next()) {
                Student student = new Student();
                student.setFullName(rs.getString("full_name"));
                student.setStudentId(rs.getString("student_id"));
                student.setEmail(rs.getString("email"));

                String birthStr = rs.getString("birth_date");
                if (birthStr != null && !birthStr.isEmpty()) {
                    student.setBirthDate(LocalDate.parse(birthStr));
                }

                student.setFaculty(rs.getString("faculty"));
                student.setGender(rs.getString("gender"));
                return student;
            }

        } catch (SQLException e) {
            System.err.println("Lỗi tải database: " + e.getMessage());
        }
        return null;
    }
}
