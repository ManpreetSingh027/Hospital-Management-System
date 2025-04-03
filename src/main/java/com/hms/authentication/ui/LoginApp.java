package com.hms.authentication.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // Load the login screen from FXML
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/LoginApp.fxml"));
        Scene scene = new Scene(root);
        // Apply the global stylesheet
        scene.getStylesheets().add(getClass().getResource("/styles/app.css").toExternalForm());
        stage.setScene(scene);
        stage.setTitle("Hospital Management System - Login");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
