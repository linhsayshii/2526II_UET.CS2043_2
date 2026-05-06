package com.app;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Controller - Xử lý toàn bộ logic tương tác.
 * View (FXML) chỉ là bố cục khai báo, Controller xử lý logic.
 */
public class StudentController implements Initializable {

    // Liên kết với các controls trong FXML (qua fx:id)
    @FXML private TextField txtFullName;
    @FXML private TextField txtStudentId;
    @FXML private TextField txtEmail;
    @FXML private DatePicker dateBirth;
    @FXML private ComboBox<String> cboFaculty;
    @FXML private RadioButton radioMale;
    @FXML private RadioButton radioFemale;
    @FXML private CheckBox chkAgree;
    @FXML private Label lblStatus;
    @FXML private Button btnSubmit;
    @FXML private Button btnClear;

    // ToggleGroup để đảm bảo chỉ chọn 1 RadioButton
    private ToggleGroup genderGroup;

    /**
     * Được gọi tự động sau khi FXML được load.
     * Khởi tạo dữ liệu cho các controls.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Khởi tạo ComboBox - danh sách khoa
        cboFaculty.setItems(FXCollections.observableArrayList(
            "Công nghệ Thông tin",
            "Điện tử Viễn thông",
            "Vật lý Kỹ thuật",
            "Cơ học Kỹ thuật",
            "Toán - Cơ - Tin học"
        ));

        // Nhóm RadioButton lại với nhau
        genderGroup = new ToggleGroup();
        radioMale.setToggleGroup(genderGroup);
        radioFemale.setToggleGroup(genderGroup);

        // Gắn sự kiện cho các nút
        btnSubmit.setOnAction(e -> handleSubmit());
        btnClear.setOnAction(e -> handleClear());
    }

    /**
     * Xử lý khi nhấn nút Submit.
     * Đọc dữ liệu → Validate → Hiển thị kết quả.
     */
    private void handleSubmit() {
        // Bước 1: Validate dữ liệu
        List<String> errors = validateForm();

        if (!errors.isEmpty()) {
            // Có lỗi → hiển thị thông báo lỗi
            String errorMsg = "Lỗi xác thực:\n• " + String.join("\n• ", errors);
            showAlert(Alert.AlertType.ERROR, "Lỗi", errorMsg);
            lblStatus.setText("❌ Vui lòng sửa các lỗi trên.");
            lblStatus.getStyleClass().setAll("status-label", "error-text");
            return;
        }

        // Bước 2: Tạo đối tượng Student từ dữ liệu form
        Student student = readFormData();

        // Bước 3: Hiển thị thông báo thành công
        String successMsg = "Đã đăng ký thành công!\n\n" + student.toString();
        showAlert(Alert.AlertType.INFORMATION, "Thành công", successMsg);
        lblStatus.setText("✅ Đăng ký thành công: " + student.getFullName());
        lblStatus.getStyleClass().setAll("status-label", "success-text");
    }

    /**
     * Kiểm tra dữ liệu form và trả về danh sách lỗi.
     */
    private List<String> validateForm() {
        List<String> errors = new ArrayList<>();

        // Tên không được rỗng
        if (txtFullName.getText().trim().isEmpty()) {
            errors.add("Họ và tên không được để trống.");
        }

        // MSSV phải là 8 chữ số
        String sid = txtStudentId.getText().trim();
        if (sid.isEmpty()) {
            errors.add("MSSV không được để trống.");
        } else if (!sid.matches("\\d{8}")) {
            errors.add("MSSV phải gồm đúng 8 chữ số (VD: 25020234).");
        }

        // Email phải có định dạng hợp lệ
        String email = txtEmail.getText().trim();
        if (email.isEmpty()) {
            errors.add("Email không được để trống.");
        } else if (!email.matches("^[\\w.+-]+@[\\w-]+\\.[\\w.]+$")) {
            errors.add("Email không đúng định dạng.");
        }

        // Ngày sinh phải được chọn
        if (dateBirth.getValue() == null) {
            errors.add("Vui lòng chọn ngày sinh.");
        }

        // Khoa phải được chọn
        if (cboFaculty.getValue() == null) {
            errors.add("Vui lòng chọn khoa.");
        }

        // Giới tính phải được chọn
        if (genderGroup.getSelectedToggle() == null) {
            errors.add("Vui lòng chọn giới tính.");
        }

        // Phải đồng ý điều khoản
        if (!chkAgree.isSelected()) {
            errors.add("Bạn phải đồng ý với các điều khoản.");
        }

        return errors;
    }

    /**
     * Đọc dữ liệu từ form và tạo đối tượng Student.
     */
    private Student readFormData() {
        String gender = "";
        if (genderGroup.getSelectedToggle() != null) {
            RadioButton selected = (RadioButton) genderGroup.getSelectedToggle();
            gender = selected.getText();
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

    /**
     * Xóa toàn bộ dữ liệu trên form.
     */
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

    /**
     * Hiển thị hộp thoại Alert.
     */
    private void showAlert(Alert.AlertType type, String title, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
