package desktop.interfaces;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class HomeController {

    @FXML
    private ImageView img;

    @FXML
    private Pane pane;

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
    private MenuButton partenairebtn;

    @FXML
    private MenuButton produitbtn;

    @FXML
    private Separator sep;

    @FXML
    private ImageView logo;

    @FXML
    private Button decbtn;

    @FXML
    public void initialize() throws IOException {
         FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose Image File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif")
        );
        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            Image image = new Image(selectedFile.toURI().toString());
            img.setImage(image);
        }

        // Load the Login.fxml file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
        Parent root = loader.load();

        // Create the scene and set it to the stage
        Scene scene = new Scene(root);
        Stage stage = (Stage) decbtn.getScene().getWindow();
        stage.setScene(scene);
        stage.show();

        // Load the Partenaire.fxml file
        FXMLLoader loader1 = new FXMLLoader(getClass().getResource("GestionPartenaire.fxml"));
        Parent root1 = loader1.load();
        GestionPartenaireController dt = loader1.getController();

        // Create the scene and set it to the stage
        Scene scene1 = new Scene(root1);
        Stage stage1 = (Stage) partenairebtn.getScene().getWindow();
        stage1.setScene(scene1);
        stage1.show();

        // Other methods for handling button clicks and loading FXML files
    }
}
