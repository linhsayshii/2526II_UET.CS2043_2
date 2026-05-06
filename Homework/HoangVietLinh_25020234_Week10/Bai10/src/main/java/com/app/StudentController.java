package com.app;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Controller Bài 10 - Advanced JavaFX:
 * 1. Real-time Validation (Change Listeners)
 * 2. Keyboard Events (Enter → next field)
 * 3. Async Save/Load (javafx.concurrent.Task)
 * 4. ProgressIndicator + Platform.runLater()
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
    @FXML private ProgressIndicator progressIndicator;

    private ToggleGroup genderGroup;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Khởi tạo ComboBox
        cboFaculty.setItems(FXCollections.observableArrayList(
            "Công nghệ Thông tin",
            "Điện tử Viễn thông",
            "Vật lý Kỹ thuật",
            "Cơ học Kỹ thuật",
            "Toán - Cơ - Tin học"
        ));

        // Nhóm RadioButton
        genderGroup = new ToggleGroup();
        radioMale.setToggleGroup(genderGroup);
        radioFemale.setToggleGroup(genderGroup);

        // Ẩn ProgressIndicator ban đầu
        progressIndicator.setVisible(false);

        // ============================================================
        // 1. REAL-TIME VALIDATION - Change Listeners
        // ============================================================

        // Họ tên: không được rỗng
        txtFullName.textProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal.trim().isEmpty()) {
                txtFullName.getStyleClass().add("error-field");
            } else {
                txtFullName.getStyleClass().remove("error-field");
            }
        });

        // MSSV: phải đúng 8 chữ số
        txtStudentId.textProperty().addListener((obs, oldVal, newVal) -> {
            if (!newVal.matches("\\d{0,8}") || (newVal.length() == 8 && !newVal.matches("\\d{8}"))) {
                if (!newVal.matches("\\d{8}")) {
                    txtStudentId.getStyleClass().add("error-field");
                } else {
                    txtStudentId.getStyleClass().remove("error-field");
                }
            } else if (newVal.length() == 8) {
                txtStudentId.getStyleClass().remove("error-field");
            }
        });

        // Email: phải có @ và .
        txtEmail.textProperty().addListener((obs, oldVal, newVal) -> {
            if (!newVal.isEmpty() && !newVal.matches("^[\\w.+-]+@[\\w-]+\\.[\\w.]+$")) {
                txtEmail.getStyleClass().add("error-field");
            } else {
                txtEmail.getStyleClass().remove("error-field");
            }
        });

        // ============================================================
        // 2. KEYBOARD EVENTS - Enter → next field
        // ============================================================

        txtFullName.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) txtStudentId.requestFocus();
        });
        txtStudentId.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) txtEmail.requestFocus();
        });
        txtEmail.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) dateBirth.requestFocus();
        });

        // Gắn sự kiện nút
        btnSave.setOnAction(e -> handleSaveAsync());
        btnLoad.setOnAction(e -> handleLoadAsync());
        btnClear.setOnAction(e -> handleClear());
    }

    /**
     * Phương thức công khai để App gọi từ phím tắt Ctrl+S.
     */
    public void triggerSave() {
        handleSaveAsync();
    }

    // ============================================================
    // 3. ASYNC SAVE - Chạy trên luồng nền bằng Task
    // ============================================================

    private void handleSaveAsync() {
        // Validate trước (trên UI thread)
        List<String> errors = validateForm();
        if (!errors.isEmpty()) {
            String errorMsg = "Lỗi xác thực:\n• " + String.join("\n• ", errors);
            showAlert(Alert.AlertType.ERROR, "Lỗi", errorMsg);
            lblStatus.setText("❌ Vui lòng sửa các lỗi.");
            lblStatus.getStyleClass().setAll("status-label", "error-text");
            return;
        }

        Student student = readFormData();

        // Hiển thị ProgressIndicator
        progressIndicator.setVisible(true);
        btnSave.setDisable(true);
        lblStatus.setText("⏳ Đang lưu...");

        // Tạo Task chạy trên luồng nền
        Task<Boolean> saveTask = new Task<>() {
            @Override
            protected Boolean call() throws Exception {
                // Mô phỏng thao tác database chậm (để thấy ProgressIndicator)
                Thread.sleep(800);
                return DatabaseHelper.saveStudent(student);
            }
        };

        // Khi Task hoàn thành → cập nhật UI bằng Platform.runLater()
        saveTask.setOnSucceeded(event -> {
            Platform.runLater(() -> {
                progressIndicator.setVisible(false);
                btnSave.setDisable(false);

                boolean success = saveTask.getValue();
                if (success) {
                    showAlert(Alert.AlertType.INFORMATION, "Thành công",
                        "Đã lưu sinh viên " + student.getFullName() + "!");
                    lblStatus.setText("✅ Đã lưu: " + student.getFullName());
                    lblStatus.getStyleClass().setAll("status-label", "success-text");
                } else {
                    showAlert(Alert.AlertType.ERROR, "Lỗi Database",
                        "Không thể lưu. MSSV có thể đã tồn tại.");
                    lblStatus.setText("❌ Lỗi database.");
                    lblStatus.getStyleClass().setAll("status-label", "error-text");
                }
            });
        });

        // Khi Task thất bại
        saveTask.setOnFailed(event -> {
            Platform.runLater(() -> {
                progressIndicator.setVisible(false);
                btnSave.setDisable(false);
                lblStatus.setText("❌ Lỗi không mong đợi.");
                lblStatus.getStyleClass().setAll("status-label", "error-text");
            });
        });

        // Chạy Task trên luồng nền
        new Thread(saveTask).start();
    }

    // ============================================================
    // 4. ASYNC LOAD - Với ProgressIndicator
    // ============================================================

    private void handleLoadAsync() {
        progressIndicator.setVisible(true);
        btnLoad.setDisable(true);
        lblStatus.setText("⏳ Đang tải...");

        Task<Student> loadTask = new Task<>() {
            @Override
            protected Student call() throws Exception {
                Thread.sleep(800);  // Mô phỏng độ trễ
                return DatabaseHelper.loadLatestStudent();
            }
        };

        loadTask.setOnSucceeded(event -> {
            // Cập nhật UI AN TOÀN từ background thread
            Platform.runLater(() -> {
                progressIndicator.setVisible(false);
                btnLoad.setDisable(false);

                Student student = loadTask.getValue();
                if (student == null) {
                    showAlert(Alert.AlertType.WARNING, "Không có dữ liệu",
                        "Database chưa có bản ghi nào.");
                    lblStatus.setText("⚠️ Không có dữ liệu.");
                    return;
                }

                // Populate form
                txtFullName.setText(student.getFullName());
                txtStudentId.setText(student.getStudentId());
                txtEmail.setText(student.getEmail());
                dateBirth.setValue(student.getBirthDate());
                cboFaculty.setValue(student.getFaculty());

                if ("Nam".equals(student.getGender())) {
                    genderGroup.selectToggle(radioMale);
                } else if ("Nữ".equals(student.getGender())) {
                    genderGroup.selectToggle(radioFemale);
                }

                lblStatus.setText("✅ Đã tải: " + student.getFullName());
                lblStatus.getStyleClass().setAll("status-label", "success-text");
            });
        });

        loadTask.setOnFailed(event -> {
            Platform.runLater(() -> {
                progressIndicator.setVisible(false);
                btnLoad.setDisable(false);
                lblStatus.setText("❌ Lỗi khi tải dữ liệu.");
                lblStatus.getStyleClass().setAll("status-label", "error-text");
            });
        });

        new Thread(loadTask).start();
    }

    // ============================================================
    // VALIDATION + HELPERS (giống các bài trước)
    // ============================================================

    private List<String> validateForm() {
        List<String> errors = new ArrayList<>();
        if (txtFullName.getText().trim().isEmpty())
            errors.add("Họ và tên không được để trống.");

        String sid = txtStudentId.getText().trim();
        if (sid.isEmpty()) errors.add("MSSV không được để trống.");
        else if (!sid.matches("\\d{8}")) errors.add("MSSV phải gồm đúng 8 chữ số.");

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
        // Xóa error styling
        txtFullName.getStyleClass().remove("error-field");
        txtStudentId.getStyleClass().remove("error-field");
        txtEmail.getStyleClass().remove("error-field");
    }

    private void showAlert(Alert.AlertType type, String title, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
