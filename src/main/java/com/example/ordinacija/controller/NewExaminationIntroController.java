package com.example.ordinacija.controller;

import com.example.ordinacija.Program;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;

public class NewExaminationIntroController {


    @FXML
    protected void newExamination (ActionEvent evt)  {
        Stage stage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
        Program.swapScene(stage,"newExamination-view.fxml","Novi pregled");

    }

    @FXML
    protected void newAppointment (ActionEvent evt)  {
        Stage stage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
        Program.swapScene(stage,"newAppointment-view.fxml","Zakazivanje termina");

    }



}
