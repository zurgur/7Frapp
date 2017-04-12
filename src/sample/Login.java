package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.awt.*;
import java.io.IOException;

/**
 * Created by Alexander on 4/11/2017.
 */
public class Login {
    //búa til FXML hluti svo við getum notað þá ur skjalinu
    @FXML
    private Button tilBaka;
    public void searchAction(ActionEvent actionEvent) throws IOException{
        Parent root;
        Stage stage;
        stage = (Stage) tilBaka.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("start.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
