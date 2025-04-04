package com.hms.doctor.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class UploadPrescriptionController {

    @FXML
    private TextField filePathField;

    @FXML
    public void handleChooseFile(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose Prescription File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("PDF Files", "*.pdf"),
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg")
        );
        Stage stage = (Stage) filePathField.getScene().getWindow();
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            filePathField.setText(file.getAbsolutePath());
        }
    }

    @FXML
    public void handleSubmit(ActionEvent event) {
        // Here, implement the logic to upload the file (e.g., save to a server or database)
        System.out.println("Uploading file: " + filePathField.getText());
        // After uploading, you can close the window:
        handleClose(event);
    }

    @FXML
    public void handleClose(ActionEvent event) {
        Stage stage = (Stage) filePathField.getScene().getWindow();
        stage.close();
    }
}
