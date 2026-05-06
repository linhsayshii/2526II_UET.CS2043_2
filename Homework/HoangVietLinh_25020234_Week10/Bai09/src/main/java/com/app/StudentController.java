package com.app;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Controller Bài 9 - Thêm chức năng Save và Load từ Database.
 */
public class StudentController implements Initializable {

    @FXML private TextField txtFullName;
    @FXML private TextField txtStudentId;
    @FXML private TextField txtEmail;
    @FXML private DatePicker dateBirth;
    @FXML private ComboBox<String> cboFaculty;
    @FXML private RadioButton radioMale;
    @FXML private RadioButton radioFemale;
    @FXML private CheckBox chkAgree;
    @FXML private Label lblStatus;
    @FXML private Button btnSave;
    @FXML private Button btnLoad;
    @FXML private Button btnClear;

    private ToggleGroup genderGroup;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cboFaculty.setItems(FXCollections.observableArrayList(
            "Công nghệ Thông tin",
            "Điện tử Viễn thông",
            "Vật lý Kỹ thuật",
            "Cơ học Kỹ thuật",
            "Toán - Cơ - Tin học"
        ));

        genderGroup = new ToggleGroup();
        radioMale.setToggleGroup(genderGroup);
        radioFemale.setToggleGroup(genderGroup);

        // Gắn sự kiện
        btnSave.setOnAction(e -> handleSave());
        btnLoad.setOnAction(e -> handleLoad());
        btnClear.setOnAction(e -> handleClear());
    }

    /**
     * Lưu dữ liệu vào Database.
     * Validate → Save → Hiển thị kết quả.
     */
    private void handleSave() {
        List<String> errors = validateForm();

        if (!errors.isEmpty()) {
            String errorMsg = "Lỗi xác thực:\n• " + String.join("\n• ", errors);
            showAlert(Alert.AlertType.ERROR, "Lỗi", errorMsg);
            lblStatus.setText("❌ Vui lòng sửa các lỗi.");
            lblStatus.getStyleClass().setAll("status-label", "error-text");
            return;
        }

        Student student = readFormData();
        boolean success = DatabaseHelper.saveStudent(student);

        if (success) {
            showAlert(Alert.AlertType.INFORMATION, "Thành công",
                "Đã lưu sinh viên " + student.getFullName() + " vào database!");
            lblStatus.setText("✅ Đã lưu: " + student.getFullName());
            lblStatus.getStyleClass().setAll("status-label", "success-text");
        } else {
            showAlert(Alert.AlertType.ERROR, "Lỗi Database",
                "Không thể lưu. MSSV có thể đã tồn tại trong database.");
            lblStatus.setText("❌ Lỗi khi lưu vào database.");
            lblStatus.getStyleClass().setAll("status-label", "error-text");
        }
    }

    /**
     * Tải dữ liệu sinh viên gần nhất từ Database và điền vào form.
     */
    private void handleLoad() {
        Student student = DatabaseHelper.loadLatestStudent();

        if (student == null) {
            showAlert(Alert.AlertType.WARNING, "Không có dữ liệu",
                "Database chưa có bản ghi nào.");
            lblStatus.setText("⚠️ Không có dữ liệu để tải.");
            return;
        }

        // Điền dữ liệu vào form (populate)
        txtFullName.setText(student.getFullName());
        txtStudentId.setText(student.getStudentId());
        txtEmail.setText(student.getEmail());
        dateBirth.setValue(student.getBirthDate());
        cboFaculty.setValue(student.getFaculty());

        // Chọn giới tính
        if ("Nam".equals(student.getGender())) {
            genderGroup.selectToggle(radioMale);
        } else if ("Nữ".equals(student.getGender())) {
            genderGroup.selectToggle(radioFemale);
        }

        lblStatus.setText("✅ Đã tải: " + student.getFullName());
        lblStatus.getStyleClass().setAll("status-label", "success-text");
    }

    private List<String> validateForm() {
        List<String> errors = new ArrayList<>();
        if (txtFullName.getText().trim().isEmpty())
            errors.add("Họ và tên không được để trống.");

        String sid = txtStudentId.getText().trim();
        if (sid.isEmpty()) errors.add("MSSV không được để trống.");
        else if (!sid.matches("\\d{8}"))
            errors.add("MSSV phải gồm đúng 8 chữ số.");

        String email = txtEmail.getText().trim();
        if (email.isEmpty()) errors.add("Email không được để trống.");
        else if (!email.matches("^[\\w.+-]+@[\\w-]+\\.[\\w.]+$"))
            errors.add("Email không đúng định dạng.");

        if (dateBirth.getValue() == null) errors.add("Vui lòng chọn ngày sinh.");
        if (cboFaculty.getValue() == null) errors.add("Vui lòng chọn khoa.");
        if (genderGroup.getSelectedToggle() == null) errors.add("Vui lòng chọn giới tính.");
        if (!chkAgree.isSelected()) errors.add("Bạn phải đồng ý với các điều khoản.");

        return errors;
    }

    private Student readFormData() {
        String gender = "";
        if (genderGroup.getSelectedToggle() != null) {
            gender = ((RadioButton) genderGroup.getSelectedToggle()).getText();
        }
        return new Student(
            txtFullName.getText().trim(),
            txtStudentId.getText().trim(),
            txtEmail.getText().trim(),
            dateBirth.getValue(),
            cboFaculty.getValue(),
            gender,
            chkAgree.isSelected()
        );
    }

    private void handleClear() {
        txtFullName.clear();
        txtStudentId.clear();
        txtEmail.clear();
        dateBirth.setValue(null);
        cboFaculty.setValue(null);
        genderGroup.selectToggle(null);
        chkAgree.setSelected(false);
        lblStatus.setText("");
        lblStatus.getStyleClass().setAll("status-label");
    }

    private void showAlert(Alert.AlertType type, String title, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
