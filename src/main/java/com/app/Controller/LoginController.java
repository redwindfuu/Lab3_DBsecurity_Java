package com.app.Controller;

import com.app.Util.ConnectSQL;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.util.Objects;

import com.app.Constains.SQLConstant;

public class LoginController {
    String user = "Admin";
    String pass = "1234";
    @FXML
    private Label loginLabel;
    @FXML
    private TextField textFieldUser;
    @FXML
    private PasswordField textFieldPass;
    @FXML
    protected void onClickLogin() {
        String textUser = textFieldUser.getText();
        String textPass = textFieldPass.getText();
        if(ConnectSQL.LoginStatus(textUser,textPass)){
            showAlertSuccess();
        }else{
            showAlertFail();
        }
    }
    private void showAlertSuccess() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Test Connection");
        alert.setHeaderText("Results:");
        alert.setContentText("Connect to the database successfully!");
        alert.showAndWait();
    }
    private void showAlertFail() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Test Connection");
        alert.setHeaderText("Results:");
        alert.setContentText("Connect to the database failer!");

        alert.showAndWait();
    }
}