package com.hms.patient.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class PatientBillReportController implements Initializable {

    @FXML
    private TextArea reportTextArea;

    // Static variable to hold report content for display
    private static String reportContent = "No report available.";

    public static void setReportContent(String content) {
        reportContent = content;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        reportTextArea.setText(reportContent);
    }

    @FXML
    public void handleClose(ActionEvent event) {
        // Close the report window
        Stage stage = (Stage) reportTextArea.getScene().getWindow();
        stage.close();
    }
}
