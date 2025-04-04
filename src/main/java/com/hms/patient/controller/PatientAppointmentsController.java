package com.hms.patient.controller;

import com.hms.appointment.model.Appointment;
import com.hms.appointment.service.AppointmentService;
import com.hms.patient.model.Patient;
import com.hms.patient.util.PatientSession;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class PatientAppointmentsController implements Initializable {

    @FXML
    private TableView<Appointment> appointmentsTable;

    @FXML
    private TableColumn<Appointment, Integer> idColumn;

    @FXML
    private TableColumn<Appointment, String> doctorColumn;

    @FXML
    private TableColumn<Appointment, String> dateColumn;

    @FXML
    private TableColumn<Appointment, String> timeColumn;

    @FXML
    private TableColumn<Appointment, String> reasonColumn;

    private AppointmentService appointmentService = new AppointmentService();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        doctorColumn.setCellValueFactory(new PropertyValueFactory<>("doctor"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("appointmentDate"));
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("appointmentTime"));
        reasonColumn.setCellValueFactory(new PropertyValueFactory<>("reason"));

        loadAppointments();
    }

    private void loadAppointments() {
        Patient patient = PatientSession.getLoggedInPatient();
        String username = (patient != null) ? patient.getUsername() : "";
        List<Appointment> appointments = appointmentService.getAppointmentsByPatient(username);
        ObservableList<Appointment> list = FXCollections.observableArrayList(appointments != null ? appointments : FXCollections.emptyObservableList());
        appointmentsTable.setItems(list);
    }

    @FXML
    public void handleBack(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/patient/PatientDashboard.fxml"));
            Stage stage = (Stage) appointmentsTable.getScene().getWindow();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("/styles/app.css").toExternalForm());
            stage.setScene(scene);
            stage.setTitle("Patient Dashboard");
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
