package com.hms.doctor.controller;

import com.hms.doctor.service.DoctorService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class DoctorController {

    @FXML private ListView<String> patientRecordsListView;

    private DoctorService doctorService = new DoctorService();

    public void initialize() {
        // Provide a username argument (for demonstration, "drsmith")
        ObservableList<String> records = FXCollections.observableArrayList(
                doctorService.getAssignedPatientRecords("drsmith")
        );
        patientRecordsListView.setItems(records);
    }
}
