package com.hms.doctor.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestDoctorModule extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load the Doctor Dashboard FXML
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/doctor/DoctorDashboardUI.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/styles/app.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Doctor Dashboard Test");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
