package com.example.ordinacija.controller;

import com.example.ordinacija.model.Examination;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.LocalDate;

import static com.example.ordinacija.Program.alertDisplay;
import static com.example.ordinacija.Program.swapScene;


public class NewAppointmentController {

    @FXML
    TextField idTxt;

    @FXML
    DatePicker dateTxt;

    @FXML
    TextField hourTxt;

    @FXML
    ComboBox typeTxt;


    @FXML
    protected void saveExaminationApp () throws Exception {
        Examination newExamination = new Examination();
        newExamination.setDate(String.valueOf(this.dateTxt.getValue()));
        newExamination.setHour(this.hourTxt.getText());
        newExamination.setType((String) this.typeTxt.getValue());
        newExamination.setPatientFk(Integer.parseInt(this.idTxt.getText()));
        newExamination.setStatus("zakazan");
        newExamination.setNote("");

        newExamination.save();

        alertDisplay("newAppointmentAdded-view.fxml", "Zakazano!");

        this.dateTxt.setValue(LocalDate.now());
        this.hourTxt.setText("");
        this.typeTxt.setValue("");
        this.idTxt.setText("");
    }

    @FXML
    protected void back (ActionEvent evt){
        Stage stage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
        swapScene(stage, "newExaminationIntro-view.fxml","Dodaj podatke o novom pregledu");
    }
}
