package com.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Ứng dụng chính - Load giao diện từ FXML.
 * Bài 7: SceneBuilder & FXML.
 */
public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load file FXML (giao diện đã thiết kế)
        Parent root = FXMLLoader.load(
            getClass().getResource("/com/app/student_form.fxml")
        );

        // Tạo Scene và gắn CSS
        Scene scene = new Scene(root, 600, 550);
        scene.getStylesheets().add(
            getClass().getResource("/com/app/style.css").toExternalForm()
        );

        // Cấu hình cửa sổ
        primaryStage.setTitle("Hệ thống Đăng ký Sinh viên");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
