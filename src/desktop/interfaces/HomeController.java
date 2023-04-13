package desktop.interfaces;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.Separator;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class HomeController {

    @FXML
    private MenuButton servicebtn;

    @FXML
    private MenuButton consultationbtn;

    @FXML
    private MenuButton rdvbtn;

    @FXML
    private MenuButton candidatbtn;

    @FXML
    private MenuButton offrebtn;

    @FXML
    private Button partenairebtn;


    @FXML
    private Button decbtn;
    @FXML
    private ImageView img;
    @FXML
    private Pane pane;
    @FXML
    private MenuButton partenairebtn1;
    @FXML
    private Separator sep;
    @FXML
    private ImageView logo;

    @FXML
    private void redirectToAddPartenaire(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("GestionPartenaire.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage()+ ex.getStackTrace());
        }
    }




}

