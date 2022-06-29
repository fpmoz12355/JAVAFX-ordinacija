package com.example.ordinacija.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.ordinacija.Program.display;
import static com.example.ordinacija.Program.swapScene;

public class IntroController {

    @FXML
    protected void evidention (ActionEvent evt){
        Stage stage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
        swapScene(stage, "evidention-view.fxml","Evidention");
    }

    @FXML
    protected void newPatient (ActionEvent evt) throws IOException {
        display("newPatient-view.fxml","Dodaj podatke o novom pacijentu");
    }

    @FXML
    protected void newExaminationIntro (ActionEvent evt) throws IOException {
        display("newExaminationIntro-view.fxml","Dodaj podatke o novom pregledu");
    }

}

