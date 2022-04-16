package com.app.Controller;

import com.app.App;
import com.app.Constains.SQLConstant;
import com.app.Util.ConnectSQL;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ConnectDbController {
    private Scene scene;
    @FXML
    private TextField textFieldURL;
    @FXML
    private TextField textFieldUSER;
    @FXML
    private PasswordField textFieldPASS;

    @FXML
    private void initialize() {
        textFieldURL.setText(SQLConstant.getURL());
        textFieldUSER.setText(SQLConstant.getUSER());
        textFieldPASS.setText(SQLConstant.getPASS());
    }
    @FXML
    protected void onClickConnect() throws Exception {
        Stage stage = (Stage)textFieldURL.getScene().getWindow();
        if(ConnectSQL.getConnection(textFieldURL.getText(),textFieldUSER.getText(),textFieldPASS.getText()) == null){
            return;
        }else {
            replaceSceneContent("login-view.fxml", stage, 600.0, 400.0, "Login");
        }
    }

    private Parent replaceSceneContent(String fxml, Stage stage, Double v1 , Double v , String title) throws Exception {
        Parent page = (Parent) FXMLLoader.load(App.class.getResource(fxml), null, new JavaFXBuilderFactory());
        scene = stage.getScene();
        scene = new Scene(page, v1, v );
        stage.setTitle(title);
        stage.setScene(scene);
        stage.sizeToScene();
        return page;
    }


}
