package is.hi.adal;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Brynja Palina on 4/11/2017.
 */
public class NewAccountSuccess {
    //búa til FXML hluti svo við getum notað þá ur skjalinu

    @FXML
    private JFXTextField user;

    @FXML
    private JFXPasswordField password;

    @FXML
    private JFXButton goToMenu;

    @FXML
    private JFXButton goHome;


    public void StartAction(ActionEvent actionEvent) throws IOException {
        Parent root;
        Stage stage;
        stage = (Stage) goToMenu.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("start.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void GoHomeAction(ActionEvent actionEvent) throws IOException {
        Parent root;
        Stage stage;
        stage = (Stage) goHome.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}