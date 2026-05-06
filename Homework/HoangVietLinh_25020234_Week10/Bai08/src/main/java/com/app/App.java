package com.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Bài 8: MVC Event Handling.
 * Load FXML và liên kết Controller.
 */
public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(
            getClass().getResource("/com/app/student_form.fxml")
        );

        Scene scene = new Scene(root, 600, 580);
        scene.getStylesheets().add(
            getClass().getResource("/com/app/style.css").toExternalForm()
        );

        primaryStage.setTitle("Đăng ký Sinh viên - MVC");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
