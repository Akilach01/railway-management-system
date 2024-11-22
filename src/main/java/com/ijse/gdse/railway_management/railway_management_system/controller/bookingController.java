package com.ijse.gdse.railway_management.railway_management_system.controller;

import java.util.Date;

import com.ijse.gdse.railway_management.railway_management_system.util.crudUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import com.ijse.gdse.railway_management.railway_management_system.db.DBConnection;
import com.ijse.gdse.railway_management.railway_management_system.dto.bookingDto;
import com.ijse.gdse.railway_management.railway_management_system.dto.tm.bookingTm;
import com.ijse.gdse.railway_management.railway_management_system.Model.bookingModel;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;
import javafx.event.ActionEvent;

public class bookingController {

        @FXML
        private AnchorPane content;

        @FXML
        private TextField txtBookingID;

        @FXML
        private TextField txtUserID;

        @FXML
        private DatePicker dpBookingDate;

        @FXML
        private ComboBox<String> cmbFrom;

        @FXML
        private ComboBox<String> cmbTo;

        @FXML
        private TextField txtTrainID;

        @FXML
        private TextField txtStatus;

        @FXML
        private TextField txtTotalFare;

        @FXML
        private ComboBox<?> cmbPassenger;

        @FXML
        private Button btnBook;

        @FXML
        private Button btnReset;

        @FXML
        private Button btnNext;

        // Initialize ComboBoxes
        @FXML
        public void initialize() {
            cmbFrom.getItems().addAll("Panadura", "Colombo", "Galle", "Kandy","maradana");
            cmbTo.getItems().addAll("Jaffna", "Matara", "Badulla", "Trincomalee","kalutara");
        }

    @FXML
    void bookOnaction(ActionEvent event) {
            String bookingID = txtBookingID.getText();
            String userID = txtUserID.getText();
            String trainID = txtTrainID.getText();
            String from = cmbFrom.getValue();
            String to = cmbTo.getValue();
            String status = txtStatus.getText();
            String totalFare = txtTotalFare.getText();
            String passengers = cmbPassenger.getValue();

            if (bookingID.isEmpty() || userID.isEmpty() || trainID.isEmpty() || from == null || to == null || status.isEmpty() || totalFare.isEmpty()) {
                showAlert(Alert.AlertType.ERROR, "Input Error", "Please fill in all fields!");
                return;
            }

            try {
                // Insert booking details into the database
                String sql = "INSERT INTO booking (b_id, b_date, user_id, tr_id, total_fare, status, from, to, no_of_passengers) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                boolean isBooked = crudUtil.execute(sql, bookingID, dpBookingDate.getValue(), userID, trainID, Double.parseDouble(totalFare), status, from, to, passengers);

                if (isBooked) {
                    showAlert(Alert.AlertType.INFORMATION, "Booking Successful", "Ticket booked successfully!");
                    resetForm();
                } else {
                    showAlert(Alert.AlertType.ERROR, "Booking Failed", "Failed to book the ticket. Try again.");
                }
            } catch (Exception e) {
                e.printStackTrace();
                showAlert(Alert.AlertType.ERROR, "Database Error", "An error occurred while booking the ticket.");
            }
        }

    @FXML
    void navigateToPayment(ActionEvent event) {

        try {
                Parent paymentView = FXMLLoader.load(getClass().getResource("/view/paymentView.fxml"));
                Stage stage = (Stage) content.getScene().getWindow();
                stage.setScene(new Scene(paymentView));
                stage.setTitle("Payment");
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
                showAlert(Alert.AlertType.ERROR, "Navigation Error", "Failed to navigate to the payment screen.");
            }
        }

    @FXML
    void resetOnAction(ActionEvent event) {

        resetForm();
        }

        private void resetForm() {
            txtBookingID.clear();
            txtUserID.clear();
            txtTrainID.clear();
            txtStatus.clear();
            txtTotalFare.clear();
            cmbFrom.getSelectionModel().clearSelection();
            cmbTo.getSelectionModel().clearSelection();
            cmbPassenger.getSelectionModel().clearSelection();;
            dpBookingDate.setValue(null);
        }

        private void showAlert(Alert.AlertType alertType, String title, String message) {
            Alert alert = new Alert(alertType);
            alert.setTitle(title);
            alert.setContentText(message);
            alert.showAndWait();
        }
    }






    public void saveOnAction(ActionEvent actionEvent) {
    }

    public void updateONAction(ActionEvent actionEvent) {
    }

    public void deleteOnAction(ActionEvent actionEvent) {
        
    }

    public void bookOnaction(ActionEvent actionEvent) {
    }

    public void resetOnAction(ActionEvent actionEvent) {
    }

    public void navigateToPayment(ActionEvent actionEvent) {

    }

    public void saveBookingOnAction(ActionEvent actionEvent) {

    }


    }

}


