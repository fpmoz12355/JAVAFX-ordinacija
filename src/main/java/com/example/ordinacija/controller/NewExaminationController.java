package com.example.ordinacija.controller;

import com.example.ordinacija.Program;
import com.example.ordinacija.model.Examination;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static com.example.ordinacija.Program.alertDisplay;

public class NewExaminationController {

    @FXML
    TextField idTxt;

    @FXML
    ComboBox typeTxt;

    @FXML
    TextArea noteTxt;


    @FXML
    protected void endExamination () throws Exception {

        Examination newExamination = new Examination();
        LocalDate today = LocalDate.now();
        newExamination.setDate(String.valueOf(today));
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime now = LocalTime.now();
        newExamination.setHour(dt.format(now));
        newExamination.setStatus("obavljen");
        newExamination.setType((String) this.typeTxt.getValue());
        newExamination.setPatientFk(Integer.parseInt(this.idTxt.getText()));
        newExamination.setNote(this.noteTxt.getText());

        newExamination.save();
        alertDisplay("examinationAdded-view.fxml", "Uspješno dodani podatci o pregledu!");

        this.idTxt.setText("");
        this.typeTxt.setValue("");
        this.noteTxt.setText("");
    }



    @FXML
    protected void endAndStartNewExamination (ActionEvent evt) throws Exception {

        Examination newExamination = new Examination();
        LocalDate today = LocalDate.now();
        newExamination.setDate(String.valueOf(today));
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime now = LocalTime.now();
        newExamination.setHour(dt.format(now));
        newExamination.setStatus("obavljen");
        newExamination.setType((String) this.typeTxt.getValue());
        newExamination.setPatientFk(Integer.parseInt(this.idTxt.getText()));
        newExamination.setNote(this.noteTxt.getText());

        newExamination.save();
        this.idTxt.setText("");
        this.typeTxt.setValue("");
        this.noteTxt.setText("");


        alertDisplay("examinationAdded-view.fxml", "Uspješno dodani podatci o pregledu!");

        Stage stage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
        Program.swapScene(stage, "newAppointment-view.fxml","Dodaj podatke o novom terminu");

    }


    @FXML
    protected void back (ActionEvent evt){
        Stage stage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
        Program.swapScene(stage, "newExaminationIntro-view.fxml","Dodaj podatke o novom pregledu");

    }
}
