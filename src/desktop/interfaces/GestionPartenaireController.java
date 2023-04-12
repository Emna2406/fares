/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desktop.interfaces;

import desktop.entities.Partenaire;
import desktop.tools.MyConnection;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author msi
 */
public class GestionPartenaireController implements Initializable {
    @FXML
    private TableView<Partenaire> partenaireTable;

    @FXML
    private TextField nomField;

    @FXML
    private TextField emailField;

    private ObservableList<Partenaire> partenaireList;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialize the columns of the TableView
        TableColumn<Partenaire, Integer> idCol = new TableColumn<>("ID");
        TableColumn<Partenaire, String> nomCol = new TableColumn<>("Nom");
        TableColumn<Partenaire, String> emailCol = new TableColumn<>("Email");

        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nomCol.setCellValueFactory(new PropertyValueFactory<>("nom"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));

        partenaireTable.getColumns().addAll(idCol, nomCol, emailCol);

        // Initialize the ObservableList of Partenaire objects
        partenaireList = FXCollections.observableArrayList();

        // Set the items of the TableView to the ObservableList of Partenaire objects
        partenaireTable.setItems(partenaireList);

        // Add a listener to the TableView to display the selected Partenaire object's attributes in the TextField objects
        partenaireTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                nomField.setText(newSelection.getNom());
                emailField.setText(newSelection.getEmail());
            } else {
                nomField.setText("");
                emailField.setText("");
            }
        });

        // Set up input validation for the email TextField
        TextFormatter<String> emailFormatter = new TextFormatter<>(change -> {
            if (change.getText().contains("@")) {
                return change;
            }
            return null;
        });
        emailField.setTextFormatter(emailFormatter);

        // Add listeners to the TextField objects to mark the form as "modified"
        nomField.textProperty().addListener((observable, oldValue, newValue) -> {
            partenaireTable.getSelectionModel().clearSelection();
        });
        emailField.textProperty().addListener((observable, oldValue, newValue) -> {
            partenaireTable.getSelectionModel().clearSelection();
        });
    }
}
