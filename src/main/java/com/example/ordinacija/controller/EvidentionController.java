package com.example.ordinacija.controller;

import com.example.ordinacija.model.Examination;
import com.example.ordinacija.model.Patient;
import com.example.ordinacija.model.Table;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import static com.example.ordinacija.Program.*;

public class EvidentionController implements Initializable {

    //Examination

    @FXML
    TextField dateTxt;

    @FXML
    TextField timeTxt;

    @FXML
    TextField patientTxt;

    @FXML
    TextField typeTxt;

    @FXML
    TextField statusTxt;

    @FXML
    TextArea noteTxt;

    @FXML
    Button deleteExaminationBtn;


    // Examinations TableView


    @FXML
    TableColumn <Object, Object> tableColumnIDE;

    @FXML
    TableColumn tableColumnDate;

    @FXML
    TableColumn tableColumnTime;

    @FXML
    TableColumn tableColumnType;

    @FXML
    TableColumn tableColumnStatus;

    @FXML
    TableColumn tableColumnPatient;

    @FXML
    TableColumn tableColumnNote;

    @FXML
    TableView tableViewExaminations;


    //Patient

    @FXML
    TextField nameTxt;

    @FXML
    TextField lastnameTxt;

    @FXML
    TextField uidTxt;

    @FXML
    TextField phoneTxt;

    @FXML
    TextField mailTxt;

    @FXML
    Button deleteBtn;

    @FXML
    Button updatePatientBtn;

    //Patient TableView

    @FXML
    TableColumn tableColumnID;

    @FXML
    TableColumn tableColumnName;

    @FXML
    TableColumn tableColumnLastname;

    @FXML
    TableColumn tableColumnUid;

    @FXML
    TableColumn tableColumnPhone;

    @FXML
    TableColumn tableColumnMail;

    @FXML
    TableView<Patient> tableViewPatients;


    //PATIENT CRUD


    Patient selectedPatient = null;

    @FXML
    protected void selectPatient (){
        this.selectedPatient = tableViewPatients.getSelectionModel().getSelectedItem();
        this.deleteBtn.setDisable(false);
        this.nameTxt.setText(this.selectedPatient.getName());
        this.lastnameTxt.setText(this.selectedPatient.getLastname());
        this.uidTxt.setText(this.selectedPatient.getUid());
        this.phoneTxt.setText(this.selectedPatient.getPhone());
        this.mailTxt.setText(this.selectedPatient.getMail());

    }

    @FXML
    protected void deletePatient() throws IOException {
        if (this.selectedPatient != null){
            try {
                this.selectedPatient.delete();
                alertDisplay("newPatientDeleted-view.fxml", "Uspješno obrisano!");
            } catch (Exception e) {
                e.printStackTrace();
                alertDisplay("cantDeletePatient-view.fxml", "Greška!");
            }
            this.fillPatients();
            this.selectedPatient=null;
            this.nameTxt.setText("");
            this.lastnameTxt.setText("");
            this.uidTxt.setText("");
            this.phoneTxt.setText("");
            this.mailTxt.setText("");
            this.deleteBtn.setDisable(true);

        }
    }

    @FXML
    protected void updatePatient () throws Exception {
        if(this.selectedPatient == null){
            Patient newPatient = new Patient ();
            newPatient.setName(this.nameTxt.getText());
            newPatient.setLastname(this.lastnameTxt.getText());
            newPatient.setUid(this.uidTxt.getText());
            newPatient.setPhone(this.phoneTxt.getText());
            newPatient.setMail(this.mailTxt.getText());
            newPatient.save();
            this.fillPatients();
            alertDisplay("newPatientAdded-view.fxml", "Uspješno spremljeno!");
        } else{
            selectedPatient.setName(this.nameTxt.getText());
            selectedPatient.setLastname(this.lastnameTxt.getText());
            selectedPatient.setUid(this.uidTxt.getText());
            selectedPatient.setPhone(this.phoneTxt.getText());
            selectedPatient.setMail(this.mailTxt.getText());

            selectedPatient.update();
            alertDisplay("newPatientUpdated-view.fxml", "Uspješno ažurirano!");

        }

        this.selectedPatient=null;
        this.nameTxt.setText("");
        this.lastnameTxt.setText("");
        this.uidTxt.setText("");
        this.phoneTxt.setText("");
        this.mailTxt.setText("");
        this.deleteBtn.setDisable(true);
        this.fillPatients();
    }

    //EXAMINATION CRUD

    Examination selectedExamination;

