package com.ijse.gdse.railway_management.railway_management_system.controller;

import java.util.Date;
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
   /* private String b_id;
    private Date b_date;
    private String user_id;
    private Double total_fare;
    private String status;
    private String tr_id;
    private String from;
    private String to; */

    public class BookingView {

        @FXML
        void bookOnaction(ActionEvent event) {

        }

        @FXML
        void navigateToPayment(ActionEvent event) {

        }

        @FXML
        void resetOnAction(ActionEvent event) {




        }

    }

}


