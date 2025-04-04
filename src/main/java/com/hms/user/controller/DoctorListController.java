package com.hms.user.controller;

import com.hms.doctor.model.Doctor;
import com.hms.doctor.service.DoctorService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.Node;

import java.util.List;

public class DoctorListController {

    @FXML
    private TableView<Doctor> doctorTableView;

    @FXML
    private TableColumn<Doctor, String> usernameColumn;

    @FXML
    private TableColumn<Doctor, String> nameColumn;

    @FXML
    private TableColumn<Doctor, String> specializationColumn;

    @FXML
    private TableColumn<Doctor, String> availabilityColumn;

    @FXML
    private TableColumn<Doctor, String> passwordColumn; // New column for password

    private DoctorService doctorService = new DoctorService();

    @FXML
    public void initialize() {
        // Configure columns with PropertyValueFactory. The property names should match the getters in Doctor.
        usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        specializationColumn.setCellValueFactory(new PropertyValueFactory<>("specialization"));
        availabilityColumn.setCellValueFactory(new PropertyValueFactory<>("availability"));
        passwordColumn.setCellValueFactory(new PropertyValueFactory<>("password"));

        loadDoctorList();
    }

    private void loadDoctorList() {
        List<Doctor> doctors = doctorService.getAllDoctors();
        ObservableList<Doctor> doctorList = FXCollections.observableArrayList(doctors);
        doctorTableView.setItems(doctorList);
    }

    @FXML
    private void handleBack(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/AdminDashboard.fxml"));
            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Admin Dashboard");
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
