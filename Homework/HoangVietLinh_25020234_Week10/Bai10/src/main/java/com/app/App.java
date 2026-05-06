package com.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

/**
 * Bài 10: Advanced JavaFX - Concurrency + Keyboard Events.
 * Thêm phím tắt Ctrl+S toàn cục.
 */
public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        DatabaseHelper.initializeDatabase();

        FXMLLoader loader = new FXMLLoader(
            getClass().getResource("/com/app/student_form.fxml")
        );
        Parent root = loader.load();

        // Lấy reference đến Controller
        StudentController controller = loader.getController();

        Scene scene = new Scene(root, 620, 700);
        scene.getStylesheets().add(
            getClass().getResource("/com/app/style.css").toExternalForm()
        );

        // Phím tắt toàn cục: Ctrl+S → Save
        KeyCombination ctrlS = new KeyCodeCombination(
            KeyCode.S, KeyCombination.CONTROL_DOWN
        );
        scene.getAccelerators().put(ctrlS, () -> controller.triggerSave());

        primaryStage.setTitle("Đăng ký Sinh viên - Advanced");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