    @FXML
    protected void selectExamination () {
        this.selectedExamination = (Examination) tableViewExaminations.getSelectionModel().getSelectedItem();
        this.deleteExaminationBtn.setDisable(false);
        this.dateTxt.setText(this.selectedExamination.getDate());
        this.timeTxt.setText(this.selectedExamination.getHour());
        this.patientTxt.setText(String.valueOf(this.selectedExamination.getPatient_fk()));
        this.statusTxt.setText(this.selectedExamination.getStatus());
        this.typeTxt.setText(this.selectedExamination.getType());
        this.noteTxt.setText(this.selectedExamination.getNote());

    }

    @FXML
    protected void deleteExamination() throws IOException {
        if (this.selectedExamination != null){
            try {
                this.selectedExamination.delete();
                alertDisplay("examinationDeleted-view.fxml", "Uspješno obrisano!");
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.fillExaminations();
            this.selectedExamination=null;
            this.dateTxt.setText("");
            this.timeTxt.setText("");
            this.statusTxt.setText("");
            this.typeTxt.setText("");
            this.patientTxt.setText("");
            this.noteTxt.setText("");

        }
    }

    @FXML
    protected void updateExamination () throws Exception {
        if(this.selectedExamination == null){
            Examination newExamination = new Examination();
            LocalDate today = LocalDate.now();
            newExamination.setDate(String.valueOf(today));
            DateTimeFormatter dt = DateTimeFormatter.ofPattern("HH:mm");
            LocalTime now = LocalTime.now();
            newExamination.setHour(dt.format(now));
            newExamination.setStatus(this.statusTxt.getText());
            newExamination.setType((String) this.typeTxt.getText());
            newExamination.setPatientFk(Integer.parseInt(this.patientTxt.getText()));
            newExamination.setNote(this.noteTxt.getText());

            newExamination.save();
            this.fillPatients();
            alertDisplay("examinationAdded-view.fxml", "Uspješno dodani podatci o pregledu!");

        } else{

            selectedExamination.setDate(this.dateTxt.getText());
            selectedExamination.setHour(this.timeTxt.getText());
            selectedExamination.setStatus(this.statusTxt.getText());
            selectedExamination.setType(this.typeTxt.getText());
            selectedExamination.setPatientFk(Integer.parseInt(this.patientTxt.getText()));
            selectedExamination.setNote(this.noteTxt.getText());

            selectedExamination.update();
            alertDisplay("examinationUpdated-view.fxml", "Uspješno ažurirano!");
        }
        this.selectedExamination=null;
        this.dateTxt.setText("");
        this.timeTxt.setText("");
        this.statusTxt.setText("");
        this.typeTxt.setText("");
        this.patientTxt.setText("");
        this.noteTxt.setText("");
        this.fillExaminations();
    }

    private void fillExaminations(){
        try {
            ObservableList<?> examinations = FXCollections.observableList(Table.list(Examination.class));
            this.tableViewExaminations.setItems(examinations);
        } catch (Exception e) {

            // e.printStackTrace();
            System.out.println("Nastala je pogreška: " + e.getMessage());

        }
    }

     public void fillPatients() throws IOException {
        try {
            ObservableList<?> patients;
            patients = FXCollections.observableList(Table.list(Patient.class));
            this.tableViewPatients.setItems((ObservableList<Patient>) patients);
        } catch (Exception e) {
            // e.printStackTrace();
            System.out.println("Nastala je pogreška: " + e.getMessage());

        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // Examinations TableView Items
        this.tableColumnIDE.setCellValueFactory(new PropertyValueFactory<>("ID"));
        this.tableColumnDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        this.tableColumnTime.setCellValueFactory(new PropertyValueFactory<>("hour"));
        this.tableColumnType.setCellValueFactory(new PropertyValueFactory<>("type"));
        this.tableColumnPatient.setCellValueFactory(new PropertyValueFactory<>("patient_fk"));
        this.tableColumnNote.setCellValueFactory(new PropertyValueFactory<>("note"));
        this.tableColumnStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        this.fillExaminations();


        //Patient TableView Items
        this.tableColumnID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        this.tableColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        this.tableColumnLastname.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        this.tableColumnUid.setCellValueFactory(new PropertyValueFactory<>("uid"));
        this.tableColumnPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        this.tableColumnMail.setCellValueFactory(new PropertyValueFactory<>("mail"));
        try {
            this.fillPatients();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    protected void intro (ActionEvent evt){
        Stage stage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
        swapScene(stage, "intro-view.fxml","EL PASO BRACES - bringing teeth together");

    }

}

