package com.example.ordinacija.controller;

import com.example.ordinacija.model.Patient;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import static com.example.ordinacija.Program.alertDisplay;

public class NewPatientController  {

    @FXML
    TextField nameTxt;

    @FXML
    TextField lastNameTxt;

    @FXML
    TextField uidTxt;

    @FXML
    TextField phoneTxt;

    @FXML
    TextField mailTxt;

    
    @FXML
    protected void savePatient () throws Exception {
        Patient newPatient = new Patient ();
        newPatient.setName(this.nameTxt.getText());
        newPatient.setLastname(this.lastNameTxt.getText());
        newPatient.setUid(this.uidTxt.getText());
        newPatient.setPhone(this.phoneTxt.getText());
        newPatient.setMail(this.mailTxt.getText());

        newPatient.save();
        alertDisplay("newPatientAdded-view.fxml", "Spremljeni podaci o pacijentu!");

        this.nameTxt.setText("");
        this.lastNameTxt.setText("");
        this.uidTxt.setText("");
        this.phoneTxt.setText("");
        this.mailTxt.setText("");
    }

}
