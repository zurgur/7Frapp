package is.hi.adal;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Sigfús on 18.4.2017.
 */
public class Finish {

    @FXML
    private JFXButton goToMenu;

    public void StartAction(ActionEvent actionEvent) throws IOException {
        Parent root;
        Stage stage;
        stage = (Stage) goToMenu.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("start.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
