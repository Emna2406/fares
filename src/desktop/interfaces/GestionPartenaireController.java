/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desktop.interfaces;

import desktop.entities.Partenaire;
import desktop.services.PartenaireCRUD;
import java.net.URL;
import java.util.List;
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
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author msi
 */
public class GestionPartenaireController implements Initializable {

    @FXML
    private TextField emailField;
    @FXML
    private TextField nomField;
    @FXML
    private Button btnadd;
    @FXML
    private Button btnupdate;
    @FXML
    private Button btndelete;
    @FXML
    private TableView<Partenaire> partenaireTable;
    @FXML
    private TableColumn<Partenaire, Integer> idcol;
    @FXML
    private TableColumn<Partenaire, String> nomcol;
    @FXML
    private TableColumn<Partenaire, String> emailcol;
    
    private List<Partenaire> list_categorie;
    PartenaireCRUD su=new PartenaireCRUD();
      ObservableList<Partenaire> data=FXCollections.observableArrayList();


    /**
     * Initializes the controller class.
     */
     @Override
    public void initialize(URL url, ResourceBundle rb) { 
    }
       public void refreshList(){
        data.clear();
        data=FXCollections.observableArrayList(su.display());
       
        nomcol.setCellValueFactory(new PropertyValueFactory<>("nom"));
        emailcol.setCellValueFactory(new PropertyValueFactory<>("email"));
       
        partenaireTable.setItems(data);
    }

    @FXML
    private void addPartenairee(ActionEvent event) {
        PartenaireCRUD pc = new PartenaireCRUD();
        String nom = nomField.getText();
       String email = emailField.getText();
       
        
         if (nom.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("'Nom' must be inputed");
            alert.setTitle("Problem");
            alert.setHeaderText(null);
            alert.showAndWait();
        }  else 
          if (email.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("'email' must be inputed");
            alert.setTitle("Problem");
            alert.setHeaderText(null);
            alert.showAndWait();
        }  else
          {
                Partenaire p = new Partenaire( nom,email);
                pc.AddEntity(p);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setContentText("Added .");
                alert.setHeaderText(null);
                alert.show();
                //redirectToListProduit();
            }
        }

    @FXML
    private void updatePartenaire(ActionEvent event) {
    }

    @FXML
    private void deletePartenaire(ActionEvent event) {
    }
    }

   

    
  

