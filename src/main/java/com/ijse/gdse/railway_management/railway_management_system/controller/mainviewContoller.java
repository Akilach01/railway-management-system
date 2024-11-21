package com.ijse.gdse.railway_management.railway_management_system.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class mainviewContoller implements Initializable{

@FXML
private AnchorPane content;

@Override
public void initialize(URL url, ResourceBundle resourceBundle) {
   navigateTo("/view/bookingView.fxml");
}

    @FXML
    void navigateToBooking(ActionEvent event) { navigateTo("/view/bookingView.fxml");
    }

    @FXML
    void navigateToPayment(ActionEvent event) {
        navigateTo("/view/paymentView.fxml");
    }

    @FXML
    void navigateToTrainManagement(ActionEvent event) {
        navigateTo("/view/trainManagementView.fxml");
    }

    @FXML
    void navigateToScheduleManagement(ActionEvent event) { navigateTo("/view/scheduleManageView.fxml");}

    @FXML
    void navigateToPromotion(ActionEvent event) {
        navigateTo("/view/promotionView.fxml");
    }

    @FXML
    void navigateToUserManagement(ActionEvent event) { navigateTo("/view/userManagementView.fxml");}

    @FXML
    void navigateToBookingManagement(ActionEvent event) { navigateTo("/view/bookingManagement.fxml");}



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

    public void navigateToSendMailView(ActionEvent actionEvent) {
        navigateTo("/view/SendMailView.fxml");
    }

    public void logoutOnAction(ActionEvent actionEvent) {

    }
}



