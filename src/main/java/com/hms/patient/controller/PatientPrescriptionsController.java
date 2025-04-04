package com.hms.patient.controller;

import com.hms.prescription.model.Prescription;
import com.hms.prescription.service.PrescriptionService;
import com.hms.patient.model.Patient;
import com.hms.patient.util.PatientSession;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class PatientPrescriptionsController implements Initializable {

    @FXML
    private TableView<Prescription> prescriptionsTable;

    @FXML
    private TableColumn<Prescription, Integer> idColumn;

    @FXML
    private TableColumn<Prescription, String> doctorColumn;

    @FXML
    private TableColumn<Prescription, String> dateColumn;

    @FXML
    private TableColumn<Prescription, String> medicationColumn;

    @FXML
    private TableColumn<Prescription, String> dosageColumn;

    @FXML
    private TableColumn<Prescription, String> instructionsColumn;

    @FXML
    private TableColumn<Prescription, Void> payColumn;

    private PrescriptionService prescriptionService = new PrescriptionService();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        doctorColumn.setCellValueFactory(new PropertyValueFactory<>("doctor"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        medicationColumn.setCellValueFactory(new PropertyValueFactory<>("medication"));
        dosageColumn.setCellValueFactory(new PropertyValueFactory<>("dosage"));
        instructionsColumn.setCellValueFactory(new PropertyValueFactory<>("instructions"));

        loadPrescriptions();
        addPayButtonToTable();
    }

    private void loadPrescriptions() {
        Patient patient = PatientSession.getLoggedInPatient();
        String username = (patient != null) ? patient.getUsername() : "";
        List<Prescription> prescriptions = prescriptionService.getPrescriptionsByPatient(username);
        ObservableList<Prescription> list = FXCollections.observableArrayList(
                prescriptions != null ? prescriptions : FXCollections.emptyObservableList());
        prescriptionsTable.setItems(list);
    }

    private void addPayButtonToTable() {
        Callback<TableColumn<Prescription, Void>, TableCell<Prescription, Void>> cellFactory = new Callback<>() {
            @Override
            public TableCell<Prescription, Void> call(final TableColumn<Prescription, Void> param) {
                final TableCell<Prescription, Void> cell = new TableCell<>() {
                    private final Button btn = new Button("Pay Bill");
                    {
                        btn.setOnAction((ActionEvent event) -> {
                            Prescription prescription = getTableView().getItems().get(getIndex());
                            handlePayBill(prescription, btn);
                        });
                    }
                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        setGraphic(empty ? null : btn);
                    }
                };
                return cell;
            }
        };
        payColumn.setCellFactory(cellFactory);
    }

    private void handlePayBill(Prescription prescription, Button btn) {
        try {
            // Build a report string based on prescription details (customize as needed)
            String report = "Bill Report for Prescription ID: " + prescription.getId() + "\n"
                    + "Doctor: " + prescription.getDoctor() + "\n"
                    + "Date: " + prescription.getDate() + "\n"
                    + "Medication: " + prescription.getMedication() + "\n"
                    + "Dosage: " + prescription.getDosage() + "\n"
                    + "Instructions: " + prescription.getInstructions() + "\n"
                    + "Amount Due: $XXX"; // Replace with actual amount if available

            // Set the report content in the PatientBillReportController (static method)
            com.hms.patient.controller.PatientBillReportController.setReportContent(report);

            // Open a new window to show the bill report
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/PatientBillReportUI.fxml"));
            Parent root = loader.load();
            Stage reportStage = new Stage();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("/styles/app.css").toExternalForm());
            reportStage.setScene(scene);
            reportStage.setTitle("Bill Report");
            reportStage.show();

            // Optionally update the button state to indicate payment
            btn.setText("Paid");
            btn.setDisable(true);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleBack(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/patient/PatientDashboard.fxml"));
            Stage stage = (Stage) prescriptionsTable.getScene().getWindow();
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
