package com.ijse.gdse.railway_management.railway_management_system.controller;
import com.ijse.gdse.railway_management.railway_management_system.Model.userModel;
import com.ijse.gdse.railway_management.railway_management_system.dto.tm.userTm;
import com.ijse.gdse.railway_management.railway_management_system.dto.userDto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class userController  {


   @FXML
    private Button btnDelete;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableColumn<userTm, Integer> colContactNo;

    @FXML
    private TableColumn<userTm, String> colGmail;

    @FXML
    private TableColumn<userTm, String> colUserId;

    @FXML
    private TableColumn<userTm, String> colUserName;

    @FXML
    void deleteUserOnAction(ActionEvent event) {
    }

    @FXML
    void saveUserOnAction(ActionEvent event) {
    }

    @FXML
    void updateUserOnAction(ActionEvent event) {
    }


    @FXML private TextField userIdField;

    @FXML private TextField nameField;

    @FXML private TextField contactNoField;

    @FXML private TextField gmailtext;

    @FXML
    private AnchorPane content;

        @FXML
        void register(ActionEvent event) throws Exception{
             handleRegisterUser();
        }


        private final userModel model = new userModel();

        public void handleRegisterUser() throws Exception{
            userDto UserDto = new userDto(userIdField.getText(),nameField.getText(),Integer.parseInt(contactNoField.getText()),gmailtext.getText());
            String resp = model.handleRegisterUser(UserDto);

            if (resp.equals("success")){
                    new Alert(Alert.AlertType.INFORMATION,resp).show();
            }else {
                    new Alert(Alert.AlertType.ERROR,resp).show();
            }
//userDto dto = new userDto(userIdField.getText(),nameField.getText(),contactNoField.getText());
        }

    public void gotoLogin(ActionEvent actionEvent) {
            navigateTo("/view/loginView.fxml");
    }

    public void navigateTo(String fxmlPath) {
        try {
            content.getChildren().clear();
            AnchorPane load = FXMLLoader.load(getClass().getResource(fxmlPath));

//  -------- Loaded anchor edges are bound to the content anchor --------
//      (1) Bind the loaded FXML to all edges of the content anchorPane
            load.prefWidthProperty().bind(content.widthProperty());
            load.prefHeightProperty().bind(content.heightProperty());

//      (2) Bind the loaded FXML to all edges of the AnchorPane
//            AnchorPane.setTopAnchor(load, 0.0);
//            AnchorPane.setRightAnchor(load, 0.0);
//            AnchorPane.setBottomAnchor(load, 0.0);
//            AnchorPane.setLeftAnchor(load, 0.0);

            content.getChildren().add(load);
        } catch (IOException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Fail to load page!").show();
        }
    }
}


