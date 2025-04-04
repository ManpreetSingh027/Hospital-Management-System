package com.hms.doctor.controller;

import com.hms.doctor.model.PatientRecord;
import com.hms.doctor.service.DoctorService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PatientRecordUpdateController {

    @FXML
    private TextField patientNameField;
    @FXML
    private TextArea diagnosisArea;
    @FXML
    private Label feedbackLabel;

    private static PatientRecord selectedRecord;
    private DoctorService doctorService = new DoctorService();

    public static void setSelectedRecord(PatientRecord record) {
        selectedRecord = record;
    }

    @FXML
    public void initialize() {
        if(selectedRecord != null) {
            patientNameField.setText(selectedRecord.getPatientName());
            diagnosisArea.setText(selectedRecord.getDiagnosis());
        }
    }

    @FXML
    public void handleUpdateRecord(ActionEvent event) {
        if(selectedRecord != null) {
            selectedRecord.setDiagnosis(diagnosisArea.getText());
            // Call a service method to update the record in a real application.
            // For demonstration, we print to console.
            System.out.println("Updated record for " + selectedRecord.getPatientName() + " with diagnosis: " + diagnosisArea.getText());
            feedbackLabel.setText("Record updated successfully!");
            // Navigate back to the Doctor Dashboard after updating:
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/fxml/DoctorUI.fxml"));
                Stage stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                scene.getStylesheets().add(getClass().getResource("/styles/app.css").toExternalForm());
                stage.setScene(scene);
                stage.setTitle("Doctor Dashboard");
                stage.show();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}
