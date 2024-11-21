package com.ijse.gdse.railway_management.railway_management_system.controller;
import com.ijse.gdse.railway_management.railway_management_system.Model.userModel;
import com.ijse.gdse.railway_management.railway_management_system.dto.tm.userTm;
import com.ijse.gdse.railway_management.railway_management_system.dto.userDto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class userController {


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


    @FXML
    private TextField userIdField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField contactNoField;

    @FXML
    private TextField gmailtext;


    @FXML
    private AnchorPane content;

    @FXML
    void register(ActionEvent event) throws Exception {
        handleRegisterUser();
    }


    private final userModel model = new userModel();

    public void handleRegisterUser() throws Exception {
        userDto UserDto = new userDto(userIdField.getText(), nameField.getText(), Integer.parseInt(contactNoField.getText()), gmailtext.getText());
        String resp = model.handleRegisterUser(UserDto);

        if (resp.equals("success")) {
            new Alert(Alert.AlertType.INFORMATION, resp).show();
        } else {
            new Alert(Alert.AlertType.ERROR, resp).show();
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

        @FXML
        void openSendMailModel (ActionEvent event){
            userTm selectedItem = tbluser.getSelectionModel().getSelectedItem();
            if (selectedItem == null) {
                new Alert(Alert.AlertType.WARNING, "Please select customer..!");
                return;
            }

            try {
                // Load the mail dialog from FXML file
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/SendMailView.fxml"));
                Parent load = loader.load();

                sendMailcontroller sendMailController = loader.getController();

                String email = selectedItem.getGmail();
                sendMailController.setGmail(gmailtext);

                Stage stage = new Stage();
                stage.setScene(new Scene(load));
                stage.setTitle("Send email");
                // stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/mail_icon.png")));

                // Set window as modal
                stage.initModality(Modality.APPLICATION_MODAL);

                Window underWindow = btnUpdate.getScene().getWindow();
                stage.initOwner(underWindow);

                stage.showAndWait();
            } catch (IOException e) {
                new Alert(Alert.AlertType.ERROR, "Fail to load ui..!");
                e.printStackTrace();
            }
        }
    }
}


