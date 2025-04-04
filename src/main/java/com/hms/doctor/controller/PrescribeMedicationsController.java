package com.hms.doctor.controller;

import com.hms.doctor.service.DoctorService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class PrescribeMedicationsController {

    @FXML private TextField doctorUsernameField;
    @FXML private TextField medicationField;
    @FXML private TextField dosageField;
    @FXML private TextField instructionsField;

    private DoctorService doctorService = new DoctorService();

    @FXML
    private void handlePrescribe(ActionEvent event) {
        String username = doctorUsernameField.getText();
        String medication = medicationField.getText();
        String dosage = dosageField.getText();
        String instructions = instructionsField.getText();

        // Simply call the method; it returns void.
        doctorService.prescribeMedication(username, medication, dosage, instructions);
    }
}
