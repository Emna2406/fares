/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desktop.interfaces;

import desktop.entities.Produit;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author msi
 */

public class GestionProduitController implements Initializable  {
   @FXML
   private TextField nomField;
 
   @FXML
   private TextField stockField;
 
   @FXML
   private TableView<Produit> produitTable;
 
   private ObservableList<Produit> produitList;
 
   public void initialize() {
       produitList = FXCollections.observableArrayList();
       produitTable.setItems(produitList);
   }
 
   @FXML
   private void addProduit() {
       Produit produit = new Produit(nomField.getText(), Integer.parseInt(stockField.getText()));
       produitList.add(produit);
   }
 
   @FXML
   private void updateProduit() {
       Produit selectedProduit = produitTable.getSelectionModel().getSelectedItem();
       if (selectedProduit != null) {
           selectedProduit.setNom(nomField.getText());
           selectedProduit.setStock(Integer.parseInt(stockField.getText()));
           produitTable.refresh();
       }
   }
 
   @FXML
   private void deleteProduit() {
       Produit selectedProduit = produitTable.getSelectionModel().getSelectedItem();
       if (selectedProduit != null) {
           produitList.remove(selectedProduit);
       }
   }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
